/**
 * 
 */
package com.objectif.informatique.alerte.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.objectif.informatique.alerte.dao.EvenementDAOImpl;
import com.objectif.informatique.alerte.model.Evenement;

/**
 * 
 */
@Path("/alerte")
public class EvenementRestService {

	@GET
	@Path("/evenement/get")
	//@Produces(MediaType.APPLICATION_JSON)
	@Produces("application/json")
	public List<Evenement> getEvenement() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaALerte");
        EntityManager em = emf.createEntityManager();
		EvenementDAOImpl evenementServicDaoImpl = new EvenementDAOImpl(em);
	
		List<Evenement> evenements = null;
		try {
			System.out.println("totototototo ");			
			evenements = evenementServicDaoImpl.findAll();

			System.out.println("R�sultat = " +evenements);			
	}

		catch (Exception e) {
			System.out.println("Exception Error"+e.getMessage()); // Console
		}
		return evenements;
	}
}