/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hibernate;
import hibernate.HibernateUtil;
import hibernate.Empleado;
import java.util.Iterator;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
/**
 *
 * @author a21pablosp
 */
public class Hibernate {
    public static void main(String[] args) {
        SessionFactory instancia = HibernateUtil.buildSessionFactory();
        Session session = instancia.openSession();
        Query q = session.createQuery("from Empleados");
        Iterator<Empleado> it = q.iterate();
        Empleado e ;
        while (it.hasNext()){
            e=it.next();
            System.out.println(e.nombre + " " + e.salario);
        }
        session.close();
    }    
}
