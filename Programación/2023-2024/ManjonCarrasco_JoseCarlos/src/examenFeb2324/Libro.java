package examenFeb2324;

/**
 * Ejercicio 3. Clase Libro
 *
 * @author Nombre y apellidos del alumno/a
 */
public class Libro {

    // Atributos
    public String titulo;
    public String autor;
    public int numPaginas;
    public int anyoPublicacion;
    public static int numLibros;
    public static final String AUTORDEFECTO = "DESCONOCIDO";

    /**
     * Constructor de 4 par�metros que genera un objeto de tipo Libro.
     *
     * @param titulo
     * @param autor
     * @param numPaginas
     * @param anyoPublicacion
     * @throws IllegalArgumentException
     */
    public Libro(String titulo, String autor, int numPaginas, int anyoPublicacion) throws IllegalArgumentException {
        if (titulo.isEmpty()) {
            throw new IllegalArgumentException("Error !! El t�tulo del libro no puede estar vac�o");
        } else if (numPaginas <= 0) {
            throw new IllegalArgumentException("Error !! El n�mero de p�ginas no puede ser negativo o cero");
        } else if (anyoPublicacion < 0) {
            throw new IllegalArgumentException("Error !! El a�o de publicaci�n del libro no puede ser negativo");
        } else {

            this.numLibros += 1;
this.titulo = titulo;
        this.numPaginas = numPaginas;
        this.anyoPublicacion = anyoPublicacion;
        this.autor = autor;
        }
        
    }

    /**
     * Constructor de 3 par�metros que genera un objeto de tipo Libro.
     *
     * @param titulo
     * @param numPaginas
     * @param anyoPublicacion
     * @throws
     */
    public Libro(String titulo, int numPaginas, int anyoPublicacion) throws IllegalArgumentException {
        if (titulo.isEmpty()) {
            throw new IllegalArgumentException("Error !! El t�tulo del libro no puede estar vac�o");
        } else if (numPaginas <= 0) {
            throw new IllegalArgumentException("Error !! El n�mero de p�ginas no puede ser negativo o cero");
        } else if (anyoPublicacion < 0) {
            throw new IllegalArgumentException("Error !! El a�o de publicaci�n del libro no puede ser negativo");
        } else {

            this.numLibros += 1;
   this.titulo = titulo;
        this.numPaginas = numPaginas;
        this.anyoPublicacion = anyoPublicacion;
        this.autor = AUTORDEFECTO;
        }
     
    }

    /**
     * Actualiza el n�mero de p�ginas.
     *
     * @param nuevoNumeroPaginas
     * @return
     */
    public int getNumPaginas() {
        return numPaginas;
    }

    /**
     * Obtiene la informaci�n del libro con formato.
     *
     * @return
     */
    public String informacionLibro() {
        // Se utiliza un objeto de tipo StringBuilder para formatear el estado de la aeronave
        StringBuilder estado = new StringBuilder();

        estado.append(String.format("-T�tulo : ", this.titulo));
        estado.append(String.format("-Autor : ", this.autor));
        estado.append(String.format("-N�mero de p�ginas : ", this.numPaginas));
        estado.append(String.format("-A�o de publicaci�n : ", this.anyoPublicacion));

        // Se devuelve el estado formateado como una cadena
        return estado.toString();
    }

    /**
     * Imprime la informaci�n del libro, mostrando cada campo en una l�nea.
     */
    /**
     * Devuelve si el libro es "CORTO", "MEDIANO" o "LARGO".
     *
     * @return
     */
    /**
     * M�todo est�tico que devuelve un entero con la cantidad de libros creados.
     *
     * @return
     */
    public static int getNumLibros() {
        return numLibros;
    }

    /**
     * Programa de pruebas.
     *
     * @param args argumentos de consola
     */
    public static void main(String[] args) {
        try {
            Libro libroPrimero = new Libro("", 100, 1554);
        } catch (IllegalArgumentException s) {
            System.out.print(s.getMessage());
        }
        System.out.print("\n");

        try {
            Libro libroPrimero = new Libro("Test", -10, 1554);
        } catch (IllegalArgumentException s) {
            System.out.print(s.getMessage());
        }
        System.out.print("\n");
        try {
            Libro libroPrimero = new Libro("Test", 10, -150);
        } catch (IllegalArgumentException s) {
            System.out.print(s.getMessage());
        }
        System.out.print("\n");
        try {
            Libro libroPrimero = new Libro("El lazarillo de Tormes", 100, 1554);
            System.out.print(libroPrimero.informacionLibro());
            Libro libroSegundo = new Libro("Maldita roma", "Santiago Posteaguillo", 896, 2023);
            System.out.print("\n" + libroSegundo.informacionLibro());
        } catch (IllegalArgumentException s) {
            System.out.print(s.getMessage());
        }

        System.out.print("\nN�mero total de libros : " + getNumLibros() + "\n");
    }
}
