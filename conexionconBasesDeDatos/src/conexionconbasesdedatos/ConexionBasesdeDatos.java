/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexionconbasesdedatos;

/**
 *
 * @author a21pablosp
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


/**
 *
 * @author a21pablosp
 */
public class ConexionBasesdeDatos {

    public static void main(String[] args) {
        //cargar el Driver
        try{
            //Establecemos la conexion con la BBDD
            Connection conexion =
                    DriverManager.getConnection("jdbc:mysql://localhost/empleados","root","root");
            /**
             * Preparamos la consulta
            Statement sentencia= conexion.createStatement();
            String sql = "Select * from empleado";
            ResultSet resultado = sentencia.executeQuery(sql);
            //Recorremos el resultSet obteniendo su contenido
            while(resultado.next()){
                String nif= resultado.getString(1);
                String nombre= resultado.getString(2);
                String apellidos=resultado.getString(3);
                Double salario=resultado.getDouble(8);
                //printeamos los resultados
                System.out.println(nif +" " + nombre +" "+ apellidos+" " + salario);
            }
            //Liberamos los recursos
            resultado.close();
            sentencia.close();
            conexion.close();
        */
            /**
            //Creacion de tablas
        
            Statement sentencia = conexion.createStatement();
            String sql = "Create table if not exists salarios("
                    + "codigo varchar(23),"
                    + "especialidad varchar(23),"
                    + "Constraint mascotas_PK PRIMARY KEY(codigo)"
                    + ");";
            int resultado = sentencia.executeUpdate(sql);
            System.out.println(resultado);
            conexion.close();
            sentencia.close();
            */
            
            //INSERCION DE DATOS
            Statement consulta = conexion.createStatement();
            String sql = "INSERT INTO salarios(codigo, especialidad) VALUES("
                    +"'001','Programador'),"
                    +"('002','Programador'),"
                    +"('003','Analista'),"
                    + "('004','Analista')";
            consulta = conexion.prepareStatement(sql);
            int n = consulta.executeUpdate(sql);
            if(n>0)
                System.out.println("Se ha insertado en la BBDD");
            
        }catch(SQLException e){
            e.printStackTrace();
        }
        
    }
    
}
