/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import ut8_utilidades.ES;

/**
 *
 * @author JCMCarra
 */
public class Ejercicio5 {

    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    /**
     *
     * @author atecaiestrassierra
     */
    public static void main(String[] args) {
        String nombreArchivo = "";
        String numero;
        Scanner teclado = new Scanner(System.in);
        Map<String, Integer> mapaOcurrencias = new TreeMap<>();
        /*      do {
            System.out.println("Introduce números separados por espacios:");
            numero = teclado.nextLine();
            String[] numerosSeparados = numero.split("\\s+");
            /*for (String numeross : numerosSeparados) {
                System.out.println(numeross);
            }*/
 /*        } while (!numero.isEmpty() && (!numero.matches(".*\\d.*") || (!numero.matches(".*\\s.*"))));*/
        do {

            do {
                numero = ES.leeCadena("Introduce una cadena de texto de números positivos entre 1 y 8 cifras separados por espacios en blanco");
            } while (!numero.matches("[\\d\\s]+"));
            String[] palabrasSplit = numero.split(" ");
            for (int i = 0; i < palabrasSplit.length; i++) {

                System.out.println(palabrasSplit[i]);

                if (mapaOcurrencias.containsKey(palabrasSplit[i])) {
                    int valor = (mapaOcurrencias.get(palabrasSplit[i]));
                    mapaOcurrencias.put(palabrasSplit[i], valor + 1
                    );

                } else {
                    mapaOcurrencias.put(palabrasSplit[i], 1);
                }

            }
        } while (String.valueOf(numero).length() < 1 && String.valueOf(numero).length() > 8);

        System.out.println("Los número son " + numero);
        TreeMap<String, Integer> miTreeMapLeido = generarArchivoBinario(mapaOcurrencias);

        ut8_utilidades.ColeccionUtil.leerArchivoBinario(miTreeMapLeido);
 
    }

    public static TreeMap<String, Integer> generarArchivoBinario(Map<String, Integer> mapaOcurrencias) {
        String nombreArchivo;
        // Map<Integer, Integer> mapaOcurrencias = ut8_utilidades.ColeccionUtil.sacaMapaNumerosSeparadosPorBlancos(String.valueOf(numero));
        File f = null;
        do {
            nombreArchivo = ES.leeCadena("Dime un nombre de fichero binario...");
            String ruta = System.getProperty("user.dir") + "/src/ejercicio5/" + nombreArchivo + ".rec";
            try {
                f = new File(ruta);
            } catch (Exception e) {
                System.out.println("Error" + e.getMessage());
            }
        } while (f == null);
        try (ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream(f))) {
            escribiendo_fichero.writeObject(mapaOcurrencias);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        //archivo.matches("^[a-zA-Z][a-zA-Z0-9]{0,19}(\.[a-zA-Z
        //ultimo paso
        TreeMap<String, Integer> miTreeMapLeido = null;
        try (ObjectInputStream leyendo_fichero = new ObjectInputStream(new FileInputStream(f))) {
            miTreeMapLeido = (TreeMap<String, Integer>) leyendo_fichero.readObject();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            System.err.println(e.getMessage());
        }
        return miTreeMapLeido;
    }

}
