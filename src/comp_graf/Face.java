package comp_graf;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import static java.lang.Math.cos;
import java.util.Arrays;

public class Face {
    
    protected final int nVertices;
    protected final Vertice[] vertices;
    protected double[][] matrizTransformacao = {{1,0,0,0},
                                                {0,1,0,0},
                                                {0,0,1,0},
                                                {0,0,0,1}};
    
    public Face(int n, int[] x, int[] y, int[] z){
        
        this.nVertices = n;
        vertices = new Vertice[this.nVertices];
        
        for(int i=0; i < this.nVertices; i++){
            vertices[i] = new Vertice(x[i], y[i], z[i]);
        }
    }
    
    public void mudaMatrizTransformacao(double[][] a){
        
        double[][] resultado = {{0,0,0,0},
                                {0,0,0,0},
                                {0,0,0,0},
                                {0,0,0,0}};
        
        for(int i=0; i < 4; i++){
            for(int j=0; j < 4; j++){
                for(int k=0; k < 4; k++){
                    resultado[i][j] += matrizTransformacao[i][k] * a[k][j];
                }
            }
        }
        
        matrizTransformacao = resultado;
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                System.out.print(matrizTransformacao[i][j] + " ");
            }
            System.out.println("");
        }
        System.out.println("");
    }
    
    public void transformar(){
        
        for(Vertice v : vertices){
            int tempx = v.x;
            int tempy = v.y;
            v.x = (int)(v.x * matrizTransformacao[0][0]) + (int)(v.y * matrizTransformacao[0][1]) + (int)(v.z * matrizTransformacao[0][2]) + (int)(matrizTransformacao[0][3]);
            v.y = (int)(tempx * matrizTransformacao[1][0]) + (int)(v.y * matrizTransformacao[1][1]) + (int)(v.z * matrizTransformacao[1][2]) + (int)(matrizTransformacao[1][3]);
            v.z = (int)(tempx * matrizTransformacao[2][0]) + (int)(tempy * matrizTransformacao[2][1]) + (int)(v.z * matrizTransformacao[2][2]) + (int)(matrizTransformacao[2][3]);
        }
        
        matrizTransformacao = new double[][]{{1,0,0,0},
                                             {0,1,0,0},
                                             {0,0,1,0},
                                             {0,0,0,1}};
    }
    
    public void translacao(int x, int y, int z){
        System.out.println("Translação: x = "  + x + "\ty = " + y);
        mudaMatrizTransformacao(new double[][]{{1,0,0,x},
                                               {0,1,0,y},
                                               {0,0,1,z},
                                               {0,0,0,1}});
    }
    
    public void escalaX(double sx, int referenciax){
        
        translacao(referenciax, 0, 0);
        
        System.out.println("Escala X: " + sx);
        mudaMatrizTransformacao(new double[][]{{sx,0,0,0},
                                               {0, 1,0,0},
                                               {0, 0,1,0},
                                               {0, 0,0,1}});
        
        translacao(-referenciax, 0, 0);
    }
    
    public void escalaY(double sy, int referenciay){
        
        translacao(0, referenciay, 0);
        
        System.out.println("Escala Y: " + sy);
        mudaMatrizTransformacao(new double[][]{{1, 0,0,0},
                                               {0,sy,0,0},
                                               {0, 0,1,0},
                                               {0, 0,0,1}});
        
        translacao(0, -referenciay, 0);
    }
    
    public void escalaZ(double sz, int referenciaz){
        
        translacao(0, 0, referenciaz);
        
        System.out.println("Escala Z: " + sz);
        mudaMatrizTransformacao(new double[][]{{1,0, 0,0},
                                               {0,1, 0,0},
                                               {0,0,sz,0},
                                               {0,0, 0,1}});
        
        translacao(0, 0, -referenciaz);
    }
    
    public void escalaGlobal(double escala, int referenciax, int referenciay, int referenciaz){
        
        translacao(referenciax, referenciay, referenciaz);
        
        System.out.println("Escala Global: " + escala);
        mudaMatrizTransformacao(new double[][]{{escala,0,     0,     0},
                                               {0,     escala,0,     0},
                                               {0,     0,     escala,0},
                                               {0,     0,     0,     1}});
        
        translacao(-referenciax, -referenciay, -referenciaz);
    }
    
    public void rotacaoPlanoXY(double angulo, int referenciax, int referenciay, int referenciaz){
        
        double seno = Math.sin(Math.toRadians(angulo));
        double cosseno = Math.cos(Math.toRadians(angulo));
        
        translacao(referenciax, referenciay, referenciaz);
        
        System.out.println("Rotação no Plano XY: " + angulo);
        mudaMatrizTransformacao(new double[][]{{cosseno,-seno,  0,0},
                                               {seno,   cosseno,0,0},
                                               {0,      0,      1,0},
                                               {0,      0,      0,1}});
        
        translacao(-referenciax, -referenciay, -referenciaz);
    }
    
    public void rotacaoPlanoYZ(double angulo, int referenciax, int referenciay, int referenciaz){
        
        double seno = Math.sin(Math.toRadians(angulo));
        double cosseno = Math.cos(Math.toRadians(angulo));
        
        translacao(referenciax, referenciay, referenciaz);
        
        System.out.println("Rotação no Plano YZ: " + angulo);
        mudaMatrizTransformacao(new double[][]{{1,      0,      0,      0},
                                               {0,      cosseno,-seno,  0},
                                               {0,      seno,   cosseno,0},
                                               {0,      0,      0,      1}});
        
        translacao(-referenciax, -referenciay, -referenciaz);
    }
    
    public void rotacaoPlanoXZ(double angulo, int referenciax, int referenciay, int referenciaz){
        
        double seno = Math.sin(Math.toRadians(angulo));
        double cosseno = Math.cos(Math.toRadians(angulo));
        
        translacao(referenciax, referenciay, referenciaz);
        
        System.out.println("Rotação no Plano XZ: " + angulo);
        mudaMatrizTransformacao(new double[][]{{cosseno,0,   seno,0},
                                               {0,      1,      0,0},
                                               {-seno,  0,cosseno,0},
                                               {0,      0,      0,1}});
        
        translacao(-referenciax, -referenciay, -referenciaz);
    }
    
    public void rotacaoQuaternio(float referenciax, float referenciay, float referenciaz, float nx, float ny, float nz, double angulo){
        
        Quaternio q = new Quaternio(nx, ny, nz, angulo);
        Quaternio q_conjugado;
        q_conjugado = q.calculaConjugado(q);
        double rq0, rq1, rq2, rq3;
        
        // Fazer a multiplicação  q p q* 
        rq0 = 0;
        rq1 =   q.getQ1() * referenciax  * q_conjugado.getQ1();
        rq2 =   q.getQ2() * referenciay  * q_conjugado.getQ2();
        rq3 =   q.getQ3() * referenciaz  * q_conjugado.getQ3();
        
}

    public void reflexaoX(int referenciax){
        
        translacao(referenciax, 0, 0);
        
        System.out.println("Reflexão X:");
        mudaMatrizTransformacao(new double[][]{{-1,0,0,0},
                                               {0, 1,0,0},
                                               {0, 0,1,0},
                                               {0, 0,0,1}});
        
        translacao(-referenciax, 0, 0);
    }
    
    public void reflexaoY(int referenciay){
        
        translacao(0, referenciay, 0);
        
        System.out.println("Reflexão Y:");
        mudaMatrizTransformacao(new double[][]{{1,0, 0,0},
                                               {0,-1,0,0},
                                               {0,0, 1,0},
                                               {0,0, 0,1}});
        
        translacao(0, -referenciay, 0);
    }
    
    public void reflexaoZ(int referenciaz){
        
        translacao(0, 0, referenciaz);
        
        System.out.println("Reflexão Z:");
        mudaMatrizTransformacao(new double[][]{{1,0,0, 0},
                                               {0,1,0, 0},
                                               {0,0,-1,0},
                                               {0,0,0, 1}});
        
        translacao(0, 0, -referenciaz);
    }
    
    public void desenhar(Graphics g){
        transformar();
        g.setColor(Color.black);
        for(int i = 0; i < this.nVertices-1; i++){
            g.drawLine(vertices[i].x, vertices[i].y, vertices[i+1].x, vertices[i+1].y);
            
        }
        g.drawLine(vertices[this.nVertices-1].x, vertices[this.nVertices-1].y, vertices[0].x, vertices[0].y);
        
        
    }
    
    public void fill(Graphics g){
        
        transformar();
      g.setColor(Color.red);
        
        int[] x = new int[nVertices];
        int[] y = new int[nVertices];
        
        for(int i = 0; i < this.nVertices; i++){
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
