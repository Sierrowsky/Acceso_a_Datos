/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hibernate;
/**
 *
 * @author a21pablosp
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Conexion {

    static Connection conexion;

    public static void conexion() throws SQLException {
        conexion = DriverManager.getConnection("jdbc:mysql://localhost/empleados_departamentos", "root", "root");
    }
}
