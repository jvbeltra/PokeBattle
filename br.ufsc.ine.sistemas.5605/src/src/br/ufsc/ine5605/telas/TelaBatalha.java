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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import src.br.ufsc.ine5605.controllers.BatalhaController;
import src.br.ufsc.ine5605.persistencia.BatalhaDAO;

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
    private JLabel tituloLabel;

    private JTextField tituloField;
    private JTextField aliadoField;
    private JTextField adversarioField;

    private JPanel tableButtonPanel;
    private JPanel buttonPanel;
    private JPanel detalhesPanel;

    private JScrollPane tableScrollPane;

    private JTable table;
    private DefaultTableModel tableModel;

    public TelaBatalha() {
        super("Batalha");
        this.initTelaBatalha();

    }

    private void initTelaBatalha() {
        JPanel panel = new JPanel(new GridBagLayout());
        this.getContentPane().setLayout(new GridBagLayout());
        this.getContentPane().add(panel);

        tableButtonPanel = new JPanel();

        this.createButtons(tableButtonPanel);

        buttonPanel = new JPanel();
        detalhesPanel = this.batalhaDetalhes();
        detalhesPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.manageTable();
        this.initTable();

        this.layoutManager(panel);

        this.pack();
        setLocationRelativeTo(null);

    }

    public JPanel batalhaDetalhes() {

        JPanel panel = new JPanel();
        this.createDetalhesLabels();

        panel.setLayout(new GridBagLayout());

        this.layoutDetalhesManager(panel);

        return panel;

    }

    private void limparCampos() {
        tituloField.setText("");
        aliadoField.setText("");
        adversarioField.setText("");
        initTable();
    }

    private void createButtons(JPanel tableButtonPanel) {
        selecionarLutadoresBtn = new JButton();
        batalharBtn = new JButton();
        apagarBatalhaBtn = new JButton();
        cancelarBtn = new JButton();
        aleatorioBtn = new JButton();

        batalharBtn.setText("Batalhar!");
        apagarBatalhaBtn.setText("Apagar Batalha");
        aleatorioBtn.setText("Inimigo aleatório");

        GerenciadorBotao btManager = new GerenciadorBotao();

        batalharBtn.addActionListener(btManager);
        batalharBtn.setActionCommand("1");

        apagarBatalhaBtn.addActionListener(btManager);
        apagarBatalhaBtn.setActionCommand("2");

        aleatorioBtn.addActionListener(btManager);
        aleatorioBtn.setActionCommand("3");

        tableButtonPanel.add(batalharBtn);
        tableButtonPanel.add(aleatorioBtn);
        tableButtonPanel.add(apagarBatalhaBtn);

    }

    private void initTable() {
        table = new JTable();
        String[] columnNames = {
            "Titulo",
            "Vitorioso",
            "Derrotado"
        };

        tableModel = new DefaultTableModel(columnNames, 0);

        BatalhaDAO.getInstancia().getList().stream().forEach((batalha) -> {
            tableModel.addRow(new Object[]{
                batalha.getTitulo(),
                batalha.getVitorioso().getNome(),
                batalha.getDerrotado().getNome()

            });
        });

        table.setModel(tableModel);
        this.repaint();

    }

    private void manageTable() {

        tableScrollPane = new JScrollPane(table);
        table = new JTable() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };

        table.getTableHeader().setReorderingAllowed(false);

        Dimension dimension = new Dimension(300, 200);
        tableScrollPane.setPreferredSize(dimension);
    }

    private void layoutManager(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel label = new JLabel("Batalhas registradas");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        panel.add(label, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridheight = 1;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;

        panel.add(new JScrollPane(table), gbc);

        gbc.fill = GridBagConstraints.NONE;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weightx = 0;
        gbc.weighty = 0;

        panel.add(tableButtonPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        panel.add(buttonPanel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 3;
        gbc.gridheight = 1;

        gbc.anchor = GridBagConstraints.NORTH;

        panel.add(detalhesPanel, gbc);

    }

    private void layoutDetalhesManager(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.anchor = GridBagConstraints.NORTHEAST;

        int i = 0;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = i;

        panel.add(aliadoLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = i;

        panel.add(aliadoField, gbc);

        i++;

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = i;

        panel.add(adversarioLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 3;
        gbc.gridx = 1;
        gbc.gridy = i;

        panel.add(adversarioField, gbc);

        i++;

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = i;

        panel.add(tituloLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = i;

        panel.add(tituloField, gbc);

    }

    private void createDetalhesLabels() {

        aliadoLabel = new JLabel("Aliado");
        adversarioLabel = new JLabel("Adversário");
        tituloLabel = new JLabel("Título");

        aliadoField = new JTextField("", 10);
        adversarioField = new JTextField("", 10);
        tituloField = new JTextField("", 10);

    }

    private class GerenciadorBotao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            switch (e.getActionCommand()) {
                case "1": {

                    try {
                        BatalhaController.getInstancia().batalhar(aliadoField.getText(), adversarioField.getText(), tituloField.getText());
                        initTable();
                        new TelaLuta().setVisible(true);
                    } catch (Exception e1) {
                        JOptionPane.showMessageDialog(null, e1.getMessage());
                    }
                    break;
                }
                case "2": {
                    try {
                        System.out.println(BatalhaController.getInstancia().getBatalhaByTitulo(table.getValueAt(table.getSelectedRow(), 0).toString()));
                        BatalhaController.getInstancia().delBatalha(BatalhaController.getInstancia().getBatalhaByTitulo(table.getValueAt(table.getSelectedRow(), 0).toString()));
                        aliadoField.setText("");
                        adversarioField.setText("");
                        tituloField.setText("");
                    } catch (Exception e2) {
                        JOptionPane.showMessageDialog(null, e2.getMessage());
                    }
                    initTable();
                    break;
                }
                case "3": {
                    adversarioField.setText(BatalhaController.getInstancia().getAleatorio().getNome());
                    break;
                }
                case "4": {
                    aliadoField.setText("");
                    adversarioField.setText("");
                    tituloField.setText("");
                    break;
                }
            }
        }

    }

}
