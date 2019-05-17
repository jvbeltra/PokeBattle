/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.controllers;

import src.br.ufsc.ine5605.telas.TelaBatalha;

/**
 *
 * @author Joao
 */
public class BatalhaController {
   
    
    TelaBatalha tela;
    void listarTarefas() {
        tela = new TelaBatalha();
        tela.listarTarefas();
    }
    
}
