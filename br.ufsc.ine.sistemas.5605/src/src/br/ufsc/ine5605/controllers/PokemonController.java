/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.controllers;

import java.util.ArrayList;
import java.util.Random;
import src.br.ufsc.ine5605.exceptions.PokemonJahExisteException;
import src.br.ufsc.ine5605.exceptions.PokemonNaoExisteException;
import src.br.ufsc.ine5605.exceptions.TipoNaoExisteException;
import src.br.ufsc.ine5605.exceptions.ValorEhZeroException;
import src.br.ufsc.ine5605.exceptions.ValorInvalidoException;
import src.br.ufsc.ine5605.objects.ETipo;
import src.br.ufsc.ine5605.objects.Pokemon;
import src.br.ufsc.ine5605.persistencia.PokemonDAO;
import src.br.ufsc.ine5605.telas.TelaPokemon;

/**
 *
 * @author Joao
 */
public class PokemonController {

    private ArrayList<Pokemon> pokemons = new ArrayList<>();
    private TelaPokemon tela;
    private Pokemon pokemon;
    private PrincipalController principalControll;

    private static PokemonController instancia;

    public PokemonController() {
        PokemonDAO.getInstancia().put(new Pokemon("Pikachu", "Principal", "Elétrico!", 8, 10, 8, 50, ETipo.GRAMA));
        PokemonDAO.getInstancia().put(new Pokemon("Bulbassauro", "Secundario", "Folhoso!", 5, 8, 8, 50, ETipo.GRAMA));
        PokemonDAO.getInstancia().put(new Pokemon("Charizard", "Terciario", "Fogoso!", 7, 9, 8, 50, ETipo.FOGO));
        PokemonDAO.getInstancia().put(new Pokemon("Squirtle", "Quarto", "Aguoso!!", 6, 11, 8, 50, ETipo.AGUA));
    }

    public static PokemonController getInstancia() {
        if (instancia == null) {
            instancia = new PokemonController();
        }
        return instancia;
    }

    public void addPokemon(String nome, String nick, String descricao, int velocidade, int ataque, int defesa, int vida, int escolhaTipo) throws PokemonJahExisteException {
        ETipo tipo = this.verificaTipo(escolhaTipo);
        System.out.println(escolhaTipo);
        if (this.getPokemonByName(nome) != null) {
            throw new PokemonJahExisteException();
        }

        if (velocidade <= 0 || ataque <= 0 || defesa <= 0 || vida <= 0) {
            throw new ValorEhZeroException();
        }

        pokemon = new Pokemon(nome, nick, descricao, velocidade, ataque, defesa, vida, tipo);
        PokemonDAO.getInstancia().put(pokemon);

    }

    public void delPokemon(Pokemon pokemon) {
        if (pokemon == null) {
            throw new PokemonNaoExisteException();
        } else {
            PocketController.getInstancia().soltarPokemon(pokemon.getNome());
            PokemonDAO.getInstancia().remove(pokemon);

        }
    }

    public Pokemon getPokemonByName(String name) {
        return PokemonDAO.getInstancia().getPokemon(name);
    }

    public Pokemon getAleatorio() {
        Random pokemonAleatorio = new Random();
        return PokemonDAO.getInstancia().getList().get(pokemonAleatorio.nextInt(PokemonDAO.getInstancia().getList().size()));
    }

    public void listarTarefas() {
        tela = new TelaPokemon();
        tela.setVisible(true);

    }

    private ETipo verificaTipo(int escolhaTipo) {
        if (escolhaTipo > 2 || escolhaTipo < 0) {
            throw new TipoNaoExisteException();
        }

        ETipo tipoVerificado = null;
        switch (escolhaTipo) {
            case 0:
                tipoVerificado = ETipo.AGUA;
                break;
            case 1:
                tipoVerificado = ETipo.GRAMA;
                break;
            case 2:
                tipoVerificado = ETipo.FOGO;
                break;
        }
        return tipoVerificado;
    }

    public void editarPokemon(String editado, String newNome, String nick, String descricao, int velocidade, int ataque, int defesa, int vida, int tipoIndex) throws PokemonJahExisteException {

        newNome = newNome.trim();
        nick = nick.trim();
        descricao = descricao.trim();
        if (newNome.equals("") || nick.equals("") || descricao.equals("")) {
            throw new ValorInvalidoException();
        }

        ETipo tipoVerificado = this.verificaTipo(tipoIndex);
        if (velocidade <= 0 || ataque <= 0 || defesa <= 0 || vida <= 0) {
            throw new ValorEhZeroException();
        }

        Pokemon editedPokemon = new Pokemon(newNome, nick, descricao, velocidade, ataque, defesa, vida, tipoVerificado);

        PokemonDAO.getInstancia().remove(this.getPokemonByName(editado));
        PokemonDAO.getInstancia().put(editedPokemon);
        if (PocketController.getInstancia().getPokemonByName(editado) != null) {
            PocketController.getInstancia().editar(editedPokemon, editado);
        }

    }

}
