package Ejercicio3;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AeroGeneradorXML {

    /**
     * Ruta del archivo donde se lee y escribe la colección de objetos
     * AeroGenerador
     */
    private String rutaArchivo;
    /**
     * Objeto Xstream que permite la L/E con archivos XML
     */
    private XStream xstream;

    /**
     * Método constructor
     *
     * @param archivo Ruta del archivo donde se lee y escribe la colección de
     * objetos AeroGenerador
     */
    public AeroGeneradorXML(String nombreArchivo) {
        XStream xStream;
        xStream = new XStream(new DomDriver("UTF-8"));
        xStream.allowTypesByWildcard(new String[]{
            "CrearFicherosXML.**", "com.myDomain.utilitylibraries.**"});
        List<AeroGeneradorXML> aerogenerador = new ArrayList<AeroGeneradorXML>();
        //   public AeroGenerador(LocalDate fechaInstalacion, int distancia) throws IllegalArgumentException {
        LocalDate date = LocalDate.now();
        int distancia = 0;

        try ( FileWriter ficheroSalida = new FileWriter(new File(rutaArchivo));) {

           
                xStream.alias("ghgh", AeroGenerador.class);
                xStream.alias("fechaInstalacion", LocalDate.class);
                //  xStream.alias("distancia", distancia.class);
                ficheroSalida.write(xstream.toXML(aerogenerador));

            } catch (IOException e) {
                System.err.println(e.getMessage());
            }

          

        } 
    

    /**
     * Método que escribe, en un archivo binario, una colección de objetos
     * AeroGenerador serializables.
     *
     * @param aeroGens Lista de objetos AeroGenerador serializables para
     * almacenar en el archivo binario.
     */
    public void escribir(List aeroGens) {

    }

    /**
     * Método que lee, desde un archivo binario, una colección de objetos
     * AeroGenerador serializados.
     *
     * @return Lista de objetos AeroGenerador que estaba almacenada en el
     * archivo binario.
     */
    public List leer() {
        return null;
    }

}
