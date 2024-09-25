/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea01;

import java.util.Scanner;

/**
 *
 * @author Jose Carlos Manjon Carrasco
 */
public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------

        // Constantes 
        final double PI = 3.1415927;

        // Variables de entrada y salida
        double radio = 0, altura = 0, volumen = 0;
           
        // Variables auxiliares
        double radioCuadrado = 0;

        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado = new Scanner(System.in);
        Scanner tecladoDos = new Scanner(System.in);
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("Introduce el radio del cilindro en cm");
        radio = teclado.nextDouble();
        System.out.println("Introduce la altura del cilindro en cm");
        altura = tecladoDos.nextDouble();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        radioCuadrado = radio * radio;
        volumen = PI * radioCuadrado * altura;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------

        System.out.printf("El volumen del cilindro de radio %.2f cm y altura %.2f cm es de %.2fcm3 \n", radio, altura, volumen);
        System.out.println("Fin del programa");

    }

}
