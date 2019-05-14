/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.controllers;

import java.util.List;
import src.br.ufsc.ine5605.objects.Pokemon;
import src.br.ufsc.ine5605.telas.TelaPokemon;

/**
 *
 * @author Joao
 */
public class PokemonController {
    
    private TelaPokemon tela = new TelaPokemon();

    public PokemonController() {
    }
    
    
    
    public void addPokemon(){
        
    }
    
    public void delPokemon(){
        
    }
    
    public Pokemon getPokemonByName(String name){
        return null;
    }
    public int calcularVida(Pokemon pokemon){
        return 0;
    }
    
    public List<Pokemon> listarPokemons(){
        return null;
    }

    public void listarTarefas() {
       tela.listarTarefas();
    }

    public void editarPokemon() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
