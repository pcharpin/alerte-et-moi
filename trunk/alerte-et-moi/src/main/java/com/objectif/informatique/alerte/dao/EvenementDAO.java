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
	public Evenement findEvenementById(int evenementId) throws Exception;
	/**
	 * Lister tous les evenements
	 * @return
	 * @throws Exception
	 */
	public List<Evenement> findAll() throws Exception;
	/**
	 * Chercher un evenement par son nom
	 * @param name
	 * @return
	 * @throws Exception
	 */
	public Evenement findEvenementByName(String name) throws Exception;
	
	/**
	 * Chercher un evenement par dates
	 * @param date
	 * @return
	 * @throws Exception
	 */
	public List<Evenement> findEvenementsByDateRange(Date start_date, Date end_date) throws Exception;
	
	/**
	 * Lister des événements par nom
	 * @param srchKeyWord
	 * @return
	 * @throws Exception
	 */
	public List<Evenement> findEvenementsByPartialName(String srchKeyWord) throws Exception;
	
	public List<EnumPeriodeEvet> findEnumPeriod()throws Exception;
	
	/**
	 * Lister des événements par nom utilisateur
	 * @param respname
	 * @return
	 * @throws Exception
	 */
	public List<Evenement> findEvenementsByRespName(String respname) throws Exception;
	
	/**
	 * Lister des événements par statut (traité ou non)
	 * @param status
	 * @return
	 * @throws Exception
	 */
	public List<Evenement> findEvenementsByStatus(int status) throws Exception;
	
	/**
	 * Lister des événements par type de dossier associé
	 * @param typedos
	 * @return
	 * @throws Exception
	 */
	public List<Evenement> findEvenementsByTypeDos(String typedos) throws Exception;
}
