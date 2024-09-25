package sieteymedia;


import java.util.Comparator;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author antonio
 */
public class AgrupadorCartasSimbolo implements Comparator<Carta>{
    @Override
    public int compare(Carta carta1, Carta carta2){
       int resultado;
       if (carta1.obtenerSimbolo() > carta2.obtenerSimbolo()){
             resultado=1; 
       }else{  
           if (carta1.obtenerSimbolo()<carta2.obtenerSimbolo()){ 
                resultado=-1;
           }else{
               resultado=0;
           }
       }
       return resultado;
   }
}
