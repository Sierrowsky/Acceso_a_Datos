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
@Table(name = "actor",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = {"actor_id"})})

public class empleados1 {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "emp_no", nullable = false, unique = true, length = 11)
    private int emp_no;

    @Column(name = "apellido", nullable = true)
    private String apellido;

    @Column(name = "oficio", nullable = true)
    private String oficio;
    @Column(name = "dir", nullable = true)
    private int dir;

    @Column(name = "fecha_alt", nullable = true)
    private Date fecha_alt;
    @Column(name = "salario", nullable = true)
    private float salario;
    @Column(name = "comision", nullable = true)
    private float comision;
    @Column(name = "last_update", nullable = true)
    private int dept_no;

    public int getEmp_no() {
        return emp_no;
    }

    public void setEmp_no(int emp_no) {
        this.emp_no = emp_no;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getOficio() {
        return oficio;
    }

    public void setOficio(String oficio) {
        this.oficio = oficio;
    }

    public int getDir() {
        return dir;
    }

    public void setDir(int dir) {
        this.dir = dir;
    }

    public Date getFecha_alt() {
        return fecha_alt;
    }

    public void setFecha_alt(Date fecha_alt) {
        this.fecha_alt = fecha_alt;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float salario) {
        this.salario = salario;
    }

    public float getComision() {
        return comision;
    }

    public void setComision(float comision) {
        this.comision = comision;
    }

    public int getDept_no() {
        return dept_no;
    }

    public void setDept_no(int dept_no) {
        this.dept_no = dept_no;
    }


}
