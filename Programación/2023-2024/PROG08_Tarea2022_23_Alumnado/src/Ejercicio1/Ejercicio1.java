/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;


/**
 * Programa para trabajar con archivos de texto.
 * @profesorado
 */
public class Ejercicio1 {
    
    /**
    * Método principal.
    */
    public static void main(String args[]){
        
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        
        // Constantes


        // Variables de entrada
       
        
        // Variables de salida
        
        
        // Variables auxiliares
        
   
        
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        
        System.out.println ();
	System.out.println ("Archivos cerrados y procesamento finalizado");
	System.out.println ("---------");
        
        
        System.out.println ();
	System.out.println ("Fin del programa.");
    }
    
    /**
     * 
     * @param ventasN Importe de ventas nacionales
     * @param ventasI Importe de ventas internacionales
     * @param cN Coeficiente que corresponde al tanto por ciento que recibe el comercial por ventas nacionales
     * @param cI Coeficiente que corresponde al tanto por ciento que recibe el comercial por ventas internacionales
     * @param limitePrima Cantidad a partir de la cual se cobra la prima extra
     * @return 
     */
    public static double calcularSueldoComercial(double ventasN, double ventasI, double cN, double cI, int limitePrima) {
        double sueldoComercial = (ventasN * cN)/100 + (ventasI * cI)/100;
        if ((ventasN + ventasI) >= limitePrima) {
            sueldoComercial += (ventasN + ventasI) * 7 / 100;
        }
        return sueldoComercial;
    }

    /**
     * 
     * @param ventasN Importe de ventas nacionales
     * @param ventasI Importe de ventas internacionales
     * @param minimoObjetivos Cantidad mínima en ventas para cubrir obejivos.
     * @return 
     */
    public static boolean isObjetivosCumplidos(double ventasN, double ventasI, int minimoObjetivos){
       return ((ventasN + ventasI) >= minimoObjetivos);
    }
}
