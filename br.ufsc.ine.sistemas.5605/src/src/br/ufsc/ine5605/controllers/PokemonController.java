/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.controllers;

import java.util.ArrayList;
import java.util.Scanner;
import src.br.ufsc.ine5605.objects.ETipo;
import src.br.ufsc.ine5605.objects.Pokemon;
import src.br.ufsc.ine5605.telas.TelaPokemon;

/**
 *
 * @author Joao
 */
public class PokemonController {

    private TelaPokemon tela;
    private Pokemon pokemon;
    private ArrayList<Pokemon> pokemons = new ArrayList<>();

    public PokemonController() {

    }

    public void addPokemon() {
        Scanner s = new Scanner(System.in);

        try {
            System.out.println("Insira o nome do novo Pokemon: ");
            String nome = s.nextLine();

            System.out.println("Insira o apelido: ");
            String nick = s.nextLine();

            System.out.println("Faça uma descrição do novo Pokemon");
            String descricao = s.nextLine();

            System.out.println("Insira a velocidade do novo Pokemon: ");
            int velocidade = s.nextInt();

            System.out.println("Insira o ataque do novo Pokemon");
            int ataque = s.nextInt();

            System.out.println("Insira a defesa do novo Pokemon");
            int defesa = s.nextInt();

            System.out.println("Insira o valor de vida do novo Pokemon");
            int vida = s.nextInt();
            
            System.out.println("Escolha o tipo");
            ETipo tipo = s.;

            pokemon = new Pokemon(nome, nick, descricao, velocidade, ataque, defesa, vida, tipo);
            pokemons.add(pokemon);

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void delPokemon() {

        Scanner s = new Scanner(System.in);

        System.out.println("Insira o nome do Pokemon que você deseja excluir");
        String nome = s.nextLine();
        Pokemon pokemonToRemove = this.getPokemonByName(nome);
        if (pokemonToRemove != null) {
            try {
                pokemons.remove(pokemonToRemove);
                System.out.println("Pokemon deletado com sucesso!");
            } catch (Exception e) {
                System.out.println("Algo de errado aconteceu");
            }
        }

    }

    public Pokemon getPokemonByName(String name) {

        for (Pokemon pokemon : pokemons) {
            if (pokemon.getNome().equalsIgnoreCase(name)) {
                return pokemon;
            }
        }
        return null;

    }

    public int calcularVida(Pokemon pokemon) {
        return 0;
    }

    public void listarPokemons() {

        pokemons.forEach((pokemon) -> {

            System.out.println("\n Pokemon: " + pokemon.getNome() + "\n Descrição: " + pokemon.getDescricao() + "\n Ataque: "
                    + pokemon.getAtaque() + "\n Defesa: " + pokemon.getDefesa() + "\n Vida: " + pokemon.getVida() + "\n Velocidade: "
                    + pokemon.getVelocidade() + "\n " + "-----------");

        });

    }

    public void listarTarefas() {

        tela = new TelaPokemon();
        tela.listarTarefas();

    }

    public void editarPokemon(int toEdit, String pokemonName) {

        Scanner s = new Scanner(System.in);
        Pokemon myPokemon = this.getPokemonByName(pokemonName);
        System.out.println("Nome ->" + myPokemon.getNome());
        
        switch (toEdit) {
            case 1: {
                System.out.println("Insira um novo nome: ");
                String newNome = s.nextLine();
                myPokemon.setNome(newNome);
                break;
            }
            case 2: {
                System.out.println("Insira um novo nick: ");
                String newNick = s.nextLine();
                myPokemon.setNick(newNick);
                break;
            }
            case 3: {
                System.out.println("Insira uma nova descrição: ");
                String newDescricao = s.nextLine();
                myPokemon.setDescricao(newDescricao);
                break;
            }
            case 4: {
                System.out.println("Insira um novo valor de ataque: ");
                int newAtaque = s.nextInt();
                myPokemon.setAtaque(newAtaque);
                break;
            }
            case 5: {
                System.out.println("Insira um novo valor de defesa: ");
                int newDefesa = s.nextInt();
                myPokemon.setDefesa(newDefesa);
                break;
            }
            case 6: {
                System.out.println("Insira uma nova vida: ");
                int newVida = s.nextInt();
                myPokemon.setVida(newVida);
                break;
            }
            case 7: {
                System.out.println("Insira uma nova velocidade: ");
                int newVelocidade = s.nextInt();
                myPokemon.setVelocidade(newVelocidade);

                break;
            }
        }

    }
}
