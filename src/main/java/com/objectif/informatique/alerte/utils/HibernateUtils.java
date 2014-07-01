/**
 * 
 */
package com.objectif.informatique.alerte.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author vdibi
*
 */
public class HibernateUtils {

	private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
        	sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        }
        catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
		return sessionFactory;
    }

    public static SessionFactory getSessionFactory() {
        return (SessionFactory) sessionFactory.openSession();
    }
    
    
	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}
 

	public static void closeSession() throws HibernateException {
		sessionFactory.close();
	}
}
