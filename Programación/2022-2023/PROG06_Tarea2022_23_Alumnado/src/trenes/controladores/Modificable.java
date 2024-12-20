package trenes.controladores;

/**
 * Interfaz Modificable.
 *
 * Esta interfaz representa a la funcionalidad de elementos que se puedan
 * cambiar o modificar su estado aumentando o disminuyendo algún parámetro, es
 * decir, subir o bajar el volumen, aumentar o disminuir la intensidad,
 * opacidad, etc. A los elementos que puedan presentar variaciones de valor en
 * algún parámetro.
 *
 * @author David - IES Trassierra
 * @version 1.0
 */
public interface Modificable {

    /*
     * Mínimo valor posible para el estado del control de servicio:
     */
    public int getValorMinimoPosibleEstadoControl();

    /*
     * Máxima valor posible para el estado del control de servicio:
     */
    public int getValorMaximoPosibleEstadoControl();

    /*
     * Definición del método para aumentar un parámetro
     */
    public void aumentar();

    /*
     * Definición del método para disminuir un parámetro
     */
    public void disminuir();
}
