package com.objectif.informatique.alerte.dao;

import java.util.List;

import com.objectif.informatique.alerte.model.Dossier;
import com.objectif.informatique.alerte.model.Profil;

public interface ProfilDAO extends GenericDAO<Profil>{
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Profil> findAll() throws Exception;
	/**
	 * 
	 * @param folderId
	 * @return
	 * @throws Exception
	 */
	Profil findProfilById(int profilId) throws Exception;
}
