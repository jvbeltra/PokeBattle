/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.objects;

import java.util.Date;
import src.br.ufsc.ine5605.controllers.BatalhaController;
import static src.br.ufsc.ine5605.objects.ETipo.AGUA;
import static src.br.ufsc.ine5605.objects.ETipo.FOGO;
import static src.br.ufsc.ine5605.objects.ETipo.GRAMA;
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

    public Batalha(Date horaBatalha, Pokemon myPokemon, Pokemon wildPokemon, Pokemon vitorioso, Pokemon derrotado) {
        this.horaBatalha = horaBatalha;
        this.myPokemon = myPokemon;
        this.wildPokemon = wildPokemon;
        this.vitorioso = vitorioso;
        this.derrotado = derrotado;
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
    
    public int ataqueAliado(){
      if (myPokemon.getTipo() == AGUA && wildPokemon.getTipo() == FOGO){
      myPokemon.setAtaque(0);
      }
      if (myPokemon.getTipo() == FOGO && wildPokemon.getTipo() == GRAMA){
      myPokemon.setAtaque(0);
      } 
      
      if (myPokemon.getTipo() == GRAMA && wildPokemon.getTipo() == AGUA){
      myPokemon.setAtaque(0);
      }
      
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
