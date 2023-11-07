/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.io.EOFException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
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
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author a21pablosp
 * 
 */
/**
 * 2.
 * Ahora vamos a modificar el código del ejercicio 1 para, manteniendo lo más inalterados posible
 * el modelo y la vista, pasemos de trabajar con ficheros binarios a hacerlo con ficheros XML a través
 * del protocolo DOM.
 * Diseña los métodos necesarios para insertar, modificar, borrar y consultar empleados en un fichero
 * XML haciendo uso de DOM.
 */
public class EJ2 {

    /**
     * @param args the command line arguments
     */
static Scanner sc;
static Document documentoxml;
    public static void main(String[] args) throws IOException, ParserConfigurationException{
        sc = new Scanner(System.in);
        try{
            // Creamos un DocumentBuilder haciendo uso del DocumentBuilderFactory
            File archivo = new File(".RegistroEmpleados.xml");
            DocumentBuilderFactory dbf= DocumentBuilderFactory.newInstance();
            DocumentBuilder db =dbf.newDocumentBuilder();
            //Creamos un documento Vacio
            if(archivo.exists()){
                documentoxml=db.parse(archivo);
            }else{
                documentoxml=db.newDocument();
                Element ElementoRaiz = documentoxml.createElement("empleados");
                documentoxml.appendChild(ElementoRaiz);
            }
        
        ArrayList<Empleado> empleados = new ArrayList<>();
        boolean menu = true;
        while(menu){
            System.out.println("""
                                MENÚ
                    1. Inserccion de Datos
                    2. Consulta de Datos
                    3. Modificacion de Datos
                    4. Borrado de Datos
                    5. Listado de Datos
                    6. Guardar ----> Importante
                    7. Salir         """);
            int opcion;
            System.out.println("Elija una opcion.");
            opcion=sc.nextInt();
            switch(opcion){
                case 1:
                    insercion(empleados);
                    break;
                case 2:
                    consulta(empleados);
                    break;
                case 3:
                    modificacion(empleados);
                    break;
                case 4:
                    borrado(empleados);
                    break;
                case 5:
                    listado(empleados);
                    break;
                case 6:
                    //Creamos metodo para guardar todo
                    guardar(archivo);
                    break;
                case 7:
                    menu = false;
                    break;
                default:
                    System.err.println("Introduzca una opcion valida.");
            }
        }
            
        
        }catch(EOFException e){
            e.printStackTrace();
        } catch (SAXException ex) {
        Logger.getLogger(EJ2.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    public static void insercion(ArrayList<Empleado> empleados){
        try{
            Element elemEmpleado = documentoxml.createElement("empleado");
                        sc = new Scanner(System.in);
            System.out.println("Introduzca el DNI");
            
            String dni = sc.nextLine();
            boolean duplicado = false;
            for(Empleado trabajador: empleados){
                if(trabajador.getNif().equals(dni)){
                    System.err.println("El dni ya existe");
                    duplicado=true;
                }else if(!trabajador.getNif().equals(dni)){
                    
                    duplicado=false;
                }
            }
            if(!duplicado){
                Element elemDNI = documentoxml.createElement("DNI");
                elemDNI.appendChild(documentoxml.createTextNode(dni));
                elemEmpleado.appendChild(elemDNI);
                System.out.println("Introduzca el Nombre");
                String nombre = sc.nextLine();
                Element nombreElement = documentoxml.createElement("nombre");
                nombreElement.appendChild(documentoxml.createTextNode(nombre));
                elemEmpleado.appendChild(nombreElement);

                System.out.println("Introduzca los Apellidos");
                String apellidos = sc.nextLine();
                Element apellidosElement = documentoxml.createElement("apellidos");
                apellidosElement.appendChild(documentoxml.createTextNode(apellidos));
                elemEmpleado.appendChild(apellidosElement);

                System.out.println("Introduzca el Salario");
                double salario = sc.nextDouble();
                Element salarioElement = documentoxml.createElement("salario");
                salarioElement.appendChild(documentoxml.createTextNode(Double.toString(salario)));
                elemEmpleado.appendChild(salarioElement);

                documentoxml.getDocumentElement().appendChild(elemEmpleado);

                System.out.println("Empleado agregado correctamente");
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void consulta(ArrayList<Empleado> empleados){
        sc = new Scanner(System.in);
        System.out.println("Introduzca el DNI");
        String dni = sc.nextLine();
        boolean existe= false;
        for(Empleado trabajador: empleados){
            if(trabajador.getNif().equals(dni)){
                System.out.println("DNI : " + trabajador.getNif());
                System.out.println("Nombre : " + trabajador.getNombre());
                System.out.println("Apellidos : " + trabajador.getApellidos());
                System.out.println("Salario : " + trabajador.getSalario());
                existe=true;
            }
        }
        if(!existe){
            System.err.println("El Dni del empleado es incorrecto o no existe.");
        }
    }
    public static void modificacion(ArrayList<Empleado> empleados){
        sc = new Scanner(System.in);
        System.out.println("Introduzca un DNI para modificar al Empleado:");
        String dni = sc.nextLine();
        boolean existe = false;
        for(Empleado trabajador: empleados){
            
            if(trabajador.getNif().equals(dni)){
            System.out.println("Introduzca el nuevo nombre");
            String nombre = sc.nextLine();
            trabajador.setNombre(nombre);
            System.out.println("Introduzca los nuevos apellidos");
            String apellidos = sc.nextLine();
            trabajador.setApellidos(apellidos);
            System.out.println("Introduzca el nuevo salario");
            double salario = sc.nextDouble();
            trabajador.setSalario(salario);
            System.out.println("Empleado modificado correctamente"); 
            }
        }
        if(!existe){
            System.err.println("El empleado no existe");
        }
    }
    
    public static void borrado(ArrayList<Empleado> empleados){
        sc = new Scanner(System.in);
        System.out.println("Introduzca un DNI para eliminar al Empleado:");
        String dni = sc.nextLine();
        Iterator<Empleado> ie = empleados.iterator();
        while(ie.hasNext()){
            Empleado trabajador = ie.next();
            if(trabajador.getNif().equals(dni)){
                ie.remove();
                System.out.print("El empleado fue eliminado correctamente");
            }
        }
    }
    public static void listado(ArrayList<Empleado> empleados){
        for(Empleado trabajador: empleados){
            System.out.println(trabajador.toString());
        }
    }
public static void guardar(File file) {
        try {
            Source origen = new DOMSource(documentoxml);
            Result resultado= new StreamResult(new File ("Empleados.xml"));
            Transformer transformador = TransformerFactory.newInstance().newTransformer();
            transformador.setOutputProperty(OutputKeys.INDENT, "yes");
            transformador.transform(origen,resultado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
