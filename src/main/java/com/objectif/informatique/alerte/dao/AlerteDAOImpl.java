/**
 * 
 */
package com.objectif.informatique.alerte.dao;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import com.objectif.informatique.alerte.model.Alerte;

/**
 * @author gsoh
 *
 */

@Repository("AlerteDAO")
public class AlerteDAOImpl extends GenericDAOImpl<Alerte> implements AlerteDAO{
	
	
	public AlerteDAOImpl(EntityManager entityManager) {
		super(entityManager);
		entityManager = this.entityManager;
	}
	public AlerteDAOImpl(){}
	

}