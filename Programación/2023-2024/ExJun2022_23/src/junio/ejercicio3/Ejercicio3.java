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
                if (linea.startsWith("COD")) {
                    System.out.println("Leida línea válida como producto: " + linea);
                    String codigo = linea.substring(3, 6);
                    String denominacion = linea.substring(6, 13);
                    int cantidad = Integer.parseInt(linea.substring(13, 16));
                    String uMedida = linea.substring(16, 18);
                    Producto p = new Producto(codigo, denominacion, cantidad, uMedida);
                    listaProductos.add(p);
                } else {
                    System.out.println("Leída línea no válida como producto: " + linea);
                }

            }
        }

        System.out.println("\nTotal de productos válidos (3 líneas que empiezan por COD):");

        for (Producto listaProducto : listaProductos) {
            System.out.println("Producto: " + listaProducto.toString());

        }
    }

}
