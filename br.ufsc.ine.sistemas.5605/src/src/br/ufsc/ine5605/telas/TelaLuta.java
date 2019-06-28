/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.telas;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import src.br.ufsc.ine5605.controllers.BatalhaController;
import src.br.ufsc.ine5605.objects.Luta;

/**
 *
 * @author Bruno
 */
public class TelaLuta extends JFrame {

    private JTable tabela;
    private DefaultTableModel tableModel;

    private ArrayList<Luta> lutas;

    private void initTable() {
        String[] columnNames = {
            "Turno",
            "Vida Aliado",
            "Vida Adversario",
            "Dano Causado",
            "Dano Recebido"

        };

        tableModel = new DefaultTableModel(columnNames, 0);
        this.repaint();

        lutas = BatalhaController.getInstancia().getLutas();
        for (Luta luta : lutas) {
            tableModel.addRow(new Object[]{
                luta.getTurno(),
                luta.getVidaAliada(),
                luta.getVidaAdversaria(),
                luta.getDanoCausado(),
                luta.getDanoRecebido()
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

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                tableModel.setRowCount(0);
                BatalhaController.getInstancia().removeAllLutas();
            }
        });
        
        this.tabela = new JTable(tableModel) {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };

        Dimension dimension = new Dimension(300, 200);
        setSize(800, 500);
        setResizable(false);
        repaint();
        tableScrollPane.setPreferredSize(dimension);
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        setLocationRelativeTo(null);

        panelPrincipal.add(new JScrollPane(tabela), gbc);

    }
}
