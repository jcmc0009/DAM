package trenes.controladores;

/**
 * Clase PuertaVagon.
 *
 * Esta clase hereda de la clase ControlServicio e implementa la interfaz
 * Activable (implementa los métodos on() y off()). Representa una puerta del
 * vagón. Este control presenta como atributos un valor de estado para saber si
 * la puerta está cerrada o no. La ubicación de la puerta.
 *
 * @author David - IES Trassierra
 * @version 1.0
 */
public final class PuertaVagon extends ControlServicio implements Activable {

    @Override
    public void on() {
       estadoPuerta=true;
    }

    @Override
    public void off() {
        estadoPuerta=false;    }

    /*
     * Atributo estadoPuertaCerrada. 
     */
    private boolean estadoPuerta;
    /*
     * Atributo ubicacionPuerta. 
     */
    private String ubicacionPuerta;

    /*
     * Constructor con tres parámetros de PuertaVagon. 
     */
    public PuertaVagon(boolean estadoPuertaCerrada, String ubicacionPuerta, String nombreControlServicio) {
        super(nombreControlServicio);
        this.estadoPuerta = estadoPuertaCerrada;
        this.ubicacionPuerta = ubicacionPuerta;
        this.tipoControlServicio="Puerta";
    }

    /*
     * Constructor con dos parámetros de PuertaVagon. 
     */

    public PuertaVagon(String ubicacionPuerta, String nombreControlServicio) {
        super(nombreControlServicio);
        this.ubicacionPuerta = ubicacionPuerta;
        this.tipoControlServicio="Puerta";
    }
    

    /*
     * Método observador (getter) estado de la puerta
     *
     */
    public boolean getEstadoPuertaCerrada() {
        return estadoPuerta;
    }

    /*
     * Método modificador (setter)  estado  de la puerta
     */
    public void setEstadoPuertaCerrada(boolean estadoPuertaCerrada) {
        this.estadoPuerta = estadoPuertaCerrada;
    }

    /*
     * Método observador (getter)  ubicación de la puerta
     */
    public String getUbicacionPuerta() {
        return ubicacionPuerta;
    }

    /*
     * Método modificador (setter)  nueva ubicación a la puerta
     *
     */
    public void setUbicacionPuerta(String ubicacionPuerta) {
        this.ubicacionPuerta = ubicacionPuerta;
    }

    /*
     * Implementaión del método de la interfaz Activable on
    
    public void Activable() {
        on();
    } */
    

    /*
     * Implementaión del método de la interfaz Activable off
    
    public void Activable2() {
        off();
    } */

    /*
     * Método toString 
     */
    @Override
    public String toString() {
        return "PuertaVagon{" + "estadoPuertaCerrada=" + estadoPuerta + ", ubicacionPuerta=" + ubicacionPuerta + '}';
    }

}
