/**
 * 
 */
package com.objectif.informatique.alerte.service;

import java.util.List;

import javax.persistence.EntityManager;

import com.objectif.informatique.alerte.dao.EvenementDAO;
import com.objectif.informatique.alerte.model.Evenement;

/**
 * @author vdibi
 *
 */

public class EvenementServiceImpl implements EvenementDAO{

	private EntityManager entityManager;

	public EvenementServiceImpl(EntityManager entityManager) {
        this.entityManager= entityManager;
    }
	/**
	 * @param entityManager the entityManager to set
	 */
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

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
			updatedEvenement = entityManager.merge(evenement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updatedEvenement;		
	}

	@Override
	public void delete(Evenement evenement) throws Exception {
		try {
			entityManager.remove(evenement);
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
	public List<Evenement> selectedAllEvenementByName() throws Exception {
		return null;
	
	}
	

	@Override
	public List<Evenement> listEvenement() throws Exception {
		return null;

	}

	@Override
	public Evenement findEvenementById(Long evenementId) {
		try {
			Evenement e = entityManager.find(Evenement.class, evenementId); 
			return e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}