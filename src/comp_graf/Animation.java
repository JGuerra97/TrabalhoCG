
package comp_graf;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;



public  class Animation extends JPanel implements ActionListener {
    
    Timer tm = new Timer(90, this);
    int j= 1;
    int v;
    int[] x1  = new int[100];
    int[] y1 = new int[100];
    int[] z1= new int[100];
    
    Tuple3d[] resultadoBezier;
    
   
    Objeto3DAviao aviao = new Objeto3DAviao();
    
    Tuple3d[] pontosBezier = new Tuple3d[4] ;
    
    public Animation(Tuple3d[] pontosBezier){
        this.pontosBezier= pontosBezier;
        CurvaBezier curva = new CurvaBezier();
        double t = 0.01;   //Definição do parâmetro da curva

        /*for(int k = 0; k<4; k++){
            System.out.println(" x  %2f "+ pontosBezier[k].getX());
            System.out.println(" y %2f "+ pontosBezier[k].getY());
            System.out.println(" z %2f "+ pontosBezier[k].getZ());
        }*/
        resultadoBezier = curva.getCurvePoints(pontosBezier, t);  //Envio dos pontos definidos pelo usuário e retorno dos pontos a ser desenhados em um vetor de Tuple3D

        for (int i = 0; i < (1 / t) - 1; i++) {
               x1[i]= (int) resultadoBezier[i].x;
               y1[i] = (int) resultadoBezier[i].y;

               System.out.println("x1 " + (int) resultadoBezier[i + 1].x);
               System.out.println("y1 "+ (int) resultadoBezier[i + 1].y);
               
                

              //System.out.println(" to aqui 1 : " + i);


        }
        aviao.translacao(x1[0],y1[0] , 0);
        
       /*new Timer(20, new ActionListener(){
                   @Override
                   public void actionPerformed(ActionEvent e){
                            j +=j;
                            repaint();
                           
                    }
                }).start();*/
      tm.start();
    
    }
    
    
    
    @Override
    public void paint(Graphics g){
        g.clearRect(0, 0, getWidth(),getWidth() );
      
        System.out.println(" to aqui 1 :  " + j);
        
        for(int i = 0 ; i<99; i++){
            g.drawLine((int) resultadoBezier[i].x,(int) resultadoBezier[i].y,  (int) resultadoBezier[i + 1].x, (int) resultadoBezier[i + 1].y); 
        }
      //  System.out.println("to aqui 2: "+(int) resultadoBezier[j].x );
      //  System.out.println("to aqui 2: "+(int) resultadoBezier[j].y );
        
       aviao.desenhar(g);
       aviao.translacao(x1[j]- x1[j-1], y1[j]- y1[j-1], 0);
        
       
       
    }
    
    
        
   
  
    @Override
    public void actionPerformed(ActionEvent e){
        if(j<99){
            j = j+1;

            repaint();
        }
    }
        
    
}
