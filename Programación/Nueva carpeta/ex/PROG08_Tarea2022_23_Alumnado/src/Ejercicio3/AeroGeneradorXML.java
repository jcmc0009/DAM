package Ejercicio3;

import com.thoughtworks.xstream.XStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
        super();
        this.rutaArchivo = nombreArchivo;
        xstream = new XStream();
        //Permite asignar privilegios para poder operar con los archivos XML
        xstream.allowTypesByWildcard(new String[]{
            "Ejercicio3.**",
            "com.mydomain.utilitylibraries.**"
        });
    }

    /**
     * Método que escribe, en un archivo binario, una colección de objetos
     * AeroGenerador serializables.
     *
     * @param aeroGens Lista de objetos AeroGenerador serializables para
     * almacenar en el archivo binario.
     */
    List<AeroGenerador> aerogeneradorXML = new ArrayList<>();

    public void escribir(List aeroGens) {
        /*xstream = new XStream(new DomDriver("UTF-8"));
        xstream.allowTypesByWildcard(new String[]{
            "AeroGeneradorXML.**", "com.myDomain.utilitylibraries.**"});*/

        aerogeneradorXML.addAll(aeroGens);
        //(List) aerogeneradorXML.add(new AeroGenerador(LocalDate.MIN, 0));
        //    AeroGenerador aeroGenerador = new AeroGenerador(LocalDate.MIN, 0);
        //   public AeroGenerador(LocalDate fechaInstalacion, int distancia) throws IllegalArgumentException {
/*
        try ( FileWriter ficheroSalida = new FileWriter(new File(rutaArchivo));) {

            xStream.alias("AeroGenerador", aeroGenerador.getClass());
            xstream.alias("numSerie", AeroGenerador.class);
            xstream.alias("distancia", AeroGenerador.class);
            xstream.alias("numAeroGeneradores", AeroGenerador.class);
            xStream.alias("registroInicioFuncionamientoActual", LocalDate.class);
            // xStream.alias("distancia", distancia.class);
            ficheroSalida.write(xstream.toXML(aerogeneradorXML));
            ficheroSalida.close();
            //ficheroSalida.write(xStream.toXML(aerogenerador));

        } catch (IOException ex) {
            Logger.getLogger(AeroGeneradorXML.class.getName()).log(Level.SEVERE, null, ex);
        }*/
        try ( FileWriter ficheroSalida = new FileWriter(new File(rutaArchivo), false);) {
            //xstream.alias("ytyuy", AeroGeneradorXML.class);
            ficheroSalida.write(xstream.toXML(aerogeneradorXML));
            ficheroSalida.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Método que lee, desde un archivo binario, una colección de objetos
     * AeroGenerador serializados.
     *
     * @return Lista de objetos AeroGenerador que estaba almacenada en el
     * archivo binario.
     */
    public List leer() {

           return (List) aerogeneradorXML;
        

    }

}
