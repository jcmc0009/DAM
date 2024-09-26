package junio.ejercicio2;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

/**
 * Clase que representa un <strong>Inmueble</strong>
 * para la gestión de viviendas en una inmobiliaria.
 *
* @author José Carlos Manjón Carrasco
 */
public abstract class Inmueble implements Alquilable {

    public final static LocalDate FECHA_MINIMA = LocalDate.of(1950, Month.JANUARY, 1);
    public final static LocalDate FECHA_MAXIMA = LocalDate.now();
    public final static double PRECIO_BASE = 600.0;
    protected static int cantidadMuebles;
    protected String referenciaCatastral;
    protected String direccion;
    protected int numHabitaciones;
    protected LocalDate fechaConstruccion;
    private boolean bonificable;
    DateTimeFormatter formatoDdMmAa = DateTimeFormatter.ofPattern("'Fecha 'dd/MM/yyyy");

    public Inmueble(String referenciaCatastral, String direccion, int numHabitaciones, LocalDate fechaConstruccion) throws IllegalArgumentException {
        this.referenciaCatastral = referenciaCatastral;
        this.direccion = direccion;

        if (numHabitaciones <= 0) {
            throw new IllegalArgumentException("El número de habitaciones debe ser positivo");
        } else {
            this.numHabitaciones = numHabitaciones;
        }

        this.fechaConstruccion = fechaConstruccion;
        if (fechaConstruccion.isBefore(FECHA_MINIMA) || fechaConstruccion.isAfter(FECHA_MAXIMA)) {
            throw new IllegalArgumentException("La fecha " + fechaConstruccion.format(formatoDdMmAa) + " no es correcta");
        } else {
            this.fechaConstruccion = fechaConstruccion;
        }
    }

    public String getReferenciaCatastral() {
        return referenciaCatastral;
    }

    public String getDireccion() {
        return direccion;
    }

    public LocalDate getFechaConstruccion() {
        return fechaConstruccion;
    }

    public void setReferenciaCatastral(String referenciaCatastral) {
        this.referenciaCatastral = referenciaCatastral;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public static int getCantidadesInmuebles() {
        return cantidadMuebles;
    }

    @Override
    public boolean esBonificable() {
        LocalDate fecha = getFechaConstruccion().plusYears(20);

        if (fecha.compareTo(fechaConstruccion) < 0) {
            return bonificable = true;
        } else {
            return bonificable = false;
        }

    }

    @Override
    public double calcularTarifaAlquiler() {
        double tarifaBonificable;
        if (esBonificable() == false) {
            return PRECIO_BASE;

        } else {
            if (numHabitaciones == 1) {
                return PRECIO_BASE;
            } else if (this.numHabitaciones== 2 && this.numHabitaciones == 3) {
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
        return "Inmueble: " + "referenciaCatastral -> " + referenciaCatastral + ", direccion ->" + direccion + ", numHabitaciones -> " + numHabitaciones + ", fechaConstruccion ->" + fechaConstruccion.format(formatoDdMmAa);

    }

}
