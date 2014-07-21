/**
 * 
 */
package com.objectif.informatique.alerte.rest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.objectif.informatique.alerte.model.Dossier;
import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.model.Responsable;
import com.objectif.informatique.alerte.service.DossierService;
import com.objectif.informatique.alerte.service.EvenementService;
import com.objectif.informatique.alerte.service.ResponsableService;

/**
 * 
 */
@Component
@Path("/evenement")
public class EvenementRestService {

	@Autowired
	EvenementService service;
	@Autowired
	DossierService dossierService;
	@Autowired
	ResponsableService respService;
	private Responsable responsable;
	
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("JpaALerte");
	EntityManager em = emf.createEntityManager();
	

	/**
	 * Retourne un evenement par son id
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Evenement getEvenement(@PathParam("id") int id) {
		return service.getEvenementById(id);
	}

//	@GET
//	@Path("/{nom}")
//	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
//	public Response getByName(Evenement evenement,@PathParam("nom") String nom){
//		evenement =  service.getEvenementByName(nom);
//		return Response.ok().build();
//	}
	
	/**
	 * Retourne tous les evenements 
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/getall")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Evenement> getAllEvenement() throws Exception {
		List<Evenement> evenements = service.findAll();
		return evenements;
	}	
	/**
	 * Creer un evenement
	 * @param evenement
	 * @return
	 */
	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response add(Evenement evenement,@PathParam("id") int id){		
		//Attribution d'un dossier par defaut
		Dossier dossier = null;
		dossierService.getDossierById(id); 
//		if(dossier == null){
//			dossierService.create(dossier); 
//		}
		
		
		//Profil : attribution du rôle normal à la création
		respService.getResponsableById(id);
//		Profil profil =  new Profil();
//		profil.setIdProf(2);
	
		//selection un responsable existant ou créer(un par défaut)
		//Responsable responsable = new Responsable();
		//responsable.setProfil(2);
		
//		Responsable responsable = null;
//		if(responsable != null){
//			respService.getResponsableById(id);
//		}
//		else {
//			responsable.setProfil(2);
//		}
//		
		//respService.getResponsableById(1);
		
		// Création d'un evenement
//		evenement.setResponsable(responsable);	
//		evenement.setDossier(dossier);
		service.create(evenement);
		
		return Response.status(200).entity(evenement).build();
	}
	/**
	 * Supprimmer un evenement par son id
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response deleteEvent(@PathParam("id") int id,Evenement evenement){
		evenement =  service.getEvenementById(id);
		service.delete(evenement);
		return Response.ok().build();
	}
	/**
	 * Mise à jour d'un evenement par son id
	 * @return
	 */
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public  Response updateEvent(@PathParam("id") int id,Evenement evenement){
		evenement =  service.getEvenementById(id);
		if(evenement != null){
			service.update(evenement);
		}
		return Response.status(200).entity(evenement).build();		
	}
}