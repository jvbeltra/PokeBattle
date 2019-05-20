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
public class TipoNaoExisteException extends RuntimeException {

    public TipoNaoExisteException() {
        this("O tipo inserido não existe");
    }
    
    public TipoNaoExisteException(String message) {
        super(message);
    }
    
}
