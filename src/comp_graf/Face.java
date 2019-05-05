package comp_graf;

import java.awt.Graphics;

public class Face {
    
    protected final int nVertices;
    protected final Vertice[] vertices;
    protected double[][] matrizTransformacao = {{1,0,0},
                                                {0,1,0},
                                                {0,0,1}};
    
    public Face(int n, int[] x, int[] y){
        
        this.nVertices = n;
        vertices = new Vertice[this.nVertices];
        
        for(int i=0; i < this.nVertices; i++){
            vertices[i] = new Vertice(x[i], y[i]);
        }
    }
    
    private void mudaMatrizTransformacao(double[][] a){
        
        double[][] resultado = {{0,0,0},
                                {0,0,0},
                                {0,0,0}};
        
        for(int i=0; i < matrizTransformacao.length; i++){
            for(int j=0; j < a.length; j++){
                for(int k=0; k < matrizTransformacao.length; k++){
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
            int temp = v.x;
            v.x = (int)(v.x * matrizTransformacao[0][0]) + (int)(v.y * matrizTransformacao[0][1]) + (int)(matrizTransformacao[0][2]);
            v.y = (int)(temp * matrizTransformacao[1][0]) + (int)(v.y * matrizTransformacao[1][1]) + (int)(matrizTransformacao[1][2]);
        }
        
        matrizTransformacao = new double[][]{{1,0,0},
                                             {0,1,0},
                                             {0,0,1}};
    }
    
    public void translacao(int x, int y){
        System.out.println("Translação: x = "  + x + "\ty = " + y);
        mudaMatrizTransformacao(new double[][]{{1,0,x},
                                               {0,1,y},
                                               {0,0,1}});
    }
    
    public void escalaX(double sx, int referenciax){
        
        translacao(referenciax, 0);
        
        System.out.println("Escala X: " + sx);
        mudaMatrizTransformacao(new double[][]{{sx,0,0},
                                               {0,1,0},
                                               {0,0,1}});
        
        translacao(-referenciax, 0);
    }
    
    public void escalaY(double sy, int referenciay){
        
        translacao(0, referenciay);
        
        System.out.println("Escala Y: " + sy);
        mudaMatrizTransformacao(new double[][]{{1,0,0},
                                               {0,sy,0},
                                               {0,0,1}});
        
        translacao(0, -referenciay);
    }
    
    public void escalaGlobal(double escala, int referenciax, int referenciay){
        
        translacao(referenciax, referenciay);
        
        System.out.println("Escala Global: " + escala);
        mudaMatrizTransformacao(new double[][]{{escala,0,0},
                                               {0,escala,0},
                                               {0,0,1}});
        
        translacao(-referenciax, -referenciay);
    }
    
    public void rotacao(double angulo, int referenciax, int referenciay){
        
        double seno = Math.sin(Math.toRadians(angulo));
        double cosseno = Math.cos(Math.toRadians(angulo));
        
        translacao(referenciax, referenciay);
        
        System.out.println("Rotação: " + angulo);
        mudaMatrizTransformacao(new double[][]{{cosseno,-seno,0},
                                               {seno,cosseno,0},
                                               {0,0,1}});
        
        translacao(-referenciax, -referenciay);
    }
    
    public void reflexaoX(int referenciax){
        
        translacao(referenciax, 0);
        
        System.out.println("Reflexão X:");
        mudaMatrizTransformacao(new double[][]{{-1,0,0},
                                               {0,1,0},
                                               {0,0,1}});
        
        translacao(-referenciax, 0);
    }
    
    public void reflexaoY(int referenciay){
        
        translacao(0, referenciay);
        
        System.out.println("Reflexão Y:");
        mudaMatrizTransformacao(new double[][]{{1,0,0},
                                               {0,-1,0},
                                               {0,0,1}});
        
        translacao(0, -referenciay);
    }
    
    public void desenhar(Graphics g){
        
        transformar();
        
        for(Vertice v : vertices) System.out.println("X = "+v.x+"\tY = "+v.y);
        System.out.println("");
        for(int i = 0; i < this.nVertices-1; i++){
            g.drawLine(vertices[i].x, vertices[i].y, vertices[i+1].x, vertices[i+1].y);
        }
        g.drawLine(vertices[this.nVertices-1].x, vertices[this.nVertices-1].y, vertices[0].x, vertices[0].y);
    }

}
