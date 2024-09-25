package tarea03;

import static java.lang.System.err;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Ejercicio 1: Creación y uso de cartones de bingo. <br>
 * En este ejercicio probamos el funcionamiento de la clase CartonBingo tratando
 * de conocer los métodos que tiene y el funcionamiento de cada uno de ellos
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio1 {

    public static void main(String[] args) {

        // 1. Presentación del ejercicio
        System.out.println("Ejercicio 1. Creación y uso de cartones de bingo");
        System.out.println("------------------------------------------------");
        /* 
            Debes mostrar la fecha ACTUAL (hoy) usando la API de LocalDate
            (usa también DateTimeFormatter para formatear la fechala correctamente (ej. 08/11/2022)
         */

        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate hoy = LocalDate.now();

        System.out.println("Fecha actual de ejecución: " + hoy.format(formateador));// .format(formateador) sirve para aplicar el formato,previamente definido, a la fecha
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // 2.- Declaración de tres variables referencia a objetos instancia de la clase CartonBingo
        CartonBingo carton1, carton2, carton3;
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        /* 
            En este ejercicio no habrá entrada de datos como tal ya que los datos que se piden en el enunciado son fijos, 
            y son introducidos por el/la programador/a (no hay que pedir datos por teclado al usuario de la aplicación).
         */

        // 3.- Instanciación de objetos de la clase CartonBingo
        // 3.1.- Comprobación del lanzamiento de excepciones (se intentan crear cartones no válidos)
        // 3.1.1.- Intento de creación de un cartón de bingo con fecha de sorteo de la semana pasada (hay gestionar la posible excepción)
        /* Aplicamos a la LocalDate .minusDays(7) , para restarle 7 días, una semana a la fecha de ejecución
        Usamos la función try catch para gestionar los errores , que nos dará el intentar crear un cartón para una fecha pasada*/
        LocalDate fechaPasada = hoy.minusDays(7);

        try {
            CartonBingo cartonException = new CartonBingo(fechaPasada);
        } catch (IllegalStateException exception) {
            System.out.println("Intentando crear un cartón para el sorteo celebrado la semana pasada");
            System.err.println(exception.getMessage()); // se captura las excepciones así
        } catch (Exception generalException) {
            System.err.println(generalException.getMessage());
        }

        // 3.1.2.- Intento de creación de un cartón de bingo con una cantidad de números no válida (30 números)
        /* Usamos la función try catch para gestionar el intento de crear un carton de bingo para más números de los permitidos*/
        try {
            CartonBingo cartonNumeroPasado = new CartonBingo(30, (String) "JC", hoy);
        } catch (IllegalStateException exception) {
            System.out.println("Intentando crear un cartón para con 30 números(debe tener un mímino de 15 y un máximo de 21)");
            System.err.println(exception.getMessage()); // se captura las excepciones así
        } catch (Exception generalException) {
            System.err.println(generalException.getMessage());
        }

        // 3.2 Creación de cartones válidos
        System.out.println("Creamos ahora cartones válidos para nuestros jugadores...\n");
        // 3.2.1.- Creación de un cartón válido para María siguiendo las especificaciones del enunciado
        LocalDate fechaSorteo1 = LocalDate.of(2023, 11, 22);
        //Usamos LocalDate anterior en la instanciación de cartonMaria para crear un carton a una fecha dada
        CartonBingo cartonMaria = new CartonBingo(18, (String) "María", fechaSorteo1);

        // 3.2.2.- Creación de un cartón válido para Ada siguiendo las especificaciones del enunciado
        System.out.println("Creando un cartón para Ada ,sin indicar nada más");
        CartonBingo cartonAda = new CartonBingo((String) "Ada");

        // 3.2.3.- Creación de un cartón válido para Juan siguiendo las especificaciones del enunciado
        System.out.println("Creando un cartón para Juan, utilizando los valores por defecto:");
        CartonBingo cartonJuan = new CartonBingo();
        cartonJuan.setPropietario("Juan");
        //----------------------------------------------
        //       Procesamiento + Salida de Resultados
        //----------------------------------------------
        /* 
            Dado que se va a ir mostrando información de salida a la vez que se van realizando operaciones, podemos considerar en este caso
            que el procesamiento y la salida de resultado van unidos y "mezclados" 
         */
        // 4.- Obtención de información de los cartones creados
        
        //Usaremos las instancias de CartonBingo, y las de cartonMaria, cartonAda y cartonJuan para realizar algunas operaciones
        System.out.println("Obtención de información de los cartones creados ");
        System.out.println("------------------------------------------------ \n");
        //4.1  Total de cartones que se han creado hasta el momento
        System.out.println("Total de cartones creados: " + CartonBingo.CANTIDAD_TOTAL_CARTONES + " cartones");

        //4.2 Identificador del cartón de María
        System.out.println("Identificador del cartón de María: " + cartonMaria.getIdCarton());

        //4.3 Cantidad de números que tiene el cartón de Ada 
        System.out.println("Identificador del cartón de María: " + cartonAda.getCantidadNumerosPendientes());

        //4.4 Fecha de sorteo del cartón de Juan
        System.out.println("La fecha de sorteo del cartón de Juan " + "(" + cartonJuan.getFechaSorteo() + ")" + " y del cartón de María " + "(" + cartonMaria.getFechaSorteo() + ")");
        //4.5 Lista de números del cartón de Ada
        System.out.println("La lista de númeos del cartón de Ada es : " + cartonAda.listadoNumerosPendientes());
        //4.6 Número de días que faltan para el sorteo en el que participará el cartón de María

        System.out.println("Cantidad de días hasta el sorteo en el que participa María : " + cartonMaria.diasHastaSorteo());
        //4.7 Total de cartones que participan en el sorteo de hoy

        System.out.println("Cartones que participan en el sorteo de hoy : " + CartonBingo.totalCartonesSorteo(hoy));
        System.out.println();
        // 5.- Realización de algunas operaciones con los cartones creados
        System.out.println("Realización de algunas operaciones con los cartones creados");
        System.out.println("-------------------------------------------------------- \n");

        // 5.1.- Marcar los números del 20 al 35 en los tres cartones
        System.out.println("Marcamos los números desde el 20 hasta el número 35 ambos incluidos en los tres cartones... ");
        System.out.println("de los números anteriores, mostramos la lista de númeos que sí se ha podido marcar en cada uno de los tres cartones...");
        // 5.2.- Mostrar los números que han podido marcar correctamente en cada uno de los cartones

        for (int i = 20; i <= 35; i++) {

            int numero = i;

            cartonAda.marcarNumero(numero);
            cartonMaria.marcarNumero(numero);
            cartonJuan.marcarNumero(numero);

        }

        System.out.println("- En el carton de Ada estaban los números : " + cartonAda.listadoNumerosMarcados());
        System.out.println("- En el carton de María estaban los números : " + cartonMaria.listadoNumerosMarcados());
        System.out.println("- En el carton de Juan estaban los números : " + cartonJuan.listadoNumerosMarcados() + "\n");

        // 5.3.- Indica de los tres cartones, a cuál de ellos le quedan menos números
        if (cartonAda.getCantidadNumerosPendientes() < cartonMaria.getCantidadNumerosPendientes() && cartonAda.getCantidadNumerosPendientes() < cartonJuan.getCantidadNumerosPendientes()) {
            System.out.println("El jugador que le quedan menos números pendientes de marcar en su carton es...Ada que le quedan " + cartonAda.getCantidadNumerosPendientes() + " números por marcar");
        } else if (cartonMaria.getCantidadNumerosPendientes() < cartonAda.getCantidadNumerosPendientes() && cartonMaria.getCantidadNumerosPendientes() < cartonJuan.getCantidadNumerosPendientes()) {
            System.out.println("El jugador que le quedan menos números pendientes de marcar en su carton es...Maria que le quedan " + cartonMaria.getCantidadNumerosPendientes() + " números por marcar");
        } else {
            System.out.println("El jugador que le quedan menos números pendientes de marcar en su carton es...Juan que le quedan " + cartonJuan.getCantidadNumerosPendientes() + " números por marcar");
        }
        System.out.println("Estado final de todos los cartones");
        System.out.println("----------------------------------");
        // 6.- Muestra el estado final de los cartones

        System.out.println(cartonAda);
        System.out.println(cartonMaria);
        System.out.println(cartonJuan);
        System.out.println("\n");
        System.out.println("El programa ha finalizado!!");
        System.out.println();
    }
}
