package tarea04;

import java.util.StringTokenizer;

/**
 * Ejercicio 4. Análisis de calificaciones y Estadísticas
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio4 {

    public static void main(String[] args) {

        System.out.println("Ejercicio 4 - Análisis de calificaciones y Estadísticas\n");

        //----------------------------------------------------------------------
        //                     Declaración de variables
        //----------------------------------------------------------------------        
        // Punto 0. Declaración de variables y constantes
        final int NUMERO_ALUMNOS = 30;
        final int NUMERO_NOTAS = 6;
        final String NOTAS_ALUMNOS = "6,6,0,4,10,8\n"
                + "7,7,7,4,2,4\n"
                + "4,7,1,2,3,5\n"
                + "5,10,5,8,5,7\n"
                + "6,3,4,2,1,6\n"
                + "4,8,8,8,8,9\n"
                + "2,4,0,4,5,4\n"
                + "3,1,8,9,8,7\n"
                + "5,3,2,8,7,9\n"
                + "7,3,1,2,8,4\n"
                + "6,8,2,6,10,4\n"
                + "3,3,7,5,6,9\n"
                + "1,7,10,2,1,2\n"
                + "3,5,3,4,8,9\n"
                + "2,3,1,1,2,10\n"
                + "3,1,2,6,3,9\n"
                + "2,9,9,7,0,8\n"
                + "8,9,8,8,2,0\n"
                + "2,4,3,7,6,1\n"
                + "8,0,5,4,7,1\n"
                + "8,8,5,7,1,6\n"
                + "8,0,6,4,10,1\n"
                + "5,6,9,1,2,7\n"
                + "5,6,7,8,6,4\n"
                + "0,7,9,4,9,5\n"
                + "6,4,9,2,8,5\n"
                + "5,1,3,1,10,3\n"
                + "6,6,10,0,2,8\n"
                + "4,7,9,5,3,8\n"
                + "2,5,6,6,8,1";

        /* Array doble para almacenar las notas (tendrá una columna más que el número de notas y una fila más que el número de alumnos).
           - En la última columna de cada fila se almacenará la nota media de ese alumno (se consideran solo valores enteros)
           - En la última fila se almacenará en cada columna el número de suspensos de cada asignatura
         */
 /* Dos arrays para almacenar:
            - Las notas medias de cada asigntaura
            - El número de asignaturas suspensas de cada alumno
         */
        // Otras variables auxiliares para guardar notas individuales, índices, contadores, acumuladores, etc.
        // (puedes crear las que necesites según tu planteamiento)
        //  StringTokenizer para separar las notas de los alumnos mediante el símbolo \n (cada token estará compuesto por 6 notas separadas por coma) 
        //----------------------------------------------------------------------
        //                        Procesamiento
        //----------------------------------------------------------------------        
        // Punto 1. Recorrer el tokenizer de alumnos mientras siga habiendo tokens sin recorrer 
        StringTokenizer notasAlumnos = new StringTokenizer(NOTAS_ALUMNOS, "\n");
        int i = 0, j = 0;
        int[][] matrizNotas = new int[NUMERO_ALUMNOS + 1][NUMERO_NOTAS + 1];
        int numeroAlumno = 0, notas = 0, sumaNotas = 0, asignaturasSuspensas = -1;

        while (notasAlumnos.hasMoreTokens()) {

            // Punto 1.1 Extraer el siguiente token a una variable String (son las notas de un alumno individual);
            String notaAlumno = notasAlumnos.nextToken();
            // System.out.println(notaAlumno);

            // Punto 1.2 Mediante otro StringTokenizer extraer las notas 6 individuales de esa cadena (el separador será el símbolo coma);
            StringTokenizer calificaciones = new StringTokenizer(notaAlumno, ",");
            j = 0;
            //  Punto 1.3 Recorrer el tokenizer de notas de alumno mientras siga habiendo tokens sin recorrer 
            while (calificaciones.hasMoreTokens()) {

                /* Punto 1.4 Leer cada nota como valor numérico entero y almacenarla en el array doble de notas de alumnos (la última columna 
           de ese array doble aún no se rellenará */
                int nota = Integer.parseInt(calificaciones.nextToken());
                //System.out.print("\t" + nota);
                matrizNotas[i][j] = nota;
                j++;

            }
            // System.out.println();
            i++;
        }
        for (i = 0; i < matrizNotas.length; i++) {
            for (j = 0; j < matrizNotas[i].length; j++) {
                //System.out.print(matrizNotas[i][j] + "\t");
            }
            // System.out.println("");
        }
        System.out.println("-----------------------");

        for (i = 0; i < NUMERO_NOTAS; i++) {

            for (j = 0; j < NUMERO_ALUMNOS; j++) {
                //  System.out.print(matrizNotas[j][i] + "\t");

            }
            //System.out.println("");
        }
        System.out.println("he leído la cadena de texto con las " + NUMERO_NOTAS + " notas de los " + NUMERO_ALUMNOS + " alumnos original y represento cada alu,no en una fila y en ella las asignaturas por orden. En cada columna están todas las notas de cada asignatura");

        for (i = 0; i < (matrizNotas.length - 1); i++) {
            for (j = 0; j < (matrizNotas[i].length - 1); j++) {

                System.out.print(matrizNotas[i][j] + "-\t");

            }
            System.out.println("");
        }

        /* Punto 2.4.1 Podemos comprobar si la nota media del alumno es la más alta de las encontradas hasta ahora
           Si es así, guardaremos en una variable la posición del array en la que está ese alumno y actualizamos el valor 
           de la media más alta encontrada hasta ahora con el valor de la nota media de este alumno */
        // Punto 3. Ahora recorreremos de nuevo el array doble de notas para calcular, esta vez por cada asignatura (no por cada alumno) la nota media 
        // de cada asignatura y la asignatura con más suspensos. Para ello, recorremos el array doble columna a columna y calculamos la nota media 
        // de cada asignatura y la cantidad de suspensos en cada asignatura
        System.out.println("");
        System.out.println("Asignaturas: ");
        asignaturasSuspensas = 0;
        int asignatura = 0, notaMediaAsignatura = 0;
        for (i = 0; i < NUMERO_NOTAS; i++) {
            asignatura++;
            notaMediaAsignatura = 0;
            for (j = 0; j < NUMERO_ALUMNOS; j++) {
//                System.out.print(matrizNotas[j][i] + "\t");
                // Punto 3.1 Para cada asignatura, si alguna de las notas es inferior a 5 se incrementará su contador de suspensos em esa asigntura
                if (matrizNotas[j][i] < 5) {
                    asignaturasSuspensas++;
                    matrizNotas[30][i] = asignaturasSuspensas;
                }
                // Punto 3.2 Para cada asignatura, sumamos la nota de cada uno de los alumnos en un acumulador (nos servirá para calcular la nota media de esa asignatura) 
                notaMediaAsignatura += matrizNotas[j][i];

            }

            asignaturasSuspensas = 0;
            // Punto 3.3 Para cada asignatura, guardamos en la última array doble de notas de asignaturas suspensas el contador de suspensos de ese alumno
            /* Punto 3.4 Para cada asignatura, se calculará la nota media dividiendo la suma de las notas de cada alumno entre el número de alumnos. Este valor
           se guardará en el array de notas medias de cada asignatura */
 /* Punto 3.4.1 Podemos comprobar si la cantidad de suspensos de una asignatura es la más alta de las encontradas hasta ahora
           Si es así, guardaremos en una variable la posición del array en la que está esa asignatura y actualizamos el valor de la 
           cantidad de suspensos más alta encontrada hasta ahora con el valor de suspensos de esa asignatura */
            //----------------------------------------------------------------------
            //            Salida de resultados
            //----------------------------------------------------------------------        
            // Punto 4. Recorrer el array doble de notas y mostrar la información de notas separadas por guiones
            // Punto 4.1. Localizar al alumno con la media más alta e incluir un mensaje junto a sus notas
            // Punto 5. Mostrar para cada asignatura su nota media y número de suspensos
            // Punto 6. Mostrar para cada alumno su nota media y número de suspensos
            // Punto 7. Mostrar la asignatura con más suspensos y el alumno con la nota media más alta
            System.out.print("Asignatura" + asignatura + ",nota media : " + notaMediaAsignatura / NUMERO_ALUMNOS + ", número de suspensos " + matrizNotas[j][i] + "\t");
            System.out.println("");
        }
        System.out.println("");
        System.out.println("Alumnos :");
        for (i = 0; i < matrizNotas.length - 1; i++) {// el -1 es para eliminar el último registro, que es usado para calcular el número de suspensos por asignatura
            sumaNotas = 0;
            numeroAlumno++;
            for (j = 0; j < matrizNotas[i].length; j++) {

                notas = matrizNotas[i][j];
                // Punto 2.2 Para cada alumno, sumamos cada una de sus notas en un acumulador (nos servirá para calcular la nota media) 
                sumaNotas += notas;
                // Punto 2.3 Para cada alumno, guardamos en el array de asignaturas suspensas el contador de suspensos de ese alumno
                if (matrizNotas[i][j] < 5) {
                    asignaturasSuspensas++;

                }

            }

            /* Punto 2.4 Para cada alumno, se calculará la nota media dividiendo la suma de sus notas entre el número de notas. Este valor
           se guardará en la última columna de notas de ese alumno (esta columna estaba vacía, la usamos para almacenar las medias calculadas) */
            //notaMedia = sumaNotas / NUMERO_NOTAS;
            matrizNotas[i][6] = sumaNotas / NUMERO_NOTAS;

            System.out.print("[Alumno" + numeroAlumno + ",tiene nota media " + matrizNotas[i][6] + " y número de suspensas " + asignaturasSuspensas + "]");
            System.out.println("");
            asignaturasSuspensas = -1;
        }
    }
}
