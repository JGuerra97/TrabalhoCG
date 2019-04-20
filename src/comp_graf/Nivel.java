package comp_graf;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.*;

public class Nivel extends JPanel {
    private int fase= 0;

    public void setFase(int fase) {
        this.fase = fase;
    }

   
    @Override
    public void paint(Graphics g) {
        
        g.drawRect(15, 0, 230, 230);
        g.drawRect(265, 0, 230, 230);
        g.drawRect(515, 0, 230, 230);
        g.drawRect(15, 250, 230, 230);
        g.drawRect(265, 250, 230, 230);
        g.drawRect(515, 250, 230, 230);
        g.drawRect(15, 500, 230, 230);
        g.drawRect(265, 500, 230, 230);
        g.drawRect(795,0,230,230);
        g.drawRect(795,250,230,230);
        g.drawRect(795,500,230,230);
        g.drawString("A", 805, 15);
        g.drawString("B", 805, 265);
        g.drawString("C", 805, 515);

       
        switch (fase){
            case 1:
                   Poligono quadrado= new Poligono(4, new int[]{105,105,155,155}, new int[]{90,140,140,90});
                   Poligono reta= new Poligono(2, new int[]{355,405},new int[]{90,140});
                   Poligono triangulo= new Poligono(3,new int[]{105,130,155}, new int[]{140,90,140});
                   triangulo.translacao(500, 0);
                   triangulo.desenhar(g);
                   quadrado.desenhar(g);
                   reta.desenhar(g);
                   
                  quadrado.translacao(0, 250);
                  quadrado.desenhar(g);
                  reta.rotacao(90, 380, 115);
                  reta.translacao(0, 250);
                  reta.desenhar(g);
                  
                  Poligono pentagono= new Poligono(5,new int[]{10,1,25,49,40}, new int[]{50,20,5,20,50});
                  pentagono.translacao(605, 340); 
                  pentagono.desenhar(g);
                  
                  triangulo.translacao(-500, 500);
                  triangulo.desenhar(g);
                  
                  reta.translacao(0, 250);
                  reta.desenhar(g);
                  reta.rotacao(90, 380, 615);
                  reta.desenhar(g);
                  
                  quadrado.translacao(780, 0);
                  quadrado.desenhar(g);
                  
                  triangulo.translacao(780, -500);
                  triangulo.desenhar(g);
                  
                  reta.rotacao(45, 380, 615);
                  reta.translacao(530, 0);
                  reta.desenhar(g);
                   
                   
                   break;
            
        
            default: break;
        }
        
                

     //   g.drawRect(515, 500, 230, 230); 
        
        //poligonos.get(0).desenhar(g); 
        //poligonos.get(0).translacao(165, 0);
        
       

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