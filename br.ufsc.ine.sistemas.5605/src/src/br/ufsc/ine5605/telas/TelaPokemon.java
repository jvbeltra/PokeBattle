/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.telas;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.Scanner;
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
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import org.w3c.dom.events.MouseEvent;
import src.br.ufsc.ine5605.controllers.PokemonController;
import src.br.ufsc.ine5605.exceptions.PokemonJahExisteException;
import src.br.ufsc.ine5605.exceptions.PokemonNaoExisteException;
import src.br.ufsc.ine5605.exceptions.TipoNaoExisteException;
import src.br.ufsc.ine5605.exceptions.ValorEhZeroException;
import src.br.ufsc.ine5605.objects.ETipo;
import src.br.ufsc.ine5605.objects.Pokemon;
import src.br.ufsc.ine5605.persistencia.PokemonDAO;

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
    private JButton cancelarBtn;
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

        for (Pokemon pokemon : PokemonDAO.getInstancia().getList()) {
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
        }

        table.setModel(tableModel);
        this.repaint();

    }

    public TelaPokemon() {
        super("Pokemon");
        JPanel panel = new JPanel(new GridBagLayout());
        this.getContentPane().setLayout(new GridBagLayout());
        this.getContentPane().add(panel);
        GridBagConstraints gbc = new GridBagConstraints();

        JPanel tableButtonPanel = new JPanel();

        cadastrarBtn = new JButton();
        editarBtn = new JButton();
        removerBtn = new JButton();
        cancelarBtn = new JButton();

        cadastrarBtn.setText("Cadastrar Pokemon");
        editarBtn.setText("Editar Pokemon");
        removerBtn.setText("Remover");
        cancelarBtn.setText("Cancelar");

        GerenciadorBotao btManager = new GerenciadorBotao();
        GerenciadorMouse mouseManager = new GerenciadorMouse();

        cadastrarBtn.addActionListener(btManager);
        cadastrarBtn.setActionCommand("1");

        editarBtn.addActionListener(btManager);
        editarBtn.setActionCommand("2");

        tableButtonPanel.add(cadastrarBtn);
        tableButtonPanel.add(editarBtn);
        tableButtonPanel.add(removerBtn);

        JPanel buttonPanel = new JPanel();

        buttonPanel.add(cancelarBtn);
        JPanel detalhesPanel = this.pokemonDetalhes();
        detalhesPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        JScrollPane tableScrollPane = new JScrollPane(table);
        table = new JTable() {
            public boolean isCellEditable(int rowIndex, int colIndex) {
                return false;
            }
        };

        table.addMouseListener(mouseManager);

        this.initTable();

        Dimension dimension = new Dimension(200, 50);
        tableScrollPane.setPreferredSize(dimension);
//        rowSelectionManager rowClickSelection = new rowSelectionManager(table, this);

//        table.getSelectionModel().addListSelectionListener(rowClickSelection);
        JLabel label = new JLabel("Pokemons cadastrados ");

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;

        panel.add(label, gbc);

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
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
        gbc.gridheight = 2;
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
        descricaoField = new JTextArea(5, 10);
        tipoField = new JComboBox(ETipo.values());

        panel.setLayout(new GridBagLayout());

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

    private class GerenciadorMouse implements MouseListener {

        @Override
        public void mouseClicked(java.awt.event.MouseEvent e) {
            nomeField.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
            record = table.getValueAt(table.getSelectedRow(), 0).toString();
            nickField.setText(table.getValueAt(table.getSelectedRow(), 1).toString());
            descricaoField.setText(table.getValueAt(table.getSelectedRow(), 2).toString());
            tipoField.setSelectedItem(table.getValueAt(table.getSelectedRow(), 3));
            ataqueField.setText(table.getValueAt(table.getSelectedRow(), 4).toString());
            defesaField.setText(table.getValueAt(table.getSelectedRow(), 5).toString());
            vidaField.setText(table.getValueAt(table.getSelectedRow(), 6).toString());
            velocidadeField.setText(table.getValueAt(table.getSelectedRow(), 7).toString());
            
            nomeField.setEnabled(false);
            tipoField.setEnabled(false);
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
                        PokemonController.getInstancia().addPokemon(
                                nomeField.getText(),
                                nickField.getText(),
                                descricaoField.getText(),
                                Integer.parseInt(velocidadeField.getText()),
                                Integer.parseInt(ataqueField.getText()),
                                Integer.parseInt(defesaField.getText()),
                                Integer.parseInt(vidaField.getText()),
                                tipoField.getSelectedIndex()
                        );
                        initTable();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }
                }
                case "2": {
                    try {

                        Pokemon pokemonChanged = PokemonDAO.getInstancia().getPokemon(table.getValueAt(table.getSelectedRow(), 0).toString());
                        pokemonChanged.setNome(table.getValueAt(table.getSelectedRow(), 0).toString());
                        pokemonChanged.setNick(table.getValueAt(table.getSelectedRow(), 1).toString());
                        pokemonChanged.setDescricao(table.getValueAt(table.getSelectedRow(), 2).toString());
                        pokemonChanged.setAtaque(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 4).toString()));
                        pokemonChanged.setDefesa(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 5).toString()));
                        pokemonChanged.setVida(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 6).toString()));
                        pokemonChanged.setVelocidade(Integer.parseInt(table.getValueAt(table.getSelectedRow(), 7).toString()));
                        initTable();
                    } catch (Exception exception) {
                        JOptionPane.showMessageDialog(null, exception.getMessage());
                    }

                    break;
                }
                case "3": {

                    break;
                }
            }
        }
    }

}

//    private PokemonController pokemonControll;
//    private Scanner teclado = new Scanner(System.in);
//
//    public TelaPokemon(PokemonController pokemonControll) {
//        this.pokemonControll = pokemonControll;
//    }
//
//    public void listarTarefas() {
//        Scanner s = new Scanner(System.in);
//        int input;
//        try {
//            do {
//                System.out.println(
//                        "\n --- Selecione uma tarefa --- \n"
//                        + " 1: Cadastrar Pokemon \n"
//                        + " 2: Deletar Pokemon \n"
//                        + " 3: Editar Pokemon \n"
//                        + " 4: Listar Pokemons \n"
//                        + " 5: Buscar Pokemon pelo nome \n"
//                        + " 0: Sair \n"
//                );
//
//                input = teclado.nextInt();
//
//                switch (input) {
//                    case 1: {
//                        this.listarAdicao();
//                        break;
//                    }
//                    case 2: {
//                        pokemonControll.delPokemon();
//                        break;
//                    }
//                    case 3: {
//
//                        this.listarEdicao();
//                        break;
//                    }
//                    case 4: {
//                        pokemonControll.listarPokemons();
//                        break;
//                    }
//                    case 5: {
//                        System.out.println("Insira o nome do Pokemon desejado");
//                        String nome = s.next();
//                        System.out.println(pokemonControll.getPokemonByName(nome));
//                        break;
//                    }
//                }
//            } while (input > 0);
//        } catch (Exception e) {
//            if (e.toString().equals("java.util.InputMismatchException")) {
//                System.out.println("Insira um valor inteiro para selecionar a tarefa.");
//            }
//        }
//    }
//
//    public void listarAdicao() {
//        Scanner s = new Scanner(System.in);
//        try {
//            System.out.println("Insira o nome do novo Pokemon: ");
//            String nome = s.nextLine();
//
//            if (pokemonControll.getPokemonByName(nome) != null) {
//                throw new PokemonJahExisteException();
//            }
//
//            System.out.println("Insira o apelido: ");
//            String nick = s.nextLine();
//
//            System.out.println("Faça uma descrição do novo Pokemon");
//            String descricao = s.nextLine();
//
//            System.out.println("Insira a velocidade do novo Pokemon: ");
//            int velocidade = s.nextInt();
//            if (velocidade <= 0) {
//                throw new ValorEhZeroException();
//            }
//
//            System.out.println("Insira o ataque do novo Pokemon");
//            int ataque = s.nextInt();
//
//            if (ataque <= 0) {
//                throw new ValorEhZeroException();
//            }
//
//            System.out.println("Insira a defesa do novo Pokemon");
//            int defesa = s.nextInt();
//
//            if (defesa <= 0) {
//                throw new ValorEhZeroException();
//            }
//
//            System.out.println("Insira o valor de vida do novo Pokemon");
//            int vida = s.nextInt();
//            if (vida <= 0) {
//                throw new ValorEhZeroException();
//            }
//
//            int escolhaTipo = 0;
//
//            System.out.println("Escolha o tipo\n"
//                    + "1: Tipo Agua\n"
//                    + "2: Tipo Fogo\n"
//                    + "3: Tipo Grama\n"
//            );
//
//            escolhaTipo = s.nextInt();
//
//            if (escolhaTipo < 1 || escolhaTipo > 3) {
//                throw new TipoNaoExisteException();
//            }
//            pokemonControll.addPokemon(nome, nick, descricao, velocidade, ataque, defesa, vida, escolhaTipo);
//
//        } catch (Exception e) {
//            if (e.toString().equals("java.util.InputMismatchException")) {
//                System.out.println("Tipo de atributo não permitido.");
//            } else {
//                System.out.println(e.getMessage());
//            }
//        }
//    }
//
//    public void listarEdicao() {
//        Scanner s = new Scanner(System.in);
//        int toEdit;
//        try {
//            System.out.println("Insira o nome do Pokemon que você deseja editar.");
//            String pokemonName = s.nextLine();
//            if (pokemonControll.getPokemonByName(pokemonName) == null) {
//                throw new PokemonNaoExisteException();
//            }
//
//            System.out.println("Qual componente você deseja editar? ");
//            System.out.println("1: Nome ");
//            System.out.println("2: Nick ");
//            System.out.println("3: Descrição ");
//            System.out.println("4: Ataque ");
//            System.out.println("5: Defesa ");
//            System.out.println("6: Vida ");
//            System.out.println("7: Velocidade ");
//            System.out.println("8: Voltar");
//            System.out.println("0: Sair");
//
//            toEdit = s.nextInt();
//
//            if (toEdit > 0 && toEdit < 8) {
//                pokemonControll.editarPokemon(toEdit, pokemonName);
//            } else {
//                this.listarTarefas();
//            }
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        }
