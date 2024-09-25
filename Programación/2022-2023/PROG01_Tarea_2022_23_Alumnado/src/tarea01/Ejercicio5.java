/**
 *
 * Ejercicio 5.  Venta de pienso para animales
 *Cálculo de importes con y sin IVA , aplicando un descuento en base al número de sacos a comprar
 *
 * @José Carlos Manjón Carrasco
 */
package tarea01;

import java.util.Scanner;

public class Ejercicio5 {

    /**
     *
     * @param args the command line arguments
     *
     */
    public static void main(String[] args) {

        // TODO code application logic here
        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //               Variables entrada
        //----------------------------------------------
        int sacos;

        double cantidadConIva, porcentajeDescuento, descuento, cantidadNoIva, porcentajeIva;

        //----------------------------------------------
        //               constantes
        //----------------------------------------------
        final double PRECIOSACO = 9.75;
        final double IVA = 10;
        //----------------------------------------------
        //               Entrada de datos
        //----------------------------------------------
        System.out.println("Introduce el número de sacos que quiere comprar el cliente: ");

        sacos = teclado.nextInt();

        //----------------------------------------------
        //               procesamiento
        //----------------------------------------------
        descuento = (sacos <= 5) ? 0.0 : 5.5;
        descuento = (sacos > 8) ? 10.3 : descuento;
        //porcentajeDescuento, se podría meter el valor en cantidadNoIva, pero creo simplifica más la lectura así
        porcentajeDescuento = ((100.0 - descuento) / 100);
        cantidadNoIva = sacos * PRECIOSACO * porcentajeDescuento;
        //porcentajeIva, se podría meter el valor en cantidadConIva, pero creo simplifica más la lectura así
        porcentajeIva = ((100 + IVA) / 100);
        cantidadConIva = (cantidadNoIva * porcentajeIva);

        //----------------------------------------------
        //              Salida de resultados
        //----------------------------------------------
        System.out.println("El cliente va a comprar un total de " + sacos + " sacos");
        System.out.print("Se aplicará un descuento del " + descuento + "%\n");
        System.out.printf("Importe aplicando descuento pero sin iva es de %.2f€\n", cantidadNoIva);
        System.out.printf("Importe total(incluyendo IVA y descuento) es de %.2f€\n", cantidadConIva);
        System.out.println("El importe total (IVA incluido) asciende a " + (int) cantidadConIva + "€\n");

    }

}
