/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.objects;

import java.io.Serializable;
import java.util.ArrayList;
import src.br.ufsc.ine5605.controllers.PocketController;
import src.br.ufsc.ine5605.exceptions.PokemonJahCapturadoException;
import src.br.ufsc.ine5605.exceptions.PokemonJahExisteException;
import src.br.ufsc.ine5605.exceptions.PokemonNaoCapturadoException;

/**
 *
 * @author Joao
 */
public class Pocket implements Serializable  {

    private ArrayList<Pokemon> pokemonsCapturados = new ArrayList<>();
 

    public void setPokemonsCapturados(ArrayList<Pokemon> pokemonsCapturados) {
        this.pokemonsCapturados = pokemonsCapturados;
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
        
        return pokemon.getNome();
    }

    public String delPokemon(Pokemon pokemon) throws PokemonNaoCapturadoException {
        try {
            for (Pokemon pokemonCap : pokemonsCapturados) {
                if (pokemonCap.getNome().equals(pokemon.getNome())) {
                    pokemonsCapturados.remove(pokemonCap);
                    return pokemon.getNome();
                }
            }
            throw new PokemonNaoCapturadoException();
        } catch (PokemonNaoCapturadoException e) {
            System.out.println(e.getMessage());
            return pokemon.getNome();
        }

    }
};
