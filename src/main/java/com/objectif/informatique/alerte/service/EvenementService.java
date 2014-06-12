/**
 * 
 */
package com.objectif.informatique.alerte.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public void update(Integer idEvt) throws SQLException {
		Transaction tx = null;
			session = HibernateUtils.getSession();
			 tx = session.beginTransaction();
			 int idEventfounded = findByEvenementById(idEvt);
			 Evenement evenement =  new Evenement();
			 if(evenement.getIdEvt() == idEventfounded){
				 session.update(evenement);
			 }			
			session.getTransaction().commit();
			HibernateUtils.closeSession();	
	}

	@Override
	public void delete(Integer idEvtt) throws SQLException {
		Transaction tx = null;
		try {
			
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			findByEvenementById(idEvtt);
			session.getTransaction().commit();
			HibernateUtils.closeSession();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
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

	@Override
	public List<Evenement> listEvenement() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
