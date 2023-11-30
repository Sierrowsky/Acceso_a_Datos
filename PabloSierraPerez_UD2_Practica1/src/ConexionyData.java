

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
    public static void consultaEmp(Connection conexion) {
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
    public static void consultaDni(Connection conexion) {
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
    public static void consultaSalSup(Connection conexion) {
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
    public static void consultaSalInf(Connection conexion) {
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
    public static void insertarEmp(Connection conexcion){
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
                System.out.println("Escriba la fecha de nacimiento (año-mes-dia) del empleado");
                String fechanac = sc.nextLine();
                // Convert fechanac to a java.sql.Date object
                java.sql.Date fechaNacimiento = java.sql.Date.valueOf(fechanac);
                System.out.println("Escriba NSS del superior");
                String nsss = sc.nextLine();
                System.out.println("Escriba el salario del empleado");
                int salario = sc.nextInt();
                System.out.println("Escriba el numero del departamento");
                int numdep = sc.nextInt();
                String sql = "INSERT INTO empleado VALUES ('" + nss + "', '" + nombre + "', '" + apellido1 +
                        "', '" + apellido2 + "', '" + sexo + "', '" + direccion + "', '" + fechaNacimiento + "', '" + salario +
                        "', '" + numdep + "', '" + nsss + "', '" + dni + "')";
                int rA = consulta.executeUpdate(sql);
                if(rA >0){
                    System.out.println("Empleado Insertado Correctamente");
                }else{
                    System.out.println("Error al insertar el empleado");
                }
            }else
                System.out.println("El dni del empleado ya existe");
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    } 
    public static void modifEmp(Connection conexion){
        sc = new Scanner(System.in);
        try {
            System.out.println("Modificacion de empleados");
            System.out.println("Introduzca el dni del empleado a modificar : ");
            String dni = sc.nextLine();
            Statement consulta = conexion.createStatement();
            String sqld = "Select * from empleado where nif = " + "'"+ dni+ "'" +";";
            ResultSet result = consulta.executeQuery(sqld);
            if(!result.next()){
                System.out.println("El empleado no existe");
            }else{
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
                System.out.println("Escriba la fecha de nacimiento (año-mes-dia) del empleado");
                String fechanac = sc.nextLine();
                // Convert fechanac to a java.sql.Date object
                java.sql.Date fechaNacimiento = java.sql.Date.valueOf(fechanac);
                System.out.println("Escriba NSS del superior");
                String nsss = sc.nextLine();
                System.out.println("Escriba el salario del empleado");
                int salario = sc.nextInt();
                System.out.println("Escriba el numero del departamento");
                int numdep = sc.nextInt();
                
                String sqlupdate = "UPDATE empleado SET NSS = '" + nss + "', Nombre = '" + nombre + "', Apel1 = '" + apellido1 +
                        "', Apel2 = '" + apellido2 + "', Sexo = '" + sexo + "', Dirección = '" + direccion + "', Fechanac = '" + fechaNacimiento +
                        "', Salario = " + salario + ", Numdept = " + numdep + ", NSSsup = '" + nsss + "' WHERE nif = '" + dni + "'";
                int rA = consulta.executeUpdate(sqlupdate);
                if(rA >0){
                    System.out.println("Empleado Modificado Correctamente");
                }else{
                    System.out.println("Error al Modificar el empleado");
                    }
            
                }
            }
        catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public static void deletEmp(Connection conexion){
        sc = new Scanner(System.in);
        try {
            System.out.println("Eliminacion de empleados");
            System.out.println("Ingrese el nif/dni del empleado que desea eliminar : ");
            String dni = sc.nextLine();
            Statement consulta = conexion.createStatement();
            String sqld = "Select * from empleado where nif = " + "'"+ dni+ "'" +";";
            ResultSet result = consulta.executeQuery(sqld);
            if(result.next()){
                String sqldel = "Delete from empleado where nif = '" + dni +"'";
                int rA = consulta.executeUpdate(sqldel);
                if(rA >0){
                    System.out.println("Empleado Eliminado Correctamente");
                }else{
                    System.out.println("Error al Eliminar el empleado");
                    }
            }
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void insertDep(Connection conexion) {
        sc = new Scanner(System.in);
        try {
            System.out.println("Inserccion de Departamentos");
            System.out.println("Ingrese el numero del departamento : ");
            int numDep = sc.nextInt();
            Statement consulta = conexion.createStatement();
            String sql = "Select * from departamento where Numdep = '" + numDep +"'";
            ResultSet result = consulta.executeQuery(sql);
            if (!result.next()) {
                sc = new Scanner(System.in);
                System.out.println("Escriba nombre del departamento");
                String nomDep = sc.nextLine();
                System.out.println("Escriba numero de empleados del departamento");
                int numEmp = sc.nextInt();
                sc = new Scanner(System.in);
                System.out.println("Escriba NSS del gerente del departamento");
                String numSegSocGer = sc.nextLine();
                System.out.println("Escriba Fecha de inicio del gerente del departamento");
                String fechaIniGer = sc.nextLine();
                java.sql.Date fechaInicGerente = java.sql.Date.valueOf(fechaIniGer);
                String sqldep = "Insert into departamento values('" + numDep + "','" + nomDep +
                        "','" +numEmp +"','" +numSegSocGer +"','" + fechaInicGerente +"');"; 
                int rA = consulta.executeUpdate(sqldep);
                if(rA >0){
                    System.out.println("Departamento Insertado Correctamente");
                }else{
                    System.out.println("Error al insertar el departamento");
                }
            }else
                System.out.println("El numero del departamento ya existe");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
    }
    public static void modifDep(Connection conexion){
        sc = new Scanner(System.in);
        try {
            System.out.println("Inserccion de Departamentos");
            System.out.println("Ingrese el numero del departamento : ");
            int numDep = sc.nextInt();
            Statement consulta = conexion.createStatement();
            String sql = "Select * from departamento where Numdep = '" + numDep +"'";
            ResultSet result = consulta.executeQuery(sql);
            if (result.next()) {
                sc = new Scanner(System.in);
                System.out.println("Escriba nombre del departamento");
                String nomDep = sc.nextLine();
                System.out.println("Escriba numero de empleados del departamento");
                int numEmp = sc.nextInt();
                sc = new Scanner(System.in);
                System.out.println("Escriba NSS del gerente del departamento");
                String numSegSocGer = sc.nextLine();
                System.out.println("Escriba Fecha de inicio del gerente del departamento");
                String fechaIniGer = sc.nextLine();
                java.sql.Date fechaInicGerente = java.sql.Date.valueOf(fechaIniGer);
                String sqlupdate = "UPDATE departamento SET Nombredep = '" + nomDep + "', Numempdep = '" + numEmp + "', NSSgerente = '" + numSegSocGer +
                        "', fechainicgerente = '" + fechaIniGer + "' WHERE Numdep = '" + numDep + "'";
              int rA = consulta.executeUpdate(sqlupdate);
                if(rA >0){
                    System.out.println("Departamento Modificado Correctamente");
                }else{
                    System.out.println("Error al Modificar el departamento");
                }
            }else
                System.out.println("El numero del departamento no existe");
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void delDep(Connection conexion){
        sc = new Scanner(System.in);
        try {
            System.out.println("Eliminacion de Departamentos");
            System.out.println("Ingrese el numero del departamento");
            int numDep = sc.nextInt();
            Statement consulta = conexion.createStatement();
            String sql = "Select * from departamento where Numdep = '" + numDep +"'";
            ResultSet result = consulta.executeQuery(sql);
            if (result.next()) {
                String sqls = "Delete from departamento where Numdep = '" + numDep +"'";
                int rA = consulta.executeUpdate(sqls);
                if(rA >0){
                    System.out.println("Departamento Eliminado Correctamente");
                }else{
                    System.out.println("Error al Eliminar el departamento");
                    }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    } 
    public static void listDep(Connection conexion) {
        try {
            Statement consulta = conexion.createStatement();
            String sql = "Select * from departamento";
            ResultSet rs = consulta.executeQuery(sql);
            while (rs.next()){
                System.out.println("Numero del departamento :" + rs.getString("Numdep"));
                System.out.println("Nombre del departamento :" +  rs.getString("Nombredep"));
                System.out.println("Numero de empleados del departamento :" + rs.getString("Numempdep"));
                System.out.println("Numero seguridad social del gerente :" + rs.getString("NSSgerente"));
                System.out.println("Fecha de inicio del gerente :" + rs.getString("fechainicgerente"));
                System.out.println("-----------------------------------------------------");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
                
    }
}
