package comp_graf;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.GroupLayout.Group;

public class TelaPrincipal extends JFrame {
    ArrayList<Fase> fases = new ArrayList();
    Graphics g;
    private int resultado = 10; //Place Holder para o resultado final
    

    public Fase getfase(int i) {
        return fases.get(i);
    }

    public TelaPrincipal() {

        super("TESTE DE QI");
        
        fases.add(new Fase());
        fases.add(new Fase());
        fases.add(new Fase());
        fases.add(new Fase());
        fases.add(new Fase());
        fases.add(new Fase());
        fases.add(new Fase());
        fases.add(new Fase());
        fases.add(new Fase());
        fases.add(new Fase());

        JPanel panel = new JPanel();
        this.add(panel);
        JButton botao = new JButton("Começar");
        botao.setBounds(50, 50, 200, 200);
        panel.add(botao);

        this.setSize(1045,890);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

        botao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fase1();       //fase 1
            }
        });
    }

     public void fase1(){
        
        getContentPane().removeAll();
        
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        JPanel panel = new JPanel();
        JButton botaoa = new JButton("A");
        JButton botaob = new JButton("B");
        JButton botaoc = new JButton("C");
        
    
        panel.setLayout( new FlowLayout() );
        panel.setPreferredSize( new Dimension( 100, 100 ) );
        panel.setMinimumSize( new Dimension( 20, 50 ) );
        panel.add(botaoa, BorderLayout.WEST);      
        panel.add(botaob, BorderLayout.CENTER);
        panel.add(botaoc, BorderLayout.EAST);
        
        container.add(panel);
        Nivel nivel1= new Nivel();
        nivel1.setFase(1);
        JPanel panel2 = nivel1;
        panel2.setLayout( new BorderLayout() );
        panel2.setPreferredSize( new Dimension( 600, 100 ) );
        panel2.setMinimumSize( new Dimension( 500, 100 ) );
        container.add(panel2);      
        getContentPane().add(container);       
        revalidate();
        repaint();
       
        
        botaoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){     
                fase2();
            }
        });
        botaob.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                resultado -= 1;
                fase2();
            }
        });
        botaoc.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){             
                resultado -= 1;
                fase2();
            }
        });
    }
    public void fase2() {

        getContentPane().removeAll();

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        JButton botaoa = new JButton("A");
        JButton botaob = new JButton("B");
        JButton botaoc = new JButton("C");

        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setMinimumSize(new Dimension(20, 50));
        panel.add(botaoa, BorderLayout.WEST);
        panel.add(botaob, BorderLayout.CENTER);
        panel.add(botaoc, BorderLayout.EAST);

        container.add(panel);
        JPanel panel2 = new Nivel();
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(600, 100));
        panel2.setMinimumSize(new Dimension(500, 100));
        container.add(panel2);
        getContentPane().add(container);
        revalidate();
        repaint();

        botaob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fase3();
            }
        });
        
        botaoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultado -= 1;
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

    public void fase3() {

        getContentPane().removeAll();

        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));

        JPanel panel = new JPanel();
        JButton botaoa = new JButton("A");
        JButton botaob = new JButton("B");
        JButton botaoc = new JButton("C");

        panel.setLayout(new FlowLayout());
        panel.setPreferredSize(new Dimension(100, 100));
        panel.setMinimumSize(new Dimension(20, 50));
        panel.add(botaoa, BorderLayout.WEST);
        panel.add(botaob, BorderLayout.CENTER);
        panel.add(botaoc, BorderLayout.EAST);

        container.add(panel);
        JPanel panel2 = new Nivel();
        panel2.setLayout(new BorderLayout());
        panel2.setPreferredSize(new Dimension(600, 100));
        panel2.setMinimumSize(new Dimension(500, 100));
        container.add(panel2);
        getContentPane().add(container);
        revalidate();
        repaint();
        System.out.println("Resultado = "+resultado);
        botaoc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {              
                fase1();  // fase 1
            }
        });
        
        botaob.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {              
                resultado -= 1;
                fase1();  // fase 1
            }
        });
        
        botaoa.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {                
                resultado -= 1;            
                fase1();  // fase 1
            }
        });
    }
}
