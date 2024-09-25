package tarea05.clases;

import java.util.Scanner;
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
    private int numPedido = 1;
    private int pizzaActual = 0;
    private Configuracion configuracion;
    private Pizza[] pizzas;
    private final int basePequenha = 1;
    private final int baseMediana = 2;
    private final int baseGrande = 3;
    private final int margarita = 1;
    private final int barbacoa = 2;
    private final int carbonara = 3;
    private final int cuatroEstaciones = 4;
    int baseElegida = 0;
    int tipoElegido = 0;
    Scanner teclado = new Scanner(System.in);
    Scanner tecladoDos = new Scanner(System.in);
    private Pizza[] pedido = new Pizza[3];

    public GestorPedidos() {
        configuracion = new Configuracion();
        pizzas = new Pizza[configuracion.getNumPizza()];
    }

    public void gestionarPedidos() {//Método que mostrará el menú de la aplicación y que lanzará los diferentes métodos internos en función de lo se pida
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

                case INTRODUCIR_PIZZA: //Crearemos una pizza y la guardaremos.
                    // Llamar al método nsertarPizzaEnPedido
                    Pizza p1 = new Pizza("Configuracion.BASE_MEDIANA", "Configuracion.PIZZA_BARBACOA");
                    pedido[0] = p1;
                    insertarPizzaEnPedido();
                    break;

                case MOSTRAR_PEDIDO: //Mostraremos las pizzas del pedido.
                    //Llamar al método mostrarPedido      
                    mostrarPedido();
                    break;

                case FINALIZAR_PEDIDO: // Mostraremos las pizzas del pedido, el coste y prepararemos la aplicación para un nuevo pedido.
                    //Llamar al método finalizaPedido
                    resumenPedido();
                    finalizarPedido();

                    break;

                case SALIR:
                    terminar = true;
                    break;
            }

        } while (!terminar);
        ES.msg("Finalizando aplicación...\n");
    }

    public void insertarPizzaEnPedido() {
        System.out.println("Añadiendo pizza");
        ES.msgln("¿Qué tamaño de pizza desea?");
        ES.msgln(basePequenha + ".- Base pequeña");
        ES.msgln(baseMediana + ".- Base pequeña");
        ES.msgln(baseGrande + ".- Base pequeña");
        baseElegida = ES.leeEntero("elija una opción:", 1, 3);
        baseElegida = teclado.nextInt();
        switch (baseElegida) {
            case basePequenha:
                break;
            case baseMediana:
                break;
            case baseGrande:
                break;
        }

        ES.msgln("¿Qué tipo de pizza desea?");
        ES.msgln(margarita + ".- margarita");
        ES.msgln(barbacoa + ".- barbacoa");
        ES.msgln(carbonara + ".- carbonara");
        ES.msgln(cuatroEstaciones + ".- cuatro Estaciones");
        baseElegida = ES.leeEntero("elija una opción:", 1, 4);
        tipoElegido = tecladoDos.nextInt();
        switch (tipoElegido) {
            case margarita:
                break;
            case barbacoa:
                break;
            case carbonara:
                break;
            case cuatroEstaciones:
                break;
        }

        //Añadir una nueva pips al array de pipsas.
        // pizzas[pizzaActual] = new Pizza(3, 4);
        pizzaActual++;

    }

    public void mostrarPedido() {
        System.out.println("Pizzas de su pedido actual: ");
        StringBuilder cadena = new StringBuilder("");
        for (int i = 0; i < Pizza.numPizzas; i++) {
            cadena.append(pedido[i] + "\n");
        }
    }

    public void resumenPedido() {
        System.out.println("El resumen de su pedido es : ");

    }

    public void imprimeTicket() {
        System.out.println("Imprimiendo ticket....... ");

        pizzas = new Pizza[configuracion.getNumPizza()];
        numPedido++;
        pizzaActual = 0;

    }
    //Crear todos el resto de métodos de la clase.

    private void finalizarPedido() {
        System.out.println("El resumen de su pedido es : ");

        System.out.println("Su numero de pedido es el  : " + numPedido + "el total de su pedido es " + "caja. Gracias y hasta pronto.");
// liberar el array de pizzas
    }
}
