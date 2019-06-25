/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.telas;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import src.br.ufsc.ine5605.controllers.BatalhaController;

/**
 *
 * @author Bruno
 */
public class TelaLuta extends JFrame {

    private JTable tabela;
    private DefaultTableModel tableModel;

    private ArrayList<Integer> turnos = new ArrayList<Integer>();
    private ArrayList<Integer> vidaMomentoAliado = new ArrayList<Integer>();
    private ArrayList<Integer> vidaMomentoAdversario = new ArrayList<Integer>();
    private ArrayList<String> vencedores = new ArrayList<String>();
    private ArrayList<String> perdedores = new ArrayList<String>();

    private void initTable() {
        tabela = new JTable();
        String[] columnNames = {
            "Turno",
            "Vida Aliado",
            "Vida Adversario",
            "Dano causado",
            "Dano Recebido",
            "Pokemon Vencedor",
            "Pokemon Derrotado"

        };

        tableModel = new DefaultTableModel(columnNames, 0);

        ArrayList<Integer> turnos = BatalhaController.getInstancia().getTurnosList();
        for (Integer turno : turnos) {
            tableModel.addRow(new Object[]{
                turno
            });
        }
    }

    public TelaLuta() {
        super("luta");
        JPanel panelPrincipal = new JPanel(new GridBagLayout());
        this.getContentPane().setLayout(new GridBagLayout());
        this.getContentPane().add(panelPrincipal);
        GridBagConstraints gbc = new GridBagConstraints();
        JScrollPane tableScrollPane = new JScrollPane(tabela);
        this.initTable();
        this.tabela = new JTable(tableModel) {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
    
    panelPrincipal.add(new JScrollPane(tabela), gbc);
    }
}
