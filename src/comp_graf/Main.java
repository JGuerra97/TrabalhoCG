package comp_graf;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

public class Main{
    
    public static void main(String[] args) {
        
        TelaPrincipal tela = new TelaPrincipal();

    }
    
}

/*
import java.awt.Graphics;
import javax.swing.*;

public class Main extends JPanel {

    @Override
    public void paint(Graphics g) {
        Poligono p = new Poligono(5, new int[]{25, 145, 25, 145, 85}, new int[]{25, 25, 145, 145, 85});
        p.desenhar(g);
        
        p.translacao(330, 0);
        p.desenhar(g);
        
        p.translacao(-165, 315);
        p.escalaGlobal(0.75, 0.25, p.vertices[4].x, p.vertices[4].y);
        p.desenhar(g);
        
        p.rotacao(90, p.vertices[4].x, p.vertices[4].y);
        p.desenhar(g);
    }
    
    public static void main(String[] args) {
        JFrame janela = new JFrame("Teste");
        janela.setVisible(true);
        janela.setSize(500, 500);
        janela.getContentPane().add(new Main());
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.setResizable(false);
    
}
}*/