/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject1;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
 * • Salario 
 *  La aplicación debe permitir la inserción, consulta, modificación y borrado de empleados.
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
    static Scanner sc;
    static File file = new File("./XML/Empleados.txt");
    static File temp = new File("./XML/EmpleadosTemp.txt");
    private static void creacionFichero(File file){
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch(IOException e){
                throw new RuntimeException(e);
            }
        }
    }
    public static void insercion(){
        creacionFichero(file);
        sc= new Scanner (System.in);
        System.out.println("Introduzca el DNI del Empleado:");
        String nif = sc.nextLine();
        System.out.println("Introduzca el nombre del Empleado: ");
        String nombre = sc.nextLine();
        System.out.println("Introduzca el apellido del Empleado: ");
        String apellidos = sc.nextLine();
        System.out.println("Introduzca el sueldo del Empleado: ");
        double sueldo = sc.nextDouble();
        Empleado empleado = new Empleado(nif, nombre, apellidos, sueldo);
        try(MyObjectOutputStream moos = new MyObjectOutputStream(new FileOutputStream(file,true))){
            moos.writeObject(empleado);
        }catch(IOException e){
            throw new RuntimeException(e);
        }
    } 
    public static void consulta(){
        creacionFichero(file);
        System.out.println("Introduzca el DNI del empleado");
        sc = new Scanner(System.in);
        int cont = 0;
        String dni = sc.next();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            Empleado empleado;
            while(true){
                empleado=(Empleado) ois.readObject();
                if(dni.equalsIgnoreCase(empleado.getNif())){
                System.out.print(empleado);
                cont++;
                }
            }
        }catch(EOFException e){
            System.out.println("Fin del archivo");
            if (cont == 0){
                System.out.println("No hay empleados registrados");
            }
        }
        catch (IOException | ClassNotFoundException e){
            throw new RuntimeException (e);
        }
    }
    public static void modificacion(){
        creacionFichero(temp);
        sc = new Scanner(System.in);
        System.out .println("Introduce el dni del empleado a modificar");
        String dni = sc.nextLine();
        int cont=0;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            MyObjectOutputStream mtoos = new MyObjectOutputStream(new FileOutputStream(temp, true))){
            Empleado empleado;
            while(true){
                empleado=(Empleado) ois.readObject();
                if(empleado.getNif().equalsIgnoreCase(dni)){
                    System.out.println("Introduzca el salario modificado");
                    empleado.setSalario(sc.nextDouble());
                    System.out.println(empleado.getNif() + " " + empleado.getNombre() + " " + empleado.getApellidos() + " " + empleado.getSalario());
                    mtoos.writeObject(empleado);
                }else{
                    mtoos.writeObject(empleado);
                    cont++;
                }
                
            }
        }catch (EOFException e){
            System.out.println("Fin del archivo");
            file.delete();
            temp.renameTo(file);
            if (cont == 0){
                System.out.println("No hay empleados registrados");
            }
        }catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void borrado(){
        creacionFichero(temp);
        sc = new Scanner(System.in);
        System.out .println("Introduce el dni del empleado a eliminar");
        String dni = sc.nextLine();
        int cont=0;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
            MyObjectOutputStream mtoos = new MyObjectOutputStream(new FileOutputStream(temp, true))){
            Empleado empleado;
            while(true){
                empleado=(Empleado) ois.readObject();
                if(!empleado.getNif().equalsIgnoreCase(dni)){
                    mtoos.writeObject(empleado);
                }else{
                    System.out.println("Se ha eliminado el empleado" + empleado);
                }
            }
        }catch (EOFException e){
            System.out.println("Fin del archivo");
            file.delete();
            temp.renameTo(file);
            if (cont == 0){
                System.out.println("No hay empleados registrados");
            }
        }catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public static void listado(){
        creacionFichero(file);
        int cont = 0;
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            Empleado empleado;
            while(true){
                empleado = (Empleado) ois.readObject();
                System.out.println(empleado);
                cont++;
            }
        }catch (EOFException e) {
            System.out.println("Fin del archivo");
            if (cont == 0){
                System.out.println("No hay alumnos registrados");
            }
        }
        catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        sc = new Scanner(System.in);
        boolean sistem= true;
        while(sistem){
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
        opcion= sc.nextInt();
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
}
