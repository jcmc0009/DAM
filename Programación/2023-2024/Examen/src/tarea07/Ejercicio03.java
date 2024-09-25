package tarea07;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import static java.util.Spliterators.iterator;
import java.util.TreeMap;

/**
 * Ejercicio 3. Calendario de especies de plantas
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        // Variables auxiliares
        LocalDate hoy = LocalDate.now();
        final int NUMEROMAXIMO = 7;
        int i = 0;
        //Formatter para la fecha
        DateTimeFormatter formatoDdMmAa = DateTimeFormatter.ofPattern("'Fecha 'dd/MM/yyyy");
        //TreeMap donde almacenaremos la información
        TreeMap<LocalDate, String> mapaEspecies = new TreeMap<>();
        // Variables de salida
        String resultado = "";
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("CALENDARIO DE ESPECIES DE PLANTAS");
        System.out.println("---------------------------------");

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        //recorremos el mapa hasta el número máximo de veces, evitamos que se inserten mas datos de lo permitido
        while (mapaEspecies.size() < NUMEROMAXIMO) {

            String especie = Utilidades.especiePlantaAleatoria();
            //con la siguiente condición evitamos tener duplicados, ya que la estructura usada si lo permite
            if (!mapaEspecies.containsValue(especie)) {
                mapaEspecies.put(hoy.plusDays(i), especie);
                i++;
            }

        }
//con el siguiente bucle al recorrerlo , se almacena los restultados a mostrar y se guardan en el formato esperado
        for (Map.Entry<LocalDate, String> entry : mapaEspecies.entrySet()) {

            LocalDate key = entry.getKey();
            String value = entry.getValue();

            resultado += key.format(formatoDdMmAa) + ": " + value + "\n";

        }

        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        System.out.println(resultado);

    }
}
