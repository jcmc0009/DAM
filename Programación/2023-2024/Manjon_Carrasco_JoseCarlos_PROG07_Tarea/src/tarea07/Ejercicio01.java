package tarea07;

import java.util.HashSet;
import java.util.Set;

/**
 * Ejercicio 1. Creando jardín botánico
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int CANTIDAD_ESPECIES_PLANTAS = 4;
        // Variables de entrada
        // Variables auxiliares
        // Variables de salida
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // No hay, pues se usa un número fijo de elementos aleatorios
        System.out.println("CONJUNTOS DE ESPECIES DE PLANTAS");
        System.out.println("--------------------------------");

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        // Rellenamos los conjuntos con especies de plantas aleatorias hasta que haya CANTIDAD_ESPECIES_PLANTAS
        Set<String> conjuntoUno = new HashSet<>();
        Set<String> conjuntoDos = new HashSet<>();
        Set<String> conjuntoTres = new HashSet<>();
        Set<String> conjuntoCuatro = new HashSet<>();
        Set<String> conjuntoCinco = new HashSet<>();
        do {

            conjuntoUno.add(Utilidades.especiePlantaAleatoria());
            conjuntoDos.add(Utilidades.especiePlantaAleatoria());

        } while (conjuntoUno.size() <= CANTIDAD_ESPECIES_PLANTAS && conjuntoDos.size() <= CANTIDAD_ESPECIES_PLANTAS);

        // Unión de los dos conjuntos
        conjuntoTres.addAll(conjuntoUno);
        conjuntoTres.addAll(conjuntoDos);

        // Intersección de los conjuntos
        conjuntoCuatro.addAll(conjuntoTres);

        conjuntoCuatro.retainAll(conjuntoDos);
        conjuntoCuatro.retainAll(conjuntoUno);

        // Diferencia de los conjuntos
        conjuntoCinco.addAll(conjuntoTres);
        conjuntoCinco.removeAll(conjuntoUno);

        //----------------------------------------------
        //              Salida de Resultados 
        //----------------------------------------------
        // Recorremos el conjunto y mostramos su contenido por pantalla
        System.out.printf("\nConjunto C1: " + conjuntoUno.toString() + "\nConjunto C2:" + conjuntoDos.toString() + "\n");
        System.out.println("Unión C1 y C2 : " + conjuntoTres.toString());
        System.out.println("Interseccion C1 y C2 : " + conjuntoCuatro.toString());
        System.out.println("Diferencia C2 y C1 : " + conjuntoCinco.toString());

    }
}
