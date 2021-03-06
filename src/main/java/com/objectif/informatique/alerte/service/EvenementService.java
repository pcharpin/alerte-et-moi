package com.objectif.informatique.alerte.service;

import java.util.Date;
import java.util.List;

import com.objectif.informatique.alerte.model.EnumPeriodeEvet;
import com.objectif.informatique.alerte.model.Evenement;

/**
 * JAVADOC ETC...
 * @author npincon
 *
 */
public interface  EvenementService {
	
	public Evenement getEvenementById(int evenementId);
	List<Evenement> findAll() throws Exception;
	public Evenement getEvenementByName(String name);
	public Evenement create(Evenement evenement);
	public void delete(Evenement eventId);
	public void update(Evenement evenement);
	public List<EnumPeriodeEvet> findListOfPeriod();
	public List<Evenement> getEvenementsByDateRange(Date start_date, Date end_date) throws Exception;
	public List<Evenement> getEvenementsByPartialName(String srchKeyWord) throws Exception;
	public List<Evenement> getEvenementsByRespName(String respname) throws Exception;
	public List<Evenement> getEvenementsByTypeDos(String typedos) throws Exception;
	public List<Evenement> getEvenementsByStatus(int status) throws Exception;
	
}