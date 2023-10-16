/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import java.io.File;
import java.util.Scanner;
import java.util.Objects;
/**
 *
 * @author a21pablosp
 * 
 */

/**
 * 1.
 * Crear un programa que muestre por defecto un listado de los ficheros y directorios que contiene el directorio desde el que se ejecuta el programa.
 * Pero si se le pasa la ruta de un directorio o fichero, muestra la información acerca de él y, si se trata de un directorio,
 * muestra los ficheros y directorios que contiene.
 * @author a21pablosp
 */
public class PracticaFicheros1_1 {
    
    public static void main(String[] args) {
        System.out.println("Introduzca una ruta de ficheros o archivo: ");
        Scanner sc = new Scanner(System.in);
        File file = new File(sc.nextLine());
        if (file.isDirectory()){
            for(String listaDirectorios : Objects.requireNonNull((file.list()))){
                System.out.println(listaDirectorios);
            }
        }
        if(file.isFile()){
             System.out.println("El nombre del Archivo es: " + file.getName());
            System.out.println("El tamaño del Archivo es: " + file.length() / 1024);
            System.out.println("El Archivo tiene permiso de ejecucion?: " + file.canExecute());
            System.out.println("El Archivo tiene permiso de lectura?: " + file.canRead());
            System.out.println("El nombre tiene permiso de escritura?: " + file.canWrite());
            System.out.println("La ruta absoluta del Archivo es: " + file.getAbsolutePath());
        }
    }
}
