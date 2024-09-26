package junio.ejercicio2;

import java.time.LocalDate;

/**
 * Clase que representa un <strong>Inmueble</strong> de tipo Casa para la
 * gestión de viviendas en una inmobiliaria.
 *
* @author José Carlos Manjón Carrasco
 */
public class Casa extends Inmueble {

    private int NUM_PLANTAS;
    private String tipoCasa;
    private boolean piscina;

    public Casa(String referenciaCatastral, String direccion, int numHabitaciones, LocalDate fechaConstruccion, int numPLantas) throws IllegalArgumentException {
        super(referenciaCatastral, direccion, numHabitaciones, fechaConstruccion);
        this.NUM_PLANTAS = numPLantas;
        this.tipoCasa = "Individual";
        this.piscina = false;
    }

    @Override
    public String toString() {
        String hayPiscina;
        if (this.piscina == false) {
            hayPiscina = "No";
        } else {
            hayPiscina = "Si";
        }

        return String.format("%s ,numero de plantas %d ,piscina -> %s",
                super.toString(),
                NUM_PLANTAS,
                hayPiscina
        );

        /* super.toString();
        return "Inmueble: " + "referenciaCatastral -> " + referenciaCatastral + ", direccion ->" + direccion + ", numHabitaciones -> " + numHabitaciones + ", fechaConstruccion ->"
                + fechaConstruccion.format(formatoDdMmAa) + ", número de plantas ->" + NUM_PLANTAS + ", tipo de casa ->" + tipoCasa + " , piscina --> " + hayPiscina// + (this.piscina = false ? "Si" : "NO");
                ;*/
    }

}
