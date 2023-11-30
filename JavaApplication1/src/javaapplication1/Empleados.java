/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author P13si
 */
public class Empleados {
     int NSS;
     String Nombre;
     String Apel1;
     String Apel2;
     String Sexo;
     String Direccion;
     String FechaNac;
     int Salario;
     int Numdep;
     String NSSsup;
     String NIF;

    public Empleados(int Salario, String Nombre, String Apel1, String Apel2, String Sexo, String Direccion, Date fechaNacimiento, int NSS, int Numdep, String FechaNac, String nif) {
        this.NSS = NSS;
        this.Nombre = Nombre;
        this.Apel1 = Apel1;
        this.Apel2 = Apel2;
        this.Sexo = Sexo;
        this.Direccion = Direccion;
        this.FechaNac = FechaNac;
        this.Salario = Salario;
        this.Numdep = Numdep;
        this.NSSsup = NSSsup;
        this.NIF = NIF;
    }

    public Empleados() {
    }

    public int getNSS() {
        return NSS;
    }

    public void setNSS(int NSS) {
        this.NSS = NSS;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApel1() {
        return Apel1;
    }

    public void setApel1(String Apel1) {
        this.Apel1 = Apel1;
    }

    public String getApel2() {
        return Apel2;
    }

    public void setApel2(String Apel2) {
        this.Apel2 = Apel2;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getFechaNac() {
        return FechaNac;
    }

    public void setFechaNac(String FechaNac) {
        this.FechaNac = FechaNac;
    }

    public int getSalario() {
        return Salario;
    }

    public void setSalario(int Salario) {
        this.Salario = Salario;
    }

    public int getNumdep() {
        return Numdep;
    }

    public void setNumdep(int Numdep) {
        this.Numdep = Numdep;
    }

    public String getNSSsup() {
        return NSSsup;
    }

    public void setNSSsup(String NSSsup) {
        this.NSSsup = NSSsup;
    }

    public String getNIF() {
        return NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }
    
}
