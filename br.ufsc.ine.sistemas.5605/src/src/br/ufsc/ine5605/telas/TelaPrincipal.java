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
    
    public void listarTarefas() {
        principalControll = new PrincipalController();
        Scanner s = new Scanner(System.in);
        int input = 0;
        do {
            System.out.println(
                    "Selecione uma tarefa \n"
                    + " 1: Gerenciar Pokemons \n"
                    + " 2: Gerenciar Pocket \n"
                    + " 3: Gerenciar Batalhas\n"
                    +" 0: Sair \n"
            ); 
            
                    
            input = s.nextInt();
            
            
            switch (input){
                case 1:{
                    
                    principalControll.acessaPokemon();
                    break;
                }
                case 2:{
                    principalControll.acessaPocket();
                    break;
                }
                case 3:{
                    
                    principalControll.acessaCampoBatalha();
                    break;
                }
               
            }
        } while (input > 0);

    }
}