/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.rerepaso;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author P13si
 */
public class ReRepaso {
    private Element Raizelement;
    private Document document;
    
    public ReRepaso() {
        try {
            File file = new File("medicamentos.xml");
            if (!file.exists()) {
                crearArchivoXML();
            } else {
                DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
                DocumentBuilder db = dbf.newDocumentBuilder();
                document = db.parse(file);
                document.getDocumentElement().normalize();
                Raizelement = (Element) document.getDocumentElement();
            }
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }private void crearArchivoXML() {
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            document = db.newDocument();
            Raizelement = document.createElement("medicamentos");
            document.appendChild(Raizelement);
            guardarXML("medicamentos.xml");
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void insertarMedicamento(String codigo,String nombre,String lote,String caducidad,double precio
    ,double iva,String laboratorio){
        
        Element medicamentoElement = document.createElement("medicamento");
        medicamentoElement.setAttribute("codigo", codigo);
        
        Element nombrelement = document.createElement("nombre");
        nombrelement.appendChild(document.createTextNode(nombre));
        medicamentoElement.appendChild(nombrelement);
        
        Element loteElemnt = document.createElement("lote");
        loteElemnt.appendChild(document.createTextNode(lote));
        medicamentoElement.appendChild(loteElemnt);
        
        Element caducidadElement = document.createElement("caducidad");
        caducidadElement.appendChild(document.createTextNode(caducidad));
        medicamentoElement.appendChild(caducidadElement);
        
        Element precioElement = document.createElement("precio");
        precioElement.appendChild(document.createTextNode(String.valueOf(precio)));
        medicamentoElement.appendChild(precioElement);
        
        Element ivaElement = document.createElement("Iva");
        ivaElement.appendChild(document.createTextNode(String.valueOf(iva)));
        medicamentoElement.appendChild(ivaElement);
        
        Element laboratorioElement = document.createElement("laboratorio");
        laboratorioElement.appendChild(document.createTextNode(laboratorio));
        medicamentoElement.appendChild(laboratorioElement);
        
        Raizelement.appendChild(medicamentoElement);
    }
    
    public void modificarLaboratorio(String codigo,String nuevoLaboratorio){
        Element medicamento = consultarMedicamento(codigo);
        if (medicamento != null) {
            Node laboratorioNode = medicamento.getElementsByTagName("laboratorio").item(0);
            laboratorioNode.setTextContent(nuevoLaboratorio);
        } else{
            System.out.println("EL medicamento con el código " + codigo + " no existe.");
        }
        
    }
    public Element consultarMedicamento(String codigo){
        NodeList medicamentos = Raizelement.getElementsByTagName("medicamento");
        for(int i = 0; i < medicamentos.getLength(); i++){
            Element medicamento = (Element) medicamentos.item(i);
            String codigoMedicamento = medicamento.getAttribute("codigo");
            if (codigoMedicamento.equals(codigo)){
                return medicamento;
            }
        }
        return null;
    }
    public void listarMedicamentos(int tipoListado,String laboratorio){
        NodeList medicamentos = Raizelement.getElementsByTagName("medicamento");
        switch (tipoListado) {
            case 1:
                System.out.println("***  LISTADO TOTAL DE MEDICAMENTOS   ***");
                for (int i = 0; i < medicamentos.getLength(); i++) {
                    Element medicamento = (Element) medicamentos.item(i);
                    String codigo = medicamento.getAttribute("codigo");
                    String nombre= medicamento.getElementsByTagName("nombre").item(0).getTextContent();
                    String lote = medicamento.getElementsByTagName("lote").item(0).getTextContent();
                    String caducidad = medicamento.getElementsByTagName("caducidad").item(0).getTextContent();
                    double precio = Double.parseDouble(medicamento.getElementsByTagName("precio").item(0).getTextContent());
                    double iva = Double.parseDouble(medicamento.getElementsByTagName("iva").item(0).getTextContent());
                    String laboratorioMed = medicamento.getElementsByTagName("laboratorio").item(0).getTextContent();
                    double importe = precio +( precio * iva/100);
                    
                    System.out.println("Código: " + codigo);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Lote: " + lote);
                    System.out.println("Caducidad: "+ caducidad);
                    System.out.println("Precio sin iva: " + precio + "€");
                    System.out.println("IVA: " + iva + "%");
                    System.out.println("Laboratorio: " + laboratorioMed);
                    System.out.println("Importe: " + importe + "€");
                }           
                break;
            case 2:
                System.out.println("***   LISTADO DE MEDICAMENTOS DEL LABORATORIO" + laboratorio + "  ***");
                for(int i = 0;i<medicamentos.getLength();i++){
                    Element medicamento = (Element) medicamentos.item(i);
                    String laboratorioMed = medicamento.getElementsByTagName("laboratorio").item(0).getTextContent();
                    if (laboratorioMed.equals(laboratorio)) {
                        String codigo = medicamento.getAttribute("codigo");
                    String nombre= medicamento.getElementsByTagName("nombre").item(0).getTextContent();
                    String lote = medicamento.getElementsByTagName("lote").item(0).getTextContent();
                    String caducidad = medicamento.getElementsByTagName("caducidad").item(0).getTextContent();
                    double precio = Double.parseDouble(medicamento.getElementsByTagName("precio").item(0).getTextContent());
                    double iva = Double.parseDouble(medicamento.getElementsByTagName("iva").item(0).getTextContent());
                    double importe = precio +( precio * iva/100);
                    
                    System.out.println("Código: " + codigo);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Lote: " + lote);
                    System.out.println("Caducidad: "+ caducidad);
                    System.out.println("Precio sin iva: " + precio + "€");
                    System.out.println("IVA: " + iva + "%");
                    System.out.println("Laboratorio: " + laboratorioMed);
                    System.out.println("Importe: " + importe + "€");
                        
                    }
                }
                break;
            default:
                System.out.println("Tipo de listado no valido.");
                break;
        }
    }
    public void guardarXML (String nombreArchivo){
        try{
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File(nombreArchivo));
            transformer.transform(source,result);
            System.out.println("Datos guardados correctamente en " + nombreArchivo);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        ReRepaso rr = new ReRepaso();
        Scanner sc = new Scanner(System.in);
        while (true) {            
            System.out.println("""
                                            MENÚ
                               1. Insertar Medicamento
                               2. Modificar laboratorio de un medicamento
                               3. Consultar medicamento
                               4. Listar medicamentos
                               5. Guardar cambios y salir
                               Seleccione una opción
                               """);
            int opc = sc.nextInt();
            sc.nextLine();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese los datos del nuevo medicamento:");
                    System.out.println("Código: ");
                    String codigo = sc.nextLine();
                    System.out.println("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.println("Lote: ");
                    String lote = sc.nextLine();
                    System.out.println("Caducidad (YYYY-MM-DD)");
                    String caducidad = sc.nextLine();
                    System.out.println("Precio (sin IVA)(introduzca con , no con .): ");
                    double precio = sc.nextDouble();
                    System.out.println("IVA (%) (introduzca con , no con .)");
                    double iva = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Laboratorio: ");
                    String laboratorio = sc.nextLine();
                    rr.insertarMedicamento(codigo, nombre, lote, caducidad, precio, iva, laboratorio);
                    break;
                case 2:
                    System.out.println("Ingrese el código del medicamento a modificar: ");
                    String codigoModificar = sc.nextLine();
                    String nuevoLab = sc.nextLine();
                    rr.modificarLaboratorio(codigoModificar, nuevoLab);
                    break;
                case 3:
                    System.out.println("Ingrese el código del medicamento a consultar: ");
                    String codigoConsulta = sc.nextLine();
                    Element medicamento = rr.consultarMedicamento(codigoConsulta);
                    if (medicamento!= null) {
                        System.out.println("***     INFORMACION DEL MEDICAMENTO     ***");
                        System.out.println("Código: " + medicamento.getAttribute("codigo"));
                        System.out.println("Nombre: " + medicamento.getElementsByTagName("nombre").item(0).getTextContent());
                        System.out.println("Lote: " + medicamento.getElementsByTagName("Lote").item(0).getTextContent());
                        System.out.println("Caducidad: " + medicamento.getElementsByTagName("Caducidad").item(0).getTextContent());
                        System.out.println("Precio: " + medicamento.getElementsByTagName("precio").item(0).getTextContent());
                        System.out.println("IVA: " + medicamento.getElementsByTagName("IVA").item(0).getTextContent());
                        System.out.println("Laboratorio: " + medicamento.getElementsByTagName("Laboratorio").item(0).getTextContent());
                    }else{
                        System.out.println("El medicamento no existe");
                    }   
                    break;
                case 4:
                    System.out.println("Seleccione el tipo de listado:");
                    System.out.println("1. Listado total de medicamentos");
                    System.out.println("2. Listado por laboratorio");
                    int tipoListado=sc.nextInt();
                    sc.nextLine();
                    if (tipoListado == 2) {
                        System.out.println("Ingrese el nombre del laboratorio: ");
                        String laboratorioListado = sc.nextLine();
                        rr.listarMedicamentos(2, laboratorioListado);
                    }else{
                        rr.listarMedicamentos(1, "");
                    }
                    break;
                case 5:
                    rr.guardarXML("medicamentos.xml");
                    System.out.println("SAliendo del programa");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opcion invalida. Seleccione una opcion valida");
            }
        }
    }
}
