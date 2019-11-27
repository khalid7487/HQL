/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hqlexample;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author KHALID
 */
public class HqlExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
        Session session=sessionFactory.openSession();
        session.beginTransaction();
        Query query=session.createQuery("select emp_name from Employee");
        List<String> list=query.list();
        session.getTransaction().commit();
        session.close();
        //System.out.println(list.size());
        for (String e:list) {
            System.out.println(e);
            
        }
    }
    
}
