/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.ejercicicosxmldom;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
/**
 *
 * @author a21pablosp
 * 
 */
/**
 * Crea un programa en Java que utilizando el fichero libros2.xml,
 * analicemos el archivo XML y calcularemos el precio promedio de los libros.
 */
public class Ej2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try{
            //Crear una instancia de DocumentBuilderFactory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //Crear un DocumentBuilder
            DocumentBuilder db = dbf.newDocumentBuilder();
            //Analizar el documento XML
            Document doc = db.parse("XML/libros2.xml");
            //Obtener la lista de nodos de libros
            NodeList nl = doc.getElementsByTagName("libro");
            double totalPrecio=0;
            int numLibros = nl.getLength();
            //Iterar a través de los nodos de libros
            for (int i =0; i<numLibros; i++){
                Element libro = (Element) nl.item(i);
                double precio = Double.parseDouble(libro.getElementsByTagName("precio").item(0).getTextContent());
                totalPrecio += precio;
            }
            double precioPromedio = totalPrecio / numLibros;
            System.out.println("Precio promedio de los libros : $" + precioPromedio);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
