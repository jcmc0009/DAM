package Ejercicio2;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class AeroGeneradorIO{

    /**
     * Ruta del archivo donde se lee y escribe la colección de objetos AeroGenerador
     */
    private String rutaArchivo;

    /**
     * Método constructor
     * @param archivo Ruta del archivo donde se lee y escribe la colección de objetos AeroGenerador
     */
    public AeroGeneradorIO(String archivo) {
        this.rutaArchivo = archivo;
    }
 
    /**
     * Método que lee, desde un archivo binario, una colección de objetos AeroGenerador serializados.
     * @return Lista de objetos AeroGenerador que estaba almacenada en el archivo binario.
     */
    public List leer() {
        
    }

    /**
     * Método que escribe, en un archivo binario, una colección de objetos AeroGenerador serializables.
     * @param aeroGens Lista de objetos AeroGenerador serializables para almacenar en el archivo binario.
     */
    public void escribir(List aeroGens) {
       
    }
    
  
        try {

            // Abrir fichero para escribir en el, en la ruta que me interesa
            FileOutputStream fichero = new FileOutputStream(new File(rutaArchivo));

            ObjectOutputStream ficheroSalida = new ObjectOutputStream(fichero);

            ficheroSalida = new ObjectOutputStream(fichero);

            // Escribo el array en el fichero
            ficheroSalida.writeObject(misAerog);

            // También escribo dos datos que me interesan
            // Cerramos el fichero
            ficheroSalida.close();

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio2.class.getName()).log(Level.SEVERE, null, ex);
        }
    

    

}
