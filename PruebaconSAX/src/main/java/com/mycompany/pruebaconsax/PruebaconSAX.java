/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebaconsax;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
/**
 *
 * @author a21pablosp
 */
public class PruebaconSAX {

    public static void main(String[] args) {
        try{
        XMLReader procesadorxml = XMLReaderFactory.createXMLReader();
        procesadorxml.setContentHandler(new AlumnosReader());
        InputSource xmlFile=new InputSource("XML/alumnosSAX.xml");
        procesadorxml.parse(xmlFile);
        
        }catch (SAXException | IOExceptiion e){
            e.printStacTrace();}
    }
}
}
