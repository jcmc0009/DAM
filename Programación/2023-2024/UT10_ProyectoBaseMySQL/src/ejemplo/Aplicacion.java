package ejemplo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import static java.lang.System.err;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.stream.Collectors;



 
/**
 * Aplicación principal del programa.
 * 
 * @author Profesor
 */
public class Aplicacion {

    /**
     * Nombre de la base de datos.
     */
    private static final String DB_NAME = "proyectobase";
    /**
     * URL para la conexión a la base de datos. Modificar "localhost" si
     * la base de datos está en otro sistema.
     */
    private static final String CONNECTION_URL = "jdbc:mysql://localhost/"+DB_NAME;
    /**
     * Driver a utilizar para conectarse a la base de datos.
     */
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    /**
     * Opciones adicionales de conexión. 
     */
    private static final String CU_PARAMS = "?serverTimezone=UTC&useUnicode=true&characterEncoding=utf8";
    
    /**
     * UUSUARIO para conectar (dependerá de tu instalación de MySQL)
     */
    private static final String USUARIO = "proyectobase";
   
    /**
     * Password para conectar (dependerá de tu instalación de MySQL)
     */
    private static final String PASSWORD="proyectobase";
   
    
    /**
     * Path al archivo que contiene la estructura de la base de datos.
     */
    public final static String ESTRUCTURA_DB="/resources/estructuradb.sql";  
    
    
    /**
     * Método principal de la aplicación. En él se realiza la preparación
     * del entorno antes de empezar. A destacar:
     * 
     * - Se carga el DRIVER (Class.forName) - solo necesario para JDBC menor que 4.0.
     * - Se establece una conexión con la base de datos (DriverManager.getConnection)
     * - Se crean las tablas, si no están creadas, invocando el método createTables.
     * - Se ejecuta una consulta de prueba
     * 
     * @param args 
     */
     public static void main(String[] args) {        
        boolean DRIVERCargado=false;
        
        //Carga del DRIVER de la base de datos (solo necesario JDBC < 4.0).
        try {
            Class.forName(DRIVER) ;
            DRIVERCargado=true;
        }
        catch (ClassNotFoundException e) {
            err.printf("No se encuentra el DRIVER de la base de datos (%s)\n",DRIVER);
        }
         
        //Si el DRIVER está cargado, aseguramos que podremos conectar.
        if (DRIVERCargado) {
            //Conectamos con la base de datos.
            //El try-with-resources asegura que se cerrará la conexión al salir.
            System.out.println(CONNECTION_URL+CU_PARAMS);
            try (Connection con = DriverManager.getConnection(CONNECTION_URL+CU_PARAMS,USUARIO,PASSWORD)) {
                
                
                /*Creamos las tablas y algunos datos de prueba si no existen
                y continuamos*/
                if (createTables(con)) {
                    
                    //Ejecutamos una consulta de prueba
                    try ( Statement consulta = con.createStatement()) {
                        if (consulta.execute("SELECT id,nombre,precio FROM producto")) {
                            ResultSet resultados = consulta.getResultSet();
                            while (resultados.next()) {
                                long id = resultados.getLong("id");
                                String nombre = resultados.getString("nombre");
                                double precio = resultados.getDouble("precio");
                                System.out.printf("%5d %-15s %10.2f\n", id, nombre, precio);
                            }
                        }
                    } catch (SQLException ex) {
                        System.err.printf("Se ha producio un error al ejecutar la consulta SQL.");
                    }

                    
                } else {
                    err.println("Problema creando las tablas.");

                }                                                        
                                
            } catch (SQLException ex) {
                err.printf("No se pudo conectar a la base de datos (%s)\n", DB_NAME);
            }
        }

    }
    
    /**
     * Dada una conexión válida, lleva a cabo la creación de la estructura
     * de la base de datos, usando como SQL para la creación el contenido 
     * en la constante ESTRUCTURA_DB
     * @param con conexión a la base de datos.
     * @see ESTRUCTURA_DB
     * @return true si se creo la estructura y false en caso contrario. 
     */
    public static boolean createTables (Connection con)
    {
        boolean ok=false;
        
        try (Statement st=con.createStatement())
        {                   
            String sqlScript=loadResourceAsString(ESTRUCTURA_DB);
            if (sqlScript!=null) 
            {
                String sqlSentences[]=sqlScript.split(";");                
                for (String sqlSentence:sqlSentences)
                    if(!sqlSentence.trim().isEmpty())
                        st.execute(sqlSentence);                  
                ok=true;
            }                    
            else {
                System.out.printf("Problema cargando el archivo: %s \n",ESTRUCTURA_DB);
                System.out.printf("Para ejecutar este proyecto no puede usarse 'Run File'\n");
            }
            
        }
        catch (SQLException ex) {
            System.err.printf("Problema creando la estructura de la base de datos.\n");
        }
        return ok;        
    }        
    
    /**
      * Carga un recurso que estará dentro del JAR como cadena de texto.
      * @param resourceName Nombre del recurso dentro del JAR.
      * @return Cadena que contiene el contenido del archivo.
      */
    public static String loadResourceAsString(String resourceName) {
        String resource = null;
        InputStream is = Aplicacion.class.getResourceAsStream(resourceName);
        if (is != null) {
            try ( InputStreamReader isr = new InputStreamReader(is);  BufferedReader br = new BufferedReader(isr);) {
                resource = br.lines().collect(Collectors.joining("\n"));
            } catch (IOException ex) {
                System.err.printf("Problema leyendo el recurso como cadena: %S\n ", resourceName);
            }
        }
        return resource;
    }
}
