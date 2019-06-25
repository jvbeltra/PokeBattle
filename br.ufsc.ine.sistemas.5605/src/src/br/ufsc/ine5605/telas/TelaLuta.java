/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.telas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;

/**
 *
 * @author Bruno
 */
public class TelaLuta extends JFrame{
    private JTable tabela;
    
    
    public TelaLuta() {
        super("luta");
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        this.getContentPane().setLayout(new GridBagLayout());
        this.getContentPane().add(panelPrincipal);
        GridBagConstraints gbc = new GridBagConstraints();

    
    
    }
}