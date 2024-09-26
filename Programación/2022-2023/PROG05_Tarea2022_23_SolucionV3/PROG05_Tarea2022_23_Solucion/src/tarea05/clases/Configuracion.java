package tarea05.clases;

import utilidades.ES;

/**
 * Clase que nos servirá para la configuración del sistema
 * @author Profe
 */
public class Configuracion {
    
    // Número máximo de pizzas por pedido.
    public static final int MAXIMO_DE_PIZZAS_POR_PEDIDO = 3;
    
    //Precios según tamaños.
    final static float BASE_PEQUENHA = 5f;
    final static float BASE_MEDIANA = 9f;
    final static float BASE_GRANDE = 13f;
    
    //Precios según el tipo de pizza.
    final static float PIZZA_MARGARITA = 1f;
    final static float PIZZA_CARBONARA = 4f;
    final static float PIZZA_BARBACOA = 6f;
    final static float PIZZA_4ESTACIONES = 5f;
    
    public static String getConfiguraciones(){
        String resumen ="";
        resumen += "Parámetros de configuración de la aplicación - Pedidos de pizzas.\n";
        resumen += "Número máximo de pizzas por pedido: "  + Configuracion.MAXIMO_DE_PIZZAS_POR_PEDIDO +  ".\n";
        resumen += "Precio de base pequeña: "  + String.format("%.2f", Configuracion.BASE_PEQUENHA) +  " €.\n";
        resumen += "Precio de base mediana: "  + String.format("%.2f", Configuracion.BASE_MEDIANA) +  " €.\n";
        resumen += "Precio de base grande: "  + String.format("%.2f", Configuracion.BASE_GRANDE) +  " €.\n";
        return resumen;
    }
    
}
