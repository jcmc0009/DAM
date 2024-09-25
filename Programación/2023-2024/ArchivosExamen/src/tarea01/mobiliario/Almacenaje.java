/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Esta clase sirve para representar el concepto genérico de mueble que permite
 * guardar o almacenar.
 *
 * @author José Carlos Manjón Carrasco
 * @version 1
 */
public abstract class Almacenaje extends Mueble implements Personalizable {

    private double anchura, altura;
    /**
     * Número máximo de módulos que se le pueden añadir al mueble de almacenaje
     * (entero)
     */
    protected final int numMaximoModulos;
    /**
     * Este atributo se usará para contar el número de modulos añadidos
     */
    protected int numModulos = 0;
    /**
     * Cantidad mínima de módulos, siendo este un número entero
     * {@value MIN_MODULOS}
     */
    public final static int MIN_MODULOS = 1;
    /**
     * Cantidad máxima de módulos, siendo este un número entero
     * {@value MAX_MODULOS}
     */
    public final static int MAX_MODULOS = 20;

    /**
     * Con este constructor creamos una instancia de la clase Asiento, la cual
     * hereda de Mueble
     *
     * @param precio Precio del armario
     * @param descripcion Pequeña descripción del armario
     * @param anchura Describimos la anchura
     * @param altura Describimos la altura
     * @param numMaximoModulos Introducimos el número entero que definirá el
     * número máximo de módulos que podrá tener la instancia de Almacenaje
     * @throws IllegalArgumentException Se lanzará esta excepción cuando se
     * trate de crear una instancia de la clase Almacenaje con un número de
     * módulos fuera del rango permitido
     */
    public Almacenaje(double precio, String descripcion, double anchura, double altura, int numMaximoModulos) throws IllegalArgumentException {
        super(precio, descripcion);

        this.numMaximoModulos = numMaximoModulos;

        if (this.numMaximoModulos < MIN_MODULOS || this.numMaximoModulos > MAX_MODULOS) {
            throw new IllegalArgumentException("Error: No se puede crear el mueble de almacenaje. El número de  modulos no está en el rango permitido:" + this.numMaximoModulos);

        }

        this.anchura = anchura;
        this.altura = altura;

    }

    /**
     * Método que devuelve la altura
     *
     * @return Altura
     */
    public double getAltura() {
        return altura;
    }

    /**
     * Método que devuelve la anchura
     *
     * @return Anchura
     */
    public double getAnchura() {
        return anchura;
    }

    /**
     * Método que devuelve la cantidad de módulos que tiene la instancia
     *
     * @return Cantidad de módulos que tiene la instancia
     */
    public int getNumModulos() {
        return numMaximoModulos;
    }

    /**
     * Método que devuelve la cantidad máxima de módulos que tiene la instancia
     *
     * @return Cantidad máxima de módulos que puede tener
     */
    public int getNumMaximoModulos() {
        return numMaximoModulos;
    }

    @Override
    public String toString() {
        return String.format("tipo:%s Anchura:%.2f Altura:%.2f Módulos máximos:%d Módulos añadidos:%s",
                super.toString(),
                this.getAnchura(),
                this.getAltura(),
                this.getNumMaximoModulos(),
                this.getNumModulos());
    }

    @Override
    public String obtenerModulos() {
        for (int i = 0; i <= numMaximoModulos; i++) {
            return obtenerModulos();
        }
        return obtenerModulos();
    }

    /**
     * Método que devuelve la cantidad de módulos añadidos
     *
     * @return Cantidad de módulos añadidos
     */
    public int getModulosAnyadidos() {

        return numModulos;
    }

    /**
     * Método que elimina módulos de la instancia
     *
     * @throws IllegalStateException Se lanza un error cuando se trata de
     * eliminar un módulo cuando la instancia ya está en la cantidad mínima , {@value MIN_MODULOS
     * }
     */
    public int extraerModulo(Modulo modulo) throws IllegalStateException {

        if (numModulos == MIN_MODULOS) {
            throw new IllegalStateException("Error: no se puede quitar el módulo. El número de módulos no puede ser inferior a" + MIN_MODULOS);
        }
        return numModulos -= 1;
    }

    /**
     * Método usado para obtener el nombre de los módulos presentes en la
     * instancia
     *
     * @return Devuelve una cadena de tipo String con los módulos presentes en
     * la instancia
     *
     */
    public String[] obtenerModulos(Modulo[] modulo) {
        String[] nombresModulos = new String[modulo.length];
        for (int i = 0; i < modulo.length; i++) {
            nombresModulos[i] = modulo[i].toString();

        }
        return nombresModulos;
    }
//obtenerModulos(), que devolverá en una cadena el contenido del array de módulos;}

}
