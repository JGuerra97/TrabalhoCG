package comp_graf;

import java.awt.Graphics;
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
        g.drawRect(15, 240, 230, 230);
        g.drawRect(265, 240, 230, 230);
        g.drawRect(515, 240, 230, 230);
        g.drawRect(15, 480, 230, 230);
        g.drawRect(265, 480, 230, 230);
        g.drawRect(795,0,230,230);
        g.drawRect(795,240,230,230);
        g.drawRect(795,480,230,230);
        g.drawString("A", 805, 15);
        g.drawString("B", 805, 255);
        g.drawString("C", 805, 495);
  
        Face reta = new Face(2, new int[]{0,50},new int[]{0,50});
        Face triangulo = new Face(3, new int[]{0,25,50}, new int[]{0,-50,0});
        Face quadrado = new Face(4, new int[]{0,0,50,50}, new int[]{0,50,50,0});
        Face trapezio = new Face(4, new int[]{0,50,40,10}, new int[]{0,0,-30,-30});
        Face pentagono = new Face(5, new int[]{0,-10,15,40,30}, new int[]{0,-29,-50,-29,0});
           
        Face retangulo = new Face(4, new int[]{0,0,50,50}, new int[]{0,50,50,0});
        retangulo.escalaX(2, 0);
        
        Face estrela = new Face(10, new int[]{0,19,25,31,50,35,40,25,10,15}, new int[]{0,0,-21,0,0,11,29,18,29,11});
        Face bandeira = new Face(5, new int[]{0,0,50,50,25}, new int[]{0,50,50,0,25});
        Face hexagono = new Face(6, new int[]{0,13,38,50,37,12}, new int[]{0,-22,-22,0,22,22});
        Face octogono = new Face(8, new int[]{0,-18,-25,-18,0,18,25,18}, new int[]{0,7,25,43,50,43,25,7});
        Face umMonteDePonto = new Face(16, new int[]{0,17,18,36,25,35,18,17,0,-15,-18,-35,-25,-36,-18,-15}, new int[]{0,-13,4,6,22,38,40,58,47,58,40,38,22,6,4,-13});
                
        switch (fase){
            case 1:
               
               // Primeira Linha   
               quadrado.translacao(105, 90);
               quadrado.desenhar(g);
               reta.translacao(355, 90);
               reta.desenhar(g);
               triangulo.translacao(605, 140);
               triangulo.desenhar(g);
               
               // Segunda Linha
               quadrado.translacao(0, 240);
               quadrado.desenhar(g);
               reta.rotacao(90, 380, 115);
               reta.translacao(0, 240);
               reta.desenhar(g);
               pentagono.translacao(615, 380); 
               pentagono.desenhar(g);
               
               // Terceira Linha
               triangulo.translacao(-500, 480);
               triangulo.desenhar(g);
               reta.translacao(0, 240);
               reta.desenhar(g);
               reta.rotacao(90, 380, 595);
               reta.desenhar(g);
               
               // Respostas
               triangulo.translacao(780, -480);
               triangulo.desenhar(g);
               quadrado.translacao(780, 0);
               quadrado.desenhar(g);
               reta.rotacao(45, 380, 595);
               reta.translacao(530, 0);
               reta.desenhar(g);

               break;
               
            case 2:
                
                // Primeira Linha
                triangulo.translacao(105, 140);
                triangulo.desenhar(g);
                triangulo.rotacao(90, 130, 115);
                triangulo.translacao(250, 0);
                triangulo.desenhar(g);
                triangulo.reflexaoX(380);
                triangulo.translacao(250, 0);
                triangulo.desenhar(g);
                
                // Segunda Linha
                pentagono.translacao(115, 380);
                pentagono.desenhar(g);
                pentagono.rotacao(90, 130, 355);
                pentagono.translacao(250, 0);
                pentagono.desenhar(g);
                pentagono.reflexaoX(380);
                pentagono.translacao(250, 0);
                pentagono.desenhar(g);
                
                // Terceira Linha
                trapezio.rotacao(-90, 25, -15);
                trapezio.translacao(105, 610);
                trapezio.desenhar(g);
                trapezio.rotacao(90, 130, 595);
                trapezio.translacao(250, 0);
                trapezio.desenhar(g);
                
                // Respostas
                quadrado.translacao(885, 90);
                quadrado.desenhar(g);
                trapezio.translacao(530, -240);
                trapezio.reflexaoY(355);
                trapezio.desenhar(g);
                trapezio.reflexaoY(355);
                trapezio.translacao(0, 240);
                trapezio.desenhar(g);
                
                break;
                
            case 3:
                
                //Primeira Linha
                triangulo.translacao(105, 165);
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
                retangulo.translacao(80, 330);
                retangulo.desenhar(g);
                reta.translacao(0, 240);
                reta.rotacao(90, 380, 355);
                reta.desenhar(g);
                quadrado.translacao(568, 330);
                quadrado.desenhar(g);
                quadrado.reflexaoX(630);
                quadrado.desenhar(g);

                
                //Terceira Linha
                quadrado.translacao(-537, 240);
                quadrado.escalaGlobal(2, 130, 595);
                quadrado.desenhar(g);
                quadrado.escalaGlobal(0.5, 130, 595);
                quadrado.translacao(537, -240);
                reta.translacao(0, 240);
                reta.desenhar(g);
                reta.rotacao(90, 380, 595);
                reta.desenhar(g);
                
                //Respostas
                retangulo.translacao(780, -240);
                retangulo.rotacao(90, 910, 115);
                retangulo.desenhar(g);
                
                quadrado.translacao(206, -37);    // 243 - 37 desloca ele para cima
                quadrado.desenhar(g);
                quadrado.reflexaoY(355);
                quadrado.desenhar(g);
                quadrado.reflexaoX(910);
                quadrado.desenhar(g);
                quadrado.reflexaoY(355);
                quadrado.desenhar(g);
                
                quadrado.translacao(-37, 277);
                quadrado.desenhar(g);

                
                break;
            
        
            case 4:
                
                //Primeira Linha
                triangulo.translacao(105, 140);
                triangulo.desenhar(g);
                triangulo.translacao(250, 0);
                triangulo.rotacao(180, 380, 115);
                triangulo.desenhar(g);
                triangulo.translacao(250, 0);
                triangulo.desenhar(g);
                triangulo.rotacao(180, 630, 115);
                triangulo.desenhar(g);
                
                //Segunda Linha
                bandeira.translacao(105, 330);
                bandeira.desenhar(g);
                bandeira.translacao(250, 0);
                bandeira.rotacao(180, 380, 355);
                bandeira.desenhar(g);
                bandeira.translacao(250, 0);
                bandeira.desenhar(g);
                bandeira.rotacao(180, 630, 355);
                bandeira.desenhar(g);
                
                //Terceira Linha
                estrela.translacao(105, 591);
                estrela.desenhar(g);
                estrela.translacao(250, 0);
                estrela.rotacao(180, 380, 595);
                estrela.desenhar(g);
               
               //Respostas
                estrela.translacao(530, 0);
                estrela.desenhar(g);
                estrela.rotacao(180, 910, 595);
                estrela.desenhar(g);
                estrela.translacao(0, -240);
                estrela.desenhar(g);
                estrela.translacao(0, -240);
                estrela.desenhar(g);
                bandeira.translacao(280, -240);
                bandeira.desenhar(g);
      
                break;
            
        
            case 5:     
               
                
                
                //Primeira linha
                hexagono.translacao(105, 112);
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
                hexagono.translacao(-537, 144);
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
                hexagono.translacao(-638, 132);
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
                hexagono.translacao(105, 112);
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
                hexagono.translacao(-566, 183 );
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
                hexagono.translacao(-509, 184);
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
                hexagono.translacao(482, -116);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116);
                hexagono.desenhar(g);               
                hexagono.translacao(77, -116);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116);
                hexagono.desenhar(g);
                hexagono.translacao(-38, -58);
                hexagono.desenhar(g);
                
                hexagono.translacao(-38, -300);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116);
                hexagono.desenhar(g);               
                hexagono.translacao(77, -116);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116);
                hexagono.desenhar(g);
                
                hexagono.translacao(-38, -358);
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
                hexagono.translacao(605, 112);
                hexagono.desenhar(g);
                
                //Segunda linha  
                reta.translacao(0, 240);
                reta.desenhar(g);
                triangulo.translacao(355, 380);
                triangulo.desenhar(g);
                pentagono.translacao(615, 380);
                pentagono.desenhar(g);
                
                //Terceira linha
                reta.translacao(0, 240);
                reta.desenhar(g);
                hexagono.translacao(-250, 480);
                hexagono.desenhar(g);
                
                
                //Respostas
                octogono.translacao(910, 570);
                octogono.desenhar(g);
                trapezio.translacao(885, 370);
                trapezio.desenhar(g);
                bandeira.translacao(885, 90);
                bandeira.desenhar(g);
                
                
                break;
                
            
            case 8:
                
                //Primeira Linha
                umMonteDePonto.translacao(126, 92);
                umMonteDePonto.desenhar(g);
                reta.rotacao(-45, 100, 0);
                reta.translacao(315, 0);
                reta.desenhar(g);
                reta.translacao(0, 100);
                reta.desenhar(g);
                umMonteDePonto.translacao(505, 0);
                umMonteDePonto.desenhar(g);
                
                //Segunda Linha
                umMonteDePonto.translacao(-505, 240);
                umMonteDePonto.desenhar(g);
                retangulo.escalaX(1.3, 0);
                retangulo.rotacao(90, 25, 25);
                retangulo.translacao(355, 290);
                retangulo.desenhar(g);
                
                //Terceira Linha
                umMonteDePonto.translacao(0, 240);
                umMonteDePonto.desenhar(g);
                quadrado.translacao(355, 545);
                quadrado.desenhar(g);
                quadrado.translacao(0, 55);
                quadrado.desenhar(g);
                
                //Respostas
                reta.rotacao(90, 350, 190);
                reta.translacao(540, -110);
                reta.desenhar(g);
                retangulo.escalaX(0.1, 300);
                retangulo.escalaY(0.5, 300);
                retangulo.translacao(600, 25);
                retangulo.desenhar(g);
                retangulo.rotacao(90, 900, 360);
                retangulo.translacao(0, 240);
                retangulo.desenhar(g);
                
                
                break;


            default:
                
                break;
        }
    }
}
