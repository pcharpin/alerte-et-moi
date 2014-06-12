/**
 * 
 */
package com.objectif.informatique.alerte.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.objectif.informatique.alerte.dao.JdbcEvenementDAO;
import com.objectif.informatique.alerte.model.Evenement;

/**
 * @author vdibi
 *
 */
@Transactional
@Service("EvenementService")
public class EvenementService implements JdbcEvenementDAO{
	private Session session;

	@Override
	public Integer create(Evenement evenement) throws SQLException {
		Transaction tx = null;
		Integer idEvent = null;
			
			session = HibernateUtils.getSession();
			//Transaction tx = session.beginTransaction();
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
//			 int idEventfounded = findByEvenementById(idEvt);
//			 Evenement evenement =  new Evenement();
//			 if(evenement.getIdEvt() == idEventfounded){
//				 session.update(evenement);
//			 }			
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
	public String getEvenementByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evenement findByEvenementById(int evid) throws SQLException {
		Evenement evenement = null;
		try {
			
			session = HibernateUtils.getSession();
			Transaction tx = session.beginTransaction();
			//Query query = session.createQuery(" SELECT idEvt FROM evenement WHERE idEvt = evid ");
			evenement = (Evenement) session.get(Evenement.class, evid);
			System.out.println("e :" +evenement);
//			query.setParameter("", evid);
//			query.executeUpdate();
			session.getTransaction().commit();
			HibernateUtils.closeSession();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return evenement;
	}

	@Override
	public ArrayList<String> selectedAllEvenementByName() throws SQLException {
		Transaction tx = null;
		ArrayList<String> allEvet = new ArrayList<String>();
		try {
			
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			
			Query query = (Query) session.createSQLQuery("SELECT nomEvt FROM evenement ").list();
			query.executeUpdate();
			for (Iterator iterator = query.iterate(); iterator.hasNext();)
			{
			     Evenement evenement = (Evenement) iterator.next(); 
			     allEvet.add(evenement.toString());
			     System.out.println("allEvet : " + allEvet);	
			     System.out.print("First Name: " +evenement.getNomEvt()); 
			  }
			
			session.getTransaction().commit();
			HibernateUtils.closeSession();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return allEvet;
	
	}
	

	@Override
	public List<Evenement> listEvenement() throws SQLException {
		Transaction tx = null;
		List<Evenement> evenements = null;
		try {
			
			session = HibernateUtils.getSession();
			tx = session.beginTransaction();
			evenements = session.createQuery("SELECT nomEvt FROM evenement ").list();
			System.out.println("evenements :" +evenements);
			
			for (Evenement evenement : evenements){
				String e= evenement.getNomEvt();
				evenements.add(evenement);
				System.out.println("e :" + e);
				}
			session.getTransaction().commit();
			HibernateUtils.closeSession();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return evenements;
	}

}
