package main;


import java.util.Date;
import model.Employee;
import org.hibernate.Session;
import util.HibernateUtil;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author a21pablosp
 */
public class HibernateEx {

    public static void main(String[] args) {
        Employee emp = new Employee();
        emp.setName("Juan");
        emp.setRole("CEO");
        emp.setInsertTime(new Date());
        //Get Session
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        //start transaction
        session.beginTransaction();
        //Save the model object
        session.save(emp);
        //Commit transaction
        session.getTransaction().commit();
        System.out.println("Employee ID = " + emp.getId());
        //terminate session factory, otherwise program won't end
        HibernateUtil.getSessionFactory().close();
                
    }
}
