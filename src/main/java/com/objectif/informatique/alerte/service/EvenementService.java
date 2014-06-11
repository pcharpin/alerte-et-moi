/**
 * 
 */
package com.objectif.informatique.alerte.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.objectif.informatique.alerte.dao.JdbcEvenementDAO;
import com.objectif.informatique.alerte.model.Evenement;

/**
 * @author vdibi
 *
 */
public class EvenementService implements JdbcEvenementDAO{
	private Session session;

	@Override
	public Integer create(Evenement evenement) throws SQLException {
		Transaction tx = null;
		Integer idEvent = null;
		// try{
			 //getSession = (GetSession) factory.openSession();
			 //session = HibernateUtils.getSessionFactory().getCurrentSession();
			
			session = HibernateUtils.getSession();
			 tx = session.beginTransaction();
			 Evenement evenement2 = new Evenement();
			 idEvent = (Integer) session.save(evenement2);
				System.out.println("query :" +idEvent);
				
			session.getTransaction().commit();
	       // session.close();
			HibernateUtils.closeSession();

		return idEvent;	
	}

	@Override
	public void update(Evenement evenement) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Evenement evenement) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Evenement getEvenementByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer findByEvenementById(int evid) throws SQLException {
		Transaction tx = null;
		try {
			
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			Query query = session.createQuery(" SELECT idEvt FROM evenement WHERE idEvt = evid ");
			System.out.println("query :" +query);
			query.setParameter("", evid);
			session.getTransaction().commit();
			HibernateUtils.closeSession();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return evid;
	}

	@Override
	public ArrayList<String> selectedAllEvenementByName() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
