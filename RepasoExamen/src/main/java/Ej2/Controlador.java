/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej2;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMException;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;



/**
 *
 * @author P13si
 */
public class Controlador {
    private String ruta;
    File file;
    /**Iniciamos los atributos path y file.
     * si el archivo no existe se crea uno vacio
     */
    public Controlador(){
        ruta = "./ListaDatosEmpleado.xml";
        file = new File(ruta);
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
         }
        }
    }
    /**
     * agregamos un nuevo empleado al archivo XML.
     * Leemos el archivo XML existente o creamos uno nuevo si no existe.
     * Creamos varios elementos XML para cada atributo del empleado y los agragamos al XML
     * Escribimos el documento XML actualizado de nuevo en el archivo
     */
    public boolean agregarEmpleado(Empleados trabajador){
        try{
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document Registro = null;
            if(file.exists() && file.length()>0){
                Registro = db.parse(file);
            }
            else{
                DOMImplementation dom = db.getDOMImplementation();
                Registro = dom.createDocument(null,"Empleados",null);
                Registro.setXmlVersion("1.0");
            }
            //Creamos un nodo empleado
            Element empleado = Registro.createElement("Empleado");
            //Lo añadimos como hijo de empleados
            Registro.getDocumentElement().appendChild(empleado);
            //Creamos el nodo ID
            Element id = Registro.createElement("DNI");
            //Creamos el nodo texto con el valor de la id
            Text text = Registro.createTextNode(trabajador.getDni());
            //Añadimos el valor al nodo id
            id.appendChild(text);
            //añadimos el nodo ID a empleado
            empleado.appendChild(id);
            Element nombre = Registro.createElement("Nombre");
            text = Registro.createTextNode(trabajador.getNombre());
            nombre.appendChild(text);
            empleado.appendChild(nombre);
            
            Element apellido = Registro.createElement("Apellido");
            text = Registro.createTextNode(trabajador.getApellidos());
            apellido.appendChild(text);
            empleado.appendChild(apellido);
            
            Element salario = Registro.createElement("Salario");
            text = Registro.createTextNode(String.valueOf(trabajador.getSalario()));
            salario.appendChild(text);
            empleado.appendChild(salario);
            
            Source source = new DOMSource(Registro);
            Result result = new StreamResult(file);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT,"yes");
            transformer.transform(source,result);
            return true;
        }
        catch (DOMException e) {
            e.printStackTrace();
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (SAXException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        }
        catch (TransformerException e) {
            e.printStackTrace();
        }
        return false;
        }
    
    /**
     * Modifica los datos de un empleado existente en el archivo XML.
     * Lee el archivo XML y busca al empleado con el DNI proporcionado.
     * Si se encuentra al empleado, actualiza los elementos XML 
     * correspondientes (DNI, Nombre, Apellido, Salario) con los nuevos valores.
     * Escribe el documento XML modificado de nuevo en el archivo.
     */
    public boolean modificarEmpleado(Empleados trabajador){
        
            try{
                ArrayList<Empleados> trabajadores = new ArrayList<>();
                //Creamos el DocumentBuilder para poder obtener el Document
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder dc = dbf.newDocumentBuilder();
                //Leemos el DOcument desde el fichero
                Document Registro = dc.parse(file);
                //Normalizamos el documento para evitar errores delectura.
                Registro.getDocumentElement().normalize();
                //creamos una lista de todos los nodos de empleado.
                NodeList empleados = Registro.getElementsByTagName("Empleado");
                //Recorremos la lista
                for(int i = 0 ; i< empleados.getLength();i++){
                    //Obtenemos el primer nodo de la lista
                    Node empleado = empleados.item(i);
                    //En caso de que ese nodo sea un Elemento
                    if(empleado.getNodeType()==Node.ELEMENT_NODE){
                        //creamos el elemento empleado y leemos su informacion
                        Element trabajo = (Element) empleado;
                        if(trabajo.getElementsByTagName("DNI").item(0).getTextContent().equals(trabajador.getDni())){
                            trabajo.getElementsByTagName("DNI").item(0).setTextContent(trabajador.getDni());
                            trabajo.getElementsByTagName("Nombre").item(0).setTextContent(trabajador.getNombre());
                            trabajo.getElementsByTagName("Apelidos").item(0).setTextContent(trabajador.getApellidos());
                            trabajo.getElementsByTagName("Salario").item(0).setTextContent(String.valueOf(trabajador.getSalario()));
                            Source source = new DOMSource(Registro);
                            Result result = new StreamResult(file);
                            Transformer transfomer = TransformerFactory.newInstance().newTransformer();
                            transfomer.transform(source,result);
                            return true;
                        }
                    }
                  }
            }
            catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (SAXException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        }
        catch (TransformerException e) {
            e.printStackTrace();
        }
        return false;
        }
        
    
    /**
     * Elimina a un empleado existente del archivo XML.
     * Lee el archivo XML y busca al empleado con el DNI proporcionado.
     * Si se encuentra al empleado, elimina el elemento XML correspondiente del documento.
     * Escribe el documento XML actualizado de nuevo en el archivo.
     */
    public boolean borrarEmpleado(Empleados trabajador){
        try{
            ArrayList<Empleados> trabajadores = new ArrayList<>();
                //Creamos el DocumentBuilder para poder obtener el Document
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder dc = dbf.newDocumentBuilder();
                //Leemos el DOcument desde el fichero
                Document Registro = dc.parse(file);
                //Normalizamos el documento para evitar errores delectura.
                Registro.getDocumentElement().normalize();
                //creamos una lista de todos los nodos de empleado.
                NodeList empleados = Registro.getElementsByTagName("Empleado");
                //Recorremos la lista
                for(int i = 0 ; i< empleados.getLength();i++){
                    //Obtenemos el primer nodo de la lista
                    Node empleado = empleados.item(i);
                    if(empleado.getNodeType()== Node.ELEMENT_NODE){
                        //Creamos el elemento empleado y leemos su informacion
                        Element trabajo = (Element)trabajador;
                        if(trabajo.getElementsByTagName("Dni").item(0).getTextContent().equals(trabajador.getDni())){
                            trabajo.getParentNode().removeChild(trabajo);
                            Source source = new DOMSource(Registro);
                            Result result = new StreamResult(file);
                            Transformer transformer = TransformerFactory.newInstance().newTransformer();
                            transformer.transform(source, result);
                           return true;
                        }
                    }
                }
        }catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (SAXException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        catch (TransformerFactoryConfigurationError e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return false;
    }

    
   /**
     * Recupera los datos del empleado basándose en el DNI proporcionado.
     * Lee el archivo XML y busca al empleado con el DNI especificado.
     * Si se encuentra, crea y devuelve un objeto Employee con los detalles del empleado.
     */
    
    public Empleados consultarEmpleado(String Dni){
    
        try {
            ArrayList<Empleados> trabajadores = new ArrayList<>();
            //Creamos el DocumentBuilder para poder obtener el Document
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder dc = dbf.newDocumentBuilder();
                //Leemos el DOcument desde el fichero
                Document Registro = dc.parse(file);
                //Normalizamos el documento para evitar errores delectura.
                Registro.getDocumentElement().normalize();
                //creamos una lista de todos los nodos de empleado.
                NodeList empleados = Registro.getElementsByTagName("Empleado");
                //Recorremos la lista
                for(int i = 0 ; i< empleados.getLength();i++){
                    //Obtenemos el primer nodo de la lista
                    Node empleado = empleados.item(i);
                    if(empleado.getNodeType()== Node.ELEMENT_NODE){
                        //Creamos el elemento empleado y leemos su informacion
                        Element trabajo = (Element)trabajadores;
                        if (trabajo.getElementsByTagName("Dni").item(0).getTextContent().equals(Dni)){
                            return new Empleados(trabajo.getElementsByTagName("Dni").item(0).getTextContent(),
                            trabajo.getElementsByTagName("Nombre").item(0).getTextContent(),
                                    trabajo.getElementsByTagName("Apellidos").item(0).getTextContent(),
                                    Double.valueOf(trabajo.getElementsByTagName("Salario").item(0).getTextContent()));
                            
                        }
                    }
                }
        }
        catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (SAXException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
            
     /**
     * Recupera una lista de todos los empleados almacenados en el archivo XML.
     * Lee el archivo XML e itera a través de los elementos "Employee", 
     * creando un objeto Employee para cada uno.
     * Devuelve un ArrayList<Employee> que contiene a todos los empleados.
     */
    public ArrayList<Empleados> listaEmpleados(){
        try {
        ArrayList<Empleados> trabajadores = new ArrayList<>();
                //Creamos el DocumentBuilder para poder obtener el Document
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder dc = dbf.newDocumentBuilder();
                //Leemos el DOcument desde el fichero
                Document Registro = dc.parse(file);
                //Normalizamos el documento para evitar errores delectura.
                Registro.getDocumentElement().normalize();
                //creamos una lista de todos los nodos de empleado.
                NodeList empleados = Registro.getElementsByTagName("Empleado");
                //Recorremos la lista
                for(int i = 0 ; i< empleados.getLength();i++){
                    //Obtenemos el primer nodo de la lista
                    Node empleado = empleados.item(i);
                    if(empleado.getNodeType()== Node.ELEMENT_NODE){
                        //Creamos el elemento empleado y leemos su informacion
                        Element trabajo = (Element) empleado;
                        trabajadores.add(new Empleados(trabajo.getElementsByTagName("Dni").item(0).getTextContent(),
                                                     trabajo.getElementsByTagName("Nombre").item(0).getTextContent(),
                                                     trabajo.getElementsByTagName("Apellidos").item(0).getTextContent(),
                                                     Double.valueOf(trabajo.getElementsByTagName("Salario").item(0).getTextContent())));
                    }
                }
        }catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        catch (SAXException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
               