/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.objects;

import java.util.ArrayList;
import src.br.ufsc.ine5605.controllers.PocketController;
import src.br.ufsc.ine5605.exceptions.PocketVaziaException;
import src.br.ufsc.ine5605.exceptions.PokemonJahCapturadoException;
import src.br.ufsc.ine5605.exceptions.PokemonJahExisteException;
import src.br.ufsc.ine5605.exceptions.PokemonNaoCapturadoException;

/**
 *
 * @author Joao
 */
public class Pocket {

    private ArrayList<Pokemon> pokemonsCapturados = new ArrayList<>();
    private int vitoriasPocket;
    private int derrotasPocket;
    private PocketController pocketControll;

    public void getPokemonsCapturados() throws PocketVaziaException {

        try {
            if (pokemonsCapturados.size() > 0) {
                System.out.println("-----------");
                pokemonsCapturados.forEach((pokemon) -> {
                    System.out.println("\n Pokemon: " + pokemon.getNome() + "\n Descrição: " + pokemon.getDescricao()
                            + "\n Ataque: " + pokemon.getAtaque() + "\n Defesa: " + pokemon.getDefesa() + "\n Vida: " + pokemon.getVida() + "\n Velocidade: "
                            + pokemon.getVelocidade() + "\n " + "-----------");

                });
            } else {
                throw new PocketVaziaException();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    public void setPokemonsCapturados(ArrayList<Pokemon> pokemonsCapturados) {
        this.pokemonsCapturados = pokemonsCapturados;
    }

    public int getVitoriasPocket() {
        return vitoriasPocket;
    }

    public void setVitoriasPocket(int vitoriasPocket) {
        this.vitoriasPocket = vitoriasPocket;
    }

    public int getDerrotasPocket() {
        return derrotasPocket;
    }

    public void setDerrotasPocket(int derrotasPocket) {
        this.derrotasPocket = derrotasPocket;
    }

    public String addPokemon(Pokemon pokemon) throws PokemonJahCapturadoException {

        for (Pokemon pokemonCap : pokemonsCapturados) {
            try {
                if (pokemonCap.getNome().equals(pokemon.getNome())) {
                    throw new PokemonJahCapturadoException();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return e.getMessage();
            }
        }
        pokemonsCapturados.add(pokemon);
        System.out.println("\n" + pokemon.getNome() + " capturado!");
        return "\n Pokemon " + pokemon.getNome() + " capturado!";
    }

    public String delPokemon(Pokemon pokemon) throws PokemonNaoCapturadoException {
        try {
        for (Pokemon pokemonCap : pokemonsCapturados) {
            if (pokemonCap.getNome().equals(pokemon.getNome())) {
                System.out.println("\n" + pokemon.getNome() + " foi solto!");
                pokemonsCapturados.remove(pokemonCap);
                return pokemon.getNome();
            }
        }
        throw new PokemonNaoCapturadoException();
        } catch(PokemonNaoCapturadoException e){
            System.out.println(e.getMessage());
            return pokemon.getNome();
        }
       
        
    }
};
