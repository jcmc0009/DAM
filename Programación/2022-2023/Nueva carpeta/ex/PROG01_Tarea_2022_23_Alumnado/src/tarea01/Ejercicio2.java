/**
 *
 * Ejercicio 2.  Operadores aritmeticos, realización de diversos cálculos introduciendo 3 números
 *
 * @José Carlos Manjón Carrasco
 */
package tarea01;

import java.util.Scanner;

public class Ejercicio2 {

    public static void main(String[] args) {
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------
        String parImpar, tercero, cuarto, quinto2;
        double numero1, numero2, numero3, sumaDivision, sumaNumeros, divisionNumero2, cuadradoNumero1, tripleNumero2, quinto1;
        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        //Se piden los datos por pantalla y se almacenan 
        System.out.println("Introduccion de datos");
        System.out.println("--------------------");
        System.out.println("Introduce número 1");
        numero1 = teclado.nextInt();
        System.out.println("Introduce número 2");
        numero2 = teclado.nextInt();
        System.out.println("Introduce número 3");
        numero3 = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        //He comentado los diferentes cálculos para mostrar True o False, en lugar del texto 
        
        sumaDivision = (numero1 + numero2) / numero3;
        sumaNumeros = numero1 + numero2 + numero3;
        parImpar = (sumaNumeros % 2 == 0) ? "La suma es par" : "La suma es impar";
        //parImpar = (sumaNumeros % 2 == 0) ? "True" : "False";
        tercero = (numero1 % numero2 != 0) ? "Igual a 0" : "Distinto a 0";
        //tercero = (numero1 % numero2 != 0) ? "True" : "False";
        /*el cálculo de la cuarta pregunta, se podría hacer enn una línea, metiendo el valor de la variable divisionNumero2 en la siguiente linea
        pero he preferido hacerlo así por sencillez*/
        divisionNumero2 = numero2 / 2;
        cuarto = ((numero1 * divisionNumero2) > numero3) ? "Mayor que número 3" : "Menor que número 3";
        //cuarto = ((numero1 * divisionNumero2) > numero3) ? "True" : "False";
        /*Para el cálculo dela quinta comprobación , he preferido hacer pequeños cálculos , y luego una comparación más sencilla,
        aunque podría hacerse todo en una línea, pero complicaría la lectura y debugueo si fuera necesario
         */
        cuadradoNumero1 = numero1 * numero1;
        tripleNumero2 = numero2 * 3;
        quinto1 = ((cuadradoNumero1 - tripleNumero2) * numero3);
        quinto2 = (quinto1 < 0 ? "Menor 0" : "Mayor 0");
        //quinto2 = (quinto1 < 0 ? "True" : "False";
        // todos los cálculos
        
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println("Resultados");
        System.out.println("Resultado suma de los dos primeros números divididos por el tercer número es " + sumaDivision);
        System.out.println();
        System.out.println("¿Suma de los 3 números es par? " + parImpar);
        System.out.println();
        System.out.println("¿El resto del primer número dividido por el segundo número es distinto de 0 ? " + tercero);
        System.out.println();
        System.out.println("¿Mayor que número 3? " + cuarto);
        System.out.println();
        System.out.println("¿El resultado del cuadrado del primer número menos el triple del segundo número por el tercer número es menor que 0? " + quinto2);
        System.out.println("Fin del programa.");

    }
}
