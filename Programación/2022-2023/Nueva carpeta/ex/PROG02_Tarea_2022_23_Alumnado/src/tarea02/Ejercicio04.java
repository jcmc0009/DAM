/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarea02;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio04 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        // Variables de entrada (aquí se definen las variables que recibirán valores, si fueran necesarias)
        int numero, numeroFilasAproximado;

        // Variables de salida (aquí se definen las variables que almacenarán resultados y se mostrarán al usuario, si fueran necesarias)
        // Clase Scanner para petición de datos al usuario a través del teclado
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        //Se crea bucle para establecer un número mínimo de entrada
        do {
            System.out.println("Introduce el número de filas del histograma(Mayor de 12)");
            numero = teclado.nextInt();
        } while (numero < 12);

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        numeroFilasAproximado = (numero / 4) * 4; // cálculo para ajustar el número de filas a mayor múltiplo de 4
        System.out.print("El numero de filas a mostrar es " + numeroFilasAproximado + "\n"); //se muestra oor pantalla

        //----------------------------------------------
        //                 Pintar histograma 
        //----------------------------------------------
        System.out.println("----------------------------------------------");
        int tipoCaracter = 0;//
        String caracter = "";
        for (int i = 0; i < numeroFilasAproximado; i++) {
            //seleccionamos caracter válido para la línea 
            tipoCaracter++; //incrementando el número de carácter para la siguiente iteración
            if (tipoCaracter == 0) {
                caracter = "*";
            } else if (tipoCaracter == 1) {
                caracter = "#";
            } else if (tipoCaracter == 2) {
                caracter = "@";
            } else if (tipoCaracter == 3) {
                caracter = ">";

            }
            //generar número aleatorio, estableciendo el valor mínimo en 3 y el máximo entre la mitad del numero de filas del histograma
            Random random = new Random();
            int min = 3;
            int max = numeroFilasAproximado / 2;
            int aleatorio = random.nextInt((max - min) + 1) + min;

            // pintar tantos caracteres como el número aleatorio menos 1,se empieza a contar por 0
            for (int j = 0; j < aleatorio; j++) {
                System.out.print(caracter);
            }
            System.out.print("\n"); // este salto de línea, lo que hace es formatear, para que en cada línea esté un caracter diferente y no todos seguidos

            //reinicio contador de caracteres cuando me pase de 3 para tener un carácter distinto en cada línea
            //pintar la línea divisoria
            if (tipoCaracter > 3) {
                System.out.println("--------------------------------------");
                tipoCaracter = 0;
            }

        }

    }

}
