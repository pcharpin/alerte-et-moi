/**
 * 
 */
package com.objectif.informatique.alerte.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.objectif.informatique.alerte.dao.EvenementDAOImpl;
import com.objectif.informatique.alerte.model.Evenement;

/**
 * 
 */
@Path("/Alerte")
public class EvenementRestService {

	@GET
	@Path("/:id")
	@Produces("application/json")
	public String getEvenement(@PathParam(value="id") int id) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaALerte");
        EntityManager em = emf.createEntityManager();
		EvenementDAOImpl evenementServicDaoImpl = new EvenementDAOImpl(em);
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		
		try {
			
			List<Evenement> evenements =evenementServicDaoImpl.findAll();
			String evenement = null; 
		for(int i=0;i<evenements.size();i++){
			evenement = evenements.get(i).getNomEvt();	
			String json = gson.toJson(evenement);
			System.out.println("Résultat = "+ json);
			gson.toJson(evenement);
		}
	}

		catch (Exception e) {
			System.out.println("Exception Error"); // Console
		}
		return null;

	}

}