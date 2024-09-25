package tarea07;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Comparator;

/**
 * Ejercicio 5. Ordenación de especies de plantas (por nombre y longitud)
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio05 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes
        final int MAXIMONUMEROESPECIES = 5;
        // Variables de entrada

        // Variables auxiliares
        List<String> listaEspecies = new ArrayList<>();
        int num = 1;//variable para hacer una lista numerada
        // Variables de salida

        String resultadoAmostrar = "";
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("ORDENACIÓN DE ESPECIES DE PLANTAS");
        System.out.println("---------------------------------");

        //----------------------------------------------
        //     Procesamiento + Salida de resultados
        //----------------------------------------------
        //rellenamos la lista
        while (listaEspecies.size() < MAXIMONUMEROESPECIES) {

            String especie = Utilidades.especiePlantaAleatoria();

            /*si usando indexOf no lo encuentra en la lista devolverá algo sin sentido ,<0,
            si lo encontrase devuelve un indice que debe ser >0*/
            if (listaEspecies.indexOf(especie) < 0) {
                listaEspecies.add(especie);
            }

        }
        // recorremos la lista mediatne iterador y guardamos formateado
        for (Iterator<String> iterator = listaEspecies.iterator(); iterator.hasNext();) {
            resultadoAmostrar += num + ". " + iterator.next() + "\n";
            num++;

        }

        num = 1;
        /*Collections.sort para ordenar una lista de objetos basándote en ese orden natural
        primer parámetro es qué queremos ordenar y el segundo es como, dicha clase se crea mas abajo*/

        Collections.sort(listaEspecies, new ComparadorEspeciePlantaPorNombre());
        resultadoAmostrar += "\nOrdenación de la lista por nombre (alfabético) \n";
        //mediante iterador recorreremos la lista alamcenando en un string el resultado
        for (Iterator<String> iterator = listaEspecies.iterator(); iterator.hasNext();) {
            resultadoAmostrar += num + ". " + iterator.next() + "\n";
            num++;

        }

        Collections.sort(listaEspecies, new ComparadorEspeciePlantaPorLongitud());

        listaEspecies.sort(new ComparadorEspeciePlantaPorLongitud());

        num = 1;//se reinicia la variable a 1 para mostar orden lógico y reutilizar la variable

        resultadoAmostrar += "\nOrdenación de la lista por longitud\n";
        for (Iterator<String> iterator = listaEspecies.iterator(); iterator.hasNext();) {
            resultadoAmostrar += num + ". " + iterator.next() + "\n";
            num++;

        }

        System.out.println(resultadoAmostrar);
    }

}

class ComparadorEspeciePlantaPorNombre implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.compareToIgnoreCase(o2);
    }

}

class ComparadorEspeciePlantaPorLongitud implements Comparator<String> {

    public int compare(String o1, String o2) {
        int lUno = o1.length();
        int lDos = o2.length();
        return lUno - lDos;
    }

}
