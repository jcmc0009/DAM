package tarea03;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.DayOfWeek;
import java.time.LocalTime;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.InputMismatchException;

/**
 * Ejercicio 3: Vamos al cine.<br>
 * En este ejercicio trabajaremos con objetos de tipo fecha y de tipo hora a
 * través de las clases LocalDate y LocalTime respectivamente.
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio3 {

    public static void main(String[] args) {

        System.out.println("\nEjercicio 3. ¡Vamos al cine!");
        System.out.println("----------------------------");

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        String fechaEntradas;
        int hora = 0, minuto = 0, extraSesionDemandada = 0;
        boolean fechaValida, comparacion, horaValida, minutoValido;
        final double precioCine = 4.5;
        double espectador = 0, precioEntrada;

        fechaValida = false;
        horaValida = false;
        minutoValido = false;
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fechaMinima = LocalDate.now().plusDays(7);
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------

        System.out.println("Introduce la fecha para la que quieres comprar la entrada");
        System.out.println("---------------------------------------------------------");

        Scanner teclado = new Scanner(System.in);
        Scanner tecladoHora = new Scanner(System.in);
        Scanner tecladoMinuto = new Scanner(System.in);
        // 1.- Lectura por teclado de la fecha para la que se quiere reservar (mínimo con una semana de antelación)
        /* Se deberán cumplir los requisitos del enunciado y determinará si es uno de los Días del Espectador */
        do {
            try {
                System.out.print("Introduce una fecha (ej. 06/04/2023): ");
                fechaEntradas = teclado.nextLine();
                LocalDate fechaEntradasFormateada = LocalDate.parse(fechaEntradas, formateador); // esta linea permite 

                /* en el siguiente if, calculamos si es lunes o jueves, en caso afirmativo aplicaremos un descuento del 50% en el precio , es decir,  
                 multiplicaremos por 0.5 o 1, en caso de ser otro día, en la fórmula para calcular el precio de la entrada*/
                if (fechaEntradasFormateada.getDayOfWeek() == DayOfWeek.MONDAY) {
                    espectador = 0.5;
                } else if (fechaEntradasFormateada.getDayOfWeek() == DayOfWeek.THURSDAY) {
                    espectador = 0.5;
                } else {
                    espectador = 1.0;
                }
                comparacion = fechaEntradasFormateada.isAfter(fechaMinima);

                /* validamos la fecha mínima a partir de la cual se puedeon comprar entradas, en caso deser esa comparación cierta,
                 de la fecha introducida con aquella una semana posterior, en el primer if se crea un booleano que hace salir del bucle */
                if (comparacion == true) {
                    fechaValida = true;
                } else {
                    System.err.println("¡Error! Fecha inválida, no se permiten reservas con menos de una semana de antelación");
                }
                // capturamos las excepciones de las fechas 
            } catch (DateTimeParseException exception) {
                System.err.println("¡ERROR! La fecha introducida NO es válida (utiliza el formato sugerido)");
            } catch (Exception generalException) {
                System.err.println("¡ERROR! La fecha introducida NO es válida (utiliza el formato sugerido)");
            }

        } while (!fechaValida);
        System.out.println("Introduce la hora para la que quieres comprar la entrada");
        System.out.println("--------------------------------------------------------");

        // 2. Lectura por teclado y comprobación de hora y minuto (cumpliendo los requisitos del enunciado)
        /* en los siguientes do-while , pediremos la hora y minutos mediante teclado, controlaremos que tienenen rango válido
        de 0 a 23 para las horas y 0 a 59 para los minutos, controlaremos las excepciones, y una vez con valores válidos
        se almacenarán en una LocalTime*/
        do {
            try {
                System.out.print("- Hora (00-23): ");
                hora = tecladoHora.nextInt();
                if (hora >= 0 && hora <= 23) {
                    horaValida = true;
                    tecladoHora.nextLine();
                } else {
                    System.out.println("¡Error! Hora fuera de rango 0 a 23");
                }
            } catch (InputMismatchException exceptionHora) {
                tecladoHora.nextLine();
                System.err.println(exceptionHora.getMessage() + " exception, introduce valores válidos");

            } catch (Exception exceptionGeneral) {
                tecladoHora.nextLine();
                System.err.println(exceptionGeneral.getMessage() + " exception, introduce valores válidos");

            }
        } while (!horaValida);

        do {
            try {
                System.out.print("- Minuto (00-59): ");
                minuto = tecladoMinuto.nextInt();
                if (minuto >= 0 && minuto <= 59) {
                    minutoValido = true;
                    tecladoMinuto.nextLine();
                } else {
                    System.out.println("¡Error! Hora fuera de rango 0 a 59");
                }
            } catch (InputMismatchException exceptionHora) {
                tecladoMinuto.nextLine();
                System.err.println(exceptionHora.getMessage() + " exception, introduce valores válidos");

            } catch (Exception exceptionGeneral) {
                tecladoHora.nextLine();
                System.err.println(exceptionGeneral.getMessage() + " exception, introduce valores válidos");

            }

        } while (!minutoValido);

        // 3. Creación de los objetos LocalTime de referencia:
        // 3.1. Creación de un objeto LocalTime de referencia para almacenar la hora de la primera sesión de cine (17:00)  
        LocalTime primeraSesion = LocalTime.of(17, 00); // el resto de sesiones se calcularán a partir de esta primera sesión
        // 3.2 Creación de objeto LocalTime con la hora indicada a partir de los datos (hora y minuto) leídos por teclado

        LocalTime horaCine = LocalTime.of(hora, minuto);    // eesta variable de LocalTime, almacena los valores introducidos por pantalla si son válidos

        //----------------------------------------------
        //               Procesamiento 
        //----------------------------------------------
        // 4. Obtener la siguiente sesión (y su precio) a la que el usuario puede entrar según la hora que ha indicado
        //----------------------------------------------
        //            Salida de resultados 
        //----------------------------------------------
        // 5. Mostrar por pantalla los resultados obtenidos según el procesamiento realizado.
        /*A continuación en base a la hora de la primera sesión, que es una variable definida al inicio, se irán comparando
        el valor de la hora y minuto a la que se quieren comprar la entrada, para ver en qué sesión entra, y de ahí en base a si es sesión demandada (+1€) y día del espectador
        calcularemos el precio final de la entrada*/
        if (horaCine.isBefore(primeraSesion)) {
            /*Para saber cuantos minutos faltan para la sesión , usamos ChronoUnit.Minutes  y between para la diferencia entre las dos horas*/

            System.out.println("A la hora indicada,faltarían " + ChronoUnit.MINUTES.between(horaCine, primeraSesion) + " minutos para el inicio de la sesión de las " + primeraSesion);
            extraSesionDemandada = 0;
            precioEntrada = espectador * (precioCine + extraSesionDemandada);
            System.out.println(
                    "El precio de la entrada para esta sesión es de " + precioEntrada + "€");
        } else if (horaCine.isAfter(primeraSesion) && horaCine.isBefore(primeraSesion.plusMinutes(150))) {

            System.out.println("A la hora indicada,faltarían " + ChronoUnit.MINUTES.between(horaCine, primeraSesion.plusMinutes(150)) + " minutos para el inicio de la sesión de las " + primeraSesion.plusMinutes(150));
            extraSesionDemandada = 0;
            precioEntrada = espectador * (precioCine + extraSesionDemandada);
            System.out.println(
                    "El precio de la entrada para esta sesión es de " + precioEntrada + "€");

        } else if (horaCine.isAfter(primeraSesion.plusMinutes(150)) && horaCine.isBefore(primeraSesion.plusMinutes(300))) {

            System.out.println("A la hora indicada,faltarían " + ChronoUnit.MINUTES.between(horaCine, primeraSesion.plusMinutes(300)) + " minutos para el inicio de la sesión de las " + primeraSesion.plusMinutes(300));
            extraSesionDemandada = 1;
            precioEntrada = espectador * (precioCine + extraSesionDemandada);
            System.out.println(
                    "El precio de la entrada para esta sesión es de " + precioEntrada + "€");
        } else if (horaCine.isAfter(primeraSesion.plusMinutes(300))) {
            
            System.out.println("La última sesión de este día comienza  " + ChronoUnit.MINUTES.between( primeraSesion.plusMinutes(300),horaCine) + " minutos antes de la hora indicada " );
            System.out.println("No hay más sesiones después de esta.");
        } else if (horaCine.equals(primeraSesion.plusMinutes(300))) {
            System.out.println("La última sesión de este día comienza  " + ChronoUnit.MINUTES.between( primeraSesion.plusMinutes(300),horaCine) + " minutos antes de la hora indicada " );
            extraSesionDemandada = 1;
            precioEntrada = espectador * (precioCine + extraSesionDemandada);
            System.out.println("El precio de la entrada para esta sesión es de " + precioEntrada + "€");
        }
        if (espectador == 0.5) {
            System.out.println("Nota: se ha aplicado un descuento del 50% por ser Día del espectador");
        }

        System.out.println();

        System.out.println(
                "El programa ha finalizado!!");
        System.out.println();

    }
}
