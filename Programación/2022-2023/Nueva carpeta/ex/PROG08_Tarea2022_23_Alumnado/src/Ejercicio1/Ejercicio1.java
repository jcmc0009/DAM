/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.util.StringTokenizer;

/**
 * Programa para trabajar con archivos de texto.
 *
 * @profesorado
 */
public class Ejercicio1 {

    /**
     * Método principal.
     */
    public static void main(String args[]) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        String rutaCoeficientes = System.getProperty("user.dir") + "/recursos/coeficientes.txt";
        String listadoComerciales = System.getProperty("user.dir") + "/recursos/listadoComerciales.txt";
        // Variables de entrada

        // Variables de salida
        // Variables auxiliares
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        File archivoCoeficientes = new File(rutaCoeficientes);
        System.out.println("Nombre y apellidos" + "              DNI" + "             Ventas Nac." + "             Ventas inter" + "         Sueldo" + "     Objetivos cumplidos");
        try {
            FileReader fr = new FileReader(archivoCoeficientes);
            BufferedReader br = new BufferedReader(fr);
            String linea = br.readLine();
            //System.out.println(br.readLine());

            StringTokenizer coeficientes = new StringTokenizer(linea, ";");
            // System.out.println(coeficientes);

            FileReader archivoComerciales = new FileReader(listadoComerciales);
            BufferedReader bufferArchivoComerciales = new BufferedReader(archivoComerciales);
            StringBuilder sb = new StringBuilder();    //crea un constructor string buffer vacío, sin caracteres 
            String line;
            while ((line = bufferArchivoComerciales.readLine()) != null) {
                sb.append(line);      
                sb.append("\n");      
            }
            fr.close();    //closes the stream and release the resources  
            StringTokenizer comercial = new StringTokenizer(sb.toString(), ";");
            while (comercial.hasMoreTokens()) {
                System.out.print(comercial.nextToken() + "        ");   //returns a string that textually represents the object 

            }
            System.out.println("\n");
            while (coeficientes.hasMoreTokens()) {
                System.out.println(coeficientes.nextToken()+"rerd");

            }

        } catch (IOException e) {
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("Archivos cerrados y procesamento finalizado");
        System.out.println("---------");

        System.out.println();
        System.out.println("Fin del programa.");
    }

    /**
     *
     * @param ventasN Importe de ventas nacionales
     * @param ventasI Importe de ventas internacionales
     * @param cN Coeficiente que corresponde al tanto por ciento que recibe el
     * comercial por ventas nacionales
     * @param cI Coeficiente que corresponde al tanto por ciento que recibe el
     * comercial por ventas internacionales
     * @param limitePrima Cantidad a partir de la cual se cobra la prima extra
     * @return
     */
    public static double calcularSueldoComercial(double ventasN, double ventasI, double cN, double cI, int limitePrima) {
        double sueldoComercial = (ventasN * cN) / 100 + (ventasI * cI) / 100;
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
    public static boolean isObjetivosCumplidos(double ventasN, double ventasI, int minimoObjetivos) {
        return ((ventasN + ventasI) >= minimoObjetivos);
    }
}
