package tarea05;

/**
 * La clase "ComputadoVuelo" simular� el funcionamiento de un computador de
 * vuelo. Este computador de vuelo nos permitir� realizar diversas operaciones y
 * c�lculos relacionados�con�el�vuelo
 *
 * @author Jos� Carlos Manj�n Carrasco
 * @version 1
 */
public class ComputadorVuelo {
    //Atributos de clase 

    // mediante private final , indicamos que este atributo es constante durante todo el programa.
    private final String patronMatricula = "EC-[a-zA-Z0-9]{3}";

    private final String matricula;
    private String modelo;
    private String piloto;
    private boolean isVolando;
    private int tipoVuelo;
    private static int tiempoTotalVuelo;
    //private String estado;
    private int velocidad;
    private int rumbo;
    private int altitud;
    //static es para decir que el valor es igual a toda la clase, es decir, ser�a un atributo de clase
    private static int NumAeronaves;
    private static int NumAeronavesVolando;
    private static float NumHorasVuelo;

    // ------------------------------------------------------------
    //                 ATRIBUTOS EST�TICOS (de clase)
    // ------------------------------------------------------------
    // Atributos est�ticos constantes p�blico
    /**
     * Nombre piloto por defecto, se usar� este valor {@value PILOTO_DEFECTO} en
     * caso de no informar ning�n pilot@
     *
     */
    public final static String PILOTO_DEFECTO = "Juan P�rez";
    /**
     * Matr�cula usada por defecto , {@value MATRICULA_DEFECTO}, en caso de no
     * informar ning�na matr�cula .
     *
     */
    public final static String MATRICULA_DEFECTO = "EC-ABC";
    /**
     * Modelo de aeronave usada por defecto ,{@value MODELO_DEFECTO}, en caso de
     * no informar ning�na matr�cula
     *
     */
    public final static String MODELO_DEFECTO = "Cessna 152";
    /**
     * Altitud m�nima a la que podremos programar un vuelo , siendo esta de
     * {@value MIN_ALTITUD}m
     */
    public final static int MIN_ALTITUD = 1000;
    /**
     * Altitud m�xima a la que podremos programar un vuelo , siendo esta de
     * {@value MAX_ALTITUD}m
     */
    public final static int MAX_ALTITUD = 3000;
    /**
     * El valor del vuelo de escuela es "{@value VUELO_ESCUELA}"
     */
    public final static int VUELO_ESCUELA = 0;
    /**
     * El valor del vuelo de escuela es "{@value VUELO_PRIVADO}"
     */
    public final static int VUELO_PRIVADO = 1;

    /**
     * M�todo Get usado para obtener el total de aeronaves creadas.
     *
     * @return Devuelve el n�mero de objetos aeronaves creadas
     */
    public static int getNumAeronaves() {
        return NumAeronaves;
    }
//----------------------------------------------
    // ------------------------------------------------------------
    //             M�todos
    // ------------------------------------------------------------

    /**
     * M�todo Get usado para obtener el total de objetos aeronaves que est�n
     * volando.
     *
     * @return Devuelve el n�mero de objetos aeronaves creadas que est�n volando
     */
    public static int getNumAeronavesVolando() {
        return NumAeronavesVolando;
    }

    /**
     * M�todo Get usado para obtener el total de horas que los objetos aeronaves
     * que est�n volando. Se har� un casting del atributo tiempoTotalVuelo para
     * que al pasarlo a horas, no se realizen redondeos no deseados
     *
     * @return Devuelve el total de horas que los objetos aeronaves hayan estado
     * volando
     */
    public static float getNumHorasVuelo() {

        return NumHorasVuelo;
    }

    /**
     * M�todo que usaremos para crear arrays de objetos ComputadorVuelo, en base
     * al n�mero itroducido
     *
     * @param cantidad N�mero de arrays a crear
     * @return Un array de objetos ComputadorVuelo
     * @throws IllegalArgumentException Si la cantidad introducida es negativa o
     * mayor de 10.
     *
     */
    public static ComputadorVuelo[] crearArrayComputadorVuelo(int cantidad) throws IllegalArgumentException {
        return new ComputadorVuelo[]{};

    }

    /**
     * M�todo usado para introducir la velocidad en un objeto aeronave.
     *
     * @param velocidad Se trata de la velocidad a la que volar� el objeto
     * aeronave
     */
    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    /**
     * M�todo con el que introduciremos el rumbo en la informaci�n de vuelo
     *
     * @param rumbo Rumbo del vuelo a tomar en grados
     */
    public void setRumbo(int rumbo) {
        this.rumbo = rumbo;
    }

    /**
     * M�todo con el fijaremos la altitud en metros en la informaci�n de vuelo
     *
     * @param altitud Altitud en metros del vuelo,en caso es estar entre el
     * {@link ComputadorVuelo#MIN_ALTITUD} y
     * {@link ComputadorVuelo#MAX_ALTITUD}, se tomar� dicho valor, en caso
     * contrario se tomar� {@link ComputadorVuelo#MIN_ALTITUD}
     */
    public void setAltitud(int altitud) {
        if (altitud >= MIN_ALTITUD && altitud <= MAX_ALTITUD) {
            this.altitud = altitud;

        } else {
            this.altitud = MIN_ALTITUD;
        }
    }

    /**
     * Devuelve si el objeto est� volando.
     *
     * @return true si el objeto est� volando, false si no
     */
    public boolean isVolando() {
        return isVolando;
    }

    /**
     * M�todo que devuelve el nombre del piloto asignado a la aeronave. Si no
     * hay piloto asignado, se devuelve el nombre de
     * {@link ComputadorVuelo#PILOTO_DEFECTO}.
     *
     * @return El nombre del piloto asignado o el nombre de
     * {@link ComputadorVuelo#PILOTO_DEFECTO} si no hay piloto asignado.
     */
    public String getPiloto() {
        if (piloto != null && piloto == "") {
            return PILOTO_DEFECTO;
        } else {
            return piloto;
        }
    }

    /**
     * M�todo que devuelve el tipo de vuelo asignado,
     *
     * @return tipoVuelo Que puede tomar los valores de
     * {@link ComputadorVuelo#VUELO_PRIVADO} y
     * {@link ComputadorVuelo#VUELO_ESCUELA} , siendo este �ltimpo el valor por
     * defecto
     */
    public int getTipoVuelo() {

        return tipoVuelo;
    }

    /**
     * M�todo que devuelve el tiempo total de vuelo asignado,
     *
     * @return tiempoTotalVuelo Tiempo total de vuelo en minuto
     *
     */
    public int getTiempoTotalVuelo() {

        return tiempoTotalVuelo;

    }

    /*public String getEstado() {
        return estado;
    }*/
    /**
     * M�todo que devuelve la velocidad medida en km/h, en caso de no estar
     * volando dicha velocidad ser� fijada a 0
     *
     * @return velocidad Velocidad a la que se realizar� el despegue medido en
     * km/h
     */
    public int getVelocidad() {
        if (isVolando() == false) {
            return this.velocidad = 0;
        } else {
            return this.velocidad;
        }

    }

    /**
     * M�todo que devuelve el rumbo medido en grados
     *
     * @return En caso de no estar volando dicho rumbo ser� fijado a 0
     */
    public int getRumbo() {
        if (isVolando() == false) {
            return 0;
        } else {
            return rumbo;
        }
    }

    /**
     * M�todo que devuelve la altitud de vuelo en metros
     *
     * @return En caso de no estar volando dicha altitud ser� fijado a 0
     */
    public int getAltitud() {
        if (this.isVolando() == false) {
            return 0;
        } else {
            return altitud;
        }

    }

    /**
     * M�todo que devuelve el modelo de la aeronave. Si el modelo es nulo o
     * vac�o, se devuelve el {@link ComputadorVuelo#MODELO_DEFECTO}.
     *
     * @return El modelo de aronave o modelo por defecto si es nulo o vac�o.
     */
    public String getModelo() {
        if (modelo != null && modelo == "") {
            return MODELO_DEFECTO;
        } else {
            return modelo;
        }
    }

    /**
     * Devuelve la matr�cula de la aeronave. Si la matr�cula es nula o vac�a, se
     * devuelve la {@link ComputadorVuelo#MATRICULA_DEFECTO}.
     *
     * @return La matr�cula del veh�culo o la matr�cula por defecto si es nula o
     * vac�a.
     */
    public String getMatricula() {
        if (matricula != null && matricula == "") {
            return MATRICULA_DEFECTO;
        } else {
            return matricula;
        }
    }

    /**
     * Este es el constructor por defecto de la clase ComputadorVuelo. Crea una
     * nueva instancia de la clase con los valores por defecto.
     *
     * @see MATRICULA_DEFECTO
     * @see MODELO_DEFECTO
     * @see PILOTO_DEFECTO
     */
    public ComputadorVuelo() {

        this(MATRICULA_DEFECTO, MODELO_DEFECTO, PILOTO_DEFECTO);

    }

    /**
     * Este es el constructor de la clase ComputadorVuelo en la que se informan
     * dos par�metros. Crea una nueva instancia de la clase con la matr�cula y
     * modelo introducida , defaulteando el piloto al piloto por defecto.
     *
     * @param matricula Matr�cula para crear el objeto, estar� sujeta a
     * validaci�n
     * @param modelo Modelo introducido de la aeronave
     * @see PILOTO_DEFECTO
     *
     */
    public ComputadorVuelo(String matricula, String modelo) {
        this(matricula, modelo, PILOTO_DEFECTO);

    }

    /**
     * Este es el constructor de la clase ComputadorVuelo en la que se informan
     * dos par�metros. Crea una nueva instancia de la clase con la matr�cula y
     * modelo introducida , defaulteando el piloto al piloto por defecto.
     *
     * @param matricula Matr�cula para crear el objeto, estar� sujeta a
     * validaci�n
     * @param modelo Modelo introducido de la aeronave
     * @param piloto Nombre del piloto que usarremos para crear el objeto
     *
     */
    public ComputadorVuelo(String matricula, String modelo, String piloto) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.piloto = piloto;
        NumAeronaves++;
    }

    /**
     * M�todo que crear� tantos arrays de la clase ComputadorVuelo como el
     * par�metro que se introduzca, sujeto a validaci�n, arrojar� una expeci�n
     * si est� fuera de rango v�lido
     *
     * @param NumAeronaves N�mero de objetos a crear
     * @throws IllegalArgumentException Saltar� una excepci�n cuando el n�mero
     * introducido no est� en el rango valido, entre 1 y 10
     */
    public void ComputadorVuelo(int NumAeronaves) throws IllegalArgumentException {

        ComputadorVuelo[] arrayAeronaves = new ComputadorVuelo[this.NumAeronaves];

    }

    /**
     * M�todo para obtener el patr�n que todas las matr�culas deben seguir
     *
     * @return Devolver� el patr�n a seguir
     */
    public String getPatronMatricula() {
        return patronMatricula;
    }

    /**
     * M�todo que usaremos para realizar el aterrizaje de vuelos que est�n
     * volando
     *
     * @param aeropuertoSalida Aeropuerto de salida
     * @param aeropuertoLlegada Aeropuerto de llegada
     * @param tiempoVuelo Tiempo en minutos de duraci�n del vuelo
     * @throws IllegalStateException Saltar� una expeci�n en caso de intentar
     * atterrizar un vuelo que atterrizase con anterioridad
     */
    public void aterrizar(String aeropuertoSalida, String aeropuertoLlegada, int tiempoVuelo) {

        if (isVolando() == false) {
            throw new IllegalStateException(getMatricula() + " ya ha aterrizado y debemos despegar de nuevo antes de volver a aterrizar");
        } else {

            this.tiempoTotalVuelo += tiempoVuelo;
            this.NumHorasVuelo = (float) this.tiempoTotalVuelo / 60;
            this.isVolando = false;
            this.NumAeronavesVolando -= 1;
        }
    }

    /**
     * M�todo que usaremos para realizar el despegue de un vuelo
     *
     * @param tipoVuelo Tipo de vuelo ,siendo el valor 0 para
     * {@link ComputadorVuelo#VUELO_ESCUELA} y 1 para
     * {@link ComputadorVuelo#VUELO_PRIVADO}
     *     * @param velocidad Velocidad a la que se realizar� el despegue medido en
     * km/h
     * @param altitud Altitud a la que se realizar� el vuelo tras el despegue
     * @throws IllegalStateException Saltar� una expeci�n cuando se trate de
     * despegar un vuelo que ya est� volando
     * @throws IllegalArgumentException Saltar� una expeci�n cuando se
     * introduzca una altitud fuera de {@link ComputadorVuelo#MAX_ALTITUD} y
     * {@link ComputadorVuelo#MIN_ALTITUD}
     */
    public void despegar(int tipoVuelo, int velocidad, int altitud) throws IllegalStateException, IllegalArgumentException {
        this.altitud = altitud;
        if (isVolando() == true && ((this.altitud >= MIN_ALTITUD) && (this.altitud <= MAX_ALTITUD))) {

            throw new IllegalStateException(getMatricula() + " ya ha despegado y se encuentra fuera del aeropuerto");
        } else if (isVolando() == true && ((this.altitud < MIN_ALTITUD) || (this.altitud > MAX_ALTITUD))) {
            throw new IllegalArgumentException("la altitud de vuelo de " + getAltitud() + " es incorrecta");
        } else {
            this.tipoVuelo = tipoVuelo;
            this.velocidad = velocidad;
            this.altitud = altitud;
            this.isVolando = true;
            this.NumAeronavesVolando += 1;
            isVolando = true;
        }
    }

    /**
     * M�todo usado para obtener los atributos de estado del vuelo al que se
     * apliquen
     *
     * @return Devuelve una cadena informando de la matr�cula, si est� volando,
     * el piloto, tipo de vuelo, tiempo total , la velocidad , rumbo y la
     * altitud en metros
     */
    public String toString() {
        return String.format("[Matricula=%s,Modelo= %s,[isVolando]=%b,Piloto=%s,TipoVuelo=%s,TiempoTotal=%s,V=%skm/h,Rumbo=%s\u00BA,Altitud=%s metros]", getMatricula(), getModelo(), isVolando, getPiloto(), getTipoVuelo(), getTiempoTotalVuelo(), getVelocidad(), getRumbo(), getAltitud());

    }

}
