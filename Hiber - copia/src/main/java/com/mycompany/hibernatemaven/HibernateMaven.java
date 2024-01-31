/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.hibernatemaven;

import java.util.Date;
import org.hibernate.Session;

/**
 *
 * @author a22danielpc
 */
public class HibernateMaven {

    public static void main(String[] args) {
       empleados1 aut = new empleados1();
        aut.setDniAutor("12345678A");
        aut.setNombre("Juan");
        aut.setNacionalidad("Venezuela");
        //Get Session
	Session session = HibernateUtil.getSessionFactory().getCurrentSession();		
        //start transaction
        session.beginTransaction();
        //Save the Model object
        session.save(aut);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Nombre Autor = " + aut.getNombre());
        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
    }
}
