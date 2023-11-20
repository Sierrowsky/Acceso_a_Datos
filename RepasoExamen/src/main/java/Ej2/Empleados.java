/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej2;

import com.mycompany.repasoexamen.Ej1.*;

/**
 *
 * @author P13si
 */
public class Empleados {
    private String Dni;
    private String Nombre;
    private String Apellidos;
    private double Salario;

    public Empleados(String Dni, String Nombre, String Apellidos, double Salario) {
        this.Dni = Dni;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Salario = Salario;
    }
public Empleados(){
    
}   

    public String getDni() {
        return Dni;
    }

    public void setDni(String Dni) {
        this.Dni = Dni;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public double getSalario() {
        return Salario;
    }

    public void setSalario(double Salario) {
        this.Salario = Salario;
    }

    @Override
    public String toString() {
        return "Empleados{" + "Dni=" + Dni + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Salario=" + Salario + '}';
    }

}
