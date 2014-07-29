package com.objectif.informatique.alerte.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.objectif.informatique.alerte.model.Dossier;


@Repository("DossierDAO")
public class DossierDAOImpl extends GenericDAOImpl<Dossier> implements DossierDAO{

	public DossierDAOImpl(EntityManager entityManager) {
		super(entityManager);
		entityManager = this.entityManager;
	}
	public DossierDAOImpl(){}
	
	@Override
	public List<Dossier> findAll() throws Exception {
		List<Dossier> dossiers = new ArrayList<Dossier>();
		Query query = this.entityManager.createQuery("select d from Dossier d");
		dossiers = query.getResultList();
	    return dossiers;
	}

	@Override
	public Dossier findFolderById(int folderId) throws Exception {	
		return entityManager.find(Dossier.class, folderId); 
	}
	@Override
	public Dossier getFolderByName(String name) {
		Query query = this.entityManager.createQuery("select d from Dossier d where d.nomDos = name");
		query.setParameter("name", name);
		query.getSingleResult();
		return (Dossier) query;
	}	
}