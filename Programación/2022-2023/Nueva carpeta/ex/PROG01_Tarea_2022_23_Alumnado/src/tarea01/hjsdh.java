/**
 *
 * Ejercicio 2.  Signos del zodiaco. 
 * Se trata de devolver el signo zodiacal en base a una fecha dada
 *
 * @José Carlos Manjón Carrasco
 */
package tarea01;

import java.io.PrintStream;
import java.util.Scanner;

public class hjsdh {

    public static void main(String[] args) {
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------

        //double numero1, numero2, numero3, sumaDivision, sumaNumeros, divisionNumero2, cuadradoNumero1, tripleNumero2, quinto1;
        int mes, dia;
        String signoZodiaco="";
        
        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("¿Mes?");
        mes = teclado.nextInt();
        System.out.println("¿día?");
        dia = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        //Para la fecha insertada 22/01 , el signo es Acuario
        switch (mes) {
            case 1: {
                if (dia >= 21 & dia<=31) {
                    
                    //System.out.printf("Importe aplicando descuento pero sin iva es de %.2f€\n", cantidadNoIva);
                    System.out.printf("Para la fecha insertada %02d/"+"%02d,el signo es Acuario",dia,mes);
                  
                  System.out.println();
                   //System.out.printf("Para la fecha insertada "+dia+"/"+ ", por lo que el signo es "+ signoZodiaco+"\n");
                    //System.out.printf( "%02d %n",mes);
                } else if (dia > 1 & dia < 21) {
                 System.out.printf("Para la fecha insertada %02d/"+"%02d,el signo es Capricornio",dia,mes);
                 System.out.println();
                } else  {
                    System.out.println("Fecha incorrecta");
                }
                 break;
            }
            case 2: {
                if (dia >= 20 & dia<=29) {
                    signoZodiaco="Piscis";
                } else if (dia > 1 & dia < 20) {
                    signoZodiaco="Acuario";
                } else  {
                    System.out.println("Fecha incorrecta");
                }
                  break;
            }
            case 3: {
                if (dia >= 21 & dia<=31) {
                  signoZodiaco="Aries";
                } else if (dia > 1 & dia < 21) {
                   signoZodiaco="Piscis";
                } else  {
                    System.out.println("Fecha incorrecta");
                }
                  break;
            }
            case 4: {
                if (dia >= 21 & dia<=30) {
                  signoZodiaco="Tauro";
                } else if (dia > 1 & dia < 21) {
                    signoZodiaco="Aries";
                } else  {
                    System.out.println("Fecha incorrecta");
                }
                  break;
            }
            case 5: {
                if (dia >= 22 & dia<=31) {
                  signoZodiaco="Géminis";
                } else if (dia > 1 & dia < 22) {
                   signoZodiaco="Tauro";
                } else {
                    System.out.println("Fecha incorrecta");
                }
                  break;
            }
            case 6: {
                if (dia >= 23 & dia<=30) {
                  signoZodiaco="Cáncer";
                } else if (dia > 1 & dia < 22) {
                    signoZodiaco="Géminis";
                } else {
                    System.out.println("Fecha incorrecta");
                }
                  break;
            }
            case 7 : {
                if (dia >= 24 & dia<=31) {
                  signoZodiaco="Leo";
                } else if (dia > 1 & dia < 24) {
                    signoZodiaco="Cáncer";
                } else {
                    System.out.println("Fecha incorrecta");
                }
                  break;
            }
            case 8 : {
                if (dia >= 24 & dia<=31) {
                  signoZodiaco="Virgo";
                } else if (dia > 1 & dia < 24) {
                    signoZodiaco="Leo";
                } else if (dia <= 0) {
                    System.out.println("Fecha incorrecta");
                }
                  break;
            }
            case 9 : {
                if (dia >= 24 & dia<=30) {
                  signoZodiaco="Libra";
                } else if (dia > 1 & dia < 24) {
                    signoZodiaco="Virgo";
                } else {
                    System.out.println("Fecha incorrecta");
                }
                  break;
            }
            case 10 : {
                if (dia >= 24 & dia<=31) {
                  signoZodiaco="Escorpio";
                } else if (dia > 1 & dia < 24) {
                    signoZodiaco="Libra";
                } else {
                    System.out.println("Fecha incorrecta");
                }
                  break;
            }
            case 11 : {
                if (dia >= 23 & dia<=30) {
                  signoZodiaco="Sagitario";
                } else if (dia > 1 & dia < 23) {
                    signoZodiaco="Escorpio";
                } else {
                    System.out.println("Fecha incorrecta");
                }
                  break;
            }
            case 12 : {
                if (dia >= 22 & dia<=31) {
                  signoZodiaco="Capricornio";
                } else if (dia > 1 & dia < 22) {
                    signoZodiaco="Sagitario";
                } else {
                    System.out.println("Fecha incorrecta");
                }
                  break;
            }
                      
            default:  System.out.println("Fecha incorrecta");
        }
                 
    }
    
}
            
        
 
