/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author a21pablosp
 * 
 */
/**
 * 
 * 1.
 *Desde el departamento de recursos humanos de Umbrella Corp, nos han pedido que diseñemos
 * una pequeña aplicación que les ayude a realizar la gestión de sus empleados. 
 *Esta aplicación debe almacenar la siguiente información de cada uno de los empleados.
 * • NIF 9 caracteres (8 números y 1 letra)
 * • Nombre → 10 caracteres
 * • Apellidos → 20 caracteres
 * • Salario La aplicación debe permitir la inserción, consulta, modificación y borrado de empleados.
 * • Consulta → Solicitará al usuario el NIF del empleado a
 *  ◦ Si existe mostrará su información, en caso contrario indicará que el empleado solicitado
 *    no existe.
 * • Inserción → Solicitará por teclado la información del nuevo empleado. Antes de insertar
 *  comprobará si el nuevo NIF ya existe:
 *  ◦ Si existe se debe informar al usuario.
 *  ◦ En caso contrario se insertará.
 * • Modificación → Se solicitará por teclado el NIF del empleado y el nuevo importe de su
 * salario.
 *  ◦En caso de no existir se informará al usuario.
 *  ◦En caso contrario se realizará la modificación.
 * • Borrado → Se solicitará el NIF del empleado a borrar por teclado. Haremos un borrado
 * lógico situando su NIF a 1.
 * •
 * Listar → Muestra todos los empleados (No borrados) existentes en el
 * Realiza una aplicación en Java que cumpla con todos los requisitos anteriores.
 * 
 */
public class EJ1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean sistem= true;
        while(sistem);
        System.out.println("""
                           MENÚ
                1. Consulta de Datos
                2. Inserción de Datos
                3. Modificación de Datos
                4. Borrado de Datos
                5. Listado de Datos
                6. Salir
                """);
        int opcion;
        System.out.println("Elija una opcion");
        opcion= sc.next;
        switch(opcion){
            case 1:
                consulta();
                break;
            case 2:
                insercion();
                break;
            case 3:
                modificacion();
                break;
            case 4:
                borrado();
                break;
            case 5:
                listado();
                break;
            case 6:
                sistem=false;
                break;
        }
    }
    
}
