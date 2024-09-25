/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut8_utilidades;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.*;
import javax.swing.text.Document;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Node;

/**
 *
 * @author luisnavarro
 */
public class ColeccionUtil {

    public static void imprimirColeccion(Collection c) {
        Iterator it = c.iterator();
        while (it.hasNext()) {
            System.out.print(it.next());
        }
        System.out.println("");
    }

    public static void imprimirMapa(Map m) {
        //creo keyset iterador, iterando imprimo clave y valor asociado
        Set conjuntoDeClaves = m.keySet();
        Iterator it = conjuntoDeClaves.iterator();

        while (it.hasNext()) {
            String palabra = (String) (it.next());
            int n = (Integer) m.get(palabra);
            System.out.println(palabra + "-" + n);
        }

    }

    public static Map<String, Integer> sacaMapaPalabrasCadenaSeparadaPorBlancos(String cadena) {
        Map<String, Integer> mapaOcurrencias = new TreeMap<String, Integer>();
        String[] arrayPalabras = cadena.split(" ");
        /*
        for (String palabra : arrayPalabras) {
        //int n=mapaOcurrencias.geget(palabra);
        mapaOcurrencias.put(palabra, mapaOcurrencias.getOrDefault(palabra, 0)+1 );
        }*/
        for (String i : arrayPalabras) {
            if (mapaOcurrencias.containsKey(i)) {
                Integer Numero = mapaOcurrencias.get(i) + 1;
                mapaOcurrencias.put(i, Numero);
            } else {
                mapaOcurrencias.put(i, 1);
            }
        }
        return mapaOcurrencias;
    }

    public static Map<Integer, Integer> sacaMapaNumerosSeparadosPorBlancos(String cadena) {
        Map<Integer, Integer> mapaOcurrencias = new TreeMap<>();
        String[] numerosComoTexto = cadena.split(" ");

        for (String numeroTexto : numerosComoTexto) {
            try {
                int numero = Integer.parseInt(numeroTexto);
                mapaOcurrencias.put(numero, mapaOcurrencias.getOrDefault(numero, 0) + 1);
            } catch (NumberFormatException e) {
                // Manejo de error si hay texto que no es un número
            }
        }

        return mapaOcurrencias;
    }

    public static void leerArchivoBinario(TreeMap<String, Integer> miTreeMapLeido) {
        // Tengo miTreeMapLeido
// El mapa no es coleccion, pero puedo sacar una enumeración de sus claves e iterar por ellas, sacando valor asociado
//Mostramos por pantalla el archivo binario
        Set<String> conjuntoDeClaves = miTreeMapLeido.keySet();
        Iterator<String> it = conjuntoDeClaves.iterator();

        while (it.hasNext()) {
            String clave = it.next();
            int n = miTreeMapLeido.get(clave);
            System.out.println("El número " + clave + " ha aparecido " + n + ((n == 1) ? " vez" : " veces"));
        }
    }

    public static void escribirTxt(String ruta, String contenidoArchivo) throws IOException {
        File archivo = new File(ruta);
        BufferedWriter bw;
        if (archivo.exists()) {
            // El fichero ya existe
        } else {
            // El fichero no existe y hay que crearlo
            bw = new BufferedWriter(new FileWriter(archivo));

            //bw.close(); // Debe cerrarse la escritura del fichero
        }

        try {
            FileWriter fileRoute = new FileWriter(ruta);
            fileRoute.write(contenidoArchivo);
            fileRoute.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    public static void mostrarContenidoTxt(String rutaArchivo) throws IOException {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
            String linea;
            while ((linea = reader.readLine()) != null) {
                System.out.println(linea);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error al leer el archivo: " + e.getMessage());
        }
    }

    // Método para generar un archivo XML basado en una ruta y contenido de tipo String
    public static void generarXml(String rutaArchivo, String contenidoXml) {
        try {
            FileWriter fileWriter = new FileWriter(rutaArchivo);
            fileWriter.write(contenidoXml);
            fileWriter.close();
            System.out.println("Se ha generado el archivo XML en la ruta: " + rutaArchivo);
        } catch (IOException e) {

        }

    }
}
