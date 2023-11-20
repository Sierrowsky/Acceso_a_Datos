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
        int opc = 0;
        try{
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empleados","root","root");
        while(system){
            System.out.println("""
                                        Menu
                           1.   Consultar todos los empleados.
                           2.   Consultar empleados por dni/nif.
                           3.   Consultar empleados que tengan un salario superior al introducido por el usuario.
                           4.   Consultra empleados que tengan un salario igual o inferior al introducido por el usuario.
                           """);
            System.out.println("Introduce una opcion :");
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    consultaemp(conexion);
                    break;
                case 2:
                    consultadni(conexion);
                    break;
                case 3:
                    consultass( conexion);
                    break;
                case 4:
                    consultasif(conexion);
                    break;
                case 5:
                    system = false;
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
        // TODO code application logic here

            
        } catch (Exception e) {
        }
    }
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
}
