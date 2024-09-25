package junio.ejercicio2;

/**
 * Clae principal donde se crean objetos y prueban métodos de las clases.
 * 
 * En el ejercicio trata de construir la jerarquía que se muestra en la imagen
 * adjunta. Hay que tener en cuenta que se tienen las clases:
 * - Planta, clase abstracta con dos atributos codigo de tipo entero y denominacion de tipo cadena de caracteres
 * -  PlantaConFrutos, hereda de Planta y presenta un atributo entero que representa el número de frutos.
 * -  PlantaSinFrutos, hereda de Planta y presenta un atributo entero que representa el número de hojas.
 *    Esta clase debe implemetar la interfaz Vida. El método envejecer debe restar una unidad en el número de hojas
 * 
 * @author Profesor
 */
public class PruebaInsectos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println ("EJERCICIO 2: CLASES INSECTO, HORMIGA, MARIPOSA");
        System.out.println ("----------------------------------------------");
        System.out.println ("Creando insectos");
        System.out.println ("----------------");

        // Creación de una hormiga
        Hormiga miHormiga = new Hormiga("AA01", "Atomic", "marrón") ;
        // Mostrar su información
        System.out.printf("Hormiga: %s\n", miHormiga.toString());
        
        // Creación de una mariposa
        Mariposa miMariposa = new Mariposa("3345", "Danaus gilippus", 10.0) ;
        // Mostrar su información
        System.out.printf("Mariposa: %s\n", miMariposa.toString());
        System.out.println();
        

        // Transformamos cinco veces los insectos
        System.out.println ("Transformando insectos");
        System.out.println ("----------------------");
        for (int i=0; i<5 ; i++) {
            // Transformamos hormiga y mariposa
            miHormiga.transformarse();
            miMariposa.transformarse();
            // Mostrar su información
            System.out.println ("Realizando transformación...");
            System.out.printf ("Hormiga: %s\n", miHormiga.toString());
            System.out.printf ("Mariposa: %s\n", miMariposa.toString());
            System.out.println();
        }
    }
    
}
