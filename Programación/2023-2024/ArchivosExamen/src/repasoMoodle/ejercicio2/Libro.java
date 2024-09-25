/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author JCMCarra
 */
public abstract class Libro {

    private String titulo, formato;

    private double precio;

    public Libro(String titulo, double precio) {
        this.titulo = titulo;

        this.precio = precio;

        if (titulo == null || titulo.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("Precio inválido");
        }

    }

    @Override
    public String toString() {
        return "Libro" + "titulo=" + titulo + ", formato=" + formato + ", precio=" + precio;
    }
}
