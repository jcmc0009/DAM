package tarea05.clases;

import utilidades.ES;

/**
 *
 * @author profe
 */
public class GestorPedidos {

    //----------------------------------------------
    //          Declaración de variables 
    //----------------------------------------------
    //Constantes
    private final int INTRODUCIR_PIZZA = 1;
    private final int MOSTRAR_PEDIDO = 2;
    private final int FINALIZAR_PEDIDO = 3;
    private final int SALIR = 4;
    private final int PRIMER_NUMERO_DE_PEDIDO = 1; // Podremos definir por cúal número comienzan los pedidos.

    public static int numeroDePedido;
    private Pizza[] pedidoDePizzas; //Array en el que almacenaremos las pizzas del pedido.

    public GestorPedidos() {
        this.numeroDePedido = PRIMER_NUMERO_DE_PEDIDO; //
        this.pedidoDePizzas = new Pizza[Configuracion.MAXIMO_DE_PIZZAS_POR_PEDIDO]; //Inicializo el array.
    }

    public void gestionarPedidos() {
        //Variables        
        boolean terminar = false;

        // Variables de entrada
        int opcionElegida = 0;

        //----------------------------------------------
        //               Procesamiento 
        //----------------------------------------------
        do {
            ES.msgln("\nMenú Pedido Pizza");
            ES.msgln("-------------------------");
            ES.msgln(INTRODUCIR_PIZZA + ".- Introducir pizza en el pedido.");
            ES.msgln(MOSTRAR_PEDIDO + ".- Ver estado del pedido.");
            ES.msgln(FINALIZAR_PEDIDO + ".- Finalizar Pedido.");
            ES.msgln(SALIR + ".- Apagar aplicación.");
            opcionElegida = ES.leeEntero("elija una opción:", 1, 4); //Leeremos un número entero entre 1 y 4.

            switch (opcionElegida) {

                case INTRODUCIR_PIZZA:
                    try {
                    insertarPizzaEnPedido(new Pizza());
                } catch (Exception ex) {
                    ES.msgln(ex.getMessage());
                }
                break;

                case MOSTRAR_PEDIDO: //Mostraremos las pizzas del pedido.
                    try {
                    mostrarPedido();
                } catch (Exception ex) {
                    ES.msgln(ex.getMessage());
                }
                break;

                case FINALIZAR_PEDIDO: // Mostraremos las pizzas del pedido, el coste y prepararemos la aplicación para un nuevo pedido.
                    finalizaPedido();
                    break;

                case SALIR:
                    terminar = true;
                    break;
            }

        } while (!terminar);
        ES.msg("Finalizando aplicación...\n");
    }

    /**
     * Método que creará una pizza y la guardará.
     *
     * @param pizza
     */
    private void insertarPizzaEnPedido(Pizza pizza) {
        String tamanhoPizza;
        this.pedidoDePizzas[Pizza.numeroDePizzasCreadas] = pizza;
        tamanhoPizza = pedidoDePizzas[Pizza.numeroDePizzasCreadas].getTamanho();
        if (tamanhoPizza == "pequenho") { // Comprobamos si debemos mostrar correctamente la ñ
            tamanhoPizza = "pequeño";
        }
        ES.msgln("la pizza seleccionada ha sido una pizza " + pedidoDePizzas[Pizza.numeroDePizzasCreadas].getTipo()
                + " de tamaño " + tamanhoPizza + " cuyo importe es " + String.format("%.2f", pedidoDePizzas[Pizza.numeroDePizzasCreadas].getPrecio()) + " €.");
        Pizza.numeroDePizzasCreadas++;
    }

    /**
     * Método que mostrará todas las pizzas del pedido.
     *
     * @throws Exception
     */
    private void mostrarPedido() throws Exception {
        ES.msgln("Pizzas de su pedido actual:");
        if (Pizza.numeroDePizzasCreadas == 0) {
            throw new Exception("El pedido aún está vacío.");
        }
        for (int i = 0; i < Pizza.numeroDePizzasCreadas; i++) {
            ES.msgln(pedidoDePizzas[i].toString());
        }

    }

    /**
     * Método que gestionará la finalización del pedido y preparará al sistema
     * para uno nuevo.
     */
    private void finalizaPedido() {
        float dineroPedidoCompleto = 0;
        ES.msg("El resumen de su pedido es:\n");
        for (int i = 0; i < Pizza.numeroDePizzasCreadas; i++) {
            ES.msgln(pedidoDePizzas[i].toString());
            dineroPedidoCompleto += pedidoDePizzas[i].getPrecio();
        }
        ES.msgln("Su número de pedido es el " + GestorPedidos.numeroDePedido + 
                        ". El total de su pedido asciende a " + String.format("%.2f", dineroPedidoCompleto) +
                        " €. Imprimiendo ticket... no olvide pasar por caja. Gracias y hasta pronto.");
        this.imprimeTicket();
        GestorPedidos.numeroDePedido++;
        this.limpiarPedido();
    }

    private void imprimeTicket() {
        float dineroPedidoCompleto = 0;
        String tamanho = "";

        ES.msgln("\n+----------------------------------------------------+");
        ES.msgln("|                   Paco`s Pizza                     | ");
        ES.msgln("|                   PEDIDO: " + String.format("%0" + 4 + "d", GestorPedidos.numeroDePedido) + "                     | ");
        ES.msgln("|                                                    | ");
        for (int i = 0; i < Pizza.numeroDePizzasCreadas; i++) {
            tamanho = pedidoDePizzas[i].getTamanho();
            if (tamanho == "pequenho") { // Comprobamos si debemos mostrar correctamente la ñ
                tamanho = "pequeño";
            }
            ES.msgln("|            " + pedidoDePizzas[i].getTipo() + "   "
                    + tamanho + "   "
                    + String.format("%.2f", pedidoDePizzas[i].getPrecio()) + " € ");
            dineroPedidoCompleto += pedidoDePizzas[i].getPrecio();
        }
        ES.msgln("|                                                    | ");
        ES.msgln("|                   TOTAL: " + String.format("%.2f", dineroPedidoCompleto) + " €");
        ES.msgln("|                                                    | ");
        ES.msgln("|               GRACIAS POR SU VISITA                | ");
        ES.msgln("+----------------------------------------------------+");
    }

    private void limpiarPedido() {
        for (int i = 0; i < Pizza.numeroDePizzasCreadas; i++) {
            pedidoDePizzas[i] = null; //El recolector de basura destruira el objeto porque ya no estará referenciado.                       
        }
        Pizza.numeroDePizzasCreadas = 0;
    }
}
