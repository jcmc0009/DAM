/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea02;

/**
 *
 * @author JCMCarra
 */
public class prueba {

    public static void main(String[] args) {
        /* int numero = 4;
        int contador = 1;
        int acumulador = 0;
        while (contador <= numero) {
            acumulador += contador;
            contador++;
        }
        System.out.println(contador);
        System.out.print(acumulador);*/
        int numero = 7;
        int contador;
        int resultado = 0;
        contador = 1;
        do {
            resultado = contador * numero;
            System.out.println(numero + " x " + contador + " = " + resultado);
            contador++;
        } while (contador <= 10);
        
        System.out.println(resultado);
    }
}
