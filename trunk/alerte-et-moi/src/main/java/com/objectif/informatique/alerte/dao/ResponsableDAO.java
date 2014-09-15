package com.objectif.informatique.alerte.dao;

import java.util.List;

import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.model.Responsable;

/**
 * @author vdibi
 * 
 */

public interface ResponsableDAO extends GenericDAO<Responsable>{
	/**
	 * 
	 * @param respId
	 * @return
	 * @throws Exception
	 */
	Responsable findResponsableById(int respId) throws Exception;
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Responsable> findAll() throws Exception;
	
	
	List<Evenement> findAllEventsByRespName(String nomResp) throws Exception;

}
