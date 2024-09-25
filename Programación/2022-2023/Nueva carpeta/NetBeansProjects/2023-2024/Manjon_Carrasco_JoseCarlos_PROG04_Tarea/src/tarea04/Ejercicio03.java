
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.Arrays;
import java.util.Locale;
import java.util.StringTokenizer;

/**
 * Tarea Online 4. Ejercicio 3: Días Festivos y Puentes
 *
 * @author José Carlos Manjón Carrasco
 * @version 1.0
 */
public class Ejercicio03 {

    public static void main(String[] args) {

        // DEFINICIÓN DE CONSTANTES
        final String CADENA_FESTIVOS = "12,8;12,25;1,1;1,6;5,1;5,18;10,12;11,1;12,6";
        final LocalDate[] FESTIVOS;
        LocalDate[] CADENAINTERMEDIAFESTIVOS;

        // DEFINICIÓN DE VARIABLES
        String cadenaIntermedia = "";
        // Objeto tipo fecha con la fecha de fechaAcomprobar
        LocalDate fechaAcomprobar;
        LocalDate diaNavidadAnyoAcomprobar;
        // Formateador fecha
        // DateTimeFormatter formatoDdMmAa = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatoDd = DateTimeFormatter.ofPattern("dd");
        //idioma español para fecha
        Locale espaniol = new Locale("es", "SP");
        // Objeto de tipo StringBuilder para mostrar el resultado al final
        StringBuilder resultado = new StringBuilder("");
        int contadorFechasAcomprobar = 0, anyoActual;

        /*
         * ************************************************************************
         * PROCESAMIENTO
         ***********************************************************************/
        // Obtención de la fecha actual (fechaAcomprobar)
        // Si queremos hacer pruebas podemos descomentar la siguiente línea y cambiar
        // las fechas
        // fechaAcomprobar = LocalDate.of(2023, 12, 29);
        fechaAcomprobar = LocalDate.of(2025, Month.APRIL, 12);
        //fechaAcomprobar = LocalDate.of(2023, Month.DECEMBER, 29);
        // fechaAcomprobar = LocalDate.of(2023, Month.NOVEMBER, 4);
        //fechaAcomprobar = LocalDate.now();
        diaNavidadAnyoAcomprobar = LocalDate.of(fechaAcomprobar.getYear(), Month.DECEMBER, 25);
        /*
         * Comprobamos si el día de fechaAcomprobar es posterior al 25 de Diciembre, en tal
         * caso debemos incrementar el año actual en una unidad. Ya que, el último día
         * festivo del año es el 25 de Diciembre, y por tanto no tiene sentido calcular
         * los festivos hasta final de años, ya que no habría ninguno.
         */
        anyoActual = fechaAcomprobar.getYear();
        if ((fechaAcomprobar.isAfter(diaNavidadAnyoAcomprobar))) {
            //recalculamos la fecha a comprobar, fijándola en el 1 de enero del año posterior

            fechaAcomprobar = LocalDate.of(anyoActual + 1, Month.JANUARY, 1);
        }

        /*
         * Creamos un array con los festivos, para ello, utilizando la clase
         * StringTokenizer, dividimos en tokens las fechas que nos han entregado
         * con la cadena constante CADENA_FESTIVOS. Por tanto, debemos obtener los
         * diferentes tokens para la pareja de fechas día y mes, separados de las otras
         * parejas, días y mes mediante ";". Y posteriormente, obtener el día y el mes
         * de cada pareja, sabiendo que estos están separados por una coma ","
         * Cargaremos cada una de las fechas creadas en el array constante de FESTIVOS
         */
        StringTokenizer PrimerArraySinPuntoComas = new StringTokenizer(CADENA_FESTIVOS, ";");
        int tamanyoPrimerArray = PrimerArraySinPuntoComas.countTokens();
        FESTIVOS = new LocalDate[tamanyoPrimerArray];
        while (PrimerArraySinPuntoComas.hasMoreTokens()) {
            cadenaIntermedia = PrimerArraySinPuntoComas.nextToken();
            StringTokenizer segundoArraySinComas = new StringTokenizer(cadenaIntermedia, ",");
            FESTIVOS[contadorFechasAcomprobar] = LocalDate.of(fechaAcomprobar.getYear(), Integer.parseInt(segundoArraySinComas.nextToken()), Integer.parseInt(segundoArraySinComas.nextToken()));
            contadorFechasAcomprobar++;
        }

        // Ordenamos el array
        Arrays.sort(FESTIVOS);
        int t = 0, r = 0;
        /*
         * Calculamos el próximo día festivo que vamos a tener, para ello recorremos
         * el array de Festivos hasta que encontremos una fecha posterior a la actual
         */
        for (int i = 0; i < FESTIVOS.length; i++) {

            if (FESTIVOS[i].isAfter(fechaAcomprobar) || FESTIVOS[i].isEqual(fechaAcomprobar)) {
                t++;
            }
            t++;
        }
        CADENAINTERMEDIAFESTIVOS = new LocalDate[t];
        for (int i = 0; i < FESTIVOS.length; i++) {

            if (FESTIVOS[i].isAfter(fechaAcomprobar) || FESTIVOS[i].isEqual(fechaAcomprobar)) {
                CADENAINTERMEDIAFESTIVOS[r] = FESTIVOS[i];
                r++;

            }
        }/*            
         * A continuación, queremos saber si ese próximo festivo calculado, se encuentra
         * en viernes o lunes, en cuyo caso se generaría un PUENTE
         */
        resultado.append("El próximo festivo es " + CADENAINTERMEDIAFESTIVOS[0] + " y");
        if ((CADENAINTERMEDIAFESTIVOS[0].getDayOfWeek().equals(DayOfWeek.MONDAY) || CADENAINTERMEDIAFESTIVOS[0].getDayOfWeek().equals(DayOfWeek.FRIDAY))) {

            resultado.append(" TENDREMOS puente\nFestivos con puente hasta final del año " + fechaAcomprobar.getYear() + "\n");

            // Mostramos los festivos desde el día actual hasta el final de año que no generan puente
        } else {
            resultado.append(" No TENDREMOS puente\nFestivos con puente hasta final del año " + fechaAcomprobar.getYear() + "\n");
        }
        for (int i = 0; i < FESTIVOS.length; i++) {

            if (FESTIVOS[i].isAfter(fechaAcomprobar) || FESTIVOS[i].isEqual(fechaAcomprobar)) {
                CADENAINTERMEDIAFESTIVOS[r] = FESTIVOS[i];
                r++;

                /*
                * A continuación, queremos saber si ese próximo festivo calculado, se encuentra
         * en viernes o lunes, en cuyo caso se generaría un PUENTE
                 */
                if ((FESTIVOS[i].getDayOfWeek().equals(DayOfWeek.MONDAY) || FESTIVOS[i].getDayOfWeek().equals(DayOfWeek.FRIDAY))) {
                    // Generamos el formato de fecha que queremos
                    // Recorremos el array de festivos para ver qué festivos hasta final de año
                    // generan puente
                    // Mostramos los festivos desde el día actual hasta el final de año que generan
                    // puente
                    resultado.append("\t*En el festivo " + FESTIVOS[i].format(formatoDd) + " " + FESTIVOS[i].getMonth().getDisplayName(TextStyle.FULL, espaniol) + " " + FESTIVOS[i].getYear() + " genera PUENTE\n");

                }
            }
        }

        /*
         * ***********************************************************************
         * SALIDA de DATOS
         *************************************************************************/
        System.out.println(resultado);
    }

}
