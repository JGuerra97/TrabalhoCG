package comp_graf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.List;
import static java.lang.Math.cos;
import static java.time.temporal.TemporalQueries.precision;
import java.util.ArrayList;
import java.util.Arrays;

public class Face {

    protected boolean isVisible;
    protected final int nVertices;
    protected Vertice[] vertices;
    protected double[][] matrizTransformacao = {{1, 0, 0, 0},
    {0, 1, 0, 0},
    {0, 0, 1, 0},
    {0, 0, 0, 1}};

    public Face(int n, int[] x, int[] y, int[] z) {

        this.nVertices = n;
        vertices = new Vertice[this.nVertices];

        for (int i = 0; i < this.nVertices; i++) {
            vertices[i] = new Vertice(x[i], y[i], z[i]);
        }
    }

    public void mudaMatrizTransformacao(double[][] a) {

        double[][] resultado = {{0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0},
        {0, 0, 0, 0}};

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    resultado[i][j] += matrizTransformacao[i][k] * a[k][j];
                }
            }
        }
        matrizTransformacao = resultado;
    }

    public void transformar() {

        for (Vertice v : vertices) {
            int tempx = v.x;
            int tempy = v.y;
            v.x = (int) (v.x * matrizTransformacao[0][0]) + (int) (v.y * matrizTransformacao[0][1]) + (int) (v.z * matrizTransformacao[0][2]) + (int) (matrizTransformacao[0][3]);
            v.y = (int) (tempx * matrizTransformacao[1][0]) + (int) (v.y * matrizTransformacao[1][1]) + (int) (v.z * matrizTransformacao[1][2]) + (int) (matrizTransformacao[1][3]);
            v.z = (int) (tempx * matrizTransformacao[2][0]) + (int) (tempy * matrizTransformacao[2][1]) + (int) (v.z * matrizTransformacao[2][2]) + (int) (matrizTransformacao[2][3]);
        }

        matrizTransformacao = new double[][]{{1, 0, 0, 0},
        {0, 1, 0, 0},
        {0, 0, 1, 0},
        {0, 0, 0, 1}};
    }

    public void translacao(int x, int y, int z) {
        mudaMatrizTransformacao(new double[][]{{1, 0, 0, x},
        {0, 1, 0, y},
        {0, 0, 1, z},
        {0, 0, 0, 1}});
    }

    public void escalaX(double sx, int referenciax) {

        translacao(referenciax, 0, 0);

        mudaMatrizTransformacao(new double[][]{{sx, 0, 0, 0},
        {0, 1, 0, 0},
        {0, 0, 1, 0},
        {0, 0, 0, 1}});

        translacao(-referenciax, 0, 0);
    }

    public void escalaY(double sy, int referenciay) {

        translacao(0, referenciay, 0);

        mudaMatrizTransformacao(new double[][]{{1, 0, 0, 0},
        {0, sy, 0, 0},
        {0, 0, 1, 0},
        {0, 0, 0, 1}});

        translacao(0, -referenciay, 0);
    }

    public void escalaZ(double sz, int referenciaz) {

        translacao(0, 0, referenciaz);

        mudaMatrizTransformacao(new double[][]{{1, 0, 0, 0},
        {0, 1, 0, 0},
        {0, 0, sz, 0},
        {0, 0, 0, 1}});

        translacao(0, 0, -referenciaz);
    }

    public void escalaGlobal(double escala, int referenciax, int referenciay, int referenciaz) {

        translacao(referenciax, referenciay, referenciaz);

        mudaMatrizTransformacao(new double[][]{{escala, 0, 0, 0},
        {0, escala, 0, 0},
        {0, 0, escala, 0},
        {0, 0, 0, 1}});

        translacao(-referenciax, -referenciay, -referenciaz);
    }

    public void rotacaoPlanoXY(double angulo, int referenciax, int referenciay, int referenciaz) {

        double seno = Math.sin(Math.toRadians(angulo));
        double cosseno = Math.cos(Math.toRadians(angulo));

        translacao(referenciax, referenciay, referenciaz);

        mudaMatrizTransformacao(new double[][]{{cosseno, -seno, 0, 0},
        {seno, cosseno, 0, 0},
        {0, 0, 1, 0},
        {0, 0, 0, 1}});

        translacao(-referenciax, -referenciay, -referenciaz);
    }

    public void rotacaoPlanoYZ(double angulo, int referenciax, int referenciay, int referenciaz) {

        double seno = Math.sin(Math.toRadians(angulo));
        double cosseno = Math.cos(Math.toRadians(angulo));

        translacao(referenciax, referenciay, referenciaz);

        mudaMatrizTransformacao(new double[][]{{1, 0, 0, 0},
        {0, cosseno, -seno, 0},
        {0, seno, cosseno, 0},
        {0, 0, 0, 1}});

        translacao(-referenciax, -referenciay, -referenciaz);
    }

    public void rotacaoPlanoXZ(double angulo, int referenciax, int referenciay, int referenciaz) {

        double seno = Math.sin(Math.toRadians(angulo));
        double cosseno = Math.cos(Math.toRadians(angulo));

        translacao(referenciax, referenciay, referenciaz);

        mudaMatrizTransformacao(new double[][]{{cosseno, 0, seno, 0},
        {0, 1, 0, 0},
        {-seno, 0, cosseno, 0},
        {0, 0, 0, 1}});

        translacao(-referenciax, -referenciay, -referenciaz);
    }

    private double prodInterno(double v1x, double v1y, double v1z, double v2x, double v2y, double v2z) {

        return v1x * v2x + v1y * v2y + v1z * v2z;
    }

    private double[] prodVetorial(double v1x, double v1y, double v1z, double v2x, double v2y, double v2z) {

        return new double[]{v1y * v2z - v1z * v2y, v1z * v2x - v1x * v2z, v1x * v2y - v1y * v2z};
    }

    public int[] rotacaoPontoQuaternio(int referenciax, int referenciay, int referenciaz, double nx, double ny, double nz, double angulo) {

        Quaternio q = new Quaternio(nx, ny, nz, angulo);
        Quaternio q_conjugado;
        q_conjugado = q.calculaConjugado(q);
        double rq0, rq1, rq2, rq3;
        // Fazer a multiplicação  q p q*
        double[] multiplicacao_qp = multqp(q.getQ0(), q.getQ1(), q.getQ2(), q.getQ3(), 0, referenciax, referenciay, referenciaz);
        double[] multiplicacao_qpq_conj = multqp(multiplicacao_qp[0], multiplicacao_qp[1], multiplicacao_qp[2], multiplicacao_qp[3], q_conjugado.getQ0(), q_conjugado.getQ1(), q_conjugado.getQ2(), q_conjugado.getQ3());
        /*
        double[] prodVet = calculaProdutoVetorial(q.getQ1(), q.getQ2(), q.getQ3(), referenciax, referenciay, referenciaz);
        rq0 = 0;
        //System.out.println("XXXXXXXXX "+referenciax+" "+ q.getQ0());
        rq1 = q.getQ0() * q.getQ0() * referenciax - (calculaProdutoInterno(q.getQ1(), q.getQ2(), q.getQ3(), q.getQ1(), q.getQ2(), q.getQ3())) * referenciax
                + 2 * (calculaProdutoInterno(q.getQ1(), q.getQ2(), q.getQ3(), referenciax, referenciay, referenciaz)) * q.getQ1()
                + 2 * q.getQ0() * prodVet[0];

        rq2 = q.getQ0() * q.getQ0() * referenciay - (calculaProdutoInterno(q.getQ1(), q.getQ2(), q.getQ3(), q.getQ1(), q.getQ2(), q.getQ3())) * referenciay
                + 2 * (calculaProdutoInterno(q.getQ1(), q.getQ2(), q.getQ3(), referenciax, referenciay, referenciaz)) * q.getQ2()
                + 2 * q.getQ0() * prodVet[1];

        rq3 = q.getQ0() * q.getQ0() * referenciaz - (calculaProdutoInterno(q.getQ1(), q.getQ2(), q.getQ3(), q.getQ1(), q.getQ2(), q.getQ3())) * referenciaz
                + 2 * (calculaProdutoInterno(q.getQ1(), q.getQ2(), q.getQ3(), referenciax, referenciay, referenciaz)) * q.getQ3()
                + 2 * q.getQ0() * prodVet[2];
         */

        return new int[]{(int) multiplicacao_qpq_conj[1], (int) multiplicacao_qpq_conj[2], (int) multiplicacao_qpq_conj[3]};
    }

    public double[] multqp(double p0, double p1, double p2, double p3, double q0, double q1, double q2, double q3) {
        double[] resp = new double[4];
        double[] pxq = prodVetorial(p1, p2, p1, q1, q2, q3);
        resp[0] = (p0 * q0) - prodInterno(p1, p2, p3, q1, q2, q3);
        resp[1] = (p0 * q1) + (q0 * p1) + pxq[0];
        resp[2] = (p0 * q2) + (q0 * p2) + pxq[1];
        resp[3] = (p0 * q3) + (q0 * p3) + pxq[2];

        return resp;
    }

    public void rotacaoQuaternio(double angulo, double nx, double ny, double nz) {
        for (int i = 0; i < nVertices; i++) {
            int[] temp = rotacaoPontoQuaternio(vertices[i].x, vertices[i].y, vertices[i].z, nx, ny, nz, angulo);
            vertices[i].x = temp[0];
            vertices[i].y = temp[1];
            vertices[i].z = temp[2];
        }
    }

    public void reflexaoX(int referenciax) {

        translacao(referenciax, 0, 0);

        mudaMatrizTransformacao(new double[][]{{-1, 0, 0, 0},
        {0, 1, 0, 0},
        {0, 0, 1, 0},
        {0, 0, 0, 1}});

        translacao(-referenciax, 0, 0);
    }

    public void reflexaoY(int referenciay) {

        translacao(0, referenciay, 0);

        mudaMatrizTransformacao(new double[][]{{1, 0, 0, 0},
        {0, -1, 0, 0},
        {0, 0, 1, 0},
        {0, 0, 0, 1}});

        translacao(0, -referenciay, 0);
    }

    public void reflexaoZ(int referenciaz) {

        translacao(0, 0, referenciaz);

        mudaMatrizTransformacao(new double[][]{{1, 0, 0, 0},
        {0, 1, 0, 0},
        {0, 0, -1, 0},
        {0, 0, 0, 1}});

        translacao(0, 0, -referenciaz);
    }

    public void desenhar(Graphics g) {
        transformar();
        g.setColor(Color.black);
        for (int i = 0; i < this.nVertices - 1; i++) {
            g.drawLine(vertices[i].x, vertices[i].y, vertices[i + 1].x, vertices[i + 1].y);
        }
        g.drawLine(vertices[this.nVertices - 1].x, vertices[this.nVertices - 1].y, vertices[0].x, vertices[0].y);
    }

    public static Color getShade(Color color, double shade) {
        double redLinear = Math.pow(color.getRed(), 2.4) * shade;
        double greenLinear = Math.pow(color.getGreen(), 2.4) * shade;
        double blueLinear = Math.pow(color.getBlue(), 2.4) * shade;

        int red = (int) Math.pow(redLinear, 1 / 2.4);
        int green = (int) Math.pow(greenLinear, 1 / 2.4);
        int blue = (int) Math.pow(blueLinear, 1 / 2.4);

        return new Color(red, green, blue);
    }

    public void fill(Graphics g, Color cor) {

        int[] v1 = new int[3];
        int[] v2 = new int[3];
        double[] normal = new double[3];

        v1[0] = this.vertices[1].x - this.vertices[0].x;
        v1[1] = this.vertices[1].y - this.vertices[0].y;
        v1[2] = this.vertices[1].z - this.vertices[0].z;

        v2[0] = this.vertices[2].x - this.vertices[1].x;
        v2[1] = this.vertices[2].y - this.vertices[1].y;
        v2[2] = this.vertices[2].z - this.vertices[1].z;

        normal[0] = v1[1] * v2[2] - v1[2] * v2[1];
        normal[1] = v1[2] * v2[0] - v1[0] * v2[2];
        normal[2] = v1[0] * v2[1] - v1[1] * v2[0];

        double norma = Math.sqrt(Math.pow(normal[0], 2) + Math.pow(normal[1], 2) + Math.pow(normal[2], 2));
        normal[0] = (normal[0] / norma);
        normal[1] = (normal[1] / norma);
        normal[2] = (normal[2] / norma);
        transformar();
        g.setColor(cor);

        int[] x = new int[nVertices];
        int[] y = new int[nVertices];

        for (int i = 0; i < this.nVertices; i++) {
            // g.drawLine(vertices[i].x, vertices[i].y, vertices[i+1].x, vertices[i+1].y);
            x[i] = vertices[i].x;
            y[i] = vertices[i].y;

        }
        //g.drawLine(vertices[this.nVertices-1].x, vertices[this.nVertices-1].y, vertices[0].x, vertices[0].y);
        g.fillPolygon(x, y, nVertices);
    }

//    public void FillPolygon (int np, int[] x, int[] y){
//
//        int ymin = Arrays.stream(y).min().getAsInt();
//        int ymax = Arrays.stream(y).max().getAsInt();
//        /* calcula y max e min dos vértices*/
//        . . .
//        for(int ys=ymin; ys<=ymax; ys--) /* para cada linha de scan */
//        {
//        int num_inters = 0;
//        for(int i=0; i<np; i++) /* para cada aresta */
//        {
//        int yi = y[i];
//        int yf = y[(i+1)%np];
//        if (yi!=yf && ys >= Math.min(yi,yf) && ys < Math.max(yi,yf) )
//        {
//        vxs[num_inters] = x[i] +
//        (ys-yi)*(x[(i+1)%np]-x[i])/(yf-yi);
//        num_inters++;
//        }
//        }
//        ordena(vxs,0,num_inters-1); /* ordena as interseções */
//        for (i=0;i<num_inters;i+=2)
//        if (vxs[i]+1 <= vxs[i+1]) ScanLine(vxs[i],vxs[i+1],ys);
//    }
}
