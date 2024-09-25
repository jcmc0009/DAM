/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Esta clase sirve para representar el concepto de "Estantería"
 *
 * @author José Carlos Manjón Carrasco
 * @version 1
 */
public final class Estanteria extends Almacenaje implements Personalizable {

    private final String tipo;
    private final int maximoBaldas = 3;
    private final String cadenaModulos = "";

    /**
     * Método usador para obtener el tipo de mueble
     *
     * @return Tipo de mueble
     *
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Con este constructor creamos una instancia de la clase Asiento, la cual
     * hereda de Mueble
     *
     * @param precio Precio de la estantería
     * @param descripcion Pequeña descripción de la estantería
     * @param anchura Describimos la anchura
     * @param altura Describimos la altura
     * @param numMaximoModulos Introducimos el número entero máximo de módulos
     * que tendrá
     * @param tipo Describimos el tipo de la instancia de la clase "Estantería"
     * @throws IllegalArgumentException Se lanzará esta excepción cuando se
     * trate de crear una instancia de la clase Estantería con un número de
     * "módulos" fuera del rango permitido, el cual hereda de la clase
     * "Almacenaje"
     */
    public Estanteria(double precio, String descripcion, double anchura, double altura, int numMaximoModulos, String tipo) throws IllegalArgumentException {
        super(precio, descripcion, anchura, altura, numMaximoModulos);
        this.tipo = tipo;
        if (this.numModulos < MIN_MODULOS) {
            this.numModulos = MIN_MODULOS;
        } else {

            this.numModulos = 1;
        }

    }

    /**
     * Método que devuelve en una cadena tipo String toda la información por
     * heredar de la clase Mueble además de la anchura y tipo
     *
     *
     * @return Devuelve una cadena String con toda la información de la
     * instancia de la clase "Estantería"
     */
    @Override
    public String toString() {

        return String.format("%s Anchura: %.2f Tipo: %s",
                super.toString(),
                getAnchura(),
                getTipo()
        );
    }

    /**
     * @throws IllegalArgumentException Se lanza este error cuando se trata de
     * añadir un módulo que sea nulo
     */
    @Override
    public void anyadirModulo(Modulo modulo) throws IllegalArgumentException, IllegalStateException {

        if (modulo == null) {
            throw new NullPointerException("El módulo no puede ser nulo");
        }
        if (modulo != Modulo.BALDA) {
            throw new IllegalArgumentException("El módulo no puede ser distinto de balda");
        }

        if (this.numModulos < maximoBaldas) {
            this.numModulos++;
        } else {
            throw new IllegalStateException("Error: no se puede añadir el módulo " + modulo.BALDA + ".El número de módulos no puede superar el máximo permitido: " + maximoBaldas);

        }
    }

    @Override
    public String obtenerModulos() {
        return cadenaModulos;
    }

    @Override
    public int extraerModulo() throws IllegalStateException {
        if (numModulos == MIN_MODULOS) {
            throw new IllegalStateException("Error: no se puede quitar el módulo. El número de módulos no puede ser inferior a" + MIN_MODULOS);
        } else {
            numModulos -= 1;
        }
        return numModulos;
    }

}
