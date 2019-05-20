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
    private PrincipalController principalControll;
    private Pocket pocket;

    public PocketController(TelaPocket telaPocket, PrincipalController principalControll, Pocket pocket) {
        this.telaPocket = telaPocket;
        this.principalControll = principalControll;
        this.pocket = pocket;
    }
    
    public PocketController(PrincipalController principalControll, Pocket pocket){
        this.principalControll = principalControll;
        this.pocket = pocket;
    }
    
    
    public void capturaPokemon() throws PokemonNaoExisteException{
        Scanner s = new Scanner(System.in);
        System.out.println("Insira o nome do Pokemon que você deseja capturar: ");
        String nome = s.nextLine();
        try {
            if (principalControll.acessaPokemon().getPokemonByName(nome)!= null){
                pocket.addPokemon(principalControll.acessaPokemon().getPokemonByName(nome));
            } else {
                throw new PokemonNaoExisteException();
            }
            
        } catch (PokemonNaoExisteException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void soltarPokemon() throws PokemonNaoExisteException{
        Scanner s = new Scanner(System.in);
        System.out.println("Insira o nome do Pokemon que você deseja soltar: ");
        String nome = s.nextLine();
        try {
            if (principalControll.acessaPokemon().getPokemonByName(nome)!= null){
                pocket.delPokemon(principalControll.acessaPokemon().getPokemonByName(nome));
            } else {
                throw new PokemonNaoExisteException();
            }
            
        } catch (PokemonNaoExisteException e){
            System.out.println(e.getMessage());
        }
    }
    
    public void listarPokemons(){
        pocket.getPokemonsCapturados();
    }

    public void listarTarefas() {
        telaPocket = new TelaPocket(this);
        telaPocket.listarTarefas();
    }
}
