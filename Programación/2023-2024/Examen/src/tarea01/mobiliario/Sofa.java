/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 * Esta clase sirve para representar el concepto de Sofá
 *
 * @author José Carlos Manjón Carrasco
 * @version 1
 */
public final class Sofa extends Asiento {

    private final String composicion;

    /**
     * Método que devuelve la composición del sofá
     *
     * @return Composición del sofá
     */
    public String getComposicion() {
        return composicion;
    }

    /**
     * Con este constructor creamos una instancia de tipo Sofá
     *
     * @param precio Precio del sofá
     * @param descripcion Pequeña descripción del sofá
     * @param numPlazas Anchura determinada del sofá
     * @param tapiceria Altura determinada del sofá
     * @param color Número máximo de módulos que permitirá el sofá
     * @param composicion Número de puertas que tendrá el sofá
     * @throws IllegalArgumentException Se lanzará esta excepción cuando se
     * trate de crear un sofá con un número de plazas fuera del rango permitido
     * {@value MIN_PLAZAS} y {@value MAX_PLAZAS }
     */
    public Sofa(double precio, String descripcion, int numPlazas, String tapiceria, String color, String composicion) throws IllegalArgumentException {
        //llamamos al constructor padre, (comprobación y asignación de atributos de la superclase

        super(precio, descripcion, tapiceria, color, numPlazas);
        this.composicion = composicion;
        this.numPlazas = numPlazas;
        if (this.numPlazas < mobiliario.Asiento.MIN_PLAZAS || this.numPlazas > mobiliario.Asiento.MAX_PLAZAS) {
            throw new IllegalArgumentException("El número de plazas no está en el rango permitido:" + numPlazas);

        }

    }

    /**
     * Método que devuelve en una cadena tipo String toda la información por
     * heredar de la clase Mueble además de la composición del sofá
     *
     * @return Devuelve una cadena String con toda la información
     */
    @Override
    public String toString() {

        return String.format("%s Composicion: %s",
                super.toString(),
                this.getComposicion()
        );
    }
}
