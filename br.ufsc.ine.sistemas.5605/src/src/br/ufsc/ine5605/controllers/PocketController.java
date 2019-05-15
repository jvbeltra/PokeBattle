/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.controllers;

import java.util.List;
import src.br.ufsc.ine5605.objects.Pocket;
import src.br.ufsc.ine5605.telas.TelaPocket;

/**
 *
 * @author Joao
 */
public class PocketController {
    TelaPocket tela;
    public void capturaPokemon(){
        
    }
    
    public void soltarPokemon(){
        
    }
    
    public List<Pocket> listarPokemons(){
        return null;
    }
    
    public void getPokemonByName(String nome){
        
    }

    public void listarTarefas() {
        tela = new TelaPocket();
        tela.listarTarefas();
    }
}
