/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ejercicio4;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xml.sax.SAXException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.Document;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Programa para trabajar con DOM.
 *
 * @profesorado
 */
public class Ejercicio4 {

    /**
     * Método principal.
     */
    public static void main(String[] args) {

        //----------------------------------------------
        //          Declaración de variables 
        //----------------------------------------------

        /*Abrir el archivo y convertir el contenido en un árbol DOM
    Eliminar el elemento distancia de cada aeroGenerador.
    Añadir un nuevo elemento a aeroGenerador llamado color con el valor "blanco".
    Convertir el árbol DOM en el nuevo contenido del archivo, actualizarlo y cerrarlo.*/
        // Constantes
        // Variables de entrada
        // Variables de salida
        // Variables auxiliares
        //----------------------------------------------
        //                Entrada de datos 
        //----------------------------------------------
        String ruta = System.getProperty("user.dir") + "/recursos/BDAeroGens.xml";
        //----------------------------------------------
        //                 Procesamiento 
        //----------------------------------------------
        try {

            // 1º Creamos una nueva instancia de un fábrica de constructores de documentos.
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

            // 2º A partir de la instancia anterior, fabricamos un constructor de documentos, que procesará el XML.
            DocumentBuilder db = dbf.newDocumentBuilder();

            // 3º Procesamos el documento (almacenado en un archivo) y lo convertimos en un árbol DOM.
            org.w3c.dom.Document documento = db.parse(ruta);
            Element raiz = documento.getDocumentElement();

            //lista de nodos del elemento raiz
            NodeList nodeList = raiz.getChildNodes();

            for (int i = 0; i < nodeList.getLength(); i++) {
                if (nodeList.item(i).getNodeType() == Node.ELEMENT_NODE) {
                    Element tagDistancia = (Element) nodeList.item(i);
                    NodeList nodeListHijo = tagDistancia.getElementsByTagName("distancia");
                    Element tagNombre = (Element) nodeListHijo.item(0);
                    String nombre = tagNombre.getTextContent();

                    // System.out.println(nombre);
                    if (nombre.equalsIgnoreCase("151")) {

                        tagDistancia.removeChild(tagNombre);

                    }
                    Element tagColor = documento.createElement("color");
                    tagColor.setTextContent("Blanco");
                    tagDistancia.appendChild(tagColor);
                    //  raiz.appendChild(tagColor);
             
                   
                }

            }

            FileWriter ficheroSal = new FileWriter(new File(ruta));
            DOMSource domSource = new DOMSource(documento);
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transfor = tf.newTransformer();
            transfor.transform(domSource, result);
            ficheroSal.write(writer.toString());
            ficheroSal.close();

        } catch (ParserConfigurationException | SAXException ex) {
            Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("¡Error! No se ha podido cargar el documento XML.");
        } catch (IOException ex) {
            Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Ejercicio4.class.getName()).log(Level.SEVERE, null, ex);
        } catch (java.lang.NullPointerException es) {
        }

        //----------------------------------------------
        //              Salida de resultados 
        //----------------------------------------------
        System.out.println();
        System.out.println("Archivo cerrado y procesamento finalizado");
        System.out.println("---------");
        System.out.println();
        System.out.println("Fin del programa.");
    }
}
