package trenes.controladores;

/**
 * Clase VentanillaVagon.
 *
 * Esta clase hereda de la clase ControlServicio e implementa la interfaz
 * Modificable (implementa los métodos aumentar() y disminiur()). Representa una
 * ventanilla del vagón. Este control presenta como atributos un valor que
 * marcará el porcentaje de opacidad de la ventanilla siendo el 0 transparente y
 * el 100 completamente opaco. La ubicación de la ventanilla.
 *
 * @author David - IES Trassierra
 * @version 1.0
 */
public class VentanillaVagon extends ControlServicio implements Modificable {

    private int valorMinimo = 0;
    private int valorMaximo = 100;

    @Override
    public int getValorMinimoPosibleEstadoControl() {
        return valorMinimo;
    }

    @Override
    public int getValorMaximoPosibleEstadoControl() {
        return valorMaximo;
    }

    /*
     * Atributo opacidadVentanilla. 
     */
    public int opacidadVentanilla;

    /*
     * Atributo ubicacionVentanilla.
     */
    public String ubicacionVentanilla;

    /*
     * Constructor con tres parámetros de VentanillaVagon. 
     */
    public VentanillaVagon(int opacidadVentanilla, String ubicacionVentanilla, String nombreControlServicio) {
        super(nombreControlServicio);
        this.opacidadVentanilla = opacidadVentanilla;
        this.ubicacionVentanilla = ubicacionVentanilla;
        this.tipoControlServicio = "Ventanilla";
    }


    /*
     * Constructor con dos parámetros de VentanillaVagon.
     */
    public VentanillaVagon(int opacidadVentanilla, String ubicacionVentanilla) {
        this.opacidadVentanilla = opacidadVentanilla;
        this.ubicacionVentanilla = ubicacionVentanilla;
        this.tipoControlServicio = "Ventanilla";
    }

    /*
     * Método observador (getter) opacidad 
     *
     */
    public int getOpacidadVentanilla() {
        return opacidadVentanilla;
    }

    /**
     * Método modificador (setter) nuevo el porcentaje de opacidad .
     */
    public void setOpacidadVentanilla(int opacidadVentanilla) {
        this.opacidadVentanilla = opacidadVentanilla;
    }

    /*
     * Método observador (getter)  ubicación de la ventana
     *
     */
    public String getUbicacionVentanilla() {
        return ubicacionVentanilla;
    }

    /*
     * Método modificador (setter) nueva ubicación 
     */
    public void setUbicacionVentanilla(String ubicacionVentanilla) {
        this.ubicacionVentanilla = ubicacionVentanilla;
    }

    /*
     * Implementaión del método de la interfaz Modificable para aumentar la
     * opacidad de la ventanilla en 5 unidades. 
     */
    @Override
    public void aumentar() {
        opacidadVentanilla += 5;
    }

    /*
     * Implementaión del método de la interfaz Modificable para disminiur la
     * opacidad de la ventanilla en 5 unidades. 
     */
    @Override
    public void disminuir() {
        opacidadVentanilla -= 5;
    }

    /*
     * Método toString 
     */
    @Override
    public String toString() {
        return "VentanillaVagon{" + "opacidadVentanilla=" + opacidadVentanilla + ", ubicacionVentanilla=" + ubicacionVentanilla + '}';
    }

}
