package comp_graf;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tela3 extends JFrame {

    Scanner teclado = new Scanner(System.in);

    public Tela3() {

        super("TESTE DE QI");

        this.setSize(1045, 850);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        JButton botao = new JButton("COMEÇAR");
        botao.setFont(new Font("Arial", Font.BOLD, 12));

        JLabel label = new JLabel("TESTE DE QI         ");
//        label.setBounds(445, 0, 150, 40);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label, BorderLayout.WEST);

        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(100, 40));
        panel.setMinimumSize(new Dimension(20, 50));
        panel.add(botao, BorderLayout.EAST);

        container.add(panel);

        System.out.println("Defina o eixo de rotação:");
        int x,
                y,
                z,
                x1,
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

        x = x2 - x1;
        y = y2 - y1;
        z = z2 - z1;

        AnimacaoQuaternio animacao = new AnimacaoQuaternio(x1, y1, z1, x2, y2, z2, angulo);

        JPanel panel2 = animacao;
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(600, 100));
        panel2.setMinimumSize(new Dimension(500, 100));
        container.add(panel2);
        getContentPane().add(container);
        setVisible(true);

    }
}
