/**
 * 
 */
package com.objectif.informatique.alerte.service;

import com.objectif.informatique.alerte.model.Alerte;

/**
 * @author gsoh
 *
 */
public interface AlerteService {

	public Alerte create(Alerte alerte);
	public void update(Alerte alerte);
}
