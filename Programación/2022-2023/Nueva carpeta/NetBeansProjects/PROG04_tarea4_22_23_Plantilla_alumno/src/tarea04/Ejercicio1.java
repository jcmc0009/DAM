package tarea04;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * en el reemplazo de caracteres a mi solo me reemplazaba el primer caracter de
 * la cadena prohibida , entonces le he metido a la funcion de reemplazo:
 * "*".repeat(palabrasProhibidas[i].length()) y ya si me reemplaza toda la
 * cadena prohibida por *
 *
 *
 *
 *
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio1 {

    public static final String ANSI_GREEN = "\u001B[32m";

    public static void main(String[] args) {

        String cadena = "";
        String alfabeto = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        boolean cadenaValida;
        //String vocales = "AEIOU";
        //  String consonantes = "BCDFGHJKLMNPQRSTVWXYZ";

//        stringBuilder.ensureCapacity(alfabeto.length());
        String[] palabrasProhibidas = {"STAR", "THE", "AL", "DE", "AS"};

        StringBuilder correspondencia;
        // invertimos orden del alfabeto
        System.out.println("Cifrado : Generación de correspondencia entre alfabeto origen y destino.");
        do {
            cadenaValida = true;
            correspondencia = new StringBuilder();
            StringBuilder alfabetoIntermedio = new StringBuilder(alfabeto);
            for (int i = 0; i < alfabeto.length(); i++) {
                while (alfabeto.length() != correspondencia.length()) {
                    try {
                        // elegir posicion
                        Random r = new Random();
                        int n = r.nextInt((alfabeto.length() + 1) - 0) + 0;
                        // tomamos caracter de esa posición
                        char c = alfabetoIntermedio.charAt(n);
                        // lo agregamos a cadena resultado
                        correspondencia.append(c);
                        // elimino el caracter añadodp de la cadena
                        alfabetoIntermedio.deleteCharAt(n);
                        //alfabetoIntermedio = alfabeto;
                        // System.out.println(alfabeto);

                    } catch (StringIndexOutOfBoundsException e) {
                    }

                }

            }
            cadena = correspondencia.toString();
            System.out.println("Intento de correspondencia: " + correspondencia);

            Pattern patron = Pattern.compile("[AEIOU][B-Z^AEIOU][AEIOU]");
            //  String textoAnalizar = correspondencia.toString();
            //cadena = "QTHLFOSKGPNWVYIECZMBXAJUDR";
            Matcher acoplamiento = patron.matcher(cadena); // Texto donde buscar o "acoplar"
            if (acoplamiento.find()) {
                System.out.println("Patrón de una sola consonante entre dos vocales encontrado : " + acoplamiento.replaceAll("***"));
                cadenaValida = false;
            } else {
                //System.out.println("Todo bien: ");

            }

            //palabrasProhibidas
            // detectar palabras prohibidas
            //   cadena = "BCEFGHIJDKLMNOPQRASTUVWXYZ";
            if (cadenaValida) {

                for (int z = 0; z < palabrasProhibidas.length; z++) {

                    String palabraProhibida = palabrasProhibidas[z];
                    //cadena = "ZUORFWGASVJQYPNCTEMDKIHLBX";
                    if (cadena.contains(palabraProhibida)) {
                        int numeroCaracterCadena = palabraProhibida.length();
                        cadenaValida = false;
                        System.out.println("Intento correspondencia contiene " + palabraProhibida + " palabra prohibida");

                        for (int y = 0; y < palabraProhibida.length(); y++) {
                            Character letraProhibida = palabraProhibida.charAt(y);
                            /*String numeroVeces = String.valueOf(letraProhibida);
                            int t = numeroVeces.length();*/

                            for (int r = 0; r < numeroCaracterCadena; r++) {
                                cadena = cadena.replace(letraProhibida.toString(), "*");
                            }

                        }
                        System.out.println(cadena);
                    }

                }
            }
            if (!cadenaValida) {
                //System.out.println("otra cadena");
            }
        } while (!cadenaValida);

        System.out.println("Se ha generado una correspondencia válida");
        System.out.println("Las letras correspondientes a :" + alfabeto);
        System.out.println("son las siguientes en orden :" + cadena);
        System.out.println("Letra sin codificar--------Letra codificada");
        for (int p = 0; p < alfabeto.length(); p++) {
            System.out.println("\t\t" + alfabeto.charAt(p) + "---------------" + cadena.charAt(p));

        }

    }

}
