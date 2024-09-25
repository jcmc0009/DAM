package tarea03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

/**
 * Ejercicio 3: Día de cumpleaños
 *
 * @author Jose Carlos Manjon Carrasco
 */
public class Ejercicio03 {

    public static void main(String[] args) {
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes

        // Variables de entrada
        // Variables de salida
        String mensajeSalida = "";
        String texto = "";
        // Variables auxiliares
        boolean añoValido = false, mesValido = false, fechaValida = false;
        int añoIntroducido = 0, mesIntroducido = 0, diaIntroducido = 0, diasMes = 0, añoOrigen = 0;
        // Objeto Scanner para lectura desde tecladoFecha
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        System.out.println("DÍA DE CUMPLEAÑOS");
        System.out.println("-----------------");

        // 1. Entrada de datos: lectura de añoFinBucle de nacimiento
        // 1.1.- Leer y comprobar el añoFinBucle de nacimiento (entre 1900 y añoFinBucle actual)
        Scanner tecladoFecha = new Scanner(System.in);

        do {

            System.out.println("Introduzca año de nacimiento (1900-2023)");

            try {
                añoIntroducido = tecladoFecha.nextInt();
                //corregir,para hacer mas legible y entendible
                //   añoValido = (añoIntroducido >= 1900 && añoIntroducido <= 2023) ? true : false;

            } catch (InputMismatchException e) {
                System.out.println("Error de lectura: año incorrecto.");
                tecladoFecha.nextLine();//limpia el scanner , cuando da una excepción
                añoValido = false;
            }

        } while (añoIntroducido < 1900 || añoIntroducido > 2023);

        // 1.2.- Leer y comprobar el mesIntroducido de nacimiento 
        Scanner tecladoMes = new Scanner(System.in);
        do {
            System.out.println("Introduzca mes de nacimiento (1-12):");
            try {
                mesIntroducido = tecladoMes.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error de lectura: año incorrecto.");
                tecladoMes.nextLine();
            }

        } while (mesIntroducido < 1 || mesIntroducido > 12);
        // 1.3.- Averiguamos cuántos días tiene el mesIntroducido de nacimiento
        Scanner tecladoDia = new Scanner(System.in);
        LocalDate fechaConstruida = null;

        int diasMaximoMes = 0;
        Locale espaniol = new Locale("es", "SP");
        do {
            System.out.println("Introduzca día de nacimiento");

            try {
                diaIntroducido = tecladoDia.nextInt();
                fechaConstruida = LocalDate.of(añoIntroducido, mesIntroducido, diaIntroducido);

            } catch (java.util.InputMismatchException a) {
                tecladoDia.nextLine();
                System.out.println("Error de lectura: día incorrecto.");
                fechaConstruida = LocalDate.of(añoIntroducido, mesIntroducido, diaIntroducido);

            } catch (java.time.DateTimeException f) {
                tecladoDia.nextLine();
                System.out.println("Duración del mes inválida.Introduce día nacimiento");// con esta expeción capturamos cuando una fecha no existe como 33/12/2023
                diaIntroducido = tecladoDia.nextInt();
                fechaConstruida = LocalDate.of(añoIntroducido, mesIntroducido, diaIntroducido);

            } catch (java.lang.NullPointerException e) {
                // con esta expeción capturamos cuando da una expecion por introducir una fecha inválida de año bisiesto como 29/2/2019
                tecladoDia.nextLine();
                System.out.println("14156Duración del mes inválida.Introduce día nacimiento");

                diaIntroducido = tecladoDia.nextInt();
                fechaConstruida = LocalDate.of(añoIntroducido, mesIntroducido, diaIntroducido);
            }
//            tecladoDia.nextLine();
//            System.out.println(fechaConstruida.getMonth().length(true));
            diasMaximoMes = fechaConstruida.getMonth().length(true);
            System.out.println(fechaConstruida.getMonth().length(true));
        } while (diaIntroducido < 1 || diaIntroducido > diasMaximoMes);
        fechaConstruida = LocalDate.of(añoIntroducido, mesIntroducido, diaIntroducido);

        texto += "¿Cuántas veces tu cumpleaños ha caído en " + fechaConstruida.getDayOfWeek().getDisplayName(TextStyle.FULL, espaniol) + "?" + "\n";
        tecladoDia.nextLine();
        añoOrigen = fechaConstruida.getYear() + 1;

        // 1.4.- Leer y comprobar el día de nacimiento 
        //----------------------------------------------
        //    Procesamiento + Salida de resultados  
        //----------------------------------------------
        //2.- Cálculo del día de la semana en que cayó el nacimiento       
        // 3.- Recorremos desde el añoFinBucle posterior al añoFinBucle de nacimiento hasta el añoFinBucle actual (bucle)
        LocalDate añoHoy = LocalDate.now();
        LocalDate fechaCoincidencia = LocalDate.now();
        int añoFinBucle = añoHoy.getYear();
        int fechasCoincidencia = 0;
        DateTimeFormatter formatoDdMmAa = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        for (int i = añoOrigen; i <= añoFinBucle; i++) {
            //  System.out.println("años" + i);
            try {
                fechaCoincidencia = LocalDate.of(i, mesIntroducido, diaIntroducido);
                if (fechaCoincidencia.getDayOfWeek().equals(fechaConstruida.getDayOfWeek())) {
                    fechasCoincidencia++;
                    texto += fechasCoincidencia + ". " + fechaCoincidencia.format(formatoDdMmAa) + "\n";

                }
            } catch (java.time.DateTimeException e) {
                //con este catch evitamos falle el bucle for por no ser el año siguiente bisiesto
            }
        }

        // 4.- Mostramos por pantalla el número de coincidencias
        System.out.println(texto + "Número total de coincidencias: " + fechasCoincidencia);
    }
}
