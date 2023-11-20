/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package Ej2;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author a21pablosp
 */
/**
 *Desde el departamento de recursos humanos del Hospital Pupitas, nos han
 * pedido que diseñemos una pequeña aplicación que les ayude a realizar la
 * gestión de sus pacientes. Esta aplicación debe almacenar la siguiente
 * información de cada uno de los pacientes. (3,5 puntos)
 * La aplicación debe permitir las siguientes operaciones: 
 * • (0,75 puntos) Consulta → Solicitará al
 * usuario el NIF del paciente a consultar: ◦ Si existe mostrará su información,
 * en caso contrario indicará que el paciente solicitado no existe. 
 * • (1 puntos)
 * Inserción → Solicitará por teclado la información del nuevo paciente. Antes
 * de insertar comprobará si el nuevo NIF ya existe: ◦ Si existe se debe
 * informar al usuario. 
 * ◦ En caso contrario se insertará. 
 * • (0,75 puntos)
 * Borrado → Se solicitará el NIF del paciente a borrar por teclado. Haremos un
 * borrado lógico situando su NIF a -1. 
 * • (1 punto) Listar → Nos solicitará el
 * tipo de listado que queremos: 
 * ◦ 1. Total: Muestra un listado con todos los
 * pacientes existentes. 
 * ◦ 2. Listado de alergias: Se solicitará por teclado si
 * queremos los pacientes con alergias o sin alergias y según cual sea la
 * respuesta nos mostrará unos pacientes u otros. 
 * ◦ 3. Listado de asegurados: Se solicitará por teclado si 
 * queremos los pacientes privados o con S.S. y según
 * cual sea la respuesta nos mostrará unos pacientes u otros.
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    static Scanner sc;
    public static void main(String args[]) {
        // TODO code application logic here
        sc = new Scanner(System.in);
        int opc = 0;
        boolean est = true;
        while(est){
            System.out.println("""
                                            Menú
                               1.   Insercion
                               2.   Consulta
                               3.   Borrado
                               4.   Listar
                               5.   Salir                               
                               """);
            System.out.println("Elija una opcion : ");
            opc = sc.nextInt();
            
            switch(opc){
                case 1:
                    sc = new Scanner(System.in);
                    sc.nextLine();
                    
                    Paciente pacientes = new Paciente();
                    System.out.println("Introduzca el nif");
                    pacientes.setNif(sc.nextLine());
                    System.out.println("Introduzca el nombre");
                    pacientes.setNombre(sc.nextLine());
                    System.out.println("Introduzca el apellidos");
                    pacientes.setApellidos(sc.nextLine());
                    System.out.println("Introduzca el direccion");
                    pacientes.setDireccion(sc.nextLine());
                    System.out.println("Fecha de la ultima visita");
                    pacientes.setFechaultimavisita(sc.nextLine());
                    System.out.println("Alergias? (Si = 1/No = 0)");
                    pacientes.setAlergia(sc.nextBoolean());
                    System.out.println("Seguro privado o por seguridad social? (P/S)");
                    String tipo = sc.nextLine();
                    //pacientes.setTipo(tipo);
                    if(new Controlador().insercion(pacientes)){
                        System.out.println("El paciente fue registrado");
                    }else if (!new Controlador().insercion(pacientes)){
                        System.out.println("El paciente no fue registrado");
                    }
                    break;
                case 2:
                    sc = new Scanner(System.in);
                    System.out.println("Introduce el Nif");
                    System.out.println(new Controlador().consulta(sc.nextLine()));
                    break;
                case 3:
                    sc = new Scanner(System.in);
                    pacientes = new Paciente();
                    System.out.println("Introduce el Nif");
                    pacientes.setNif(sc.nextLine());
                    if(new Controlador().borrado(pacientes)){
                        System.out.println("Empleado borrado");
                    }else if(!new Controlador().borrado(pacientes)){
                        System.out.println("Empleado borrado");
                    }
                    break;
                case 4:
                    ArrayList<Paciente> ingresado = new Controlador().listapacientes();
                    for (Paciente paciente : ingresado) {
                        System.out.println(paciente);
                    }
                    break;
                case 5:
                    est = false;
                    break;
                default:
                    System.out.println("Introduzca una opcion valida");
            }
        }
        
    }
    
}
