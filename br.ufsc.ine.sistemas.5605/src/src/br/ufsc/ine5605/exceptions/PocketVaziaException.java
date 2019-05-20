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
public class PocketVaziaException extends RuntimeException {

    public PocketVaziaException() {
        this("Não há nenhum Pokemon inserido na pocket");
    }
    
    public PocketVaziaException(String message) {
        super(message);
    }
        
}
