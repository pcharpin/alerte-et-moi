package com.objectif.informatique.alerte.dao;

import java.util.List;

import com.objectif.informatique.alerte.model.Alerte;

public interface AlerteDAO extends GenericDAO<Alerte> {
	
	/**
	 * 
	 * @param alertId
	 * @return
	 * @throws Exception
	 */
	Alerte findAlerteById(int alertId) throws Exception;
	
	/**
	 * 
	 * @param alertId
	 * @return
	 * @throws Exception
	 */
	void deleteAlerte(Alerte alerte) throws Exception;
		
	/**
	 * 
	 * @param
	 * @return
	 * @throws Exception
	 */
	List<Alerte> findAll() throws Exception;

}
