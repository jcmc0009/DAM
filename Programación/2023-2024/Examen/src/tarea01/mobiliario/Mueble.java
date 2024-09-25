/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Esta clase sirve para representar el concepto genérico de mueble
 *
 *
 * @author José Carlos Manjón Carrasco
 * @version 1
 */
public abstract class Mueble {

    /**
     * Define el precio mínimo para una instancia de Mueble, siendo este {@value MIN_PRECIO
     * }
     */
    public final static double MIN_PRECIO = 0.01;
    /**
     * Define el precio máximo para una instancia de Mueble, siendo este {@value MAX_PRECIO
     * }
     */
    public final static double MAX_PRECIO = 10000.00;
    private static int numMueble;
    /**
     * Número tipo double para definir el precio del mueble
     */
    protected double precio;
    /**
     * Sirve como identificador único de cada instancia
     */
    private final int id = 0;
    /**
     * Define una descripción , da información extra
     */
    private final String descripcion;

    /**
     * Método constructor base de "Mueble"
     *
     * @param precio Define el precio del mueble
     * @param descripcion Define una pequeña descripción
     *
     * @throws IllegalArgumentException Se lanzará una excepción cuando se trate
     * de crear una instancia teniendo el precio fuera del rango válido
     */
    public Mueble(double precio, String descripcion) throws IllegalArgumentException {
        if (precio < MIN_PRECIO || precio > MAX_PRECIO) {
            String str = String.format("%.2f", precio);
            throw new IllegalArgumentException("El precio no está en el rango permitido:" + str);// dos decimales."
        }
        if (descripcion == null || descripcion == "") {
            throw new IllegalArgumentException("Descripción inválida");
        }

        this.descripcion = descripcion;
        this.precio = precio;

    }

    /**
     * Método que devuelve el precio de la instancia
     *
     * @return Precio con dos decimales
     */
    public double getPrecio() {
        return this.precio;
    }

    /**
     * Método que devuelve el valor de la identificación única de la instancia
     * (id)
     *
     * @return El valor único de cada instancia
     */
    public int getId() {

        return id;
    }

    /**
     * Método que devuelve el valor de la descripción de la instancia
     *
     *
     * @return Descripción de la instancia
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Método que devuelve en una cadena tipo String con la información base por
     * el hecho de ser un mueble
     *
     * @return Devuelve una cadena String con toda la información base
     */
    public String toString() {
        return String.format("Tipo:%s Id:%d Precio:%.2f Descripción:%s",
                this.getClass().getSimpleName(),
                this.getId(),
                this.getPrecio(),
                this.getDescripcion());
    }
}
