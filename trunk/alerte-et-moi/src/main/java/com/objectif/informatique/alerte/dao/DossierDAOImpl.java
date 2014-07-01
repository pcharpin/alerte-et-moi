package com.objectif.informatique.alerte.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.web.bind.annotation.RequestMapping;

import com.objectif.informatique.alerte.model.Dossier;

@RequestMapping("DossierDAO")
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
		Dossier dossier = entityManager.find(Dossier.class, folderId); 
		return dossier;
	}

}
