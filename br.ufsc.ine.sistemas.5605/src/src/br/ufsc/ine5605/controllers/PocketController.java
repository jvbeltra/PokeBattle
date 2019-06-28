/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.controllers;

import java.util.List;
import java.util.Scanner;
import src.br.ufsc.ine5605.objects.Pocket;
import src.br.ufsc.ine5605.telas.TelaPocket;
import src.br.ufsc.ine5605.controllers.PrincipalController;
import src.br.ufsc.ine5605.exceptions.PokemonNaoExisteException;
import src.br.ufsc.ine5605.persistencia.PocketDAO;

/**
 *
 * @author Joao
 */
public class PocketController {

    private TelaPocket telaPocket;
    private static TelaPocket sTelaPocket;
    private static Pocket sPocket;
    private TelaPocket tela;
    private Pocket pocket;
    private static PocketController instancia;

    
    public PocketController() {;
        this.pocket = new Pocket();
        PocketDAO.getInstancia().put(PokemonController.getInstancia().getPokemonByName("Pikachu"));
    }
    
    public static PocketController getInstancia(){
        if (instancia == null){
            instancia = new PocketController();
        }
        return instancia;
    }
    

    public void capturaPokemon(String nome) throws PokemonNaoExisteException {
        try {
            if (PrincipalController.getInstancia().acessaPokemon().getPokemonByName(nome) != null) {
                PocketDAO.getInstancia().put(PrincipalController.getInstancia().acessaPokemon().getPokemonByName(nome));
            } else {
                throw new PokemonNaoExisteException();
            }

        } catch (PokemonNaoExisteException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void soltarPokemon(String nome) throws PokemonNaoExisteException {
        try {
            if (PrincipalController.getInstancia().acessaPokemon().getPokemonByName(nome) != null) {
                PocketDAO.getInstancia().remove(PrincipalController.getInstancia().acessaPokemon().getPokemonByName(nome));
               
            } else {
                throw new PokemonNaoExisteException();
            }

        } catch (PokemonNaoExisteException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarPokemons() {
        PocketDAO.getInstancia().getList();
    }

}
