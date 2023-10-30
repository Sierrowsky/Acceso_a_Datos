
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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
 * Crea un programa que lea archivo CSV (valores separados por comas) con datos de estudiantes,
 * calcula el promedio de sus calificaciones y escribe el resultado en otro fichero.
 * Supondremos que el formato del archivo CSV es: nombre,apellido,nota1,nota2,nota3.
 * 
 */
public class PracticaFicheros2_2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        String de = sc.next()+".scv";
        String pe = sc.next()+".scv";
        List<String> le = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(de))){
            String linea;
            while((linea = br.readLine())!=null){
                le.add(linea);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
        try(FileWriter fw = new FileWriter(pe)){
            fw.write("Nombre Apellido : Promedio\n");
            for(String linea : le){
                String[] datos = linea.split(",");
                String nombre = datos[0];
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
