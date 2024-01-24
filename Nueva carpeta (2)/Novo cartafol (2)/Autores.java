package com.journaldev.hibernate.model;

public class Autores {

    private int dniAutor;
    private String nombre;
    private String nacionalidad;

    public int getDniAutor() {
        return dniAutor;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setDniAutor(int dniAutor) {
        this.dniAutor = dniAutor;
    }

    public void setNombre(String Nombre) {
        this.nombre = Nombre;
    }

    public void setNacionalidad(String Nacionalidad) {
        this.nacionalidad = Nacionalidad;
    }
    
    
}