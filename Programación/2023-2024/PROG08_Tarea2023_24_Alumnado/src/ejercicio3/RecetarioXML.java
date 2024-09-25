package ejercicio3;

import com.thoughtworks.xstream.XStream;

/**
 * Clase que permite serializar un objeto Recetario al formato XML y 
 viceversa.
 *   
 * @author profe
 */
public class RecetarioXML {
    
     // Ruta del archivo donde se lee y escribe el objeto Recetario
    private String rutaArchivo;
    
    
    // Objeto Xstream que permite la L/E con archivos XML
    private XStream xstream;

    /**
     * Método constructor
     * @param nombreArchivo Ruta del archivo donde se lee y escribe el objeto Recetario
     */
    public RecetarioXML(String nombreArchivo) {
        this.rutaArchivo = nombreArchivo;
        this.xstream = new XStream();
        //Permite asignar privilegios para poder operar con los archivos XML
        this.xstream.allowTypesByWildcard(new String[] { 
            "ejercicio3.**",
            "com.mydomain.utilitylibraries.**"
        });
    }

    
    // -----------------------------------------------------
    // Ejercicio 3: Métodos que debe implementar el alumnado
    // -----------------------------------------------------
    
    // 3.1. Método escribir()
    /**
     * Método que escribe, en un archivo de texto, un objeto Recetario serializable.
     * @param recetario Objeto Recetario serializable para almacenar en el archivo de texto.
     */    
    public void escribir(Recetario recetario) {
        // Incluir el código que debe realizar el método
    }
    
    // 3.2. Método leer()
     /**
     * Método que lee, desde un archivo de texto, un objeto Recetario serializado.
     * @return Objecto Recetario que estaba almacenado en el archivo de texto.
     */
    public Recetario leer() {
        return null; // Sustituir este return por el código que resuelve el ejercicio
    }
}
