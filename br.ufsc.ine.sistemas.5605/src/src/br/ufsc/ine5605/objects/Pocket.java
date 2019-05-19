/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.objects;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import src.br.ufsc.ine5605.controllers.PocketController;
import src.br.ufsc.ine5605.objects.Pokemon;
/**
 *
 * @author Joao
 */
public class Pocket {
 private ArrayList<Pokemon> pokemonsCapturados = new ArrayList<>();
 private int vitoriasPocket;
 private int derrotasPocket;
 private PocketController pocketControll;

    public void getPokemonsCapturados() {
          pokemonsCapturados.forEach((pokemon) -> {
            System.out.println("\n Pokemon: " + pokemon.getNome() + "\n Descrição: " + pokemon.getDescricao() +
                     "\n Ataque: " + pokemon.getAtaque() + "\n Defesa: " + pokemon.getDefesa() + "\n Vida: " + pokemon.getVida() + "\n Velocidade: "
                    + pokemon.getVelocidade() + "\n " + "-----------");

        });

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
 
    public void addPokemon(Pokemon pokemon){
        System.out.println("adicionou o pokemon ");
        System.out.println(pokemon.getNome());
        System.out.println(pokemon.getDefesa());
        pokemonsCapturados.add(pokemon);
        
        this.getPokemonsCapturados();
//        if (pokemon != null){
//          //try  
//            for (Pokemon auxPokemon : pokemonsCapturados){
//                if (auxPokemon == pokemon){
//                    //throw exception
//                    System.out.println("Pokemon já capturado. ");     
//                    break;
//                }
//            }
//            
            
            
        }
    
    public void delPokemon(Pokemon pokemon){
        if (pokemon != null) {
            for (Pokemon pokemonInside : pokemonsCapturados) {
                if (pokemonInside == pokemon){
                    System.out.println("Pokemon já existe");
                    //throw exception
                }
            }
            try {
                pokemonsCapturados.remove(pokemon);
                System.out.println("Pokemon deletado com sucesso!");
            } catch (Exception e) {
                System.out.println("Algo de errado aconteceu");
            }
        }
    }
};