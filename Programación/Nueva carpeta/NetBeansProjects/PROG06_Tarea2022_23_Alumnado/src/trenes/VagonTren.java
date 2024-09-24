package trenes;

import trenes.controladores.ControlServicio;
import trenes.controladores.PuertaVagon;
import trenes.controladores.TiraLuz;

/**
 * Clase VagonTren.
 *
 * Esta clase representa un vagon de tren donde se tiene un conjunto de
 * Controles de Servicio para controlar dicho vagón. Para ello esta clase cuenta
 * con un array de objetos de tipo ControlServicio.
 *
 * @author David - IES Trassierra
 * @version 1.0
 */
public class VagonTren {

    /*
     * Atributo companyiaTrenes.
     */
    private String companyiaTrenes;

    /*
     * Atributo descripcion. 
     */
    private String descripcion;

    /*
     * Atributo servicios. 
     */
    private ControlServicio[] servicios;


    /*
     * Constructor con tres parámetros companyia, descripción y número de controles
     * de VagonTren. 
     */
    public VagonTren(String companyiaTrenes, String descripcion, int numControles) {
        this.companyiaTrenes = companyiaTrenes;
        this.descripcion = descripcion;
        servicios = new ControlServicio[numControles];
    }

    /*
     * Constructor con tres parámetros companyia, descripción y array de objetos de controles
     * de VagonTren. 
     */
    public VagonTren(String companyiaTrenes, String descripcion, ControlServicio[] servicios) {
        this.companyiaTrenes = companyiaTrenes;
        this.descripcion = descripcion;
        this.servicios = servicios;
    }

    /*
     * Método observador (getter) que devuelve el nombre de la compañía
     */
    public String getCompanyiaTrenes() {
        return companyiaTrenes;
    }

    /*
     * Método modificador (setter)  nombre de la compañía 
     */
    public void setCompanyiaTrenes(String companyiaTrenes) {
        this.companyiaTrenes = companyiaTrenes;
    }

    /*
     * Método observador (getter) que devuelve la descripción 
     * 
     */
    public String getDescripcion() {
        return descripcion;
    }

    /*
     * Método modificador (setter) que establece la descripción 
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /*
     * Método observador (getter) que devuelve el array 
     */
    public ControlServicio[] getServicios() {
        return servicios;
    }

    /*
     * Método modificador (setter) que establece el array 
     * 
     */
    public void setServicios(ControlServicio[] servicios) {
        this.servicios = servicios;
    }

    /*
     * Método observador (getter)  número de elementos     
     */
    public int getNumServicios() {
        return servicios.length;
    }

    /*
     * Método observador (getter)  numero de Controles Puerta
     */
    public int getNumServiciosPuerta() {
        return cuentaPorTipo("Puerta");
    }

    private int cuentaPorTipo(String tipo) {
        int contador = 0;

        for (ControlServicio servicio : servicios) {
            if (servicio.getTipoControlServicio() == tipo) {
                contador++;
            }
        }
        return contador;
    }


    /*
     * Método observador (getter)  numero de Controles  Tira de Luz 
     */
    public int getNumServiciosLuz() {
        return cuentaPorTipo("Luz");
    }

    /**
     * Método observador (getter) numero de Controles Ventanilla
     */
    public int getNumServiciosVentanilla() {
        return cuentaPorTipo("Ventanilla");
    }

    /**
     * Método observador (getter) numero de Controles Conjunto Altavoces
     */
    public int getNumServiciosAltavoces() {
        return cuentaPorTipo("Altavoces");
    }

    /*
     * Método cerrarPuertas 
     *
     */
    public void cerrarPuertas() {
        for (ControlServicio servicio : servicios) {
            if (servicio.getTipoControlServicio() == "Puerta") {
                ((PuertaVagon) servicio).off();
            }
        }
    }

    /*
     * Método activarTodosServicios 
     */
    public void activarTodosServicios() {
        for (ControlServicio servicio : servicios) {
            if (servicio.getTipoControlServicio() == "Puerta") {
                ((PuertaVagon) servicio).on();
            } else if (servicio.getTipoControlServicio() == "Luz") {
                ((TiraLuz) servicio).on();
            }
        }
    }

    /*
     * Método toString 
     */
    @Override
    public String toString() {
        return "VagonTren{" + "companyiaTrenes=" + companyiaTrenes + ", descripcion=" + descripcion + ", servicios=" + servicios + '}';
    }

}
