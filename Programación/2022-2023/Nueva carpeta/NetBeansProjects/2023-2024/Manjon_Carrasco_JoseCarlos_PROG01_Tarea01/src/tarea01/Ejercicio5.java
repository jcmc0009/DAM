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
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------

        // Constantes 
        final double PRECIOINFANTIL = 10, PRECIOADULTO = 15, COSTEPARADESCUENTOMINIMO = 50, PORCENTAJEMAXIMODESCUENTO = 15, IVA = 0.21, PORCENTAJEDESCUENTOMINIMO = 5, COSTEPARADESCUENTOMAXIMO = 100, PORCENTAJEDESCUENTONULO = 0;

        // Variables de entrada 
        int entradasAdulto = 0, entradasInfantil = 0;

        // Variables de salida 
        double costeEntradas = 0,  costeDescuentoMinimo = 0 ;
        //PORCENTAJEDESCUENTONULO da igual el valor que tenga, pues tal como está calculoPorcentajeDescuento las condiciones no serán falsas y no irá por ese camino
        double calculoPorcentajeDescuento = costeEntradas > COSTEPARADESCUENTOMAXIMO ? PORCENTAJEMAXIMODESCUENTO : ((costeEntradas > costeDescuentoMinimo) && (costeEntradas > costeDescuentoMinimo) ? PORCENTAJEDESCUENTOMINIMO : PORCENTAJEDESCUENTONULO);
        double calculoImporteTrasDescuento = costeEntradas - (costeEntradas * calculoPorcentajeDescuento) / 100;
        double calculoImporteTrasDescuentoIva = calculoImporteTrasDescuento * (1 + IVA);
        // Variables auxiliares
        
        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.print("Introduce la cantidad de entradas DE ADULTO que deseas adquirir: ");
        entradasAdulto = teclado.nextInt();
        System.out.print("Introduce la cantidad de entradas INFANTILES que deseas adquirir: ");
        entradasInfantil = teclado.nextInt();
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        costeEntradas = (entradasAdulto * PRECIOADULTO) + (entradasInfantil * PRECIOINFANTIL);


        String mensajeNoDescuento = "No procede descuento en esta compra"
                + "\nTras aplicar posibles descuentos el importe total de las entradas (sin IVA) es de " + costeEntradas + "€"
                + "\nEl importe IVA incluido es de " + (costeEntradas * (1 + IVA)) + "€\n" + "La cantidad final a pagar por el cliente es de " + (int) (costeEntradas * (1 + IVA)) + "€\n";
        String mensajeSiDescuentoMaximo = "Se aplicará un descuento del %.2f%%"
                + "\nTras aplicar posibles descuentos el importe total de las entradas (sin IVA) es de %.2f€"
                + "\nEl importe IVA incluido es de %.2f€\n" + "La cantidad final a pagar por el cliente es de " + (int) calculoImporteTrasDescuentoIva + "€\n";
       
        //el mensaje es el mismo tanto para un descuento del 15% como para el del 5% variando solo las cantidades a mostrar
        String mensajeNoDescuentoMaximo = mensajeSiDescuentoMaximo;
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("\nResultado");
        System.out.println("---------");
        System.out.println("Se comprarán " + entradasAdulto + " de tipo ADULTO y " + entradasInfantil + " de tipo INFANTIL");
        System.out.printf("El coste de las entradas antes de aplicar descuentos es de %.2f €\n", costeEntradas); //PORCENTAJEDESCUENTOMINIMO,costeDescuentoMinimo,costeDescuentoMinimoIva;
        System.out.printf((costeEntradas < COSTEPARADESCUENTOMINIMO) ? mensajeNoDescuento : (costeEntradas > COSTEPARADESCUENTOMAXIMO ? mensajeSiDescuentoMaximo : mensajeNoDescuentoMaximo), calculoPorcentajeDescuento, calculoImporteTrasDescuento, calculoImporteTrasDescuentoIva);
        System.out.println("Fin del programa");

    }

}
