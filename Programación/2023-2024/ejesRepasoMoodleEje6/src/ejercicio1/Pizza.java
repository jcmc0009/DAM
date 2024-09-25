/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author JCMCarra
 */
public class Pizza {

    private String nombre;
    private HashMap<Ingrediente, Integer> listaIngredientes;

    public Pizza(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        this.nombre = nombre;
        this.listaIngredientes = new HashMap<>();
    }

    public void addIngredientes(Ingrediente[] ings) {
        for (Ingrediente i : ings) {
            if (listaIngredientes.containsKey(i)) {
                int numVeces = listaIngredientes.get(i);
                numVeces++;
                if (numVeces < 3) {
                    listaIngredientes.put(i, numVeces);
                }
            } else {
                listaIngredientes.put(i, 1);
            }
        }
    }


public void eliminarIngredienteCompletamente(Ingrediente ing) {
        listaIngredientes.remove(ing);
    }

    public String getIngredientes() {
        return "Pizza{" + "nombre=" + nombre + ", listaIngredientes=" + listaIngredientes + '}';
    }

}
