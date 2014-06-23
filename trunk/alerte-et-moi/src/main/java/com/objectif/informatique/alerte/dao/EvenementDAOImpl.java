/**
 * 
 */
package com.objectif.informatique.alerte.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.objectif.informatique.alerte.model.Evenement;

/**
 * @author vdibi
 *
 */

@Repository("EvenementDAO")
public class EvenementDAOImpl implements EvenementDAO{
//	@PersistenceContext 
	private EntityManager entityManager;
	
	public EvenementDAOImpl(EntityManager entityManager) {
        this.entityManager= entityManager;
    }
//	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	/**
	 * @param entityManager the entityManager to set
	 */
//	@Autowired
//	public void setEntityManager(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}

	@Override
	public Integer create(Evenement evenement) throws Exception {
try {
			
			entityManager.persist(evenement);
			return evenement.getIdEvt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Evenement update(Evenement evenement) throws Exception {
		Evenement updatedEvenement = new Evenement();
		try {
			//updatedEvenement = entityManager.merge(evenement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updatedEvenement;		
	}

	@Override
	public void delete(Evenement evenement) throws Exception {
		try {
		//	entityManager.remove(evenement);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		
	}

	@Override
	public String getEvenementByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evenement findEvenementById(Long evenementId) {
		try {
		//	Evenement e = entityManager.find(Evenement.class, evenementId); 
		//	return e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Evenement> findAll() throws Exception {
		List<Evenement> evenements=new ArrayList<Evenement>();
	    Query query = entityManager.createQuery("SELECT e.* FROM Evenement e");
	    evenements = query.getResultList();
	    return evenements;
	}

}
