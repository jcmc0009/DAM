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
public class Ejercicio3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------

        // Constantes 
        // Variables de entrada 
        String primera, segunda, tercera;

        // Variables de salida 
        int longitudPrimera = 0, longitudSegunda = 0, longitudTercera = 0;
        String primeraMinuscula, segundaMinuscula, terceraMinuscula, primeraPregunta, segundaPregunta, primeraLetraPrimeraString, primeraLetraSegundaString, terceraPregunta, cuartaPregunta, ultimaLetraPrimeraString, ultimaLetraSegundaString, primeraLetraTerceraString, ultimaLetraTerceraString;;
        // Variables auxiliares

        // Clase Scanner para petición de datos al usuario a través del palabraPrimera
        Scanner palabraPrimera = new Scanner(System.in);
        Scanner palabraSegunda = new Scanner(System.in);
        Scanner palabraTercera = new Scanner(System.in);
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("Introduce la PRIMERA palabra:");
        primera = palabraPrimera.nextLine();
        primeraMinuscula = primera.toLowerCase();
        System.out.println("Introduce la SEGUNDA palabra:");
        segunda = palabraSegunda.nextLine();
        segundaMinuscula = segunda.toLowerCase();
        System.out.println("Introduce la TERCERA palabra:");
        tercera = palabraTercera.nextLine();
        terceraMinuscula = tercera.toLowerCase();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        //Primera pregunta
        longitudPrimera = primeraMinuscula.length();
        longitudSegunda = segundaMinuscula.length();
        longitudTercera = terceraMinuscula.length();
        primeraPregunta = (((longitudSegunda | longitudPrimera) < 6) | longitudTercera > 8 ? "Si" : "NO");

        //Segunda pregunta
        segundaPregunta = (longitudSegunda > (longitudPrimera & longitudTercera)) ? "Si" : "NO";

        //Tercera pregunta
        primeraLetraPrimeraString = String.valueOf(primeraMinuscula.charAt(0));
        ultimaLetraPrimeraString = String.valueOf(primeraMinuscula.charAt(longitudPrimera - 1));
        primeraLetraSegundaString = String.valueOf(segundaMinuscula.charAt(0));
        ultimaLetraSegundaString = String.valueOf(segundaMinuscula.charAt(longitudSegunda - 1));
        primeraLetraTerceraString = String.valueOf(terceraMinuscula.charAt(0));
        ultimaLetraTerceraString = String.valueOf(terceraMinuscula.charAt(longitudTercera - 1));
        terceraPregunta = (ultimaLetraPrimeraString.equals(primeraLetraSegundaString) & ultimaLetraSegundaString.equals(primeraLetraTerceraString)) ? "SI" : "NO";

        //Cuarta pregunta
        cuartaPregunta = (ultimaLetraPrimeraString.equals(primeraLetraSegundaString) & ultimaLetraSegundaString.equals(primeraLetraTerceraString) & primeraLetraPrimeraString.equals(ultimaLetraTerceraString)) ? "SI" : "NO";

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("RESULTADO");
        System.out.println("---------");
        System.out.println("La longitud de las dos primeras palabras es menor de 6 o la longitud de la tercera es mayor de 8 caracteres :" + primeraPregunta);
        System.out.println("La segunda palabra es la palabra de mayor longitud: " + segundaPregunta);
        System.out.println("Las tres palabras introducidas son palabras encadenadas: " + terceraPregunta);
        System.out.println("Las tres palabras introducidas son palabras circulares: " + cuartaPregunta);
        System.out.println("Fin del programa");

    }

}
