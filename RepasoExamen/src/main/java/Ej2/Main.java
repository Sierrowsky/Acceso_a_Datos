/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Ej2;


import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author P13si
 */
public class Main {
static Scanner sc;
    public static void main(String[] args) {
        sc = new Scanner (System.in);
        boolean salir = true;
        int opc;
        while(salir){
            System.out.println("""
                                        Menú
                               1.   Insertar
                               2.   Consultar
                               3.   Modificar
                               4.   Borrar
                               5.   Listar Todos    
                               6.   Salir
                               """);
            opc = sc.nextInt();
            switch(opc){
                case 1:
                    //Creamos una funcion
                    sc.nextLine();
                    Empleados trabajador = new Empleados();
                    System.out.println("Introduce Dni");
                    trabajador.setDni(sc.nextLine());
                    System.out.println("Introduce nombre");
                    trabajador.setNombre(sc.nextLine());
                    System.out.println("Introduce Apellidos");
                    trabajador.setApellidos(sc.nextLine());
                    System.out.println("Introduce Salario");
                    trabajador.setSalario(sc.nextDouble());
                    if(new Controlador().agregarEmpleado(trabajador)){
                        System.out.println("Empleado insertado");
                    }
                    else{
                        System.out.println("Empleado no insertado");
                    }
                    sc.nextLine();
                    break;
                case 2:                   
                    System.out.println("Introduce Dni: ");
                    String dni = sc.nextLine();
                    System.out.println(new Controlador().consultarEmpleado(dni));
                case 3:
                    sc.nextLine();
                    trabajador = new Empleados();
                    System.out.println("Introduce Dni");
                    trabajador.setDni(sc.nextLine());
                    System.out.println("Introduce nombre");
                    trabajador.setNombre(sc.nextLine());
                    System.out.println("Introduce Apellidos");
                    trabajador.setApellidos(sc.nextLine());
                    System.out.println("Introduce Salario");
                    trabajador.setSalario(sc.nextDouble());
                    if(new Controlador().modificarEmpleado(trabajador)){
                        System.out.println("Empleado modificado");
                    }
                    else{
                        System.out.println("Empleado no modificado");
                    }     
                    sc.nextLine();
                    break;
                case 4:
                    sc.nextLine();
                    trabajador = new Empleados();
                    System.out.println("Introduce Dni: ");
                    trabajador.setDni(sc.nextLine());
                    if(new Controlador().borrarEmpleado(trabajador)){
                        System.out.println("Empleado eliminado");
                    }
                    else{
                        System.out.println("Empleado no eliminado");
                    }
                    break;
                case 5:
                    ArrayList<Empleados> trabajadores = new Controlador().listaEmpleados();
                    for(Empleados empleado: trabajadores){
                        System.out.println(empleado);
                    }
                    break;
                case 6:
                    salir = false;
                    break;
                default:
                    break;
        }
    }
}
}