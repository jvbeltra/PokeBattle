/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.telas;

import java.util.Scanner;
import src.br.ufsc.ine5605.controllers.BatalhaController;
import java.util.Date;

/**
 *
 * @author Joao
 */
public class TelaBatalha {

    private BatalhaController batalhaControll;
    private Scanner teclado = new Scanner(System.in);

    public TelaBatalha(BatalhaController batalhaControll) {
        this.batalhaControll = batalhaControll;
    }

    public void listarTarefas() {

        try {
            int input = 0;
            do {
                System.out.println(
                        "\n --- Selecione uma tarefa --- \n"
                        + " 1: Batalhar \n"
                        + " 2: Mostrar histórico de batalhas \n"
                        + " 0: Sair"
                );

                input = teclado.nextInt();

                switch (input) {
                    case 1: {
                        this.selecionarLutadores();
                        break;
                    }
                    case 2: {
                        batalhaControll.listarBatalhas();
                        break;
                    }
                }
            } while (input > 0);

        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    

    public void selecionarLutadores() {
        Scanner s = new Scanner(System.in);
        System.out.println("Insira o nome do Pokemon que você utilizará: ");
        String nomeMyPokemon = s.nextLine();
        System.out.println("Insira o nome do Pokemon selvagem: ");
        String nomeSelvagem = s.nextLine();

        batalhaControll.batalhar(nomeMyPokemon, nomeSelvagem);
    }
}
