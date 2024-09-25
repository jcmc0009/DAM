/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mobiliario;

/**
 **Esta clase representa la idea de asiento.
 *
 * @author José Carlos Manjón Carrasco
 * @version 1
 *
 */
public class Asiento extends Mueble {

    /**
     * Número de plazas que tiene los objetos de la clase Asiento y las clases
     * que hereden de el
     */
    protected int numPlazas;
    private String tapiceria, color;
    /**
     * Mínimo de plazas que podrá tener , siendo este {@value MIN_PLAZAS }
     */
    public final static int MIN_PLAZAS = 1;
    /**
     * Máximo de plazas que podrá tener , siendo este {@value MAX_PLAZAS }
     */
    public final static int MAX_PLAZAS = 9;

    /**
     * Con este constructor creamos una instancia de la clase Asiento, la cual
     * hereda de Mueble
     *
     * @param precio Precio del armario
     * @param descripcion Pequeña descripción del armario
     * @param tapiceria Describimos la tapicería
     * @param color Describimos el color
     * @param numPLazas Introducimos el número entero de plazas que tendrá
     * @throws IllegalArgumentException Se lanzará esta excepción cuando se
     * trate de crear una instancia de la clase Asiento con un número de plazas
     * fuera del rango permitido
     */
    public Asiento(double precio, String descripcion, String tapiceria, String color, int numPlazas) throws IllegalArgumentException {
        //llamamos al constructor padre, (comprobación y asignación de atributos de la superclase
        super(precio, descripcion);
        this.tapiceria = tapiceria;
        this.numPlazas = (int) numPlazas;
        this.color = color;
        this.numPlazas = numPlazas;

        if (this.numPlazas < MIN_PLAZAS || this.numPlazas > MAX_PLAZAS) {
            throw new IllegalArgumentException("El número de plazas no está en el rango permitido:" + numPlazas);

        }

    }

    /**
     * Devuele el número de plazas que tendrá la instancia de la clase Asiento
     *
     * @return Número de plazas
     */
    public int getNumPlazas() {
        return numPlazas;
    }

    /**
     * Devuelve en la descripción de la tapicería
     *
     * @return Tapicería
     */
    public String getTapiceria() {
        return tapiceria;
    }

    /**
     * Devuelve en la descripción del color
     *
     * @return Color de la instancia de la clase Asiento
     */
    public String getColor() {
        return color;
    }

    /**
     * Método que devuelve en una cadena tipo String toda la información por
     * heredar de la clase Mueble además de la tapicería, color, y número de
     * plazas
     *
     * @return Devuelve una cadena String con toda la información
     */
    @Override
    public String toString() {
        return String.format("%s Tapiceria:%s Color:%s Número de plazas:%d",
                super.toString(),
                this.getTapiceria(),
                this.getColor(),
                this.getNumPlazas());
    }
}
