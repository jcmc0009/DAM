package ejercicio3;

import com.thoughtworks.xstream.XStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;

/**
 * Clase que permite serializar un objeto Recetario al formato XML y viceversa.
 *
 * @author José Carlos Manjón Carrasco
 */
public class RecetarioXML implements Serializable {

    // Ruta del archivo donde se lee y escribe el objeto Recetario
    private String rutaArchivo;

    // Objeto Xstream que permite la L/E con archivos XML
    private XStream xstream;

    /**
     * Método constructor
     *
     * @param nombreArchivo Ruta del archivo donde se lee y escribe el objeto
     * Recetario
     */
    public RecetarioXML(String nombreArchivo) {
        this.rutaArchivo = nombreArchivo;
        this.xstream = new XStream();
        //Permite asignar privilegios para poder operar con los archivos XML
        this.xstream.allowTypesByWildcard(new String[]{
            "ejercicio3.**",
            "com.mydomain.utilitylibraries.**"
        });
    }

    // -----------------------------------------------------
    // Ejercicio 3: Métodos que debe implementar el alumnado
    // -----------------------------------------------------
    // 3.1. Método escribir()
    /**
     * Método que escribe, en un archivo de texto, un objeto Recetario
     * serializable.
     *
     * @param recetario Objeto Recetario serializable para almacenar en el
     * archivo de texto.
     */
    public void escribir(Recetario mirecetario) {

        String xml = xstream.toXML(mirecetario); // serialize to XML 
        File fArchivo = new File(rutaArchivo);//creamos archivo
        try (
                PrintWriter pwArchivo = new PrintWriter(fArchivo);) {
            pwArchivo.print(xml);
            pwArchivo.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo " + rutaArchivo + "·no encontrado.");
        }

    }

    public Recetario leer() {

        String xml = "";
        String contenidoArchivo = "";
        Recetario recetas = null;
        File fArchivo = new File(rutaArchivo);//cargamos el archivo

        try (BufferedReader brArchivo = new BufferedReader(new FileReader(fArchivo));) {//metemos en un buffer el archivo para leerlo

            while ((contenidoArchivo = brArchivo.readLine()) != null) {//con este bucle leemos el archivo y lo acumulamos en un nuevo string hasta que el archivo se acabe
                xml += contenidoArchivo;
            }
            brArchivo.close();//cerramos archivo

            recetas = (Recetario) xstream.fromXML(xml); // deserializamos el XML 

        } catch (FileNotFoundException e) {
            System.out.println("Error: archivo " + rutaArchivo + "·no encontrado.");
        } catch (IOException e) {
            System.out.printf("Error de entrada/salida: %s\n", e.getMessage());
        } catch (Exception e) {
            System.out.printf("Error de entrada/salida: %s\n", e.getMessage());
        }
        return recetas;

    }

}
