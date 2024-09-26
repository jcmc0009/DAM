package junio.ejercicio2;

import java.time.LocalDate;
import java.time.Month;
import junio.ejercicio2.Piso;
import junio.ejercicio2.Casa;
import junio.ejercicio2.Inmueble;
import junio.ejercicio2.Alquilable;

/**
 * Programa de pruebas
 *
 * @author Alumno/a
 */
public class PruebaInmuebles {

    public static void main(String[] args) {

        //  Intentos de creación de inmuebles no válidos según las especificaciones del enunciado
        System.out.println("------CREACIÓN DE INMUEBLES CON DATOS NO VÁLIDOS------");

        // Intento de crear un objeto de tipo Casa con número de habitaciones no válido y los siguientes datos
        // Ref. catastral: 1VH222S3, dirección: Avenida La Paz, habitaciones: 0, fecha de construcción: 25/01/2007, plantas: 2, tipo de casa: Individual, piscina: no
        try {
            Casa casa = new Casa("1VH222S3", "Avenida La Paz", 0, LocalDate.of(2007, Month.JANUARY, 25), 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // Intento de crear un objeto de tipo Piso con año no válido y los siguientes datos
        try {
            Casa casa = new Casa("1VH222S3", "Avenida La Paz", 0, LocalDate.of(1890, Month.JANUARY, 25), 2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        // Ref. catastral: 1VH222S3, dirección: Avenida La Paz, habitaciones: 2, fecha de construcción: 31/12/1949, comunidad: 27.50 euros
        // Creación de inmuebles con datos válidos
        System.out.println("-------------CREACIÓN DE INMUEBLES VÁLIDOS------------");

        // Creación de un inmueble de tipo Casa con los siguientes datos
        // Ref. catastral: 1VH222S3, dirección: Avenida La Paz, habitaciones: 4, fecha de construcción: 25/01/2007, plantas: 2, tipo de casa: Individual, piscina: no.
        System.out.println("Creando un inmueble 'casa1' de tipo Casa...");

        Casa casa1 = new Casa("1VH222S3", "Avenida La Paz", 4, LocalDate.of(2007, Month.JANUARY, 25), 2);;
        System.out.println("Inmueble casa creado correctamente");

        // Creación de un inmueble de tipo Casa con los siguientes datos
        // Ref. catastral: 1GY782L3, dirección: Calle Sacramento, habitaciones: 3, fecha de construcción: 02/09/2000
        System.out.println("Creando un inmueble 'casa2' de tipo Casa...");

        Casa casa2 = new Casa("1GY782L3", "Calle Sacramento", 3, LocalDate.of(2000, Month.SEPTEMBER, 02), 2);
        System.out.println("Inmueble casa creado correctamente");

        // Creación de un inmueble de tipo Piso con datos válidos
        // Ref. catastral: 1VJ256Z7, dirección: Avenida Pedro Muñoz Seca, habitaciones: 2, fecha de construcción: 23/10/2002, comunidad: 27.50 euros
        System.out.println("Creando un inmueble 'piso1' de tipo Piso...");

        Piso piso = new Piso("1VJ256Z7", "Avenida Pedro Muñoz Seca", 2, LocalDate.of(2002, Month.OCTOBER, 23), 27.5);
        System.out.println("Inmueble piso creado correctamente");

        //Imprimimos los datos de los tres inmuebles junto con la tarifa de alquiler de cada uno
        System.out.println("-------------INFORMACIÓN DE LOS INMUEBLES------------");
        System.out.println("Datos del inmueble 'casa1' de tipo Casa:");
        System.out.println(casa1.toString());
        System.out.println(casa1.calcularTarifaAlquiler() + " €");
        System.out.println("Datos del inmueble 'casa2' de tipo Casa:");
        System.out.println(casa2.toString());
        System.out.println(casa2.calcularTarifaAlquiler() + " €");
        System.out.println("Datos del inmueble 'piso1' de tipo Piso:");
        System.out.println(piso.toString());
        System.out.println(piso.calcularTarifaAlquiler() + " €");
        //Imprimimos la cantidad de inmuebles creados
        System.out.println("\n------------------INFORMACIÓN GENERAL-----------------");

    }

}
