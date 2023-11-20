/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 *
 * @author a21pablosp
 */

public class Controlador {
    private final int tamañoRegistro = 128;
    private  RandomAccessFile raf;
    private  String ruta;
    public Controlador() {
        ruta = "./listapacientes.dat";
        File file = new File(ruta);

        if (!file.exists()){
            try {
                file.createNewFile();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public boolean insercion(Paciente pacientes){
        if (!posicionenuso(posicion(pacientes.getNif()))) {
            try{
                raf= new RandomAccessFile (new File(ruta),"rw");
               if(raf.length() <= 0){
                    raf.write(0);
                }
                raf.seek(posicion(pacientes.getNif()) * tamañoRegistro);
                
                StringBuffer sb = new StringBuffer(pacientes.getNif());
                sb.setLength(9);
                raf.writeChars(sb.toString());
                sb = new StringBuffer(pacientes.getNombre());
                sb.setLength(15);
                raf.writeChars(sb.toString());
                sb = new StringBuffer(pacientes.getApellidos());
                sb.setLength(25);
                raf.writeChars(sb.toString());
                sb=new StringBuffer(pacientes.getDireccion());
                sb.setLength(30);
                raf.writeChars(sb.toString());
                sb=new StringBuffer(pacientes.getFechaultimavisita());
                sb.setLength(9);
                raf.writeChars(sb.toString());
                raf.writeBoolean(pacientes.getAlergia());
                raf.writeChar(pacientes.getTipo());
                raf.close();
                return true;
            
        }
            catch(FileNotFoundException e){
                e.printStackTrace();
                return false;
            }
            catch(IOException e){
                e.printStackTrace();
                return false;
            }
                        
        }else{
            return false;
        }
            
            
    }
    public Paciente consulta(String nif){
        if(!posicionenuso(posicion(nif))) {
            try{
               raf= new RandomAccessFile (new File(ruta),"rw");
               if(raf.length() <= 0){
                    raf.write(0);
                }
               
                nif = "";
                for(int i = 0; i < 9; i++)
                    nif += raf.readChar();
                
                String nombre = "";
                for(int i = 0; i < 15; i++)
                    nombre += raf.readChar();
                
                String apellidos = "";
                for(int i = 0; i < 25; i++)
                    apellidos += raf.readChar();
                
                String direccion = "";
                for(int i= 0; i <30;i++)
                    direccion += raf.readChar();
                
                String fecha = "";
                for(int i = 0; i<9;i++)
                    fecha +=raf.readChar();
                
                Boolean alergia = raf.readBoolean();
                
                char tipo = ' ';
                    for (int i = 0; i<2;i++)
                        tipo += raf.readChar(); 
                    
               return new Paciente(nif,nombre,apellidos,direccion,fecha,alergia,tipo);
               
    
            }
            catch(FileNotFoundException e){
                e.printStackTrace();
                return null;
            }
            catch(IOException e){
                e.printStackTrace();
                return null;
            }
        
        }
        else{
            return null;
        }
    }
    
    public boolean borrado (Paciente pacientes){
        if(posicionenuso(posicion(pacientes.getNif()))) {
            try{
                raf = new RandomAccessFile(new File(this.ruta), "rw");
                raf.seek(posicion(pacientes.getNif()) * tamañoRegistro);

                StringBuffer sb = new StringBuffer(" ");
                sb.setLength(9);
                raf.writeChars(sb.toString());

                raf.close();
                return true;
                }   
            catch(FileNotFoundException e){
                e.printStackTrace();
                return false;
            }
            catch(IOException e){
                e.printStackTrace();
                return true;
            }
            
        }
                else{
            return false;
        }
    }
    
    public ArrayList<Paciente> listapacientes(){
        try {
            ArrayList<Paciente> pacientes = new ArrayList<Paciente>();
            raf = new RandomAccessFile(new File(this.ruta), "r");
            for(int position = 0; position < raf.length(); position += this.tamañoRegistro) {

                String nif = "";
                for(int i = 0; i < 9; i++)
                    nif += raf.readChar();
                
                String nombre = "";
                for(int i = 0; i < 15; i++)
                    nombre += raf.readChar();
                
                String apellidos = "";
                for(int i = 0; i < 25; i++)
                    apellidos += raf.readChar();
                
                String direccion = "";
                for(int i= 0; i <30;i++)
                    direccion += raf.readChar();
                
                String fecha = "";
                for(int i = 0; i<9;i++)
                    fecha +=raf.readChar();
                
                Boolean alergia = raf.readBoolean();
                
                char tipo = ' ';
                    for (int i = 0; i<2;i++)
                        tipo += raf.readChar(); 
                    
               pacientes.add(new Paciente(nif,nombre,apellidos,direccion,fecha,alergia,tipo));
            }
            return pacientes;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
        catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    private int posicion (String nif){
        return Integer.valueOf(nif.substring(0,nif.length()))%10;
    }
    
    private boolean posicionenuso(int posicion){
        try {
            raf = new RandomAccessFile(new File(this.ruta), "r");
            raf.seek(posicion * this.tamañoRegistro);
            if(raf.readChar() == ' ') {
                raf.close();
                return false;
            }
            else {
                raf.close();
                return true;
            }
        }
        catch (FileNotFoundException e) {
        }
        catch (IOException e) {
            return false;
        }
        return true;
    }
}
