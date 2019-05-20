    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.telas;
import java.util.Scanner;
import src.br.ufsc.ine5605.controllers.BatalhaController;
import java.util.Date;
/**
 *
 * @author Joao
 */
public class TelaBatalha {
    BatalhaController batalhaControll;
    
 public void listarTarefas(){
     Scanner s = new Scanner(System.in);
        int input = 0;
        do {
            System.out.println(
                    "Selecione uma tarefa \n"
                    +" 1: Batalhar \n"
                    +" 2: Mostrar histórico batalhas \n"
                    +" 0: Sair"
            );
            
                    
            input = s.nextInt();
            
            
            switch (input){
                case 1:{
                    batalhaControll.batalhar();
                    break;
                }
                case 2:{
                    //Chama deleção de pokemon
                    break;
                }
            }
        } while (input > 0);
 }   
}
