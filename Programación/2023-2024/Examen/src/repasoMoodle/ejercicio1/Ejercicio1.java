/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package repasoMoodle.ejercicio1;

/**
 *
 * @author JCMCarra
 */
public class Ejercicio1 {
    
    public static void main(String[] args) {
        
        try {
            Pizza pizza = new Pizza("");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        
        try {
            
            Pizza pizzaDos = new Pizza("  ");
            
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        Pizza pizza = new Pizza("Prueba");
        //pizza.addIngredientes(Ingrediente.CEBOLLA, Ingrediente.CHAMPIÑONES, Ingrediente.TOMATE, Ingrediente.CEBOLLA);
        Ingrediente[] listaIngredientes = {Ingrediente.CEBOLLA, Ingrediente.CHAMPIÑONES, Ingrediente.TOMATE, Ingrediente.CEBOLLA,Ingrediente.CEBOLLA};
        pizza.addIngredientes(listaIngredientes);
        System.out.println(pizza.getIngredientes());
        pizza.eliminarIngredienteCompletamente(Ingrediente.CEBOLLA);
        System.out.println(pizza.getIngredientes());
        
    }
}
