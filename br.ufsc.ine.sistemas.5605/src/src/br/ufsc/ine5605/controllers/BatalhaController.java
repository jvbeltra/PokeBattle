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
import src.br.ufsc.ine5605.objects.Luta;
import src.br.ufsc.ine5605.persistencia.BatalhaDAO;

/**
 *
 * @author Joao
 */
public class BatalhaController {

    private ArrayList<Luta> lutas = new ArrayList<>();
    private Pokemon wildPokemon;
    private Pokemon myPokemon;
    private Pokemon pokemonVencedor;
    private Pokemon pokemonDerrotado;
    private TelaBatalha tela;
    private Batalha batalha;
    private static BatalhaController instancia;
    private String tituloBatalha;

    public BatalhaController() {

    }

    public static BatalhaController getInstancia() {
        if (instancia == null) {
            instancia = new BatalhaController();
        }
        return instancia;
    }

    public void delBatalha(Batalha batalha) {
        BatalhaDAO.getInstancia().remove(batalha);
    }

    public ArrayList getLutas() {
        return lutas;
    }

    public Pokemon getAleatorio() {

        return PokemonController.getInstancia().getAleatorio();
    }

    public Batalha getBatalhaByTitulo(String titulo) {
        return BatalhaDAO.getInstancia().getBatalha(titulo);
    }
//    public void listarTarefas() {
//        tela = new TelaBatalha(this);
//        tela.listarTarefas();
//    }
//    public void selecionarLutadores() {
//        Scanner s = new Scanner(System.in);
//
//        System.out.println("Insira o nome do Pokemon que você utilizará: ");
//        String nomeMyPokemon = s.nextLine();
//        myPokemon = PokemonController.getInstancia().getPokemonByName(nomeMyPokemon);
//
//        System.out.println("Insira o nome do Pokemon selvagem: ");
//        String nomeSelvagem = s.nextLine();
//    }

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

//        System.out.println(" Aliado causou dano: " + danoCausado);
        return wildPokemon.getVida();

    }

    public void excluirBatalha(Batalha batalha) {
        BatalhaDAO.getInstancia().remove(batalha);
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
//                System.out.println(" *-*-* ATAQUE DE SORTE! *-*-*");
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

//        System.out.println(" Inimigo causou de Dano: " + danoCausado);
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

//    public Pokemon pokemonAleatorio(){
//    
//    }
    public String lutar(Pokemon myPokemon, Pokemon wildPokemon) {

        Integer turno = 0;
        Integer vidaAtualAliado = 0;
        Integer vidaAtualAdversario = 0;
        Integer danoSofrido = 0;
        Integer danoCausado = 0;
        Integer ataque = wildPokemon.getVida();
        Integer defesa = myPokemon.getVida();

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

            turno = (i + 1);
            vidaAtualAliado = (myPokemon.getVida());
            vidaAtualAdversario = (wildPokemon.getVida());
            danoCausado = (ataque - vidaAtualAdversario);
            danoSofrido = (defesa - vidaAtualAliado);
            Luta lutaDetalhes = new Luta(turno, vidaAtualAliado, vidaAtualAdversario, danoCausado, danoSofrido);
            lutas.add(lutaDetalhes);
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

    public Batalha batalhar(String myPokemonName, String wildPokemonName, String tituloBatalha) {
        Batalha resultadoBatalha = null;
        try {
            myPokemon = PokemonController.getInstancia().getPokemonByName(myPokemonName);
            wildPokemon = PokemonController.getInstancia().getPokemonByName(wildPokemonName);
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

            resultadoBatalha = new Batalha(pokemonVencedor, pokemonDerrotado, tituloBatalha);
            resultadoBatalha.setVitorioso(pokemonVencedor);
            resultadoBatalha.setDerrotado(pokemonDerrotado);
            resultadoBatalha.setTitulo(tituloBatalha);

            myPokemon.setVida(myPokemonResetaVida);
            wildPokemon.setVida(wildPokemonResetaVida);

            BatalhaDAO.getInstancia().put(resultadoBatalha);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return resultadoBatalha;
    }

}
