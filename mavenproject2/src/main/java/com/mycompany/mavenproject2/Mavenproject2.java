/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.mavenproject2;

import org.hibernate.Session;

/**
 *
 * @author a21pablosp
 */
public class Mavenproject2 {

    public static void main(String[] args) {
        libros aut = new libros();
        aut.setId(1234);
        aut.setTitulo("Juan");
        aut.setPrecio(20.5f);
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        session.beginTransaction();
        session.save(aut);
        session.getTransaction().commit();
        System.out.println("Nombre Autor = " + aut.getTitulo());
        HibernateUtil.getSessionFactory().close();
    }
}

