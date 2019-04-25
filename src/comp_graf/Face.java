package comp_graf;

import java.awt.Graphics;

public class Face {
    
    protected final int nVertices;
    protected final Vertice[] vertices;
    protected double matrizTransformacao[][];
    
    public Face(int n, int[] x, int[] y){
        this.nVertices = n;
        vertices = new Vertice[this.nVertices];
        for(int i=0; i < this.nVertices; i++){
            vertices[i] = new Vertice(x[i], y[i]);
        }
        matrizTransformacao = new double[3][3];
        for(int i=0; i < 3; i++){
            for(int j=0; j < 3; j++){
                matrizTransformacao[i][j] = (i == j) ? 1 : 0;
            }
        }
    }
    
    private void transformar(){
        for(Vertice v : vertices){
            int temp = v.x;
            v.x = (int)(v.x * matrizTransformacao[0][0]) + (int)(v.y * matrizTransformacao[0][1]) + (int)(matrizTransformacao[0][2]);
            v.y = (int)(temp * matrizTransformacao[1][0]) + (int)(v.y * matrizTransformacao[1][1]) + (int)(matrizTransformacao[1][2]);
        }
    }
    
    public void translacao(int x, int y){
        matrizTransformacao[0][2] = x;
        matrizTransformacao[1][2] = y;
        transformar();
        matrizTransformacao[0][2] = 0;
        matrizTransformacao[1][2] = 0;
    }
    
    public void escalaX(double sx, int referenciax){
        this.translacao(- referenciax, 0);
        matrizTransformacao[0][0] = sx;
        transformar();
        matrizTransformacao[0][0] = 1;
        this.translacao(referenciax, 0);
    }
    
    public void escalaY(double sy, int referenciay){
        this.translacao(0, - referenciay);
        matrizTransformacao[1][1] = sy;
        transformar();
        matrizTransformacao[1][1] = 1;
        this.translacao(0, referenciay);
    }
    
    public void escalaGlobal(double escala, int referenciax, int referenciay){
        this.escalaX(escala, referenciax);
        this.escalaY(escala, referenciay);
    }
    
    public void rotacao(double angulo, int referenciax, int referenciay){
        double seno = Math.sin(Math.toRadians(angulo));
        double cosseno = Math.cos(Math.toRadians(angulo));
        this.translacao(- referenciax, - referenciay);
        matrizTransformacao[0][0] = cosseno;
        matrizTransformacao[1][1] = cosseno;
        matrizTransformacao[0][1] = -seno;
        matrizTransformacao[1][0] = seno;
        transformar();
        matrizTransformacao[0][0] = 1;
        matrizTransformacao[1][1] = 1;
        matrizTransformacao[0][1] = 0;
        matrizTransformacao[1][0] = 0;
        this.translacao(referenciax, referenciay);
    }
    
    public void reflexaoX(int referenciax){
        this.translacao(- referenciax, 0);
        matrizTransformacao[0][0] = -1;
        transformar();
        matrizTransformacao[0][0] = 1;
        this.translacao(referenciax, 0);
    }
    
    public void reflexaoY(int referenciay){
        this.translacao(0, - referenciay);
        matrizTransformacao[1][1] = -1;
        transformar();
        matrizTransformacao[1][1] = 1;
        this.translacao(0, referenciay);
    }
    
    public void desenhar(Graphics g){
        for(int i = 0; i < this.nVertices-1; i++){
            g.drawLine(vertices[i].x, vertices[i].y, vertices[i+1].x, vertices[i+1].y);
        }
        g.drawLine(vertices[this.nVertices-1].x, vertices[this.nVertices-1].y, vertices[0].x, vertices[0].y);
    }
    public void pintar(Graphics g){
        
        
    }
}
