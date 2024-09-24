/**
 *
 * Ejercicio Propuesto 3.3
 *
 * @José Carlos Manjón Carrasco
 */
package tarea01;

import java.util.Scanner;

public class NewClass {

    public static void main(String[] args) {
        //----------------------------------------------
        //    Declaración de variables y constantes
        //----------------------------------------------

        int preguntasAcertadas, preguntasFalladas, sumaPreguntas;
        double nota;
        final int PREGUNTAS = 20;
   
        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner teclado = new Scanner(System.in);

        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("¿Preguntas acertadas?");
        preguntasAcertadas = teclado.nextInt();
        System.out.println("¿Preguntas falladas?");
        preguntasFalladas = teclado.nextInt();

        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        nota = ((preguntasAcertadas - (0.5 * preguntasFalladas)) / PREGUNTAS) * 10;
        sumaPreguntas = preguntasAcertadas + preguntasFalladas;
        if (sumaPreguntas > 20) {
            System.out.println("Datos erróneos");
        } else if (sumaPreguntas <= 0) {
            System.out.println("Datos erróneos");
        } else if (sumaPreguntas > 0 & sumaPreguntas <= 20) {

            switch ((int) nota) {
                //los ifs bajo los cases, no sen necesarios, ya que el case estaría demás
                case 5:
                    //if (nota>=5 & nota <6){
                        System.out.println("La nota obtenida es "+ nota+" por lo que la calificación es de SUFICIENTE ");
                    //}
                        break;
                case 6:
                     //if (nota>=6 & nota <7){
                        System.out.println("La nota obtenida es "+ nota+" por lo que la calificación es de BIEN ");
                       // }
                     break;
                case 7:
                   // if (nota>=7 & nota <9){
                        System.out.println("La nota obtenida es "+ nota+" por lo que la calificación es de Notable ");
                   // }
                        break;
                 case 8:
                     
                    /*if (nota>=7 & nota <9){*/
                        System.out.println("La nota obtenida es "+ nota+" por lo que la calificación es de Notable ");
                  //  }
                        break;
                 case 9:
                    //if (nota>=9 & nota <10){
                        System.out.println("La nota obtenida es "+ nota+" por lo que la calificación es de SOBRESALIENTE ");
                  //  }
                        break;
                case 10:
                    //if (nota ==10){
                        System.out.println("La nota obtenida es "+ nota+" por lo que la calificación es de SOBRESALIENTE ");
                    //}
                        break;
                                       
                default:  System.out.println("La nota obtenida es "+ nota+" ,por lo que la calificación es de INSUFICIENTE ");
            }
        }
    }
}
