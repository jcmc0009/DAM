
import java.util.Random;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author atecaiestrassierra
 */
public class JuegoDeDados {

    public static void main(String args[]) {
        Dado dado1 = new Dado();
        Dado dado2 = new Dado(4);
        Dado dado3 = new Dado(20);
        boolean continuar = true;
        int intentos = 0;
        dado3 = dado1;
        do {

            dado1.tirarDado();
            dado2.tirarDado();
            dado3.tirarDado();
            if (dado1.obtenerValorDado() == 1 && dado2.obtenerValorDado() == 1) {
                System.out.println("Has Ganado - OJOS de SERPIENTE");
                continuar = false;
            } else {
                System.out.println("Has perdido: " + dado1.obtenerValorDado() + " - " + dado2.obtenerValorDado());

            }
            intentos++;
        } while (continuar);
        System.out.println("Has obtenido los ojos de serpiente en " + intentos + " intentos");
    }
}
