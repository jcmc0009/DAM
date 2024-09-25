/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.util.ArrayList;
import java.util.List;


/**
 * Programa para trabajar con archivos binarios y objetos serializables.
 * @profesorado
 */
public class Ejercicio2 {
    
    /**
    * Método principal.
    */
    public static void main(String args[]){
        
        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        // Constantes


        // Variables de entrada
        String ruta = System.getProperty("user.dir") + "/recursos/BDAeroGen.dat";
        List<AeroGenerador> misAerog=null;
        AeroGeneradorIO bd = null;
        List bicisBD = null;
        
        // Variables de salida

        // Variables auxiliares
        
        //----------------------------------------------
        //                 Entrada de datos + Procesamiento + Salida 
        //----------------------------------------------
        misAerog = new ArrayList<>();
        misAerog.add(new AeroGenerador());
        misAerog.add(new AeroGenerador());
        misAerog.add(new AeroGenerador());
        
        bd = new AeroGeneradorIO(ruta);
        
        System.out.printf("He creado y almaceno en el archivo %d aero generadores.\n",misAerog.size());
        System.out.println("LISTADO AERO GENERADORES GUARDADOS EN FICHERO:");
        System.out.println(misAerog.toString());
        
        bd.escribir(misAerog);
          
        misAerog.add(new AeroGenerador());
        misAerog.add(new AeroGenerador());
        
        System.out.printf("Ahora inserto 2 aero generadores más. Tengo ahora %d aero generadores.\n",misAerog.size());
        System.out.println("LISTADO DE AERO GENERADORES GUARDADOS EN EL ARRAYLIST:");
        System.out.println(misAerog.toString());
        
        bicisBD = bd.leer();
        System.out.printf("Leo del archivo %d aero generadores.\n",bicisBD.size());
        System.out.println("LISTADO DE AERO GENERADORES GUARDADOS EN FICHERO:");
        System.out.println(bicisBD.toString());      
    }
}
