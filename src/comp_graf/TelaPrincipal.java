package comp_graf;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.GridLayout;
import javax.swing.GroupLayout.Group;


public class TelaPrincipal extends JFrame{
    
  

    public TelaPrincipal(){
    
        super("TESTE DE QI");
       
         
        JPanel panel = new JPanel();
        this.add(panel);
        JButton botao = new JButton("Começar");
        botao.setBounds(50, 50, 200, 200);
        panel.add(botao);
        
        this.setSize(500, 800);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        

        
        botao.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                fase1();
            }
        });
  
    }
    
    public void fase1(){
        
        getContentPane().removeAll();
        
        JPanel container = new JPanel();
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        
        JPanel panel = new JPanel();
        JButton botaoa = new JButton("A1");
        JButton botaob = new JButton("B");
        JButton botaoc = new JButton("C");
        
        panel.setLayout( new FlowLayout() );
        panel.setPreferredSize( new Dimension( 100, 100 ) );
        panel.setMinimumSize( new Dimension( 20, 50 ) );
        panel.add(botaoa, BorderLayout.WEST);      
        panel.add(botaob, BorderLayout.CENTER);
        panel.add(botaoc, BorderLayout.EAST);
        
        container.add(panel);
        JPanel panel2 = new Nivel();
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
        
        
    }
    public void fase2(){
        
        getContentPane().removeAll();
        
        JPanel panel = new JPanel();
        JButton botaoa = new JButton("A2");
        JButton botaob = new JButton("B");
        JButton botaoc = new JButton("C");
        
    
        panel.add(botaoa);
        panel.add(botaob);
        panel.add(botaoc);
        getContentPane().add(panel);
        revalidate();
        repaint();
        
        botaoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                fase3();
            }
        });
        
        
    }
    public void fase3(){
        
        getContentPane().removeAll();
       
        JPanel panel = new JPanel();
        JButton botaoa = new JButton("A3");
        JButton botaob = new JButton("B");
        JButton botaoc = new JButton("C");
        
        
        getContentPane().add(panel);
        panel.add(botaoa);
        panel.add(botaob);
        panel.add(botaoc);
        getContentPane().add(panel);
        revalidate();
        repaint();
        
        botaoa.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                fase1();
            }
        });      
    }
}