/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.objects;

import java.io.Serializable;
import src.br.ufsc.ine5605.controllers.PokemonController;
import src.br.ufsc.ine5605.objects.Tipo;

/**
 *
 * @author Joao
 */
public class Pokemon implements Serializable  {

    private String nome;
    private String nick;
    private String descricao;
    private int velocidade;
    private int ataque;
    private int defesa;
    private int vida;
    private ETipo tipo;

    public Pokemon() {
    }

    public Pokemon(String nome, String nick, String descricao, int velocidade, int ataque, int defesa, int vida, ETipo tipo) {
        this.nome = nome;
        this.nick = nick;
        this.descricao = descricao;
        this.velocidade = velocidade;
        this.ataque = ataque;
        this.defesa = defesa;
        this.vida = vida;
        this.tipo = tipo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getVelocidade() {
        return velocidade;
    }

    public void setVelocidade(int velocidade) {
        this.velocidade = velocidade;
    }

    public int getAtaque() {
        return ataque;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public ETipo getTipo() {
        return tipo;
    }

}
