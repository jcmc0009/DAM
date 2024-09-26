package junio.ejercicio3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Ejercicio 3
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio3 {

    public static void main(String[] args) throws IOException {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Definir e instanciar el mapa para almacenar los datos donde las claves son enteros y los valores son listas de enteros
        Map<Integer, ArrayList> listaMultiplos = new TreeMap<>();
        ArrayList<Integer> lista = new ArrayList<>();

        String contenidoArchivo = "";
        String ruta = System.getProperty("user.dir") + "/src/recursos/Multiplos.txt";
        String rutaMala = System.getProperty("user.dir") + " ";


        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        /* Rellenar la estructura con los 5 primeros números a partir del 2 y sus 10 primeros múltiplos
                        (nota: debes utilizar estructuras de repetición)                                 */
        int contador = 2;
        int contadorDos = 0;
        for (int i = 2; i < 7; i++) {
            for (int j = 1; j <= 10; j++) {
                lista.add(i * 2);
                if (listaMultiplos.containsKey(i)) {
                    listaMultiplos.put((i + contadorDos), lista);
                    /*int valor = (listaMultiplos.(i, lista.add(i * 2)));
                    mapaOcurrencias.put(palabrasSplit[i], valor + 1
                    );*/
                } else {
                    listaMultiplos.put((i + contadorDos), lista);
                }

            }

            //  listaMultiplos.put((i + contadorDos), lista);
            contadorDos++;
            contenidoArchivo += "Multiplos de " + contador + ": " + listaMultiplos.toString() + "\n";
            contador++;
        }

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
            System.out.println("El fichero Multiplos.txt ha sido generado correctamente");
        } catch (IOException ex) {
            System.out.println(ex);
        }

        if (archivo.exists()) {
            // El fichero ya existe
        } else {
            // El fichero no existe y hay que crearlo
            bw = new BufferedWriter(new FileWriter(archivo));

            //bw.close(); // Debe cerrarse la escritura del fichero
        }

        try {
            FileWriter fileRoute = new FileWriter(rutaMala);
            fileRoute.write(contenidoArchivo);
            fileRoute.close();
        } catch (IOException ex) {
            System.out.println("Error al escribir en el fichero : " + ruta);

        }
    }
}
