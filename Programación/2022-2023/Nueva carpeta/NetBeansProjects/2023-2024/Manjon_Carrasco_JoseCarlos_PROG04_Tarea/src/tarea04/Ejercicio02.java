package tarea04;

import java.util.Random;
import java.util.Scanner;

/**
 * Tarea Online 4. Ejercicio 2: Campo de regalos
 *
 * @author José Carlos Manjón Carrasco
 * @version 1.0
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        // DEFINICIÓN DE CONSTANTES
        // DEFINICIÓN DE VARIABLES
        int bolsaPremios = 0;

        // Variable que contiene un objeto tipo Random para generar valores aleatorios
        // Matriz de enteros para gestionar la partida de juego
        int[][] matriz;
        int fila = 0, filaAmostrar = 1;
        String posicionAvanze = "", mensajeFinal = "";
        // Variable que contiene un objeto tipo Scanner para gestionar la entrada de datos
        Scanner teclado = new Scanner(System.in);

        // Genera números aleatorios
        Random aleatorio = new Random();

        /* ************************************************************************
         * PROCESAMIENTO
         * ***********************************************************************/
 /* 
         1. Creación de la Matriz
         Creamos una matriz bidimensional de 6x6 que será nuestro mapa, donde
         iremos recorriendo entre los premios
         */
        matriz = new int[6][6];

        /* 
           2. Generación de Premios 
           Se generan números aleatorios entre 100 y 200, que se asignarán a cada una
           una de las casillas, un premio aleatorio para cada casilla. Debemos recorrer
           la matriz y asignar los premios.
         */
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j] = (aleatorio.nextInt(101) + 100);
            }
        }

        /* 
           3. Asignación de CEROS
           A partir de la segunda fila, elegimos aleatoriamente una posición entre 0 y 
            el número de columnas de cada fila. En esa posición para cada fila, 
           sobreescribimos el valor existente y asignamos un cero
         */
        for (int i = 1; i < matriz.length; i++) {
            int columnaAleatoria = aleatorio.nextInt((matriz[i].length));
            matriz[i][columnaAleatoria] = 0;

        }
        /*
         4.1 Elección de columna de partida en la primera fila.
         Al igual que antes elegimos una posición aleatoria entre 0 y 
         el número de columnas de esa primera fila.
         */
        int columna = aleatorio.nextInt(matriz.length);
        /*
         4.2 Sumar el premio existente en la casilla elegida a la bolsa de premios
         */
        bolsaPremios += matriz[fila][columna];
        //    mostrar(matriz);
        /*
          4.3 Cambiamos el valor de la casilla elegida "3", para posteriormente 
        poder mostrar una "A" en dicha casilla
         */
        matriz[fila][columna] = 3;

        do {
            /* 5. Para realizar la  jugada mostraremos el mapa, así como la posición en la que se encuentra (fila y columna). 
           Posteriormente, se muestra al usuario los posibles movimientos que puede realizar
                - Si se está en la primera columna (0), evidemente sólo se podrá ir de frente o a la derecha
                - Si se está en la úlitma columna (longitud-1), evidemente sólo se podrá ir de frente o a la izquierda
                - Si se está en una columna intermedia, se podrá avanzar a cualquiera de las tres posiciones (frente, derecha o izquierda)
           Se pregunta al usuario la dirección de su avance en función de sus posibilidades.
           Si el desplazamiento introducido no es correcto se volverá a repetir la solicitud de dirección           
             */
 /*
             5.1 Mostrar el mapa actualmente
             Para recorrer el mapa por filas, se irá descubiendo cada una de las casillas
             El valor mostrado dependerá de si la casilla está descubierta o no, 
             presentando dos posibles casos, 
             - si la fila de la casilla es menor o igual a la que estamos mostraremos 
               la información según los cógigos establecidos en el enunciado.
             - Si la fila de la casilla es mayou a que estamos actualmente, mostraremos una "X"
             
             */
            System.out.println("Mapa ACTUAL");
            mostrar(fila, matriz);

            /* 5.2 Se muestra el premio actual */
            System.out.println("El premio actual es de " + bolsaPremios);
            /* 5.3 Se muestra la fila y columnas actuales*/
            System.out.println("La posición actual es de " + filaAmostrar + " y columna " + columna);
            filaAmostrar++;
            /* 5.4 Se genera un bucle para validar la entrada y elegir un valor 
               correcto, entre IZQUIERDA, DERECHA  o FRENTE. Sólo se mostrarán los 
               posibles movimientos en función de las posibilidades*/
            do {
                /* 5.4.1 Mostramos las posibilidades según la posición horizontal
                    *  - Si se está en la primera columna (0), evidentemente sólo se podrá ir de frente o a la derecha
                    *  - Si se está en la últi  ma columna (longitud-1), evidentemente sólo se podrá ir de frente o a la izquierda
                    *  - Si se está en una columna intermedia, se podrá avanzar a cualquiera de las tres direcciones (frente, derecha o izquierda)
                 */
                System.out.print("Introduce la posición de avance\nSólo puedes avanzar hacia ");
                if (columna == 0) {
                    System.out.print("frente o derecha\n");

                } else if (columna == matriz.length - 1) {
                    System.out.print("izquierda o frente\n");
                } else {
                    System.out.print("izquierda, derecha o frente\n");
                }

                /* 5.4.2 Leemos los valores de teclado. Para simplificar errores, 
                   hacemos que la entrada NO sea case sensitive 
                 */
                posicionAvanze = teclado.nextLine().toLowerCase();
                /* 5.4.3 El bucle sólo debe salir si la opción elegida es correcta 
                   en función de la posición
                 */
            } while ((columna == 0 && posicionAvanze.compareToIgnoreCase("izquierda") == 0) || (columna == matriz.length - 1 && posicionAvanze.compareToIgnoreCase("derecha") == 0));

            matriz[fila][columna] = 2;
            /* 5.5 Según la elección de desplazamiento, nos posicionamos en 
               casilla correspondiente */
            switch (posicionAvanze) {
                /*  5.5.1 Si se ha elegido la dirección izquierda, las fila del 
                   mapa se avanza, pero la columna se decrementa en una unidad para
                   desplazarnos hacia nuestra izquierda. 
                   Se debe comprobar si en dicha casilla hay un cero. 
                     -Si hay un cero en la próxima casilla a visitar, debemos poner
                      la bolsa a 0, y asignar en esa casilla un 1, para después 
                      mostrar una "B" en lugar de un 0.
                    - Si no hay un cero en la próxima casilla a visitar, debemos 
                      sumar a nuestra bolsa de premios el valor de dicha casilla, 
                      y asignar en esa casilla un 3, para después mostrar una "A".
                      También debemos ajustar la nueva posición de fila y columna.
                      Actualizamos el valor de la casilla actual a 2, para 
                      después imprimir una "I.
                 */
                case "izquierda":
                    fila++;
                    columna--;
                    if (matriz[fila][columna] == 0) {
                        bolsaPremios = 0;
                        matriz[fila][columna] = 1;
                    } else {
                        bolsaPremios += matriz[fila][columna];
                        matriz[fila][columna] = 3;
                    }

                    break;
                /* 5.5.2 Si se ha elegido la dirección derecha, las fila del mapa se avanza,
                   pero la columna se incrementa en una unidad para desplazarnos hacia 
                   nuestra derecha. 
                   Se debe comprobar si en dicha casilla hay un cero. 
                     -Si hay un cero en la próxima casilla a visitar, debemos poner
                      la bolsa a 0, y asignar en esa casilla un 1, para después 
                      mostrar una "B" en lugar de un 0.
                    - Si no hay un cero en la próxima casilla a visitar, debemos 
                      sumar a nuestra bolsa de premios el valor de dicha casilla, 
                      y asignar en esa casilla un 3, para después mostrar una "A".
                      También debemos ajustar la nueva posición de fila y columna.
                      Actualizamos el valor de la casilla actual a 2, para 
                      después imprimir una "I.
                 */
                case "derecha":
                    fila++;
                    columna++;
                    if (matriz[fila][columna] == 0) {
                        bolsaPremios = 0;
                        matriz[fila][columna] = 1;
                    } else {
                        bolsaPremios += matriz[fila][columna];
                        matriz[fila][columna] = 3;
                    }
                    break;
                /*  5.5.3 En cualquier otro caso se avanza de frente, con lo que la
                    fila se incrementa en una unidad, pero la columna se mantiene igual. 
                    Se debe comprobar si en dicha casilla hay un cero. 
                     -Si hay un cero en la próxima casilla a visitar, debemos poner
                      la bolsa a 0, y asignar en esa casilla un 1, para después 
                      mostrar una "B" en lugar de un 0.
                    - Si no hay un cero en la próxima casilla a visitar, debemos 
                      sumar a nuestra bolsa de premios el valor de dicha casilla, 
                      y asignar en esa casilla un 3, para después mostrar una "A".
                      También debemos ajustar la nueva posición de fila y columna.
                      Actualizamos el valor de la casilla actual a 2, para 
                      después imprimir una "I.
                 */

                case "frente":

                default:
                    /* 5.5.4 Incrementamos la fila"*/
                    fila++;
                    if (matriz[fila][columna] == 0) {
                        bolsaPremios = 0;
                        matriz[fila][columna] = 1;
                    } else {
                        bolsaPremios += matriz[fila][columna];
                        matriz[fila][columna] = 3;
                    }
                    break;
            }
            /*
                Se comprueba si la nueva posición obtenida permite seguir jugado o no,
                así como si hemos llegado a la fila final del trayecto.
                Si permite seguir se repetirá el bucle. Sino, saldremos del bucle.
             */
        } while ((fila < matriz.length - 1) && (bolsaPremios != 0));

        /* 6. Si se ha llegado a la fila final sin problemas, habremos ganado, 
          en caso contrario se habrá perdido     
         */
 /* 6.1 Imprimir mensaje correspondiente de haber perdido */
        //calculamos el incremento de la última fila
        if (bolsaPremios == 0) {
            mensajeFinal += "Has perdido :(" + "\nMapa al final de la partida";
            /* 6.2 Imprimir mensaje correspondiente de haber ganado */

        } else {
            mensajeFinal += "Has Ganado " + bolsaPremios + "€ :)\nMapa al final de la partida";

        }
        System.out.println(mensajeFinal);
        /* 7. Mostrar el mapa FINAL de la PARTIDA */

        mostrar(fila, matriz);
    }


    /* 7. BIS. Para mostrar el mapa se puede realizar un método estático para ver 
       el mapa de situación. Para mostrar el mapa vamos generando por filas cada  
       uno de los valores de las columnas. A este método estático se le debería pasar
       el número actual de fila, y el array bidimensional, devolviendo un String
            
     */
    public static void mostrar(int y, int[][] m) {

        for (int i = 0; i < m.length; i++) {
            for (int j = 0; j < m[i].length; j++) {
                if (i <= y) {
                    switch (m[i][j]) {
                        case 0:
                            System.out.print("C  ");
                            break;
                        case 1:
                            System.out.print("B  ");
                            break;
                        case 2:
                            System.out.print("I  ");
                            break;
                        case 3:
                            System.out.print("A  ");
                            break;
                        default:
                            System.out.print(m[i][j]);
                            break;
                    }

                } else {
                    System.out.print("X  ");

                }

                System.out.print(" ");
            }
            System.out.println("");
        }
    }
}
