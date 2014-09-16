/**
 * 
 */
package com.objectif.informatique.alerte.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.objectif.informatique.alerte.model.Alerte;
import com.objectif.informatique.alerte.model.Responsable;

import org.apache.log4j.Logger;

/**
 * @author gsoh
 *
 */

@Repository("AlerteDAO")
public class AlerteDAOImpl extends GenericDAOImpl<Alerte> implements AlerteDAO{
	
	private static Logger LOGGER = Logger.getLogger(AlerteDAOImpl.class.getName());
	public AlerteDAOImpl(EntityManager entityManager) {
		super(entityManager);
		entityManager = this.entityManager;
	}
	public AlerteDAOImpl(){}
	@Override
	public Alerte findAlerteById(int alertId) throws Exception {
		Alerte alerte = null;
		try {
			alerte = entityManager.find(Alerte.class, alertId);
			
			LOGGER.info("Alerte with Id " + alertId + "found in DB." );
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return alerte;
	}
	@Override
	public void deleteAlerte(Alerte alerte) throws Exception {
		
		try{
			entityManager.remove(alerte);
			LOGGER.info("Alerte Id " + alerte.getIdAler() + "removed from DB.");
		}
		catch (Exception e){
			e.printStackTrace();
		}
		return;
	}
	
	
	@Override
	public List<Alerte> findAll() throws Exception {
		List<Alerte> alertes = new ArrayList<Alerte>();
		Query query = this.entityManager.createQuery("select a from Alerte a");
		alertes = query.getResultList();
	    return alertes;
	}
	

}