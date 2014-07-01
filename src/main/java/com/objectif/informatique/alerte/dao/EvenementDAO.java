package com.objectif.informatique.alerte.dao;

import java.util.List;

import com.objectif.informatique.alerte.model.Evenement;

/**
 * @author vdibi
 * 
 */

public interface EvenementDAO extends GenericDAO<Evenement>{
	/**
	 * Chercher un evenement par son id
	 * @param evenementId
	 * @return
	 * @throws Exception
	 */
	Evenement findEvenementById(int evenementId) throws Exception;
	/**
	 * Lister tous les evenements
	 * @return
	 * @throws Exception
	 */
	List<Evenement> findAll() throws Exception;

}
