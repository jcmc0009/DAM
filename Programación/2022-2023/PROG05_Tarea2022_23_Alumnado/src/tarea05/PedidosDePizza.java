package tarea05;

import tarea05.clases.Configuracion;
import tarea05.clases.GestorPedidos;
import utilidades.ES;

/**
 * Clase con la que trabajaremos la gestión de pedidos de pizzas.
 *
 * @author Profe
 */
public class PedidosDePizza {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Variables
        GestorPedidos aplicacion;

        //Mostramos el resumen de las configuraciones establecidas para la aplicación.
        // Aqui llama al método que realiza el texto con los datos de la configuración actual y muestralos en la consola.
        //Creamos un pedido
        aplicacion = new GestorPedidos();

        //Mandamos comenzar los pedidos
        aplicacion.gestionarPedidos();
       
    
    }
}
