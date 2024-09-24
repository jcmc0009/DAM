package tarea07;


import java.util.LinkedList;


/**
 * Ejercicio 2. Clasificación de mascotas
 *
* @author José Carlos Manjón Carrasco
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes
        final int NUMERO_MASCOTAS = 10;

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        // No se piden datos al usuario, ya que se usa un número fijo de elementos aleatorios
        System.out.println("CLASIFICACIÓN DE MASCOTAS");
        System.out.println("-------------------------");

        // Rellenamos la lista con mascotas aleatorias hasta que haya NUMERO_MASCOTAS
        LinkedList<Mascota> listaMascotas = new LinkedList<>(); // Declaración y creación de la lista de tipo Mascota
        LinkedList<Mascota> listaPerres = new LinkedList<>();
        LinkedList<Mascota> listaGates = new LinkedList<>();
        LinkedList<Mascota> listaMascotasHembra = new LinkedList<>();
        LinkedList<Mascota> listaMascotasMacho = new LinkedList<>();
        LinkedList<Mascota> listaMascotasSinPerres = new LinkedList<>();
        LinkedList<String> listaMascotasSinPerresNombres = new LinkedList<>();
        LinkedList<String> nombresELiminados = new LinkedList<>();
        LinkedList<Integer> listaMascotasSinPerresPosiciones = new LinkedList<>();
        LinkedList<Mascota> listaMascotasSinPerresSinRepetir = new LinkedList<>();

        //----------------------------------------------
        //               Procesamiento
        //----------------------------------------------
        while (listaMascotas.size() < NUMERO_MASCOTAS) {

            listaMascotas.add(Utilidades.mascotaAleatoria());

        }

        for (Mascota mascota : listaMascotas) {

            if (mascota.getTipo().equalsIgnoreCase("Perro")) {
                listaPerres.add(mascota);

            } else if (mascota.getTipo().equalsIgnoreCase("Perra")) {
                listaPerres.add(mascota);

            }

            if (mascota.getSexo().equalsIgnoreCase("Macho")) {
                listaMascotasMacho.add(mascota);
            } else if (mascota.getSexo().equalsIgnoreCase("Hembra")) {
                listaMascotasHembra.add(mascota);
            }

        }

        for (int j = 0; j < NUMERO_MASCOTAS; j++) {

            if (listaMascotas.get(j).getTipo().equalsIgnoreCase("Gato")) {

                listaGates.add(listaMascotas.get(j));

            } else if (listaMascotas.get(j).getTipo().equalsIgnoreCase("Gata")) {
                listaGates.add(listaMascotas.get(j));

            }

        }
        /* Iterator< Mascota> it = listaMascotas.iterator();
        for (Iterator<Mascota> iterator = listaMascotasSinPerresSinRepetir.iterator(); iterator.hasNext();) {
            Mascota next = iterator.next();
            listaMascotasSinPerresNombres.addAll(listaMascotasSinPerresNombres);
            System.out.println(next.getNombre() + "sddcsds");
        }

        for (int j = 0; j < listaMascotas.size(); j++) {

            if (listaMascotas.get(j).getTipo().equalsIgnoreCase("Perro")) {
                //listaMascotasSinPerres.add(listaMascotas.get(j).getNombre());
                listaMascotas.get(j).getNombre();

            } else if (listaMascotas.get(j).getTipo().equalsIgnoreCase("Perra")) {
                listaMascotas.get(j).getNombre();

            }

        }*/
        String nombre = "";
       /* for (int i = 0; i < listaMascotas.size(); i++) {

            //listaPerres.get(i).getNombre();
            // nombre = listaMascotas.element().getNombre();
            listaMascotasSinPerresNombres.add(listaPerres.get(i).getNombre());

        }*/

        for (int k = 0; k < listaMascotas.size(); k++) {

            if (listaMascotas.get(k).getTipo().equalsIgnoreCase("Perro")) {
                listaMascotasSinPerresPosiciones.add(k);

            } else if (listaMascotas.get(k).getTipo().equalsIgnoreCase("Perra")) {
                listaMascotasSinPerresPosiciones.add(k);
            }

        }
        //----------------------------------------------
        //            Salida de resultados
        //----------------------------------------------
        System.out.println("1. Contenido inicial de la lista de mascotas:");

        System.out.println(listaMascotas);

        //  System.out.println(listaMascotas.retainAll(listaMascotas.element().getTipo());
        //  System.out.println(listaMascotas.remove(i).getTipo()+listaMascotas.remove(i).getNombre());
        /*
        for (int i = 0; i < listaMascotas.size(); i++) {
            //   System.out.println(listaMascotas.remove(i).getTipo());
        }
        try {
            while (it.hasNext()) {
                //System.out.println(listaMascotas.element().getTipo());
                // System.err.println(it.next().getTipo());
                //it.next().getTipo();
//numero.getTipo().equalsIgnoreCase("Perro") && numero.getTipo().equalsIgnoreCase("Perra")

                if (listaMascotas.element().getTipo().equalsIgnoreCase("Perro") && listaMascotas.element().getTipo().equalsIgnoreCase("Perra")) {
                    listaPerres.addLast(numero);
                    it.remove();
                    //if (it.next().getTipo().equals("Gato") && it.next().getTipo().equals("Gata"))
                } else {
                    listaGates.addLast(numero);
                    it.remove();
                }

            }
        } catch (Exception e) {
        }*/
        System.out.println("2. Contenido final de la lista de perr@s:");

        System.out.println(listaPerres);
        System.out.println("3. Contenido final de la lista de gat@s:");
        System.out.println(listaGates);
        System.out.println("4. Contenido final de la lista de mascotas machos:");
        System.out.println(listaMascotasMacho);
        System.out.println("5. Contenido final de la lista de mascotas hembras:");
        System.out.println(listaMascotasHembra);
        System.out.println("6. Contenido final de la lista de nombres de mascotas eliminadas:");
        System.out.println(listaMascotasSinPerresNombres);
        System.out.println("7. Contenido final de la lista de posiciones eliminadas:");
        System.out.println(listaMascotasSinPerresPosiciones);
        System.out.println("8. Contenido final del conjunto de nombres de mascotas eliminadas:");

    }

}
