package trenes.controladores;

/**
 * Clase ConjuntoAltavoces.
 *
 * Esta clase hereda de la clase ControlServicio e implementa la interfaz
 * Modificable (implementa los métodos aumentar() y disminiur()). Representa un
 * determinado conjunto de altavoces de un vagon. Este control presenta como
 * atributos el nombre de la pista o melodía que se está reproduciendo, así como
 * el volumen de salida de sonido del conjunto de altavoces.
 *
 * @author David - IES Trassierra
 * @version 1.0
 *
 */
public class ConjuntoAltavoces extends ControlServicio implements Modificable {

    /**
     *@param pistaReproduciendo
     * Atributo pistaReproduciendo. 
     */
    private String pistaReproduciendo;

    /*
     * Atributo volumenReproduccion.
     */
    private int volumenReproduccion=0;
     /*
     * Atributo valor mínimo.
    @param kjdkfjdkf
     */
    private int valorMinimo = 0;
    private int valorMaximo = 100;
    

    @Override
    public int getValorMinimoPosibleEstadoControl() {
        return valorMinimo;//así con todas
    }

    @Override
    public int getValorMaximoPosibleEstadoControl() {
        return valorMaximo;
    }

    /*
     * Implementación del método de la interfaz Modificable para aumentar el
     * volumen en 1. 
     */
    @Override
    public void aumentar() {
        volumenReproduccion++;
    }

    /*
     * Implementaión del método de la interfaz Modificable para disminiur el
     * volumen en 1. 
     */
    @Override
    public void disminuir() {
        volumenReproduccion--;
    }

 
    /**
     * Constructor con tres parámetros de ConjuntoAltavoces. 
     * @param pistaReproduciendo Pista o canción que se esté reproduciendo en el momento
     * @param volumenReproduccion Volumen al que se esté reproduciendo la pista o canción
     * @param nombreControlServicio Nombre del control de servicio
     */
    public ConjuntoAltavoces(String pistaReproduciendo, int volumenReproduccion, String nombreControlServicio) {
        super(nombreControlServicio);
        this.pistaReproduciendo = pistaReproduciendo;
        this.volumenReproduccion = volumenReproduccion;
        this.tipoControlServicio="Altavoces";
    }

    /*
     * Constructor con dos parámetros de ConjuntoAltavoces. 
     */
    public ConjuntoAltavoces(String pistaReproduciendo, int volumenReproduccion) {
        this.pistaReproduciendo = pistaReproduciendo;
        this.volumenReproduccion = volumenReproduccion;
        this.tipoControlServicio="Altavoces";
    }

    /*
     * Método observador (getter) pista o melodia que se está
     * reproduciendo
     *
     */
    public String getPistaReproduciendo() {
        return pistaReproduciendo;
    }

    /*
     * Método modificador (setter) el nombre de la nueva pista 
     */
    public void setPistaReproduciendo(String pistaReproduciendo) {
        this.pistaReproduciendo = pistaReproduciendo;
    }

    /*
     * Método observador (getter) volumen actual     
     */
    public int getVolumenReproduccion() {
        return volumenReproduccion;
    }

    /*
     * Método modificador (setter) nuevo volumen de reproducción 
     *
     */
    public void setVolumenReproduccion(int volumenReproduccion) {
        this.volumenReproduccion = volumenReproduccion;
    }

    /*
     * Método toString 
     */
    @Override
    public String toString() {
        return "ConjuntoAltavoces{" + "valorMinimo=" + valorMinimo + ", valorMaximo=" + valorMaximo + ", volumenReproduccion=" + volumenReproduccion + ", pistaReproduciendo=" + pistaReproduciendo + ", volumenReproduccion=" + volumenReproduccion + '}';
    }

}
