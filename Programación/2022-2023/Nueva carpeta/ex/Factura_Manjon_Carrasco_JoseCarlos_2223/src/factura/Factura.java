/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package factura;

import java.time.LocalDate;

/**
 *
 * @author Profesor modificado por alumno José Carlos Manjón Carrasco
 */
public class Factura {
    // Atributos de la clase

    private int numeroFactura;
    private LocalDate fechaEmision;
    private double baseImponible;
    private double porcentajeIva;
    private double descuento;

    // Constructor
    public Factura(int numeroFactura, LocalDate fechaEmision, double baseImponible) {
        this.numeroFactura = numeroFactura;
        this.fechaEmision = fechaEmision;
        this.baseImponible = baseImponible;
        this.porcentajeIva = 21; // Valor por defecto del IVA en España
        this.descuento = 0; // No se aplica descuento por defecto
    }

    // Método para calcular el total de la factura
    public double calcularTotal() throws Exception {
        double iva = baseImponible * porcentajeIva / 100;

        if (porcentajeIva < 0) {
            throw new Exception("Iva negativo");
        } else if (porcentajeIva > 21) {
            throw new Exception("Iva mayor que 21.0");
        } else if (porcentajeIva == 0) {
            throw new Exception("Iva igual a 0");
        }
        if (baseImponible > 0.0) {

        } else if (baseImponible < 0.0) {
            throw new Exception("Base imponible menor que 0");
        } else if (baseImponible == 0.0) {
            throw new Exception("Base imponible igual a 0");
        }
        if (descuento < 0) {
            throw new Exception("Descuento negativo");
        } else if (descuento > (baseImponible + iva)) {
            throw new Exception("Descuento fuera de rango ");
        }
        return baseImponible + iva - descuento;
    }
    // Getters

    public int getNumeroFactura() {
        return numeroFactura;
    }

    public LocalDate getFechaEmision() {
        return fechaEmision;
    }

    public double getBaseImponible() {
        return baseImponible;
    }

    public double getPorcentajeIva() {
        return porcentajeIva;
    }

    public double getDescuento() {
        return descuento;
    }

    //Setters
    public void setPorcentajeIva(double porcentajeIva) {
        this.porcentajeIva = porcentajeIva;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

}
