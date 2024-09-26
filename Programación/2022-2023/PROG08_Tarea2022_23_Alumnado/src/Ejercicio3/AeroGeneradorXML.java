package Ejercicio3;

import com.thoughtworks.xstream.XStream;
import java.util.List;

public class AeroGeneradorXML {

    /**
     * Ruta del archivo donde se lee y escribe la colección de objetos AeroGenerador
     */
    private String rutaArchivo;
    /**
     * Objeto Xstream que permite la L/E con archivos XML
     */
    private XStream xstream;

    /**
     * Método constructor
     * @param archivo Ruta del archivo donde se lee y escribe la colección de objetos AeroGenerador
     */
    public AeroGeneradorXML(String nombreArchivo) {
        super();
        this.rutaArchivo = nombreArchivo;
        xstream = new XStream();
        //Permite asignar privilegios para poder operar con los archivos XML
        xstream.allowTypesByWildcard(new String[] { 
            "Ejercicio3.**",
            "com.mydomain.utilitylibraries.**"
        });
    }

    /**
     * Método que escribe, en un archivo binario, una colección de objetos AeroGenerador serializables.
     * @param aeroGens Lista de objetos AeroGenerador serializables para almacenar en el archivo binario.
     */
    public void escribir(List aeroGens) {
        
    }

    /**
     * Método que lee, desde un archivo binario, una colección de objetos AeroGenerador serializados.
     * @return Lista de objetos AeroGenerador que estaba almacenada en el archivo binario.
     */
    public List leer() {
        
    }
}
