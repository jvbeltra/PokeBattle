/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.controllers;

import java.util.ArrayList;
import java.util.Scanner;
import src.br.ufsc.ine5605.telas.TelaBatalha;
import src.br.ufsc.ine5605.objects.Batalha;
import src.br.ufsc.ine5605.controllers.PokemonController;
import src.br.ufsc.ine5605.objects.Pokemon;
import static src.br.ufsc.ine5605.objects.ETipo.AGUA;
import static src.br.ufsc.ine5605.objects.ETipo.FOGO;
import static src.br.ufsc.ine5605.objects.ETipo.GRAMA;
import java.util.Random;
import src.br.ufsc.ine5605.exceptions.PokemonNaoExisteException;
import src.br.ufsc.ine5605.exceptions.ValorEhZeroException;

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
    private ArrayList<Batalha> batalhas = new ArrayList<>();
    private static BatalhaController instancia;
    
    public BatalhaController() {
        this.pokemonControll = pokemonControll;
    }
    public static BatalhaController getInstancia() {
        if (instancia == null) {
            instancia = new BatalhaController();
        }
        return instancia;
    }

//    public void listarTarefas() {
//        tela = new TelaBatalha(this);
//        tela.listarTarefas();
//    }

    public void selecionarLutadores() {
        Scanner s = new Scanner(System.in);

        System.out.println("Insira o nome do Pokemon que você utilizará: ");
        String nomeMyPokemon = s.nextLine();
        myPokemon = pokemonControll.getPokemonByName(nomeMyPokemon);

        System.out.println("Insira o nome do Pokemon selvagem: ");
        String nomeSelvagem = s.nextLine();
    }

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
        int newVida = wildPokemon.getVida();
        int danoCausado = 0;

        if (myPokemon.getAtaque() > wildPokemon.getDefesa()) {
            danoCausado = myPokemon.getAtaque() - wildPokemon.getDefesa();

        } else if (myPokemon.getAtaque() < wildPokemon.getDefesa()) {
            danoCausado = (myPokemon.getAtaque() - wildPokemon.getDefesa() / 2);
        }

        if (danoCausado <= 0) {
            if (this.ataqueSorte()) {
                danoCausado = myPokemon.getAtaque();
            } else {
                danoCausado = myPokemon.getAtaque() / 2;
            }

        }

        newVida = wildPokemon.getVida() - danoCausado;

        if (newVida < 0) {
            newVida = 0;
        }

        wildPokemon.setVida(newVida);

        System.out.println(" Aliado causou dano: " + danoCausado);
        return wildPokemon.getVida();

    }

    public int ataqueInimigo() {
        int newVida = myPokemon.getVida();
        int danoCausado = 0;

        if (wildPokemon.getAtaque() > myPokemon.getDefesa()) {
            danoCausado = wildPokemon.getAtaque() - myPokemon.getDefesa();
        } else if (wildPokemon.getAtaque() < myPokemon.getDefesa()) {
            danoCausado = (wildPokemon.getAtaque() - myPokemon.getDefesa() / 2);
        }

        if (danoCausado <= 0) {
            if (this.ataqueSorte()) {
                System.out.println(" *-*-* ATAQUE DE SORTE! *-*-*");
                danoCausado = wildPokemon.getAtaque();
            } else {
                danoCausado = wildPokemon.getAtaque() / 2;
            }
        }

        newVida = myPokemon.getVida() - danoCausado;

        if (newVida < 0) {
            newVida = 0;
        }

        myPokemon.setVida(newVida);

        System.out.println(" Inimigo causou de Dano: " + danoCausado);
        return myPokemon.getVida();

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

    public String lutar(Pokemon myPokemon, Pokemon wildPokemon) {
        int i = 0;
        int ordem = 0;

        if (myPokemon.getVelocidade() < wildPokemon.getVelocidade()) {
            ordem = 0;
            this.ataqueInimigo();
            this.ataqueAliado();
        } else {
            ordem = 1;
            this.ataqueAliado();
            this.ataqueInimigo();
        }

        do {
            if (ordem == 1) {
                this.ataqueAliado();
                this.ataqueInimigo();
            } else {
                this.ataqueInimigo();
                this.ataqueAliado();
            }

            System.out.println("\n --- Turno --- : " + (i + 1));
            System.out.println(" Vida do meu Pokemon: " + myPokemon.getVida());
            System.out.println(" Vida do Pokemon inimigo: " + wildPokemon.getVida());
            i++;

        } while ((myPokemon.getVida() > 0 && wildPokemon.getVida() > 0));

        if (myPokemon.getVida() == 0) {
            pokemonVencedor = wildPokemon;
            pokemonDerrotado = myPokemon;
        } else {
            pokemonVencedor = myPokemon;
            pokemonDerrotado = wildPokemon;
        }

        return pokemonVencedor.getNome();

    }

    public Boolean ataqueSorte() {
        Random sorte = new Random();
        return sorte.nextInt(10) % 2 == 0;
    }

    public Batalha batalhar(String myPokemonName, String wildPokemonName) {
        Batalha resultadoBatalha = null;
        try {
            myPokemon = pokemonControll.getPokemonByName(myPokemonName);
            wildPokemon = pokemonControll.getPokemonByName(wildPokemonName);
            if (myPokemon == null || wildPokemon == null) {
                throw new PokemonNaoExisteException();
            }
            
            

            if (myPokemon.getVida() <= 0 || wildPokemon.getVida() <= 0) {
                throw new ValorEhZeroException();
            }

            int myPokemonResetaVida = myPokemon.getVida();
            int wildPokemonResetaVida = wildPokemon.getVida();

            this.calculaVantagemAliada();
            this.calculaVantagemAdversaria();

            this.lutar(myPokemon, wildPokemon);

            resultadoBatalha = new Batalha(pokemonVencedor, pokemonDerrotado);
            resultadoBatalha.setVitorioso(pokemonVencedor);
            resultadoBatalha.setDerrotado(pokemonDerrotado);
            System.out.println("Pokemon vencedor: " + pokemonVencedor.getNome());
            System.out.println("Pokemon derrotado: " + pokemonDerrotado.getNome() + "\n");
            
            
            
            myPokemon.setVida(myPokemonResetaVida);
            wildPokemon.setVida(wildPokemonResetaVida);

            batalhas.add(resultadoBatalha);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultadoBatalha;
    }

    public void listarBatalhas() {
        int i = 1;
        for (Batalha batalha : batalhas) {
            System.out.println(
                    "\n --- Batalha: " + i + " ---"
                    + "\n Vencedor: " + batalha.getVitorioso().getNome()
                    + "\n Derrotado: " + batalha.getDerrotado().getNome());
            i++;
        }
    }
}
