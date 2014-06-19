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
	@Produces("application/json")
	public String getEvenement() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaALerte");
        EntityManager em = emf.createEntityManager();
		EvenementDAOImpl evenementServicDaoImpl = new EvenementDAOImpl(em);
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		Gson gson1 = new Gson();
	
		String evenement = null;
		List<Evenement> evenements = null;
		try {
//			ArrayList<String> interests = new ArrayList<String>(); 
//			evenements =evenementServicDaoImpl.findAll();
//			
			ArrayList<String> interests = new ArrayList<String>();  
			Evenement evenement2 =  new Evenement();
			evenement2.setNomEvt("nomEvt");
			evenement2.setActifEvt(0);
			interests.add(evenement);		
			gson1 = new Gson();
			evenement = gson1.toJson(evenement2);
			System.out.println("Résultat = "+ gson1.toJson(evenement2));			
	}

		catch (Exception e) {
			System.out.println("Exception Error"); // Console
		}
		return evenement;
	}
}