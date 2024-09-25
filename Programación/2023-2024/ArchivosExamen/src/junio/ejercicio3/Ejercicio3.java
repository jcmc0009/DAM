package junio.ejercicio3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 * @author Juanma Muñoz
 */
public class Ejercicio3 {

    public static void main(String[] args) throws FileNotFoundException, IOException {
        List<Producto> listaProductos = new ArrayList<>();
        FileReader fr = new FileReader("fichero.txt");

        System.out.println("---------------------------------------------");
        System.out.println("-- Ejercicio 3 De fichero de TEXTO a lista --");
        System.out.println("---------------------------------------------");

        System.out.println("Leyendo lineas del archivo...");

        try (BufferedReader br = new BufferedReader(fr)) {
            String linea;

            while ((linea = br.readLine()) != null) {
               

            }
        }

        System.out.println("\nTotal de productos válidos (3 líneas que empiezan por COD):");

        for (Producto listaProducto : listaProductos) {
            System.out.println("Producto: " + listaProducto.toString());

        }
    }

}
