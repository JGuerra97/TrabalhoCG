
package comp_graf;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Tela2 extends JFrame{
    
    public Tela2(){
        

        setSize(1045, 850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(new GridLayout());
        
        Tuple3d[] pontosBezier = new Tuple3d[4];
        Scanner teclado = new Scanner(System.in);
        for (int i = 0; i < 4; i++) {
                    System.out.println("Defina os valores x, y e z do ponto " + i);
                    pontosBezier[i] = new Tuple3d(teclado.nextInt(), teclado.nextInt(), teclado.nextInt()); //Pedindo ao usuário os 4 pontos da curva
                }
       
        Animation animacao = new Animation(pontosBezier);
         add(animacao);
         setVisible(true);
    }
    
}
