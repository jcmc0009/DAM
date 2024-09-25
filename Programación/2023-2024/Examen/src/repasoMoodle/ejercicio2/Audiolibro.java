/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicio2;

import org.w3c.dom.ls.LSOutput;

/**
 *
 * @author JCMCarra
 */
public class Audiolibro extends Libro implements Reproducible {

    private int numReproduccion;
    private int numeroPistas;
    private final String FORMATOWAV = "wav";
    private final String FORMATOMTRES = "mp3";
    private final String formato;
    public final static int NUMMINCANCIONES = 1;
    public final static int NUMMAXCANCIONES = 20;
    //private int vecesReproduccion = Audiolibro.numReproduccion;
    private final String TEXTOCANCIONES = "#Aquí sonaría la pista número: ";

    public Audiolibro(String titulo, double precio, int numeroPistas, String formato) {

        super(titulo, precio);

        if (numeroPistas < NUMMINCANCIONES || numeroPistas > NUMMAXCANCIONES) {
            throw new IllegalArgumentException("Numero pistas inválido");
        }

        if (!formato.trim().equalsIgnoreCase(FORMATOWAV) && !formato.trim().equalsIgnoreCase(FORMATOMTRES)) {
            throw new IllegalArgumentException("Formato inválido");
        }
        this.formato = formato;
        this.numeroPistas = numeroPistas;
        numReproduccion = 0;
    }

    @Override
    public String toString() {
        return String.format("%s Numero de pistas: %s",
                super.toString(),
                this.numeroPistas);
    }


    public int obtenerNumeroPistas() {
        return this.numeroPistas;
    }

    
    public String obtenerFormato() {
        return formato;
    }

    @Override
    public String reproducir() {

        StringBuilder textoMostrar = new StringBuilder("");
        for (int i = NUMMINCANCIONES; i <= this.numeroPistas; i++) {
            textoMostrar.append(TEXTOCANCIONES + i + "#\n");

        }
        numReproduccion++;
        return textoMostrar.toString();
    }

    public static int getNUMEROPISTAS() {
        return NUMEROPISTAS;
    }

    public static String getFORMATO() {
        return FORMATO;
    }

   
    public int obtenerNumeroReproducciones() {
        return numReproduccion;
    }

}
