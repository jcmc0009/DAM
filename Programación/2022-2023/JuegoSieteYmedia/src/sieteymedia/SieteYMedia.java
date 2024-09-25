/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sieteymedia;

import java.util.Scanner;

/**
 *
 * @author antonio
 */
public class SieteYMedia {
    Scanner teclado;
    
    static final float[] valores={1,2,3,4,5,6,7,0.5f,0.5f,0.5f};
    Mazo jugador1;
    Mazo jugador2;
    Mazo baraja;

    public SieteYMedia() {
    this.teclado = new Scanner(System.in);
    
    baraja = new Mazo("Baraja");
    jugador1 = new Mazo("Jugador 1");
    jugador2 = new Mazo("Jugador 2");
    
    baraja.crearBaraja(valores);
    baraja.barajar();
    }
    
    private boolean Turno(Mazo jugador) {
        Carta carta;
        float puntos;
        boolean r = true;
        String nombre;
        
        nombre = jugador.obtenerNombre();
        
        System.out.printf("%s",jugador.mostrar());
        System.out.println("¿Quiere carta?");
        if(quiereJugar())
        {
            carta = this.baraja.extraerCarta();
            System.out.printf("%s",carta.mostrarGrafico());
            jugador.insertarCarta(carta);
            System.out.printf("%s",jugador.mostrar());
            puntos = jugador.sumarPuntos();
            System.out.printf("%2.1f\n",puntos);
            if (puntos > 7.5) {
                System.out.println("Fin, te pasaste" + nombre);
                r = false;
            } else if (puntos == 7.5) {
                System.out.println("Fin, SIETE y MEDIA" + nombre + "!!!");
                r = false;
            }    
        } else {
            System.out.println("Fin" + nombre);
            r = false;
        }
        
        return r;
    }
    
    public void Jugar() {
        boolean juega1, juega2;
        
        juega1 = true;
        juega2 = true;
        
        do{
            if (juega1)
                juega1 = Turno(jugador1);
            if (juega2)
                juega2 = Turno(jugador2);
            
        } while (juega1 || juega2);
        
        System.out.printf("\n%s%2.1f\n", jugador1.mostrar(), jugador1.sumarPuntos());
        System.out.printf("\n%s%2.1f\n", jugador2.mostrar(), jugador2.sumarPuntos());
        
        if (jugador1.sumarPuntos() == jugador2.sumarPuntos())
            System.out.println("Empate");
        else {
            if(jugador1.sumarPuntos() > 7.5 && jugador2.sumarPuntos() > 7.5)
                if (jugador1.sumarPuntos() < jugador2.sumarPuntos())
                    System.out.printf("Ganador %s", jugador1.obtenerNombre());
                else
                    System.out.printf("Ganador %s", jugador2.obtenerNombre());
            else if(jugador1.sumarPuntos() < 7.5 && jugador2.sumarPuntos() < 7.5)
                if (jugador1.sumarPuntos() > jugador2.sumarPuntos())
                    System.out.printf("Ganador %s", jugador1.obtenerNombre());
                else
                    System.out.printf("Ganador %s", jugador2.obtenerNombre());
            else
                if (jugador1.sumarPuntos() < jugador2.sumarPuntos())
                    System.out.printf("Ganador %s", jugador1.obtenerNombre());
                else
                    System.out.printf("Ganador %s", jugador2.obtenerNombre());
        }
           
    }
    
    private boolean quiereJugar() {
        int r=0;
        
        try
        {
        do {
        System.out.println("1. Sí - 0. No");
        r = teclado.nextInt();
        }while (r < 0 || r > 1);
        }
        catch (Exception e)
        {
            System.out.println("Ocurrió un error");
        }
    if(r==1)
        return(true);
    else
        return(false);
    }
    
}
