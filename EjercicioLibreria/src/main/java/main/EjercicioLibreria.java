package main;

import model.Autores;
import model.Libros;
import org.hibernate.Session;
import util.HibernateUtil;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author a21pablosp
 */
public class EjercicioLibreria {

    public static void main(String[] args) {
        Libros aut = new Libros();
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
