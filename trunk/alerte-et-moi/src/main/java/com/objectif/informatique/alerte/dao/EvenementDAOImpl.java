/**
 * 
 */
package com.objectif.informatique.alerte.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.objectif.informatique.alerte.model.Evenement;

/**
 * @author vdibi
 *
 */

@Repository("EvenementDAO")
public class EvenementDAOImpl extends GenericDAOImpl<Evenement> implements EvenementDAO{
	
//	@PersistenceContext(unitName="JpaALerte")
//	private EntityManager entityManager;
//	private SessionFactory sessionFactory;
	
	public EvenementDAOImpl(EntityManager entityManager) {
		super(entityManager);
		entityManager = this.entityManager;
	}
	public EvenementDAOImpl(){}
	
	@Override
	public List<Evenement> findAll() throws Exception {
		List<Evenement> evenements = new ArrayList<Evenement>();
		try {
			Query query = this.entityManager.createQuery("select e from Evenement e");
		    evenements = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return evenements;
	}

	@Override
	public Evenement findEvenementById(int evenementId) throws Exception {
		Evenement e = entityManager.find(Evenement.class, evenementId); 
		return e;
	}
	@Override
	public Evenement findEvenementByName(String name) throws Exception {
		Evenement e = entityManager.find(Evenement.class, name); 
		return e;
	}
}