/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.controllers;

import java.util.ArrayList;
import java.util.Scanner;
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

            pokemon = new Pokemon(nome, nick, descricao, velocidade, ataque, defesa, vida);
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
        
            System.out.println("-----------" + "\n Pokemon: " + pokemon.getNome() + "\n Descrição: " + pokemon.getDescricao() + "\n Ataque: "
                    + pokemon.getAtaque() + "\n Defesa: " + pokemon.getDefesa() + "\n Vida: " + pokemon.getVida() + "\n Velocidade: "
                    + pokemon.getVelocidade() + "\n ");
        
        });
        
    }

    public void listarTarefas() {
    
        tela = new TelaPokemon();
        tela.listarTarefas();
    
    }

    public void editarPokemon() {
        Scanner s = new Scanner(System.in);
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
        
        int toEdit = s.nextInt();
        switch(toEdit){
            //@todo implementar cases
        }
            
        
    }

}
