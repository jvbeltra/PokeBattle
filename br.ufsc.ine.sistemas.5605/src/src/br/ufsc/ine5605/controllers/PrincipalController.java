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
import src.br.ufsc.ine5605.objects.Pocket;

public class PrincipalController {
    
    private Pocket pocket = new Pocket();
    private static PrincipalController instancia;
    private PocketController pocketControll = PocketController.getInstancia();
    private PokemonController pokemonControll=  PokemonController.getInstancia();
    private BatalhaController batalhaControll = new BatalhaController(pokemonControll);
    TelaPrincipal telaPrincipal;

   
    public PrincipalController(){
        
    }

    public PocketController acessaPocket() {
        return pocketControll;
        
    }

    public PokemonController acessaPokemon() {
        return pokemonControll;
    }

    public BatalhaController acessaCampoBatalha() {
        return batalhaControll;
        
    }

    public void listarTarefas() {
        telaPrincipal = new TelaPrincipal(this);
        telaPrincipal.setVisible(true);
    }
    
    public static PrincipalController getInstancia(){
        if (instancia == null){
            instancia = new PrincipalController();
        }
        return instancia;
    }

}
