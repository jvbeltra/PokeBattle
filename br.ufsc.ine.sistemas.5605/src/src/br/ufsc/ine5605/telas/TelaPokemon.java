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
import java.util.Scanner;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
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

    private JLabel velocidadeLabel;
    private JLabel descricaoLabel;
    private JLabel ataqueLabel;
    private JLabel defesaLabel;
    private JLabel nomeLabel;
    private JLabel nickLabel;
    private JLabel tipoLabel;
    private JLabel vidaLabel;

    private JTextField velocidadeField;
    private JTextField descricaoField;
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

    public TelaPokemon() {
        super("Pokemon");
        JPanel panel = new JPanel(new GridBagLayout());
        this.getContentPane().setLayout(new GridBagLayout());
        this.getContentPane().add(panel);
        GridBagConstraints gbc = new GridBagConstraints();

        JTable t = new JTable(null);
        JPanel tableButtonPanel = new JPanel();

        cadastrarBtn = new JButton();
        editarBtn = new JButton();
        removerBtn = new JButton();
        cancelarBtn = new JButton();

        cadastrarBtn.setText("Cadastrar Pokemon");
        editarBtn.setText("Editar Pokemon");
        removerBtn.setText("Remover");
        cancelarBtn.setText("Cancelar");

        tableButtonPanel.add(cadastrarBtn);
        tableButtonPanel.add(editarBtn);
        tableButtonPanel.add(removerBtn);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(cancelarBtn);
        JPanel detalhesPanel = this.pokemonDetalhes();
        detalhesPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

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

        //passar por cada pokemon do banco, dar push no array de data
        Object[][] data = {
            {
                "Pikachu", "Walrus", "Gosta de raiosss", "GRAMA", new Integer(5), new Integer(5), new Integer(5), new Integer(5), new Integer(5)
            },
            {
                "Bulbassauro", "Bulba", "Gosta de grama", "GRAMA", new Integer(5), new Integer(5), new Integer(5), new Integer(5), new Integer(5)
            },
            {
                "Charmander", "Charmandar", "Gosta de fogos", "FOGO", new Integer(5), new Integer(5), new Integer(5), new Integer(5), new Integer(5)
            },
            {
                "Squirtle", "Aguinha", "Gosta de agua", "AGUA", new Integer(5), new Integer(5), new Integer(5), new Integer(5), new Integer(5)
            },};

        JTable table = new JTable(data, columnNames);
        JScrollPane tableScrollPane = new JScrollPane(table);
        Dimension dimension = new Dimension(200, 50);
        tableScrollPane.setPreferredSize(dimension);
        rowSelectionManager rowClickSelection = new rowSelectionManager(table, this);
        table.getSelectionModel().addListSelectionListener(rowClickSelection);
        
        
        

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

        JLabel velocidadeLabel = new JLabel("Velocidade");
        JLabel descricaoLabel = new JLabel("Descricao");
        JLabel ataqueLabel = new JLabel("Ataque");
        JLabel defesaLabel = new JLabel("Defesa");
        JLabel nomeLabel = new JLabel("Nome");
        JLabel nickLabel = new JLabel("Nick");
        JLabel tipoLabel = new JLabel("Tipo");
        JLabel vidaLabel = new JLabel("Vida");

        JTextField velocidadeField = new JTextField("");
        JTextField vidaField = new JTextField("");
        JTextField ataqueField = new JTextField("");
        JTextField defesaField = new JTextField("");
        JTextField nomeField = new JTextField("");
        JTextField nickField = new JTextField("");
        JTextArea descricaoField = new JTextArea(5, 10);
        JComboBox tipoField = new JComboBox();

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

        return panel;
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

    private static class rowSelectionManager implements ListSelectionListener {
        
        JTable table;
        TelaPokemon context;
        Object record;
        Pokemon pokemon;
        public rowSelectionManager(JTable table, TelaPokemon context){
            this.table = table;
            this.context = context;
        }
        
        @Override
        public void valueChanged(ListSelectionEvent e) {
            Object record  = this.table.getValueAt(table.getSelectedRow(), 0);     
            this.setRecord(record);
            Pokemon pokemon = PokemonDAO.getInstancia().getPokemon(record.toString());
            
        }
        
        public void setRecord(Object record){
            this.record = record;
        }
        
        public Object getRecord(){
            return record;
        }
        
        

        
    }
}
