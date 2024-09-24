/*
 * Juego de las Siete y Media
 */
package tarea02;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio03 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Variables de entrada (aquí se definen las variables que recibirán valores, si fueran necesarias)
        // Variables de salida (aquí se definen las variables que almacenarán resultados y se mostrarán al usuario, si fueran necesarias)
        // Clase Scanner para petición de datos al usuario a través del teclado
        double banca, puntosJugador;
        int carta;
        double valorCartaAleatoria;
        boolean quieresSeguir = true, parar = false;

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        // Generamos un número entre 4 y 7.5
        /* La clase Random es una clase de Java que nos sirve para generar elementos aleatorios
            en este caso el objeto "r", consigue a través de su método nextInt(número), generar
            un número aleatorio entero entre 0 y número-1, por ejemplo r.nextInt(4), generará 
            un número entero entre 0 y 3, es decir, podrá devolver 0,1,2 o 3 cada vez que se 
            utilice.
            En la siguiente línea generamos un número entre  0 y 3, al que le sumamos 4, de esta
            forma la banca obtendrá siempre un número bastante competivo, entre 4 y 7.
            Posteriormente utilizamos este mismo método sin parámetros, generando un entero entre
            0 y 2 elevado a 32
         */
        Random r = new Random();
        banca = 4 + r.nextInt(4) + ((r.nextInt() % 2 == 0) ? 0f : 0.5f);

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        valorCartaAleatoria = 0;
        puntosJugador = 0;
        do {
            Random aleatorio = new Random();
            carta = aleatorio.nextInt(13); //este código tiene como propósito el genera un número aletorio entre 0 y 12

            switch (carta) { //en este switch asignamos a cada valor aleatorio obtenido antes, un carta con un valor propio
                case 1:
                    valorCartaAleatoria = 1;
                    break;
                case 2:
                    valorCartaAleatoria = 2;
                    break;
                case 3:
                    valorCartaAleatoria = 3;
                    break;
                case 4:
                    valorCartaAleatoria = 4;
                    break;
                case 5:
                    valorCartaAleatoria = 5;
                    break;
                case 6:
                    valorCartaAleatoria = 6;
                    break;
                case 7:
                    valorCartaAleatoria = 7;
                    break;
                case 8:

                case 9:
                    valorCartaAleatoria = 0;
                    break;
                case 10:

                case 11:

                case 12:
                    valorCartaAleatoria = 0.5;
                    break;
            }
            puntosJugador += valorCartaAleatoria; //sumaamos el valor de todas las cartas anteriores
            System.out.println("El valor obtenido es " + valorCartaAleatoria); //mostramos el valor de la carta obtenida
            System.out.println("La suma total de sus cartas es " + puntosJugador); //mostramos la puntuación total del jugador
            
            
            if (puntosJugador <= 7.5) { // en base a la puntación del jugador el flujo se mueve a un flujo u otro  , flujo 1
                quieresSeguir = true;
            } else if (puntosJugador > 7.5) {  // en base a la puntación del jugador el flujo se mueve a un flujo u otro , flujo 2 
                quieresSeguir = false;

            }

            if (quieresSeguir == true) { //flujo 1

                System.out.println("¿Quieres seguir(true/false)?");
                quieresSeguir = teclado.nextBoolean();// en base al valor introducido true o false, se redirige a un flujo u otro, true flujo 1 y false flujo 2

            }
            if (quieresSeguir == false) {  //flujo 2

                System.out.println("Resultado ");
                System.out.println("-------------");
                // en base a los puntos obtenidos por el jugador el flujo va por un camino u otro
                if (puntosJugador > 7.5) { // el jugador se ha pasado , por lo que pierde
                    System.out.println("Has perdido, tu puntuación es " + puntosJugador);
                    parar = true;

                }
                if (puntosJugador > banca && puntosJugador <= 7.5) {
                    /* introducimos el rengo de valores y una condicional, que puntosJugador sea mayor que la banca(puntos banca)
 pero también establecemos que puntosJugador sea menor o igual que 7.5*/
                    System.out.println("Has ganado " + banca + " VS " + puntosJugador + " jugador");
                    parar = true; //al igualar parar a true, el bucle se para
                }
                if (puntosJugador < banca && puntosJugador <= 7.5) {/* introducimos el rengo de valores y una condicional, que puntosJugador sea menor que la banca(puntos banca)
 pero también establecemos que puntosJugador sea menor o igual que 7.5*/

                    System.out.println("Has perdido " + banca + " VS " + puntosJugador + " jugador");
                    parar = true;//al igualar parar a true, el bucle se para
                }
                if (puntosJugador == banca) { //este if, ante empate, la  banca gana

                    System.out.println("Ha ganado la banca: banca " + banca + " VS " + puntosJugador + " jugador");
                    parar = true; //al igualar parar a true, el bucle se para
                }

            }

        } while (parar == false); //el bucle sigue hasta que la variable parar sea igual true, mientras sigue ejecutandose

    }

}
