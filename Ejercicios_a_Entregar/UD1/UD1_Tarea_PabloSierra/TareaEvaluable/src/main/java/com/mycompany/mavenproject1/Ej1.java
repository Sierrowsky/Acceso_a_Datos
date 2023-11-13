/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
/**
 *
 * @author P13si
 */
public class Ej1 {
    static Scanner sc;
    public static void main(String[] args){
        sc = new Scanner(System.in);
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
                    6. Salir         """);
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
                    menu = false;
                    break;
                default:
                    System.err.println("Introduzca una opcion valida.");
            }
           
        }
    }
    public static void insercion(ArrayList<Empleado> empleados){
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
            System.out.println("Introduzca el Nombre");
            String nombre = sc.nextLine();
            System.out.println("Introduzca los Apellidos");
            String apellidos = sc.nextLine();
            System.out.println("Introduzca el Salario");
            double salario = sc.nextDouble();
            empleados.add(new Empleado(dni,nombre,apellidos,salario));
            System.out.println("Empleado agregado correctamente");
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
}
