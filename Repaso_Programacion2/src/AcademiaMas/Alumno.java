/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package AcademiaMas;
import java.util.ArrayList;
/**
 *
 * @author P13si
 */
public class Alumno {
    private String nombre;
    private String localidad;
    private ArrayList<Modulo> modulos;
    public  Alumno(String nombre, String localidad){
        this.nombre= nombre;
        this.localidad = localidad;
        this.modulos=new ArrayList<Modulo>();
    }
    public Alumno(String nombre, String localidad, ArrayList<Modulo>modulos){
        this.nombre= nombre;
        this.localidad=localidad;
        this.modulos= modulos;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public String getLocalidad(){
        return localidad;
    }
    public void setLocalidad(String localidad){
        this.localidad=localidad;
    }
    public void addModulo(Modulo a){
        modulos.add(a);
    }
    public String[] getNombreModulos(){
        String[] nombres = new String[modulos.size()];
        for(int x = 0 ; x<modulos.size();x++){
            nombres[x] = modulos.get(x).getNombre();
        }
        return nombres;
    }
    public double getNumeroHoras(){
        int horas=0;
        for (int x =0 ; x<modulos.size(); x++){
            horas += modulos.get(x).getHoras();
        }
        return horas;
    }
}
