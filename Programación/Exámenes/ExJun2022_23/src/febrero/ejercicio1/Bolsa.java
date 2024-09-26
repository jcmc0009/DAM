package febrero.ejercicio1;

import java.util.Random;

/**
 * Clase Bolsa.
 *
 * @author Juanma Muñoz
 */
public class Bolsa {

    // Atributos de clase
    static int VALOR_MIN = 65;
    static int VALOR_MAX = 90;

    // Atributos de objeto
    int[] numeros;

    public Bolsa(int inicio) {
        if (inicio < VALOR_MIN || inicio > VALOR_MAX) {
            throw new IllegalArgumentException("Elemento inicial no válido: " + inicio);
        } else {
            numeros = new int[numAleatorio(5, 8)];
            numeros[0] = inicio;
            for (int i = 1; i < numeros.length; i++) {
                numeros[i] = Math.min(VALOR_MAX, numeros[i - 1] + 1);

            }
        }
    }

    public Bolsa() {
        this(VALOR_MIN);
    }

    static int numAleatorio(int min, int max) {
        Random r = new Random();
        if (min > max) {
            int temp = min;
            min = max;
            max = temp;
        }
        return r.nextInt((max - min) + 1) + min;

    }

    public int getElemento(int posicion) {
        if (posicion < 0 || posicion >= numeros.length) {
            throw new IllegalArgumentException("Posición no válida: " + posicion);
        }

        return numeros[posicion];
    }

    public char getElementoChar(int posicion) {
        return (char) getElemento(posicion);
    }

    public int getNumElementos() {
        return numeros.length;
    }

    @Override
    public String toString() {
        StringBuilder contenidoArray = new StringBuilder("[");
        for (int numero : numeros) {
            contenidoArray.append(numero).append(", ");
        }
        contenidoArray.setLength(contenidoArray.length() - 2); // Eliminar la coma y el espacio extra al final
        contenidoArray.append("]");
        return contenidoArray.toString();
    }

    public static void main(String args[]) {

        System.out.println("CLASE BOLSA");
        System.out.println("-----------");

        try {
            System.out.println("Intentando crear objeto Bolsa con elemento inicial 64...");
            Bolsa bolsaInvalida1 = new Bolsa(64);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            System.out.println("Intentando crear objeto Bolsa con elemento inicial 91...");
            Bolsa bolsaInvalida2 = new Bolsa(91);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
        System.out.println("");
        System.out.println("Creando Bolsa con número de elementos por omisión...");
        Bolsa bolsaCorrecta = new Bolsa(88);
        System.out.println("Bolsa creada.");
        System.out.println("La bolsa completa es:");
        System.out.println(bolsaCorrecta);
        System.out.println("");
        System.out.println("Contenido de la bolsa elemento a elemento:");
        for (int i = 0; i < bolsaCorrecta.getNumElementos(); i++) {
            System.out.println("Elemento " + i + ": " + bolsaCorrecta.getElemento(i));
        }
        System.out.println("");
        System.out.println("Contenido de la bolsa elemento a elemento con conversión a char:");
        for (int i = 0; i < bolsaCorrecta.getNumElementos(); i++) {
            System.out.println("Elemento " + i + ": " + bolsaCorrecta.getElementoChar(i));
        }
    }

}
