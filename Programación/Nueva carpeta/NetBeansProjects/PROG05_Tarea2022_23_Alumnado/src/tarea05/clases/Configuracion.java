package tarea05.clases;

/**
 * Clase que nos servirá para la configuración del sistema
 *
 * @author Profe
 */
public class Configuracion {

    // numero maximo pizzas
    private int numPizza = 3;

    //Precios según tamaños.
    final static float BASE_PEQUENHA = 5f;
    final static float BASE_MEDIANA = 9f;
    final static float BASE_GRANDE = 13f;

    public int getNumPizza() {
        return numPizza;
    }

    //Precios según el tipo de pizza.
    final static float PIZZA_MARGARITA = 1f;
    final static float PIZZA_CARBONARA = 4f;
    final static float PIZZA_BARBACOA = 6f;
    final static float PIZZA_4ESTACIONES = 5f;

    /*public String verConfiguracion() {
        String verConfiguracion = "Parámetros de configuración de la aplicación - Pedidos de pizzas.\n";
        String verNumeroMaximoPizzas = "Número máximo de pizzas por pedido: " + numPizza;
        String tipoPizzaPequeña = "Precio de base pequeañ: " + BASE_PEQUENHA;
        return verConfiguracion + verNumeroMaximoPizzas + "Pizza pequeña: \t" + 5f + "\nPizza mediana:\t" + 9f + "\nPizza grande:\t" + 13f + "\n";
    }*/
    
    public float precioDeBase(int base){
        if(base == 1){
            return BASE_PEQUENHA;
        }
        
         if(base == 2){
            return BASE_MEDIANA;
        }
        return BASE_GRANDE;
    }
}
