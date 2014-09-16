package com.objectif.informatique.alerte.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.objectif.informatique.alerte.model.Evenement;
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
	@Override
	public List<Evenement> findAllEventsByRespName(String nomResp)
			throws Exception {
		List<Evenement> evenements = new ArrayList<Evenement>();
		
		//Query query = this.entityManager.createQuery("select r.nomResp from Responsable r" +
			//										 "inner join Evenement e on e.Responsable_idResp = r.idResp");
		
		Query query = this.entityManager.createQuery("select r.nomResp from Responsable r " +
				 "inner join Evenement e on e.Responsable_idResp = r.idResp +" +
				 "where r.nomresp like '" +
				 nomResp + "'");
		evenements = query.getResultList();
	    return evenements;
	}

}
