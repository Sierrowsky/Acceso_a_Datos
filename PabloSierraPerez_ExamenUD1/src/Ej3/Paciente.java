/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ej3;

import Ej2.*;
import java.util.Date;
/**
 *
 * @author a21pablosp
 */
/**
 * Desde el departamento de recursos humanos del Hospital Pupitas, nos han
 * pedido que diseñemos una pequeña aplicación que les ayude a realizar la
 * gestión de sus pacientes. Esta aplicación debe almacenar la siguiente
 * información de cada uno de los pacientes. (3,5 puntos) Atributos: 
 * • NIF →String → 9 caracteres (8 números y 1 letra) (con Validación) 
 * • Nombre → * String → 15 caracteres 
 * • Apellidos → String → 25 caracteres 
 * • Dirección → * String → 30 caracteres 
 * • FechaUltimaVisita → Date 
 * • Alergia → Boolean → (1:Tiene alergias. 0: NO tiene alergias) 
 * (con Validación) • Tipo → char → (P:
 * Privado, S: Seguridad Social) (con Validación)
 */
public class Paciente {
    private String nif;
    private String nombre;
    private String apellidos;
    private String direccion;
    private String fechaultimavisita;
    private Boolean alergia;
    private char tipo;

    public Paciente(String nif, String nombre, String apellidos, String direccion, String fechaultimavisita, Boolean alergia, char tipo) {
        this.nif = nif;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.fechaultimavisita = fechaultimavisita;
        this.alergia = alergia;
        this.tipo = tipo;
    }

    public Paciente() {
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFechaultimavisita() {
        return fechaultimavisita;
    }

    public void setFechaultimavisita(String fechaultimavisita) {
        this.fechaultimavisita = fechaultimavisita;
    }

    public Boolean getAlergia() {
        return alergia;
    }

    public void setAlergia(Boolean alergia) {
        this.alergia = alergia;
    }

    public char getTipo() {
        return tipo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Paciente{" + "nif=" + nif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", direccion=" + direccion + ", fechaultimavisita=" + fechaultimavisita + ", alergia=" + alergia + ", tipo=" + tipo + '}';
    }
    
}
