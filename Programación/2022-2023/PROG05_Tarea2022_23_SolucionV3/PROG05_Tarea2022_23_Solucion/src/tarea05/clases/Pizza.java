package tarea05.clases;

import utilidades.ES;

/**
 * Clase Pizza con la que trabajaremos con pizzas.
 *
 * @author Profe
 */
public class Pizza {

    public static int numeroDePizzasCreadas = 0;
    private String tamanho;
    private String tipo;

    /**
     * Contructor por defecto, que irá preguntando los datos para crear el
     * objeto.
     *
     * @throws Exception Si se intenta crear más pizzas de lo permitido por
     * pedido.
     */
    public Pizza() throws Exception {

        if (Pizza.numeroDePizzasCreadas < Configuracion.MAXIMO_DE_PIZZAS_POR_PEDIDO) {
            ES.msgln("Añadiendo Pizza");
            ES.msgln("------------------");
            setTamanho();
            setTipo();
        } else {
            throw new Exception("Ya se han pedido " + Configuracion.MAXIMO_DE_PIZZAS_POR_PEDIDO + " pizzas, no puedes pedir más.");
        }

    }

    /**
     * Constructor de pizza sabiendo
     *
     * @param tamaño Definimos el tamaño de la pizza.
     * @param tipo Definimos el tipo de pizza.
     */
    public Pizza(String tamaño, String tipo) {
        this.tamanho = tamaño;
        this.tipo = tipo;
        Pizza.numeroDePizzasCreadas++;
    }
    
    /**
     * Método que usaremos para conocer el tamaño de la pizza.
     * @return El tamaño de la pizza.
     */
    public String getTamanho() {
        return tamanho;
    }

    /**
     * Método que usaremos para conocer el tipo de la pizza.
     * @return El tipo de la pizza
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Método que calculará el precio final de la pizza en función a tamaño y el
     * tipo.
     *
     * @return Devuelve el importe de la pizza.
     */
    public float getPrecio() {
        float precioTamanho = 0;
        float precioTipo = 0;

        switch (tamanho) {
            case "pequenho":
                precioTamanho = Configuracion.BASE_PEQUENHA;
                break;
            case "mediano":
                precioTamanho = Configuracion.BASE_MEDIANA;
                break;
            case "grande":
                precioTamanho = Configuracion.BASE_GRANDE;
                break;
        }

        switch (tipo) {
            case "margarita":
                precioTipo = Configuracion.PIZZA_MARGARITA;
                break;
            case "barbacoa":
                precioTipo = Configuracion.PIZZA_BARBACOA;
                break;
            case "carbonara":
                precioTipo = Configuracion.PIZZA_CARBONARA;
                break;
            case "4Estaciones":
                precioTipo = Configuracion.PIZZA_4ESTACIONES;
                break;
        }

        return (precioTamanho + precioTipo);
    }

    @Override
    public String toString() {
        String tamanhoPizza;
        
        tamanhoPizza = this.tamanho;
        if (tamanhoPizza == "pequenho") { // Comprobamos si debemos mostrar correctamente la ñ
            tamanhoPizza = "pequeño";
        }
        
        return ("Pizza de tamaño " + tamanhoPizza + ", del tipo " + this.tipo + ", y su precio es de " + String.format("%.2f", this.getPrecio()) + " €.");
    }

    /**
     * Metodo interno que usaremos para preguntara el tamaño de la pizza al usuario y guardarlo.
     */
    private void setTamanho() {
        int opcionElegida;

        ES.msgln("¿Qué tamaño de Pizza desea?");
        ES.msgln("1.- Base pequeña.");
        ES.msgln("2.- Base mediana.");
        ES.msgln("3.- Base grande.");
        opcionElegida = ES.leeEntero("elija una opción:", 1, 3);
        switch (opcionElegida) {
            case 1:
                this.tamanho = "pequenho";
                break;
            case 2:
                this.tamanho = "mediano";
                break;
            case 3:
                this.tamanho = "grande";
                break;
        }
    }

    /**
     * Metodo interno que usaremos para preguntara el tipo de la pizza al usuario y guardarlo.
     */
    private void setTipo() {
        int opcionElegida;

        ES.msgln("¿Qué tipo de pizza desea?");
        ES.msgln("1.- margarita.");
        ES.msgln("2.- barbacoa.");
        ES.msgln("3.- carbonara.");
        ES.msgln("4.- Cuatro Estaciones.");
        opcionElegida = ES.leeEntero("elija una opción:", 1, 4);
        switch (opcionElegida) {
            case 1:
                this.tipo = "margarita";
                break;
            case 2:
                this.tipo = "barbacoa";
                break;
            case 3:
                this.tipo = "carbonara";
                break;
            case 4:
                this.tipo = "4Estaciones";
                break;
        }
    }
}
