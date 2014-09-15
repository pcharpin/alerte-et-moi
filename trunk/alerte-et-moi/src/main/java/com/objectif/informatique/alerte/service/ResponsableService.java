package com.objectif.informatique.alerte.service;

import java.util.List;

import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.model.Responsable;

/**
 * JAVADOC ETC...
 * @author npincon
 *
 */
public interface  ResponsableService {
	
	public Responsable getResponsableById(int responsableId);
	List<Responsable> findAll() throws Exception;
	public Responsable getResponsableByName(String name) throws Exception;
	public Responsable create(Responsable responsable);
	public void delete(Responsable respId);
	public void update(Responsable responsable);
	public Responsable findResponsableById(int id);
	List<Evenement> findAllEventsByRespName(String respName) throws Exception;
}