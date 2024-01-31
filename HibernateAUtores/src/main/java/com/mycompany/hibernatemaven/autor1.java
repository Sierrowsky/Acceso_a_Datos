package com.mycompany.hibernatemaven;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author a22danielpc
 */

@Entity
@Table(name="autores", 
	   uniqueConstraints={@UniqueConstraint(columnNames={"DniAutor"})})

public class autor1 {
    
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="DniAutor", nullable=false, unique=true)
	private String DniAutor;
    
    @Column(name="Nombre", nullable=true)
	private String Nombre;
    
    @Column(name="Nacionalidad", nullable=true)
	private String Nacionalidad;

    public String getDniAutor() {
        return DniAutor;
    }

    public void setDniAutor(String DniAutor) {
        this.DniAutor = DniAutor;
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
