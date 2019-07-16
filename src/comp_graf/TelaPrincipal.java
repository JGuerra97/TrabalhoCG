package comp_graf;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.GroupLayout.Group;

public class TelaPrincipal extends JFrame {

    Graphics g;
    private int resultado = 8; //Place Holder para o resultado final

    public TelaPrincipal() {

        super("TESTE DE QI");

        this.setSize(1045, 850);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

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
        Nivel nivel = new Nivel();

        JPanel panel2 = nivel;
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(600, 100));
        panel2.setMinimumSize(new Dimension(500, 100));
        container.add(panel2);
        getContentPane().add(container);

//        JPanel panel = new JPanel(null);
//        this.add(panel);
//        JButton botao = new JButton("COMEÇAR");
//        botao.setBounds(470, 700, 100, 40);
//        botao.setFont(new Font("Arial", Font.BOLD, 12));
//        panel.add(botao);
//
//        JLabel label = new JLabel("TESTE DE QI");
//        label.setBounds(445, 625, 150, 40);
//        label.setFont(new Font("Arial", Font.BOLD, 24));
//        panel.add(label);
        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fase1();       //fase 1
            }
        });

    }

    public void fase1() { // Resposta A

        getContentPane().removeAll();

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        JButton botaoa = new JButton("A");
        JButton botaob = new JButton("B");
        JButton botaoc = new JButton("C");

        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(100, 40));
        panel.setMinimumSize(new Dimension(20, 50));
        panel.add(botaoa, BorderLayout.WEST);
        panel.add(botaob, BorderLayout.CENTER);
        panel.add(botaoc, BorderLayout.EAST);

        container.add(panel);
        Nivel nivel = new Nivel();
        nivel.setFase(1);
        JPanel panel2 = nivel;
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(600, 100));
        panel2.setMinimumSize(new Dimension(500, 100));
        container.add(panel2);
        getContentPane().add(container);
        revalidate();
        repaint();

        botaoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fase2();
            }
        });
        botaob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fase2();
            }
        });
        botaoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fase2();
            }
        });
    }

    public void fase2() { // Resposta B

        getContentPane().removeAll();

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        JButton botaoa = new JButton("A");
        JButton botaob = new JButton("B");
        JButton botaoc = new JButton("C");

        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(100, 40));
        panel.setMinimumSize(new Dimension(20, 50));
        panel.add(botaoa, BorderLayout.WEST);
        panel.add(botaob, BorderLayout.CENTER);
        panel.add(botaoc, BorderLayout.EAST);

        container.add(panel);
        Nivel nivel = new Nivel();
        nivel.setFase(2);
        JPanel panel2 = nivel;
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(600, 100));
        panel2.setMinimumSize(new Dimension(500, 100));
        container.add(panel2);
        getContentPane().add(container);
        revalidate();
        repaint();

        botaoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fase3();
            }
        });

        botaob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fase3();
            }
        });

        botaoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fase3();
            }
        });

    }

    public void fase3() { // Resposta B

        getContentPane().removeAll();

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        JButton botaoa = new JButton("A");
        JButton botaob = new JButton("B");
        JButton botaoc = new JButton("C");

        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(100, 40));
        panel.setMinimumSize(new Dimension(20, 50));
        panel.add(botaoa, BorderLayout.WEST);
        panel.add(botaob, BorderLayout.CENTER);
        panel.add(botaoc, BorderLayout.EAST);

        container.add(panel);
        Nivel nivel = new Nivel();
        nivel.setFase(3);
        JPanel panel2 = nivel;
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(600, 100));
        panel2.setMinimumSize(new Dimension(500, 100));
        container.add(panel2);
        getContentPane().add(container);
        revalidate();
        repaint();

        botaoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fase4();
            }
        });

        botaob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fase4();
            }
        });

        botaoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fase4();
            }
        });
    }

    public void fase4() { // Resposta C

        getContentPane().removeAll();

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        JButton botaoa = new JButton("A");
        JButton botaob = new JButton("B");
        JButton botaoc = new JButton("C");

        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(100, 40));
        panel.setMinimumSize(new Dimension(20, 50));
        panel.add(botaoa, BorderLayout.WEST);
        panel.add(botaob, BorderLayout.CENTER);
        panel.add(botaoc, BorderLayout.EAST);

        container.add(panel);
        Nivel nivel = new Nivel();
        nivel.setFase(4);
        JPanel panel2 = nivel;
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(600, 100));
        panel2.setMinimumSize(new Dimension(500, 100));
        container.add(panel2);
        getContentPane().add(container);
        revalidate();
        repaint();

        botaoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fase5();
            }
        });

        botaob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fase5();
            }
        });

        botaoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fase5();
            }
        });
    }

    public void fase5() { // Resposta C

        getContentPane().removeAll();

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        JButton botaoa = new JButton("A");
        JButton botaob = new JButton("B");
        JButton botaoc = new JButton("C");

        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(100, 40));
        panel.setMinimumSize(new Dimension(20, 50));
        panel.add(botaoa, BorderLayout.WEST);
        panel.add(botaob, BorderLayout.CENTER);
        panel.add(botaoc, BorderLayout.EAST);

        container.add(panel);
        Nivel nivel = new Nivel();
        nivel.setFase(5);
        JPanel panel2 = nivel;
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(600, 100));
        panel2.setMinimumSize(new Dimension(500, 100));
        container.add(panel2);
        getContentPane().add(container);
        revalidate();
        repaint();

        botaoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fase6();
            }
        });

        botaob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fase6();
            }
        });

        botaoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fase6();
            }
        });
    }

    public void fase6() { // Resposta B

        getContentPane().removeAll();

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        JButton botaoa = new JButton("A");
        JButton botaob = new JButton("B");
        JButton botaoc = new JButton("C");

        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(100, 40));
        panel.setMinimumSize(new Dimension(20, 50));
        panel.add(botaoa, BorderLayout.WEST);
        panel.add(botaob, BorderLayout.CENTER);
        panel.add(botaoc, BorderLayout.EAST);

        container.add(panel);
        Nivel nivel = new Nivel();
        nivel.setFase(6);
        JPanel panel2 = nivel;
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(600, 100));
        panel2.setMinimumSize(new Dimension(500, 100));
        container.add(panel2);
        getContentPane().add(container);
        revalidate();
        repaint();

        botaoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fase7();
            }
        });

        botaob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fase7();
            }
        });

        botaoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fase7();
            }
        });
    }

    public void fase7() { // Resposta C

        getContentPane().removeAll();

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        JButton botaoa = new JButton("A");
        JButton botaob = new JButton("B");
        JButton botaoc = new JButton("C");

        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(100, 40));
        panel.setMinimumSize(new Dimension(20, 50));
        panel.add(botaoa, BorderLayout.WEST);
        panel.add(botaob, BorderLayout.CENTER);
        panel.add(botaoc, BorderLayout.EAST);

        container.add(panel);
        Nivel nivel = new Nivel();
        nivel.setFase(7);
        JPanel panel2 = nivel;
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(600, 100));
        panel2.setMinimumSize(new Dimension(500, 100));
        container.add(panel2);
        getContentPane().add(container);
        revalidate();
        repaint();

        botaoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fase8();
            }
        });

        botaob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fase8();
            }
        });

        botaoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fase8();
            }
        });
    }

    public void fase8() { // Resposta C

        getContentPane().removeAll();

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        JButton botaoa = new JButton("A");
        JButton botaob = new JButton("B");
        JButton botaoc = new JButton("C");

        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(100, 40));
        panel.setMinimumSize(new Dimension(20, 50));
        panel.add(botaoa, BorderLayout.WEST);
        panel.add(botaob, BorderLayout.CENTER);
        panel.add(botaoc, BorderLayout.EAST);

        container.add(panel);
        Nivel nivel = new Nivel();
        nivel.setFase(8);
        JPanel panel2 = nivel;
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(600, 100));
        panel2.setMinimumSize(new Dimension(500, 100));
        container.add(panel2);
        getContentPane().add(container);
        revalidate();
        repaint();

        botaoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fimDeJogo();
            }
        });

        botaob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
                fimDeJogo();
            }
        });

        botaoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fimDeJogo();
            }
        });
    }

    public void fimDeJogo() {

        getContentPane().removeAll();

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();

        JLabel label = new JLabel("VOCÊ ACERTOU " + resultado + " DE 8 QUESTÕES - ");
        label.setBounds((this.getWidth() / 2) - 210, (this.getHeight() / 2) - 100, 420, 40);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label);

        JButton botao = new JButton("RECOMEÇAR");
        botao.setBounds((this.getWidth() / 2) - 60, (this.getHeight() / 2) - 25, 120, 40);
        botao.setFont(new Font("Arial", Font.BOLD, 12));
        panel.add(botao);

        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(100, 40));
        panel.setMinimumSize(new Dimension(20, 50));

        container.add(panel);
        Nivel nivel = new Nivel();
        nivel.setFase(9);
        JPanel panel2 = nivel;
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(600, 100));
        panel2.setMinimumSize(new Dimension(500, 100));
        container.add(panel2);
        getContentPane().add(container);
        revalidate();
        repaint();

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado = 8;
                fase1();
            }
        });
    }
}
