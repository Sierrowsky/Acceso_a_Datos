

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a21pablosp
 */
public class ConexionyData {
    static Scanner sc ;
    public static void consultaemp(Connection conexion) {
        try {
            Statement consulta = conexion.createStatement();
            String sql = "Select * from empleado";
            ResultSet result = consulta.executeQuery(sql);
            while (result.next()){
                System.out.println("NSS :" + result.getString("NSS"));
                System.out.println("Nombre :" +  result.getString("Nombre"));
                System.out.println("Apellidos :" + result.getString("Apel1")+ " " + result.getString("Apel2"));
                System.out.println("Sexo :" + result.getString("Sexo"));
                System.out.println("Direccion :" + result.getString("Dirección"));
                System.out.println("Fecha Nacimiento :" + result.getString("Fechanac"));
                System.out.println("Salario :" + result.getInt("Salario"));
                System.out.println("Nº de departamento :" + result.getInt("Numdept"));
                System.out.println("NSS del superior :" + result.getString("NSSsup"));
                System.out.println("NIF : " + result.getString("NIF"));
                System.out.println("----------------------------------------------------------");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void consultadni(Connection conexion) {
        try {
            sc = new Scanner(System.in);
            System.out.println("Escriba un DNI del empleado : ");
            String dnibus = sc.nextLine();
            Statement consulta = conexion.createStatement();
            String sql = "Select * from empleado where NIF =" + "'" +dnibus +"';";
            ResultSet result = consulta.executeQuery(sql);
            while (result.next()){
                System.out.println("NSS :" + result.getString("NSS"));
                System.out.println("Nombre :" +  result.getString("Nombre"));
                System.out.println("Apellidos :" + result.getString("Apel1")+ " " + result.getString("Apel2"));
                System.out.println("Sexo :" + result.getString("Sexo"));
                System.out.println("Direccion :" + result.getString("Dirección"));
                System.out.println("Fecha Nacimiento :" + result.getString("Fechanac"));
                System.out.println("Salario :" + result.getInt("Salario"));
                System.out.println("Nº de departamento :" + result.getInt("Numdept"));
                System.out.println("NSS del superior :" + result.getString("NSSsup"));
                System.out.println("NIF : " + result.getString("NIF"));
                System.out.println("----------------------------------------------------------");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void consultass(Connection conexion) {
        try {
            sc = new Scanner(System.in);
            System.out.println("Escriba un salario : ");
            int salariobusq = sc.nextInt();
            Statement consulta = conexion.createStatement();
            String sql = "Select * from empleado where Salario >" + "'" +salariobusq +"';";
            ResultSet result = consulta.executeQuery(sql);
            while (result.next()){
                System.out.println("NSS :" + result.getString("NSS"));
                System.out.println("Nombre :" +  result.getString("Nombre"));
                System.out.println("Apellidos :" + result.getString("Apel1")+ " " + result.getString("Apel2"));
                System.out.println("Sexo :" + result.getString("Sexo"));
                System.out.println("Direccion :" + result.getString("Dirección"));
                System.out.println("Fecha Nacimiento :" + result.getString("Fechanac"));
                System.out.println("Salario :" + result.getInt("Salario"));
                System.out.println("Nº de departamento :" + result.getInt("Numdept"));
                System.out.println("NSS del superior :" + result.getString("NSSsup"));
                System.out.println("NIF : " + result.getString("NIF"));
                System.out.println("----------------------------------------------------------");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void consultasif(Connection conexion) {
         try {
            sc = new Scanner(System.in);
            System.out.println("Escriba un salario : ");
            int salariobusq = sc.nextInt();
            Statement consulta = conexion.createStatement();
            String sql = "Select * from empleado where Salario <=" + "'" +salariobusq +"';";
            ResultSet result = consulta.executeQuery(sql);
            while (result.next()){
                System.out.println("NSS :" + result.getString("NSS"));
                System.out.println("Nombre :" +  result.getString("Nombre"));
                System.out.println("Apellidos :" + result.getString("Apel1")+ " " + result.getString("Apel2"));
                System.out.println("Sexo :" + result.getString("Sexo"));
                System.out.println("Direccion :" + result.getString("Dirección"));
                System.out.println("Fecha Nacimiento :" + result.getString("Fechanac"));
                System.out.println("Salario :" + result.getInt("Salario"));
                System.out.println("Nº de departamento :" + result.getInt("Numdept"));
                System.out.println("NSS del superior :" + result.getString("NSSsup"));
                System.out.println("NIF : " + result.getString("NIF"));
                System.out.println("----------------------------------------------------------");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public static void insertaremp(Connection conexcion){
        sc = new Scanner(System.in);
        try{
            System.out.println("Insercion de empleado");
            System.out.println("Escriba el nif/dni del empleado");
            String dni = sc.nextLine();
            Statement consulta = conexcion.createStatement();
            String sqld = "Select * from empleado where nif = " + "'"+ dni+ "'" +";";
            ResultSet result = consulta.executeQuery(sqld);
            if(!result.next()){
                System.out.println("Escriba un NSS del empleado");
                String nss = sc.nextLine();
                System.out.println("Escriba el Nombre del empleado");
                String nombre = sc.nextLine();
                System.out.println("Escriba el Apellido 1 del empleado");
                String apellido1 = sc.nextLine();
                System.out.println("Escriba el Apellido 2 del empleado");
                String apellido2 = sc.nextLine();
                System.out.println("Escriba el sexo del empleado");
                String sexo = sc.nextLine();
                System.out.println("Escriba la direccion del empleado");
                String direccion = sc.nextLine();
                System.out.println("Escriba la fecha de nacimiento(año-mes-dia) del empleado");
                String fechanac = sc.nextLine();
                System.out.println("Escriba NSS del superior");
                String nsss = sc.nextLine();
                System.out.println("Escriba el salario del empleado");
                int salario = sc.nextInt();
                System.out.println("Escriba el numero del departamento");
                int numdep = sc.nextInt();
                String sql = "Insert into empleado values(" + "'"+ nss+ "'"+ "," + "'"+ nombre + "'"+ "," + "'"+ apellido1 + "'"+ 
                        "," + "'"+ apellido2 + "'"+ ","+ sexo + "'"+ ","+ "'"+ direccion + "'"+ ","+ "'"+ fechanac + "'"+ ","+ "'"+ salario + "'"+
                        "," + "'"+ numdep + "'"+ "," + nsss + "'"+ "," + "'"+ dni + "'" +");";
                consulta.executeQuery(sql);
            }else
                System.out.println("El dni del empleado ya existe");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
}
