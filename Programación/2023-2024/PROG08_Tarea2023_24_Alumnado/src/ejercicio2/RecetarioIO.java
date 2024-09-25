package ejercicio2;

/**
 * Clase encargada de realizar la lectura y escritura de objetos Recetario en archivos binarios.
 * @author profe
 */
public class RecetarioIO {
    
    // Ruta del archivo donde se lee y escribe el objeto Recetario
    private String rutaArchivo;

    /**
     * Método constructor
     * @param archivo Ruta del archivo donde se lee y escribe el objeto Recetario
     */
    public RecetarioIO(String archivo) {
        this.rutaArchivo = archivo;
    }
    
 
    // -----------------------------------------------------
    // Ejercicio 2: Métodos que debe implementar el alumnado
    // -----------------------------------------------------
    
    /**
     * Método que lee, desde un archivo binario, un objeto Recetario serializado.
     * @return Objeto Recetario que estaba almacenado en el archivo binario.
     */
    public Recetario leer() {
        return null; // Sustituir este return por el código que resuelve el ejercicio 
    }
    
    /**
     * Método que escribe, en un archivo binario, un objeto Recetario serializable.
     * @param recetario Objeto Recetario serializable para almacenar en el archivo binario.
     */   
    public void escribir(Recetario recetario) {
        // Incluir el código que debe realizar el método
    }
}
