package febrero.ejercicio1;

import java.util.Scanner;

/**
 * Clase Bolsa.
 *
 * @author
 */
public class Bolsa {

    public static void numAleatorio(String[] args) {

    }

    // Atributos de clase
    // Atributos de objeto
    public static void main(String args[]) throws IllegalArgumentException {
        int VALOR_MIN = 65;
        int VALOR_MAX = 90;

        int ValorArray = 0;
        Scanner teclado = new Scanner(System.in);

        int[] ValorArrayAguadar = new int[VALOR_MAX];
        try {
            System.out.println("Intentando crear objeto Bolsa con elemento inicial ");
            ValorArray = teclado.nextInt();

            //      System.out.println("Intentando crear objeto Bolsa con elemento inicial ");
            if (ValorArray >= VALOR_MIN && ValorArray <= VALOR_MAX) {

            } else {
                throw new IllegalArgumentException("Elemento inicial no válido:" + ValorArray);
                //System.err.println("Elemento inicial no válido:" + ValorArray);
            }
        } catch (IllegalArgumentException e) {
            System.err.println("Elemento inicial no válido:" + ValorArray);
        }

    }

}
