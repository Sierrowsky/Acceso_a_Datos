/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hibernatemaven;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author a21pablosp
 */
@Entity
@Table(name = "Libros",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"IdLibro"})})
public class Libros {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "IdLibro",nullable = false,unique = true,length = 20)
        private int id;
        @Column(name = "Titulo",nullable = true,length = 50)
        private String titulo;
        @Column(name = "Precio" , nullable = true,length = 9)
        private Float precio;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitulo() {
            return titulo;
        }

        public void setTitulo(String titulo) {
            this.titulo = titulo;
        }

        public Float getPrecio() {
            return precio;
        }

        public void setPrecio(Float precio) {
            this.precio = precio;
        }    
}
