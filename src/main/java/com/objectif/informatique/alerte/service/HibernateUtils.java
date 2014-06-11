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
 * Classe HibernateUtils charg�e de cr�er et de g�rer la SessionFactory
 * La m�thode getSession() de cette classe sera appel�e � chaque fois que nous voudrons *
 * acc�der � la base de donn�es.
 */
public class HibernateUtils {

	private static SessionFactory sessionFactory = buildSessionFactory();

    private static SessionFactory buildSessionFactory() {
        try {
            
        	// On cr�� une factory de type Annotation afin de les prendre en charge
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
