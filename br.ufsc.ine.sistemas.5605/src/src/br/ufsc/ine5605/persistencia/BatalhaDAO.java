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
import src.br.ufsc.ine5605.objects.Batalha;

/**
 *
 * @author Bruno
 */
public class BatalhaDAO {

    private static BatalhaDAO instancia;
    private HashMap<String, Batalha> cacheBatalhas;
    private final String fileName = "batalhas.dat";

    private BatalhaDAO() {
        cacheBatalhas = new HashMap<>();
        
        this.load();
    }

    public Batalha getBatalha(String titulo) {
        return cacheBatalhas.get(titulo);
    }

    public void put(Batalha batalha) {
        cacheBatalhas.put(batalha.getTitulo(), batalha);
        persist();
    }

    public void load() {
        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            this.cacheBatalhas = (HashMap<String, Batalha>) ois.readObject();

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

            oos.writeObject(cacheBatalhas);

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

    public ArrayList<Batalha> getList() {
        return new ArrayList(cacheBatalhas.values());
    }

    public static BatalhaDAO getInstancia() {
        if (instancia == null) {
            instancia = new BatalhaDAO();
        }
        return instancia;
    }

    public void remove(Batalha batalha) {
        cacheBatalhas.remove(batalha.getTitulo());
        persist();
    }
}
