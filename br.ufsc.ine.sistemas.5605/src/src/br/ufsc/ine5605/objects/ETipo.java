/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.objects;

/**
 *
 * @author Joao
 */
public enum ETipo {
    AGUA("agua"),
    GRAMA("grama"),
    FOGO("fogo");

    private String tipo;

    ETipo(String tipo) {
        this.tipo = tipo;
    }

    public String tipo() {
        return tipo;
    }
}
