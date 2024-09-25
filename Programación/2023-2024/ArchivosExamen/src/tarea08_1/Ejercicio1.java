package ejercicio1;

import java.io.File;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Ejercicio 1: Lectura/escritura de un recetario en ficheros de texto.
 *
 * @author profe
 */
public class Ejercicio1 {

    /**
     * Método principal.
     *
     * @param args argumentos que recibe el método
     */
    public static void main(String args[]) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        // Variables de salida
        // Variables auxiliares
        String rutaRecetas = System.getProperty("user.dir") + "/recursos/ListadoRecetas.txt";

        Recetario recetario = new Recetario();

        //----------------------------------------------
        //       Entrada de datos + Procesamiento
        //----------------------------------------------
        System.out.println("Abriendo archivo de recetas...");
        // Abrimos archivo de contactos ListadoRecetas.txt
        File fichero = new File(rutaRecetas);
        Scanner s = null;
        int i = 1;
        try {
            // Leemos el contenido del fichero
            System.out.println("... Leemos el contenido del fichero ...");
            s = new Scanner(fichero);

            // Leemos contenidoArchivo a contenidoArchivo el fichero
            String contenidoArchivo = null;

            while (s.hasNextLine()) {
                contenidoArchivo = s.nextLine(); 	// Guardamos la contenidoArchivo en un String
                String[] textos = contenidoArchivo.split(";");
                if (textos.length == 5) { // Asumiendo que hay 5 partes en la cadena separadas por ';'
                    String nombre = textos[0];
                    String tipoPlato = textos[1];
                    String fecha = textos[2];
                    String listaIngredientes = textos[3];
                    String instrucciones = textos[4];
                    recetario.add(new Receta(nombre, tipoPlato, LocalDate.parse(fecha), Arrays.asList(listaIngredientes.split(",")), instrucciones));

                }

            }

        } catch (Exception ex) {
            System.out.println("Mensaje: " + ex.getMessage());
        } finally {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (s != null) {
                    s.close();
                }
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
        System.out.println("Cerrando archivo de recetas...");

        System.out.println();

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        // Abrimos el archivo de la agenda Recetario.txt
        System.out.println("Abriendo archivo del recetario...");

        System.out.println("Cerrando archivo del recetario...");

        System.out.println();
        System.out.println("Archivos cerrados y procesamiento finalizado");
        System.out.println("---------");
        System.out.println();
        System.out.println(recetario.toString());
        //System.out.println(recetaPrimera.getNombre());
        System.out.println("Fin del programa.");
    }
}
