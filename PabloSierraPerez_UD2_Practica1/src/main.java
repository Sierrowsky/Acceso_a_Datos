/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

import java.sql.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author a21pablosp
 */
public class main {

    /**
     * @param args the command line arguments
     */
    static Scanner sc ;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        boolean system = true;
        int opc1 = 0;
        try{
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empleados","root","root");
        while(system){
            System.out.println("""
                                        Menu
                           1.   Gestión empleados.
                           2.   Gestión de departamentos
                           3.   Salir.
                           """);
            System.out.println("Introduce una opcion :");
            opc1 = sc.nextInt();
            switch (opc1) {
                case 1:
                    boolean system2= true;
                    int opc2 = 0;
                    System.out.println("""
                                                Menu Empleados
                                       a.   Insertar empleado.
                                       b.   Modificar empleado.
                                       c.   Borrar empleado.
                                       d.   Listar todos los empleados.
                                       e.   Listar todos los empleados de un departamento.
                                       f.   Consultar empleados por nif/dni.
                                       g.   Consultar empleados que tengan un salario superior al introducido por el usuario.                                 
                                       h.   Consultar empleados que tengan un salario igual o inferior al introducido por el usuario. 
                                       s.   Salir
                                       """);
                    System.out.println("Introduce una opcion :");
                    opc2 = sc.nextInt();
                    switch (opc2) {
                        case 1:
                            ConexionyData.insertarEmp(conexion);
                            break;
                        case 2:
                            ConexionyData.modifEmp(conexion);
                            break;
                        case 3:
                            ConexionyData.deletEmp(conexion);
                            break;
                        case 4:
                            ConexionyData.consultaEmp(conexion);
                            break;
                        case 5:
                            break;
                        case 6:
                            ConexionyData.consultaDni(conexion);
                            break;
                        case 7:
                            ConexionyData.consultaSalSup(conexion);
                            break;
                        case 8:
                            ConexionyData.consultaSalInf(conexion);
                            break;
                        case 9:
                            system2 = false;
                            break;
                        default:
                            throw new AssertionError();
                            
                    }
                    break;
                case 2:
                    boolean system3 = true;
                    int opc3 = 0;
                    System.out.println("""
                                                Menu Departamentos
                                       a.   Insertar departamento
                                       b.   Modificar departamento
                                       c.   Eliminar departamento
                                       d.   Listar todos los departamentos
                                       e.   Ver información de un único departamento
                                       s.   Salir
                                       """);
                    System.out.println("Introduce una opcion :");
                    opc3 = sc.nextInt();
                    switch (opc3) {
                        case 1:
                            ConexionyData.insertDep(conexion);
                            break;
                        case 2:
                            ConexionyData.modifDep(conexion);
                            break;
                        case 3:
                            ConexionyData.delDep(conexion);
                            break;
                        case 4:
                            ConexionyData.listDep(conexion);
                            break;
                        case 5:
                            boolean system4 = true;
                            int opc4 = 0;
                            System.out.println("""
                                                        Menu info departamento
                                               i.   Por nombre
                                               ii.  Por ID
                                               s.   Salir
                                               """);
                            System.out.println("Introduce una opcion :");
                            opc4 = sc.nextInt();
                            switch (opc4) {
                                case 1:
                                    break;
                                case 2:
                                    break;
                                case 3:
                                    system4 = false;
                                    break;
                                default:
                                    throw new AssertionError();
                                    
                            }
                            break;
                        case 6:
                            break;
                        default:
                            throw new AssertionError();
                            
                    }
                    break;
                case 3:
                    system=false;
                    break;
                default:
                    throw new AssertionError();
                   
            }
        }
        
        // TODO code application logic here

            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
   
}
