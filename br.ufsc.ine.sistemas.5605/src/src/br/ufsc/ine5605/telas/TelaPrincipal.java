/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.telas;

import java.util.Scanner;
import src.br.ufsc.ine5605.controllers.PrincipalController;

/**
 *
 * @author Joao
 */
public class TelaPrincipal {
    private PrincipalController principalControll; 
    private Scanner teclado = new Scanner(System.in);

    public TelaPrincipal(PrincipalController principalControll) {
        this.principalControll = principalControll;
    }
    
    
    
    public void listarTarefas() {
        
        int input = 0;
        do {
            System.out.println(
                    "\n --- Selecione uma tarefa ---\n"
                    + " 1: Gerenciar Pokemons \n"
                    + " 2: Gerenciar Pocket \n"
                    + " 3: Gerenciar Batalhas\n"
                    +" 0: Sair \n"
            );
            
                    
            input = teclado.nextInt();
            
            
            switch (input){
                case 1:{
                    principalControll.acessaPokemon().listarTarefas();
                    break;
                }
                case 2:{
                    principalControll.acessaPocket().listarTarefas();
                    break;
                }
                case 3:{
                    
                    principalControll.acessaCampoBatalha().listarTarefas();
                    break;
                }
               
            }
        } while (input > 0);

    }
}
