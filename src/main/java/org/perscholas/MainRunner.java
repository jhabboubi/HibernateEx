package org.perscholas;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.perscholas.models.Department;
import org.perscholas.models.Employee;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class MainRunner {

    private static SessionFactory factory;
    private static ServiceRegistry registry;

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);


        try {
            Configuration conf = new Configuration().configure(new File("src/main/resources/hibernate.cfg.xml"));
            conf.addAnnotatedClass(Employee.class);
            conf.addAnnotatedClass(Department.class);
            registry = new StandardServiceRegistryBuilder().applySettings(conf.getProperties()).build();
            factory = conf.buildSessionFactory(registry);

        }catch(Throwable e){
            System.err.println("Failed to create session factory object " + e.getMessage());
            throw  new ExceptionInInitializerError(e);
        }

        Session session = factory.openSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            Employee e = new Employee(100, "Jafer Alhaboubi", "jhaboubi@perscholas.org");
            session.save(e);
            tx.commit();
            // HQL Query
          //  List employees = session.createQuery("From Employee").list();

        }catch (HibernateException e){
            if(tx != null) tx.rollback();
            e.printStackTrace();
        }finally {
            session.close();
        }
        StandardServiceRegistryBuilder.destroy(registry);


    } // main
} // class
