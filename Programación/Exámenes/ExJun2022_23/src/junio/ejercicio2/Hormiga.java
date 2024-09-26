package junio.ejercicio2;

/**
 * Clase Hormiga que hereda de Insecto
 *
 * @author
 */
public class Hormiga extends Insecto {

    private String color;
    private int categoria;

    public Hormiga(String codigo, String clase, String color) {
        super(codigo, clase);
        this.color = color;
        this.categoria = 0;
    }

    @Override
    public String toString() {
        return super.toString() + " Color: " + color + " Categoria " + categoria;
    }

    @Override
    public void transformarse() {
        super.transformarse();
        if (this.categoria < 2) {
            this.categoria++;
        }
    }

}
