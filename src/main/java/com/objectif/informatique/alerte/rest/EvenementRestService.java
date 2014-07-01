/**
 * 
 */
package com.objectif.informatique.alerte.rest;

import java.util.List;

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
		
	evenement =  new Evenement();
	evenement.setNomEvt("testVdibi");
	evenement.setDescEvt("descEvt");	
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