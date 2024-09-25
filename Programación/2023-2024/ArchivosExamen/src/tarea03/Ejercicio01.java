package tarea03;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Scanner;
import libtarea3.Teatro;

/**
 * Ejercicio 1: Trabajo con teatros
 *
 * @author Profe
 */
public class Ejercicio01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------
        // 1.1. Declaración de tres variables referencia a objetos instancia de la clase Teatro
        Teatro teatUno, TeatDos, teatTres;

        // 1.2. Declaración de constante para dar formato de fecha hora 
        LocalDateTime fechaHoraAhora = LocalDateTime.now();
        DateTimeFormatter formatoDdMmAaHmS = DateTimeFormatter.ofPattern("'Fecha de realización de la prueba: 'dd/MM/yyyy HH:mm:ss \n");

        // Clase Scanner para petición de datos de entrada (no es necesario)
        Scanner teclado = new Scanner(System.in);
        ///
        String codigoError = "";
        //----------------------------------------------
        //              Presentación
        //----------------------------------------------
        System.out.println("TRABAJO CON TEATROS");
        System.out.println("--------------------");
        System.out.println();

        //----------------------------------------------
        //               Análisis inicial
        //----------------------------------------------        
        // 2. Consulta de valores iniciales
        System.out.println("1.-CONSULTA INICIAL DE VALORES GLOBALES");
        System.out.println("---------------------------------------");
        System.out.println();

        // 2.1. Número de teatros creados hasta el momento
        System.out.printf("Número de teatros creados hasta el momento: " + Teatro.getTeatrosTotales() + ".\nNúmeros de obras que se están representando en este momento: " + Teatro.getObrasActivas() + ".\nNúmero de entradas vendidas hasta el momento: " + Teatro.getEntradasVendidasTotales() + ".\n");

        // 2.2. Número de obras que se están represenando en este momento en todos los teatros
        //2.3. Número de entradas vendidas en todos los teatros y para todas las obras que se han representado hasta el momento
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        // En realidad no hay entrada de datos como tal dado que la información 
        // de entrada es fija y siempre la misma
        System.out.println("\n2.-CREACIÓN Y USO DE TEATROS");
        System.out.println("------------------------------\n");

        // 3.- Instanciación de tres objetos Teatro
        System.out.println("Creación de teatros (constructores)");
        System.out.println("-------------------------------------");

        // 3.1.- Intento de crear un teatro con un aforo inferior (hay que gestionar la posible excepción)
        try {
            Teatro teatroNoAforo = new Teatro("Linares", 299);
            
        } catch (IllegalArgumentException a) {
            // System.err.printf("Error: " + e.getMessage() + "\n");
            codigoError += "Intentando crear un teatro con un aforo inferior...\n" + "Error: Aforo incorrecto: " + a.getMessage() + "\n\n";

            // 3.2.- Intento de crear un teatro con un aforo superior (hay que gestionar la posible excepción)
            try {

                Teatro teatroExcesoAforo = new Teatro("Test", 1001);

            } catch (IllegalArgumentException e) {
                //  System.err.printf("Error: " + e.getMessage() + "\n");
                codigoError += "Intentando crear un teatro con un aforo superior...\n" + "Error: " + e.getMessage() + "\n\n";
            }
            // 3.3.- Intento de crear un teatro con un nombre de teatro vacío y aforo por defecto
            try {

                Teatro teatroExcesoAforo = new Teatro("", 500);
            } catch (IllegalArgumentException l) {
                //   System.err.printf("Error: " + e.getMessage() + "\n");
                codigoError += "Intentando crear un teatro con un nombre vacío y aforo por defecto...\n" + "Error: " + l.getMessage() + "\n\n";
            }

            // 3.4.- Creación de un primer teatro usando el constructor de dos parámetros
            Teatro teatroDosParametros = new Teatro("Cervantes", 900);
            codigoError += "Creando teatro con aforo válido con un constructor con dos parámaetros\nTeatro " + teatroDosParametros.getCodigoTeatro() + " creado " + teatroDosParametros + "\n";
            // 3.5.- Creación de un segundo teatro con un aforo por defecto usando el constructor de un parámetro    
            Teatro teatroDefecto = new Teatro("Apolo");
            codigoError += "\nCreando teatro con aforo por defecto usando un constructor con un parámetro..." + "\nTeatro " + teatroDefecto.getCodigoTeatro() + " creado, estado " + teatroDefecto + "\n";
            //System.out.println(teatroDefecto);
            // 3.6.- Creación de un tercer teatro usando el constructor sin parámetros 
            Teatro teatroNoParametro = new Teatro();
            codigoError += "\nCreando teatro con valores por defecto usando un constructor sin parámetros..." + "\nTeatro " + teatroNoParametro.getCodigoTeatro() + " creado, estado " + teatroNoParametro + "\n";
            //  System.out.println(teatroNoParametro);

            //----------------------------------------------
            //       Procesamiento + Salida de Resultados
            //----------------------------------------------
            // Dado que se va a ir mostrando información de salida a la vez que 
            // se van realizando operaciones, podemos considerar en este caso
            // que el procesamiento y la salida de resultado van unidos y "mezclados"
            // 4.- Operaciones con teatros
            System.out.println("Manipulación de teatros (métodos)");
            System.out.println("-----------------------------------");

            // 4.1.- Intento de terminar de representar una obra a un teatro que no tiene obra asignada (debemos capturar el error)
            try {
                teatroDefecto.terminarObra();
            } catch (IllegalStateException d) {
                // System.err.printf("Error: " + d.getMessage() + "\n");
                codigoError += "\nManipulación de teatros (métodos)\n----------------------------------\nTerminando de representar una obra en el primer teatro...\n" + d.getMessage() + "\n";
            }
            //4.2.- Asignamos una obra al teatro1 y lo llenamos (debemos comprobar antes si podemos asignarla)

            if (teatroDosParametros.tieneObra() == false) {
                teatroDosParametros.asignarObra("El laberinto del fauno");
                teatroDosParametros.llenarTeatro();
                codigoError += "\nAsignando una obra de teatro...\nSe ha asignado la obra '" + teatroDosParametros.getObra() + "' al teatro '" + teatroDosParametros.getNombreTeatro() + "'\nTeatro lleno. Se han vendido " + teatroDosParametros.getEntradasVendidas() + " entradas\n";
            }

            //4.3.- Devolvemos 50 entradas del teatro1 (puesto que acabamos de llenar el teatro, no es necesario comprobar si podemos devolver entradas)
            teatroDosParametros.devolverEntradas(50);
            //4.4.- Intentamos traspasar la representación de la obra del teatro1 al teatro2 (hay que gestionar la posible excepción)
            try {
                teatroDosParametros.traspasarObra(teatroDefecto);
            } catch (IllegalStateException e) {
                codigoError += "\nIntentando traspasar una obra de un tratro a otro...\nError: " + e.getMessage() + "\n";
            }
            //4.5.- Devolvemos otras 50 entradas del teatro1 (no es necesario comprobar si podemos devolver entradas)
            teatroDosParametros.devolverEntradas(50);

            //4.6.- Volvemos a intentar traspasar la obra del teatro1 al teatro2 (ahora no debe dar excepción)
            try {
                //teatroDosParametros.getAforo();
                teatroDosParametros.traspasarObra(teatroDefecto);
                codigoError += "\nTraspaso realizado con éxito\n";
            } catch (IllegalStateException e) {
                codigoError += "\nIntentando traspasar una obra de un tratro a otro...\nError: " + e.getMessage();
            }
            //4.7.- Devolver una entrada del teatro2
            teatroDefecto.devolverEntrada();
            //5.- Obtención de información del segundo teatro creado
            System.out.printf(codigoError);
            String datosSegundoTeatro = "", datosSegundoTeatroObra = "";
            System.out.println("\nPrueba de los getters del segundo teatro creado:");
            System.out.println("----------------------------------------------------");
            //teatroDefecto.terminarObra();
            datosSegundoTeatro += fechaHoraAhora.format(formatoDdMmAaHmS) + "Teatro 2" + "\n\tCódigo del teatro: " + teatroDefecto.getCodigoTeatro() + "\tNombre del teatro: \"" + teatroDefecto.getNombreTeatro() + "\"\n\tAforo: " + teatroDefecto.getAforo() + "\n\tEstado:\n\t";
            datosSegundoTeatroObra = teatroDefecto.tieneObra() ? "\tSe está representando la obra de teatro:\"" + teatroDefecto.getObra() + "\"\n\t\tEntradas vendidas: " + teatroDefecto.getEntradasVendidas() : "No se está representando ninguna obra actualmente.";
            datosSegundoTeatro += datosSegundoTeatroObra;
            System.out.printf(datosSegundoTeatro + "\n");
            //----------------------------------------------
            //               Análisis Final
            //----------------------------------------------        
            // 6. Consulta de valores finales
            System.out.println("3.-CONSULTA FINAL DE VALORES GLOBALES");
            System.out.println("-------------------------------------");
            System.out.println();
            String datosGenerales = "";
            // 6.1. Número de teatros creados hasta el momento
            datosGenerales += "Número de teatros creados hasta el momento: " + Teatro.getTeatrosTotales();
            // 6.2. Número de obras que se están represenando en este momento en todos los teatros

            datosGenerales += "\nNúmero de obras que se están representando en este momento: " + Teatro.getObrasActivas();
            //6.3. Número de entradas vendidas en todos los teatros y para todas las obras que se han representado hasta el momento

            datosGenerales += "\nNúmero de entrdas vendidas hasta el momento: " + Teatro.getEntradasVendidasTotales();
            System.out.printf(datosGenerales + "\n");
        }

    }
}
