/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Esta clase sirve para representar el concepto genérico personalización. Será
 * implementada por las clases o muebles que permitan la personalización guardar
 * o almacenar.
 *
 * @author José Carlos Manjón Carrasco
 * @version 1
 */
public interface Personalizable {

    /**
     * Método que devuelve en una cadena los módulos que están presentes en el
     * mueble
     *
     * @return Devuelve una cadena con los módulos que estén creados en el
     * mueble
     */
    public String obtenerModulos();

    /**
     * Método que añade un elemento de tipo módulo al mueble personalizable
     *
     * @throws IllegalStateException Devolverá este error cuando se intente
     * crear un mueble con datos fuera de rango válido
     * @throws NullPointerException Devolverá este error cuando se intente crear
     * un mueble con un elemento "nulo"
     */
    public void anyadirModulo(Modulo modulo) throws IllegalStateException, NullPointerException;

    /**
     * Método que añade un elemento de tipo módulo al mueble personalizable
     *
     * @throws IllegalStateException Devolverá este error cuando se intente
     * extraer o eliminar un mueble con datos fuera de rango válido
     *
     */
    public int extraerModulo() throws IllegalStateException;

}
