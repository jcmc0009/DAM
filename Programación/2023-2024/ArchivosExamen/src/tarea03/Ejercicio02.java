package tarea03;

import java.util.Random;
import libtarea3.Dado;

/**
 * Ejercicio 2: Uso de la clase Dado
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        //Constantes
        // Variables de entrada (dados y puntuación máxima)
        // Variables de salida
        String infoSalida = "";
        Random semilla = new Random(System.currentTimeMillis());
        int aleatorio = semilla.nextInt(30, 60);

        infoSalida += "Número máximo de puntos : " + aleatorio + "\n";

        // Variables auxiliares
        // Clase Scanner para petición de datos de entrada (no es necesario)
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        //En realidad no hay entrada de datos como tal, pero podemos considerar
        //el número máximo como información de entrada ya que variará el
        //comportamiento del programa.
        //1. Cálculo del número aleatorio de puntos (entre 30 y 60)
        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------  
        //2. Creación de 3 dados (jugadores) de 6 caras
        Dado jugadorUno = new Dado();
        Dado jugadorDos = new Dado();
        Dado jugadorTres = new Dado();
        infoSalida += "\t\tDado1\tDado2\tDado3\n";
        //3. Lanzamiento de los dados y acumulación de las puntuaciones
        long sumaDadosTotal = 0;
        int contadorTiradaDados = 1, valorDadoUno = 0, valorDadoDos = 0, valorDadoTres = 0, numeroLanzamientos = 0;
        do {

            infoSalida += "Lanzamiento nº " + contadorTiradaDados + ": ";
            //3.1 Lanzamos cada uno de los dados y mostramos las puntuaciones
            valorDadoUno = jugadorUno.lanzar();
            valorDadoDos = jugadorDos.lanzar();
            valorDadoTres = jugadorTres.lanzar();
            //System.out.println(jugadorUno.getNumeroCaras());
            switch (valorDadoUno) {
                case 1:
                    infoSalida += "1\t  ";
                    break;
                case 2:
                    infoSalida += "2\t  ";
                    break;
                case 3:
                    infoSalida += "3\t  ";
                    break;
                case 4:
                    infoSalida += "4\t  ";
                    break;
                case 5:
                    infoSalida += "5\t  ";
                    break;
                case 6:
                    infoSalida += "6\t  ";
                    break;
            }
            switch (valorDadoDos) {
                case 1:
                    infoSalida += "1\t  ";
                    break;
                case 2:
                    infoSalida += "2\t  ";
                    break;
                case 3:
                    infoSalida += "3\t  ";
                    break;
                case 4:
                    infoSalida += "4\t  ";
                    break;
                case 5:
                    infoSalida += "5\t  ";
                    break;
                case 6:
                    infoSalida += "6\t  ";
                    break;
            }
            switch (valorDadoTres) {
                case 1:
                    infoSalida += "1\n";
                    break;
                case 2:
                    infoSalida += "2\n";
                    break;
                case 3:
                    infoSalida += "3\n";
                    break;
                case 4:
                    infoSalida += "4\n";
                    break;
                case 5:
                    infoSalida += "5\n";
                    break;
                case 6:
                    infoSalida += "6\n";
                    break;
            }
            contadorTiradaDados++;

            numeroLanzamientos = (contadorTiradaDados - 1) * 3;
            //
            sumaDadosTotal = jugadorUno.getSumaPuntuacionHistorica() + jugadorDos.getSumaPuntuacionHistorica() + jugadorTres.getSumaPuntuacionHistorica();
        } while (sumaDadosTotal <= aleatorio);
        infoSalida += "\n";
        //Utilizamos los métodos de la clase para contar los lanzamientos
        //3.2 Utilizando los métodos de la clase, acumulamos las puntuaciones
        infoSalida += "Juego Terminado. La suma de los lanzamientos es : " + sumaDadosTotal + "\nEl ganador es el dado ";
        if ((jugadorUno.getSumaPuntuacionHistorica() > jugadorDos.getSumaPuntuacionHistorica()) || (jugadorUno.getSumaPuntuacionHistorica() > jugadorTres.getSumaPuntuacionHistorica())) {
            infoSalida += "1 con " + valorDadoUno + " puntos en la última jugada\nEl valor " + valorDadoUno + " ha salido " + Dado.getNumeroVecesCaraGlobal(valorDadoUno) + " en todo el juego y se ha realizado un total de " + numeroLanzamientos + " lanzamientos\nTodos los lanzamientos del dado 1: " + jugadorUno.getSerieHistoricaLanzamientos() + ".\n";
        } else if ((jugadorDos.getSumaPuntuacionHistorica() > jugadorUno.getSumaPuntuacionHistorica()) || (jugadorDos.getSumaPuntuacionHistorica() > jugadorTres.getSumaPuntuacionHistorica())) {
            infoSalida += "2 con " + valorDadoDos + " puntos en la última jugada\nEl valor " + valorDadoDos + " ha salido " + Dado.getNumeroVecesCaraGlobal(valorDadoDos) + " en todo el juego y se ha realizado un total de " + numeroLanzamientos + " lanzamientos\nTodos los lanzamientos del dado 2: " + jugadorDos.getSerieHistoricaLanzamientos() + ".\n";
        } else {
            infoSalida += "3 con " + valorDadoTres + " puntos en la última jugada\nEl valor " + valorDadoTres + " ha salido " + Dado.getNumeroVecesCaraGlobal(valorDadoTres) + " en todo el juego y se ha realizado un total de " + numeroLanzamientos + " lanzamientos\nTodos los lanzamientos del dado 3: " + jugadorTres.getSerieHistoricaLanzamientos() + ".\n";
        }
        //de todos los dados en todos los lanzamientos.
        //4. Comprobación de cuál de los dados ha sido el ganador y consulta de
        //todas sus tiradas
        //----------------------------------------------
        //      Salida de resultados
        //----------------------------------------------
        {
            System.out.println(
                    "LANZAMIENTO DE DADOS");
        }
        System.out.println(
                "----------------------------------------");
        System.out.printf(infoSalida);
    }
}
