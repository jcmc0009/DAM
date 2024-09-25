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
public class Ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------

        // Constantes 
        // Variables de entrada 
        int valorPrimerNumero = 0, valorSegundoNumero = 0, valorTercerNumero = 0;

        // Variables de salida 
        double resultadoPrimeraPregunta, resultadoSegundaPregunta, restultadoCuartaPregunta;
        String resultadoTerceraPregunta;
        // Variables auxiliares
        double terceraPregunta;
        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado = new Scanner(System.in);
        Scanner tecladoDos = new Scanner(System.in);
        Scanner tecladoTres = new Scanner(System.in);
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.print("Introduce el valor del primer número: ");
        valorPrimerNumero = teclado.nextInt();
        System.out.print("Introduce el valor del segundo número :");
        valorSegundoNumero = tecladoDos.nextInt();
        System.out.print("Introduce el valor del segundo número: ");
        valorTercerNumero = tecladoTres.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        resultadoPrimeraPregunta =((double)valorPrimerNumero / 3) + (0.5 * (double)valorTercerNumero);
        resultadoSegundaPregunta = ((valorSegundoNumero + valorTercerNumero) / 2) * ((valorSegundoNumero + valorTercerNumero) / 2);
        terceraPregunta = (valorSegundoNumero + valorTercerNumero - valorPrimerNumero) * 3;
        resultadoTerceraPregunta = (terceraPregunta % 2) != 0 ? "false" : "true";
        restultadoCuartaPregunta = ((double)(valorPrimerNumero + valorSegundoNumero) * (double)(valorTercerNumero - valorPrimerNumero)) / (double)valorSegundoNumero;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\nResultado");
        System.out.println("---------");
        System.out.println("Valor del tercio del primer número mas la mitad del tercer número: " + resultadoPrimeraPregunta);
        System.out.println("Valor del cuadrado de la mitad de la suma del segundo número mas el tercero: " + resultadoSegundaPregunta);
        System.out.println("Comprobamos si el triple de la suma del segundo mas el tercer número menos el primero es par : " + resultadoTerceraPregunta);
        System.out.println("Valor de la suma del primero más el segdundo , multiplicado por la diferencia del tercero menos el primero y todo eso partido por el segundo número: " + restultadoCuartaPregunta);
        System.out.println("\nFin del programa");
    }
}
