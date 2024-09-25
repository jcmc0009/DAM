package examenFeb2324;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 * Ejercicio 1. Pluviómetro
 *
 * @author Nombre y apellidos del alumno/a
 */
public class Ejercicio01 {

    public static void main(String args[]) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        int hora = 0, minuto = 0;
        String entrada, resultado = "Las lluvias totales por hora son: \n";
        boolean entradaValida = false;
        StringTokenizer entradasToken;
        float lluviaCaida = 0, lluviaAcumulada = 0;
        //----------------------------------------------
        //               Entrada de datos 
        //                       +
        //                 Procesamiento 
        //----------------------------------------------
        Scanner tecladoHoraMinutos = new Scanner(System.in);
        Scanner lluviasCaidas = new Scanner(System.in);
        LocalTime horaMinuto = LocalTime.now();
        Scanner tecladoHora = new Scanner(System.in);
        //   DateTimeFormatter formatoDdMmAaHmS = DateTimeFormatter.ofPattern(" HH-mm\n");
        do {
            System.out.println("Introduce las horas y minutos en los que se ha realizado la lectura con formato hh-mm (Enter para terminar)");
            entrada = tecladoHoraMinutos.nextLine();
            entradasToken = new StringTokenizer(entrada, "-");
            if (entrada.contains("-")) {

                StringTokenizer horas = new StringTokenizer(entrada, "-");
                try {
                    horaMinuto = LocalTime.of(Integer.parseInt(horas.nextToken()), Integer.parseInt(horas.nextToken()));
                    entradaValida = true;
                    System.out.println("Introduce la lluvia caída para las " + horaMinuto);
                    lluviaCaida = lluviasCaidas.nextFloat();
                    lluviaAcumulada += lluviaCaida;
                } catch (java.time.DateTimeException e) {
                    System.out.print("Error en el formato de horas-minutos , la hora debe estar  entre las 0 y 23 h y los minutos entre 0 y 59\n");
                } catch (java.lang.NumberFormatException s) {
                    System.out.print("Error en el formato de entrada, el formato debe ser hh-mm\n");
                } catch (java.util.InputMismatchException d) {
                    System.out.print("Error en el formato de entrada de datos\n");
                }

            }
            resultado += horaMinuto + " cantidad " + lluviaCaida + " litros" + "\n Total: " + lluviaAcumulada + "litros";

        } while (!entrada.isEmpty());
        //System.out.println(entrada);

        //----------------------------------------------
        //          Salida de resultados 
        //----------------------------------------------
        // Se presentan los resultados
        System.out.print(resultado);
    }
}
