package tarea07;

import java.util.HashSet;
import java.util.Set;

/**
 * Ejercicio 1. Gestionando mascotas
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio01 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes
        final int NUMERO_MASCOTAS = 4;

        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("CONJUNTOS DE MASCOTAS");
        System.out.println("---------------------");

        //----------------------------------------------
        //                  Procesamiento
        //----------------------------------------------
        // Rellenamos los conjuntos con aleatorios hasta que haya NUMERO_MASCOTAS
        Set<Mascota> conjuntoPrimero = new HashSet<Mascota>();
        Set<Mascota> conjuntoSegundo = new HashSet<Mascota>();
        Set<Mascota> union = new HashSet<Mascota>();
        /* for (int i = 0; i < NUMERO_MASCOTAS; i++) {
            conjuntoPrimero.add(Utilidades.mascotaAleatoria());
            conjuntoSegundo.add(Utilidades.mascotaAleatoria());
        }*/

        while (conjuntoPrimero.size() < NUMERO_MASCOTAS) {

            conjuntoPrimero.add(Utilidades.mascotaAleatoria());

        }
        while (conjuntoSegundo.size() < NUMERO_MASCOTAS) {

            conjuntoSegundo.add(Utilidades.mascotaAleatoria());

        }

        /*  System.out.println(conjuntoPrimero);
        System.out.println(conjuntoSegundo);*/
        // Cálculo de la Unión de los dos conjuntos 
        // conjuntoPrimero.addAll(conjuntoSegundo);
        // System.out.println(conjuntoPrimero);
        // Cálculo de la Intersección de los conjuntos
        //conjuntoPrimero.retainAll(conjuntoSegundo);
        // System.out.println(conjuntoPrimero);
        // Cálculo de la Diferencia de los conjuntos
        // conjuntoSegundo.removeAll(conjuntoPrimero);
        // System.out.println(conjuntoPrimero + "no datos");
        //----------------------------------------------
        //              Salida de Resultados 
        //----------------------------------------------
        System.out.println("***Conjunto de Mascotas1");
        System.out.println(conjuntoPrimero);
        System.out.println("Conjunto de Mascotas2");
        System.out.println(conjuntoSegundo);

        System.out.println("Unión de Mascotas1 y Mascotas2");
        // Cálculo de la Unión de los dos conjuntos 
        conjuntoPrimero.addAll(conjuntoSegundo);
        System.out.println(conjuntoPrimero);
        // Cálculo de la Intersección de los conjuntos

        System.out.println("Intersección de Mascotas1 y Mascotas2");
        conjuntoPrimero.removeAll(conjuntoSegundo);
        System.out.println(conjuntoPrimero);
        System.out.println("Diferencia Unión-Mascotas1");
        conjuntoSegundo.addAll(conjuntoPrimero);
        conjuntoSegundo.removeAll(conjuntoPrimero);
        System.out.println(conjuntoSegundo);
    }

}
