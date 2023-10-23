/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.ejercicicosxmldom;

/**
 *
 * @author a21pablosp
 * 
 */
/**
 * 
 * Utiliza DOM en Java para leer el archivo libros.xml y mostrar la información
 * 
 */
import org.w3c.dom.*;
import java.io.*;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
public class Ej1 {

    public static void main(String[] args) {
        try{
            //Crea un objeto DocumentBuilderFactory para obtener un objeto DocumentBuilder
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            //Parsea el archivo XML
            Document doc = db.parse(new File("libros.xml"));
            //Obtiene el elemento Raíz
            Element raiz = doc.getDocumentElement();
            //Obtinee una lista de nodos hijo(que son los elementos "libro" en este caso)
            NodeList nl = raiz.getElementsByTagName("libro");
            //Itera a través de los nodos y muestra la información
            for (int i = 0;i<nl.getLength();i++){
                Node node = nl.item(i);
                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element elementoLibro = (Element) node;
                    String titulo = elementoLibro.getElementsByTagName("titulo").item(0).getTextContent();
                    String autor = elementoLibro.getElementsByTagName("autor").item(0).getTextContent();
                    String anio = elementoLibro.getElementsByTagName("anio").item(0).getTextContent();
                    
                    System.out.println("Título: " + titulo);
                    System.out.println("Autor: " + autor);
                    System.out.println("Año: " + anio);
                    System.out.println();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
