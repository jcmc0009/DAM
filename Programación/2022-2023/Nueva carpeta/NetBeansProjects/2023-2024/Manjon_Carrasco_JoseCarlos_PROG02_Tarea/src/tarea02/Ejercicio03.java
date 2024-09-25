/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea02;

import java.util.Scanner;

/**
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio03 {

    public static void main(String args[]) {
        //----------------------------------------------
        //               Declaración de variables y constantes
        //----------------------------------------------

        String resultado = "";
        int soldadosIntroducidos = 0;
        String formacionIntroducida = "";
        boolean formacionValida = false;
        int filasCuadrado, numeroSoldadosEnFormacion = 0;
        // Clase Scanner para petición de datos al usuario a través del teclado
        Scanner scanner = new Scanner(System.in);
        Scanner formacion = new Scanner(System.in);
        //----------------------------------------------
        //               Entrada de datos 
        //----------------------------------------------
        System.out.println("Ejercicio03: Formación romana a partir de un número de soldados.");
        System.out.println("----------------------------------------------------");
        // Bloque 1. Solicitud del número de soldadosIntroducidos
        // Validación de entrada: Deberíamos comprobar que es mayor o igual que uno. En caso contrario volvemos solicitar el número de soldadosIntroducidos
        // Se supone que nos introducen un número entero. En caso que no sea así saltará una excepción, cuyo tratamiento veremos en uinidades posteriores
        // 
        do {
            System.out.println("introduce el número de elementos de la formación (debe ser mayor que cero)");
            soldadosIntroducidos = scanner.nextInt();
        } while (soldadosIntroducidos <= 0);
        // Bloque 2. Solicitud del tipo de formación. 
        // Indicaremos que tiene que ser LINEA, CUADRADO o TRIANGULO
        // Leemos una cadena, puede que no sea una de las anteriores.
        System.out.println("Introduce el tipo de formación");
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        // Creamos una cadena de texto para ir almacenando el resultado, que sacaremos por pantalla al final
        // Sólo si la entrada ha sido válida simulamos la formación representando cada soldado con un *
        // No olvides que Si al hacer la mayor formación posible del tipo indicado con los soldadosIntroducidos introducidos sobran soldadosIntroducidos, se debe indicar cuantos."
        // Si el tipo de formación que nos han indicado y que hemos leído como String no coincide con una de las contempladas, indicamos este error almacenando el mensaje oportuno en el String resultado
        formacionIntroducida = formacion.nextLine();
        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        //----------------------------------------------

        /*Comparamos la formación introducida con las válidas, ignorando, en caso de no ser una se informa de opción no correcta, en caso de ser formación válida
         en cada una calculamos cómo mostrar la formaciónm, calculando también el número de soldadosIntroducidos que sobrarían en base a la mayor formación posible 
        y al número de soldadosIntroducidos introducidos*/
        switch (formacionIntroducida.toUpperCase()) {
            case "LINEA":
                for (int i = 0; i < soldadosIntroducidos; i++) {
                    resultado += ("* ");
                    //contador de soldados en la formación
                    numeroSoldadosEnFormacion++;
                }
                formacionValida = true;
                break;
            case "CUADRADO":
                //calculamos el número de filas que tendrá el cuadrado
                filasCuadrado = (int) (Math.sqrt(soldadosIntroducidos));

                for (int i = 0; i < filasCuadrado; i++) {
                    //contador de soldados en la formación
                    for (int j = 0; j < filasCuadrado; j++) {
                        //contador de soldados en la formación
                        numeroSoldadosEnFormacion++;
                        resultado += ("* ");
                    }
                    resultado += ("\n");
                }
                formacionValida = true;
                break;
            case "TRIANGULO":

                int numeroFilasTriangulo = (int) ((Math.sqrt(1 + 8 * soldadosIntroducidos) - 1) / 2);

                for (int i = 0; i < numeroFilasTriangulo; i++) {

                    for (int j = 0; j < numeroFilasTriangulo; j++) {
                        if (i == 0 || i == j || j > i) {
                            resultado += ("* ");
                            numeroSoldadosEnFormacion++;//contador para los soldadosIntroducidos
                        } else {
                            resultado += (" ");
                        }
                    }
                    resultado += ("\n");
                }
                formacionValida = true;
                break;
            default:
                System.out.println("Opción No correcta");
        }
        System.out.print(resultado);
        /*En la siguiente línea, en caso de tener más soldados itroducidos que los que admite la formación elegida 
        se informará por pantalla*/
        if (formacionValida == true && (soldadosIntroducidos > numeroSoldadosEnFormacion)) {
            System.out.println("De los " + soldadosIntroducidos + " soldados asignados, una vez hecha la mayor formación posible del tipo indicado, sobran " + (int) (soldadosIntroducidos - numeroSoldadosEnFormacion) + " soldado(s).");
        }

    }
}
