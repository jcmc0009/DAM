package junio.ejercicio3;

/**
 * Clase Producto
 * 
 * @author Profesor
 */
public class Producto {
    private final String codigo ;
    private String nombre ;
    private int unidades ;
    private String unidadMedida ;

    /**
     * Constructor de la clase Producto
     * @param codigo        Código del Producto
     * @param nombre        Nombre del producto
     * @param unidades      Número de unidades
     * @param unidadMedida  Unidad de medida 
     */
    public Producto(String codigo, String nombre, int unidades, String unidadMedida) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.unidades = unidades;
        this.unidadMedida = unidadMedida;
    }

    @Override
    public String toString() {
        return String.format ("Producto: %s nombre: %s unidades: %d unidadMedida: %s",
                codigo, nombre, unidades,  unidadMedida) ;
    }
    
    
    
}
