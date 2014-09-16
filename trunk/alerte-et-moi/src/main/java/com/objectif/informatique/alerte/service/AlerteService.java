/**
 * 
 */
package com.objectif.informatique.alerte.service;

import java.util.List;

import com.objectif.informatique.alerte.model.Alerte;

/**
 * @author gsoh
 *
 */
public interface AlerteService {

	public Alerte create(Alerte alerte);
	public void update(Alerte alerte);
	public void delete(Alerte alerte);
	public List<Alerte> findAll() throws Exception;
	public Alerte findAlerteById(int id);
}
