package comp_graf;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;

public class AnimacaoQuaternio extends JPanel implements ActionListener {

    Objeto3DAviao aviao = new Objeto3DAviao();
    int x1, x2, y1, y2, z1, z2, j;
    double norma, angulo;
    //Timer tm = new Timer(90, this);

    AnimacaoQuaternio(int x1, int y1, int z1, int x2, int y2, int z2, double angulo) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y1;
        this.y2 = y2;
        this.z1 = z1;
        this.z2 = z2;
        this.angulo = angulo;

        //tm.start();
    }

    @Override
    public void paint(Graphics g) {
        // g.clearRect(0, 0, getWidth(), getWidth());
        g.drawLine(x1, y1, x2, y2);
        norma = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2) + Math.pow((z2 - z1), 2));
        aviao.translacao(50, 50, 0);
        aviao.transformar();
        System.out.println("x1 " + x1);
        System.out.println("x2 " + x2);
        System.out.println("y1 " + y1);
        System.out.println("y2 " + y2);
        System.out.println("z1 " + z1);
        System.out.println("z2 " + z2);
        System.out.println("angulo " + angulo);
        System.out.println("norma " + norma);
        int x = x2 - x1;
        int y = y2 - y1;
        int z = z2 - z1;
        aviao.rotacaoQuaternio(angulo, x / norma, y / norma, z / norma);
        aviao.desenhar(g);

        System.out.println(" j : " + j);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        /*if(j<99){
            j = j+1;

            repaint();
        }*/
    }
}
