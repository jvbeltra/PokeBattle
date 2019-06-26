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
public class PocketCheiaException extends RuntimeException {

    public PocketCheiaException() {
        this("Não há mais espaço na pocket.");
    }
    
    public PocketCheiaException(String message) {
        super(message);
    }
}
