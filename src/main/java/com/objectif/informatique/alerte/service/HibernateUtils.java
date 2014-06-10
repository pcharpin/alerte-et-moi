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
 * HibernateUtils chargée de créer et de gérer la SessionFactory
 * La méthode getSession() de cette classe sera appelée à chaque fois que nous voudrons *
 * accéder à la base de données.
 */
public class HibernateUtils {

	private static final SessionFactory sessionFactory;

	// Crée une unique instance de la SessionFactory à partir de
	// hibernate.cfg.xml

	static {
		try {

			sessionFactory = new AnnotationConfiguration().configure()
					.buildSessionFactory();

		} catch (HibernateException ex) {

			throw new RuntimeException("Problème de configuration : "
					+ ex.getMessage(), ex);
		}

	}

	// Renvoie une session Hibernate

	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}
}
