/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.controllers;

/**
 *
 * @author Joao
 */

import src.br.ufsc.ine5605.telas.TelaPrincipal;
import src.br.ufsc.ine5605.controllers.*;

public class PrincipalController {

    private PocketController pocketControll;
    BatalhaController batalhaControll;
    PokemonController pokemonControll;
    TipoController tipoControll;
    TelaPrincipal telaPrincipal;
    
    public PrincipalController(PocketController pocketControll, BatalhaController batalhaControll, PokemonController pokemonControll, TipoController tipoControll, TelaPrincipal telaPrincipal) {
        this.pocketControll = pocketControll;
        this.batalhaControll = batalhaControll;
        this.pokemonControll = pokemonControll;
        this.tipoControll = tipoControll;
        this.telaPrincipal = telaPrincipal;
    }

    public PocketController acessaPocket() {
        return pocketControll = new PocketController();
        
    }

    public PokemonController acessaPokemon() {
        return pokemonControll = new PokemonController();
    }

    public BatalhaController acessaCampoBatalha() {
        return batalhaControll;
        
    }

    public void acessaTipo() {
        //
    }

    public void listarTarefas() {
        telaPrincipal = new TelaPrincipal(this);
        telaPrincipal.listarTarefas();
    }
}
