package com.objectif.informatique.alerte.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.objectif.informatique.alerte.model.Profil;


@Repository("Profil")
public class ProfilDAOImpl extends GenericDAOImpl<Profil> implements ProfilDAO{

	@Override
	public List<Profil> findAll() throws Exception {
		List<Profil> profils = new ArrayList<Profil>();
		Query query = this.entityManager.createQuery("select p from Profil p");
		profils = query.getResultList();
	    return profils;
	}

	@Override
	public Profil findProfilById(int profilId) throws Exception {
		Profil profil = entityManager.find(Profil.class, profilId); 
		return profil;
	}

	
}
