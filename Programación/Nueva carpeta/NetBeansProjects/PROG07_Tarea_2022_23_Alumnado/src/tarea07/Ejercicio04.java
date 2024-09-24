package tarea07;


import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * Ejercicio 4. Clasificación de mascotas coincidentes
 *
* @author José Carlos Manjón Carrasco
 */
public class Ejercicio04 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes
        final int NUMERO_MASCOTAS = 20;

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("CLASIFICACIÓN DE COINCIDENTES");
        System.out.println("-----------------------------");

        // Rellenamos la lista con mascotas aleatorias hasta que haya NUMERO_MASCOTAS
        LinkedList<Mascota> listaMascotasPrimero = new LinkedList<>(); // Declaración y creación de la lista de tipo Mascota
        LinkedList<Mascota> listaMascotasSegundo = new LinkedList<>();
        HashMap<String, Integer> listaCoincidencias = new HashMap<>();

        while (listaMascotasSegundo.size() < NUMERO_MASCOTAS) {
            listaMascotasPrimero.add(Utilidades.mascotaAleatoria());
            listaMascotasSegundo.add(Utilidades.mascotaAleatoria());

        }
        //----------------------------------------------
        //                 Procesamiento
        //----------------------------------------------
        for (int i = 0; i < NUMERO_MASCOTAS; i++) {

            String key = listaMascotasPrimero.get(i).getNombre();
            String keys = listaMascotasSegundo.get(i).getNombre();
            int value = i;
            if (key.equalsIgnoreCase(keys)) {
                listaCoincidencias.put(key, value);
                
            }
        }

        //----------------------------------------------
        //           Salida de resultados
        //----------------------------------------------
        System.out.println("Contenido inicial lista mascotas1:");
        System.out.println(listaMascotasPrimero);
        System.out.println("Contenido inicial lista mascotas2:");
        System.out.println(listaMascotasSegundo);
        System.out.println("Clasificación de coincidencias:");

        for (Map.Entry<String, Integer> entry : listaCoincidencias.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();

        }
        System.out.println(listaCoincidencias.toString());
    }

}
