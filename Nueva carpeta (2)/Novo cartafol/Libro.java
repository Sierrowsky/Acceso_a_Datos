package com.journaldev.hibernate.model;


public class Libro {

    private int idLibro;
    private String titulo;
    private String precio;

    public int getIdLibro() {
            return idLibro;
    }
    public void setIdLibro(int idLibro) {
            this.idLibro = idLibro;
    }
    public String getTitulo() {
            return titulo;
    }
    public void setTitulo(String titulo) {
            this.titulo = titulo;
    }
    public String getPrecio() {
            return precio;
    }
    public void setPrecio(String precio) {
            this.precio = precio;
    }
}