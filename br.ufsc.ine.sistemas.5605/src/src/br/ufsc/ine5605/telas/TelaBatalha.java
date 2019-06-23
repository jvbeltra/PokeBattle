/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.telas;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Scanner;
import src.br.ufsc.ine5605.controllers.BatalhaController;
import java.util.Date;
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

    private JLabel aliadoLabel;
    private JLabel adversarioLabel;

    private JTextField aliadoField;
    private JTextField adversarioField;

    private JTable tabela;

    private Scanner teclado = new Scanner(System.in);

    public TelaBatalha() {
        super("Batalha");
        JPanel panel = new JPanel(new GridBagLayout());
        this.getContentPane().setLayout(new GridBagLayout());
        this.getContentPane().add(panel);
        GridBagConstraints gbc = new GridBagConstraints();

        String[] columnNames = {"Titulo", "Pokemon Vencedor", "Pokemon Derrotado"};
        Object[][] data = {
            {"Batalha 01", "Pikacu", "bulbassalto"},
            {"Batalha 02", "Crackzard", "lsdevee"}
        };
        tabela = new JTable(data, columnNames);
        tabela.setPreferredScrollableViewportSize(new Dimension(500, 50));
        tabela.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(tabela);
        add(scrollPane);

        selecionarLutadoresBtn = new JButton();
        selecionarLutadoresBtn.setText("Selecione os Lutadores");
        selecionarLutadoresBtn.setToolTipText("Selecione os Pokemons para a batalha");
        add(selecionarLutadoresBtn);
        //------------------------------------------------------------------------------------------------//
        apagarBatalhaBtn = new JButton();
        apagarBatalhaBtn.setText("Apagar Batalha");
        apagarBatalhaBtn.setToolTipText("Apague uma Batalha Selecionada");
        add(apagarBatalhaBtn);
        //-----------------------------------------------------------------------------------------------//
        cancelarBtn = new JButton();
        cancelarBtn.setText("Cancelar");
        cancelarBtn.setToolTipText("Cancelar ação em andamento");
        add(cancelarBtn);
        //-----------------------------------------------------------------------------------------------//
        aliadoLabel = new JLabel();
        aliadoLabel.setText("Aliado:");
        aliadoLabel.setToolTipText("Selecione o seu Pokemon para a batalha");
        add(aliadoLabel);
        //------------------------------------------------------------------------------------------------//
        adversarioLabel = new JLabel();
        adversarioLabel.setText("Aliado:");
        adversarioLabel.setToolTipText("Selecione o Pokemon adversário para a batalha, ou clique em aleatorio");
        add(adversarioLabel);

    }

    public void selecionarLutadores() {
        Scanner s = new Scanner(System.in);
        System.out.println("Insira o nome do Pokemon que você utilizará: ");
        String nomeMyPokemon = s.nextLine();
        System.out.println("Insira o nome do Pokemon selvagem: ");
        String nomeSelvagem = s.nextLine();

        BatalhaController.getInstancia().batalhar(nomeMyPokemon, nomeSelvagem);
    }
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
