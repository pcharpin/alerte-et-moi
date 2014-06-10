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
 * HibernateUtils charg�e de cr�er et de g�rer la SessionFactory
 * La m�thode getSession() de cette classe sera appel�e � chaque fois que nous voudrons *
 * acc�der � la base de donn�es.
 */
public class HibernateUtils {

	private static final SessionFactory sessionFactory;

	// Cr�e une unique instance de la SessionFactory � partir de
	// hibernate.cfg.xml

	static {
		try {

			sessionFactory = new AnnotationConfiguration().configure()
					.buildSessionFactory();

		} catch (HibernateException ex) {

			throw new RuntimeException("Probl�me de configuration : "
					+ ex.getMessage(), ex);
		}

	}

	// Renvoie une session Hibernate

	public static Session getSession() throws HibernateException {
		return sessionFactory.openSession();
	}
}
