/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.telas;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import src.br.ufsc.ine5605.controllers.PrincipalController;

/**
 *
 * @author Joao
 */
public class TelaPrincipal extends JFrame {

    private JLabel bemvindo;
    private JButton pokemonBtn;
    private JButton pocketBtn;
    private JButton batalhaBtn;
    private JButton sair;

    public TelaPrincipal(PrincipalController principalControll) {
        super("PokeBattle");
        Container container = getContentPane();
        container.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        
        
        gbc.gridwidth = 10;
        gbc.gridy = 15;

        bemvindo = new JLabel();
        pokemonBtn = new JButton();
        pocketBtn = new JButton();
        batalhaBtn = new JButton();
        
        bemvindo.setText("Seja bem-vindo ao pokebattle!");
        pokemonBtn.setText("Gerenciar Pokemons");
        pocketBtn.setText("Gerenciar pocket");
        batalhaBtn.setText("Batalhar");

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 5;
        container.add(bemvindo, gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
            
        gbc.gridx = 1;
        gbc.gridy = 10;
        container.add(pokemonBtn,gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 15;
        container.add(pocketBtn,gbc);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridy = 20;
        gbc.gridx = 1;
        container.add(batalhaBtn,gbc);

        setSize(390, 170);
        setLocationRelativeTo(null);
        setVisible(true);

        GerenciadorBotao btManager = new GerenciadorBotao();
        pokemonBtn.addActionListener(btManager);
        pokemonBtn.setActionCommand("1");
        pocketBtn.addActionListener(btManager);
        pocketBtn.setActionCommand("2");
        batalhaBtn.addActionListener(btManager);
        batalhaBtn.setActionCommand("3");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    
    
    }

    private static class GerenciadorBotao implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            switch(e.getActionCommand()){
                case "1": {
                    new TelaPokemon().setVisible(true);
                }
            }
        }
    }

    

}

//            
//                    principalControll.acessaPokemon().listarTarefas();
//                    principalControll.acessaPocket().listarTarefas();
//                    principalControll.acessaCampoBatalha().listarTarefas();
//               
//    

