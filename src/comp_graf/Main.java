package comp_graf;

import java.util.Scanner;

public class Main{
    
    public static void main(String[] args) {
        
        System.out.println("1 - animacao, 2 - testes");
        Scanner teclado = new Scanner(System.in);
        int numero = teclado.nextInt();
        if (numero == 1){
            System.out.println(" 1- bezier , 2- quaternio");
            numero = teclado.nextInt();
            if(numero == 1 ){
                Tela2  tela2 = new Tela2();
            }  else if(numero == 2){
                Tela3 tela3 = new Tela3();
            }
            
        } else if (numero ==2){
        
            TelaPrincipal tela = new TelaPrincipal();
        }

    }
    
}
