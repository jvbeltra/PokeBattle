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

/**
 *
 * @author Joao
 */
public class PocketController {

    private TelaPocket telaPocket;
    private static TelaPocket sTelaPocket;
    private static Pocket sPocket;
    private Pocket pocket;
    private static PocketController instancia;

    
    public PocketController() {;
        this.telaPocket = new TelaPocket(this);
        this.pocket = new Pocket();
    }
    
    public static PocketController getInstancia(){
        if (instancia == null){
            instancia = new PocketController();
        }
        return instancia;
    }
    

    public void capturaPokemon() throws PokemonNaoExisteException {
        Scanner s = new Scanner(System.in);
        System.out.println("Insira o nome do Pokemon que você deseja capturar: ");
        String nome = s.nextLine();
        try {
            if (PrincipalController.getInstancia().acessaPokemon().getPokemonByName(nome) != null) {
                pocket.addPokemon(PrincipalController.getInstancia().acessaPokemon().getPokemonByName(nome));
            } else {
                throw new PokemonNaoExisteException();
            }

        } catch (PokemonNaoExisteException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void soltarPokemon() throws PokemonNaoExisteException {
        Scanner s = new Scanner(System.in);
        System.out.println("Insira o nome do Pokemon que vocÃª deseja soltar: ");
        String nome = s.nextLine();
        try {
            if (PrincipalController.getInstancia().acessaPokemon().getPokemonByName(nome) != null) {
                pocket.delPokemon(PrincipalController.getInstancia().acessaPokemon().getPokemonByName(nome));
            } else {
                throw new PokemonNaoExisteException();
            }

        } catch (PokemonNaoExisteException e) {
            System.out.println(e.getMessage());
        }
    }

    public void listarPokemons() {
        pocket.getPokemonsCapturados();
    }

    public void listarTarefas() {
        telaPocket = new TelaPocket(this);
        telaPocket.listarTarefas();
    }

}
