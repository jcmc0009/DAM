package trenes;

import trenes.controladores.Activable;
import trenes.controladores.ConjuntoAltavoces;
import trenes.controladores.ControlServicio;
import trenes.controladores.Modificable;
import trenes.controladores.PuertaVagon;
import trenes.controladores.TiraLuz;
import trenes.controladores.VentanillaVagon;

/**
 * Clase Lanzadera de la aplicación. Esta clase Tren contiene el método main
 * para realizar la ejecución del proyecto.
 *
 * @author David - IES Trassierra
 * @version 1.0
 *
 */
public class Tren implements Modificable, Activable {

    public static void main(String[] args) {
        int vagonNumero = 1;
        /* 1. Crear un array de 10 objetos tipo Control Servicio en una variable llamada
         controlesVagon
         */
        ControlServicio[] controlesVagon = new ControlServicio[10];


        /*2. Creamos dos objetos ConjuntoAltavoces, y los agregamos al array en las
         posiciones 0 y 1 del mismo
         */
        controlesVagon[0] = new ConjuntoAltavoces("Soy una pista", 10);
        controlesVagon[1] = new ConjuntoAltavoces("ahora eres tú la pista", 11);

        /* 3. Creamos dos objetos PuertaVagonTren, y los agregamos al array en las
         posiciones 2 y 3 del mismo
         */
        controlesVagon[2] = new PuertaVagon("Vagón 1", "Federico");
        controlesVagon[3] = new PuertaVagon("Vagón 2", "Manolo");

        /* 4. Creamos cuatro objetos VentanillaVagon, y los agregamos al array en las
         posiciones 4,5,6 y 7 del mismo        
         */
        for (int i = 4; i < 8; i++) {
            controlesVagon[i] = new VentanillaVagon(i + 10, "vagon " + i);
        }

        /* 5. Creamos dos objetos TiraLuz, y los agregamos al array en las posiciones 8
         y 9 del mismo        
         */
        controlesVagon[8] = new TiraLuz(true, "Vagon 8", 10, "control servicio");
        controlesVagon[9] = new TiraLuz(true, "Vagon 9", 10, "control servicio");

        /* 6. Se instancia o crea un objeto de tipo VagonTren. Para ello utilizamos, el
	   constructor de VagonTren al que se le pasa como parámetro el array de
	   objetos de tipo ControlServicio
         */
        VagonTren vagon = new VagonTren("Renfetrap", "Blablabla", 6);

        /*
	 * 7. Se imprime el objeto de tipo VagonTren. Para ello directamente imprimimos
	 * el objeto (ya que al tener creado el método toString() imprimirá toda la
	 * información)
         */
        // System.out.println("El vagón número "+vagonNumero+"\nEl vagón pertenece a " + vagon.getCompanyiaTrenes()+"\nPresenta los siguientes controles de servicios:"+"\n------------------------------------------");
        System.out.println(vagon.toString());
        /*
	 * 8. Mediante un bucle recorremos el array de objetos de tipo ControlServicio
	 * que hay en el objeto de tipo VagonTren creado anteriormente en el punto 6, y
	 * en el caso de que el objeto sea una instancia con interfaz "Modificable", se
	 * llamará al método aumentar() para que cada tipo de control de servicio
	 * ejecute el código correspondiente a la implementación de dicha interfaz. En
	 * el caso de que no sea una instancia con interfaz modificable, comprobamos si
	 * es una instancia de la clase TiraLuz, en cuyo caso, se realizan dos acciones
	 * por un lado cambiar el color de la tira (cambiarColorTira() sin parámetros)
	 * por otro lado la llamada al método on, para encender todas las Tiras de Luz
         */
        for (int i = 0; i < ControlServicio.getNumControlesConfigurados()+1; i++) {

        }

        /*
 
 
	 * 9. Nuevamente se imprime el objeto de tipo VagonTren para ver los cambios
	 * realizados. Para ello directamente imprimimos el objeto (ya que al tener
	 * creado el método toString() imprimirá toda la información)
         */
 /* 10. Se realiza la llamada al método preparado para cerrar todas las puertas, 
         * implementado en la clase VagonTren. Si se quiere hacer de otra forma 
         * también se puede mediante un bucle recorremos el array de objetos de tipo 
         * PuertaVagonTren en el que hay en el objeto de tipo VagonTren creado anteriormente
         * en el punto 6, abrimos todas las PuertaVagonTren, para ello debemos comprobar
         * si cada elemento del array es una instancia del tipo PuertaVagonTren, y
	 * posteriormente llamar al método on()
         */
        vagon.setServicios(controlesVagon);
        vagon.cerrarPuertas();
        /*
	 * 11. Nuevamente se imprime el objeto de tipo VagonTren para ver los cambios
	 * realizados. Para ello directamente imprimimos el objeto (ya que al tener
	 * creado el método toString() imprimirá toda la información)
         */
        System.out.println(vagon.toString());
        /* 12. Se realiza la llamada al método preparado para on todos los 
         * controles de servicio implementado en la clase VagonTren. 
         */
        vagon.activarTodosServicios();
        /*
	 * 13. Nuevamente se imprime el objeto de tipo VagonTren para ver los cambios
	 * realizados. Para ello directamente imprimimos el objeto (ya que al tener
	 * creado el método toString() imprimirá toda la información)
         */
        System.out.println(vagon.toString());
    }

    @Override
    public int getValorMinimoPosibleEstadoControl() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public int getValorMaximoPosibleEstadoControl() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void aumentar() {
        
    }

    @Override
    public void disminuir() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void on() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void off() {

    }

}
