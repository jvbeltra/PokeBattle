/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.controllers;

import java.util.ArrayList;
import java.util.Scanner;
import src.br.ufsc.ine5605.exceptions.PokemonJahExisteException;
import src.br.ufsc.ine5605.exceptions.PokemonNaoExisteException;
import src.br.ufsc.ine5605.objects.ETipo;
import src.br.ufsc.ine5605.objects.Pokemon;
import src.br.ufsc.ine5605.persistencia.PokemonDAO;
import src.br.ufsc.ine5605.telas.TelaPokemon;

/**
 *
 * @author Joao
 */
public class PokemonController {

    private ArrayList<Pokemon> pokemons = new ArrayList<>();
    private TelaPokemon tela;
    private Pokemon pokemon;
    private PrincipalController principalControll;

    private static PokemonController instancia;

    public PokemonController() {
        this.principalControll = principalControll;
        Pokemon pokemon1 = new Pokemon("Pikachu", "Principal", "Gosta de eletricidade", 8, 10, 8, 50, ETipo.GRAMA);
        Pokemon pokemon2 = new Pokemon("Bulbassauro", "Secundario", "Gosta de agua", 5, 8, 8, 50, ETipo.AGUA);
        Pokemon pokemon3 = new Pokemon("Charizard", "Terciario", "Gosta de fogo", 7, 9, 8, 50, ETipo.FOGO);
//        pokemons.add(pokemon1);
//        pokemons.add(pokemon2);
//        pokemons.add(pokemon3);
    }

    static PokemonController getInstancia() {
        if (instancia == null) {
            instancia = new PokemonController();
        }
        return instancia;
    }

    public void addPokemon(String nome, String nick, String descricao, int velocidade, int ataque, int defesa, int vida, int escolhaTipo) throws PokemonJahExisteException {
        Scanner s = new Scanner(System.in);
        ETipo tipo = null;
        switch (escolhaTipo) {
            case 1:
                tipo = ETipo.AGUA;
                break;
            case 2:
                tipo = ETipo.FOGO;
                break;
            case 3:
                tipo = ETipo.GRAMA;
                break;

        }
        if (this.getPokemonByName(nome) != null) {
            throw new PokemonJahExisteException();
        } else {
            pokemon = new Pokemon(nome, nick, descricao, velocidade, ataque, defesa, vida, tipo);
            PokemonDAO.getInstancia().put(pokemon);
        }
    }

    public void delPokemon() {
        Scanner s = new Scanner(System.in);

        try {
            
            System.out.println("Insira o nome do Pokemon que você deseja excluir");
            String nome = s.nextLine();
            if (this.getPokemonByName(nome) == null) {
                throw new PokemonNaoExisteException();
            }

            Pokemon pokemonToRemove = this.getPokemonByName(nome);

            if (pokemonToRemove != null) {
                PokemonDAO.getInstancia().remove(pokemonToRemove);
                System.out.println("Pokemon deletado com sucesso!");
            }
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Pokemon getPokemonByName(String name) {
        return PokemonDAO.getInstancia().getPokemon(name);
    }

    public void listarPokemons() {
        System.out.println(" -----------");
//        pokemon.forEach((pokemon) -> {
//            ETipo tipo = pokemon.getTipo();
//            String tipoString = tipo.tipo();
//
//            System.out.println(" Pokemon: " + pokemon.getNome() + "\n Descrição: " + pokemon.getDescricao()
//                    + "\n Tipo: " + tipoString + "\n Ataque: " + pokemon.getAtaque() + "\n Defesa: " + pokemon.getDefesa() + "\n Vida: " + pokemon.getVida() + "\n Velocidade: "
//                    + pokemon.getVelocidade() + "\n -----------");
//
//        });

    }

    public void listarTarefas() {
        tela = new TelaPokemon();
        tela.setVisible(true);

    }

    public void editarPokemon(int toEdit, String pokemonName) throws PokemonJahExisteException {

        Scanner s = new Scanner(System.in);
        Pokemon myPokemon = this.getPokemonByName(pokemonName);
        try {
            switch (toEdit) {
                case 1: {
                    System.out.println("Insira um novo nome: ");
                    String newNome = s.nextLine();
                    if (PokemonDAO.getInstancia().getPokemon(newNome) != null) {
                        throw new PokemonJahExisteException();
                    }
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
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }
}
