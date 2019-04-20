package comp_graf;

import java.awt.Graphics;
import java.lang.Math;

public class Poligono {
    
    protected final int nVertices;
    protected final Vertice[] vertices;
    
    public Poligono(int n, int[] x, int[] y){
        this.nVertices = n;
        vertices = new Vertice[this.nVertices];
        for(int i=0; i < this.nVertices; i++){
            vertices[i] = new Vertice(x[i], y[i]);
        }
    }
    
    public void translacao(int x, int y){
        for(Vertice v : vertices){
            v.translacao(x, y);
        }
    }
    
    public void escalaX(double sx, int referenciax){
        this.translacao(- referenciax, 0);
        for(Vertice v : vertices){
            v.x = (int)(v.x * sx);
        }
        this.translacao(referenciax, 0);
    }
    
    public void escalaY(double sy, int referenciay){
        this.translacao(0, - referenciay);
        for(Vertice v : vertices){
            v.y = (int)(v.y * sy);
        }
        this.translacao(0, referenciay);
    }
    
    public void escalaGlobal(double sx, double sy, int referenciax, int referenciay){
        this.escalaX(sx, referenciax);
        this.escalaY(sy, referenciay);
    }
    
    public void rotacao(double angulo, int referenciax, int referenciay){
        double seno = Math.sin(Math.toRadians(angulo));
        double cosseno = Math.cos(Math.toRadians(angulo));        
        this.translacao(- referenciax, - referenciay);
        for(Vertice v : vertices){
            int temp = v.x;
            v.x = (int)(v.x * cosseno) - (int)(v.y * seno);
            v.y = (int)(temp * seno) + (int)(v.y * cosseno);
        }
        this.translacao(referenciax, referenciay);
    }
    
    public void reflexaoX(int referenciax){
        this.translacao(- referenciax, 0);
        for(Vertice v : vertices){
            v.x = - v.x;
        }
        this.translacao(referenciax, 0);
    }
    
    public void reflexaoY(int referenciay){
        this.translacao(- referenciay, 0);
        for(Vertice v : vertices){
            v.y = - v.y;
        }
        this.translacao(referenciay, 0);
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
