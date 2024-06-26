/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebacondom;
import org.w3c.dom.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.parsers.*;
import java.io.*;
/**
 *
 * @author a21pablosp
 */
public class PruebaconDOM {

    public static void main(String[] args) throws TransformerConfigurationException, TransformerException, ParserConfigurationException {
        /**
         * Crearemos un DocumentBuilder haciendo uso de la factoria
         * DocumentBuilderFactory
         */
        
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder=dbf.newDocumentBuilder();
        /**
         * Creamos un documento vácio
         * Nombre --> RegistroEmpleados
         * Nodo Raíz --> Empleados
         *
         */
        Document registroEmpleados = builder.newDocument();
        registroEmpleados.setXmlVersion("1.0");
        Element elemRaiz = registroEmpleados.createElement("empleado");
        registroEmpleados.appendChild(elemRaiz);
        Empleados(registroEmpleados, "carlos", "30");
        Empleados(registroEmpleados, "juan", "23");
        //Asignamos la versión de XML
            /**
         * Finalmente, para guardar el documento en disco debemos:
         * 
         * 1. Crear el origen de datos (Nuestro Document)
         * 2. Crear el resultado (El fichero de destino
         * 3. Crear un TransformerFactory
         * 4. Realizar la transformacion
         */
        Source origen = new DOMSource(registroEmpleados);
        Result resultado= new StreamResult(new File ("Empleados.xml"));
        Transformer transformador = TransformerFactory.newInstance().newTransformer();
        transformador.setOutputProperty(OutputKeys.INDENT, "yes");
        transformador.transform(origen,resultado);
        /**
         * Mostramos el resultado por la salida estándar
         */
        Result salidaEstandar = new StreamResult(System.out);
        transformador.transform(origen,salidaEstandar);
        
        //Creamos el DocumentBuilder para poder obtener el Document

        
    }
    public static void Empleados(Document registroEmpleados, String Nombre, String Edad){
        
        Element elemPersona = registroEmpleados.createElement("pesona");
        registroEmpleados.getDocumentElement().appendChild(elemPersona);
        Element elemNombre = registroEmpleados.createElement("nombre");
        elemNombre.appendChild(registroEmpleados.createTextNode(Nombre));
        elemPersona.appendChild(elemNombre);
        Element elemEdad = registroEmpleados.createElement("edad");
        elemEdad.appendChild(registroEmpleados.createTextNode(Edad));
        elemPersona.appendChild(elemEdad);
    }
    
}
