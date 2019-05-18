/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.objects;
import src.br.ufsc.ine5605.controllers.TipoController;
/**
 *
 * @author Joao
 */
public abstract class Tipo {

    private ETipo nome;
    private ETipo forcaContra;
    private ETipo fraquezaContra;
    private String descricao;

    public Tipo(ETipo nome, ETipo forcaContra, ETipo fraquezaContra, String descricao) {
        this.nome = nome;
        this.forcaContra = forcaContra;
        this.fraquezaContra = fraquezaContra;
        this.descricao = descricao;
    }

    public Tipo() {
    }

    public ETipo getNome() {
        return nome;
    }

    public void setNome(ETipo nome) {
        this.nome = nome;
    }

    public ETipo getForcaContra() {
        return forcaContra;
    }

    public void setForcaContra(ETipo forcaContra) {
        this.forcaContra = forcaContra;
    }

    public ETipo getFraquezaContra() {
        return fraquezaContra;
    }

    public void setFraquezaContra(ETipo fraquezaContra) {
        this.fraquezaContra = fraquezaContra;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
//      if (myPokemon.getTipo() == AGUA && wildPokemon.getTipo() == FOGO){
//      myPokemon.setAtaque(0);
//      }
//      if (myPokemon.getTipo() == FOGO && wildPokemon.getTipo() == GRAMA){
//      
//      } 
//      
//      if (myPokemon.getTipo() == GRAMA && wildPokemon.getTipo() == AGUA){
//      myPokemon.setAtaque(0);
 //     }
    
}
