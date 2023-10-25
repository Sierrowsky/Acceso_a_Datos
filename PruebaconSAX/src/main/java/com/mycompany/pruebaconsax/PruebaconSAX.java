/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.pruebaconsax;
import java.io.IOException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.*;
import org.xml.sax.helpers.*;
/**
 *
 * @author a21pablosp
 */
public class PruebaconSAX {

    public static void main(String[] args){
        try{
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser = factory.newSAXParser();
        AlumnosReader handler = new AlumnosReader();
        parser.parse("XML/librosinfoSAX.xml", handler);
        
        }catch (SAXException | IOException | ParserConfigurationException e ){
            e.printStackTrace();}
    }
}
