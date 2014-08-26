/**
 * 
 */
package com.objectif.informatique.alerte.rest;

import java.util.ArrayList;
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
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.model.Responsable;
import com.objectif.informatique.alerte.service.DocumentService;
import com.objectif.informatique.alerte.service.DossierService;
import com.objectif.informatique.alerte.service.EvenementService;
import com.objectif.informatique.alerte.service.ResponsableService;
import com.objectif.informatique.alerte.utils.FileUploadForm;

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
	
	@Autowired
	DocumentService docService;
	
	
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
	public Response add(Evenement evenement/*,@ModelAttribute("uploadForm")FileUploadForm uploadForm,Model map*/){
		
		System.out.println("************************___o____*************************************");		
		System.out.println("Depuis le form : " + evenement);
		System.out.println("***********************___o____**************************************");
//		//téléchargement du ou des fihciers 
//		List<MultipartFile> files = uploadForm.getFiles();
//
//		List<String> fileNames = new ArrayList<String>();
//		
//		if(null != files && files.size() > 0) {
//			for (MultipartFile multipartFile : files) {
//
//				String fileName = multipartFile.getOriginalFilename();
//				fileNames.add(fileName);
//			}
//		}		
//		map.addAttribute("files", fileNames);
		
		service.create(evenement);	
		System.out.println("évènement crée : " + evenement);
		System.out.println("***********************___o____**************************************");
		return Response.status(200).entity(evenement).build();
	}
	/**
	 * Supprimmer un evenement par son id
	 * @param id
	 * @return
	 */
	@DELETE
	@Path("/deleteEvent")
	//@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
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