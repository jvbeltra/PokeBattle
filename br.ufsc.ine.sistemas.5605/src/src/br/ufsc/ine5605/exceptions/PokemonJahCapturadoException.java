/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.exceptions;

/**
 *
 * @author Joao
 */
public class PokemonJahCapturadoException extends RuntimeException {

    public PokemonJahCapturadoException() {
        this("Este pokemon já foi capturado");
    }
    
    public PokemonJahCapturadoException(String message) {
        super(message);
    }
}
