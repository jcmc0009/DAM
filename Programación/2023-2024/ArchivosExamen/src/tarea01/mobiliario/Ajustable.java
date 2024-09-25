/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 **Esta interfaz será implementada por los muebles que tengan varias
 * posiciones. Se implementarán obtenerPosicion, subirPosicion y bajarPosicion.
 *
 * @author José Carlos Manjón Carrasco
 * @version 1
 *
 */
public interface Ajustable {

    /**
     * Este método es usado para obtener la posición en la que se encuentre el
     * mueble
     *
     * @return Posicion en número del mueble
     */
    public int obtenerPosicion();

    /**
     * Este método es usado para subir la posición en la que se encuentre el
     * mueble
     *
     * @throws Error cuando se intente subir un mueble más de su posicion máxima
     */
    public int subirPosicion() throws IllegalStateException;

    /**
     * Este método es usado para subir la posición en la que se encuentre el
     * mueble
     *
     * @throws Error cuando se intente bajar un mueble más de su posicion mínima
     */
    public int bajarPosicion() throws IllegalStateException;

}
