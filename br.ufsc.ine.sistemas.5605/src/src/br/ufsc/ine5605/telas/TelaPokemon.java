/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.telas;

import java.util.Scanner;
import src.br.ufsc.ine5605.controllers.PokemonController;
import src.br.ufsc.ine5605.exceptions.PokemonJahExisteException;
import src.br.ufsc.ine5605.exceptions.PokemonNaoExisteException;
import src.br.ufsc.ine5605.exceptions.TipoNaoExisteException;
import src.br.ufsc.ine5605.exceptions.ValorEhZeroException;
import src.br.ufsc.ine5605.objects.Pokemon;

/**
 *
 * @author Joao
 */
public class TelaPokemon {

    private PokemonController pokemonControll;
    private Scanner teclado = new Scanner(System.in);

    public TelaPokemon(PokemonController pokemonControll) {
        this.pokemonControll = pokemonControll;
    }

    public void listarTarefas() {
        Scanner s = new Scanner(System.in);
        int input;
        try {
            do {
                System.out.println(
                        "\n --- Selecione uma tarefa --- \n"
                        + " 1: Cadastrar Pokemon \n"
                        + " 2: Deletar Pokemon \n"
                        + " 3: Editar Pokemon \n"
                        + " 4: Listar Pokemons \n"
                        + " 5: Buscar Pokemon pelo nome \n"
                        + " 0: Sair \n"
                );

                input = teclado.nextInt();

                switch (input) {
                    case 1: {
                        this.listarAdicao();
                        break;
                    }
                    case 2: {
                        pokemonControll.delPokemon();
                        break;
                    }
                    case 3: {

                        this.listarEdicao();
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
        } catch (Exception e) {
            if (e.toString().equals("java.util.InputMismatchException")) {
                System.out.println("Insira um valor inteiro para selecionar a tarefa.");
            }
        }
    }

    public void listarAdicao() {
        Scanner s = new Scanner(System.in);
        try {
            System.out.println("Insira o nome do novo Pokemon: ");
            String nome = s.nextLine();

            if (pokemonControll.getPokemonByName(nome) != null) {
                throw new PokemonJahExisteException();
            }

            System.out.println("Insira o apelido: ");
            String nick = s.nextLine();

            System.out.println("Faça uma descrição do novo Pokemon");
            String descricao = s.nextLine();

            System.out.println("Insira a velocidade do novo Pokemon: ");
            int velocidade = s.nextInt();
            if (velocidade <= 0) {
                throw new ValorEhZeroException();
            }

            System.out.println("Insira o ataque do novo Pokemon");
            int ataque = s.nextInt();

            if (ataque <= 0) {
                throw new ValorEhZeroException();
            }

            System.out.println("Insira a defesa do novo Pokemon");
            int defesa = s.nextInt();

            if (defesa <= 0) {
                throw new ValorEhZeroException();
            }

            System.out.println("Insira o valor de vida do novo Pokemon");
            int vida = s.nextInt();
            if (vida <= 0) {
                throw new ValorEhZeroException();
            }

            int escolhaTipo = 0;

            System.out.println("Escolha o tipo\n"
                    + "1: Tipo Agua\n"
                    + "2: Tipo Fogo\n"
                    + "3: Tipo Grama\n"
            );

            escolhaTipo = s.nextInt();

            if (escolhaTipo < 1 || escolhaTipo > 3) {
                throw new TipoNaoExisteException();
            }
            pokemonControll.addPokemon(nome, nick, descricao, velocidade, ataque, defesa, vida, escolhaTipo);

        } catch (Exception e) {
            if (e.toString().equals("java.util.InputMismatchException")) {
                System.out.println("Tipo de atributo não permitido.");
            } else {
                System.out.println(e.getMessage());
            }
        }
    }

    public void listarEdicao() {
        Scanner s = new Scanner(System.in);
        int toEdit;
        try {
            System.out.println("Insira o nome do Pokemon que você deseja editar.");
            String pokemonName = s.nextLine();
            if (pokemonControll.getPokemonByName(pokemonName) == null) {
                throw new PokemonNaoExisteException();
            }

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
            } else {
                this.listarTarefas();
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
