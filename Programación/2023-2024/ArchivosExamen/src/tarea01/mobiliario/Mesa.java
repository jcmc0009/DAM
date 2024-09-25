/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Esta clase sirve para representar el concepto de mesa
 *
 * @author José Carlos Manjón Carrasco
 * @version 1
 */
public final class Mesa extends Mueble {

    private String forma;
    private int numComensales;
    /**
     * Número minimo de comensales para crear la instancia de la clase Mesa,
     * siendo estos {@value MIN_COMENSALES }
     */
    public final static int MIN_COMENSALES = 4;
    /**
     * Número máximo de comensales para crear la instancia de la clase Mesa ,
     * siendo estos {@value MAX_COMENSALES }
     */
    public final static int MAX_COMENSALES = 16;

    /**
     * Método que devuelve el número de comensales para la instancia de la clase
     * Mesa
     *
     * @return Número entero de comensales
     */
    public int getNumComensales() {
        return numComensales;
    }

    /**
     * Método que devuelve la forma que tiene la instancia de la clase Mesa
     *
     * @return Forma de la mesa
     */
    public String getForma() {
        return forma;
    }

    /**
     * Con este constructor creamos una instancia de la clase Mesa, la cual
     * hereda de Mueble
     *
     * @param precio Precio de la mesa
     * @param descripcion Pequeña descripción de la mesa
     * @param forma Describimos la forma de la mesa
     * @param numComensales Número entero de comensales para la instancia
     *
     * @throws IllegalArgumentException Se lanzará esta excepción cuando se
     * trate de crear una instancia de la clase Mesa en un rango de comensales
     * fuera del válido
     */
    public Mesa(double precio, String descripcion, String forma, int numComensales) throws IllegalArgumentException {
        super(precio, descripcion);
        this.numComensales = numComensales;
        this.forma = forma;
        if (this.numComensales < MIN_COMENSALES || this.numComensales > MAX_COMENSALES) {
            throw new IllegalArgumentException("Error: No se puede crear la mesa. El número de comensales no está en el rango permitido:" + this.numComensales);

        }

    }

    /**
     * Método que devuelte el número entero de comensales de la instancia Mesa
     *
     * @return Número entero de comensales de la instancia
     */
    public int getComensales() {
        return numComensales;
    }

    @Override
    /**
     * Método que devuelve en una cadena tipo String toda la información por
     * heredar de la clase Mueble además de la forma y número de comensales de
     * la instancia Mesa
     *
     * @return Devuelve una cadena String con toda la información
     */
    public String toString() {
        return String.format("%s Forma: %s N.Comensales:%d ",
                super.toString(), this.forma, this.numComensales);

    }
}
