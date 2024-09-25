/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bolasorpresa;

/**
 *
 * @author Elena
 */

/** Definición clase BolaSorpresa*/
public class BolaSorpresa {
    private int unidades;//número de bolas que quedan en el dispensador
    double precio;//precio actual de una bola sorpresa
    double precioMaximo;//precio máximo que puede tener una bola sorpresa

    /** Constructor sin parámetros*/
    public BolaSorpresa() {
    }

    /** Constructor con parámetr
     * @param unidades
     * @param precio
     * @param precioMaximo*/
    public BolaSorpresa(int unidades, double precio,  double precioMaximo) {
        this.unidades = unidades;
        this.precio = precio;
        this.precioMaximo = precioMaximo;
    }

    BolaSorpresa(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int getUnidades() {
        return unidades;
    }

    public double getPrecio() {
        return precio;
    }

    public double getPrecioMaximo() {
        return precioMaximo;
    }

    public void setUnidades(int unidades) {
        this.unidades = unidades;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setPrecioMaximo(double precioMaximo) {
        this.precioMaximo = precioMaximo;
    }
    
   
       /**Método que permite sacar bolas sorpresa si  hay suficientes unidades en la máquin*/
         public void sacarBolaSorpresas(int numbolas) {
        if (this.unidades == 0) {
            System.out.println("Lo siento, pero las bolas están agotadas");
        } else if (this.unidades < numbolas){
             System.out.println("Solo hay disponibles " + this.unidades + " bolas sorpresa");
        }
        if(this.unidades >= numbolas){
            unidades = unidades - numbolas;
            System.out.println("Tenga sus " + numbolas + " bolas sorpresa. Gracias. Quedan " + unidades + " disponibles");
            
        }
    }
    
    /*Método que permite aumentar el precio de venta de una bola sorpresa, suma al precio actual 
    el aumento que se indica siempre que no se sobrepase el precio máximo de venta*/
    public void aumentarPrecio(double aumento)  {
        if (precio + aumento>this.precioMaximo){
            System.out.println("No se puede aumentar el precio porque supera el valor máximo");
         
        }else       
        { precio = precio + aumento;
        System.out.println("El nuevo precio es " + precio + " €");}
    }

}
