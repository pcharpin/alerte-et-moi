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
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.objectif.informatique.alerte.dao.EvenementDAOImpl;
import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.service.EvenementService;

/**
 * 
 */
@Component
@Path("/evenement")
public class EvenementRestService {
	
	@Autowired
	EvenementService service;

	@GET
	@Path("/evenement/get")
	@Produces(MediaType.APPLICATION_JSON)
	public Evenement getEvenement() {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaALerte");
        EntityManager em = emf.createEntityManager();
		EvenementDAOImpl evenementServicDaoImpl = new EvenementDAOImpl(em);
	
		Evenement evenement = null;
		try {
			System.out.println("totototototo ");			
			evenement = evenementServicDaoImpl.findAll().get(0);
			System.out.println("Résultat = " +evenement);
			
			
	}

		catch (Exception e) {
			System.out.println("Exception Error"+e.getMessage()); // Console
		}
		return evenement;
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	public Evenement getEvenement(@PathParam("id") int id) {
		return service.getEvenementById(id);
	}
	
	
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON+";charset=utf-8")
	public List<Evenement> getAllEvenement() throws Exception {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaALerte");
        EntityManager em = emf.createEntityManager();
		EvenementDAOImpl evenementServicDaoImpl = new EvenementDAOImpl(em);
		List<Evenement> evenements = evenementServicDaoImpl.findAll();
		return evenements;
	}

}