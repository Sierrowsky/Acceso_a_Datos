/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
/**
 *
 * @author a21pablosp
 * 
 */
/**
 * 
 * Crear un programa que muestre los contenidos de un fichero de texto línea a línea, numerando las líneas. (readLine de BufferedReader)
 *
 */
public class PracticaFicheros1_2 {
    public static void main(String[] Args){
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\a21pablosp\\Downloads\\versos.txt"))){
            String Lineas;
            int Nlineas=1;
            while((Lineas = br.readLine())!=null){
                System.out.println(Nlineas + " " + Lineas);
                Nlineas++;
            }
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
    
}
