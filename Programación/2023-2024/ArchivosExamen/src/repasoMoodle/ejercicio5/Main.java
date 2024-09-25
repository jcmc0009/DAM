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
public class Main {

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
        int numero;
        Scanner teclado = new Scanner(System.in);

        /*      do {
            System.out.println("Introduce números separados por espacios:");
            numero = teclado.nextLine();
            String[] numerosSeparados = numero.split("\\s+");
            /*for (String numeross : numerosSeparados) {
                System.out.println(numeross);
            }*/
 /*        } while (!numero.isEmpty() && (!numero.matches(".*\\d.*") || (!numero.matches(".*\\s.*"))));*/
 
        do {
            numero = ES.leeEntero("Introduce una cadena de texto de números positivos entre 1 y 8 cifras separados por espacios en blanco", 0);
            
        } while (String.valueOf(numero).length() < 1 || String.valueOf(numero).length() > 8);

        System.out.println("Los número son " + numero);
        Map<Integer, Integer> mapaOcurrencias = ut8_utilidades.ColeccionUtil.sacaMapaNumerosSeparadosPorBlancos(String.valueOf(numero));
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
        TreeMap<Integer, Integer> miTreeMapLeido = null;
        try (ObjectInputStream leyendo_fichero = new ObjectInputStream(new FileInputStream(f))) {
            miTreeMapLeido = (TreeMap<Integer, Integer>) leyendo_fichero.readObject();
        } catch (IOException | ClassNotFoundException | ClassCastException e) {
            System.err.println(e.getMessage());
        }

// Tengo miTreeMapLeido
// El mapa no es coleccion, pero puedo sacar una enumeración de sus claves e iterar por ellas, sacando valor asociado
        Set<Integer> conjuntoDeClaves = miTreeMapLeido.keySet();
        Iterator<Integer> it = conjuntoDeClaves.iterator();

        while (it.hasNext()) {
            int clave = it.next();
            int n = miTreeMapLeido.get(clave);
            System.out.println("El número " + clave + " ha aparecido " + n + ((n == 1) ? " vez" : " veces"));
        }

    }

}
