package memoria;

import java.util.*;

/**
 * Juego de Memoria. Versión por consola (sin interfaz gráfica)
 * @author: Profesorado
 */

public class Principal {

    /**
     * Método principal que inicia el juego de memoria por consola.
     * Permite a los jugadores encontrar todas las parejas de cartas.
     * @param args Argumentos de la línea de comandos (no se utilizan)
     */    
    public static void main(String[] args) {
        String ROJO =  "\033[1m\033[31m";
        String AZUL = "\033[1m\033[34m";
        String RESET = "\033[0m";
                
        Scanner scanner = new Scanner(System.in);

        JuegoMemoria partida  = new JuegoMemoria();
        
        partida.iniciarJuego();
        
        while (!partida.compruebaFin()) {
            
            partida.mostrarTableroConsola();

            try {
                    System.out.print("Introduce la posición de la primera carta (1-"+ (partida.getTamanoTablero()) +"): ");
                    int primeraPosicion = scanner.nextInt()-1; // para contar desde 1
                    if(!partida.getCartaPosicion(primeraPosicion).equals("-")) {
                        partida.mostrarJugadaConsola(primeraPosicion , primeraPosicion); // para no revelar la segunda posición

                        System.out.print("Introduce la posición de la segunda carta (1-"+ (partida.getTamanoTablero()) +"): ");
                        int segundaPosicion = scanner.nextInt()-1; // para contar desde 1
                        
                        if(primeraPosicion!=segundaPosicion){
                            partida.mostrarJugadaConsola(primeraPosicion , segundaPosicion);

                            if(partida.compruebaJugada(primeraPosicion,segundaPosicion))
                            {
                                System.out.printf("\n%s¡Encontraste una pareja!%s\n ", AZUL, RESET);
                            } else {
                                System.out.printf("\n%sLas cartas no coinciden. Inténtalo de nuevo.%s\n",ROJO,RESET);
                            }
                        } else
                        {
                            System.out.println("Error: Elige dos casillas DISTINTAS");
                        }
                    }
                    else System.out.println("Esa casilla ya ha sido descubierta. Prueba otra");
            }
            catch(InputMismatchException e){
                scanner.nextLine();
                System.out.println("Error: Las posiciones deben ser numéricas");
            }
            catch(IndexOutOfBoundsException e){
                scanner.nextLine();
                System.out.println("Error: Alguna de las posiciones elegidas están fuera del rango permitido");
            }
        }
        System.out.printf("\n\n%s¡Felicidades, has encontrado todas las parejas en un total de %d intentos!%s\n\n", AZUL,partida.getIntentos(), RESET);

        scanner.close();
    }
}