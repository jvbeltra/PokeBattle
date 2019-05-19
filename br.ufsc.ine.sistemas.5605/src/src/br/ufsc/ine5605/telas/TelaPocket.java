/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.telas;

import java.util.Scanner;
import src.br.ufsc.ine5605.controllers.PocketController;

/**
 *
 * @author Joao
 */
public class TelaPocket {
    private PocketController pocketControll;
    
    public TelaPocket(PocketController pocketControll){
        this.pocketControll = pocketControll;
    }
    
    public void listarTarefas(){    
        Scanner s = new Scanner(System.in);
        int input = 0;
        do {
            System.out.println(
                    "Selecione uma tarefa \n"
                    + " 1: Capturar Pokemon"
                    + " 2: Soltar Pokemon \n"
                    + " 3: Listar Pocket \n"
                    + " 4: Detalhes Pocket \n"
                    + " 0: Sair"
            );
            
                    
            input = s.nextInt();
            
            
            switch (input){
                case 1:{
                    pocketControll.capturaPokemon();
                    break;
                }
                case 2:{
                    //Chama deleção de pokemon
                    break;
                }
                case 3:{
                    pocketControll.listarPokemons()
                    break;
                }
                case 4:{
                    
                    //Chama listagem de pokemon
                    break;
                    
                }
            }
        } while (input > 0);
    }
}
