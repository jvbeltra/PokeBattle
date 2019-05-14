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
import src.br.ufsc.ine5605.controllers.PocketController;
import src.br.ufsc.ine5605.controllers.PokemonController;
import src.br.ufsc.ine5605.controllers.TipoController;

public class PrincipalController {
    PocketController pocketControll = new PocketController();
    BatalhaController batalhaControll = new BatalhaController();
    PokemonController pokemonControll = new PokemonController();
    TipoController tipoControll = new TipoController();
    
    public void acessaPocket(){
       pocketControll.listarTarefas();   
    }
    
    public void acessaPokemon(){
       pokemonControll.listarTarefas();   
    }
    
    public void acessaCampoBatalha(){
       batalhaControll.listarTarefas();    
    }
    
    public void acessaTipo(){
        //
    } 

    public void listarTarefas() {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
        telaPrincipal.listarTarefas();
    }
}
