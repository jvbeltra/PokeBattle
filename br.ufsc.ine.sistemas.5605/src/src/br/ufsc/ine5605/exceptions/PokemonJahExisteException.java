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
    public class PokemonJahExisteException extends RuntimeException {

        public PokemonJahExisteException() {
            this("Já existe um pokemon com este nome");
        }

        public PokemonJahExisteException(String message) {
            super(message);
        }
    
}
