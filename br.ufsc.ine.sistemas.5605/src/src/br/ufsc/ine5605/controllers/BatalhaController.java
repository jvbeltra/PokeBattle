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
import static src.br.ufsc.ine5605.objects.ETipo.AGUA;
import static src.br.ufsc.ine5605.objects.ETipo.FOGO;
import static src.br.ufsc.ine5605.objects.ETipo.GRAMA;

/**
 *
 * @author Joao
 */
public class BatalhaController {

    private PokemonController wildPokemonControll = new PokemonController();
//    PocketController myPocketControll = new PocketController();
    private PocketController myPocketControll;

    TelaBatalha tela;
    private Pokemon wildPokemon;
    private Pokemon myPokemon;

    public void listarTarefas() {
        tela = new TelaBatalha();
        tela.listarTarefas();
    }

    public void selecionarLutadores() {

        Scanner s = new Scanner(System.in);

        System.out.println("Insira o nome do Pokemon que você utilizará: ");
        String nomeMyPokemon = s.nextLine();
        //try
        myPocketControll.getPokemonByName(nomeMyPokemon);

        System.out.println("Insira o nome do Pokemon selvagem: ");
        String nomeSelvagem = s.nextLine();

        //try
        wildPokemonControll.getPokemonByName(nomeSelvagem);
    }

    ;
    
    public int ataqueAliado() {

        if (myPokemon.getTipo() == AGUA && wildPokemon.getTipo() == FOGO) {
            myPokemon.setAtaque(myPokemon.getAtaque() * 2);
        }
        if (myPokemon.getTipo() == FOGO && wildPokemon.getTipo() == GRAMA) {
            myPokemon.setAtaque(myPokemon.getAtaque() * 2);
        }
        if (myPokemon.getTipo() == GRAMA && wildPokemon.getTipo() == AGUA) {
            myPokemon.setAtaque(myPokemon.getAtaque() * 2);
        }
        if (myPokemon.getTipo() == FOGO && wildPokemon.getTipo() == AGUA) {
            myPokemon.setAtaque((myPokemon.getAtaque() / 2));
        }
        if (myPokemon.getTipo() == AGUA && wildPokemon.getTipo() == GRAMA) {
            myPokemon.setAtaque((myPokemon.getAtaque() / 2));
        }
        if (myPokemon.getTipo() == GRAMA && wildPokemon.getTipo() == FOGO) {
            myPokemon.setAtaque((myPokemon.getAtaque() / 2));
        }
        if (myPokemon.getAtaque() > wildPokemon.getDefesa()) {
            wildPokemon.setVida(myPokemon.getAtaque() - wildPokemon.getDefesa() - wildPokemon.getVida());
            return wildPokemon.getVida();
        } else {
            return wildPokemon.getVida();
        }
    }

    public int ataqueInimigo() {
        
        if (wildPokemon.getTipo() == AGUA && myPokemon.getTipo() == FOGO) {
            myPokemon.setAtaque(myPokemon.getAtaque() * 2);
        }
        if (wildPokemon.getTipo() == FOGO && myPokemon.getTipo() == GRAMA) {
            myPokemon.setAtaque(myPokemon.getAtaque() * 2);
        }
        if (wildPokemon.getTipo() == GRAMA && myPokemon.getTipo() == AGUA) {
            myPokemon.setAtaque(myPokemon.getAtaque() * 2);
        }
        if (wildPokemon.getTipo() == FOGO && myPokemon.getTipo() == AGUA) {
            myPokemon.setAtaque((myPokemon.getAtaque() / 2));
        }
        if (wildPokemon.getTipo() == AGUA && myPokemon.getTipo() == GRAMA) {
            myPokemon.setAtaque((myPokemon.getAtaque() / 2));
        }
        if (wildPokemon.getTipo() == GRAMA && myPokemon.getTipo() == FOGO) {
            myPokemon.setAtaque((myPokemon.getAtaque() / 2));
        }
        if (wildPokemon.getAtaque() > myPokemon.getDefesa()) {
            myPokemon.setVida(wildPokemon.getAtaque() - myPokemon.getDefesa() - myPokemon.getVida());
            return wildPokemon.getVida();
        } else {
            return myPokemon.getVida();
        }
    }
    
    
}
