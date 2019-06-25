/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.objects;

import java.io.Serializable;
import java.util.Date;
import src.br.ufsc.ine5605.controllers.BatalhaController;

/**
 *
 * @author Joao
 */
public class Batalha implements Serializable  {

    private String titulo;
    private Pokemon myPokemon;
    private Pokemon wildPokemon;
    private Pokemon vitorioso;
    private Pokemon derrotado;

    public Batalha(Pokemon myPokemon, Pokemon wildPokemon, String titulo) {

        this.myPokemon = myPokemon;
        this.wildPokemon = wildPokemon;
        this.titulo = titulo;
    }

    public Batalha() {
    }

    public Pokemon getMyPokemon() {
        return myPokemon;
    }

    public void setMyPokemon(Pokemon myPokemon) {
        this.myPokemon = myPokemon;
    }

    public Pokemon getWildPokemon() {
        return wildPokemon;
    }

    public void setWildPokemon(Pokemon wildPokemon) {
        this.wildPokemon = wildPokemon;
    }

    public Pokemon getVitorioso() {
        return vitorioso;
    }

    public void setVitorioso(Pokemon vitorioso) {
        this.vitorioso = vitorioso;
    }

    public Pokemon getDerrotado() {
        return derrotado;
    }

    public void setDerrotado(Pokemon derrotado) {
        this.derrotado = derrotado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

}
