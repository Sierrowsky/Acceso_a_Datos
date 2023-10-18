
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */

/**
 *
 * @author a21pablosp
 * 
 */
/**
 * 
 * (Parecido al ejercicio 2 de la parte I) Crea un programa que lea el contenido de un archivo de texto y cuente el número de líneas en él.
 * 
 */
public class PracticaFicheros2_1 {

    /**
     * @param args the command line arguments
     */
      public static void main(String[] Args){
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\a21pablosp\\Downloads\\versos.txt"))){
            String Lineas;
            int Nlineas=1;
            while((Lineas = br.readLine())!=null){
                Nlineas++;
            }
            System.out.println("El fichero tiene : "+ Nlineas);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
