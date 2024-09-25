/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package excepciones.main.java.Parking;

import java.util.ArrayList;

/**
 *
 * @author JCMCarra
 */
public class Parking {

    private ArrayList<String> matriculas;
    private String nombre;

    public Parking(String nombre, int numerPlazas) {
        matriculas = new ArrayList<>();
        for (int i = 0; i < numerPlazas; i++) {
            matriculas.add(null);

        }

        this.nombre = nombre;

    }

    public String getNombre() {
        return nombre;
    }

    public void entrada(String matricula, int plaza) throws Exception {
        try {
            if (matricula == null || matricula.length() < 4) {
                throw new Exception("Matrícula no válida");

            }
            if (matriculas.get(plaza) != null) {
                throw new Exception("Plaza ya está ocupada");
            }
            if (matriculas.contains(matricula)) {
                throw new Exception("Matrícula ya en parking");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        matriculas.set(plaza, matricula);

    }
    public void salida(String matricula){
        matriculas.remove(matricula);
    }
}
