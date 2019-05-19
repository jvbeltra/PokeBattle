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
    
    
    public void capturaPokemon(){
        Scanner s = new Scanner(System.in);
        System.out.println("Insira o nome do Pokemon que você deseja capturar: ");
        String nome = s.nextLine();
        pocket.addPokemon(principalControll.acessaPokemon().getPokemonByName(nome));
    }
    
    public void soltarPokemon(){
        Scanner s = new Scanner(System.in);
        System.out.println("Insira o nome do Pokemon que você deseja soltar: ");
        String nome = s.nextLine();
       
    }
    
    public void listarPokemons(){
        pocket.getPokemonsCapturados();
    }
    
    public void getPokemonByName(String nome){
        
    }

    public void listarTarefas() {
        telaPocket = new TelaPocket(this);
        telaPocket.listarTarefas();
    }
}
