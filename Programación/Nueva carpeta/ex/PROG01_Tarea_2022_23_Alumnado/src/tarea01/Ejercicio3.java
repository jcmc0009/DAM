/**
 *
 * Ejercicio 3.  Recluido en casa
 * Basándose en 3 entradas, se decide si se puede salir a la calle o no
 *
 * @José Carlos Manjón Carrasco
 */
package tarea01;

import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {

        // TODO code application logic here
        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //               Variables entrada
        //----------------------------------------------
        boolean lluvia, tareaTerminada, necesidadSupermercado;

        //----------------------------------------------
        //               Variables salida
        //----------------------------------------------
        //----------------------------------------------
        //               Entrada de datos
        //----------------------------------------------
        //pedimos por pantalla la entrada de datos
        System.out.println("¿Está lloviendo? (true or false)");

        lluvia = teclado.nextBoolean();

        System.out.println("¿He terminado la tarea de programación? (true or false)");

        tareaTerminada = teclado.nextBoolean();

        System.out.println("¿Tenqo que ir al supermercado? (true or false)");

        necesidadSupermercado = teclado.nextBoolean();

        //----------------------------------------------
        //               procesamiento
        //----------------------------------------------
        String salirCalle = (necesidadSupermercado || (tareaTerminada && !lluvia)) ? "Si" : "No";
        

        //----------------------------------------------
        //              Salida de resultados
        //----------------------------------------------
        System.out.println("Resultado");
        System.out.println("---------");
        System.out.println("Tenienendo en cuenta lo anterior,¿puedo salir a la calle?\n" + salirCalle+","+ salirCalle+" puedes");
        System.out.println("---------");

    }

}
