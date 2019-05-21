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
    private Scanner teclado = new Scanner(System.in);

    public TelaPocket(PocketController pocketControll){
        this.pocketControll = pocketControll;
    }
    
    public void listarTarefas(){    
        int input = 0;
        do {
            System.out.println(
                    "\n --- Selecione uma tarefa --- \n"
                    + " 1: Capturar Pokemon \n"
                    + " 2: Soltar Pokemon \n"
                    + " 3: Listar Pocket \n"
                    + " 0: Sair"
            );
            
                    
            input = teclado.nextInt();
            
            
            switch (input){
                case 1:{
                    pocketControll.capturaPokemon();
                    break;
                }
                case 2:{
                    pocketControll.soltarPokemon();
                    break;
                }
                case 3:{
                    pocketControll.listarPokemons();
                    break;
                }
                
            }
        } while (input > 0 && input<4);
    }
}
