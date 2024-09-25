package tarea07;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Ejercicio 4. Clasificación de especies de plantas coincidentes (con el mismo
 * nombre y en la misma posición)
 *
 * @author Profesor
 */
public class Ejercicio04 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes
        final int NUMEROMAXIMO = 20;
        // Variables de entrada
        // Variables auxiliares
        int posicionEspecie = 0;
        // Variables de salida
        String coletillaInicial = "Contenido inicial de la lista especies de plantas ";

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("CLASIFICACIÓN DE COINCIDENTES");
        System.out.println("-----------------------------");

        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------
        LinkedList<String> listaUno = new LinkedList<>(); // Declaración y creación del LinkedList de String.
        LinkedList<String> listaDos = new LinkedList<>();
        Map<String, List<Integer>> mapaEspecies = new HashMap<>();

        //rellenamos las listas
        for (int i = 0; i < NUMEROMAXIMO; i++) {
            listaUno.add(Utilidades.especiePlantaAleatoria());
            listaDos.add(Utilidades.especiePlantaAleatoria());
        }

        //Creamos los iteradores para recorrer las listas
        Iterator<String> iteratorListaUno = listaUno.iterator();
        Iterator<String> iteratorListaDos = listaDos.iterator();

        /*recorremos las listas con los iteradores , como queremos hacer
        comparación de dos listas esa condición debeestar en en while*/
        while (iteratorListaUno.hasNext() && iteratorListaDos.hasNext()) {
            String elementoLista1 = iteratorListaUno.next();
            String elementoLista2 = iteratorListaDos.next();
            //en caso  de coincidir la especie en una misma posición se hará algo, en caso contrario no hacemos nada
            if (elementoLista1.equals(elementoLista2)) {
                //en caso que la especie ya esté en el mapa insertaremos la especie en la posición que toque
                if (mapaEspecies.containsKey(elementoLista1) && mapaEspecies.containsKey(elementoLista2)) {
                    mapaEspecies.get(elementoLista1).add(posicionEspecie);

                } else {// si no está en mapa
                    //en caso de no estar en el arrayList lo ,mentemos como key nueva
                    mapaEspecies.put(elementoLista1, new ArrayList<>());
                    // le insertamos la posicion
                    mapaEspecies.get(elementoLista1).add(posicionEspecie);
                }
            }
            // Incrementar la posición   
            posicionEspecie++;
        }
        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        System.out.println(coletillaInicial + " 1: \n" + listaUno);
        System.out.println(coletillaInicial + " 2: \n" + listaDos);
        System.out.println("Clasificación de coincidencias: \n" + mapaEspecies);

    }
}
