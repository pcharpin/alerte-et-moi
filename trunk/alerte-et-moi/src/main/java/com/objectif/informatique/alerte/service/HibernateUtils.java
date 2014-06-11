/**
 * 
 */
package com.objectif.informatique.alerte.service;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author vdibi
 * Classe HibernateUtils chargée de créer et de gérer la SessionFactory
 * La méthode getSession() de cette classe sera appelée à chaque fois que nous voudrons *
 * accéder à la base de données.
 */
public class HibernateUtils {

	private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            
        	// On créé une factory de type Annotation afin de les prendre en charge
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
