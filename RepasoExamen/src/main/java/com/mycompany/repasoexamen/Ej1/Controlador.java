/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.repasoexamen.Ej1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author P13si
 */
public class Controlador {
    /**
     * Representa el tamaño total de un registro de empleado en el archivo.
     * El DNI se almacena como una cadena de 9 caracteres.
     * El nombre se alamacena como una cadena de 10 caracteres.
     * El apellido se almacena como una cadena de 10 caracteres.
     * El salario es un double, que generalmente ocupa 8 bytes.
     * 
     * Sumando setos tamaños : 9+10+10+8 = 37
     * 
     * 66 se eligió para que haya suficiente espacio para almacenar cada campo,
     * incluso si los datos reales son más cortos.
     */
    private final int tamañoRegistro= 66;
    /**
     * Se utiliza para realizar operaciones de lectura y escritura
     * en un acrchivo de accesp aleatorio.
     */
    private RandomAccessFile raf;
    private String ruta;
    /**
     * Establecemos la ruta predeterminada del archivo en :
     * './ListaDatosEmpleado.dat'
     * Comprobamos si el archivo existe y de no ser así, lo creamos.
     */
    public Controlador(){
        ruta = "./ListaDatosEmpleado.dat";
        File archivo = new File(ruta);
        if(!archivo.exists()){
            try{
                archivo.createNewFile();
            }catch (IOException e){
                e.printStackTrace();
         }
        }
    }
    /**
     * Añadimos un nuevo empleado al archivo
     * Verificamos si la posición para los datos del empleado en
     * el archivo no está en uso.
     * Si la posicion está disponible, abre el archivo en 
     * modo lectura-escritura, busaca la posicion adecuada y
     * escribe la informacion del empleado(Dni ,Nombre, Apellidos, Salario)
     * en el archivo.
     */
    public boolean agregarEmpleado(Empleados trabajador){
        //El fichero tiene un maximo de 10 empleados
        //La existencia o no de un empleado
        //viene dada por su posicion en el mismo
        if(!positionInUse(getPosition(trabajador.getDni()))){
            try{
                /**
                 * Mode: son los permisos --> read(r) write (w)
                 */
                //Insertamos el empleado
                raf = new RandomAccessFile(new File(this.ruta),"rw");
                if(raf.length()<=0){
                    raf.write(0);
                }
                raf.seek(getPosition(trabajador.getDni())* tamañoRegistro);
                //Escribimos las cosas
                StringBuffer sb = new StringBuffer(trabajador.getDni());
                sb.setLength(9);
                raf.writeChars(sb.toString());
                sb = new StringBuffer(trabajador.getNombre());
                sb.setLength(10);
                raf.writeChars(sb.toString());
                sb = new StringBuffer(trabajador.getApellidos());
                sb.setLength(10);
                raf.writeChars(sb.toString());
                raf.writeDouble(trabajador.getSalario());
                raf.close();
                return true;
                           
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
                return false;
            }
            catch (IOException e){
                e.printStackTrace();
                return false;
            }
        }
        else{
            return false;
        }
    }
    /**
     * Modificamos el salario deun empleado exisente en el archivo.
     * Comporbamos si la posicion para los datos del empleado estan en uso.
     * Si la posicion es valida, abre el archivo en modo lectura-escritura,
     * busca la posicion adecuada y actualiza la informacion del salario,
     */
    public boolean modificarSalario(Empleados trabajador){
        if(positionInUse(getPosition(trabajador.getDni()))){
            try{
                //Insertamos el empleado
                raf = new RandomAccessFile(new File(this.ruta),"ruta");
                raf.seek(getPosition(trabajador.getDni()) * tamañoRegistro);
                //Escribimos las cosas
                StringBuffer sb = new StringBuffer(trabajador.getDni());
                sb.setLength(9);
                raf.writeChars(sb.toString());
                sb = new StringBuffer(trabajador.getNombre());
                sb.setLength(10);
                raf.writeChars(sb.toString());
                sb = new StringBuffer(trabajador.getApellidos());
                sb.setLength(10);
                raf.writeChars(sb.toString());
                raf.writeDouble(trabajador.getSalario());
                raf.close();
                return true;
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
                return false;
            }
            catch (IOException e){
                e.printStackTrace();
                return false;
            }
        }
        else{
            return false;
        }
    }
    /**
     * Eliminadcion de un emopleado existente en el archivo
     * Comporbamos si la posicion para los datos del empleado está en uso.
     * Si la posicion es válida, abre ele archivo en modo lectura-escritura,
     * busca la posicion adecuada y escribe caracteres vacíos para marcar
     * la posicion como no utilizada
     */
    public boolean borrarEmpleado(Empleados trabajador){
        if(positionInUse(getPosition(trabajador.getDni()))){
        //Insertamos al empleado
        try{
            raf = new RandomAccessFile(new File(this.ruta),"rw");
            raf.seek(getPosition(trabajador.getDni())*tamañoRegistro);
            //Escribimos
            StringBuffer sb = new StringBuffer(" ");
            sb.setLength(9);
            raf.writeChars(sb.toString());
            raf.close();
            return true;
        }
        catch(FileNotFoundException e){
            return false;
        }
        catch(IOException e){
            return false;
        }
        }else{
                return false;
                }
    }
    /**
     * Recuperamos y devolvemos los datos de un empleado según el DNI proporcionado
     * COmporbamos si la posicion está en uso.
     * Si la posicion es válid, abrimos el archivo en modo RW, buscamos la posicion
     * adecuada, leemos la informacion del empleado y la devolvemos como un objeto empleado
     */
    public Empleados consultarEmpleado(String Dni) {
    if (positionInUse(getPosition(Dni))) {
        try {
            // Insertamos al empleado
            raf = new RandomAccessFile(new File(this.ruta), "r");
            raf.seek(getPosition(Dni) * tamañoRegistro);

            // DNI
            String dni = "";
            for (int i = 0; i < 9; i++)
                dni += raf.readChar();

            // Nombre
            String Nombre = "";
            for (int i = 0; i < 10; i++)
                Nombre += raf.readChar();

            // Apellidos
            String apellidos = "";
            for (int i = 0; i < 10; i++)
                apellidos += raf.readChar();

            // Salario
            double Salario = raf.readDouble();

            return new Empleados(dni, Nombre, apellidos, Salario);
        } catch (FileNotFoundException e) {
            return null;
        } catch (IOException e) {
            return null;
        }
    } else {
        return null;
    }
}
    /**
     * Recupera y devuelve una lista de todos los empleado en el archivo.
     * lee el archivo secuencialmente, extrayendo la informacion del empleado
     * y agregandola a un ArrayList<Empleados>
     * Omite las posiciones donde no hay datos de empleados
     */
    public ArrayList<Empleados> listaEmpleados() {
    try {
        ArrayList<Empleados> trabajadores = new ArrayList<>();
        raf = new RandomAccessFile(new File(this.ruta), "r");
        for (int posicion = 0; posicion < raf.length(); posicion += this.tamañoRegistro) {
            // DNI
            String Dni = "";
            for (int i = 0; i < 9; i++)
                Dni += raf.readChar();

            // Nombre
            String Nombre = "";
            for (int i = 0; i < 10; i++)
                Nombre += raf.readChar();

            // Apellidos
            String Apellidos = "";
            for (int i = 0; i < 10; i++)
                Apellidos += raf.readChar();

            // Salario
            double Salario = raf.readDouble();

            trabajadores.add(new Empleados(Dni, Nombre, Apellidos, Salario));
        }
        return trabajadores;
    } catch (FileNotFoundException e) {
        e.printStackTrace();
        return null;
    } catch (IOException e) {
        e.printStackTrace();
        return null;
    }
}
    /**
     * Calcular y devolver la posicion en el archivo según el ultimo digito
     * del numero del DNI
     */
    private int getPosition(String dni){
        return Integer.valueOf(dni.substring(0, dni.length()-1)) % 10;
    }
    /**
     * Comprobamos si la posicion especificada en  el archivo esta en uso leyendo el char 
     * en esa posicion.
     * Devuelve true si la posicon está en uso, false si no.
     */
    public boolean positionInUse(int position){
        try{
            raf=new RandomAccessFile(new File(this.ruta),"r");
            raf.seek(position * this.tamañoRegistro);
            if(raf.readChar()== ' '){
                raf.close();
                        return false;
            }
            else{
                raf.close();
                return true;
            }
        }
        catch(FileNotFoundException e){
            
        }
        catch (IOException e){
            return false;
        }
        return true;
    }
}
