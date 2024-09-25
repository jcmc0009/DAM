package examenFeb2324;

/**
 * Ejercicio 2. Operaciones con matrices
 *
 * @author Nombre y apellidos del alumno/a
 */
public class Ejercicio02 {

    public static void main(String[] args) {

        //-------------------------------------------------------------------------
        //                        Declaración de variables 
        //-------------------------------------------------------------------------
        //Variables de entrada
        int[][] matrizA = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        int[][] matrizB = {{0, 6, 2}, {1, 5, 2}, {6, 1, 3}};

        int[][] matrizUnion = {{0, 6, 2}, {1, 5, 2}, {6, 1, 3}};
        String resultado = "", matriz1 = "", matriz2 = "";
        int suma = 0;
        //-------------------------------------------------------------------------
        //                              Procesamiento
        //-------------------------------------------------------------------------
        //System.out.print("Matriz A:\n");
        for (int j = 0; j < matrizA.length; j++) {
            for (int i = 0; i < matrizA.length; i++) {

                matriz1 += "0" + Integer.toString(matrizA[j][i]) + " ";

            }
            matriz1 += "\n";

        }
        System.out.print("\nMatriz B :\n");
        for (int j = 0; j < matrizB.length; j++) {
            for (int i = 0; i < matrizB.length; i++) {

                matriz2 += "0" + Integer.toString(matrizB[j][i]) + " ";
            }
            matriz2 += "\n";
        }
        System.out.print("\nResultado\n");
        for (int j = 0; j < matrizUnion.length; j++) {
            for (int i = 0; i < matrizUnion.length; i++) {

                if (matrizB[j][i] % 2 != 0 && matrizA[j][i] % 2 != 0) {
                    matrizUnion[j][i] = matrizA[j][i] / +matrizB[j][i];
                } else if (matrizB[j][i] % 2 == 0 && matrizA[j][i] % 2 == 0) {
                    matrizUnion[j][i] = matrizB[j][i] + matrizA[j][i];
                } else {
                    matrizUnion[j][i] = matrizA[j][i] - matrizB[j][i];
                }
                suma += matrizUnion[j][i];
                resultado += "0" + Integer.toString(matrizUnion[j][i]) + " ";

            }
            resultado += ("\n");
        }

        //-------------------------------------------------------------------------
        //  Salida de resultados (no modifiques lo siguiente, debe funcionar así)
        //-------------------------------------------------------------------------
        System.out.println("EJERCICIO 2. OPERACIONES CON MATRICES");
        System.out.println("----------------------------------------");

        System.out.println("Matriz A:");
        System.out.println(matriz1);

        System.out.println("Matriz B:");
        System.out.println(matriz2);

        System.out.println("RESULTADO");
        System.out.println("---------------------------------------");
        System.out.println("Matriz Resultado:");
        System.out.println(resultado);
        System.out.println("Suma de todos valores de la matriz resultado:\t" + suma);
    }
}
