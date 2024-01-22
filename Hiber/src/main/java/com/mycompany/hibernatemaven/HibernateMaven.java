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
       empleados emp = new empleados();
		emp.setApellido("Romeo");
                emp.setOficio("Romeo");
                emp.setFecha_alt(new Date());
		emp.setDir(7369);
                emp.setSalario(100);
                emp.setComision(4000);
                emp.setDept_no(10);
		
		//Get Session
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		//start transaction
		session.beginTransaction();
		//Save the Model object
		session.save(emp);
		//Commit transaction
		session.getTransaction().commit();
		System.out.println("Empeado ID="+emp.getEmp_no());
		
		//terminate session factory, otherwise program won't end
		HibernateUtil.getSessionFactory().close();
    }
}
