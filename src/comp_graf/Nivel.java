package comp_graf;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.*;

public class Nivel extends JPanel {

    private int fase = 0;

    public void setFase(int fase) {
        this.fase = fase;
    }

    @Override
    public void paint(Graphics g) {

        if (fase > 0 && fase < 9) {

            g.drawRect(15, 0, 230, 230);
            g.drawRect(265, 0, 230, 230);
            g.drawRect(515, 0, 230, 230);
            g.drawRect(15, 240, 230, 230);
            g.drawRect(265, 240, 230, 230);
            g.drawRect(515, 240, 230, 230);
            g.drawRect(15, 480, 230, 230);
            g.drawRect(265, 480, 230, 230);
            g.drawRect(795, 0, 230, 230);
            g.drawRect(795, 240, 230, 230);
            g.drawRect(795, 480, 230, 230);
            g.drawString("A", 805, 15);
            g.drawString("B", 805, 255);
            g.drawString("C", 805, 495);

        }

        Objeto3DAviao aviao = new Objeto3DAviao();

        Face reta = new Face(2, new int[]{0, 50}, new int[]{0, 50}, new int[]{0, 0});
        Face triangulo = new Face(3, new int[]{0, 25, 50}, new int[]{0, -50, 0}, new int[]{0, 0, 0});
        Face quadrado = new Face(4, new int[]{0, 0, 50, 50}, new int[]{0, 50, 50, 0}, new int[]{0, 0, 0, 0});
        Face trapezio = new Face(4, new int[]{0, 50, 40, 10}, new int[]{0, 0, -30, -30}, new int[]{0, 0, 0, 0});
        Face pentagono = new Face(5, new int[]{0, -10, 15, 40, 30}, new int[]{0, -29, -50, -29, 0}, new int[]{0, 0, 0, 0, 0});

        Face retangulo = new Face(4, new int[]{0, 0, 50, 50}, new int[]{0, 50, 50, 0}, new int[]{0, 0, 0, 0});
        retangulo.escalaX(2, 0);
        retangulo.transformar();

        Face estrela = new Face(10, new int[]{0, 19, 25, 31, 50, 35, 40, 25, 10, 15}, new int[]{0, 0, -21, 0, 0, 11, 29, 18, 29, 11}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        Face bandeira = new Face(5, new int[]{0, 0, 50, 50, 25}, new int[]{0, 50, 50, 0, 25}, new int[]{0, 0, 0, 0, 0});
        Face hexagono = new Face(6, new int[]{0, 13, 38, 50, 37, 12}, new int[]{0, -22, -22, 0, 22, 22}, new int[]{0, 0, 0, 0, 0, 0});
        Face octogono = new Face(8, new int[]{0, -18, -25, -18, 0, 18, 25, 18}, new int[]{0, 7, 25, 43, 50, 43, 25, 7}, new int[]{0, 0, 0, 0, 0, 0, 0, 0});
        Face aviao2d = new Face(13, new int[]{0, 6, 11, 14, 30, 37, 36, 56, 45, 38, 54, 19, 14}, new int[]{0, 14, 19, 54, 38, 45, 56, 36, 37, 30, 14, 11, 6}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});
        Face umMonteDePonto = new Face(16, new int[]{0, 17, 18, 36, 25, 35, 18, 17, 0, -15, -18, -35, -25, -36, -18, -15}, new int[]{0, -13, 4, 6, 22, 38, 40, 58, 47, 58, 40, 38, 22, 6, 4, -13}, new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0});

        switch (fase) {

            case 0:
                System.out.println("-----------------------------------------FASE 0--------------------------------------");

                aviao.translacao(350, 350, 0);
                aviao.transformar();
                //aviao.rotacaoPlanoYZ(-36.25, 0, 0, 0);
                //aviao.rotacaoPlanoXZ(150, 0, 0, 0);
                //aviao.rotacaoQuaternio(0, 0, 1, 0);
                /*
                Scanner teclado = new Scanner(System.in);

                System.out.println("Defina o eixo de rotação:");
                int x1,
                 x2,
                 y1,
                 y2,
                 z1,
                 z2;
                double angulo;

                System.out.println("Valor de x1:");
                x1 = teclado.nextInt();
                System.out.println("Valor de y1:");
                y1 = teclado.nextInt();
                System.out.println("Valor de z1:");
                z1 = teclado.nextInt();
                System.out.println("Valor de x2:");
                x2 = teclado.nextInt();
                System.out.println("Valor de y2:");
                y2 = teclado.nextInt();
                System.out.println("Valor de z2:");
                z2 = teclado.nextInt();
                System.out.println("Valor do angulo:");
                angulo = teclado.nextDouble();

                g.drawLine(x1, y1, x2, y2);
                double norma = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1) + (z2 - z1) * (z2 - z1));
                System.out.println("NORMA: " + norma);
                aviao.rotacaoQuaternio(angulo, (int) ((x2 - x1) / norma), (int) ((y2 - y1) / norma), (int) ((z2 - z1) / norma));
                aviao.desenhar(g);
                 */
 /*for(int i=0; i<50; i++){
               aviao.desenhar(g);
               aviao.rotacaoQuaternio(angulo/50, x2-x1, y2-y1, z2-z1);
               }*/
                Tuple3d[] pontosBezier = new Tuple3d[4];

                pontosBezier[0] = new Tuple3d(100, 300, 0);
                pontosBezier[1] = new Tuple3d(300, 150, 0);
                pontosBezier[2] = new Tuple3d(800, 100, 0);
                pontosBezier[3] = new Tuple3d(1000, 300, 0);

                g.drawLine((int) pontosBezier[0].x, (int) pontosBezier[0].y, (int) pontosBezier[1].x, (int) pontosBezier[1].y);
                g.drawLine((int) pontosBezier[1].x, (int) pontosBezier[1].y, (int) pontosBezier[2].x, (int) pontosBezier[2].y);
                g.drawLine((int) pontosBezier[2].x, (int) pontosBezier[2].y, (int) pontosBezier[3].x, (int) pontosBezier[3].y);
                CurvaBezier curva = new CurvaBezier();
                Tuple3d[] resultadoBezier = curva.getCurvePoints(pontosBezier, 0.0001);
                System.out.println(resultadoBezier.length);
                for (int i = 0; i < 10000; i++) {
                    g.drawLine((int) resultadoBezier[i].x, (int) resultadoBezier[i].y, (int) resultadoBezier[i + 1].x, (int) resultadoBezier[i + 1].y);
                }

                break;

            case 1:
                System.out.println("-----------------------------------------FASE 1--------------------------------------");

                // Primeira Linha
                quadrado.translacao(105, 90, 0);
                quadrado.desenhar(g);
                reta.translacao(355, 90, 0);
                reta.desenhar(g);
                triangulo.translacao(605, 140, 0);
                triangulo.desenhar(g);

                // Segunda Linha
                quadrado.translacao(0, 240, 0);
                quadrado.desenhar(g);
                reta.translacao(0, 240, 0);
                reta.rotacaoPlanoXY(90, 380, 115, 0);
                reta.desenhar(g);
                pentagono.translacao(615, 380, 0);
                pentagono.desenhar(g);

                // Terceira Linha
                triangulo.translacao(-500, 480, 0);
                triangulo.desenhar(g);
                reta.translacao(0, 240, 0);
                reta.desenhar(g);
                reta.rotacaoPlanoXY(90, 380, 595, 0);
                reta.desenhar(g);

                // Respostas
                triangulo.translacao(780, -480, 0);
                triangulo.desenhar(g);
                quadrado.translacao(780, 0, 0);
                quadrado.desenhar(g);
                reta.translacao(530, 0, 0);
                reta.rotacaoPlanoXY(45, 380, 595, 0);
                reta.desenhar(g);

                break;

            case 2:

                // Primeira Linha
                triangulo.translacao(105, 140, 0);
                triangulo.desenhar(g);
                triangulo.translacao(250, 0, 0);
                triangulo.rotacaoPlanoXY(90, 130, 115, 0);
                triangulo.desenhar(g);
                triangulo.translacao(250, 0, 0);
                triangulo.reflexaoX(380);
                triangulo.desenhar(g);

                // Segunda Linha
                pentagono.translacao(115, 380, 0);
                pentagono.desenhar(g);
                pentagono.translacao(250, 0, 0);
                pentagono.rotacaoPlanoXY(90, 130, 355, 0);
                pentagono.desenhar(g);
                pentagono.translacao(250, 0, 0);
                pentagono.reflexaoX(380);
                pentagono.desenhar(g);

                // Terceira Linha
                trapezio.translacao(105, 610, 0);
                trapezio.rotacaoPlanoXY(-90, 25, -15, 0);
                trapezio.desenhar(g);
                trapezio.translacao(250, 0, 0);
                trapezio.rotacaoPlanoXY(90, 130, 595, 0);
                trapezio.desenhar(g);

                // Respostas
                quadrado.translacao(885, 90, 0);
                quadrado.desenhar(g);
                trapezio.reflexaoY(355);
                trapezio.translacao(530, -240, 0);
                trapezio.desenhar(g);
                trapezio.translacao(0, 240, 0);
                trapezio.reflexaoY(355);
                trapezio.desenhar(g);

                break;

            case 3:

                //Primeira Linha
                triangulo.translacao(105, 165, 0);
                triangulo.desenhar(g);
                triangulo.reflexaoY(115);
                triangulo.desenhar(g);
                reta.rotacaoPlanoXY(-45, 380, 115, 0);
                reta.translacao(355, 90, 0);
                reta.desenhar(g);
                triangulo.translacao(500, -12, 0);
                triangulo.desenhar(g);
                triangulo.reflexaoY(115);
                triangulo.desenhar(g);

                //Segunda Linha
                retangulo.translacao(80, 330, 0);
                retangulo.desenhar(g);
                reta.rotacaoPlanoXY(90, 380, 355, 0);
                reta.translacao(0, 240, 0);
                reta.desenhar(g);
                quadrado.translacao(568, 330, 0);
                quadrado.desenhar(g);
                quadrado.reflexaoX(630);
                quadrado.desenhar(g);

                //Terceira Linha
                quadrado.escalaGlobal(2, 130, 595, 0);
                quadrado.translacao(-537, 240, 0);
                quadrado.desenhar(g);
                reta.translacao(0, 240, 0);
                reta.desenhar(g);
                reta.rotacaoPlanoXY(90, 380, 595, 0);
                reta.desenhar(g);

                //Respostas
                retangulo.rotacaoPlanoXY(90, 910, 115, 0);
                retangulo.translacao(780, -240, 0);
                retangulo.desenhar(g);

                quadrado.translacao(206, -37, 0);
                quadrado.translacao(537, -240, 0);
                quadrado.escalaGlobal(0.5, 130, 595, 0);
                quadrado.desenhar(g);
                quadrado.reflexaoY(355);
                quadrado.desenhar(g);
                quadrado.reflexaoX(910);
                quadrado.desenhar(g);
                quadrado.reflexaoY(355);
                quadrado.desenhar(g);

                quadrado.translacao(-37, 277, 0);
                quadrado.desenhar(g);

                break;

            case 4:

                //Primeira Linha
                triangulo.translacao(105, 140, 0);
                triangulo.desenhar(g);
                triangulo.rotacaoPlanoXY(180, 380, 115, 0);
                triangulo.translacao(250, 0, 0);
                triangulo.desenhar(g);
                triangulo.translacao(250, 0, 0);
                triangulo.desenhar(g);
                triangulo.rotacaoPlanoXY(180, 630, 115, 0);
                triangulo.desenhar(g);

                //Segunda Linha
                bandeira.translacao(105, 330, 0);
                bandeira.desenhar(g);
                bandeira.rotacaoPlanoXY(180, 380, 355, 0);
                bandeira.translacao(250, 0, 0);
                bandeira.desenhar(g);
                bandeira.translacao(250, 0, 0);
                bandeira.desenhar(g);
                bandeira.rotacaoPlanoXY(180, 630, 355, 0);
                bandeira.desenhar(g);

                //Terceira Linha
                estrela.translacao(105, 591, 0);
                estrela.desenhar(g);
                estrela.rotacaoPlanoXY(180, 380, 595, 0);
                estrela.translacao(250, 0, 0);
                estrela.desenhar(g);

                //Respostas
                estrela.translacao(530, 0, 0);
                estrela.desenhar(g);
                estrela.rotacaoPlanoXY(180, 910, 595, 0);
                estrela.desenhar(g);
                estrela.translacao(0, -240, 0);
                estrela.desenhar(g);
                estrela.translacao(0, -240, 0);
                estrela.desenhar(g);
                bandeira.translacao(280, -240, 0);
                bandeira.desenhar(g);

                break;

            case 5:

                //Primeira linha
                hexagono.translacao(105, 112, 0);
                hexagono.desenhar(g);
                hexagono.translacao(217, -38, 0);
                hexagono.desenhar(g);
                hexagono.translacao(77, 63, 0);
                hexagono.desenhar(g);
                hexagono.translacao(168, -77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(77, 0, 0);
                hexagono.desenhar(g);
                hexagono.translacao(-77, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(77, 0, 0);
                hexagono.desenhar(g);

                //Segunda Linha
                hexagono.translacao(-537, 144, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);

                hexagono.translacao(217, -154, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(77, -154, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);

                hexagono.translacao(120, -154, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(58, -154, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(58, -154, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(58, -154, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);

                //Terceira linha
                hexagono.translacao(-638, 132, 0);
                hexagono.desenhar(g);
                hexagono.translacao(87, 63, 0);
                hexagono.desenhar(g);
                hexagono.translacao(178, -77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(77, 0, 0);
                hexagono.desenhar(g);
                hexagono.translacao(-77, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(77, 0, 0);
                hexagono.desenhar(g);

                //Respostas
                hexagono.translacao(400, -77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(58, -77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(58, -77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(58, -77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 77, 0);
                hexagono.desenhar(g);
                hexagono.translacao(-83, -271, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, -212, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, -77, 0);
                hexagono.desenhar(g);

                break;

            case 6:

                //Primeira linha
                hexagono.translacao(105, 112, 0);
                hexagono.desenhar(g);
                hexagono.translacao(257, -50, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 100, 0);
                hexagono.desenhar(g);
                hexagono.translacao(193, -50, 0);
                hexagono.desenhar(g);
                hexagono.translacao(58, 0, 0);
                hexagono.desenhar(g);
                hexagono.translacao(58, 0, 0);
                hexagono.desenhar(g);

                // Segunda linha
                hexagono.translacao(-566, 183, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 58, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 58, 0);
                hexagono.desenhar(g);
                hexagono.translacao(212, -116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(77, -116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(180, -116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(77, -116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(-38, -58, 0);
                hexagono.desenhar(g);

                //Terceira linha
                hexagono.translacao(-509, 184, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(257, -116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 58, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 58, 0);
                hexagono.desenhar(g);

                //Respostas
                hexagono.translacao(482, -116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(77, -116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(-38, -58, 0);
                hexagono.desenhar(g);

                hexagono.translacao(-38, -300, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(77, -116, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 116, 0);
                hexagono.desenhar(g);

                hexagono.translacao(-38, -358, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 58, 0);
                hexagono.desenhar(g);
                hexagono.translacao(0, 58, 0);
                hexagono.desenhar(g);

                break;

            case 7:
                // Primeira linha
                reta.translacao(105, 90, 0);
                reta.desenhar(g);
                quadrado.translacao(355, 90, 0);
                quadrado.desenhar(g);
                hexagono.translacao(605, 112, 0);
                hexagono.desenhar(g);

                //Segunda linha
                reta.translacao(0, 240, 0);
                reta.desenhar(g);
                triangulo.translacao(355, 380, 0);
                triangulo.desenhar(g);
                pentagono.translacao(615, 380, 0);
                pentagono.desenhar(g);

                //Terceira linha
                reta.translacao(0, 240, 0);
                reta.desenhar(g);
                hexagono.translacao(-250, 480, 0);
                hexagono.desenhar(g);

                //Respostas
                octogono.translacao(910, 570, 0);
                octogono.desenhar(g);
                trapezio.translacao(885, 370, 0);
                trapezio.desenhar(g);
                aviao2d.translacao(882, 87, 0);
                aviao2d.desenhar(g);

                break;

            case 8:

                //Primeira Linha
                umMonteDePonto.translacao(126, 92, 0);
                umMonteDePonto.desenhar(g);
                reta.translacao(315, 0, 0);
                reta.rotacaoPlanoXY(-45, 100, 0, 0);
                reta.desenhar(g);
                reta.translacao(0, 100, 0);
                reta.desenhar(g);
                umMonteDePonto.translacao(505, 0, 0);
                umMonteDePonto.desenhar(g);

                //Segunda Linha
                umMonteDePonto.translacao(-505, 240, 0);
                umMonteDePonto.desenhar(g);
                retangulo.translacao(355, 290, 0);
                retangulo.rotacaoPlanoXY(90, 25, 25, 0);
                retangulo.escalaX(1.3, 0);
                retangulo.desenhar(g);

                //Terceira Linha
                umMonteDePonto.translacao(0, 240, 0);
                umMonteDePonto.desenhar(g);
                quadrado.translacao(355, 545, 0);
                quadrado.desenhar(g);
                quadrado.translacao(0, 55, 0);
                quadrado.desenhar(g);

                //Respostas
                reta.translacao(540, -110, 0);
                reta.rotacaoPlanoXY(90, 350, 190, 0);
                reta.desenhar(g);
                retangulo.translacao(600, 25, 0);
                retangulo.escalaY(0.5, 300);
                retangulo.escalaX(0.1, 300);
                retangulo.desenhar(g);
                retangulo.translacao(0, 240, 0);
                retangulo.rotacaoPlanoXY(90, 900, 360, 0);
                retangulo.desenhar(g);

                break;

            case 9:

                aviao.translacao(350, 350, 0);
                aviao.rotacaoPlanoYZ(-35.26, 0, 0, 0);
                aviao.rotacaoPlanoXZ(45, 0, 0, 0);
                aviao.desenhar(g);
                break;

            default:
                System.out.println("ENTROU NO CASE DEFAULT");
                break;
        }
    }
}
