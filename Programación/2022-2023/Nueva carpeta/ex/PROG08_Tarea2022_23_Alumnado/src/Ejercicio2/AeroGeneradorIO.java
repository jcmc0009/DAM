package Ejercicio2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AeroGeneradorIO {

    /**
     * Ruta del archivo donde se lee y escribe la colección de objetos
     * AeroGenerador
     */
    private String rutaArchivo;

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
        List d = null;
        try ( ObjectInputStream ois = new ObjectInputStream(new FileInputStream(rutaArchivo))) {
            d = (List) ois.readObject();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AeroGeneradorIO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return (List) d;
    }

    /**
     * Método que escribe, en un archivo binario, una colección de objetos
     * AeroGenerador serializables.
     *
     * @param aeroGens Lista de objetos AeroGenerador serializables para
     * almacenar en el archivo binario.
     */
    public void escribir(List aeroGens) {
        try ( ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(rutaArchivo))) {
            oos.writeObject(aeroGens);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
