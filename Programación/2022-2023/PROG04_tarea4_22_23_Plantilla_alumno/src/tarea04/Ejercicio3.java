package tarea04;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.InputMismatchException;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author José Carlos Manjón Carrasco
 */
public class Ejercicio3 {

    public static void main(String[] args) {

        System.out.println("Ejercicio 3 - Ajustando el nuevo radar de la DGT\n");

        // Punto 0. Declaración de constantes y variables
        // Declaración de constantes
        final String MEDICIONES = "PA-762-ED & 191#CU-3344-H & 166 # 3344BBF & 136 #RM 437-LU & 122 #A233456L & 156 #RM 437-BB & 132# CD-332-SD&144#RM333-FF&172#DD-333-EE&222#RR-444-WW&148# 4567EBF & 116 ";
        boolean limiteValido = false;
        final int MAXIMO_CARACTERES_POR_LINEA = 80;
        final int[][] TABLA_MULTAS = {{15, 100}, {30, 200}, {40, 300}, {50, 500}};
        int limiteVelocidad = 0, exceso = 0, porcentajeSobreVelocidadMinima = 0, dineroMulta = 0, fila = 0;

        boolean ejeTerminado = false;
        CapturaRadar dgt = new CapturaRadar(CapturaRadar.Paises.ESPAÑA, 100, "3344BBF"); //creamos una instacia de CapturaRadar sobre la cual trabajaremos
        Scanner teclado = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);
        //----------------------------------------------------------------------
        //                     Declaración de variables
        //----------------------------------------------------------------------
        // Necesitaremos, al menos, las siguientes variables:
        // Definir un StringTokenizer para recorrer la cadena de mediciones y 
        // poder trocearlo asignando la cadena de mediciones y utilizando # 
        // como separador
// StringTokenizer para separar una medición concreta en matrícula y velocidad
        // la separación se recorrer la cadena de mediciones y poder 
        // Una variable entera para almacenar cuantos coches se han medido
        // busca en la API un método que te permita contar cuantos token 
        // tiene una instancia StringTokenizer según el separador indicado
        // Un array de instancias CapturaRadar. Las instancias de CapturaRadar nos 
        // servirán para almacenar en objetos de ese tipo  la información de pais, 
        // velocidad y matrícula de cada medición (para ver su constructor consulta 
        // la API en el JavaDoc proporcionado. El tamaño de este array será 
        // igual al número de Coches que se han medido
        // Una instancia de CapturaRadar para almacenar una medición individual
        // Una instancia de CapturaRadar.Paises para almacenar el país de una medición
        // Otro array de instancias CapturaRadar para guardar los coches multados
        // Array de enteros para almacenar el importe de la multa de cada coche
        // Scanner para pedir datos
// Otras variables auxiliares para guardar límites de velocidad, velocidades
        // cantidad de multados o importe de las multas, etc.
        // (puedes crear las que necesites según tu planteamiento)

        System.out.println("Ajustando el nuevo radar de la DGT");
        System.out.println("La cadena que nos da el rádar es :" + MEDICIONES);
        Pattern patronFrancia = Pattern.compile("[A-Z]{2}-[0-9]{3}-[A-Z]{2}");
        Pattern patronItalia = Pattern.compile("[A-Z]{2} [0-9]{3}-[A-Z]{2}");
        Pattern patronEspana = Pattern.compile("[0-9]{4}[A-Z]{3}");
        Pattern patronEspanaViejo = Pattern.compile("[A-Z]{1,2}-[0-9]{4}-[A-Z]{1,2}");
        CapturaRadar[] arrayCapturas;
        //----------------------------------------------------------------------
        //                        Procesamiento
        //----------------------------------------------------------------------
        // Punto 2. recorrer el tokenizer mientras siga habiendo tokens sin recorrer

        System.out.print("Lo separo en líneas de máximo " + MAXIMO_CARACTERES_POR_LINEA + " caracteres: ");

        for (int i = 0; i < MEDICIONES.length() / MAXIMO_CARACTERES_POR_LINEA; i++) {

            System.out.println(MEDICIONES.substring(i * MAXIMO_CARACTERES_POR_LINEA, MAXIMO_CARACTERES_POR_LINEA * (i + 1)));
        }

        StringTokenizer MEDICIONESTokens = new StringTokenizer(MEDICIONES, "#");

        int w = 0;
        arrayCapturas = new CapturaRadar[MEDICIONESTokens.countTokens()];
        while (MEDICIONESTokens.hasMoreTokens()) {

            String divisionPorMatriculaVelocidad = MEDICIONESTokens.nextToken().toString().trim();
            // Punto 2.1 Extraer una medición individual (el separador será &);

            StringTokenizer matriculaVelocida = new StringTokenizer(divisionPorMatriculaVelocidad, "&");
            while (matriculaVelocida.hasMoreTokens()) {
                // Punto 2.1.1 Leer el primer token de esa medición (será la matrícula)
                // Es interesante eliminar los espacios del dato leído con el método trim

                dgt.setMatricula(matriculaVelocida.nextToken().trim());
                // Punto 2.1.2 Leer el segundo token de esa medición (será la velocidad, valor entero)
                dgt.setVelocidadCaptura(Integer.parseInt(matriculaVelocida.nextToken().trim()));

                arrayCapturas[w] = new CapturaRadar(dgt.getPais(), dgt.getVelocidadCaptura(), dgt.getMatricula());;

            }
            w++;

        }

        for (int k = 0; k < arrayCapturas.length; k++) {
            // Punto 2.1.3 Identificar la matrícula según los patrones descritos en el enunciado
            Matcher acoplamientoPais1 = patronFrancia.matcher(arrayCapturas[k].getMatricula()); // Texto donde buscar o "acoplar"
            Matcher acoplamientoPais2 = patronItalia.matcher(arrayCapturas[k].getMatricula()); // Texto donde buscar o "acoplar"
            Matcher acoplamientoPais3 = patronEspana.matcher(arrayCapturas[k].getMatricula()); // Texto donde buscar o "acoplar"
            Matcher acoplamientoPais4 = patronEspanaViejo.matcher(arrayCapturas[k].getMatricula()); // Texto donde buscar o "acoplar"
            if (acoplamientoPais1.find()) {
                arrayCapturas[k].setPais(CapturaRadar.Paises.FRANCIA);
            } else if (acoplamientoPais2.find()) {
                arrayCapturas[k].setPais(CapturaRadar.Paises.ITALIA);
            } else if (acoplamientoPais3.find()) {
                arrayCapturas[k].setPais(CapturaRadar.Paises.ESPAÑA);
            } else if (acoplamientoPais4.find()) {
                arrayCapturas[k].setPais(CapturaRadar.Paises.ESPAÑA);
            } else {
                arrayCapturas[k].setPais(CapturaRadar.Paises.OTRO);
            }
// Punto 2.1.4. Creamos la instancia de CapturaRadar con los datos obtenidos
// Punto 2.1.5 Almacenamos la instancia de CapturaRadar el array de CapturaRadar
            System.out.print(arrayCapturas[k]);

        }

        do {
            do {
                //----------------------------------------------------------------------
                //                     Entrada de Datos
                //----------------------------------------------------------------------
                // Punto 1. Pedimos al usuario el límite de velocidad (controlamos excepciones)

                System.out.println("Introduce un límite de velocidad km/h");
                try {
                    /* Punto 3. A continuación, vamos a recorrer el array de CapturaRadar para ver 
             a qué coches hay que multar según el límite establecido
                     */
                    // Punto 3.1 Obtenemos la velocidad de la captura 
                    limiteVelocidad = teclado.nextInt();
                    for (int k = 0; k < arrayCapturas.length; k++) {
                        // Punto 3.1 Obtenemos la velocidad de la captura 
                        exceso = arrayCapturas[k].getVelocidadCaptura() - limiteVelocidad;

                        //  Punto 3.2. Si la velocidad de captura es superior al límite debemos calcular
                        // el importe de la multa. Según la diferencia entre la velocidad
                        // medida y ese límite establecido el importe será 100, 200, 300 o 500€
                        if (exceso > 0) {// con este if, solo tenemos en cuenta aquellos vehículos con velocidad superior a la mínima

                            for (fila = 0; fila < 1; fila++) {// en este bucle calculamos en base a la diferenciua respecto a la velocidad detectada, miramos en la tabla de multas y calculamos  la multa
// Punto 3.2.1. Cálculo del porcentajeSobreVelocidadMinima
                                porcentajeSobreVelocidadMinima = (exceso * 100 / limiteVelocidad);

                                /* Punto 3.2.2. calculamos el porcentajeSobreVelocidadMinima de velocidad en que se ha excedido el vehículo
                     empezamos a multar a partir del 15% (si el exceso es menor, no lo multamos)
                     debemos recorrer la tabla de multas e identificar a qué tramo de multa corresponde el exceso
                                 */
                                int porcentajeMinimoMulta = TABLA_MULTAS[fila][0];
                                // Punto  Mostramos la información de los coches multados , empezando con aquellos con un porcentaje mayor o igual al 15%
                                if (porcentajeSobreVelocidadMinima >= 15 && porcentajeSobreVelocidadMinima < TABLA_MULTAS[1][0]) {
                                    dineroMulta = TABLA_MULTAS[0][1];
                                    System.out.println("Exceso " + arrayCapturas[k].getVelocidadCaptura() + "-" + limiteVelocidad + "= " + exceso + " km/h que es un " + porcentajeSobreVelocidadMinima + "% , multa de " + dineroMulta + "...El vehículo de matrícula " + arrayCapturas[k].getMatricula() + " y nacionalidad " + arrayCapturas[k].getPais() + " ha sido medido a " + arrayCapturas[k].getVelocidadCaptura() + "km/h");
                                    limiteValido = true;
                                } else if (porcentajeSobreVelocidadMinima > 30 && porcentajeSobreVelocidadMinima < TABLA_MULTAS[2][0]) {
                                    dineroMulta = TABLA_MULTAS[1][1];
                                    System.out.println("Exceso " + arrayCapturas[k].getVelocidadCaptura() + "-" + limiteVelocidad + "= " + exceso + " km/h que es un " + porcentajeSobreVelocidadMinima + "% , multa de " + dineroMulta + "...El vehículo de matrícula " + arrayCapturas[k].getMatricula() + " y nacionalidad " + arrayCapturas[k].getPais() + " ha sido medido a " + arrayCapturas[k].getVelocidadCaptura() + "km/h");
                                    limiteValido = true;
                                } else if (porcentajeSobreVelocidadMinima > 40 && porcentajeSobreVelocidadMinima < TABLA_MULTAS[3][0]) {
                                    dineroMulta = TABLA_MULTAS[2][1];
                                    System.out.println("Exceso " + arrayCapturas[k].getVelocidadCaptura() + "-" + limiteVelocidad + "= " + exceso + " km/h que es un " + porcentajeSobreVelocidadMinima + "% , multa de " + dineroMulta + "...El vehículo de matrícula " + arrayCapturas[k].getMatricula() + " y nacionalidad " + arrayCapturas[k].getPais() + " ha sido medido a " + arrayCapturas[k].getVelocidadCaptura() + "km/h");
                                    limiteValido = true;
                                } else if (porcentajeSobreVelocidadMinima > 50) {
                                    dineroMulta = TABLA_MULTAS[3][1];
                                    System.out.println("Exceso " + arrayCapturas[k].getVelocidadCaptura() + "-" + limiteVelocidad + "= " + exceso + " km/h que es un " + porcentajeSobreVelocidadMinima + "% , multa de " + dineroMulta + "...El vehículo de matrícula " + arrayCapturas[k].getMatricula() + " y nacionalidad " + arrayCapturas[k].getPais() + " ha sido medido a " + arrayCapturas[k].getVelocidadCaptura() + "km/h");
                                    limiteValido = true;
                                }

                            }

                        }

                    }
                } catch (InputMismatchException exception) {
                }
                teclado.nextLine();
            } while (!limiteValido);

            Pattern patronSalidaNegativo = Pattern.compile("[No]");
         

            boolean terminarSi = false;
            /* Ahora preguntamos si queremos hacer otra simulación o damos por terminada la ejecución, en caso afirmativo se volverá a la línea 134 
donde se vuelve a preguntar por otra velocidad , se imprimirán los datos y se preguntará de nuevo si se desea otra simulación */
            do {
                System.out.println("¿Quieres hacer otra simulacion? Si/No");
                Matcher acoplamientoSalida = patronSalidaNegativo.matcher(teclado2.next());

                if (acoplamientoSalida.find()) { // he obtado por ser lo más restrictivo, en caso de insertar No tras la pregunta, se termina la ejecución, otra cosa insertada se tomará por respuesta afirmativa

                    terminarSi = true;
                    ejeTerminado = true;
                } else {
                    terminarSi = true;
                }
            } while (!terminarSi);

        } while (!ejeTerminado);

    }
}
