/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio6;

import ejercicio5.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
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
public class Ejercicio6 {

    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    /**
     *
     * @author atecaiestrassierra
     */
    public static void main(String[] args) throws IOException {
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
        } while (String.valueOf(numero).length() < 0 && String.valueOf(numero).length() > 99);
        
        System.out.println("Los número son " + numero);
        // Map<Integer, Integer> mapaOcurrencias = ut8_utilidades.ColeccionUtil.sacaMapaNumerosSeparadosPorBlancos(String.valueOf(numero));

// Tengo miTreeMapLeido
// El mapa no es coleccion, pero puedo sacar una enumeración de sus claves e iterar por ellas, sacando valor asociado
        Set<String> conjuntoDeClaves = mapaOcurrencias.keySet();
        Iterator<String> it = conjuntoDeClaves.iterator();
        String contenidoArchivo = "";
        while (it.hasNext()) {
            String clave = it.next();
            String numVeces = "";
            int n = mapaOcurrencias.get(clave);
            for (int i = 0; i < n; i++) {
                numVeces += "*";
            }
            contenidoArchivo += "El número " + clave + " : " + numVeces + "\n";
        }
        
        nombreArchivo = ES.leeCadena("Dime un nombre de fichero fomato txt...");
        String ruta = System.getProperty("user.dir") + "/src/ejercicio6/" + nombreArchivo + ".txt";
        ut8_utilidades.ColeccionUtil.escribirTxt(ruta, contenidoArchivo);
        ut8_utilidades.ColeccionUtil.mostrarContenidoTxt(ruta);
        
    }
    
}
