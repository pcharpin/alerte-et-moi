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

import com.objectif.informatique.alerte.model.Profil;
import com.objectif.informatique.alerte.service.ProfilService;

/**
 * 
 */
@Component
@Path("/profil")
public class ProfilRestService {

	@Autowired
	ProfilService service;
	
	EntityManagerFactory emf =Persistence.createEntityManagerFactory("JpaALerte");
	EntityManager em = emf.createEntityManager();
	

	/**
	 * Retourne un profil par son id
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public Profil getProfil(@PathParam("id") int id) {
		return service.getProfilById(id);
	}

	/**
	 * Retourne tous les profils existant 
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/getallProfil")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Profil> getAllProfil() throws Exception {
		List<Profil> profils = service.findAll();
		return profils;
	}	
}