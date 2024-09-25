/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea02;

import java.util.Random;

/**
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio04 {

    public static void main(String[] args) {
        //----------------------------------------------
        //               Declaración de variables
        //----------------------------------------------
        // Variables de entrada (aquí se definen las variables que recibirán valores, si fueran necesarias)

        // Variables de salida (aquí se definen las variables que almacenarán resultados y se mostrarán al usuario, si fueran necesarias)
        int contadorJugadas = 0, premioAmostrar = 0;
        String primerPremio = "PPP", segundoPremio = "FFF", tercerPremio = "MMM", cuartoPremio = "NNN", quintoPremio = "CCC", cadenaPremio = "", resultado = "", premioRecibido = "";
        boolean premio = false;
        /* La clase Random es una clase de Java que nos sirve para generar elementos aleatorios
            en este caso el objeto "r", consigue a través de su método nextInt(número), generar
            un número aleatorio entero entre 0 y número-1, por ejemplo r.nextInt(5), generará 
            un número entero entre 0 y 4, es decir, podrá devolver 0,1,2,3 o 4 cada vez que se 
            utilice.
         */

        Random r = new Random();
        //----------------------------------------------
        //              Entrada de datos
        //----------------------------------------------
        // En este caso no hay entrada de datos. 
        System.out.println("Ejercicio 4. Simulador de Máquina Tragaperras.");
        System.out.println("----------------------------------------------------");
        System.out.println("Voy a generar secuencias de 3 frutas entre Plátano, Fresa, Naranja, Manzana y Cereza hasta conseguir 3 iguales y te diré qué premio has obtenido de los cinco:");

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // Hemos de generar una secuencia de 3 frutas
        // Las frutas son: Plátano, Fresa, Manzana, Naranja, Cerezas 
        // Representamos cada fruta con un caracter: P,F,M.N,C
        // Para elegir una de las cinco frutas podemos asociar cada una con un número
        //Aquí en base a un número aleatorio, se coge una letra, y se repite hasta obtener 3 letras
        //  
        Random aleatorio = new Random();
        do {
            do {
                /*  Obtenemos un número aleatorio, en base a ese número y mediante un switch le asignamos una letra la cual guardamos en un string
                hasta que tenemos 3 letras
                 */
                int numeroAleatorio = aleatorio.nextInt(5);
                switch (numeroAleatorio) {
                    case 0:
                        cadenaPremio = cadenaPremio.concat("P");
                        break;
                    case 1:
                        cadenaPremio = cadenaPremio.concat("F");
                        break;
                    case 2:
                        cadenaPremio = cadenaPremio.concat("M");
                        break;
                    case 3:
                        cadenaPremio = cadenaPremio.concat("N");
                        break;
                    case 4:
                        cadenaPremio = cadenaPremio.concat("C");
                        break;
                    default:
                        System.out.println("Error no contemplado");
                }

            } while (cadenaPremio.length() < 3);
            //contabilizamos el número de veces que se ha repetido el bucle
            contadorJugadas++;
            //imprimimos por pantalla el contabilizador y la cadena que hemos obtenido
            //System.out.println(contadorJugadas + "-" + cadenaPremio);
            resultado += (contadorJugadas + "-" + cadenaPremio + "\n");
            switch (cadenaPremio) {
                case "PPP":
                    premioAmostrar = 1;
                    premio = true;
                    break;
                case "FFF":
                    premioAmostrar = 2;
                    premio = true;
                case "MMM":
                    premioAmostrar = 3;
                    premio = true;
                case "NNN":
                    premioAmostrar = 4;
                    premio = true;
                case "CCC":
                    premioAmostrar = 5;
                    premio = true;
                default:
                    premio = false;
                    cadenaPremio = "";
            }

            premioRecibido = "Has conseguido el premio " + premioAmostrar + " en el intento " + contadorJugadas + " con la secuencia: " + cadenaPremio;
        } while (!premio);
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        //Además de los intentos en los que se ha obtenido el premio, hay que decir qué premio hemos tenido de entre los posibles.
        System.out.println(resultado + premioRecibido);
    }
}
