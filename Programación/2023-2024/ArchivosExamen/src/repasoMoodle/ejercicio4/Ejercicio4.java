/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio4;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 *
 * @author JCMCarra
 */
public class Ejercicio4 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        Scanner input = new Scanner(System.in);
        Scanner archivo = new Scanner(System.in);
        String palabras = "";

        String textoArchivo = "";
        Map<String, Integer> listaPalabras = new TreeMap<>();

        do {
            System.out.println("Introduce un texto con palabras en minúsculas separadas por espacios:");
            palabras = input.nextLine();
            String[] palabrasSplit = palabras.split(" ");

            for (int i = 0; i < palabrasSplit.length; i++) {

                System.out.println(palabrasSplit[i]);

                if (listaPalabras.containsKey(palabrasSplit[i])) {
                    int valor = (listaPalabras.get(palabrasSplit[i]));
                    listaPalabras.put(palabrasSplit[i], valor + 1
                    );

                } else {
                    listaPalabras.put(palabrasSplit[i], 1);
                }

            }

        } while (palabras.trim().length() == 0);

        System.out.println("¡Gracias! El texto introducido es válido: " + palabras);
        //System.out.println(listaPalabras);
        for (Map.Entry<String, Integer> entry : listaPalabras.entrySet()) {
            //  System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
            textoArchivo += entry.getKey() + "--> " + entry.getValue() + "\n";
        }
        String nombreArchivo = "";
        while (nombreArchivo.length() == 0) {
            System.out.println("Introduce archivo donde guargar información");
            nombreArchivo = archivo.nextLine();
        }
        String ruta = System.getProperty("user.dir") + "/src/ejercicio4/" + nombreArchivo + ".rec";

        try {

            FileOutputStream fichero = new FileOutputStream(ruta);
            ObjectOutputStream objectOut = new ObjectOutputStream(fichero);
            // String textoAGuardar = "¡Hola, mundo!";
            objectOut.writeObject(textoArchivo);
            objectOut.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        try {
            FileInputStream ficheroDos = new FileInputStream(ruta);
            ObjectInputStream objetostream = new ObjectInputStream(ficheroDos);
            Object objeto = objetostream.readObject();
            if (objeto instanceof String) {
                String textoLeido = (String) objeto; // Convertir el objeto a String
                System.out.println(textoLeido);
            } else {
                System.out.println("El objeto leído no es de tipo correcto");
            }
            objetostream.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }

    }

}
