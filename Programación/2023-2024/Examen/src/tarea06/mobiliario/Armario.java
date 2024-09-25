/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea06.mobiliario;

import mobiliario.Personalizable;

/**
 **Esta clase representa la idea de un armario. Al ser de tipo Almacenaje,
 * heredará de esa clase y al permitir una personalización implentará los
 * métodos de dicha interfaz
 *
 * @author José Carlos Manjón Carrasco
 * @version 1
 *
 */
public final class Armario extends Almacenaje implements Personalizable {

    private final int numPuertas;
    /**
     * Número entero que indicará el mínimo de puertas que puede tener el
     * armario, siendo {@value MIN_PUERTAS }
     */
    public final static int MIN_PUERTAS = 1;
    /**
     * Número entero que indicará el máximo de puertas que puede tener el
     * armario, siendo {@value MAX_PUERTAS }
     */
    public final static int MAX_PUERTAS = 6;
    private static Modulo[] arrayModulos;
    private int contadorArray = 0;
    private String moduloAnydido = "";

    /**
     * Con este constructor creamos una instancia de tipo Armario
     *
     * @param precio Precio del armario
     * @param descripcion Pequeña descripción del armario
     * @param anchura Anchura determinada del armario
     * @param altura Altura determinada del armario
     * @param numMaximoModulos Número máximo de módulos que permitirá el armario
     * @param numPuertas Número de puertas que tendrá el armario
     * @throws IllegalArgumentException Se lanzará esta excepción cuando se
     * trate de crear un armario con un número de puertas fuera del rango
     * permitido
     */
    public Armario(double precio, String descripcion, double anchura, double altura, int numMaximoModulos, int numPuertas) throws IllegalArgumentException {

        super(precio, descripcion, anchura, altura, numMaximoModulos);
        arrayModulos = new Modulo[numMaximoModulos];
        this.numPuertas = numPuertas;
        if (this.numPuertas < MIN_PUERTAS || this.numPuertas > MAX_PUERTAS) {
            throw new IllegalArgumentException("Error: No se puede crear el armario. El número de puetas no está en el rango permitido:" + this.numPuertas);

        }

    }

    /**
     * Método que devuelve el número de puertas que tiene el armario
     *
     * @return Número entero de puertas
     */
    public int getNumPuertas() {
        return numPuertas;
    }

    /**
     * Método que devuelve en un array de tipo String los módulos que tiene el
     * mueble
     *
     *
     * @return Array de tipo String con los módulos del mueble
     */
    @Override
    public String obtenerModulos() {
        String texto = "[";
        for (Modulo arrayModulo : arrayModulos) {
            texto += arrayModulo + ",";
        }
        return texto + "]";
    }


    @Override
    public int extraerModulo() throws IllegalStateException {
        if (numModulos == MIN_MODULOS) {
            throw new IllegalStateException("Error: no se puede quitar el módulo. El número de módulos no puede ser inferior a " + MIN_MODULOS);
        } else {
            numModulos -= 1;
        }
        return numModulos;
    }

    /**
     * Método que devuelve en una cadena tipo String toda la información por
     * heredar de la clase Mueble además de la anchura, altura, número máximo de
     * módulos , cuantos módulso se han añadido y el número de puertas
     *
     * @return Devuelve una cadena String con toda la información
     */
    @Override
    public String toString() {

        return String.format("%s Anchura: %.2f Altura :%.2f Módulos máximos: %d Módulos añadidos: %d Número de puertas:%d",
                super.toString(),
                getAnchura(),
                getAltura(),
                getNumMaximoModulos(),
                getModulosAnyadidos(),
                getNumPuertas()
        );
    }

    @Override
    public void anyadirModulo(mobiliario.Modulo modulo) throws IllegalStateException, NullPointerException {

        if (modulo == null) {
            throw new IllegalStateException("El módulo no puede ser nulo");
        } else {
            int j = 0;
            for (int i = 0; i < numMaximoModulos; i++) {

                arrayModulos[i] = modulo;
                this.numModulos++;

            }

        }

        if (arrayModulos.length <= this.numMaximoModulos) {

            contadorArray++;
        } else {
            throw new IllegalArgumentException("Error: no se puede añadir el módulo balda-El número de módulos no puede superar el máximo permitido: " + this.numMaximoModulos);
        }
    }

    
}
