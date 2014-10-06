/**
 * 
 */
package com.objectif.informatique.alerte.rest;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
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
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.objectif.informatique.alerte.model.Document;
import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.model.Responsable;
import com.objectif.informatique.alerte.service.DocumentService;
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
	
	@Autowired
	DocumentService docService;
	
	@Value("${alerte.file.root.dir}")
	String rootPath ;
	
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

		String [] datas =  evenement.getDocumentContents();
		String [] datasNames = evenement.getDocumentNames();
		
		for (int i = 0; i < datas.length; i++) {			
			String data = datas[i];
			String dataName = datasNames[i];
			
			//Chemin à modifier (mettre le chemin du server)
			String path = rootPath + dataName;
			try {
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
				dos.writeBytes(data);
				dos.close();
				
				//Création d'un objet document
				Document doc = new Document();
				doc.setLienDoc(path);
				docService.create(doc);
				
				if(evenement.getDocuments() == null){
					evenement.setDocuments( new HashSet<Document>());
				}
				evenement.getDocuments().add(doc);
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
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
	//@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Transactional
	public Response deleteEvent(@PathParam("id") int id){ 
		service.delete(service.getEvenementById(id));
		return Response.ok().build();
	}
	/**
	 * Mise à jour d'un evenement par son id
	 * @return
	 */
	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	@Transactional
	public  Response updateEvent(@PathParam("id") int id){
			service.update(service.getEvenementById(id));
			return Response.ok().build();
	}
	
	/**
	 * Retourne tous les evenements 
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/getbydates")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Evenement>  getEventsByDates() throws Exception {
		
		Calendar c = new GregorianCalendar();
	    c.set(Calendar.HOUR_OF_DAY, 0); //anything 0 - 23
	    c.set(Calendar.MINUTE, 0);
	    c.set(Calendar.SECOND, 0);
	    Date current_date = c.getTime();
	    
	    c.set(Calendar.MONTH, c.get(Calendar.MONTH -1));
	    
		Date start_date =  c.getTime();
		c.set(Calendar.MONTH, c.get(Calendar.MONTH +2));
		Date end_date = c.getTime();
		
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		String str_from= sdf.format(start_date);
		String str_to= sdf.format(end_date);
		String str_current = sdf.format(current_date);
		
		System.out.println("Now " + str_current + " "+ "From " + str_from + " "+ "To "+ str_to);
		
	    
		List<Evenement> evenements = service.findEvenementsByDateRange(start_date, end_date);
		return evenements;
	}
}