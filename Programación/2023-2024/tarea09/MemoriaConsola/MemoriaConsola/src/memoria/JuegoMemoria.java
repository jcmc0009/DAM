package memoria;

import java.util.*;

/**
 * Juego de Memoria. Implementa la lógica del juego "Buscar parejas"
 */
public class JuegoMemoria {

    private final int totalParejas = 8;     // cantidad de parejas en un tablero 4x4
    private int parejasDescubiertas = 0;    // parejas descubiertas en la partida
    private int intentos  = 0;              // intentos realizados
    
    // array de cartas (se incluyen más de 8 para que no siempre aparezcan las mismas)
    private final ArrayList<String> cartas = new ArrayList<>(Arrays.asList("A", "B", "C", "D", "E", "F", "G", "H", 
                                                                             "I", "J", "K", "L", "M", "N", "O", "P"));

    // array de cartas (se incluyen más de 8 para que no siempre aparezcan las mismas)
    private ArrayList<String> tablero;

    /**
     * Inicia el juego de memoria, barajando las cartas y configurando el tablero.
     */
    public void iniciarJuego() {
        Collections.shuffle(this.cartas); // se desordena la lista de cartas

        tablero = new ArrayList<>();

        for (int i = 0; i < totalParejas; i++) { // se introducen N parejas
            // cada carta se añade dos veces (una pareja)
            tablero.add(this.cartas.get(i));
            tablero.add(this.cartas.get(i));
        }

        Collections.shuffle(this.tablero); // se barajan las N cartas elegidas
    }

    /**
     * Obtiene la carta en la posición dada del tablero.
     * 
     * @param posicion Índice de la carta en el tablero.
     * @return La carta en la posición dada del tablero.
     */
    public String getCartaPosicion(int posicion) {
        return this.tablero.get(posicion);
    }

    /**
     * Comprueba si dos cartas en las posiciones dadas forman una pareja.
     * 
     * @param pos1 Índice de la primera carta.
     * @param pos2 Índice de la segunda carta.
     * @return true si las cartas forman una pareja, false de lo contrario.
     */
    public boolean compruebaJugada(int pos1, int pos2) {
        boolean parejaEncontrada = false;
        
        if (this.getCartaPosicion(pos1).equals(this.getCartaPosicion(pos2))) {
            this.tablero.set(pos1, "-"); // pareja encontrada en pos1 (se coloca - en la casilla)
            this.tablero.set(pos2, "-"); // pareja encontrada en pos2 (se coloca - en la casilla)
            this.parejasDescubiertas++;
            parejaEncontrada = true;
        }
        intentos++;                 // se incrementa el número de intentos realizados
        
        return parejaEncontrada;
    }

    /**
     * Comprueba si todas las parejas han sido encontradas.
     * 
     * @return true si todas las parejas han sido encontradas, false de lo contrario.
     */
    public boolean compruebaFin() {
        return this.parejasDescubiertas == this.totalParejas;
    }

    /**
     * Obtiene el tamaño del tablero del juego.
     * @return El tamaño del tablero del juego.
     */
    public int getTamanoTablero() {
        return totalParejas*2; 
    }

    /**
     * Obtiene el número de intentos realizados
     * @return Intentos realizados hasta el momento.
     */
    public int getIntentos() {
        return intentos; 
    }

    /**
     * Muestra el tablero de juego con una jugada realizada en la consola.
     * En la versión gráfica este método NO es necesario.
     * @param pos1 Índice de la primera carta seleccionada.
     * @param pos2 Índice de la segunda carta seleccionada.
     */
    public void mostrarJugadaConsola(int pos1, int pos2) {
        System.out.println("\nTablero:");
        for (int i = 0; i < tablero.size(); i++) {
            if (i % 4 == 0 && i != 0) {
                System.out.println();
            }
            if (i == pos1 || i == pos2 || tablero.get(i).equals("-")) {
                System.out.print(tablero.get(i) + " ");
            } else {
                System.out.print("*" + " ");
            }
        }
        System.out.println();
    }

    /**
     * Muestra el tablero de juego en la consola.
     * En la versión gráfica este método NO es necesario.
     */
    public void mostrarTableroConsola() {
        System.out.println("\nTablero:");
        for (int i = 0; i < tablero.size(); i++) {
            if (i % 4 == 0 && i != 0) {
                System.out.println();
            }
            if (tablero.get(i).equals("-")) {
                System.out.print(tablero.get(i) + " ");
            } else {
                System.out.print("* ");
            }
        }
        System.out.println();
    }
}