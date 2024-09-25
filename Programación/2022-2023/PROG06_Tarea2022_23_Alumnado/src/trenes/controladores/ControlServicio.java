package trenes.controladores;

/**
 * Clase abstracta ControlServicio. Servirá para agrupar todas las
 * características comunes a los diferentes controles que pueda presentar cada
 * vagón del tren.
 *
 * @author David - IES Trassierra
 * @version 1.0
 */
public abstract class ControlServicio {


    /*
	 * Atributo de clase numControlesConfigurados. 
     */
    private static int numControlesConfigurados = 0;

    /*
	 * Atributo inmutable idControlServicio. 
     */
    private int idControlServicio = 0;

    /*
	 * Atributo nombreControlServicio.
     */
    String nombreControlServicio;

    /*
	 * Atributo tipoControlServicio. 
     */
    public String tipoControlServicio;

    /*
	 * Constructor con un parámetro de ControlServicio.
     */
    ControlServicio(String nombreControlServicio) {
        this.nombreControlServicio = nombreControlServicio;
        idControlServicio = numControlesConfigurados;
        numControlesConfigurados++;
        tipoControlServicio = "Desconocido";
    }

    /*
	 * Constructor sin parámetros de ControlServicio. 
     */
    ControlServicio() {

        idControlServicio = numControlesConfigurados;
        numControlesConfigurados++;
        nombreControlServicio = tipoControlServicio = "Desconocido";
    }

    /*
	 * Método estático observador (getter) el número de controles
	 * configurados
	 * 
     */
    public static int getNumControlesConfigurados() {
        return numControlesConfigurados;
    }

    /*
	 * Método estático modificador (setter) para el número de controles
	 * actualmente configurados. 
     */
    public static void setNumControlesConfigurados(int numControlesConfigurados) {
        ControlServicio.numControlesConfigurados = numControlesConfigurados;
    }


    /*
	 * Método estático observador (getter) el identificador 
     */
    public int getIdControlServicio() {
        return idControlServicio;
    }

    /*
	 * Método modificador (setter) nombre de control de 
     */
    public void setTipoControlServicio(String tipoControlServicio) {
        this.tipoControlServicio = tipoControlServicio;
    }

    /*
     * Método observador (getter)  tipo de control
     */
    public String getTipoControlServicio() {
        return tipoControlServicio;
    }

    /*    
     * Método toString
     */
    @Override
    public String toString() {
        return "ControlServicio{" + "idControlServicio=" + idControlServicio + ", nombreControlServicio=" + nombreControlServicio + ", tipoControlServicio=" + tipoControlServicio + '}';
    }

}
