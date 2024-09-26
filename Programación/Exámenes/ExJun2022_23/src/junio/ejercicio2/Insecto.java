package junio.ejercicio2;

/**
 * Clase
 *
 * @author
 */
abstract class Insecto implements Transformacion {

    protected String codigo;
    protected String clase;
    protected int numTransformaciones;

    public Insecto(String codigo, String clase) {
        this.codigo = codigo;
        this.clase = clase;
        this.numTransformaciones = 0;
    }

    @Override
    public void transformarse() {
        this.numTransformaciones++;
    }

    @Override
    public String toString() {
        return "Código: " + codigo + " Clase: " + clase + " Núm. de veces transformado: " + numTransformaciones;
    }
    
    

}
