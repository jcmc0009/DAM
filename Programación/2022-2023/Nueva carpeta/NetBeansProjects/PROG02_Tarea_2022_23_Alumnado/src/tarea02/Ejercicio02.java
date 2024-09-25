/*
 * Ejercicio 02  Signos del Zodíaco en base a una fecha dada
 */
package tarea02;

import java.util.Scanner;

/**
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------

        int mes, dia;// sólo necesitamos 2 variables, una para el mes y otra para el día
        String signoZodiaco = "";

        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado = new Scanner(System.in);
        mes = teclado.nextInt();

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("¿Introduce el número del mes?");
        mes = teclado.nextInt();
        System.out.println("¿Introduce el número de día?");
        dia = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        /* Me baso en el número del mes, switch, de en cada case o mes,se usa if/else if para definir los rangos válidos para cada caso, 
        si se introduce un valor fuera de rango en mes el default lo cubre informando de fecha errónea, y si se introduce un valor de día fuera de rango para un mes
        concreto, se ocntrola con el else, informando de fecha incorrecta.
        
        En cuanto a fechas, se ha ignorado los años bisiestos , para el mes de Febrero tomaremos como máximo 29; 
        para los meses de Abril, Junio, Septiembre, y Noviembre tomaremos 30; y para el resto de meses 31  */
        switch (mes) {
            case 1: {
                if (dia >= 21 & dia <= 31)//rango días válidos para un horóscopo
                {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Acuario", dia, mes);
                    System.out.println();

                } else if (dia > 1 & dia < 21) {
                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Capricornio", dia, mes);
                    System.out.println();
                } else //si el día introducido no está en los rangos definidos anteriormente, el día no es válido
                {
                    System.out.println("Fecha incorrecta");
                }
                break;
            }
            case 2: {
                if (dia >= 20 & dia <= 29) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Piscis", dia, mes);
                    System.out.println();
                } else if (dia > 1 & dia < 20) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Acuario", dia, mes);
                    System.out.println();
                } else {
                    System.out.println("Fecha incorrecta");
                }
                break;
            }
            case 3: {
                if (dia >= 21 & dia <= 31) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Aries", dia, mes);
                    System.out.println();

                } else if (dia > 1 & dia < 21) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Piscis", dia, mes);
                    System.out.println();
                } else {
                    System.out.println("Fecha incorrecta");
                }
                break;
            }
            case 4: {
                if (dia >= 21 & dia <= 30) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Tauro", dia, mes);
                    System.out.println();
                } else if (dia > 1 & dia < 21) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Aries", dia, mes);
                    System.out.println();
                } else {
                    System.out.println("Fecha incorrecta");
                }
                break;
            }
            case 5: {
                if (dia >= 22 & dia <= 31) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Géminis", dia, mes);
                    System.out.println();
                } else if (dia > 1 & dia < 22) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Tauro", dia, mes);
                    System.out.println();
                } else {
                    System.out.println("Fecha incorrecta");
                }
                break;
            }
            case 6: {
                if (dia >= 23 & dia <= 30) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Cáncer", dia, mes);
                    System.out.println();
                } else if (dia > 1 & dia < 22) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Géminis", dia, mes);
                    System.out.println();
                } else {
                    System.out.println("Fecha incorrecta");
                }
                break;
            }
            case 7: {
                if (dia >= 24 & dia <= 31) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Leo", dia, mes);
                    System.out.println();
                } else if (dia > 1 & dia < 24) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Cáncer", dia, mes);
                    System.out.println();
                } else {
                    System.out.println("Fecha incorrecta");
                }
                break;
            }
            case 8: {
                if (dia >= 24 & dia <= 31) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Virgo", dia, mes);
                    System.out.println();
                } else if (dia > 1 & dia < 24) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Leo", dia, mes);
                    System.out.println();
                } else if (dia <= 0) {
                    System.out.println("Fecha incorrecta");
                }
                break;
            }
            case 9: {
                if (dia >= 24 & dia <= 30) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Libra", dia, mes);
                    System.out.println();
                } else if (dia > 1 & dia < 24) {

                    System.out.printf("Para la fecha insertada %02d/" + "%02d,el signo es: Virgo", dia, mes);
                    System.out.println();
                } else {
                    System.out.println("Fecha incorrecta");
                }
                break;
            }
            case 10: {
                if (dia >= 24 & dia <= 31) {

                    System.out.printf("Para la fecha insertada %02d/" + mes + ",el signo es: Escorpio", dia);
                    System.out.println();
                } else if (dia > 1 & dia < 24) {
                    System.out.printf("Para la fecha insertada %02d/" + mes + ",el signo es: Libra", dia);
                    System.out.println();
                } else {
                    System.out.println("Fecha incorrecta");
                }
                break;
            }
            case 11: {
                if (dia >= 23 & dia <= 30) {

                    System.out.printf("Para la fecha insertada %02d/" + mes + ",el signo es: Sagitario", dia);
                    System.out.println();
                } else if (dia > 1 & dia < 23) {

                    System.out.printf("Para la fecha insertada %02d/" + mes + ",el signo es: Escorpio", dia);
                    System.out.println();
                } else {
                    System.out.println("Fecha incorrecta");
                }
                break;
            }
            case 12: {
                if (dia >= 22 & dia <= 31) {

                    System.out.printf("Para la fecha insertada %02d/" + mes + ",el signo es: Capricornio", dia);
                    System.out.println();
                } else if (dia > 1 & dia < 22) {

                    System.out.printf("Para la fecha insertada %02d/" + mes + ",el signo es: Sagitario", dia);
                    System.out.println();
                } else {
                    System.out.println("Fecha incorrecta");
                }
                break;
            }

            default:
                System.out.println("Fecha incorrecta");
        }

    }

}
