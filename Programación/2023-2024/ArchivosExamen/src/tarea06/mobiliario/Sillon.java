/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Esta clase sirve para representar el concepto de sillón
 *
 * @author José Carlos Manjón Carrasco
 * @version 1
 */
public final class Sillon extends Asiento implements Ajustable {

    private int posicion;
    /**
     * Indica con el valor {@value POS_BAJADO} que el sillón se encuentra en
     * posición bajada
     */
    public final static int POS_BAJADO = 0;
    /**
     * Indica con el valor {@value POS_SUBIDO} que el sillón se encuentra en
     * posición subida
     */
    public final static int POS_SUBIDO = 1;
    private int posicionPies;
    private String posicionamientoPies;

    /**
     * Método que devuelve la posición en valor numérico
     *
     * @return Valor de la posición en la que se encuentre
     */
    public int obtenerPosicion() {
        return posicion;
    }

    /**
     * Método usado para bajar la posición
     *
     * @throws IllegalStateException Se lanza una excepción cuando se trata de
     * bajar un sillón cuando este ya está en dicha posición
     * @return Valor de la posición
     */
    public int bajarPosicion() throws IllegalStateException {

        if (posicion == POS_BAJADO) {
            throw new IllegalStateException("Error : no se pueden bajar los pies del sillón.Ya están bajados");
        } else {
            return (posicion = POS_BAJADO);
        }
    }

    /**
     * Método usado para subir la posición
     *
     * @throws IllegalStateException Se lanza una excepción cuando se trata de
     * subir un sillón cuando este ya está subido
     * @return Valor de la posición
     */
    @Override
    public int subirPosicion() throws IllegalStateException {
        if (posicion == POS_SUBIDO) {
            throw new IllegalStateException("Error : no se pueden subir los pies del sillón.Ya están subidos");
        } else {
            return (posicion = POS_SUBIDO);
        }
    }

    /**
     * Con este constructor creamos una instancia de tipo sillón
     *
     * @param precio Precio del sillón
     * @param descripcion Pequeña descripción del sillón
     * @param tapiceria Tapicería determinada del sillón
     * @param color Color del sillón
     *
     * @throws IllegalArgumentException Se lanzará esta excepción cuando se
     * trate de crear un sofá con un número de plazas fuera del rango permitido
     * {@value MIN_PLAZAS} y {@value MAX_PLAZAS }
     */
    public Sillon(double precio, String descripcion, String tapiceria, String color) {

        super(precio, descripcion, tapiceria, color, MIN_PLAZAS);

        this.posicionPies = 0;

    }

    /**
     * Método que devuelve la posición de los pies en una cadena String
     *
     * @return Posición de los pies
     */
    public String getPosicionamientoPies() {
        return posicionamientoPies;
    }

    /**
     * Método que devuelve en una cadena tipo String toda la información por
     * heredar de la clase Mueble además de la posición de los pies
     *
     * @return Devuelve una cadena String con toda la información
     */
    @Override
    public String toString() {
        String posicionPies = "";
        if (this.posicion == 0) {
            posicionPies = "bajada";
        } else {
            posicionPies = "subida";
        }

        return String.format("%s Posición actual de los pies: %s",
                super.toString(),
                posicionPies
        );
    }
}
