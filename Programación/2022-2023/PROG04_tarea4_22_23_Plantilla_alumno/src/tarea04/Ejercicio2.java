package tarea04;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @José Carlos Manjón Carrasco
 */
public class Ejercicio2 {

    public static void main(String[] args) {
        // 0 Declaración de variables
        int vueltas = 0;
        String accion = null;
        Pattern patron = Pattern.compile("[CDcd]");

        boolean accionValida = false, vueltasValidas = false;
        StringBuilder textoTraducidoIntermedioBuilder = new StringBuilder();
        Matcher acoplamiento = null;
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String alfabetoCifrado = "BVWHGZMLXKONIYFSTUCEDPRAQJ";
        boolean patronEncontrado;
        String textoOriginal = "Doha se suma a las ciudades que han acogido uno de los grandes duelos europeos, los España-Alemania, las dos selecciones que han ganado más veces la Eurocopa (tres), ambas con estrellas en su camiseta (4-1 para los germanos) y qu";
        String textoTraducido = "";

        String textoMayusculaTraducido = "";
        Scanner tecladoNumeros = new Scanner(System.in);
        Scanner tecladoLetras = new Scanner(System.in);
        Scanner tecladoTexto = new Scanner(System.in);

        System.out.println("Cifrado de Cadenas. Varias Vueltas");
        // Selección de datos de entrada 
        // 1. Selección de Cifrado o Descifrado. Verificando si es C o D (tanto mayúscula como minúscula)

        while (!accionValida) {
            System.out.println("¿Quieres cifrar o descifrar (C ó D)?");
            try {
                accion = tecladoLetras.next(patron);
                acoplamiento = patron.matcher(accion); // Texto donde buscar o "acoplar"
                if (acoplamiento.find()) {
                    accionValida = true;

                }
            } catch (InputMismatchException exception) {
                accion = null;

            }
            tecladoLetras.nextLine(); // hace que el bucle no entre en un bucle infinito cuando el input es <> al patrón
        }
        // 2.Selección de número de vueltas entre 2 y 5

        do {
            System.out.println("¿Introduce el número de vueltas?");
            try {
                vueltas = tecladoNumeros.nextInt();
                if (vueltas >= 2 & vueltas <= 5) {
                    vueltasValidas = true;
                }

            } catch (InputMismatchException exception) {
            }
            tecladoNumeros.nextLine();
        } while (!vueltasValidas);
        // 3. Introducción del texto para  el cifrado
        System.out.println("Introduce el texto");
        textoOriginal = tecladoTexto.nextLine();
        // System.out.println(textoAtrabajarlo);
        // 4. Se pasa  el texo introducido a mayúsculas
        String textoMayuscula = textoOriginal.replace("\\s", "").toUpperCase();

        // 5. Si vamos a cifrar o descifrar elegimos un camino y otro
        // Cifrar
        if (accion.matches("[Cc]")) {
            // 5.1 Empezamos por el cifrado. Se debe recorrer caracter a caracter del texto a cifrar

            for (int d = 0; d < vueltas; d++) {
                textoTraducidoIntermedioBuilder = new StringBuilder(); // se limpia el StringBuilderIntermedio para que en los bucles de traducción  no se procesen unos tras otros , es decir que se empalmen traducciones
                for (int c = 0; c < textoOriginal.toUpperCase().length(); c++) {

                    // 5.1.1 Obtenemos cada caracter de la cadena en mayúscula
                    char caracter = textoMayuscula.charAt(c); //recorremos el texto reconociendo los caracteres
                    // 5.1.2 Se obtiene la posición en el alfabero del caracter de la cadena original en mayúscula que estamos recorriendo
                    int posicionCaracter = alfabeto.indexOf(caracter); // averiguamos la posición del caracter buscado

                    // 5.1.3 Se debe comprobar si la posición es superior a 0, lo que nos indica que tenemos caracter para traducir. Si no la encontramos, la dejamos sin cifrar, ya que será un caracter "raro", espacio, guión, etc.
                    if (posicionCaracter >= 0) {

                        // 5.1.3.1 Obtenemos el caracter en alfabetoCifrado que se encuentr en la posición obtenida del alfabeto original
                        caracter = alfabetoCifrado.charAt(posicionCaracter); // con la posición del carácter buscado recorremos el alfabeto codificado y cogemos el carácter
                    }
                    // 5.1.3.2 Caracter raro se agrega tal cual
                    // 5.1.4 Añadimos ese caracter cifrado al StringBuilder resultado
                    textoTraducidoIntermedioBuilder.append(caracter); // se van añadiendo los carácter encontrados

                }

                textoMayuscula = textoTraducidoIntermedioBuilder.toString().toUpperCase();
                textoMayusculaTraducido = textoMayuscula;
            }
        } else {
            // Descifrar
            // 5.2 Descifrado. Se debe recorrer caracter a caracter del texto a descifrar

            for (int d = 0; d < vueltas; d++) {
                textoTraducidoIntermedioBuilder = new StringBuilder();// se limpia el StringBuilderIntermedio para que en los bucles de traducción  no se procesen unos tras otros , es decir que se empalmen traducciones
                for (int c = 0; c < textoOriginal.toUpperCase().length(); c++) {

                    // 5.2.1 Obtenemos cada caracter de la cadena en mayúscula
                    char caracter = textoMayuscula.charAt(c); //recorremos el texto reconociendo los caracteres
                    // 5.1.2 Se obtiene la posición en el alfaberoCifrado del caracter de la cadena original en mayúscula que estamos recorriendo
                    int posicionCaracter = alfabetoCifrado.indexOf(caracter); // averiguamos la posición del caracter buscado

                    // 5.2.3 Se debe comprobar si la posición es superior a 0, lo que nos indica que tenemos caracter para traducir. Si no la encontramos, la dejamos sin cifrar, ya que será un caracter "raro", espacio, guión, etc.
                    if (posicionCaracter >= 0) {

                        // 5.2.3.1 Obtenemos el caracter en alfabeto que se encuentre en la posición obtenida del alfabetoCifrado original
                        caracter = alfabeto.charAt(posicionCaracter); // con la posición del carácter buscado recorremos el alfabeto codificado y cogemos el carácter
                    }
                    // 5.2.3.2 Caracter raro se agrega tal cual
                    textoTraducidoIntermedioBuilder.append(caracter); // se van añadiendo los carácter encontrados

                }

                textoMayuscula = textoTraducidoIntermedioBuilder.toString().toUpperCase();
                textoMayusculaTraducido = textoMayuscula;
            }
        }

        // 6. Se muestran los resultados.
        System.out.println(
                "El texto original:" + textoOriginal);
        System.out.println(
                "El texto traducido:" + textoMayusculaTraducido);

    }
}
