package tarea04;

import java.util.Scanner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Tarea Online 4. Ejercicio 1: Nivel de Seguridad de Contraseñas
 *
 * @author José Carlos Manjón Carrasco
 * @version 1.0
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        // DEFINICIÓN DE CONSTANTES
        final String[] PATRONES = {"[0-9]+"/*Patrón si contiene números */, "[a-z]+"/*Patrón si contiene letras minúsculas */, "[A-Z]+" /*Patrón si contiene letras mayúsculas */, "[\\\\\\\\!|#\\\\$%&()=?*+\\\\-_{\\\\[\\\\]:;,.<>@]+"/*Patrón si contiene caracteres especiales */, "[b-z^eiou]{4,}|[B-Z^EIOU]{4,}" /* Si contiene al menos cuatro consonantes juntas */, "([A-Z][a-z][A-Z])+|([a-z][A-Z][a-z])+"/* Que tenga al menos dos alternancias entre mayúsculas y minúsculas*/};
        final String CONTRASENYAS_USADAS = "password;123456;123456789;guest;qwerty;12345678;111111;12345;col123456;123123;1234567;1234;1234567890;tequiero;555555;666666;123321;654321;7777777;123;D1lakiss;777777;110110jp;1111;987654321;121212;Gizli;abc123;112233;azerty;159753;1q2w3e4r;54321;pass@123;222222;qwertyuiop;qwerty123;qazwsx;vip;asdasd;123qwe;123654;iloveyou;a1b2c3;999999;Groupd2013;1q2w3e;usr;Liman1000;1111111;333333;123123123;9136668099;11111111;1qaz2wsx;password1;mar20lt;987654321;gfhjkm;159357;abcd1234;131313;789456;luzit2000;aaaaaa;zxcvbnm;asdfghjkl;1234qwer;88888888;dragon;987654;888888;qwe123;football;3601;asdfgh;master;samsung;12345678910;killer;1237895;1234561;12344321;daniel;00000;444444;101010;f--;you;qazwsxedc;789456123;super123;qwer1234;123456789a;823477aA;147258369;unknown;98765;q1w2e3r4;232323";
        final String[] DICCIONARIO_CONTRASENYAS;
        final double PUNTOSPORNIVEL = 0.5;

        // DEFINICIÓN DE VARIABLES
        String contraseña = ""; // Variable para almacenar la password introducida
        double nivelSeguridad = 0.0;// Varaible para el nivel de seguridad
        // Variable para almacenar el objeto Scanner para la entrada de datos
        Scanner teclado = new Scanner(System.in);
        String resultado = "";
        int contadorPartesMasUsadas = 0, numeroPatron = 1;

        /* ************************************************************************
        
         * ENTRADA DE DATOS
         * ***********************************************************************/
 /* 1. Comprobamos que la contraseña tenga al menos 8 caracteres, no se debe 
         * seguir si la contraseña no presenta al menos 8 caracteres 
         */
        do {
            System.out.println("Introduce la contraseña (Nivel 0: La contraseña debe tener al menos 8 caracteres)");
            contraseña = teclado.nextLine();

        } while (contraseña.length() < 8);
        /* ************************************************************************
         * PROCESAMIENTO
         * ***********************************************************************/

 /* 2. Realizamos la comprobación de cada uno de los patrones, aumentando el nivel 
        de complejidad de la variable si va superando los patrones
         */
        for (int i = 0; i < PATRONES.length; i++) {
            resultado += "Comprobando patrón: " + numeroPatron + "\nNivel Actual: ";
            numeroPatron++;
            Pattern patron = Pattern.compile(PATRONES[i]);
            Matcher acoplamiento = patron.matcher(contraseña); // Texto donde buscar o "acoplar"
            if (acoplamiento.find()) {
                /* 2.2 Si es uno de los cuatro primeros patrones suman 0.5
                * si el patron analizado es de los siguientes (a partir del cuarto) 
                * suman un punto
                 */
                if (i <= 3) {
                    nivelSeguridad += PUNTOSPORNIVEL;
                    resultado += nivelSeguridad;
                    /* 2.1 En el caso de que hayamos completado los cuatro primeros patrones 
                   y su validación haya sido positiva en todos ellos, se suma un punto
                   al nivel de seguridad {
                     */ if (i == 3 && nivelSeguridad == 2.0) {
                        nivelSeguridad += 1;
                        resultado += "\nAl completarse los cuatro primeros patrones como positivos, añadimos un punto al nivel de seguridad\nNivel actual: " + nivelSeguridad;
                    }
//hacemos que a partir del 4 nivel de seguridad la puntuación aumente
                } else if (i > 3) {
                    nivelSeguridad += 1.0;
                    //       resultado += nivelSeguridad;
                    resultado += nivelSeguridad;
                }

            } else {
                resultado += nivelSeguridad;
            }
            resultado += "\n";
        }

        // 3. Comprobación de que la palabra se encuentra en el diccionario.
        /* 3.1 A partir de la cadena de contraseñas separadas por ";" que tenemos 
         * en la constante CONTRASENYAS_USADAS, obtenemos un array de palabras que
         * guardamos en DICCIONARIO_CONTRASENYAS
         */
        DICCIONARIO_CONTRASENYAS = CONTRASENYAS_USADAS.split(";");
        /* En este bucle comprobamos si nuestra contraseña es igual que alguna 
           palabra del diccionario, y si nuestra contraseña contiene partes de 
           de contraseñas del diccionario. Una vez encuentra una, no es necesario 
           comprobar si es igual al resto,aunque sí pueden aparecer varias 
           contraseñas del diccionario como partes de la nuestra, por lo que debemos
           incrementar el numeroPatron y recorrer el bucle hasta el final
         */

        for (int i = 0; i < (DICCIONARIO_CONTRASENYAS.length); i++) {
            if ((contraseña.equals(DICCIONARIO_CONTRASENYAS[i]))) {
                //      if ((contraseña.compareTo(DICCIONARIO_CONTRASENYAS[i].toString()))) {
                nivelSeguridad -= 1;

            } else if (contraseña.contains(DICCIONARIO_CONTRASENYAS[i])) {
                contadorPartesMasUsadas++;
            }

        }

        resultado += "El nivel de seguridad de la contraseña " + contraseña + " es : %.2f";
        /* ************************************************************************
         * SALIDA DE DATOS
         * ***********************************************************************/
        // Se muestra el nivel final de seguridad de nuestra contraseña

        System.out.printf(resultado, nivelSeguridad);
        // Se muestra la cantidad de contraseñas más utilizadas que forman parte de nuestro password
        System.out.println("\nTu contraseña tiene partes de contraseñas mas utilizadas " + contadorPartesMasUsadas + " vece(s)");
    }

}
