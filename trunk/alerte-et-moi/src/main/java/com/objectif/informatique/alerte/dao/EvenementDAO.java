package com.objectif.informatique.alerte.dao;

import java.util.Date;
import java.util.List;

import com.objectif.informatique.alerte.model.EnumPeriodeEvet;
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
	/**
	 * Chercher un evenement par son nom
	 * @param name
	 * @return
	 * @throws Exception
	 */
	Evenement findEvenementByName(String name) throws Exception;
	
	/**
	 * Chercher un evenement par dates
	 * @param date
	 * @return
	 * @throws Exception
	 */
	List<Evenement> findEvenementsByDateRange(Date start_date, Date end_date) throws Exception;
	List<EnumPeriodeEvet> findEnumPeriod()throws Exception;
}
