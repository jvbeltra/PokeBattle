/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.objects;

import java.util.List;
import src.br.ufsc.ine5605.controllers.PocketController;
/**
 *
 * @author Joao
 */
public class Pocket {
 private List<Pokemon> pokemonsCapturados;
 private int vitoriasPocket;
 private int derrotasPocket;

    public Pocket(List<Pokemon> pokemonsCapturados, int vitoriasPocket, int derrotasPocket) {
        this.pokemonsCapturados = pokemonsCapturados;
        this.vitoriasPocket = vitoriasPocket;
        this.derrotasPocket = derrotasPocket;
    }

    public Pocket() {
    }

    public List<Pokemon> getPokemonsCapturados() {
        return pokemonsCapturados;
    }

    public void setPokemonsCapturados(List<Pokemon> pokemonsCapturados) {
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
 
    public void addPokemon(Pokemon pokemon){
        
    }
    
    public void delPokemon(Pokemon pokemon){
        
    }
};