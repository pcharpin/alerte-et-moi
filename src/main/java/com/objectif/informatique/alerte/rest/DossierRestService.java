package com.objectif.informatique.alerte.rest;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.objectif.informatique.alerte.model.Dossier;
import com.objectif.informatique.alerte.service.DossierService;

@Component
@Path("/dossier")
public class DossierRestService {
	
	@Autowired
	DossierService service;

	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Dossier getFolder(@PathParam("id") int id) {
		return service.getDossierById(id);
		//return null;	
	}
	
	@GET
	@Path("/getFolders")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Dossier> getAllFolders() throws Exception {
		List<Dossier> dossiers = service.findAll();
		return dossiers;
	}	
}
