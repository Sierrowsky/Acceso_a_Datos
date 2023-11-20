package Ej1;

import java.io.File;
import java.util.Objects;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author a21pablosp
 */
    /**
     * Crear un programa que muestre por defecto un listado de los ficheros y
     * directorios que contiene el directorio desde el que se ejecuta
     * el programa. Si se le pasa la ruta de un directorio o fichero,
     * muestra la información acerca de él, y, si se trata de un directorio,
     * muestra los ficheros y directorios que contiene. (1,5 puntos)
     */
public class Main {

    /**
     * @param args the command line arguments
     */
    static Scanner sc ; 
   
    public static void main(String[] args) {
        System.out.println("Introduzca una ruta de 1 fichero o directorio.");
        sc = new Scanner(System.in);
        File ruta =new File(sc.nextLine());
        if(ruta.isDirectory()){
            System.out.println("Es un directorio.");
            for(String directorios: Objects.requireNonNull(ruta.list())){
                System.out.println(directorios);                
            }
        }
        else if (ruta.isFile()){
            System.out.println("Es un Archivo");
            System.out.println("Nombre : " + ruta.getName());
            System.out.println("Permiso de escritura : " + ruta.canWrite());
            System.out.println("Permiso de lectura : " + ruta.canRead());
            System.out.println("Permiso de ejecucion : " + ruta.canExecute());
            System.out.println("Peso : " + ruta.length()/1024 + "KB");
        }
    }
    
}
