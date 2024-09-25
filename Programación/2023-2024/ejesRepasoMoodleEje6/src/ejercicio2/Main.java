/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import static ejercicio2.Reproducible.NUMEROPISTAS;

/**
 *
 * @author JCMCarra
 */
public class Main {

    public static void main(String[] args) {
        try {
            Audiolibro prueba = new Audiolibro("", 12, 12, "WAW");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Audiolibro prueba = new Audiolibro("test", 0, 12, "WAW");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        try {
            Audiolibro prueba = new Audiolibro("tesyth", 0.5, 22, "WAW");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            Audiolibro prueba = new Audiolibro("tesyth", 12, 10, "oWAW");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        Audiolibro prueba = new Audiolibro("tesyth", 12, 15, "wav");
        System.out.println(prueba.toString() + "\n Número reproducciones " + prueba.obtenerNumeroReproducciones());
        System.out.println(prueba.reproducir());
        System.out.println("Número reproducciones " + prueba.obtenerNumeroReproducciones());
        System.out.println(prueba.reproducir());
        System.out.println(prueba.toString() + "\n Número reproducciones " + prueba.obtenerNumeroReproducciones());

    }

}
