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

import com.objectif.informatique.alerte.model.Responsable;
import com.objectif.informatique.alerte.service.ResponsableService;

@Component
@Path("/responsable")
public class ResponsableRestService {
	
	@Autowired
	ResponsableService service;

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Responsable getEvenement(@PathParam("id") int id) {
		return service.getResponsableById(id);
	}

	
	@GET
	@Path("/getallResponsable")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Responsable> getAllEvenement() throws Exception {
		List<Responsable> responsables = service.findAll();
		return responsables;
	}	

	@POST
	@Path("/send")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Transactional
	public Response add(Responsable responsable){			
		service.create(responsable);
		return Response.status(200).entity(responsable).build();
	}
	
	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Transactional
	public Response deleteEvent(@PathParam("id") int id,Responsable responsable){
		responsable =  service.getResponsableById(id);
		service.delete(responsable);
		return Response.ok().build();
	}
	
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Transactional
	public  Response updateEvent(@PathParam("id") int id,Responsable responsable){
		responsable =  service.getResponsableById(id);
		if(responsable != null){
			service.update(responsable);
		}
		return Response.status(200).entity(responsable).build();		
	}
}