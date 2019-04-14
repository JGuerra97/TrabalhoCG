package comp_graf;

import java.awt.Graphics;
import javax.swing.*;

public class Nivel extends JPanel {

    @Override
    public void paint(Graphics g) {
        Poligono p = new Poligono(5, new int[]{25, 145, 25, 145, 85}, new int[]{25, 25, 145, 145, 85});
        p.desenhar(g);
        
        p.translacao(330, 0);
        p.desenhar(g);
        
        p.translacao(-165, 315);
        p.escalaGlobal(0.75, 0.25, p.vertices[4].x, p.vertices[4].y);
        p.desenhar(g);
        
        p.rotacao(90, p.vertices[4].x, p.vertices[4].y);
        p.desenhar(g);
    }
}
/*
public class Nivel {
    protected Poligono[] poligonos;
    protected Poligono[] respostas;

    public Nivel(Poligono[] a, Poligono[] b) {
        this.poligonos= a;
        this.respostas= b;
    }
    
    
    
}
*/