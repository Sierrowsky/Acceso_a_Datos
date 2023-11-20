/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej3;

import Ej2.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
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
 * @author a21pablosp
 */

public class Controlador {
   private String path;
   private File file;
    public Controlador() {
        path = "./listapacientes.xml";
        file = new File(path);

        if (!file.exists()){
            try {
                file.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean insercion(Paciente pacientes){
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document registroPacientes = null;

            if(file.exists() && file.length() > 0) {
                registroPacientes= db.parse(file);
            }
            else {
                DOMImplementation dom = db.getDOMImplementation();
                registroPacientes = dom.createDocument(null, "pacientes", null);
                registroPacientes.setXmlVersion("1.0");
            }

            Element paciente = registroPacientes.createElement("Paciente");

            int nifPacientes = registroPacientes.getElementsByTagName("paciente").getLength() + 1;
            paciente.setAttribute("id", String.valueOf(nifPacientes));

            registroPacientes.getDocumentElement().appendChild(paciente);

            Element id = registroPacientes.createElement("Dni");

            Text text = registroPacientes.createTextNode(pacientes.getNif());

            id.appendChild(text);

            paciente.appendChild(id);
            Element nombre = registroPacientes.createElement("nombre");
            text = registroPacientes.createTextNode(pacientes.getNombre());
            nombre.appendChild(text);
            paciente.appendChild(nombre);

            Element apellidos = registroPacientes.createElement("apelidos");
            text = registroPacientes.createTextNode(pacientes.getApellidos());
            apellidos.appendChild(text);
            paciente.appendChild(apellidos);

            Element direccion = registroPacientes.createElement("direccion");
            text = registroPacientes.createTextNode(String.valueOf(pacientes.getDireccion()));
            direccion.appendChild(text);
            paciente.appendChild(direccion);
            
            Element fecha = registroPacientes.createElement("Fecha ultima visita");
            text = registroPacientes.createTextNode(String.valueOf(pacientes.getFechaultimavisita()));
            fecha.appendChild(text);
            paciente.appendChild(fecha);
            
            Element alergia = registroPacientes.createElement("Alergia");
            text = registroPacientes.createTextNode(String.valueOf(pacientes.getAlergia()));
            alergia.appendChild(text);
            paciente.appendChild(alergia);
            
            Element tipo = registroPacientes.createElement("tipo");
            text = registroPacientes.createTextNode(String.valueOf(pacientes.getTipo()));
            tipo.appendChild(text);
            paciente.appendChild(tipo);
            
            Source source = new DOMSource(registroPacientes);
            Result result = new StreamResult(file);
            Transformer transformer = TransformerFactory.newInstance().newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, result);
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
            
            
    
    public Paciente consulta(String nif){
         try {
            ArrayList<Paciente> workers = new ArrayList<Paciente>();

            //Creamos el DocumentBuilder para poder obtener el Document
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            //Leemos el Document desde el fichero
            Document registroPacientes = db.parse(file);

            //Normalizamos el documento para evitar errores de lectura.
            registroPacientes.getDocumentElement().normalize();

            //Creamos una lista de todos los nodos empleado
            NodeList employee = registroPacientes.getElementsByTagName("Employee");

            //Recorremos la lista.
            for(int i = 0; i < employee.getLength(); i++) {
                //Obtenemos el primer nodo de la lista
                Node employe = employee.item(i);
                
                //En caso de que ese nodo sea un Elemento
                if(employe.getNodeType() == Node.ELEMENT_NODE) {
                    //Creamos el elemento empleado y leemos su información
                    Element ingresado = (Element)employe;
                    
                    if(ingresado.getElementsByTagName("Dni").item(0).getTextContent().equals(nif)) {
                        return new Paciente(ingresado.getElementsByTagName("Nif").item(0).getTextContent(),
                                ingresado.getElementsByTagName("Nombre").item(0).getTextContent(),
                                ingresado.getElementsByTagName("Apellidos").item(0).getTextContent(),
                                Double.valueOf(ingresado.getElementsByTagName("Direccion").item(0).getTextContent()));
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
    
    public boolean borrado (Paciente pacientes){
        try {
            ArrayList<Paciente> paciente = new ArrayList<Paciente>();

            //Creamos el DocumentBuilder para poder obtener el Document
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            //Leemos el Document desde el fichero
            Document registerWorkers = db.parse(file);

            //Normalizamos el documento para evitar errores de lectura.
            registerWorkers.getDocumentElement().normalize();

            //Creamos una lista de todos los nodos empleado
            NodeList Paciente = registerWorkers.getElementsByTagName("Employee");

            //Recorremos la lista.
            for(int i = 0; i < Paciente.getLength(); i++) {
                //Obtenemos el primer nodo de la lista
                Node employe = Paciente.item(i);

                //En caso de que ese nodo sea un Elemento
                if(employe.getNodeType() == Node.ELEMENT_NODE) {
                    //Creamos el elemento empleado y leemos su información
                    Element employ = (Element)employe;

                    if(employ.getElementsByTagName("Dni").item(0).getTextContent().equals(worker.getDni())) {
                        employ.getParentNode().removeChild(employ);

                        Source source = new DOMSource(registerWorkers);
                        Result result = new StreamResult(file);
                        Transformer transformer = TransformerFactory.newInstance().newTransformer();
                        transformer.transform(source, result);
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
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public ArrayList<Paciente> listapacientes(){
        try {
            ArrayList<Paciente> paciente = new ArrayList<Paciente>();

            //Creamos el DocumentBuilder para poder obtener el Document
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            //Leemos el Document desde el fichero
            Document registerWorkers = db.parse(file);

            //Normalizamos el documento para evitar errores de lectura.
            registerWorkers.getDocumentElement().normalize();

            //Creamos una lista de todos los nodos empleado
            NodeList employee = registerWorkers.getElementsByTagName("Employee");

            //Mostramos el nº de elementos empleado que hemos encontrado

            //Recorremos la lista.
            for(int i = 0; i < employee.getLength(); i++) {
                //Obtenemos el primer nodo de la lista
                Node employe = employee.item(i);

                //En caso de que ese nodo sea un Elemento
                if(employe.getNodeType()==Node.ELEMENT_NODE) {
                    //Creamos el elemento empleado y leemos su información
                    Element employ = (Element)employe;

                    paciente.add(new Paciente(
                            employ.getElementsByTagName("nif").item(0).getTextContent(),
                            employ.getElementsByTagName("Nombre").item(0).getTextContent(),
                            employ.getElementsByTagName("Apellido").item(0).getTextContent(),
                            employ.getElementsByTagName("Direccion").item(0).getTextContent(),
                            employ.getElementsByTagName("Fecha").item(0).getTextContent(),
                            employ.getElementsByTagName("Alergia").item().getBoolean(),
                            Double.valueOf(employ.getElementsByTagName("Salary").item(0).getTextContent())));
                }
            }
            return workers;
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
    
}
