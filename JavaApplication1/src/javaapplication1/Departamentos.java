/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

import java.util.Date;

/**
 *
 * @author P13si
 */
public class Departamentos {
    int Numdep;
    String Nombredep;
     int Numempdep;
     int NSSgerente;
     String FechaInicGer;

    public Departamentos(int Numdep, String Nombredep, int Numempdep, String FechaInicGer, Date fechaInicGerente) {
        this.Numdep = Numdep;
        this.Nombredep = Nombredep;
        this.Numempdep = Numempdep;
        this.NSSgerente = NSSgerente;
        this.FechaInicGer = FechaInicGer;
    }

    public Departamentos() {
    }

    public int getNumdep() {
        return Numdep;
    }

    public void setNumdep(int Numdep) {
        this.Numdep = Numdep;
    }

    public String getNombredep() {
        return Nombredep;
    }

    public void setNombredep(String Nombredep) {
        this.Nombredep = Nombredep;
    }

    public int getNumempdep() {
        return Numempdep;
    }

    public void setNumempdep(int Numempdep) {
        this.Numempdep = Numempdep;
    }

    public int getNSSgerente() {
        return NSSgerente;
    }

    public void setNSSgerente(int NSSgerente) {
        this.NSSgerente = NSSgerente;
    }

    public String getFechaInicGer() {
        return FechaInicGer;
    }

    public void setFechaInicGer(String FechaInicGer) {
        this.FechaInicGer = FechaInicGer;
    }
    
}
