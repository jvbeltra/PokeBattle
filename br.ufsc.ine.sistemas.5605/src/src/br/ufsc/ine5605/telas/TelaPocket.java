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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import src.br.ufsc.ine5605.controllers.PocketController;
import src.br.ufsc.ine5605.objects.ETipo;
import src.br.ufsc.ine5605.persistencia.PocketDAO;

/**
 *
 * @author Joao
 */
public class TelaPocket extends JFrame {

    private JTable table;
    private DefaultTableModel tableModel;

    private JLabel velocidadeLabel;
    private JLabel descricaoLabel;
    private JLabel ataqueLabel;
    private JLabel defesaLabel;
    private JLabel nomeLabel;
    private JLabel nickLabel;
    private JLabel tipoLabel;
    private JLabel vidaLabel;

    private JTextField velocidadeField;
    private JTextArea descricaoField;
    private JTextField defesaField;
    private JTextField ataqueField;
    private JTextField nomeField;
    private JTextField vidaField;
    private JTextField nickField;

    private JComboBox tipoField;

    private JButton cadastrarBtn;
    private JButton limparBtn;
    private JButton removerBtn;
    private JButton editarBtn;

    private String record;

    private void initTable() {

        String[] columnNames = {
            "Nome",
            "Nick",
            "Descricao",
            "Tipo",
            "Ataque",
            "Defesa",
            "Vida",
            "Velocidade"
        };

        tableModel = new DefaultTableModel(columnNames, 0);

        PocketDAO.getInstancia().getList().stream().forEach((pokemon) -> {
            tableModel.addRow(new Object[]{
                pokemon.getNome(),
                pokemon.getNick(),
                pokemon.getDescricao(),
                pokemon.getTipo(),
                pokemon.getAtaque(),
                pokemon.getDefesa(),
                pokemon.getVida(),
                pokemon.getVelocidade()
            });
        });

        table.setModel(tableModel);
        this.repaint();

    }

    public TelaPocket() {
        super("Pocket");

        JPanel panel = new JPanel(new GridBagLayout());

        this.getContentPane().setLayout(new GridBagLayout());
        this.getContentPane().add(panel);

        GridBagConstraints gbc = new GridBagConstraints();

        JPanel tableButtonPanel = new JPanel();

        removerBtn = new JButton();
        removerBtn.setText("Libertar Pokémon");

        GerenciadorBotao btManager = new GerenciadorBotao();

        removerBtn.addActionListener(btManager);
        removerBtn.setActionCommand("1");

        tableButtonPanel.add(removerBtn);

        JPanel buttonPanel = new JPanel();

        JPanel detalhesPanel = this.pokemonDetalhes();
        detalhesPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JScrollPane tableScrollPane = new JScrollPane(table);
        table = new JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };
        table.getTableHeader().setReorderingAllowed(false);
//        table.addMouseListener(mouseManager);
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                selecionaRow(evt);
            }
        });

        this.initTable();

        Dimension dimension = new Dimension(300, 200);
        tableScrollPane.setPreferredSize(dimension);

        JLabel label = new JLabel("Pokemons capturados");

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
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.anchor = GridBagConstraints.NORTH;

        panel.add(detalhesPanel, gbc);

        this.pack();

        setLocationRelativeTo(null);

        this.setVisible(true);
    }

    public JPanel pokemonDetalhes() {

        JPanel panel = new JPanel();

        velocidadeLabel = new JLabel("Velocidade");
        descricaoLabel = new JLabel("Descricao");
        ataqueLabel = new JLabel("Ataque");
        defesaLabel = new JLabel("Defesa");
        nomeLabel = new JLabel("Nome");
        nickLabel = new JLabel("Nick");
        tipoLabel = new JLabel("Tipo");
        vidaLabel = new JLabel("Vida");

        velocidadeField = new JTextField("");
        vidaField = new JTextField("");
        ataqueField = new JTextField("");
        defesaField = new JTextField("");
        nomeField = new JTextField("");
        nickField = new JTextField("");
        descricaoField = new JTextArea("");
        tipoField = new JComboBox(ETipo.values());
        velocidadeField.setEnabled(false);
        vidaField.setEnabled(false);
        ataqueField.setEnabled(false);
        defesaField.setEnabled(false);
        nomeField.setEnabled(false);
        nickField.setEnabled(false);
        descricaoField.setEnabled(false);
        tipoField.setEnabled(false);

        panel.setLayout(new GridBagLayout());
        descricaoField.setWrapStyleWord(true);
        descricaoField.setLineWrap(true);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(2, 2, 2, 2);
        gbc.anchor = GridBagConstraints.NORTHEAST;

        int i = 0;

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = i;

        panel.add(nomeLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = i;

        panel.add(nomeField, gbc);

        i++;

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = i;

        panel.add(nickLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = i;

        panel.add(nickField, gbc);

        i++;

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = i;

        panel.add(descricaoLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 2;
        gbc.gridx = 1;
        gbc.gridy = i;

        panel.add(descricaoField, gbc);

        i++;

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = i;

        panel.add(tipoLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = i;

        panel.add(tipoField, gbc);

        i++;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = i;

        panel.add(ataqueLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = i;

        panel.add(ataqueField, gbc);

        i++;
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = i;

        panel.add(defesaLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = i;

        panel.add(defesaField, gbc);

        i++;

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = i;

        panel.add(vidaLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = i;

        panel.add(vidaField, gbc);

        i++;

        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = i;

        panel.add(velocidadeLabel, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;
        gbc.gridx = 1;
        gbc.gridy = i;

        panel.add(velocidadeField, gbc);

        return panel;

    }

    private void selecionaRow(MouseEvent ev) {
        nomeField.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
        record = table.getValueAt(table.getSelectedRow(), 0).toString();
        nickField.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
        descricaoField.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
        tipoField.setSelectedItem(table.getValueAt(table.getSelectedRow(), 3));
        ataqueField.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
        defesaField.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
        vidaField.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
        velocidadeField.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
    }

    private void limparCampos() {
        nomeField.setText("");
        nickField.setText("");
        descricaoField.setText("");
        tipoField.setSelectedIndex(0);
        ataqueField.setText("");
        defesaField.setText("");
        vidaField.setText("");
        velocidadeField.setText("");
        initTable();
    }

    private class GerenciadorBotao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()) {
                case "1": {
                    try {
                        PocketController.getInstancia().soltarPokemon(table.getValueAt(table.getSelectedRow(), 0).toString());
                        initTable();
                        limparCampos();
                    } catch (Exception exc) {
                        if (!exc.getMessage().equals("-1")) {
                            JOptionPane.showMessageDialog(null, exc.getMessage());
                        }
                    }
                    break;
                }

            }
        }
    }

}
