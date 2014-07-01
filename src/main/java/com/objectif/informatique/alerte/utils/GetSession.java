/**
 * 
 */
package com.objectif.informatique.alerte.utils;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author vdibi
 *
 */
public class GetSession {
	
	private Session session = null;
	private SessionFactory sessionFactory;
	 
	public Session getSession(){
		{
			Session session = null;
	 
			try
			{
				sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
				session = sessionFactory.openSession();
			}
			catch(HibernateException e)
			{
				System.out.println(e.getMessage());
			}
			return session;
	}
}
}
