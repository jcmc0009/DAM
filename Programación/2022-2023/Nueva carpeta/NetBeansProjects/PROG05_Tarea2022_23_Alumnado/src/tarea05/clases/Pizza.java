/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea05.clases;

/**
 *
 * @author Jose Carlos Manjon Carrasco
 */
public class Pizza {

    private String tamanho;
    private String tipo;
    private Configuracion configuracion;
    public static int numPizzas=0;


    public Pizza() {
        int numPizza = 3;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamanho() {
        return tamanho;
    }

    public String getTipo() {
        return tipo;
    }

    public Pizza(String tamanho, String tipo) {
        this.tamanho = tamanho;
        this.tipo = tipo;
        numPizzas++;
    }

    @Override
    public String toString() {
        return "Pizza{" + "tamanho=" + tamanho + ", tipo=" + tipo + '}';
    }
   // Pizza p1 = new Pizza();
}
