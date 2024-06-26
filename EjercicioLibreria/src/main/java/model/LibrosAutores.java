/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

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
@Table(name = "Libros_Autores",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"IdLibro","DniAutor"})})
public class LibrosAutores {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "IdLibro",nullable = false,unique = true,length = 20)
        private int id;       
        @Column(name = "Autores_DniAutor",nullable = false ,unique = true,length = 9)
        private String dniAutor;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getDniAutor() {
            return dniAutor;
        }

        public void setDniAutor(String dniAutor) {
            this.dniAutor = dniAutor;
        }
    
} 