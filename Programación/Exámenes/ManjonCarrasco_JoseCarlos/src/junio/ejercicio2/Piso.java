package junio.ejercicio2;

import java.time.LocalDate;

/**
 * Clase que representa un <strong>Inmueble</strong> de tipo Piso para la
 * gestión de viviendas en una inmobiliaria.
 *
* @author José Carlos Manjón Carrasco
 */
public final class Piso extends Inmueble {

    private double comunidad;

    public Piso(String referenciaCatastral, String direccion, int numHabitaciones, LocalDate fechaConstruccion, double comunidad) throws IllegalArgumentException {
        super(referenciaCatastral, direccion, numHabitaciones, fechaConstruccion);
        this.comunidad = comunidad;

    }

    @Override
    public double calcularTarifaAlquiler() {
        double tarifaBonificable;
        if (esBonificable() == false) {

            return PRECIO_BASE;

        } else {
            if (numHabitaciones == 1) {
                return PRECIO_BASE;
            } else if (numHabitaciones == 2 || numHabitaciones == 3) {
                tarifaBonificable = PRECIO_BASE * 0.05;
                return tarifaBonificable;
            } else {
                tarifaBonificable = PRECIO_BASE * 0.08;
                return tarifaBonificable;
            }

        }

    }

    @Override
    public String toString() {

        return String.format("%s ,comunidad-> %.2f",
                super.toString(),
                this.comunidad
        );
    }

}
