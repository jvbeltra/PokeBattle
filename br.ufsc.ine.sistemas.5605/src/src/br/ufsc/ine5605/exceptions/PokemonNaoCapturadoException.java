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
public class PokemonNaoCapturadoException extends RuntimeException {

    public PokemonNaoCapturadoException() {
        this("Este pokemon não existe na pocket.");
    }
    
    public PokemonNaoCapturadoException(String message) {
        super(message);
    }
}
