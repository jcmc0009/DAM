package tarea05;

import java.time.chrono.ThaiBuddhistEra;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase de utilidades necesaria para la realizaci?n de las pruebas escritas en
 * las clases <b>TestEj0102</b>, <b>TestEj03</b> , <b>TestEj040506</b>
 * y <b>TestEj07</b>
 *
 * @author Luis del Moral
 */
public class TestUtilidades {

    /**
     * Se crea un constructor privado para evitar que la clase pueda
     * instanciarse
     */
    private TestUtilidades() {

    }

    /**
     * Método de consulta de atributos estáticos de la clase
     *
     * @return String Consulta de atributos estáticos de la clase
     */
    public static String consultaAtributosEstaticos() {
        // Se utiliza un objeto de tipo StringBuilder para formatear las pruebas
        StringBuilder consulta = new StringBuilder();
        consulta.append(String.format(" -> numAeronaves: %d\n", ComputadorVuelo.getNumAeronaves()));
        consulta.append(String.format(" -> numAeronavesVolando: %d\n", ComputadorVuelo.getNumAeronavesVolando()));
        consulta.append(String.format(" -> numHorasVuelo: %f\n", ComputadorVuelo.getNumHorasVuelo()));

        // Se devuelve la salida formateada
        return consulta.toString();
    }

    /**
     * Método de consulta de atributos públicos de la clase
     *
     * @return Consulta de atributos públicos de la clase
     */
    public static String consultaAtributosPublicos() {
        // Se utiliza un objeto de tipo StringBuilder para formatear las pruebas
        StringBuilder consulta = new StringBuilder();
        consulta.append("------------------------------------------------\n");
        consulta.append(" - PRUEBA 01 - ATRIBUTOS PÚBLICOS\n");
        consulta.append("------------------------------------------------\n");
        consulta.append(String.format(" -> PILOTO_DEFECTO: %s\n", ComputadorVuelo.PILOTO_DEFECTO));
        consulta.append(String.format(" -> MODELO_DEFECTO: %s\n", ComputadorVuelo.MODELO_DEFECTO));
        consulta.append(String.format(" -> MATRICULA_DEFECTO: %s\n", ComputadorVuelo.MATRICULA_DEFECTO));
        consulta.append(String.format(" -> MIN_ALTITUD: %d\n", ComputadorVuelo.MIN_ALTITUD));
        consulta.append(String.format(" -> MAX_ALTITUD: %d\n", ComputadorVuelo.MAX_ALTITUD));
        consulta.append(String.format(" -> VUELO_ESCUELA: %d\n", ComputadorVuelo.VUELO_ESCUELA));
        consulta.append(String.format(" -> VUELO_PRIVADO: %d\n", ComputadorVuelo.VUELO_PRIVADO));

        // Se devuelve la salida formateada
        return consulta.toString();
    }

    /**
     * Método de consulta de atributos públicos de la clase
     *
     * @param aeronave ComputadorVuelo de la aeronave a consultar
     * @return Consulta de atributos públicos de la clase
     */
    public static String consultarAtributosComputadorVuelo(ComputadorVuelo aeronave) {
        // Se utiliza un objeto de tipo StringBuilder para formatear las pruebas
        StringBuilder consulta = new StringBuilder();

        // Ahora se lee el valor de cada getter() del dispositivo
        consulta.append("Leyendo los datos almacenados en el ComputadorVuelo\n");
        consulta.append(String.format(" -> getMatricula(): %s\n", aeronave.getMatricula()));
        consulta.append(String.format(" -> getModelo(): %s\n", aeronave.getModelo()));
        consulta.append(String.format(" -> isVolando(): %s\n", aeronave.isVolando()));
        consulta.append(String.format(" -> getPiloto(): %s\n", aeronave.getPiloto()));
        consulta.append(String.format(" -> getTipoVuelo(): %s\n", aeronave.getTipoVuelo()));
        consulta.append(String.format(" -> getTiempoTotalVuelo(): %d\n", aeronave.getTiempoTotalVuelo()));
        consulta.append(String.format(" -> getVelocidad(): %s\n", aeronave.getVelocidad()));
        consulta.append(String.format(" -> getRumbo(): %s\n", aeronave.getRumbo()));
        consulta.append(String.format(" -> getAltitud(): %s\n", aeronave.getAltitud()));

        // Se devuelve la salida formateada
        return consulta.toString();
    }

    /**
     * Lee los datos de un array de aeronaves y los imprime por pantalla
     *
     * @param arrayAeronaves Array de aeronaves
     */
    public static void consultarAtributosArrayAeronaves(ComputadorVuelo[] arrayAeronaves) {
        // Se leen los datos de cada aeronave y se muestran por pantalla
        for (ComputadorVuelo arrayAeronave : arrayAeronaves) {
            System.out.println(TestUtilidades.consultarAtributosComputadorVuelo(arrayAeronave));
        }
    }

    /**
     * Crea una ComputadorVuelo para una aeronave usando el constructor de tres
     * parámetros, se controlarán las expeciones como que los parámetros sean
     * nulos o vengan vacíos,y validaremos la matrícula además devolverá un
     * mensaje acorde al error.
     *
     * @param matricula Matrícula de la aeronave
     * @param modelo Modelo de la aeonave
     * @param piloto Piloto comandante de la aeronave
     * @return Instancia de constructor con los parámetros introducidos
     */
    public static ComputadorVuelo crearAeronave(String matricula, String modelo, String piloto) throws NullPointerException{
        // Se crea un objeto de tipo aeronave y se capturan las excepciones producidas
        ComputadorVuelo aeronave = null;

        try {
            System.out.printf("Registrando un ComputadorVuelo para la aeronave [%s,%s,%s]", matricula, modelo, piloto);
            aeronave = new ComputadorVuelo(matricula, modelo, piloto);

            Pattern patron = Pattern.compile(aeronave.getPatronMatricula());
            if (aeronave.getMatricula() == null) {
                throw new NullPointerException("La matrícula de la aeronaves no puede ser nula");
            } else if (aeronave.getMatricula().isEmpty()) {
                throw new NullPointerException("La matrícula de la aeronaves es una cadena vacía");
            } else if (aeronave.getPiloto() == null) {
                throw new NullPointerException("El piloto de la aeronaves no puede ser nulo");
            } else if (aeronave.getPiloto() == "") {
                throw new NullPointerException("El piloto de la aeronaves es una cadena vacía");
            } else if (aeronave.getModelo() == null) {
                throw new NullPointerException("El modelo de la aeronaves no puede ser nulo");
            } else if (aeronave.getModelo().isEmpty()) {
                throw new NullPointerException("El modelo de la aeronaves es una cadena vacía");

            }
            Matcher acoplamiento = patron.matcher(aeronave.getMatricula()); // Texto donde buscar o "acoplar"
            if (acoplamiento.matches()) {
                System.out.println("\n -> Objeto creado con éxito");
            } else {
                throw new IllegalArgumentException("Se ha producido un error: El formato de la matrícula es incorrecto: " + aeronave.getMatricula());
            }

        } catch (NullPointerException e) {
            System.out.printf("\n -> Se ha producido un error: %s\n", e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.printf("\n -> Se ha producido un error: %s\n", e.getMessage());
        }

        // Se devuelve la aeronave creada
        return aeronave;
    }

    /**
     * Crea una ComputadorVuelo para una aeronave usando el constructor de dos
     * parámetros tomando el restante por el valor por defecto
     * <ul>
     * <li> @param matricula Matrícula de la aeronave </li>
     * <li>@param modelo Modelo de la aeonave </li>
     * <li>Piloto :{@link ComputadorVuelo#PILOTO_DEFECTO} </li>
     * </ul>
     *
     *
     * @return Instancia de constructor con los parámetros
     * introducidos,defaultearemos el piloto
     * de{@link ComputadorVuelo#PILOTO_DEFECTO}
     */
    public static ComputadorVuelo crearAeronave(String matricula, String modelo) {
        // Se crea un objeto de tipo aeronave
        ComputadorVuelo aeronave = null;
        try {
            System.out.printf("Registrando un ComputadorVuelo para la aeronave [%s,%s]\n", matricula, modelo);
            aeronave = new ComputadorVuelo(matricula, modelo);
            System.out.println("\n -> Objeto creado con éxito");
        } catch (IllegalArgumentException e) {
            System.out.printf("\n -> Se ha producido un error: %s\n", e.getMessage());
        }

        // Se retorna la aeronave creada
        return aeronave;
    }

    /**
     * Crea una ComputadorVuelo para una aeronave usando el constructor sin
     * parámetros. Tomaremos los valores por defecto :
     * <ul>
     * <li>Matricula :{@link ComputadorVuelo#MATRICULA_DEFECTO} </li>
     * <li>Modelo : {@link ComputadorVuelo#MODELO_DEFECTO} </li>
     * <li>Piloto :{@link ComputadorVuelo#PILOTO_DEFECTO} </li>
     * </ul>
     *
     *
     * @return String Consulta de atributos públicos de la clase
     */
    public static ComputadorVuelo crearAeronave() {
        // Se crea un objeto de tipo aeronave
        ComputadorVuelo aeronave = null;
        try {
            System.out.printf("Registrando un ComputadorVuelo para una aeronave con los parámetros por defecto\n");
            aeronave = new ComputadorVuelo();
            System.out.println("\n -> Objeto creado con éxito");
        } catch (IllegalArgumentException e) {
            System.out.printf("\n -> Se ha producido un error: %s\n", e.getMessage());
        }

        // Se retorna la aeronave creada
        return aeronave;
    }

    /**
     * Crea un array de aeronaves con los datos por defecto usando el método
     * fábrica
     *
     * @param cantidad Indica la cantidad de dispositivos a cxrear en el array
     * @return ComputadorVuelo Array de aeronaves
     */
    public static ComputadorVuelo[] crearArrayAeronaves(int cantidad) {
        // Se crea un objeto de tipo array para almacenar las aeronaves
        ComputadorVuelo[] arrayAeronaves = null;
        try {
            System.out.printf("Intentando crear array de %d objetos.\n", cantidad);
            arrayAeronaves = ComputadorVuelo.crearArrayComputadorVuelo(cantidad);
            if (cantidad <= 0 || cantidad > 10) {
                throw new IllegalArgumentException("Número de aviones incorrecto " + cantidad + ", debe ser mayor o igual que 1 y menor o igual que 10");
            } else {
                System.out.println(" -> Array de Objetos creado con éxito.");
            }

        } catch (IllegalArgumentException e) {
            System.out.printf(" -> Se ha producido un error: %s\n", e.getMessage());
        }

        // Se retorna el vector creado
        return arrayAeronaves;
    }

    /**
     * Crea un array de aeronaves con datos de prueba
     *
     * @return ComputadorVuelo Array de aeronaves
     */
    public static ComputadorVuelo[] crearArrayAeronavesDatosPrueba() {
        // Se crea un array de dispositivos vacío
        ComputadorVuelo[] arrayAeronaves = new ComputadorVuelo[5];

        // Se crean 5 dispositivos de ejmplo con datos usando el constructor de 3 parámetros
        arrayAeronaves[0] = TestUtilidades.crearAeronave("EC-FEC", "Cessna 172", "Raúl López");
        arrayAeronaves[1] = TestUtilidades.crearAeronave("EC-FA3", "Eurostar Evektor EV-97", "Eva Lozano");
        arrayAeronaves[2] = TestUtilidades.crearAeronave("EC-IOF", "Tecnam P92", "Santiago Vázquez");
        arrayAeronaves[3] = TestUtilidades.crearAeronave("EC-FE1", "Dassault Falcon 900", "Pedro Sánchez");
        arrayAeronaves[4] = TestUtilidades.crearAeronave("EC-CQB", "HU-26", "Luis de la Torre");

        // Se devuelve el array de aeronaves
        return arrayAeronaves;
    }

    /**
     * Realiza una prueba del método de despegue del ComputadorVuelo realizando
     * controlando las excepciones
     *
     * @param aeronave Aeronave (ComputadorVuelo)
     */
    public static void pruebaMetodoDespegue(ComputadorVuelo aeronave, int tipoVuelo, int velocidad, int altitud) {
        // Testea el método de despegue y captura las excepciones
        try {
            aeronave.despegar(tipoVuelo, velocidad, altitud);

        } catch (IllegalStateException f) {
            System.out.printf("\n -> Se ha producido un error: %s\n", f.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.printf("\n -> Se ha producido un error: %s\n", e.getMessage());
        }

    }

    /**
     * Realiza una prueba del método aterrizar del ComputadorVuelo realizando
     * controlando las excepciones
     *
     * @param aeronave Aeronave (ComputadorVuelo)
     */
    public static void pruebaMetodoAterrizar(ComputadorVuelo aeronave) {
        // Genera una excepción: una aeronave que no está volando no puede aterrizar
        try {
            aeronave.aterrizar("TEST", "TEST", 60);
        } catch (IllegalStateException e) {
            System.out.printf("\n -> Se ha producido un error: %s\n", e.getMessage());
        }
    }

}
