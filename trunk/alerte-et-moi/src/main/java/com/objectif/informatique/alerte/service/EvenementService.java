package com.objectif.informatique.alerte.service;

import java.util.List;

import com.objectif.informatique.alerte.model.Evenement;

/**
 * JAVADOC ETC...
 * @author npincon
 *
 */
public interface  EvenementService {
	
	public Evenement getEvenementById(int evenementId);
	List<Evenement> findAll() throws Exception;
	public Evenement getEvenementByName(String name) throws Exception;
	public Evenement create(Evenement evenement);
	public void delete(Evenement eventId);
	public void update(Evenement evenement);
}