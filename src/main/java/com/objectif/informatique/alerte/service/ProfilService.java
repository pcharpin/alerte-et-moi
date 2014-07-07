package com.objectif.informatique.alerte.service;

import java.util.List;

import com.objectif.informatique.alerte.model.Profil;

public interface ProfilService {
	/**
	 * 
	 * @param dossierId
	 * @return
	 */
	public Profil getProfilById(int profilId);
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Profil> findAll() throws Exception;
}
