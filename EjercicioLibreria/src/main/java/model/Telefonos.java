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
@Table(name = "Telefonos",
        uniqueConstraints = {@UniqueConstraint(columnNames = {"Telefono","DniAutor"})})
public class Telefonos {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "Telefono",nullable = false,unique = true,length = 15)
        private int telefono;
        @Column(name = "DniAutor",nullable = false,unique = true,length = 9)
        private String dniAutor;

        public int getTelefono() {
            return telefono;
        }

        public void setTelefono(int telefono) {
            this.telefono = telefono;
        }

        public String getDniAutor() {
            return dniAutor;
        }

        public void setDniAutor(String dniAutor) {
            this.dniAutor = dniAutor;
        }
        
    
}
