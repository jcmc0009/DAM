/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea02;

/**
 *
 * @author José Carlos Manjón Carrasco
 */
import java.util.Scanner;

public class Ejercicio02 {

    public enum Bebidas {
        COCACOLA, PEPSI, AGUA, ZUMO, OTRO
    };

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Variables de entrada (aquí se definen las variables que recibirán valores, si fueran necesarias)
        int opcionElegida;

        // Variables de salida (aquí se definen las variables que almacenarán resultados y se mostrarán al usuario, si fueran necesarias)
        double precioBebida = 0, dineroParaBebida, vuelta;
        boolean salida = false;
        Bebidas miBebida = null;
        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner scanner = new Scanner(System.in);
        Scanner dinero = new Scanner(System.in);

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio 2: Máquina expendedora de Bebidas\n");
        System.out.println("----------------------------------------------------");
        // Bloque 1: Sacamos por pantalla el menú de opciones y pedimos que introduzca una.
        //cambiar linea 42 por un do-while pues se repite la cosa como mínimo una vez
        do {
            System.out.println("1. COCACOLA - 1.50€\n2. PEPSI - 1.50€\n3. AGUA - 1.00€\n4. Zumo de naranja - 2.00€\n0. Salir");
            System.out.println("Seleccione una opción:");
            opcionElegida = scanner.nextInt();
            //  En caso de introducir una opción inválida, debemos indicarlo y volver a pedirla.
            //----------------------------------------------
            //                 Procesamiento y  Salida de resultados 
            //----------------------------------------------
            // Cuando haya introducido una opción válida, llevamos a cabo la acción oportuna
            //  -Si nos indica 'Salir', nos despedimos y terminamos
            //  -Si nos indica un producto
            //      -Decimos el producto seleccionado y su precio
            //      -Pedimos que introduzca el importe
            //          -Si el importe es suficiente
            //               -Imprimimos el producto obtenido (Equivale a la orden de suministrar el producto
            //               -Decimos el importe que ha sobrado
            //          -Si no, indicamos que el importe es insuficiente 
            /* En el switch al seleccionar la bebida que deseamos, la variable miBebeida adquiere valor con el nombre de la bebida,
            además le amos valor a la bebida, este valor nos será útil para calcular la vuelta si procede*/
            switch (opcionElegida) {
                case 0:
                    salida = true;
                    break;
                case 1:
                    precioBebida = 1.5;
                    miBebida = Bebidas.COCACOLA;
                    salida = true;
                    break;
                case 2:
                    precioBebida = 1.5;
                    miBebida = Bebidas.PEPSI;
                    salida = true;
                    break;
                case 3:
                    precioBebida = 1;
                    miBebida = Bebidas.AGUA;
                    salida = true;
                    break;
                case 4:
                    precioBebida = 2;
                    miBebida = Bebidas.ZUMO;
                    salida = true;
                    break;
                default:
                    miBebida = Bebidas.OTRO;
                    System.out.println("Opción no válida. Seleccione una bebida válida");

            }
            //----------------------------------------------
            //             Salida de resultados 
            //----------------------------------------------
            //  Se produce durante el proceso

        } while (!salida);
        // con la siguiente condición en caso de coger bebida válida, se muestra por pantalla , se informa del precio y se pregunta el dinero disponble para la compra
        // mostrando el cambio o informando que no hay dinero suficiente 
        if (opcionElegida >= 1) {
            System.out.printf("Ha seleccionado un(a) " + miBebida + ". El precio es de %.2f € \nIngrese la cantida de dinero en euros: ", precioBebida);
            dineroParaBebida = dinero.nextDouble();
            vuelta = dineroParaBebida - precioBebida;
            if (vuelta >= 0) {
                System.out.printf("Compra exitosa. Su cambio es : %.2f € \nDisfrute de su " + miBebida + "!\n", vuelta);
            } else {
                System.out.println("Dinero insuficiente. Su dinero será devuelto");
            }
        } else {
            System.out.println("Gracias por usar la Máquina Expendedora. ¡Hasta luego!");
        }
    }
}
