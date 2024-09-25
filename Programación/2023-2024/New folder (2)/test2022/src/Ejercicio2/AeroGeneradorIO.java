package Ejercicio2;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.*;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;

public class AeroGeneradorIO implements Serializable {

    /**
     * Ruta del archivo donde se lee y escribe la colección de objetos
     * AeroGenerador
     */
    private String rutaArchivo;
    private static final long serialVersionUID = 42L;

    /**
     * Método constructor
     *
     * @param archivo Ruta del archivo donde se lee y escribe la colección de
     * objetos AeroGenerador
     */
    public AeroGeneradorIO(String archivo) {
        this.rutaArchivo = archivo;
    }

    /**
     * Método que lee, desde un archivo binario, una colección de objetos
     * AeroGenerador serializados.
     *
     * @return Lista de objetos AeroGenerador que estaba almacenada en el
     * archivo binario.
     */
    public List leer() {

        try {
            FileInputStream fichero = new FileInputStream(System.getProperty("user.dir") + "/recursos/BDAeroGen.dat");
            ObjectInputStream objetostream = new ObjectInputStream(fichero);
            Object objeto = objetostream.readObject();
            objetostream.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(AeroGeneradorIO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AeroGeneradorIO.class.getName()).log(Level.SEVERE, null, ex);
        }
       return (List) (AeroGeneradorIO) objeto;
        /*
        try {
            ObjectInputStream objetostream;
            FileInputStream fichero = new FileInputStream(“BDAeroGen.dat”);
            objetostream = new ObjectInputStream(fichero);
            Object objeto = objetostream.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(AeroGeneradorIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

    }

    /**
     * Método que escribe, en un archivo binario, una colección de objetos
     * AeroGenerador serializables.
     *
     * @param aeroGens Lista de objetos AeroGenerador serializables para
     * almacenar en el archivo binario.
         */
        return null;
    }

    void escribir(List<AeroGenerador> misAerog) {
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
}
