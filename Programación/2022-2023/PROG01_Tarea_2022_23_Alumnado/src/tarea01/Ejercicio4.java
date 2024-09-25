/**
 *
 * Ejercicio 4.  Horas, minutos y segundos
 * Realización de cálculo de horas , minutos y segundos según el tiempo introducido
 *
 * @José Carlos Manjón Carrasco
 */
package tarea01;

import java.util.Scanner;

public class Ejercicio4 {

    public static void main(String[] args) {

        // TODO code application logic here
        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //               Variables entrada
        //----------------------------------------------
        int horas, minutos, segundos, totalSegundos, sumaSegundos, calculoTotalHoras, calculoTotalMinutos, calculoTotalSegundos, horasSegundos, minutosSegundos;

        //----------------------------------------------
        //               constantes
        //----------------------------------------------
        //*se crean 2 constantes, una con el valor de una hora en segundos, y otra con el valor de un minuto en segundos
        final int HORASSEGUNDOS = 3600;
        final int MINUTOSSEGUNDOS = 60;

        //----------------------------------------------
        //               Entrada de datos
        //----------------------------------------------
        //pedimos por pantalla la entrada de datos
        System.out.println("Introduce el número de horas");

        horas = teclado.nextInt();

        System.out.println("Introduce el número de minutos");

        minutos = teclado.nextInt();

        System.out.println("Introduce el número de segundos");

        segundos = teclado.nextInt();

        System.out.println("Introduce el total de segundos");

        totalSegundos = teclado.nextInt();

        //----------------------------------------------
        //               procesamiento
        //----------------------------------------------
        sumaSegundos = (horas * HORASSEGUNDOS) + (minutos * MINUTOSSEGUNDOS) + segundos + totalSegundos; //pasar todo a segundos
        calculoTotalHoras = sumaSegundos / HORASSEGUNDOS; // cálculo de horas totales , así eliminamos la mayor cantidad de tiempo
        calculoTotalMinutos = (sumaSegundos % HORASSEGUNDOS) / MINUTOSSEGUNDOS;// con el resto de la cantida de horas, se divide por 60 , y obtenemos la cantida de minutos
        calculoTotalSegundos = (sumaSegundos % HORASSEGUNDOS) % MINUTOSSEGUNDOS;//con el resto de la cantidad de minutos, dividios por 60, obtenemos la cantida de segundos

        //----------------------------------------------
        //              Salida de resultados
        //----------------------------------------------
        System.out.print("Las cantidades suman un total de " + calculoTotalHoras + "h, " + calculoTotalMinutos + " minutos, y " + calculoTotalSegundos + " segundos\n");

        System.out.print("-------");

    }

}
