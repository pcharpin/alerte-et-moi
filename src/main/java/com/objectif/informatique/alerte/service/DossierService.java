package com.objectif.informatique.alerte.service;

import java.util.List;

import com.objectif.informatique.alerte.model.Dossier;

public interface DossierService {
	/**
	 * 
	 * @param dossierId
	 * @return
	 */
	public Dossier getDossierById(int dossierId);
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Dossier> findAll() throws Exception;
	/**
	 * 
	 * @param dossier
	 * @return
	 */
	public Dossier create(Dossier dossier);
	/**
	 * 
	 * @param class1
	 * @param id
	 */
	public void delete(Dossier dossierId);
	/**
	 * 
	 * @param dossier
	 */
	public void update(Dossier dossier);
	/**
	 * 
	 * @param name
	 * @return
	 */
	public Dossier getFolderByName(String name);
}