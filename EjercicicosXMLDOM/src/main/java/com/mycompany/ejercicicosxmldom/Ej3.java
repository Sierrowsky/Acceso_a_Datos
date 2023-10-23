/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.ejercicicosxmldom;
import java.io.File;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import org.w3c.dom.*;

/**
 *
 * @author a21pablosp
 * 
 */
/**
 * 
 * Crea un programa en Java utilizando DOM que analice el archivo XML estudiantes.xml
 * y que permita al usuario agregar nuevos estudiantes a dicho archivo.
 * Para agregar un nuevo estudiante, tendrás que proporcionar ID, nombre y edad
 * 
 */
public class Ej3 {
    private static Scanner sc = new Scanner(System.in);
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        try{
            //Crear instancia de DocumentBuilderFactory
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            //Crear un DocumentBuilder
            DocumentBuilder db = dbf.newDocumentBuilder();
            //Analizar el Documento xml
            Document doc = db.parse("XML/estudiantes.xml");
            System.out.println("Escriba el id del Alumno: ");
            String id = sc.nextLine();
            System.out.println("Escriba el nombre del Alumno: ");
            String nombre = sc.nextLine();
            System.out.println("Escriba la edad del Alumno: ");
            String edad = sc.nextLine();
            AgregarAlumno(doc,id,nombre,edad);
            Source origen = new DOMSource(doc);
            Result resultado = new StreamResult(new File("XML/estudiantes.xml"));
            Transformer transformador = TransformerFactory.newInstance().newTransformer();
            transformador.setOutputProperty(OutputKeys.INDENT,"yes");
            transformador.transform(origen,resultado);
            Result salidaEst = new StreamResult(System.out);
            transformador.transform(origen,salidaEst);
            
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    
    public static void AgregarAlumno(Document doc, String id ,String nombre, String edad){
        Element elemEst = doc.createElement("estudiante");
        doc.getDocumentElement().appendChild(elemEst);
        Element elemID = doc.createElement("id");
        elemID.appendChild(doc.createTextNode(id));
        elemEst.appendChild(elemID);
        Element elemNombre = doc.createElement("nombre");
        elemNombre.appendChild(doc.createTextNode(nombre));
        elemEst.appendChild(elemNombre);
        Element elemEdad = doc.createElement("edad");
        elemEdad.appendChild(doc.createTextNode(edad));
        elemEst.appendChild(elemEdad);
        
    }
}
