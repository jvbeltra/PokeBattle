package src.br.ufsc.ine5605.exceptions;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Joao
 */
public class ValorEhZeroException extends RuntimeException {

    public ValorEhZeroException() {
        this("Valores numéricos não podem ser iguais ou abaixo de 0.");
    }
    
    public ValorEhZeroException(String message) {
        super(message);
    }
    
}

