package com.objectif.informatique.alerte.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.objectif.informatique.alerte.model.Responsable;

@Repository("ResponsableDAO")
public class ResponsableDAOImpl  extends GenericDAOImpl<Responsable> implements ResponsableDAO{
	
	public ResponsableDAOImpl(EntityManager entityManager) {
		super(entityManager);
		entityManager = this.entityManager;
	}
	public ResponsableDAOImpl(){}

	@Override
	public Responsable findResponsableById(int respId) throws Exception {
		Responsable r = entityManager.find(Responsable.class, respId); 
		return r;
	}

	@Override
	public List<Responsable> findAll() throws Exception {
		List<Responsable> responsables = new ArrayList<Responsable>();
		Query query = this.entityManager.createQuery("select r from Responsable r");
		responsables = query.getResultList();
	    return responsables;
	}

}
