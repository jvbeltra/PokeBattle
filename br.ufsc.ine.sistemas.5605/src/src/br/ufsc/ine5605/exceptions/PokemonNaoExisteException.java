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
public class PokemonNaoExisteException extends RuntimeException {

    public PokemonNaoExisteException() {
        this("O pokemon solicitado não existe.");
    }
    
    public PokemonNaoExisteException(String message) {
        super(message);
    }
    
}
