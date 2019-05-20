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
import java.util.Date;

/**
 *
 * @author Joao
 */
public class BatalhaController {

    private PokemonController pokemonControll;
    private Pokemon wildPokemon;
    private Pokemon myPokemon;
    private Pokemon pokemonVencedor;
    private Pokemon pokemonDerrotado;
    private TelaBatalha tela;

    public BatalhaController(PokemonController pokemonControll) {
        this.pokemonControll = pokemonControll;
    }

    public void listarTarefas() {
        tela = new TelaBatalha(this);
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
        PokemonControll.getPokemonByName(nomeSelvagem);
    }

    ;
    public int calculaVantagemAliada() {
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
        return myPokemon.getAtaque();
    }

    public int ataqueAliado() {

        if (myPokemon.getAtaque() > wildPokemon.getDefesa()) {
            wildPokemon.setVida(myPokemon.getAtaque() - wildPokemon.getDefesa() - wildPokemon.getVida());
            if (myPokemon.getVida() < 0) {
                myPokemon.setVida(0);
                
            }
            return wildPokemon.getVida();
        } else {
             if (myPokemon.getVida() < 0) {
                    myPokemon.setVida(0);
                }
            return wildPokemon.getVida();

        }
    }

    public int calculaVantagemAdversaria() {

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
        return wildPokemon.getAtaque();
    }

    public int ataqueInimigo() {

        if (wildPokemon.getAtaque() > myPokemon.getDefesa()) {
            myPokemon.setVida(wildPokemon.getAtaque() - myPokemon.getDefesa() - myPokemon.getVida());
            if (myPokemon.getVida() < 0) {
                myPokemon.setVida(0);
            }
                return myPokemon.getVida();
            } 
            
            else {
                if (myPokemon.getVida() < 0) {
                    myPokemon.setVida(0);
                }

            }
        return myPokemon.getVida();

        
            }

    public String lutar() {
        int i = 0;
        while (myPokemon.getVida() != 0 || wildPokemon.getVida() != 0) {
            i++;
            if (myPokemon.getVelocidade() > wildPokemon.getVelocidade()) {
                this.ataqueAliado();
                this.ataqueInimigo();
            } else {
                this.ataqueInimigo();
                this.ataqueAliado();
            }
            System.out.println("Turno: " + i);
            System.out.println("Aliado Tirou de Dano: " + myPokemon.getAtaque());
            System.out.println("Inimigo Tirou de Dano: " + wildPokemon.getAtaque());
            System.out.println("Vida Atual do Meu Pokemon: " + myPokemon.getVida());
            System.out.println("Vida Atual do Pokemon Inimigo: " + wildPokemon.getVida());
        }
        if (myPokemon.getVida() == 0) {
            pokemonVencedor = wildPokemon;
            pokemonDerrotado = myPokemon;
        } else {
            pokemonVencedor = myPokemon;
            pokemonDerrotado = wildPokemon;
        }

        return pokemonVencedor.getNome();

    }

    public Batalha batalhar() {
        Date data = new Date();
        Scanner s = new Scanner(System.in);

        System.out.println("Insira o nome do Pokemon que você utilizará: ");
        String nomeMyPokemon = s.nextLine();
        //try
        myPokemon = pokemonControll.getPokemonByName(nomeMyPokemon);

        System.out.println("Insira o nome do Pokemon selvagem: ");
        String nomeSelvagem = s.nextLine();
        //try
        wildPokemon = pokemonControll.getPokemonByName(nomeSelvagem);
        this.calculaVantagemAliada();
        this.calculaVantagemAdversaria();
        this.lutar();
        Batalha resultadoBatalha = new Batalha(data, pokemonVencedor, pokemonDerrotado);
        System.out.println("Pokemon Vencedor" + pokemonVencedor.getNome());
        System.out.println("Pokemon Perdedor" + pokemonDerrotado.getNome());
        return resultadoBatalha;
    }
}
