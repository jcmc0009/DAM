
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author atecaiestrassierra
 */
public class Dado {
    
    // Atributos o Miembros
    private int numCaras;
    private int valorDado;
    
    
    // Constructor
    public Dado(){
        numCaras=6;
        valorDado=1;
    }
    
    public Dado(int caras){
        numCaras=caras;
        valorDado=1;
    }
    
    // Métodos
    public int obtenerValorDado(){
        return valorDado;
    }
    
    public void tirarDado(){
        Random aleatorio1 = new Random();
        // Generamos un valor de 1 a numero de caras
        valorDado = 1 + aleatorio1.nextInt(numCaras);
    }
}
