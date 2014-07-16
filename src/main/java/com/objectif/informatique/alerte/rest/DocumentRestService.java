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

import com.objectif.informatique.alerte.model.Document;
import com.objectif.informatique.alerte.service.DocumentService;

/**
 * 
 */
@Component
@Path("/document")
public class DocumentRestService {

	@Autowired
	DocumentService service;
	
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("JpaALerte");
	EntityManager em = emf.createEntityManager();
	

	/**
	 * Retourne un document par son id
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Document getDocument(@PathParam("id") int id) {
		return service.getDocumentById(id);
	}

	/**
	 * Retourne tous les documentS 
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/getallDocument")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Document> getAllDocument() throws Exception {
		List<Document> documents = service.findAll();
		return documents;
	}	
	/**
	 * Creer un document
	 * @param evenement
	 * @return
	 */
	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response add(Document document){			
		service.create(document);		
		return Response.status(200).entity(document).build();
	}
	/**
	 * Supprimmer un document par son id
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Response deleteDocument(@PathParam("id") int id,Document document){
		document =  service.getDocumentById(id);
		service.delete(document);
		return Response.ok().build();
	}
	/**
	 * Mise à jour d'un document par son id
	 * @return
	 */
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public  Response updateEvent(@PathParam("id") int id,Document document){
		document =  service.getDocumentById(id);
		if(document != null){
			service.update(document);
		}
		return Response.status(200).entity(document).build();		
	}
}