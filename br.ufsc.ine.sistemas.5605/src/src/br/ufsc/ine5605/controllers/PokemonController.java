/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.controllers;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import src.br.ufsc.ine5605.exceptions.PokemonJahExisteException;
import src.br.ufsc.ine5605.exceptions.PokemonNaoExisteException;
import src.br.ufsc.ine5605.exceptions.ValorEhZeroException;
import src.br.ufsc.ine5605.exceptions.ValorInvalidoException;
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
        Pokemon pokemon1 = new Pokemon("Pikachu", "Principal", "Gosta de eletricidade", 8, 10, 8, 50, ETipo.GRAMA);
        Pokemon pokemon2 = new Pokemon("Bulbassauro", "Secundario", "Gosta de agua", 5, 8, 8, 50, ETipo.AGUA);
        Pokemon pokemon3 = new Pokemon("Charizard", "Terciario", "Gosta de fogo", 7, 9, 8, 50, ETipo.FOGO);
        PokemonDAO.getInstancia().put(pokemon1);
        PokemonDAO.getInstancia().put(pokemon2);
        PokemonDAO.getInstancia().put(pokemon3);
    }

    public static PokemonController getInstancia() {
        if (instancia == null) {
            instancia = new PokemonController();
        }
        return instancia;
    }

    public void addPokemon(String nome, String nick, String descricao, int velocidade, int ataque, int defesa, int vida, int escolhaTipo) throws PokemonJahExisteException {
        Scanner s = new Scanner(System.in);
        ETipo tipo = null;

        System.out.println(escolhaTipo);
        switch (escolhaTipo) {
            case 0:
                tipo = ETipo.AGUA;
                break;
            case 1:
                tipo = ETipo.GRAMA;
                break;
            case 2:
                tipo = ETipo.FOGO;
                break;

        }
        if (this.getPokemonByName(nome) != null) {
            throw new PokemonJahExisteException();
        }
        if (velocidade <= 0 || ataque <= 0 || defesa <= 0 || vida <= 0) {
            throw new ValorEhZeroException();
        }
        
        pokemon = new Pokemon(nome, nick, descricao, velocidade, ataque, defesa, vida, tipo);
        PokemonDAO.getInstancia().put(pokemon);

    }

    public void delPokemon(Pokemon pokemon) {
        try {
            if (pokemon == null) {
                throw new PokemonNaoExisteException();
            } else {
                
                PocketController.getInstancia().soltarPokemon(pokemon.getNome());
                PokemonDAO.getInstancia().remove(pokemon);
                
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public Pokemon getPokemonByName(String name) {
        return PokemonDAO.getInstancia().getPokemon(name);
    }
    
    public Pokemon getAleatorio(){
        Random pokemonAleatorio = new Random(); 
        return PokemonDAO.getInstancia().getList().get(pokemonAleatorio.nextInt(PokemonDAO.getInstancia().getList().size()));
    }

    public void listarTarefas() {
        tela = new TelaPokemon();
        tela.setVisible(true);

    }

    public void editarPokemon(String editado, String newNome, String nick, String descricao, int velocidade, int ataque, int defesa, int vida, int tipoIndex) throws PokemonJahExisteException {
        
        if (this.getPokemonByName(newNome) != null && !editado.equalsIgnoreCase(newNome)) {
                    throw new PokemonJahExisteException();
        }
        PokemonDAO.getInstancia().remove(this.getPokemonByName(editado));
        this.addPokemon(newNome, nick, descricao, velocidade, ataque, defesa, vida, tipoIndex);
//                case 4: {
//                    System.out.println("Insira um novo valor de ataque: ");
//                    int newAtaque = s.nextInt();
//                    myPokemon.setAtaque(newAtaque);
//                    break;
//                }
//                case 5: {
//                    System.out.println("Insira um novo valor de defesa: ");
//                    int newDefesa = s.nextInt();
//                    myPokemon.setDefesa(newDefesa);
//                    break;
//                }
//                case 6: {
//                    System.out.println("Insira uma nova vida: ");
//                    int newVida = s.nextInt();
//                    myPokemon.setVida(newVida);
//                    break;
//                }
//                case 7: {
//                    System.out.println("Insira uma nova velocidade: ");
//                    int newVelocidade = s.nextInt();
//                    myPokemon.setVelocidade(newVelocidade);
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//
//        }
    }
}
