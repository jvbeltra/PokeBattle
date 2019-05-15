/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.telas;

import java.util.Scanner;
import src.br.ufsc.ine5605.controllers.PokemonController;

/**
 *
 * @author Joao
 */
public class TelaPokemon {
    PokemonController pokemonControll;
    
    public void listarTarefas(){
        pokemonControll = new PokemonController();
        Scanner s = new Scanner(System.in);
        int input;
        do {
            System.out.println(
                    "Selecione uma tarefa \n"
                    + " 1: Cadastrar Pokemon \n" 
                    + " 2: Deletar Pokemon \n"
                    + " 3: Editar Pokemon \n"
                    + " 4: Listar Pokemons \n"
                    + " 5: Buscar Pokemon pelo nome \n"
                    +" 0: Sair \n"
            );
            
                    
            input = s.nextInt();
            
            
            switch (input){
                case 1:{
                    pokemonControll.addPokemon();
                    break;
                }
                case 2:{
                    pokemonControll.delPokemon();
                    break;
                }
                case 3:{
                    pokemonControll.editarPokemon();
                    //Chama edição de pokemon
                    break;
                }
                case 4:{
                    pokemonControll.listarPokemons();
                    break;
                }
                case 5:{
                    System.out.println("Insira o nome do Pokemon desejado");
                    String nome = s.next();
                    pokemonControll.getPokemonByName(nome);
                    break;
                }
            }
        } while (input > 0);
    }
}
