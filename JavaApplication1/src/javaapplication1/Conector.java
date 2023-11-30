/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import javaapplication1.Empleados;
import javaapplication1.Departamentos;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

/**
 *
 * @author P13si
 */

public class Conector {
    static Connection conexion;
    static PreparedStatement statement = null;
    static ResultSet resultado = null;
    public static void conexion() throws SQLException{
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/empleados","root","root");
    }
    public static void mostrar(ResultSet resultado)throws SQLException{
        while(resultado.next()){
             System.out.println("NSS :" + resultado.getString("NSS"));
                System.out.println("Nombre :" +  resultado.getString("Nombre"));
                System.out.println("Apellidos :" + resultado.getString("Apel1")+ " " + resultado.getString("Apel2"));
                System.out.println("Sexo :" + resultado.getString("Sexo"));
                System.out.println("Direccion :" + resultado.getString("Dirección"));
                System.out.println("Fecha Nacimiento :" + resultado.getString("Fechanac"));
                System.out.println("Salario :" + resultado.getInt("Salario"));
                System.out.println("Nº de departamento :" + resultado.getInt("Numdept"));
                System.out.println("NSS del superior :" + resultado.getString("NSSsup"));
                System.out.println("NIF : " + resultado.getString("NIF"));
                System.out.println("=======================================================");
        }
    }
    public static void mostrarDep(ResultSet resultado)throws SQLException{
        while (resultado.next()){
                System.out.println("Numero del departamento :" + resultado.getString("Numdep"));
                System.out.println("Nombre del departamento :" +  resultado.getString("Nombredep"));
                System.out.println("Numero de empleados del departamento :" + resultado.getString("Numempdep"));
                System.out.println("Numero seguridad social del gerente :" + resultado.getString("NSSgerente"));
                System.out.println("Fecha de inicio del gerente :" + resultado.getString("fechainicgerente"));
                System.out.println("-----------------------------------------------------");
        }
    }
    public static void listarDept() {
        try{
            conexion();
            statement = conexion.prepareStatement("Select * from departamento");       
            resultado = statement.executeQuery();            
            mostrarDep(resultado);
            statement.close();
            conexion.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void listarEmpleados(){        
        try{
            conexion();
            statement = conexion.prepareStatement("Select * from empleado");       
            resultado = statement.executeQuery();            
            mostrar(resultado);
            statement.close();
            conexion.close();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void consultarNif(String nif){        
        try {
            conexion();
            String sql = "Select *from empleado where nif =?";
            PreparedStatement statement = conexion.prepareStatement(sql);            
            statement.setString(1, nif);
            ResultSet resultado = statement.executeQuery();
            mostrar(resultado);
            statement.close();
            conexion.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
        public static void consultarSalarioS(int salario) {
       

        try{
            conexion();
           String consulta = "SELECT * FROM empleado WHERE salario > ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setDouble(1, salario);
            ResultSet resultado = statement.executeQuery();

            mostrar(resultado);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void consultarSalarioI(int salario) {
        

        try{
            conexion();
            String consulta = "SELECT * FROM empleado WHERE salario <= ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setDouble(1, salario);
            ResultSet resultado = statement.executeQuery();

            mostrar(resultado);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    

    public static void eliminarD(int numero)  {
        
        
        try{
            conexion();
            String consulta = "DELETE FROM departamento WHERE Numdep = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, numero);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    public static void insertD(Departamentos depart)  {
        
        try{
            conexion();
            String consulta = "INSERT INTO departamento (Numdep, Nombredep,Numempdep,NSSgerente,fechainicgerente) VALUES (?,?,?,?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, depart.Numdep);
            statement.setString(2, depart.Nombredep);
            statement.setInt(3, depart.Numempdep);
            statement.setInt(4, depart.NSSgerente);
            statement.setString(5, depart.FechaInicGer);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    public static void modifD(Departamentos depart)  {
        
        try{
            conexion();
            String consulta = "UPDATE departamento SET Nombredep = ? WHERE Numdep = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, depart.Nombredep);
            statement.setInt(2, depart.Numdep);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    public static void insertE(Empleados emp)  {
        
        try{
            conexion();
            String consulta = "INSERT INTO empleado (NSS, Nombre, Apel1, Apel2, Sexo, Dirección,Fechanac, Salario,Numdept,NSSsup, NIF) VALUES (?,?,?,?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, emp.NSS);
            statement.setString(2, emp.Nombre);
            statement.setString(3, emp.Apel1);
            statement.setString(4, emp.Apel2);
            statement.setString(5, emp.Sexo);
            statement.setString(6, emp.FechaNac);
            statement.setString(7, emp.Direccion);
            statement.setInt(8, emp.Salario);
            statement.setInt(9, emp.Salario);
            statement.setString(10, emp.NSSsup);
            statement.setString(11, emp.NIF);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    public static void modifE(Empleados emp)  {
        try{
            conexion();
            String consulta = "UPDATE empleado SET NSS = ?, Nombre = ?, Apel1 = ?, Apel2 = ?, Sexo = ?, Dirección = ?, Salario = ? WHERE NIF = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setInt(1, emp.NSS);
            statement.setString(2, emp.Nombre);
            statement.setString(3, emp.Apel1);
            statement.setString(4, emp.Apel2);
            statement.setString(5, emp.Sexo);
            statement.setString(6, emp.FechaNac);
            statement.setString(7, emp.Direccion);
            statement.setInt(8, emp.Salario);
            statement.setInt(9, emp.Salario);
            statement.setString(10, emp.NSSsup);
            statement.setString(11, emp.NIF);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }

    public static void eliminarE(String nif)  {
        
        try{
            conexion();
            String consulta = "DELETE FROM empleado WHERE NIF = ?";
            PreparedStatement statement = conexion.prepareStatement(consulta);
            statement.setString(1, nif);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            
        }
    }
}
