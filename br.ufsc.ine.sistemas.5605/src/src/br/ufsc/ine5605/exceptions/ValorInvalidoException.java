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
public class ValorInvalidoException extends NumberFormatException {

    public ValorInvalidoException() {
        this("Insira os campos com seus tipos corretos.");
    }
    
    public ValorInvalidoException(String message) {
        super(message);
    }
    
}
