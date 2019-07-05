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

    private double calculaProdutoInterno(double v1x, double v1y, double v1z, double v2x, double v2y, double v2z) {

        return v1x * v2x + v1y * v2y + v1z * v2z;
    }

    private double[] calculaProdutoVetorial(double v1x, double v1y, double v1z, double v2x, double v2y, double v2z) {

        return new double[]{v1y * v2z - v1z * v2y, v1z * v2x - v1x * v2z, v1x * v2y - v1y * v2z};
    }

    public int[] rotacaoPontoQuaternio(int referenciax, int referenciay, int referenciaz, int nx, int ny, int nz, double angulo) {

        Quaternio q = new Quaternio(nx, ny, nz, angulo);
        Quaternio q_conjugado;
        q_conjugado = q.calculaConjugado(q);
        double rq0, rq1, rq2, rq3;
        double[] prodVet = calculaProdutoVetorial(q.getQ1(), q.getQ2(), q.getQ3(), referenciax, referenciay, referenciaz);
        // Fazer a multiplicação  q p q*

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

        return new int[]{(int) rq1, (int) rq2, (int) rq3};
    }

    public void rotacaoQuaternio(double angulo, int nx, int ny, int nz) {
        for (int i = 0; i < nVertices; i++) {
            int[] temp = rotacaoPontoQuaternio(vertices[i].x, vertices[i].y, vertices[i].z, nx, ny, nz, angulo);
            System.out.println("PONTO ANTES: " + vertices[i].x + ", " + vertices[i].y + ", " + vertices[i].z);
            vertices[i].x = temp[0];
            vertices[i].y = temp[1];
            vertices[i].z = temp[2];
            System.out.println("PONTO DEPOIS: " + vertices[i].x + ", " + vertices[i].y + ", " + vertices[i].z);
        }
    }

    public void reflexaoX(int referenciax) {

        translacao(referenciax, 0, 0);

        System.out.println("Reflexão X:");
        mudaMatrizTransformacao(new double[][]{{-1, 0, 0, 0},
        {0, 1, 0, 0},
        {0, 0, 1, 0},
        {0, 0, 0, 1}});

        translacao(-referenciax, 0, 0);
    }

    public void reflexaoY(int referenciay) {

        translacao(0, referenciay, 0);

        System.out.println("Reflexão Y:");
        mudaMatrizTransformacao(new double[][]{{1, 0, 0, 0},
        {0, -1, 0, 0},
        {0, 0, 1, 0},
        {0, 0, 0, 1}});

        translacao(0, -referenciay, 0);
    }

    public void reflexaoZ(int referenciaz) {

        translacao(0, 0, referenciaz);

        System.out.println("Reflexão Z:");
        mudaMatrizTransformacao(new double[][]{{1, 0, 0, 0},
        {0, 1, 0, 0},
        {0, 0, -1, 0},
        {0, 0, 0, 1}});

        translacao(0, 0, -referenciaz);
    }

    /**
     *
     * Generates several 3D points in a continuous Bezier curve based upon * the
     * parameter list of points.
     *
     *
     * @param controls
     *
     * @param detail
     *
     * @return
     *
     */
    public static Tuple3d[] getCurvePoints(Tuple3d[] controls, double detail) {

        if (detail > 1 || detail < 0) {

            throw new IllegalStateException("");

        }

        ArrayList<Tuple3d> renderingPoints = new ArrayList<>();

        ArrayList<Tuple3d> controlPoints = new ArrayList<>();

        //generate the end and control points
        for (int i = 1; i < controls.length - 1; i += 2) {

            controlPoints.add(center(controls[i - 1], controls[i]));

            controlPoints.add(controls[i]);

            controlPoints.add(controls[i + 1]);

            if (i + 2 < controls.length - 1) {

                controlPoints.add(center(controls[i + 1], controls[i + 2]));

            }

        }

        //Generate the detailed points.
        Tuple3d a0, a1, a2, a3;

        for (int i = 0; i < controlPoints.size() - 2; i += 4) {

            a0 = controlPoints.get(i);

            a1 = controlPoints.get(i + 1);

            a2 = controlPoints.get(i + 2);

            if (i + 3 > controlPoints.size() - 1) {

                //quad
                for (double j = 0; j < 1; j += detail) {

                    renderingPoints.add(quadBezier(a0, a1, a2, j));

                }

            } else {

                //cubic
                a3 = controlPoints.get(i + 3);

                for (double j = 0; j < 1; j += detail) {

                    renderingPoints.add(cubicBezier(a0, a1, a2, a3, j));

                }

            }

        }

        Tuple3d[] points = new Tuple3d[renderingPoints.size()];

        renderingPoints.toArray(points);

        return points;

    }

    /**
     *
     * A cubic bezier method to calculate the point at t along the Bezier Curve
     * give
     *
     * the parameter points.
     *
     * @param p1
     *
     * @param p2
     *
     * @param p3
     *
     * @param p4
     *
     * @param t A value between 0 and 1, inclusive.
     *
     * @return
     *
     */
    public static Tuple3d cubicBezier(Tuple3d p1, Tuple3d p2, Tuple3d p3, Tuple3d p4, double t) {

        return new Tuple3d(
                cubicBezierPoint(p1.x, p2.x, p3.x, p4.x, t),
                cubicBezierPoint(p1.y, p2.y, p3.y, p4.y, t),
                cubicBezierPoint(p1.z, p2.z, p3.z, p4.z, t));

    }

    /**
     *
     * A quadratic Bezier method to calculate the point at t along the Bezier
     * Curve give
     *
     * the parameter points.
     *
     * @param p1
     *
     * @param p2
     *
     * @param p3
     *
     * @param t A value between 0 and 1, inclusive.
     *
     * @return
     *
     */
    public static Tuple3d quadBezier(Tuple3d p1, Tuple3d p2, Tuple3d p3, double t) {

        return new Tuple3d(
                quadBezierPoint(p1.x, p2.x, p3.x, t),
                quadBezierPoint(p1.y, p2.y, p3.y, t),
                quadBezierPoint(p1.z, p2.z, p3.z, t));

    }

    /**
     *
     * The cubic Bezier equation.
     *
     *
     * @param a0
     *
     * @param a1
     *
     * @param a2
     *
     * @param a3
     *
     * @param t
     *
     * @return
     *
     */
    private static double cubicBezierPoint(double a0, double a1, double a2, double a3, double t) {

        return Math.pow(1 - t, 3) * a0 + 3 * Math.pow(1 - t, 2) * t * a1 + 3 * (1 - t) * Math.pow(t, 2) * a2 + Math.pow(t, 3) * a3;

    }

    /**
     *
     * The quadratic Bezier equation,
     *
     * @param a0
     *
     * @param a1
     *
     * @param a2
     *
     * @param t
     *
     * @return
     *
     */
    private static double quadBezierPoint(double a0, double a1, double a2, double t) {

        return Math.pow(1 - t, 2) * a0 + 2 * (1 - t) * t * a1 + Math.pow(t, 2) * a2;

    }

    /**
     *
     * Calculates the center point between the two parameter points.
     *
     * @param p1
     *
     * @param p2
     *
     * @return
     *
     */
    public static Tuple3d center(Tuple3d p1, Tuple3d p2) {

        return new Tuple3d(
                (p1.x + p2.x) / 2,
                (p1.y + p2.y) / 2,
                (p1.z + p2.z) / 2
        );

    }

    /*
    // Não por em Face
     points[pointCount] = new Point();
    points[pointCount].x = evt.getX() - this.offsetX;
    points[pointCount].y = evt.getY() - this.offsetY;
    pointCount++;

    this.drawScene();
    private void drawScene() {

        precision = Float.parseFloat(this.jTextField4.getText());
        //Clears the screen and draws X and Y lines
        g.setColor(Color.white);
        g.fillRect(0, 0, pWidth, pHeight);

        g.setColor(Color.gray);
        g.drawLine(0, offsetY, pWidth, offsetY);
        g.drawLine(offsetX, 0, offsetX, pHeight);
        //Drawing the points
        if (pointCount > 0) {
            for (int i = 0; i < pointCount; i++) {
                g.setColor(Color.red);
                g.drawString(String.valueOf(i + 1), points[i].x + offsetX, points[i].y - 6 + offsetY);
                g.drawOval(points[i].x + offsetX, points[i].y - 6 + offsetY, 3, 3);
            }
        }
        //Drawing the curve
        if (pointCount > 1) {
            float t = 0;
            while (t <= 1) {
                g.setColor(Color.gray);
                this.besierCurvePixel(t);
                t += precision;
            }
        }
    }

//Factorial
    private static int fact(int n) {
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
//Bernstein polynomial

    private static double bernstein(float t, int n, int i) {

        return (fact(n) / (fact(i) * fact(n - i))) * Math.pow(1 - t, n - i) * Math.pow(t, i);
    }

    private void besierCurvePixel(float t) {

        double bPoly[] = new double[pointCount];

        for (int i = 0; i < pointCount; i++) {
            bPoly[i] = bernstein(t, pointCount, i + 1);
        }

        double sumX = 0;
        double sumY = 0;

        for (int i = 0; i < pointCount; i++) {
            sumX += bPoly[i] * points[i].x;
            sumY += bPoly[i] * points[i].y;
        }

        int x, y;
        x = (int) Math.round(sumX);
        y = (int) Math.round(sumY);

        g.drawLine(x + offsetX, y + offsetY, x + offsetX, y + offsetY);

    }
     */
    public void desenhar(Graphics g) {
        transformar();
        g.setColor(Color.black);
        for (int i = 0; i < this.nVertices - 1; i++) {
            g.drawLine(vertices[i].x, vertices[i].y, vertices[i + 1].x, vertices[i + 1].y);
            System.out.println("DESENHANDO PONTO: " + vertices[i].x + ", " + vertices[i].y + ", " + vertices[i].z);
        }
        g.drawLine(vertices[this.nVertices - 1].x, vertices[this.nVertices - 1].y, vertices[0].x, vertices[0].y);
        System.out.println("DESENHANDO PONTO: " + vertices[this.nVertices - 1].x + ", " + vertices[this.nVertices - 1].y + ", " + vertices[this.nVertices - 1].z);
    }

    public void fill(Graphics g) {

        transformar();
        g.setColor(Color.red);

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
