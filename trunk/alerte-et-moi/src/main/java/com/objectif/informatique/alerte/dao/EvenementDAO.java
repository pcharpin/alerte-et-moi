package com.objectif.informatique.alerte.dao;

import java.util.List;

import com.objectif.informatique.alerte.model.Evenement;

/**
 * 
 */

/**
 * @author vdibi
 * 
 */

public interface EvenementDAO {
	Integer create(Evenement evenement) throws Exception;

	Evenement update(Evenement evenement) throws Exception;

	void delete(Evenement evenement) throws Exception;

	String getEvenementByName(String name) throws Exception;

	Evenement findEvenementById(int evenementId) throws Exception;
	
	List<Evenement> findAll() throws Exception;

}
