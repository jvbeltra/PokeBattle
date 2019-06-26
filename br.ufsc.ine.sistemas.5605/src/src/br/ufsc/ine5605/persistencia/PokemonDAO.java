/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src.br.ufsc.ine5605.persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import src.br.ufsc.ine5605.objects.Pokemon;

/**
 *
 * @author 13937264612
 */
public class PokemonDAO {

    private static PokemonDAO instancia;
    private HashMap<String, Pokemon> cachePokemons;
    private final String fileName = "pokemons.dat";

    private PokemonDAO() {
        cachePokemons = new HashMap<>();
        this.load();
    }

    public Pokemon getPokemon(String nome) {
        return cachePokemons.get(nome);
    }

    public void put(Pokemon pokemon) {
        cachePokemons.put(pokemon.getNome(), pokemon);
        persist();
    }

    public void load() {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.cachePokemons = (HashMap<String, Pokemon>) ois.readObject();

            ois.close();
            fis.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
            persist();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PokemonDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void persist() {
        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(cachePokemons);

            oos.flush();
            fos.flush();

            oos.close();
            fos.close();

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public ArrayList<Pokemon> getList() {
        return new ArrayList(cachePokemons.values());
    }

    public static PokemonDAO getInstancia() {
        if (instancia == null) {
            instancia = new PokemonDAO();
        }
        return instancia;
    }

    public void remove(Pokemon pokemon) {
        cachePokemons.remove(pokemon.getNome());
        persist();
    }
}