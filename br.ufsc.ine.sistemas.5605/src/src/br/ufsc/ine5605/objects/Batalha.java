/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.objects;

import java.util.Date;
import src.br.ufsc.ine5605.controllers.BatalhaController;
/**
 *
 * @author Joao
 */
public class Batalha {
    private Date horaBatalha;
    private Pokemon myPokemon;
    private Pokemon wildPokemon;
    private Pokemon vitorioso;
    private Pokemon derrotado;

    public Batalha(Date horaBatalha, Pokemon myPokemon, Pokemon wildPokemon) {
        this.horaBatalha = horaBatalha;
        this.myPokemon = myPokemon;
        this.wildPokemon = wildPokemon;
    }

    public Batalha() {
    }

    public Date getHoraBatalha() {
        return horaBatalha;
    }

    public void setHoraBatalha(Date horaBatalha) {
        this.horaBatalha = horaBatalha;
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
    
    
    
    
    
}
