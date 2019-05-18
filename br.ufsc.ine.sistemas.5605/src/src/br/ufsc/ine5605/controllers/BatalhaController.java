/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.controllers;

import java.util.Scanner;
import src.br.ufsc.ine5605.telas.TelaBatalha;
import src.br.ufsc.ine5605.objects.Batalha;
import src.br.ufsc.ine5605.controllers.PokemonController;
import src.br.ufsc.ine5605.objects.Pokemon;
import src.br.ufsc.ine5605.controllers.PocketController;

/**
 *
 * @author Joao
 */
public class BatalhaController {
   
    private PokemonController wildPokemonControll = new PokemonController();
//    PocketController myPocketControll = new PocketController();
    private PocketController myPocketControll;
    
    
    
    TelaBatalha tela;


    void listarTarefas() {
        tela = new TelaBatalha();
        tela.listarTarefas();
    }
    
    public void selecionarLutadores(){
        
        Scanner s = new Scanner(System.in);
        
        System.out.println("Insira o nome do Pokemon que você utilizará: ");
        String nomeMyPokemon = s.nextLine();
        //try
        myPocketControll.getPokemonByName(nomeMyPokemon);
        
        
        System.out.println("Insira o nome do Pokemon selvagem: ");
        String nomeSelvagem = s.nextLine();
        
        //try
        wildPokemonControll.getPokemonByName(nomeSelvagem);
    };
    
    public int ataqueAliado(){
    
      
      if(myPokemon.getAtaque() > wildPokemon.getDefesa()){  
        return (myPokemon.getAtaque() - wildPokemon.getDefesa()) - wildPokemon.getVida();
      } else{
        return wildPokemon.getVida();
            }
        }
    public int ataqueInimigo(){
    if(wildPokemon.getAtaque() > myPokemon.getDefesa()){  
        return (wildPokemon.getAtaque() - myPokemon.getDefesa()) - myPokemon.getVida();
      } else{
        return myPokemon.getVida();
            }
    }
}