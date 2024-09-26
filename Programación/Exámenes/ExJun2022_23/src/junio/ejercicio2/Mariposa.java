package junio.ejercicio2;

import java.text.DecimalFormat;

/**
 * Clase
 *
 * @author
 */
public class Mariposa extends Insecto {

    private double longitud;

    public Mariposa(String codigo, String clase, double longitud) {
        super(codigo, clase);
        this.longitud = longitud;

    }

    @Override
    public void transformarse() {
        super.transformarse();
        this.longitud += this.longitud*0.01;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        return super.toString() + " Longitud: " + df.format(longitud);
    }

}
