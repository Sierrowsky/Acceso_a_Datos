/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.sql.*;
import java.util.Scanner;
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
                    consultaemp();
                    break;
                case 2:
                    consultadni();
                    break;
                case 3:
                    consultass();
                    break;
                case 4:
                    consultasif();
                    break;
                case 5:
                    system = false;
                    break;
                default:
                    throw new AssertionError();
            }
        }
        
        // TODO code application logic here
        try {
            Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost/empleados","root","root");
        } catch (Exception e) {
        }
    }
    public static void consultaemp(String[] args) {
        
    }
    public static void consultadni(String[] args) {
        
    }
    public static void consultass(String[] args) {
        
    }
    public static void consultasif(String[] args) {
        
    }
}
