package com.objectif.informatique.alerte.dao;

import java.util.List;

import com.objectif.informatique.alerte.model.Dossier;

public interface DossierDAO extends GenericDAO<Dossier>{
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Dossier> findAll() throws Exception;
	/**
	 * 
	 * @param folderId
	 * @return
	 * @throws Exception
	 */
	Dossier findFolderById(int folderId) throws Exception;
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Dossier getFolderByName(String name);
}
