/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.telas;

import java.util.Scanner;
import src.br.ufsc.ine5605.controllers.PokemonController;
import src.br.ufsc.ine5605.objects.Pokemon;

/**
 *
 * @author Joao
 */
public class TelaPokemon {

    PokemonController pokemonControll;
    
    public TelaPokemon(PokemonController pokemonControll) {
        this.pokemonControll = pokemonControll;
    }
    public void listarTarefas() {
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
                    + " 0: Sair \n"
            );

            input = s.nextInt();

            switch (input) {
                case 1: {
                    pokemonControll.addPokemon();
                    break;
                }
                case 2: {
                    pokemonControll.delPokemon();
                    break;
                }
                case 3: {

                    this.listarEdicao();
                    //Chama edição de pokemon
                    break;
                }
                case 4: {
                    pokemonControll.listarPokemons();
                    break;
                }
                case 5: {
                    System.out.println("Insira o nome do Pokemon desejado");
                    String nome = s.next();
                    System.out.println(pokemonControll.getPokemonByName(nome));
                    break;
                }
            }
        } while (input > 0);
    }

    public void listarEdicao() {
        
        Scanner s = new Scanner(System.in);
        int toEdit;

        System.out.println("Insira o nome do Pokemon que você deseja editar. Para cancelar, digite 0:  ");
        String pokemonName = s.nextLine();

        System.out.println("Qual componente você deseja editar? ");
        System.out.println("1: Nome ");
        System.out.println("2: Nick ");
        System.out.println("3: Descrição ");
        System.out.println("4: Ataque ");
        System.out.println("5: Defesa ");
        System.out.println("6: Vida ");
        System.out.println("7: Velocidade ");
        System.out.println("8: Voltar");
        System.out.println("0: Sair");

        toEdit = s.nextInt();

        if (toEdit > 0 && toEdit < 8) {
            pokemonControll.editarPokemon(toEdit, pokemonName);
        }

        if (toEdit == 8 || pokemonName.equals('0')) {
            this.listarTarefas();
        }

    }
}
