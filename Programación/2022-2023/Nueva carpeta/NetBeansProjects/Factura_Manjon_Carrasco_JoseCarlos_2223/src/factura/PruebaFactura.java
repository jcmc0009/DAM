/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

import java.time.LocalDate;

/**
 *
 * @author Profesor
 */
public class PruebaFactura {

    public static void main(String[] args) throws Exception {
        int numeroFactura = 12345;
        LocalDate fechaEmision = LocalDate.of(2022, 1, 1);
        double baseImponible = 100.0;

        Factura miFactura = new Factura(numeroFactura, fechaEmision, baseImponible);
        double total = miFactura.calcularTotal();
        System.out.println("Total de la factura: " + total);

        int numero = miFactura.getNumeroFactura();
        System.out.println("Número de factura: " + numero);
    }
}
