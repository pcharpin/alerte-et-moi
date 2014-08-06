/**
 * 
 */
package com.objectif.informatique.alerte.rest;

import java.util.List;

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
import org.springframework.transaction.annotation.Transactional;

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
//	public Evenement getByName(Evenement evenement,@PathParam("nom") String nom){
//	return service.getEvenementByName(nom);	
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
	//@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Transactional
	public Response add(Evenement evenement){
		System.out.println("**evenement depuis le forme**:" + evenement);
		int idDossier = evenement.getDossier().getIdDos();
		System.out.println("**idDossier depuis le forme**:" + idDossier);
		
		Dossier dossier = evenement.getDossier(); 
		System.out.println("dossier recupere :" + dossier);
		
		int IdDossierRecup = dossier.getIdDos();
		
		System.out.println("**IdDossierRecup**:" + IdDossierRecup);
		
		System.out.println("id du dossier recuperer :" + dossier.getIdDos());
		System.out.println("**************************");
		Responsable responsable =  evenement.getResponsable();
		System.out.println("responsable recupere :" + responsable);
		
		System.out.println("**************************");
		Responsable responsableid =  evenement.getResponsable_resp();
		System.out.println("responsableid recupere :" + responsableid);
		System.out.println("**************************");
//		int idDossier = dossier.getIdDos();
		evenement.setDossier(dossier);
		evenement.setResponsable(responsable);
//		
		
		System.out.println("evenement à créer:" + evenement);
		service.create(evenement);
		
		return Response.status(200).entity(evenement).build();
	}
	/**
	 * Supprimmer un evenement par son id
	 * @param id
	 * @return
	 */
	@DELETE
	//@Path("/{id}")
	@Path("/deleteEvent")
	//@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	//public Response deleteEvent(@PathParam("id") int id){
	@Transactional
	public Response deleteEvent(Evenement evenement){ 
		//Evenement evenement =  service.getEvenementById(id);
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
	@Transactional
	public  Response updateEvent(@PathParam("id") int id,Evenement evenement){
		evenement =  service.getEvenementById(id);
		if(evenement != null){
			service.update(evenement);
		}
		return Response.status(200).entity(evenement).build();		
	}
}