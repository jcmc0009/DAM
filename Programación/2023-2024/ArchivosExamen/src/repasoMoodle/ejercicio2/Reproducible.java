/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ejercicio2;

/**
 *
 * @author JCMCarra
 */
public interface Reproducible {

    static final int NUMEROPISTAS = 1;
    static final String FORMATO = Audiolibro.FORMATO;

    /*
    public int obtenerNumeroPistas() throws Exception;

    public int obtenerNumeroReproducciones();

    public String obtenerFormato();*/
    public String reproducir();
}
