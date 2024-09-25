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
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------

        // Constantes 
        final double CAPACIDADMAXIMA = 2000, PORCENTAJELLENADOSEGURO = 95, PORCENTAJELIBERAR = 10, VOLUMENAVACIAR, VOLUMENTRASVACIAR, PORCENTAJETRASVACIAR;
        String mensajeNoVaciado = "No es necesario considerar la liberación controlada de agua en este momento.\n";
        String mensajeSiVaciado = "Se ha realizado una liberación del %.1f%% vaciando un total de %.2f hectómetros cúbicos.\nEn el embase quedan ahora %.1f hectómetros cúbicos, que representan un %.2f%% de su capacidad máxima.";
        // Variables de entrada 
        double volumenAgua = 0, volumenHastaLlenado = 0;

        // Variables de salida 
        double porcentajeLlenado = 0;
        // Variables auxiliares

        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.print("Introduce el volumen de agua almacenada en el embalse(hectómetros cúbicos): ");
        volumenAgua = teclado.nextDouble();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        porcentajeLlenado = (volumenAgua * 100) / CAPACIDADMAXIMA;
        volumenHastaLlenado = CAPACIDADMAXIMA - volumenAgua;
        VOLUMENAVACIAR = volumenAgua * (PORCENTAJELIBERAR / 100);
        VOLUMENTRASVACIAR = volumenAgua - VOLUMENAVACIAR;
        PORCENTAJETRASVACIAR = (VOLUMENTRASVACIAR * 100) / CAPACIDADMAXIMA;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.printf("Faltan %.2f hectómetros cúbicos para llenar completamente el embalse. \n", volumenHastaLlenado);
        System.out.printf("El embalse está a un %.2f%% de su capacidad máxima. \n", porcentajeLlenado);
        System.out.println("\nResultado");
        System.out.println("---------");
        System.out.printf(porcentajeLlenado > PORCENTAJELLENADOSEGURO ? mensajeSiVaciado : mensajeNoVaciado, PORCENTAJELIBERAR, VOLUMENAVACIAR, VOLUMENTRASVACIAR, PORCENTAJETRASVACIAR);
        System.out.println("\nFin del programa");

    }

}
