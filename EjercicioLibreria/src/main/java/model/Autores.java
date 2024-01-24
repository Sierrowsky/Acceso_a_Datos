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
@Table(name="Autores",
        uniqueConstraints={@UniqueConstraint(columnNames={"DniAutor"})})
public class Autores {
    @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "DniAutor",nullable = false,unique = true,length = 9)
        private String dniAutor;
        
        @Column(name ="Nombre",nullable = true , length = 20)
        private String Nombre;
        
        @Column(name ="Nacionalidad",nullable = true,length = 50)
        private String Nacionalidad;

        public String getDniAutor() {
            return dniAutor;
        }

        public void setDniAutor(String dniAutor) {
            this.dniAutor = dniAutor;
        }

        public String getNombre() {
            return Nombre;
        }

        public void setNombre(String Nombre) {
            this.Nombre = Nombre;
        }

        public String getNacionalidad() {
            return Nacionalidad;
        }

        public void setNacionalidad(String Nacionalidad) {
            this.Nacionalidad = Nacionalidad;
        }
        
}
