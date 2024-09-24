package tarea07;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Ejercicio 5. Ordenación de mascotas
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio05 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        final int NUMERO_MASCOTAS = 5;
        ArrayList<Mascota> listaMascotas = new ArrayList<>();
        LinkedList<Mascota> listaMascotasSegundo = new LinkedList<>();

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        Mascota newMascotaCero = new Mascota();
        Mascota newMascotaPrimero = new Mascota();
        Mascota newMascotaSegundo = new Mascota();
        Mascota newMascotaTercero = new Mascota();
        newMascotaCero.setNombre("Happy End");
        newMascotaCero.setEdad(14);
        newMascotaCero.setRaza("Europeo");
        newMascotaCero.setSexo("Hembra");
        newMascotaCero.setTipo("Gata");
        listaMascotas.add(newMascotaCero);

        newMascotaPrimero.setNombre("Nube");
        newMascotaPrimero.setEdad(8);
        newMascotaPrimero.setRaza("Samoyedo");
        newMascotaPrimero.setSexo("Macho");
        newMascotaPrimero.setTipo("Perro");
        listaMascotas.add(newMascotaPrimero);
        newMascotaSegundo.setNombre("Tana");
        newMascotaSegundo.setEdad(7);
        newMascotaSegundo.setRaza("Azul ruso");
        newMascotaSegundo.setSexo("Hembra");
        newMascotaSegundo.setTipo("Gata");
        listaMascotas.add(newMascotaSegundo);
        newMascotaTercero.setNombre("Khal");
        newMascotaTercero.setEdad(6);
        newMascotaTercero.setRaza("Akita Inu");
        newMascotaTercero.setSexo("Macho");
        newMascotaTercero.setTipo("Perro");

        listaMascotas.add(newMascotaTercero); // No se piden datos al usuario, ya que vamos a introducir unos datos concretos
        // Mostramos el contenido inicial de la lista
        for (int i = 0; i < listaMascotas.size(); i++) {
            System.out.println(i + "." + listaMascotas);

        }
        //----------------------------------------------
        //     Procesamiento + Salida de resultados
        //----------------------------------------------
        // Ordenación de la lista por nombre de la mascota (alfabético) y la mostramos por pantalla
        // Ordenación de la lista por edades y la mostramos por pantalla
        // Ordenación de la lista por número de características de las mascotas y la mostramos por pantalla
    }

}
