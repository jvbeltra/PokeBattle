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

    PocketController pocketControll;
    BatalhaController batalhaControll;
    PokemonController pokemonControll;
    TipoController tipoControll;
    TelaPrincipal telaPrincipal;

    public void acessaPocket() {
        pocketControll = new PocketController();
        pocketControll.listarTarefas();
    }

    public void acessaPokemon() {
        pokemonControll = new PokemonController();
        pokemonControll.listarTarefas();
    }

    public void acessaCampoBatalha() {
        batalhaControll = new BatalhaController();
        batalhaControll.listarTarefas();
    }

    public void acessaTipo() {
        //
    }

    public void listarTarefas() {
        telaPrincipal = new TelaPrincipal();
        telaPrincipal.listarTarefas();
    }
}
