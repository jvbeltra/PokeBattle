/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.telas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Scanner;
import src.br.ufsc.ine5605.controllers.BatalhaController;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Joao
 */
public class TelaBatalha extends JFrame {

    private JButton selecionarLutadoresBtn;
    private JButton batalharBtn;
    private JButton apagarBatalhaBtn;
    private JButton cancelarBtn;
    private JButton aleatorioBtn;

    private JLabel aliadoLabel;
    private JLabel adversarioLabel;

    private JTextField aliadoField;
    private JTextField adversarioField;

    private JTable tabela;

    private Scanner teclado = new Scanner(System.in);

    public TelaBatalha() {
        super("Batalha");
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        this.getContentPane().setLayout(new GridBagLayout());
        this.getContentPane().add(panelPrincipal);
        GridBagConstraints gbc = new GridBagConstraints();

        String[] columnNames = {"Titulo", "Pokemon Vencedor", "Pokemon Derrotado"};
        Object[][] data = {
            {"Batalha 01", "Pikachu", "bulbassalro"},
            {"Batalha 02", "Charizard", "evee"}
        };
        tabela = new JTable(data, columnNames);
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 50));
        tabela.setFillsViewportHeight(true);
        //Panel 0 Tabela Panel
        JLabel label = new JLabel("Batalhas Anteriores ");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        panelPrincipal.add(label, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        panelPrincipal.add(new JScrollPane(tabela), gbc);

        //Panel 1 Botoes Panel
        JPanel tableButtonPanel = new JPanel();

        batalharBtn = new JButton();
        batalharBtn.setText("Batlhar!!");
        batalharBtn.setToolTipText("Faça uma batalha Pokemon");
        gbc.gridx = 1;
        tableButtonPanel.add(batalharBtn);
        //------------------------------------------------------------------------------------------------//
        apagarBatalhaBtn = new JButton();
        apagarBatalhaBtn.setText("Apagar Batalha");
        apagarBatalhaBtn.setToolTipText("Apague uma Batalha Selecionada");
        tableButtonPanel.add(apagarBatalhaBtn);
        //-----------------------------------------------------------------------------------------------//
        aleatorioBtn = new JButton();
        aleatorioBtn.setText("Aleatorio");
        aleatorioBtn.setToolTipText("Selecione um inimigo aleatorio");
        tableButtonPanel.add(aleatorioBtn);
        
        //-----------------------------------------------------------------------------------------------//
        cancelarBtn = new JButton();
        cancelarBtn.setText("Cancelar");
        cancelarBtn.setToolTipText("Cancelar ação em andamento");
        tableButtonPanel.add(cancelarBtn);

        //------------------------------------------------------------------------------------------------//
        this.getContentPane().add(tableButtonPanel, gbc);

        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.weightx = 1;
        gbc.weighty = 1;
        
        this.pack();

        setLocationRelativeTo(null);
        this.setVisible(true);
        //-------------------------------------------------------------------------------------------------------//
        //Panel 2: selecionar Panel
        JPanel selecionarPanel = new JPanel();

        aliadoLabel = new JLabel();
        aliadoLabel.setText("Aliado:");
        aliadoLabel.setToolTipText("Selecione o seu Pokemon para a batalha");
        selecionarPanel.add(aliadoLabel);
        //-------------------------------------------------------------------------------------------------------//
        adversarioLabel = new JLabel();
        adversarioLabel.setText("Adversario:");
        adversarioLabel.setToolTipText("Selecione o Pokemon adversario para a batalha, ou clique em aleatorio");
        selecionarPanel.add(adversarioLabel);
        //-------------------------------------------------------------------------------------------------------//
        aliadoField = new JTextField();
        aliadoField.setText("Seu Pokemon");
        selecionarPanel.add(aliadoField);
        //-------------------------------------------------------------------------------------------------------//
        adversarioField = new JTextField();
        adversarioField.setText("Pokemon Adversario");
        selecionarPanel.add(adversarioField);
        selecionarPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
         this.getContentPane().add(selecionarPanel, gbc);

    }

//    public void selecionarLutadores() {
//        Scanner s = new Scanner(System.in);
//        System.out.println("Insira o nome do Pokemon que você utilizará: ");
//        String nomeMyPokemon = s.nextLine();
//        System.out.println("Insira o nome do Pokemon selvagem: ");
//        String nomeSelvagem = s.nextLine();
//
//        BatalhaController.getInstancia().batalhar(nomeMyPokemon, nomeSelvagem);
//    }
}
// public void listarTarefas() {
//
//        try {
//            int input = 0;
//            do {
//                System.out.println(
//                        "\n --- Selecione uma tarefa --- \n"
//                        + " 1: Batalhar \n"
//                        + " 2: Mostrar histórico de batalhas \n"
//                        + " 0: Sair"
//                );
//
//                input = teclado.nextInt();
//
//                switch (input) {
//                    case 1: {
//                        this.selecionarLutadores();
//                        break;
//                    }
//                    case 2: {
//                        batalhaControll.listarBatalhas();
//                        break;
//                    }
//                }
//            } while (input > 0);
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
//    }

