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
import com.objectif.informatique.alerte.model.EnumTypesDossiers;
import com.objectif.informatique.alerte.service.DossierService;
import com.objectif.informatique.alerte.service.EnumTypesDossiersService;

@Component
@Path("/dossier")
public class DossierRestService {
	
	@Autowired
	DossierService service;
	@Autowired
	EnumTypesDossiersService enumTypesDossiersService;

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Dossier getFolder(@PathParam("id") int id) {
		return service.getDossierById(id);
	}
	
	@GET
	@Path("/folder/{name}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Dossier getFolderByName(@PathParam("name") String dossier) {
		
//		Dossier dossier = new Dossier();
		//name = service.getDossierById(id);
		return service.getFolderByName(dossier);
	}
	
	@GET
	@Path("/getFolders")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Dossier> getAllFolders() throws Exception {
		List<Dossier> dossiers = service.findAll();
		return dossiers;
	}	
		
	@GET
	@Path("/getTypesFolders")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<EnumTypesDossiers> getAllFoldersType() throws Exception {
		List<EnumTypesDossiers> dossiersTypes = enumTypesDossiersService.findAll();
		return dossiersTypes;
	}	
	
	@POST
	@Path("/sendFolder")
	@Consumes(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Transactional
	public Response add(Dossier dossier){	
		service.create(dossier);		
		return Response.status(200).entity(dossier).build();
	}
	
	@PUT
	@Path("/update/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Transactional
	public  Response updateFolder(@PathParam("id") int id,Dossier dossier){
		dossier =  service.getDossierById(id);
		if(dossier != null){
			service.update(dossier);
		}
		return Response.status(200).entity(dossier).build();		
	}
	
	@DELETE
	@Path("/{id}")
	//@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Transactional
	public Response deleteFolder(@PathParam("id") int id){
		Dossier dossier =  service.getDossierById(id);
		service.delete(dossier);
		return Response.ok().build();
	}
}