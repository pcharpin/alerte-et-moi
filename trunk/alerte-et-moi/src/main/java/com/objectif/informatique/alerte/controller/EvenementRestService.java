/**
 * 
 */
package com.objectif.informatique.alerte.controller;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.objectif.informatique.alerte.dao.EvenementDAOImpl;
import com.objectif.informatique.alerte.model.Evenement;

/**
 * 
 */
@Path("/WebService")
public class EvenementRestService {

	@GET
	@Path("/GetEvent")
	@Produces("application/json")
	public String getEvenement() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaALerte");
        EntityManager em = emf.createEntityManager();
		 EvenementDAOImpl evenementServicDaoImpl = new EvenementDAOImpl(em);
		try {
			System.out.println("******************************");
			Evenement evenement =  new Evenement();
			evenement.setNomEvt("testAlerte");
			evenementServicDaoImpl.create(evenement);
			Gson gson = new Gson();
			gson.toJson(evenement);
		}

		catch (Exception e) {
			System.out.println("Exception Error"); // Console
		}
		return null;

	}

}