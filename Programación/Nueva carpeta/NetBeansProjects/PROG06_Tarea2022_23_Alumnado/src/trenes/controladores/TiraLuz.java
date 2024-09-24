package trenes.controladores;

import java.util.Random;

/**
 * Clase TiraLuz.
 *
 * Esta clase hereda de la clase ControlServicio e implementa la interfaz
 * Modificable (implementa los métodos aumentar() y disminiur()) y la interfaz
 * Activable (implementa los métodos on() y off()). Representa una tira o
 * columna de luces del vagón. Este control presenta como atributos un valor de
 * estado para saber si la tira está encendida o no. La ubicación de la tira de
 * luces. Un valor entero entre 0 y 100 para controlar la intensidad de la luz.
 * Así como, tres valores enteros entre 0 y 255 (ambos inclusive) para
 * determinar el color que se quiere establecer de la tira de luz, siguiendo el
 * sistema RGB (Rojo, Verde, Azul).
 *
 * Además para gestionar posibles funcionalidades aleatorias de la tira,
 * presenta un atributo de clase de tipo Random para generar esa aleatoriedad.
 *
 * @author David - IES Trassierra
 * @version 1.0
 */
public class TiraLuz extends ControlServicio implements Activable,  Modificable {

    /*
     * Atributo intensidadTira. 
     */
    private int intensidadTira = 0;
    /*
     * Atributo valor mínimo.
    @param kjdkfjdkf
     */
    private int valorMinimo = 0;
    private int valorMaximo = 100;

    @Override
    public int getValorMinimoPosibleEstadoControl() {
        return valorMinimo;
    }

    @Override
    public int getValorMaximoPosibleEstadoControl() {
        return valorMaximo;
    }

    /*
     * Implementaión del método de la interfaz Modificable para aumentar la
     * intensidad en 10 unidades.
     */
    @Override
    public void aumentar() {
        intensidadTira += 10;
    }

    /*
     * Implementaión del método de la interfaz Modificable para aumentar la
     * intensidad en 10 unidades.
     */
    @Override
    public void disminuir() {
        intensidadTira -= 10;
    }
  
    @Override
    public void on() {
           encendida=true;
    }

    @Override
    public void off() {
       encendida=false;
    }
 /*
     * Atributo aleatorio. 
     */
    private int aleatorio;

    /*
     * Atributo encendida.
     * 
     */
    private boolean encendida;

    /*
     * Atributo ubicacionTira. 
     */
    private String ubicacionTira;

    /*
     * Atributo colorAzul.
     */
    private int colorAzul;

    /*
     * Atributo colorVerde.
     */
    private int colorVerde;

    /*
     * Atributo colorRojo. 
     */
    private int colorRojo;

    /*
     * Constructor con siete parámetros de TiraLuz. 
     */
    public TiraLuz(int aleatorio, boolean encendida, String ubicacionTira, int intensidadTira, int colorAzul, int colorVerde, int colorRojo) {
        this.aleatorio = aleatorio;
        this.encendida = encendida;
        this.ubicacionTira = ubicacionTira;
        this.intensidadTira = intensidadTira;
        this.colorAzul = colorAzul;
        this.colorVerde = colorVerde;
        this.colorRojo = colorRojo;
        this.tipoControlServicio = "Luz";
    }

    /*
     * Constructor con cuatro parámetros de TiraLuz. 
     */
    public TiraLuz(boolean encendida, String ubicacionTira, int intensidadTira, String nombreControlServicio) {
        this.encendida = encendida;
        this.ubicacionTira = ubicacionTira;
        this.intensidadTira = intensidadTira;
        this.nombreControlServicio = nombreControlServicio;
        this.tipoControlServicio = "Luz";
    }

    /*
     * Método observador (getter) estado de la tira de luz
     *
     */
    public boolean isEncendida() {
        return encendida;
    }

    /*
     * Método modificador (setter)  estado para la tira
     *
     * @param encendida valor booleano para el nuevo estado de la tira de luz.
     */
    public void setEncendida(boolean encendida) {
        this.encendida = encendida;
    }

    /*
     * Método observador (getter)  ubicación de la tira
     */
    public String getUbicacionTira() {
        return ubicacionTira;
    }

    /*
     * Método modificador (setter)  nueva ubicación a la tira 
     */
    public void setUbicacionTira(String ubicacionTira) {
        this.ubicacionTira = ubicacionTira;
    }


    /*
     * Método observador (getter) que devuelve la intensidad de brillo 
     */
    public int getIntensidadTira() {
        return intensidadTira;
    }

    /*
     * Método modificador (setter)  nueva intensidad de brillo     
     */
    public void setIntensidadTira(int intensidadTira) {
        this.intensidadTira = intensidadTira;
    }

    /*
     * Método observador (getter)cantidad de color azul 
     */
    public int getColorAzul() {
        return colorAzul;
    }

    /*
     * Método modificador (setter) cantidad de color azul 
     */
    public void setColorAzul(int colorAzul) {
        this.colorAzul = colorAzul;
    }

    /*
     * Método observador (getter) la cantidad de color verde 
     */
    public int getColorVerde() {
        return colorVerde;
    }

    /*
     * Método modificador (setter) cantidad de color verde 
     */
    public void setColorVerde(int colorVerde) {
        this.colorVerde = colorVerde;
    }

    /*
     * Método observador (getter) cantidad de color rojo
     */
    public int getColorRojo() {
        return colorRojo;
    }

    /*
     * Método modificador (setter) color rojo 
     */
    public void setColorRojo(int colorRojo) {
        this.colorRojo = colorRojo;
    }

    /*
     * Método estático generarColorAleatorio 
     */
 /*
    
    
    
     * Método cambiarColorTira sin parámetros 
     */
 /*
     * Método cambiarColorTira que asigna valores pasados como parámetro para
     * cambiar los valores de los atributos rojo, verde y azul 
     */
 /*
     * Implementaión del método de la interfaz Activable para encender control
     * de servicio, 
    
    public void Activable() {
        on();
    }

    /*
     * Implementaión del método de la interfaz Activable para apagar control de
     * servicio
     
    public void Activable2() {
        off();
    }
     */
 /*
     * Método toString 
     */
    @Override
    public String toString() {
        return "TiraLuz{" + "aleatorio=" + aleatorio + ", encendida=" + encendida + ", ubicacionTira=" + ubicacionTira + ", intensidadTira=" + intensidadTira + ", colorAzul=" + colorAzul + ", colorVerde=" + colorVerde + ", colorRojo=" + colorRojo + '}';
    }

}
