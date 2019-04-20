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

        Poligono reta= new Poligono(2, new int[]{0,50},new int[]{0,50});
        Poligono triangulo= new Poligono(3,new int[]{0,25,50}, new int[]{50,0,50});
        Poligono quadrado= new Poligono(4, new int[]{0,0,50,50}, new int[]{0,50,50,0});
        Poligono trapezio= new Poligono(4, new int[]{0,50,40,10}, new int[]{40,40,10,10});
        Poligono pentagono= new Poligono(5,new int[]{10,0,25,50,40}, new int[]{50,23,0,23,50});
        
        System.out.println(fase);
        
        switch (fase){
            case 1:
                
               // Primeira Linha
               quadrado.translacao(105, 90);
               quadrado.desenhar(g);
               reta.translacao(355, 90);
               reta.desenhar(g);
               triangulo.translacao(605, 90);
               triangulo.desenhar(g);
               
               // Segunda Linha
               quadrado.translacao(0, 250);
               quadrado.desenhar(g);
               reta.rotacao(90, 380, 115);
               reta.translacao(0, 250);
               reta.desenhar(g);
               pentagono.translacao(605, 340); 
               pentagono.desenhar(g);
               
               // Terceira Linha
               triangulo.translacao(-500, 500);
               triangulo.desenhar(g);
               reta.translacao(0, 250);
               reta.desenhar(g);
               reta.rotacao(90, 380, 615);
               reta.desenhar(g);
               
               // Respostas
               triangulo.translacao(780, -500);
               triangulo.desenhar(g);
               quadrado.translacao(780, 0);
               quadrado.desenhar(g);
               reta.rotacao(45, 380, 615);
               reta.translacao(530, 0);
               reta.desenhar(g);

               break;
               
            case 2:
                
                // Primeira Linha
                triangulo.translacao(105, 90);
                triangulo.desenhar(g);
                triangulo.rotacao(90, 130, 115);
                triangulo.translacao(250, 0);
                triangulo.desenhar(g);
                triangulo.reflexaoX(380);
                triangulo.translacao(250, 0);
                triangulo.desenhar(g);
                
                // Segunda Linha
                pentagono.translacao(105, 340);
                pentagono.desenhar(g);
                pentagono.rotacao(90, 130, 365);
                pentagono.translacao(250, 0);
                pentagono.desenhar(g);
                pentagono.reflexaoX(380);
                pentagono.translacao(250, 0);
                pentagono.desenhar(g);
                
                // Terceira Linha
                trapezio.rotacao(-90, 25, 25);
                trapezio.translacao(105, 590);
                trapezio.desenhar(g);
                trapezio.rotacao(90, 130, 615);
                trapezio.translacao(250, 0);
                trapezio.desenhar(g);
                
                // Respostas
                quadrado.translacao(885, 90);
                quadrado.desenhar(g);
                trapezio.translacao(530, -250);
                trapezio.reflexaoY(365);
                trapezio.desenhar(g);
                trapezio.reflexaoY(365);
                trapezio.translacao(0, 250);
                trapezio.desenhar(g);
            
        
            default:
                break;
        }
    }
}
