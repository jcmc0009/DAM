package tarea07;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Ejercicio 2. Búsqueda de especies de plantas populares
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        final int CANTIDAD_ESPECIES_PLANTAS = 10;
        // Variables de entrada

        // Variables auxiliares
        int posicion = 0; // Para llevar el control de la posición en la que coinciden las dos listas el String
        String textoSalida = "";
        // Variables de salida

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("BÚSQUEDA DE ESPECIES DE PLANTAS POPULARES");
        System.out.println("-----------------------------------------");

        // No hay, pues se usa un número fijo de elementos aleatorios
        // Rellenamos la lista con aleatorios hasta que haya CANTIDAD_ESPECIES_PLANTAS
        //----------------------------------------------
        //               Procesamiento
        //----------------------------------------------
        ArrayList<String> listaUno = new ArrayList<>(); // Declaración y creación del ArrayList de String.
        ArrayList<String> listaDos = new ArrayList<>(); // Declaración y creación del ArrayList de String
        ArrayList<String> listaUnoMarcada = new ArrayList<>(); // Declaración y creación del ArrayList de String.
        ArrayList<String> listaDosMarcada = new ArrayList<>(); // Declaración y creación del ArrayList de String.
        ArrayList<String> listaespeciesPlantasPopulares = new ArrayList<>(); //Declaración y creación del ArrayList de String
        ArrayList<Integer> posicionesPopulares = new ArrayList<>(); // Declaración y creación del LinkedList de enteros.
        Set<String> conjuntoPLantasPopulares = new HashSet<>();
        textoSalida += "1. Contenido inicial de la lista 1:";

// Creamos las listas  
        for (int j = 0; j < CANTIDAD_ESPECIES_PLANTAS; j++) {

            listaUno.add(Utilidades.especiePlantaAleatoria());
            listaDos.add(Utilidades.especiePlantaAleatoria());
        }

        textoSalida += listaUno.toString() + "\n2. Contenido inicial de la lista 2: " + listaDos.toString();

        //Creamos los iteradores para recorrer las listas
        Iterator<String> iteratorListaUno = listaUno.iterator();
        Iterator<String> iteratorListaDos = listaDos.iterator();
        listaUnoMarcada = listaUno;//la listaMarcada es una copia de la lista
        listaDosMarcada = listaDos;//la listaMarcada es una copia de la lista

// Recorremos a la vez las dos listas  
        while (iteratorListaUno.hasNext() && iteratorListaDos.hasNext()) {
            String elementoLista1 = iteratorListaUno.next();
            String elementoLista2 = iteratorListaDos.next();

            if (elementoLista1.equals(elementoLista2)) {

                listaUnoMarcada.set(posicion, "*" + listaUno.get(posicion) + "*");
                listaDosMarcada.set(posicion, "*" + listaDos.get(posicion) + "*");
                listaespeciesPlantasPopulares.add(elementoLista1);
                posicionesPopulares.add(posicion);
                conjuntoPLantasPopulares.add(elementoLista1);

            }
            // Incrementar la posición  tanto si encuentra especie igual o no 
            posicion++;
        }

        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        System.out.println(textoSalida + "\n");
        System.out.println("1. Contenido final de la lista 1 de especies de plantas populares: " + listaUnoMarcada.toString());//listaespeciesPlantasPopulares.toString()
        System.out.println("2. Contenido final de la lista 2 de especies de plantas populares: " + listaDosMarcada.toString());
        System.out.println("3. Contenido final de especies de plantas populares: " + listaespeciesPlantasPopulares.toString());
        System.out.println("4. Contenido final de la lista de posiciones populares: " + posicionesPopulares.toString().toString());
        System.out.println("5. Contenido final del conjunto de especies de plantas populares : " + conjuntoPLantasPopulares.toString());
    }
}
