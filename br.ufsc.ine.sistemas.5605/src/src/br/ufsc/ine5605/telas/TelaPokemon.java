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
import src.br.ufsc.ine5605.objects.ETipo;
import src.br.ufsc.ine5605.persistencia.PokemonDAO;
import src.br.ufsc.ine5605.controllers.PokemonController;
import src.br.ufsc.ine5605.controllers.PrincipalController;
import src.br.ufsc.ine5605.exceptions.ValorInvalidoException;

/**
 *
 * @author Joao
 */
public class TelaPokemon extends JFrame {

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
    private JButton capturarBtn;

    private JPanel tableButtonPanel;
    private JPanel buttonPanel;
    private JPanel detalhesPanel;

    private JScrollPane tableScrollPane;

    public TelaPokemon() {
        super("Pokémon");
        this.initTelaPokemon();
        
    }

    private void initTelaPokemon() {
        JPanel panel = new JPanel(new GridBagLayout());
        this.getContentPane().setLayout(new GridBagLayout());
        this.getContentPane().add(panel);

        tableButtonPanel = new JPanel();

        this.createButtons(tableButtonPanel);

        buttonPanel = new JPanel();
        detalhesPanel = this.pokemonDetalhes();
        detalhesPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        this.manageTable();
        this.initTable();

        this.layoutManager(panel);

        this.pack();
        setSize(860, 380);
        setResizable(false);
        setLocationRelativeTo(null);
    }

    public JPanel pokemonDetalhes() {

        JPanel panel = new JPanel();
        this.createDetalhesLabels();

        panel.setLayout(new GridBagLayout());

        this.layoutDetalhesManager(panel);
        return panel;

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

    private void createButtons(JPanel tableButtonPanel) {
        cadastrarBtn = new JButton();
        editarBtn = new JButton();
        removerBtn = new JButton();
        capturarBtn = new JButton();
        limparBtn = new JButton();

        cadastrarBtn.setText("Cadastrar Pokémon");
        editarBtn.setText("Editar Pokémon");
        removerBtn.setText("Remover");
        limparBtn.setText("Limpar campos");
        capturarBtn.setText("Capturar Pokémon");

        GerenciadorBotao btManager = new GerenciadorBotao();

        cadastrarBtn.addActionListener(btManager);
        cadastrarBtn.setActionCommand("1");

        editarBtn.addActionListener(btManager);
        editarBtn.setActionCommand("2");

        removerBtn.addActionListener(btManager);
        removerBtn.setActionCommand("3");

        limparBtn.addActionListener(btManager);
        limparBtn.setActionCommand("4");

        capturarBtn.addActionListener(btManager);
        capturarBtn.setActionCommand("5");

        tableButtonPanel.add(cadastrarBtn);
        tableButtonPanel.add(editarBtn);
        tableButtonPanel.add(removerBtn);
        tableButtonPanel.add(capturarBtn);
        tableButtonPanel.add(limparBtn);
    }

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

        PokemonDAO.getInstancia().getList().stream().forEach((pokemon) -> {
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

    private void manageTable() {

        GerenciadorMouse mouseManager = new GerenciadorMouse();
        tableScrollPane = new JScrollPane(table);
        table = new JTable() {
            @Override
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };

        table.getTableHeader().setReorderingAllowed(false);
        table.addMouseListener(mouseManager);

        Dimension dimension = new Dimension(300, 200);
        tableScrollPane.setPreferredSize(dimension);
    }

    private void layoutManager(JPanel panel) {
        GridBagConstraints gbc = new GridBagConstraints();
        JLabel label = new JLabel("Pokémons cadastrados");

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
    }

    private void createDetalhesLabels() {
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

        descricaoField.setWrapStyleWord(true);
        descricaoField.setLineWrap(true);

    }

    private class GerenciadorMouse implements MouseListener {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            nomeField.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
            nickField.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
            descricaoField.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
            tipoField.setSelectedItem(table.getValueAt(table.getSelectedRow(), 3));
            ataqueField.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
            defesaField.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
            vidaField.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
            velocidadeField.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
        }

        @Override
        public void mousePressed(java.awt.event.MouseEvent e) {
        }

        @Override
        public void mouseReleased(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mouseEntered(java.awt.event.MouseEvent e) {

        }

        @Override
        public void mouseExited(java.awt.event.MouseEvent e) {

        }

    }

    private class GerenciadorBotao implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            switch (e.getActionCommand()) {
                case "1": {
                    try {
                        int velParsed;
                        int atqParsed;
                        int defParsed;
                        int vidaParsed;

                        try {

                            velParsed = Integer.parseInt(velocidadeField.getText());
                            atqParsed = Integer.parseInt(ataqueField.getText());
                            defParsed = Integer.parseInt(defesaField.getText());
                            vidaParsed = Integer.parseInt(vidaField.getText());

                        } catch (NumberFormatException excNumber) {
                            throw new ValorInvalidoException();
                        }
                        PokemonController.getInstancia().addPokemon(
                                nomeField.getText(),
                                nickField.getText(),
                                descricaoField.getText(),
                                velParsed,
                                atqParsed,
                                defParsed,
                                vidaParsed,
                                tipoField.getSelectedIndex()
                        );
                        limparCampos();
                        initTable();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
                    break;
                }
                case "2": {
                        try {
                            try {
                            int velParsed;
                            int atqParsed;
                            int defParsed;
                            int vidaParsed;

                            try {

                                velParsed = Integer.parseInt(velocidadeField.getText());
                                atqParsed = Integer.parseInt(ataqueField.getText());
                                defParsed = Integer.parseInt(defesaField.getText());
                                vidaParsed = Integer.parseInt(vidaField.getText());

                            } catch (NumberFormatException excNumber) {
                                throw new ValorInvalidoException();
                            }

                            PokemonController.getInstancia().editarPokemon(
                                    table.getValueAt(table.getSelectedRow(), 0).toString(),
                                    nomeField.getText(),
                                    nickField.getText(),
                                    descricaoField.getText(),
                                    velParsed,
                                    atqParsed,
                                    defParsed,
                                    vidaParsed,
                                    tipoField.getSelectedIndex()
                            );
                            limparCampos();
                            initTable();
                            } catch (ArrayIndexOutOfBoundsException exout){
                                JOptionPane.showMessageDialog(null, "Selecione um valor da lista");
                            }
                        } catch (Exception exception) {
                            JOptionPane.showMessageDialog(null, exception.getMessage());
                        }

                    

                    break;
                }
                case "3": {
                    try {
                        PokemonController.getInstancia().delPokemon(PokemonController.getInstancia().getPokemonByName(table.getValueAt(table.getSelectedRow(), 0).toString()));
                        initTable();
                        limparCampos();
                    } catch (Exception exc) {
                        if (!exc.getMessage().equals("-1")) {
                            JOptionPane.showMessageDialog(null, exc.getMessage());
                        }
                    }
                    break;
                }
                case "4": {
                    limparCampos();
                    break;
                }
                case "5": {
                    try {
                        PrincipalController.getInstancia().acessaPocket().capturaPokemon(table.getValueAt(table.getSelectedRow(), 0).toString());
                    } catch (Exception exc1) {
                        if (!exc1.getMessage().equals("-1")) {
                            JOptionPane.showMessageDialog(null, exc1.getMessage());
                        }
                    }
                    break;
                }
            }
        }
    }

}
