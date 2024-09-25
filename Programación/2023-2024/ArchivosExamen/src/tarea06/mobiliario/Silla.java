/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Esta clase sirve para representar el concepto de silla
 *
 * @author José Carlos Manjón Carrasco
 * @version 1
 */
public class Silla extends Asiento implements Ajustable {

    private int posicion = MIN_POSICION;
    /**
     * Posición mínima, será un valor entero {@value MIN_POSICION}
     */
    public final static int MIN_POSICION = 1;
    /**
     * Posición máxima, será un valor entero {@value MAX_POSICION}
     */
    public final static int MAX_POSICION = 4;

    /**
     * Método que devuelve el valor de la posición numérica de la silla
     *
     * @return El valor de la posición
     */
    public int obtenerPosicion() {

        return posicion;

    }

    public int bajarPosicion() throws IllegalStateException {

        if (posicion == MIN_POSICION) {
            throw new IllegalStateException("Error : no se puede bajar la posicion " + (posicion - 1) + ", ya que la posición minima es " + MIN_POSICION);
        } else {
            return posicion -= 1;
        }
    }

    @Override
    public int subirPosicion() throws IllegalStateException {
        if (posicion == MAX_POSICION) {
            throw new IllegalStateException("Error : no se puede subir la posicion " + (posicion + 1) + ", ya que la posición máxima es " + MAX_POSICION);
        } else {
            return posicion += 1;
        }
    }

    /**
     * Con este constructor creamos una instancia de tipo Sofá
     *
     * @param precio Precio del sofá
     * @param descripcion Pequeña descripción del sofá
     * @param tapiceria Altura determinada del sofá
     * @param color Número máximo de módulos que permitirá el sofá
     *
     * @throws IllegalArgumentException Se lanzará esta excepción cuando se
     * trate de crear una silla con un número de plazas fuera del rango
     * permitido {@value MIN_PLAZAS} y {@value MAX_PLAZAS }
     * @throws NumberFormatException Se lanzará esta excepción cuando se trate
     * de crear una silla con un número de plazas inválido
     */
    public Silla(double precio, String descripcion, String tapiceria, String color) throws IllegalArgumentException, NumberFormatException {

        super(precio, descripcion, tapiceria, color, MIN_PLAZAS);
        this.posicion = MIN_POSICION;

        try {

            if (this.numPlazas < MIN_PLAZAS || this.numPlazas > MAX_PLAZAS) {
                throw new IllegalArgumentException("El número de plazas no está en el rango permitido: " + this.numPlazas);
            } else {
                // Hacer lo que necesites con el número de plazas convertido a entero
                this.posicion = MIN_POSICION;
                this.precio = precio;

            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("El número de plazas no es válido: " + this.numPlazas);
        }

    }

    /**
     * Método que devuelve en una cadena tipo String toda la información por
     * heredar de la clase Mueble además de la posición actual del respaldo
     *
     * @return Devuelve una cadena String con toda la información
     */
    @Override

    public String toString() {

        return String.format("%s Posición actual de respaldo: %s",
                super.toString(),
                this.obtenerPosicion()
        );
    }
}
