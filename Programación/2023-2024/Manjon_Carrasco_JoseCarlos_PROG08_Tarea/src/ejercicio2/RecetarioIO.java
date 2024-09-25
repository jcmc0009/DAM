package ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * Clase encargada de realizar la lectura y escritura de objetos Recetario en
 * archivos binarios.
 *
 * @author José Carlos Manjón Carrasco
 */
public class RecetarioIO {

    // Ruta del archivo donde se lee y escribe el objeto Recetario
    private String rutaArchivo;
    private static final long serialVersionUID = 42L;

    /**
     * Método constructor
     *
     * @param archivo Ruta del archivo donde se lee y escribe el objeto
     * Recetario
     */
    public RecetarioIO(String archivo) {
        this.rutaArchivo = archivo;
    }

    // -----------------------------------------------------
    // Ejercicio 2: Métodos que debe implementar el alumnado
    // -----------------------------------------------------
    /**
     * Método que lee, desde un archivo binario, un objeto Recetario
     * serializado.
     *
     * @return Objeto Recetario que estaba almacenado en el archivo binario.
     */
    
    public Recetario leer() {
        try {
            FileInputStream fichero = new FileInputStream(System.getProperty("user.dir") + "/recursos/Recetario.dat");
            ObjectInputStream objetostream = new ObjectInputStream(fichero);
            Object objeto = objetostream.readObject();
            if (objeto instanceof Recetario) {
                return (Recetario) objeto;
            } else {
                System.out.println("El objeto leído no es de tipo Recetario");
            }
            objetostream.close();
        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }
        return null; // Devuelve null si no se puede leer un Recetario válido
    }

    /**
     * Método que escribe, en un archivo binario, un objeto Recetario
     * serializable.
     *
     * @param recetario Objeto Recetario serializable para almacenar en el
     * archivo binario.
     */
    public void escribir(Recetario recetario) {
        try {
            // Abrir fichero para escribir en él, en la ruta que me interesa
            FileOutputStream fichero = new FileOutputStream(new File(rutaArchivo));
            ObjectOutputStream ficheroSalida = new ObjectOutputStream(fichero);

            // Escribo el objeto recetario en el fichero
            ficheroSalida.writeObject(recetario);

            // Cierro el fichero
            ficheroSalida.close();
            
            

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
