/**
 * 
 */
package com.objectif.informatique.alerte.rest;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
	public List<Evenement> getEvenement() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaALerte");
        EntityManager em = emf.createEntityManager();
		EvenementDAOImpl evenementServicDaoImpl = new EvenementDAOImpl(em);
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
	
		String evenement = null;
		List<Evenement> evenements = null;
		try {
			evenements =evenementServicDaoImpl.findAll();
		for(int i=0;i<evenements.size();i++){
			//evenement += evenements.get(i).getNomEvt();
			evenement += evenements.get(i).getNomEvt();	
			String json = gson.toJson(evenement);
			System.out.println("Résultat = "+ json);
			//gson.toJson(evenement);
		}
	}

		catch (Exception e) {
			System.out.println("Exception Error"); // Console
		}
		return evenements;
		

	}

}