/**
 *
 * Ejercicio 1.  Calcular el área de un trapecio regular
 *
 * @José Carlos Manjón Carrasco
 */
package tarea01;

import java.util.Scanner; // importación de un paquete externo para poder utilizar la clase Scanner y meter datos

public class Ejercicio1 {

    public static void main(String[] args) {

        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Constantes 
        float calculo;
        // Variables de entrada 
        float altura, baseMenor, baseMayor, longitudes;

        // Variables de salida 
        
        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        
        System.out.println("Ejercicio 1. Inicio");
        System.out.println("--------------------");
        //Se pide por pantalla los diferentes datos y se almacenan en una variable
        System.out.println("Introduce longitud altura(cm):");
        altura = teclado.nextFloat();
        System.out.println("Introduce longitud base menor(cm):");        
        baseMenor = teclado.nextFloat();                          

        System.out.println("Introduce longitud base mayor(cm):"); 
        baseMayor = teclado.nextFloat();
      
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        //se realizan los cálculos y se almacenan en una variable y una constante (la fórmula, puesto que no se modifica)
        longitudes = (baseMayor + baseMenor) / 2;
        calculo = longitudes * altura;

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        //mostrmos los datos por pantalla
        System.out.println();
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("El área del trapecio de altura " + altura + "cm,base menor " + baseMenor + "cm, base mayor " + baseMayor + "cm , es de " + calculo + "cm2"); // se muestra el contenido de la variable textoResultado
        System.out.println();
        System.out.println("Fin del programa.");
    }
}
