/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Programa para trabajar con archivos binarios y objetos serializables.
 *
 * @profesorado
 */
public class Ejercicio2 implements Serializable {

    /**
     * Método principal.
     */
    public static void main(String args[]) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // Constantes
        // Variables de entrada
        String ruta = System.getProperty("user.dir") + "/recursos/BDAeroGen.dat";
        List<AeroGenerador> misAerog = null;
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

        System.out.printf("He creado y almaceno en el archivo %d aero generadores.\n", misAerog.size());
        System.out.println("LISTADO AERO GENERADORES GUARDADOS EN FICHERO:");
        System.out.println(misAerog.toString());

        bd.escribir(misAerog);

        misAerog.add(new AeroGenerador());
        misAerog.add(new AeroGenerador());

        System.out.printf("Ahora inserto 2 aero generadores más. Tengo ahora %d aero generadores.\n", misAerog.size());
        System.out.println("LISTADO DE AERO GENERADORES GUARDADOS EN EL ARRAYLIST:");
        System.out.println(misAerog.toString());
        // Ahora pruebo a escribir el array en un fichero de disco
//        bd.escribir(misAerog);
        bd.escribir(misAerog);
        bicisBD = misAerog;
        bicisBD = (List)bd.leer();
        System.out.printf("Leo del archivo %d aero generadores.\n", bicisBD.size());
        System.out.println("LISTADO DE AERO GENERADORES GUARDADOS EN FICHERO:");
        System.out.println(bicisBD.toString());
    }

    static List main(List misAerog) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
