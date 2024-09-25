package junio.ejercicio3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 *
 * @author
 */
public class Ejercicio3 {

    public static void main(String[] args) {
        String rutafichero = System.getProperty("user.dir") + "/fichero.txt";
        int unidades = 0;
        String codigo = "", nombre = "", unidadMedida = "";

        File fileArchivo = new File(rutafichero);
        try {
            FileReader fr = new FileReader(fileArchivo);
            BufferedReader bufferArchivoExamen = new BufferedReader(fr);
            String linea = bufferArchivoExamen.readLine();
            StringTokenizer coeficientes = new StringTokenizer(linea, " ");
            StringBuilder sb = new StringBuilder();
            String line;
            List<Producto> listaProductosValidos = new ArrayList<>();
            while ((line = bufferArchivoExamen.readLine()) != null) {
                sb.append(line);
                //listaProductosValidos.add();
                sb.append("\n");
            }
            fr.close();
            System.out.println("-----------------------------------------");
            System.out.println("-Ejercicio 3 de fichero de TEXTO a lista-");
            System.out.println("-----------------------------------------");
            System.out.println("Leyendo líneas del archivo...");
            //StringTokenizer comercial = new StringTokenizer(sb.toString(), ";");
            while (coeficientes.hasMoreTokens()) {
                System.out.println(coeficientes.nextToken());   //returns a string that textually represents the object 

            }
            System.out.println("Total de productos válidos( " + listaProductosValidos.size() + " líneas que empiezen por COD):");
            for (int i = 0; i < listaProductosValidos.size(); i++) {

                System.out.println("Producto: " + codigo + " nombre: " + unidades + " unidades " + unidadMedida);

            }
        } catch (IOException e) {
        }

    }

}
