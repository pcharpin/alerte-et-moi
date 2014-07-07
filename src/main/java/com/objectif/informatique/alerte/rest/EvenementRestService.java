/**
 * 
 */
package com.objectif.informatique.alerte.rest;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.objectif.informatique.alerte.model.Dossier;
import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.model.Profil;
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
	public Response add(Evenement evenement){		
		//créer un dossier
		Dossier dossier = new Dossier("TestL");
		dossier.setDescDoc("descDoc");
		dossierService.create(dossier);
		
		//Profil
		Profil profil =  new Profil();
		profil.setIdProf(2);
	
		//selection un responsable existant ou créer
		Responsable responsable = new Responsable();
		responsable.setNomResp("admin");
		responsable.setNomResp("nomResp");
		responsable.setPrenResp("prenResp");
		responsable.setEmailResp("test@objectif-informatique.com");
		responsable.setProfil(2);
		
		// Evenement
		evenement = new Evenement();
		evenement.setNomEvt("testGan");
		evenement.setDateEchEvt(new Date());
		evenement.setDossier(dossier);
		evenement.setResponsable(responsable);
		
		service.create(evenement);
		
		return Response.status(200).entity(evenement).build();
	}
	/**
	 * Supprimmer un evenement par son id
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response deleteEvent(@PathParam("id") int id){
		service.delete(Evenement.class,id);
		return Response.ok().build();
	}
//	@PUT
//	@Path("/{id}")
//	public 
}