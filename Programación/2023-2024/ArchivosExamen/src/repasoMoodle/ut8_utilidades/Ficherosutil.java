/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ut8_utilidades;

import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StreamTokenizer;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author luisnavarro. Ejemplos hechos:
 * //Ficherosutil.escribeFicherodesdeTeclado(Constantes.RUTA_SALIDA+"test2");
 * //Ficherosutil.leeFicheroTextoaConsola(Constantes.RUTA_SALIDA+"test2");
 * //Ficherosutil.contarPalabrasyNumeros(Constantes.RUTA_SALIDA+"datos.txt");
 * //Ficherosutil.leerBinarioConBuffer("test.bin"); //probarAgenda();
 * //probarFiltro("txt"); escribirLeerSerialzable();
 */
public class Ficherosutil {

    public static void escribeFicherodesdeTeclado(String nombreFichero) {

        Scanner sc = new Scanner(System.in);
        PrintWriter salida = null;

        try {
            salida = new PrintWriter(/*Constantes.RUTA_SALIDA*/ nombreFichero);//"datos.txt");   //se crea el fichero
            String cadena;
            System.out.println("Introduce texto. Para acabar introduce la cadena FIN:");
            cadena = sc.nextLine();                             //se introduce por teclado una cadena de texto    
            while (!cadena.equalsIgnoreCase("FIN")) {
                salida.println(cadena);                         //se escribe la cadena en el fichero
                cadena = sc.nextLine();                         //se introduce por teclado una cadena de texto    
            }
            salida.flush();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            salida.close();
        }
    }

    public static void leeFicheroTextoaConsola(String nombreFichero) {

        FileReader fr = null;
        try {
            fr = new FileReader(/*Constantes.RUTA_SALIDA +*/ nombreFichero);//"datos.txt");
            BufferedReader entrada = new BufferedReader(fr);
            int car = entrada.read();         //se lee el primer carácter del fichero
            while (car != -1) {               //mientras no se llegue al final del fichero                        
                System.out.print((char) car); //se nuestra por pantalla
                car = entrada.read();         //se lee el siguiente carácter del fichero                          
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void contarPalabrasyNumeros(String nombreFichero) {

        StreamTokenizer sTokenizer = null;
        int contadorPalabras = 0, numeroDeNumeros = 0;

        try {

            sTokenizer = new StreamTokenizer(new FileReader(nombreFichero));

            while (sTokenizer.nextToken() != StreamTokenizer.TT_EOF) {

                if (sTokenizer.ttype == StreamTokenizer.TT_WORD) {
                    contadorPalabras++;
                } else if (sTokenizer.ttype == StreamTokenizer.TT_NUMBER) {
                    numeroDeNumeros++;
                }
            }

            System.out.println("Número de palabras en el fichero: " + contadorPalabras);
            System.out.println("Número de números en el fichero: " + numeroDeNumeros);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void leoDelTecladoStringBuilder() {
        // Cadena donde iremos almacenando los caracteres que se escriban
        StringBuilder str = new StringBuilder();
        char c;
        // Por si ocurre una excepci�n ponemos el bloque try-cath
        try {
            // Mientras la entrada de terclado no sea Intro
            while ((c = (char) System.in.read()) != '\n') {
                // A�adir el character le�do a la cadena str
                str.append(c);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        // Escribir la cadena que se ha ido tecleando
        System.out.println("Cadena introducida: " + str);
    }

    public static void copiarDeReaderaOutputStreamconCodificacion(Reader entrada, OutputStream salida, String codificacion) throws IOException {
        // Crea un OutputStreamWriter para escribir en el OutputStream con la codificación especificada
        OutputStreamWriter writer = new OutputStreamWriter(salida, codificacion);

        char[] buffer = new char[1024]; // Un buffer para almacenar temporalmente los caracteres leídos
        int numCharsLeidos; // El número de caracteres leídos en cada iteración

        // Lee del Reader y escribe en el OutputStreamWriter hasta llegar al final de la entrada
        while ((numCharsLeidos = entrada.read(buffer)) != -1) {
            writer.write(buffer, 0, numCharsLeidos);
        }

        writer.flush(); // Asegura que todo el contenido se escribe en el OutputStream
    }

    public static void copiarDeInputStreamaWriterConCodificacion(InputStream entrada, Writer salida, String codificacion) throws IOException {
        // Crea un InputStreamReader para leer del InputStream con la codificación especificada
        InputStreamReader reader = new InputStreamReader(entrada, codificacion);

        char[] buffer = new char[1024]; // Un buffer para almacenar temporalmente los caracteres leídos
        int numCharsLeidos; // El número de caracteres leídos en cada iteración

        // Lee del InputStreamReader y escribe en el Writer hasta llegar al final de la entrada
        while ((numCharsLeidos = reader.read(buffer)) != -1) {
            salida.write(buffer, 0, numCharsLeidos);
        }

        salida.flush(); // Asegura que todo el contenido se escribe en el destino
    }

    
    
    static void copiaFlujoBytes(InputStream fentrada, OutputStream fsalida) {

        try {
            int n = 0;

            byte[] buffer = new byte[256 * 4 * 4];
            while ((n = fentrada.read(buffer)) >= 0) {
                fsalida.write(buffer, 0, n);
            }

            fentrada.close();
            fsalida.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void copiaFlujoCaracteres() {
        try {
            PrintWriter out = null;
            out = new PrintWriter(new FileWriter("c:\\salida.txt", true));
            //InputStreamReader lee el flujo de bytes y lo decodifica a caracteres. Actua de puente de flujo de bytes a flujo de caracteres.
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(System.in));
            String s;
            while (!(s = br.readLine()).equals("salir")) {
                out.println(s);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void copiaFlujoCaracteres(Reader r, Writer w) {
        try {
            //PrintWriter out = null;
            PrintWriter out = new PrintWriter(w);
            //InputStreamReader lee el flujo de bytes y lo decodifica a caracteres. Actua de puente de flujo de bytes a flujo de caracteres.
            BufferedReader br = new BufferedReader(r);
            String s;
            while (!(s = br.readLine()).equals("salir")) {
                out.println(s);
            }
            out.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }



    public static void leerBinarioConBuffer(String nombreFichero) {
        int tama;

        try {
            // Creamos un nuevo objeto File, que es la ruta hasta el fichero desde
            File f = new File( "test.bin");

            // Construimos un flujo de tipo FileInputStream (un flujo de entrada desde
            // fichero) sobre el objeto File. Estamos conectando nuestra aplicación
            // a un extremo del flujo, por donde van a salir los datos, y "pidiendo"
            // al Sistema Operativo que conecte el otro extremo al fichero que indica
            // la ruta establecida por el objeto File f que habíamos creado antes. De
            FileInputStream flujoEntrada = new FileInputStream(f);
            BufferedInputStream fEntradaConBuffer = new BufferedInputStream(flujoEntrada);

            // Escribimos el tamaño del fichero en bytes.
            tama = fEntradaConBuffer.available();
            System.out.println("Bytes disponibles: " + tama);

            // Indicamos que vamos a intentar leer 50 bytes del fichero.
            System.out.println("Leyendo 50 bytes....");

            // Creamos un array de 50 bytes para llenarlo con los 50 bytes
            // que leamos del flujo (realmente del fichero)*/
            byte bytearray[] = new byte[50];

            // El método read() de la clase FileInputStream recibe como parámetro un
            // array de byte, y lo llena leyendo bytes desde el flujo.
            // Devuelve un número entero, que es el número de bytes que realmente se
            // han leído desde el flujo. Si el fichero tiene menos de 50 bytes, no
            // podrá leer los 50 bytes, y escribirá un mensaje indicándolo.
            if (fEntradaConBuffer.read(bytearray) != 50) {
                System.out.println("No se pudieron leer 50 bytes");
            }

            // Usamos un constructor adecuado de la clase String, que crea un nuevo
            // String a partir de los bytes leídos desde el flujo, que se almacenaron
            // en el array bytearray, y escribimos ese String.
            System.out.println(new String(bytearray, 0, 50));

            // Finalmente cerramos el flujo.Es importante cerrar los flujos
            // para liberar ese recurso. Al cerrar el flujo, se comprueba que no
            // haya quedado ningún dato en el flujo sin que se haya leído por la aplicación. */
            fEntradaConBuffer.close();

            // Capturamos la excepción de Entrada/Salida. El error que puede
            // producirse en este caso es que el fichero no esté accesible, y
            // es el mensaje que enviamos en tal caso.
        } catch (IOException e) {
            System.err.println("No se encuentra el fichero");
        }
    }

    
    public static void copiaFichero(String fIn, String fOut) {
        try {
            //String fIn = Token.RUTA_SALIDA + "salida3.txt";
            //String fOut = Token.RUTA_SALIDA + "fichero3Copia.txt";
            File ficheroEntrada = new File(fIn);
            FileInputStream fisEntrada = new FileInputStream(ficheroEntrada);
            File ficheroSalida = new File(fOut);
            FileOutputStream fosSalida = new FileOutputStream(ficheroSalida);
            //InputStream isEntrada=new InputStream(fisEntrada);
            //OutputStream osSalida=new OutputStream(fosSalida);
            copiaFlujoBytes(fisEntrada, fosSalida);
        } catch (FileNotFoundException fnfe) {
            System.out.println("" + fnfe.getMessage());
        }

    }

}
