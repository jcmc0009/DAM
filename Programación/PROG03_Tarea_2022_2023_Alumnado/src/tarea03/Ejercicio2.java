package tarea03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

/**
 * Ejercicio 2: ¡A jugar! Utilización de las clases CartonBingo y Bombo para
 * simular una partida.<br>
 * En este ejercicio probamos el funcionamiento de la clase Bombo tratando de
 * conocer los métodos que tiene y el funcionamiento de cada uno de ellos.
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        // 1.- Presentación del ejercicio
        System.out.println("Ejercicio 2. ¡A jugar!");
        System.out.println("----------------------");
        /* 
            Debes mostrar la fecha ACTUAL (hoy) usando la API de LocalDate
            (usa también DateTimeFormatter para formatear la fechala correctamente (ej. 08/11/2022)
         */

        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate hoy = LocalDate.now();
        System.out.println("Fecha actual de ejecución: " + hoy.format(formateador));

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        String jugador1, jugador2, jugador3;
        Boolean lineaVerificada = false, bingoVerificado = false;
        //----------------------------------------------
        //          Entrada de datos
        //----------------------------------------------

        //pedimos por pantalla el nombre de los jugadores
        Scanner teclado = new Scanner(System.in);
        System.out.println("introduce el nombre del/la primer/a jugador/a:");
        jugador1 = teclado.nextLine();
        System.out.println("introduce el nombre del/la segundo/a jugador/a:");
        jugador2 = teclado.nextLine();
        System.out.println("introduce el nombre del/la tercer/a jugador/a:");
        jugador3 = teclado.nextLine();

        //----------------------------------------------
        //     Procesamiento + Salida de resultados
        //----------------------------------------------
        // 2.- Creación de los cartones para los jugadores
        CartonBingo cartonJugador1 = new CartonBingo(jugador1, hoy);
        System.out.println(cartonJugador1 + "\n");
        CartonBingo cartonJugador2 = new CartonBingo(jugador2, hoy);
        System.out.println(cartonJugador2 + "\n");
        CartonBingo cartonJugador3 = new CartonBingo(jugador3, hoy);
        System.out.println(cartonJugador3 + "\n");

        // 3.- Creación del bombo para el sorteo de hoy
        Bombo bomboHoy = new Bombo(hoy);
        System.out.println("Comienza el juego, jugamos para " + "'Línea'...");
        // 4.- Comienza el juego. Jugamos para "Línea"
        /*Simulamos una partida real, donde primero se canta línea y luego bingo,
        para la línea el/la jugador en caso de tener línea la cantará, entonces entra en juego la verificación por parte del bingo (en este caso bomboHoy.verificarLinea),
        en el caso de ser positiva ambas, entonces continuamos para bingo, donde se repetirá el proceso
        Usamos una variable booleana para salir de los bucles do-while, uno para linea y bingo, pues debemos seguir sacando números y marcarlos hasta que algún jugador
        obtenga línea y bingo*/
        // 4.1.- Extraer una bola del bombo y "cantarla"
        do {
            int numeroBombo = bomboHoy.sacarBola();
            System.out.println(bomboHoy.cantarNumero(numeroBombo));

            // 4.2.- Marcar el número de la bola en el cartón de cada jugador
            cartonJugador1.marcarNumero(numeroBombo);
            cartonJugador2.marcarNumero(numeroBombo);
            cartonJugador3.marcarNumero(numeroBombo);
            // 4.3.- Comprobar si alguno de los jugadores puede cantar ¡Línea! y comprobar si es correcta o no
            cartonJugador1.cantarLinea();
            cartonJugador2.cantarLinea();
            cartonJugador3.cantarLinea();

            if (cartonJugador1.cantarLinea() == true) {
                System.out.println("*****" + jugador1 + ":*Linea*****");
                System.out.println("Verificamos la línea cantada por " + jugador1 + " ...");
                System.out.println(cartonJugador1);
                if (bomboHoy.verificarLinea(cartonJugador1) == true) {

                    System.out.println("La línea cantada por " + jugador1 + " es Válida");
                    System.out.println();

                    lineaVerificada = cartonJugador1.cantarLinea();
                } else {
                    System.out.println("La línea cantada por " + jugador1 + " No es válida");
                }
            } else if (cartonJugador2.cantarLinea() == true) {
                System.out.println("*****" + jugador2 + ":*Linea*****");
                System.out.println("Verificamos la línea cantada por " + jugador2 + " ...");
                System.out.println(cartonJugador2);
                if (bomboHoy.verificarLinea(cartonJugador2) == true) {

                    System.out.println("La línea cantada por " + jugador2 + " es Válida");
                    System.out.println();

                    lineaVerificada = cartonJugador2.cantarLinea();
                } else {
                    System.out.println("La línea cantada por " + jugador2 + " No es válida");
                }
            } else if (cartonJugador3.cantarLinea() == true) {
                System.out.println("*****" + jugador3 + ":*Linea*****");
                System.out.println("Verificamos la línea cantada por " + jugador3 + " ...");
                System.out.println(cartonJugador3);
                if (bomboHoy.verificarLinea(cartonJugador3) == true) {

                    System.out.println("La línea cantada por " + jugador3 + " es Válida");
                    System.out.println();

                    lineaVerificada = cartonJugador3.cantarLinea();
                } else {
                    System.out.println("La línea cantada por " + jugador3 + " No es válida");
                }
            }

        } while (!lineaVerificada);
        System.out.println("\n");
        // 5.- Una vez se ha cantado una línea correcta continúa el juego para "Bingo"

        System.out.println("Seguimos para Bingo...");

        // 5.1.- Extraer una bola del bombo y "cantarla"
        do {
            int numeroBombo = bomboHoy.sacarBola();
            System.out.println(bomboHoy.cantarNumero(numeroBombo));
            // 5.2.- Marcar el número de la bola en el cartón de cada jugador
            cartonJugador1.marcarNumero(numeroBombo);
            cartonJugador2.marcarNumero(numeroBombo);
            cartonJugador3.marcarNumero(numeroBombo);
            // 5.3.- Comprobar si alguno de los jugadores puede cantar ¡Bingo! y comprobar si es correcto o no
            cartonJugador1.cantarBingo();
            cartonJugador2.cantarBingo();
            cartonJugador3.cantarBingo();

            if (cartonJugador1.cantarBingo() == true) {
                System.out.println("*****" + jugador1 + ":*Bingo*****");
                System.out.println("Verificamos el bingo cantado por " + jugador1 + " ...");
                System.out.println(cartonJugador1);
                if (bomboHoy.verificarBingo(cartonJugador1) == true) {

                    System.out.println("El bingo cantado por " + jugador1 + " es Válido");
                    System.out.println();

                    bingoVerificado = cartonJugador1.cantarBingo();
                } 
            } else if (cartonJugador2.cantarBingo() == true) {
                System.out.println("*****" + jugador2 + ":*Bingo*****");
                System.out.println("Verificamos el bingo cantado por " + jugador2 + " ...");
                System.out.println(cartonJugador2);
                if (bomboHoy.verificarBingo(cartonJugador2) == true) {

                    System.out.println("El bingo cantado por " + jugador2 + " es Válido");
                    System.out.println();

                    bingoVerificado = cartonJugador2.cantarBingo();
                }
            } else if (cartonJugador3.cantarBingo() == true) {
                System.out.println("*****" + jugador3 + ":*Bingo*****");
                System.out.println("Verificamos el bingo cantado por " + jugador3 + " ...");
                System.out.println(cartonJugador3);
                if (bomboHoy.verificarBingo(cartonJugador3) == true) {

                    System.out.println("El bingo cantado por " + jugador3 + " es Válido");
                    System.out.println();

                    bingoVerificado = cartonJugador3.cantarBingo();
                }
            }

        } while (!bingoVerificado);

        // 6.- Mostrar un resumen del sorteo
        System.out.println("Bolas No extraídas hasta el momento\n" + bomboHoy.listadoBolasPendientes());
        System.out.println("Bolas  extraídas hasta el momento\n" + bomboHoy.listadoBolasExtraidas());
        System.out.println("----------------------------------");
        System.out.println("-Cantidad de bolas extraidas:" + bomboHoy.getNumBolasExtraidas());
        System.out.println("-Cantidad de bolas extraidas:" + bomboHoy.getNumBolasPendientes());
        System.out.println("----------------------------------");

        // En este if else-if else, mostramos quien es el ganador
        if (cartonJugador1.tieneLinea() == true) {
            System.out.println("-Ganador/a Línea: " + jugador1);
        } else if (cartonJugador2.tieneLinea() == true) {
            System.out.println("-Ganador/a Línea: " + jugador2);
        } else {
            System.out.println("-Ganador/a Línea: " + jugador3);
        }

        if (cartonJugador1.tieneBingo() == true) {
            System.out.println("-Ganador/a Bingo: " + jugador1);
        } else if (cartonJugador2.tieneBingo() == true) {
            System.out.println("-Ganador/a Bingo: " + jugador2);
        } else {
            System.out.println("-Ganador/a Bingo: " + jugador3);
        }
        System.out.println("----------------------------------");
        System.out.println();
        System.out.println("El sorteo ha finalizado!!");
        System.out.println();
    }
}
