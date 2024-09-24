package tarea07;

import java.time.LocalDate;

import java.time.format.DateTimeFormatter;

import java.util.HashMap;

/**
 * Ejercicio 3. La mascota del mes
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes
        final int MESES = 12;

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("LA MASCOTA DEL MES");
        System.out.println("-------------------");

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        HashMap<LocalDate, Mascota> listaMascotas = new HashMap<>();
        DateTimeFormatter formateados = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        for (int i = 1; i <= MESES; i++) {

            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/M/yyyy");
            String date = "01/" + i + "/2023";

            //convert String to LocalDate
            LocalDate localDate = LocalDate.parse(date, formato);

            listaMascotas.put(localDate, Utilidades.mascotaAleatoria());

        }

        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        System.out.printf("Contenido final del mapa de mascotas organizado por fechas:\n\n");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/M/yyyy");

        for (int i = 1; i <= MESES; i++) {

            String date = "01/" + i + "/2023";

            //convert String to LocalDate
            LocalDate localDate = LocalDate.parse(date, formatter);

            //LocalDate key = localDate.parse(date, formatter);
            LocalDate key = localDate;
            String value = listaMascotas.get(localDate).toString();
            System.out.println("Fecha " + key.format(formatter) + " " + value);

        }

    }

}
