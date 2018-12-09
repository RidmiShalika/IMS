/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hibernate Utility class with a convenient method to get Session Factory
 * object.
 *
 * @author ridmi_g
 */
public class HibernateInit {

    private static final SessionFactory sessionFactory;
    
    static {
        try {
//            // Create the SessionFactory from standard (hibernate.cfg.xml) 
//            // config file.
            sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
        } catch (Throwable ex) {
//            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
//      public static SessionFactory sessionFactory;
//   
//
//    {
//        if (sessionFactory == null || sessionFactory.isClosed()) {
//            System.out.println("before inilzed method");
//            initialize();
//        }
//    }
//    public SessionFactory initialize() {
//        System.out.println("inside initalzed method");
//        if (this.sessionFactory == null || this.sessionFactory.isClosed()) {
//            System.out.println("ridmi");
//            Configuration configuration = new Configuration();
//            ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
//            this.sessionFactory = configuration.buildSessionFactory(serviceRegistry);
//        }
//        return this.sessionFactory;
//    }
}
