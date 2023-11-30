/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package javaapplication1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Scanner;

/**
 *
 * @author P13si
 */
public class main {

    /**
     * @param args the command line arguments
     * 
     */
    static Scanner sc ;
    public static void main(String[] args) {
        sc = new Scanner(System.in);
        boolean system = true;
        int opc1 = 0;
        try{
            
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
                    while(system2){
                    System.out.println("""
                                                Menu Empleados
                                       1.   Insertar empleado.
                                       2.   Modificar empleado.
                                       3.   Borrar empleado.
                                       4.   Listar todos los empleados.
                                       5.   Listar todos los empleados de un departamento.
                                       6.   Consultar empleados por nif/dni.
                                       7.   Consultar empleados que tengan un salario superior al introducido por el usuario.                                 
                                       8.   Consultar empleados que tengan un salario igual o inferior al introducido por el usuario. 
                                       9.   Salir
                                       """);
                    System.out.println("Introduce una opcion :");
                    opc2 = sc.nextInt();
                    switch (opc2) {
                        case 1:
                            Conector.insertE(pedirEmpleado());
                            break;
                        case 2:
                            Conector.modifE(pedirEmpleado());
                            break;
                        case 3:
                            System.out.print("Introduzca nif:");
                            String enif = new Scanner(System.in).nextLine();
                            Conector.eliminarE(enif);
                            break;
                        case 4:
                            Conector.listarEmpleados();
                            break;
                        case 5:
                            break;
                        case 6:
                            System.out.println("Introduzca un NIF");
                            sc = new Scanner(System.in);
                            String cnif = new Scanner(System.in).nextLine();
                            Conector.consultarNif(cnif);
                            break;
                        case 7:
                           System.out.print("Introduzca Salario:");
                           int salsup = new Scanner(System.in).nextInt();
                           Conector.consultarSalarioS(salsup);
                            break;
                        case 8:
                          System.out.print("Introduzca salario:");
                           int salario = new Scanner(System.in).nextInt();
                           Conector.consultarSalarioI(salario);
                            break;
                        case 9:
                            system2 = false;
                            break;
                        default:
                            throw new AssertionError();
                            
                    }
                    }
                    break;
                case 2:
                    boolean system3 = true;
                    int opc3 = 0;
                    while(system3){
                    System.out.println("""
                                                Menu Departamentos
                                       1.   Insertar departamento
                                       2.   Modificar departamento
                                       3.   Eliminar departamento
                                       4.   Listar todos los departamentos
                                       5.   Ver información de un único departamento
                                       6.   Salir
                                       """);
                    System.out.println("Introduce una opcion :");
                    opc3 = sc.nextInt();
                    switch (opc3) {
                        case 1:
                            Conector.insertD(pedirDepartamento());
                            break;
                        case 2:
                            Conector.modifD(pedirDepartamento());
                            break;
                        case 3:
                            System.out.print("Numero departamento: ");
                            int numero = new Scanner(System.in).nextInt();
                            Conector.eliminarD(numero);;
                            break;
                        case 4:
                            Conector.listarDept();
                            break;
                        case 5:
                            boolean system4 = true;
                            int opc4 = 0;
                            while(system4){
                            System.out.println("""
                                                        Menu info departamento
                                               1.   Por nombre
                                               2.  Por ID
                                               3.   Salir
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
                            }
                            break;
                        case 6:
                            break;
                        default:
                            throw new AssertionError();
                    }
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
    public static int pedirNumero() {
        System.out.print("Numero departamento: ");
        return new Scanner(System.in).nextInt();
    }
    public static Departamentos pedirDepartamento() {
        System.out.print("Numero departamento: ");
        int numero = new Scanner(System.in).nextInt();
        System.out.print("Nombre departamento: ");
        String nombre = new Scanner(System.in).nextLine();
        System.out.println("Escriba numero de empleados del departamento");
                int numEmp = sc.nextInt();
                sc = new Scanner(System.in);
                System.out.println("Escriba NSS del gerente del departamento");
                String numSegSocGer = sc.nextLine();
                System.out.println("Escriba Fecha de inicio del gerente del departamento");
                String fechaIniGer = sc.nextLine();
                java.sql.Date fechaInicGerente = java.sql.Date.valueOf(fechaIniGer);
        return new Departamentos(numero, nombre,numEmp,numSegSocGer,fechaInicGerente);
    }
    public static boolean validarNIF(String nif) {
        final int LONGITUD = 9;
        final String LETRAS = "TRWAGMYFPDXBNJZSQVHLCKE";

        if (nif.length() != LONGITUD) {
            return false;
        }
        char letra = Character.toUpperCase(nif.charAt(8));
        String numero = nif.substring(0, 8);

        try {
            int num = Integer.parseInt(numero);
            char letra2 = LETRAS.charAt(num % LETRAS.length());
            return letra == letra2;
        } catch (NumberFormatException e) {
            return false;
        }
    }
public static boolean validarNSS(int nss) {
        String nssString = String.valueOf(nss);
        return nssString.length() == 5;
    }

    public static boolean validarSexo(String sexo) {
        return sexo.equals("M") || sexo.equals("F");
    }

    public static Empleados pedirEmpleado() {
        Scanner scanner = new Scanner(System.in);
        String nif;
        do {
            System.out.print("NIF: ");
            nif = scanner.nextLine();
        } while (!validarNIF(nif));

        int nss;
        do {
            System.out.print("NSS: ");
            while (!scanner.hasNextInt()) {
                System.out.println("Por favor, ingrese un número válido para NSS.");
                System.out.print("NSS: ");
                scanner.next();
            }
            nss = scanner.nextInt();
        } while (!validarNSS(nss));

        scanner.nextLine();
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Apellido: ");
        String apellido1 = scanner.nextLine();
        System.out.print("Apellido2: ");
        String apellido2 = scanner.nextLine();
        String sexo;
        System.out.println("Escriba el numero del departamento");
        int numdep = sc.nextInt();
        System.out.println("Escriba la fecha de nacimiento (año-mes-dia) del empleado");
                String fechanac = sc.nextLine();
                // Convert fechanac to a java.sql.Date object
                java.sql.Date fechaNacimiento = java.sql.Date.valueOf(fechanac);
        System.out.println("Escriba NSS del superior");
                String nsss = sc.nextLine();
        do {
            System.out.print("Sexo: ");
            sexo = scanner.nextLine();
        } while (!validarSexo(sexo));

        System.out.print("Direccion: ");
        String direccion = scanner.nextLine();

        System.out.print("Salario: ");
        while (!scanner.hasNextInt()) {
            System.out.println("Salario incorrecto");
            System.out.print("Salario: ");
            scanner.next();
        }
        int salario = scanner.nextInt();

        scanner.nextLine();
        scanner.close();

        return new Empleados(nss, nombre, apellido1, apellido2, sexo, direccion,fechaNacimiento, salario,numdep,nsss, nif);
    }
}
    

