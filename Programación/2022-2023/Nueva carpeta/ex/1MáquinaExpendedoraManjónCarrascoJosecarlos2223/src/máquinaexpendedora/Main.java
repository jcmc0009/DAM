/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package máquinaexpendedora;

/**
 *
 * @author efech
 * @version 1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        MáquinaExpendedora snack;

        snack = new MáquinaExpendedora(13, 2, 5);
        sube1_PrecioManjonCarrascoJoseCarlos2223(snack);

        sube2_PrecioManjonCarrascoJoseCarlos2223(snack);

        obtener1_UnidadesManjonCarrascoJoseCarlos2223(snack);

        obtener2_UnidadesManjonCarrascoJoseCarlos2223(snack);

        obtener3_UnidadesManjonCarrascoJoseCarlos2223(snack);

    }

    private static void obtener3_UnidadesManjonCarrascoJoseCarlos2223(MáquinaExpendedora snack) {
        /*Vamos a intentar sacar 12 snack, y tengo 50 euros.
        Como no hay unidades suficientes en la mÃ¡quina saltarÃ¡
        una excepciÃ³n y no se modificarÃ¡ el nÂº de unidades de la tienda*/
        try {
            System.out.println("3Âº.- Vamos a sacar snacks (queremos 12 y tenemos 50 â‚¬)");
            //snack.sacarsnack(12, 50, pegatina);
            snack.sacarsnack(12, 50, "pegatina");
            System.out.println("OperaciÃ³n realizada, ahora tiene " + snack.obtenerUnidades() + " unidades en la mÃ¡quina");
        } catch (Exception e) {
            System.out.println("Error al sacar snack,porque no hay suficientes unidades");
            System.out.println("El nÂº de unidades sigue siendo: " + snack.obtenerUnidades());

        }
    }

    private static void obtener2_UnidadesManjonCarrascoJoseCarlos2223(MáquinaExpendedora snack) {
        /*Vamos a intentar sacar 2 snack, y tengo 9 euros.
        Ahora se actualizarÃ¡ el nÃºmero de snack que tenemos en
        la mÃ¡quina*/
        try {
            System.out.println("2Âº.- Vamos a sacar snacks (queremos 2 y tenemos 9 â‚¬)");
            snack.sacarsnack(2, 9, "pegatina");
            System.out.println("OperaciÃ³n realizada, ahora tiene " + snack.obtenerUnidades() + " unidades en la mÃ¡quina");
        } catch (Exception e) {
            System.out.println("Error al sacar snack,porque no hay suficientes dinero");
            System.out.println("El nÂº de unidades sigue siendo: " + snack.obtenerUnidades());

        }
    }

    private static void obtener1_UnidadesManjonCarrascoJoseCarlos2223(MáquinaExpendedora snack) {
        /*Vamos a intentar sacar 2 snack, y tengo 5 euros.
        Como no hay dinero suficiente saltarÃ¡
        una excepciÃ³n y no se modificarÃ¡ el nÂº de unidades de la tienda*/
        try {
            System.out.println("1Âº.- Vamos a sacar snacks (queremos 2 y tenemos 5 â‚¬)");
            snack.sacarsnack(2, 5, "pegatina");

            System.out.println("OperaciÃ³n realizada, ahora tiene " + snack.obtenerUnidades() + " unidades en la mÃ¡quina");
        } catch (Exception e) {
            System.out.println("Error al sacar snack,porque no hay suficientes dinero");
            System.out.println("El nÂº de unidades sigue siendo: " + snack.obtenerUnidades());

        }
    }

    private static void sube2_PrecioManjonCarrascoJoseCarlos2223(MáquinaExpendedora snack) {
        /*Vamos a aumentar el precio 3â‚¬, como supera el precio mÃ¡ximo establecido la operaciÃ³n
        no tendrÃ¡ Ã©xito y se mantendrÃ¡ el precio anterior*/
        try {
            System.out.println("Vamos a aumentar el precio de venta de un snack por encima del precio mÃ¡ximo");
            snack.aumentarPrecio(3);
            System.out.println("El precio actual es " + snack.obtenerPrecio() + " â‚¬");
        } catch (Exception e) {
            System.out.println("Error al aumentar el precio porque se supera el precio mÃ¡ximo de 5 â‚¬");
        }
    }

    private static void sube1_PrecioManjonCarrascoJoseCarlos2223(MáquinaExpendedora snack) {
        /*Vamos a aumentar el precio 1â‚¬, como no supera el precio mÃ¡ximo establecido la operaciÃ³n
        tendrÃ¡ Ã©xito y el nuevo precio serÃ¡ de 3â‚¬*/
        try {
            System.out.println("Vamos a aumentar el precio de venta de un snack por debajos del precio mÃ¡ximo");
            snack.aumentarPrecio(1);
            System.out.println("El precio actual es " + snack.obtenerPrecio() + " â‚¬");
        } catch (Exception e) {
            System.out.println("Error al aumentar el precio");
        }
    }
}
