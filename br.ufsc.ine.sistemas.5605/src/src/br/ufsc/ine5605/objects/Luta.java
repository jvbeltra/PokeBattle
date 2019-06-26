/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.objects;

/**
 *
 * @author Bruno
 */
public class Luta {

    private Integer turno;
    private Integer vidaAliada;
    private Integer vidaAdversaria;
    private Integer danoCausado;
    private Integer danoRecebido;

    public Luta(Integer turno, Integer vidaAliada, Integer vidaAdversaria, Integer danoCausado, Integer danoRecebido) {
        this.turno = turno;
        this.vidaAliada = vidaAliada;
        this.vidaAdversaria = vidaAdversaria;
        this.danoCausado = danoCausado;
        this.danoRecebido = danoRecebido;
    }

    public Integer getTurno() {
        return turno;
    }

    public Integer getVidaAliada() {
        return vidaAliada;
    }

    public Integer getVidaAdversaria() {
        return vidaAdversaria;
    }

    public Integer getDanoCausado() {
        return danoCausado;
    }

    public Integer getDanoRecebido() {
        return danoRecebido;
    }

    public void setTurno(Integer turno) {
        this.turno = turno;
    }

    public void setVidaAliada(Integer vidaAliada) {
        this.vidaAliada = vidaAliada;
    }

    public void setVidaAdversaria(Integer vidaAdversaria) {
        this.vidaAdversaria = vidaAdversaria;
    }

    public void setDanoCausado(Integer danoCausado) {
        this.danoCausado = danoCausado;
    }

    public void setDanoRecebido(Integer danoRecebido) {
        this.danoRecebido = danoRecebido;
    }

}
