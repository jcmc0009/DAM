package tarea05;

import tarea05.clases.Configuracion;
import tarea05.clases.GestorPedidos;
import tarea05.clases.Pizza;
import utilidades.ES;

/**
 * Clase con la que trabajaremos la gestión de pedidos de pizzas.
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
        ES.msg(Configuracion.getConfiguraciones());
        
        //Creamos un pedido
        aplicacion = new GestorPedidos();
        
        //Mandamos comenzar los pedidos
        aplicacion.gestionarPedidos();
        
    }
}
