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
  
        Poligono reta = new Poligono(2, new int[]{0,50},new int[]{0,50});                                         //Centro(25,25)
        Poligono triangulo = new Poligono(3, new int[]{0,25,50}, new int[]{50,0,50});
        Poligono quadrado = new Poligono(4, new int[]{0,0,50,50}, new int[]{0,50,50,0});                 //Centro(25,25)
        Poligono trapezio = new Poligono(4, new int[]{0,50,40,10}, new int[]{40,40,10,10});
        Poligono pentagono = new Poligono(5, new int[]{10,0,25,50,40}, new int[]{50,21,0,21,50}); //Centro(25,25)
        
        Poligono retangulo = new Poligono(4, new int[]{0,0,100,100}, new int[]{0,50,50,0}); // Escala no quadrado!
        
        Poligono estrela = new Poligono(10, new int[]{0,19,25,31,50,35,40,25,10,15}, new int[]{21,21,0,21,21,32,50,39,50,32});    // Centro (25,25)
        Poligono bandeira = new Poligono(5, new int[]{0,0,50,50,25}, new int[]{0,50,50,0,25});
        Poligono hexagono = new Poligono(6, new int[]{0,13,38,50,37,12}, new int[]{25,3,3,25,47,47});    //centro (25,25)
        Poligono octogono = new Poligono(8, new int[]{25,7,0,7,25,43,50,43}, new int[]{0,7,25,43,50,43,25,7});  // centro (25,25)
        
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
                
                break;
                
            case 3:
                
                //Primeira Linha
                triangulo.translacao(105, 115);
                triangulo.desenhar(g);
                triangulo.reflexaoY(115);
                triangulo.desenhar(g);
                reta.translacao(355,90);
                reta.rotacao(-45, 380, 115);
                reta.desenhar(g);
                triangulo.translacao(500, -12);
                triangulo.desenhar(g);
                triangulo.reflexaoY(115);
                triangulo.desenhar(g);
                
                //Segunda Linha
                retangulo.translacao(80, 340);
                retangulo.desenhar(g);
                reta.translacao(0, 250);
                reta.rotacao(90, 380, 365);
                reta.desenhar(g);
                quadrado.translacao(568, 340);
                quadrado.desenhar(g);
                quadrado.reflexaoX(630);
                quadrado.desenhar(g);

                
                //Terceira Linha
                quadrado.translacao(-537, 250);
                quadrado.desenhar(g);
                quadrado.translacao(537, -250);
                reta.translacao(0, 250);
                reta.desenhar(g);
                reta.rotacao(90, 380, 615);
                reta.desenhar(g);
                
                //Respostas
                retangulo.translacao(780, -250);
                retangulo.rotacao(90, 910, 115);
                retangulo.desenhar(g);
                
                quadrado.translacao(206, -37);    // 243 - 37 desloca ele para cima
                quadrado.desenhar(g);
                quadrado.reflexaoY(365);
                quadrado.desenhar(g);
                quadrado.reflexaoX(910);
                quadrado.desenhar(g);
                quadrado.reflexaoY(365);
                quadrado.desenhar(g);
                
                quadrado.translacao(-37, 287);
                quadrado.desenhar(g);

                
                break;
            
        
            case 4:
                
                //Primeira Linha
                triangulo.translacao(105, 90);
                triangulo.desenhar(g);
                triangulo.translacao(250, 0);
                triangulo.rotacao(180, 380, 115);
                triangulo.desenhar(g);
                triangulo.translacao(250, 0);
                triangulo.desenhar(g);
                triangulo.rotacao(180, 630, 115);
                triangulo.desenhar(g);
                
                //Segunda Linha
                bandeira.translacao(105, 340);
                bandeira.desenhar(g);
                bandeira.translacao(250, 0);
                bandeira.rotacao(180, 380, 365);
                bandeira.desenhar(g);
                bandeira.translacao(250, 0);
                bandeira.desenhar(g);
                bandeira.rotacao(180, 630, 365);
                bandeira.desenhar(g);
                
                //Terceira Linha
                estrela.translacao(105, 590);
                estrela.desenhar(g);
                estrela.translacao(250, 0);
                estrela.rotacao(180, 380, 615);
                estrela.desenhar(g);
               
               //Respostas
                estrela.translacao(530, 0);
                estrela.desenhar(g);
                estrela.rotacao(180, 910, 615);
                estrela.desenhar(g); 
                estrela.translacao(0, -250);
                estrela.desenhar(g);
                estrela.translacao(0, -250);
                estrela.desenhar(g);
                bandeira.translacao(280, -250);
                bandeira.desenhar(g);
      
                break;
            
        
            case 5:     
               
                
                
                //Primeira linha
                hexagono.translacao(105, 90);
                hexagono.desenhar(g);
                hexagono.translacao(217, -38);
                hexagono.desenhar(g);
                hexagono.translacao(77,63);
                hexagono.desenhar(g);
                hexagono.translacao(168, -77);
                hexagono.desenhar(g);
                hexagono.translacao(77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(-77, 77);
                hexagono.desenhar(g);
                hexagono.translacao(77, 0);
                hexagono.desenhar(g);
                
                //Segunda Linha
                hexagono.translacao(-537, 154);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(217, -154);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(77, -154);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(120, -154);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(58, -154);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(58, -154);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(58, -154);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                
                //Terceira linha
                hexagono.translacao(-638, 122);
                hexagono.desenhar(g);
                hexagono.translacao(87, 63);
                hexagono.desenhar(g);
                hexagono.translacao(178, -77);
                hexagono.desenhar(g);
                hexagono.translacao(77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(-77, 77);
                hexagono.desenhar(g);
                hexagono.translacao(77, 0);
                hexagono.desenhar(g);
                
                
                //Respostas
                hexagono.translacao(400, -77);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(58, -77);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(58, -77);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(58, -77);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77);
                hexagono.desenhar(g);
                hexagono.translacao(-83, -271);
                hexagono.desenhar(g);
                hexagono.translacao(0, -212);
                hexagono.desenhar(g);
                hexagono.translacao(0, -77);
                hexagono.desenhar(g);
                
                
                break;
            
        
            case 6:
                
                //Primeira linha
                hexagono.translacao(105, 90);
                hexagono.desenhar(g);
                hexagono.translacao(257, -50);
                hexagono.desenhar(g);
                hexagono.translacao(0, 100);
                hexagono.desenhar(g);
                hexagono.translacao(193, -50);
                hexagono.desenhar(g);
                hexagono.translacao(58, 0);
                hexagono.desenhar(g);
                hexagono.translacao(58, 0);
                hexagono.desenhar(g);
                
                // Segunda linha
                hexagono.translacao(-566, 193 );
                hexagono.desenhar(g);
                hexagono.translacao(0, 58);
                hexagono.desenhar(g);
                hexagono.translacao(0, 58);
                hexagono.desenhar(g);
                hexagono.translacao(212, -116);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116);
                hexagono.desenhar(g);               
                hexagono.translacao(77, -116);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116);
                hexagono.desenhar(g);
                hexagono.translacao(180, -116);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116);
                hexagono.desenhar(g);               
                hexagono.translacao(77, -116);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116);
                hexagono.desenhar(g);
                hexagono.translacao(-38, -58);
                hexagono.desenhar(g);
                
                //Terceira linha
                hexagono.translacao(-509, 194);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116);
                hexagono.desenhar(g);
                hexagono.translacao(257, -116);
                hexagono.desenhar(g);
                hexagono.translacao(0, 58);
                hexagono.desenhar(g);
                hexagono.translacao(0, 58);
                hexagono.desenhar(g);
                
                
                //Respostas
                hexagono.translacao(492, -116);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116);
                hexagono.desenhar(g);               
                hexagono.translacao(77, -116);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116);
                hexagono.desenhar(g);
                hexagono.translacao(-38, -58);
                hexagono.desenhar(g);
                hexagono.translacao(-38, -310);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116);
                hexagono.desenhar(g);               
                hexagono.translacao(77, -116);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116);
                hexagono.desenhar(g);
                hexagono.translacao(-38, -368);
                hexagono.desenhar(g);
                hexagono.translacao(0, 58);
                hexagono.desenhar(g);
                hexagono.translacao(0, 58);
                hexagono.desenhar(g);
                
                
                break;
            
        
            case 7:
                // Primeira linha
                reta.translacao(105, 90);
                reta.desenhar(g);
                quadrado.translacao(355, 90);
                quadrado.desenhar(g);
                hexagono.translacao(605, 90);
                hexagono.desenhar(g);
                
                //Segunda linha  
                reta.translacao(0, 250);
                reta.desenhar(g);
                triangulo.translacao(355, 340);
                triangulo.desenhar(g);
                pentagono.translacao(605, 340);
                pentagono.desenhar(g);
                
                //Terceira linha
                reta.translacao(0, 250);
                reta.desenhar(g);
                hexagono.translacao(-250, 500);
                hexagono.desenhar(g);
                
                
                //Respostas
                octogono.translacao(885, 590);
                octogono.desenhar(g);
                trapezio.translacao(885, 340);
                trapezio.desenhar(g);
                bandeira.translacao(885, 90);
                bandeira.desenhar(g);
                
                
                break;
                
            /*
            case 8:
                break;
            
        
            case 9:
                break;
            
        
            case 10:
                break;
            
            */
            default:
                break;
        }
    }
}
