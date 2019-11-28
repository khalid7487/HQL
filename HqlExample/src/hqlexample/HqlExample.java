/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hqlexample;

import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author KHALID
 */
public class HqlExample {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        //  Query query=session.createQuery("select sum(salary) from Employee");
        //   Query query = session.getNamedQuery("Employee.byId");
        //   query.setInteger(0, 1);
//        Query query = session.getNamedQuery("Employee.byName");
//        query.setString(0, "khalid");
        //    List<Double> list=query.list();
//        List<Employee> list = query.list();
//        String hql="DELETE from Employee where emp_id = :employee_id";
//        Query query=session.createQuery(hql);
//      //  query.setParameter("salary", 20000.00);
//        query.setParameter("employee_id", 8);
//        int res=query.executeUpdate();
//        System.out.println("Rows affected: "+res);
        Criteria criteria = session.createCriteria(Employee.class).add(Restrictions.eq("emp_id", 2));
        //to get records having salary more than 10000
        criteria.add(Restrictions.gt("salary", 10000));
        
        //to get records having salary less than 10000
        criteria.add(Restrictions.lt("salary", 10000));
        
        //to get records having  emp_name starting with a
        criteria.add(Restrictions.like("emp_name", "e%"));
        
        //case sensitive form of the above restriction.
        criteria.add(Restrictions.ilike("emp_name", "E%"));
        
        //to get records having salary in between 10000 and 20000
        criteria.add(Restrictions.between("salary", 10000,20000));
        
        //to check if the given property is null
        criteria.add(Restrictions.isNull("salary"));
        
        //to check if the given property is not null
        criteria.add(Restrictions.isNotNull("salary"));
        
        //to check if the given property is not empty 
        criteria.add(Restrictions.isNotEmpty("salary"));
        List<Employee> list = criteria.list();
        session.getTransaction().commit();
        session.close();
        //System.out.println(list.size());
        for (Employee e : list) {
            System.out.println(e.getEmp_name() + " " + e.getSalary());

        }
    }

}
