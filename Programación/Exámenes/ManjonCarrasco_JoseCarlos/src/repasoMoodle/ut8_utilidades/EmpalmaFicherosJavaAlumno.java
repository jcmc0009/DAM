/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut8_utilidades;

import java.io.*;
import java.util.Arrays;

/**
 *
 * @author luisnavarro
 */
public class EmpalmaFicherosJavaAlumno {

    public static void main(String[] args) {
        //String rutaCarpeta = "/Users/luisnavarro/NetBeansProjects/PROG06_T6/src/ArandaBaronaInmaculadaMobiliario_"; // Ajusta la ruta a tu carpeta
        String rutaCarpeta = "/Users/luisnavarro/NetBeansProjects/prog0x_ejemplos_luis/PROG0X_ejemplos_luis/src/T6mobiliario_v2";
        empalma(new File(rutaCarpeta));
   
    }
    public static void main2(String[] args) {
        //cojo un array de carpetas
        File carpetaRaiz = new File("/Users/luisnavarro/NetBeansProjects/PROG06_T6/src/");
        File[] subcarpetas = carpetaRaiz.listFiles(new FileFilter() {
            public boolean accept(File archivo) {
                return archivo.isDirectory();
            }

        });
        Arrays.sort(subcarpetas);
        for (int i = 0; i < subcarpetas.length; i++) {
            empalma(subcarpetas[i]);
            //System.out.println("//import "+subcarpetas[i].toString().substring(50)+".*;");
            
        }
    }

    public static void empalma(File carpeta) {
        //String rutaCarpeta = "/Users/luisnavarro/NetBeansProjects/PROG06_T6/src/ArandaBaronaInmaculadaMobiliario_"; // Ajusta la ruta a tu carpeta
        //String rutaCarpeta = "/Users/luisnavarro/NetBeansProjects/prog0x_ejemplos_luis/PROG0X_ejemplos_luis/src/T6pruebas";
        //File carpeta = new File(rutaCarpeta);

        File[] archivos = carpeta.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return name.endsWith(".java");
            }
        });
        Arrays.sort(archivos);
        try {
            File empalme=new File(carpeta, "trabajo2.txt");
            FileWriter writer = new FileWriter(empalme);//rutaCarpeta + "/trabajo.txt");
            for (File archivo : archivos) {
                FileReader fr = new FileReader(archivo);
                BufferedReader br = new BufferedReader(fr);

                String linea;
                while ((linea = br.readLine()) != null) {
                    writer.write(linea + System.lineSeparator());
                }

                br.close();
                fr.close();
            }
            writer.close();
            System.out.println("Archivo 'trabajo.txt' creado exitosamente.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
