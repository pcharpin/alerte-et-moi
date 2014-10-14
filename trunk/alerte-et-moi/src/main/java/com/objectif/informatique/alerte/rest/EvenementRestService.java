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
	
	private final int [] MONTH_LENGTH
	= {31,28,31,30,31,30,31,31,30,31,30,31};
	
	/**
	 * Retourne un evenement par son id
	 * @param id
	 * @return
	 */
	@GET
	@Path("/{id:[0-9]+}")
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
			
			//Chemin � modifier (mettre le chemin du server)
			String path = rootPath + dataName;
			try {
				DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
				dos.writeBytes(data);
				dos.close();
				
				//Cr�ation d'un objet document
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
	 * Mise � jour d'un evenement par son id
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
	 * Retourne tous les evenements sur 3 mois. Mois courant M-1, M et M+1 
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/date/{day}-{month}-{year}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Evenement>  getEventsByDate(@PathParam("day") int day,
											@PathParam("month") int month,
											@PathParam("year") int year) throws Exception {
		
		Calendar calendar = null;
		
		int current_month = 11;
		int start_month;
		int end_month;
		int current_year = 2014;
		int start_year;
		int end_year;
		
		
		if (  year != 0 &&  month != 0 && day != 0){
			calendar = new GregorianCalendar(year, month-1, day);
		} else {
			calendar = new GregorianCalendar();
		}
	    
		current_month = calendar.get(Calendar.MONTH);
	    current_year = calendar.get(Calendar.YEAR);
	    
	    //Controls on current month to detect switch on year to perform DAO request 
	    if (current_month == 0){
	    	start_month = 11;
	    	start_year = current_year-1;
	    	calendar = new GregorianCalendar(start_year, start_month, 1);
	    } else {
	    	calendar = new GregorianCalendar(current_year, current_month-1, 1);
	    }
    
		Date start_date = calendar.getTime();
	    
	    if (current_month == 11){
	    	end_month = 0;
	    	end_year = current_year + 1;
	    	calendar = new GregorianCalendar(end_year, end_month, MONTH_LENGTH[end_month]);
	    } else
	    	calendar = new GregorianCalendar(current_year, current_month+1, MONTH_LENGTH[current_month+1]);
	    		    
	    Date end_date = calendar.getTime();
		
	    
		List<Evenement> evenements = service.getEvenementsByDateRange(start_date, end_date);
		return evenements;
	}
	
	
	/**
	 * Retourne tous les evenements � partir du nom (ou partie) 
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/{name}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Evenement>  getEventsByName(@PathParam("name") String name) throws Exception {
				
	    
		List<Evenement> evenements = service.getEvenementsByPartialName(name);
		return evenements;
	}
	
	
	/**
	 * Retourne tous les evenements � partir du nom (ou partie) 
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/resp/{respname}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Evenement>  getEventsByRespName(@PathParam("respname") String respname) throws Exception {
				
	    
		List<Evenement> evenements = service.getEvenementsByRespName(respname);
		return evenements;
	}
	
	
	/**
	 * Retourne tous les evenements � partir du nom (ou partie) 
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/folder/{typedos}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Evenement>  getEventsByDosType(@PathParam("typedos") String typedos) throws Exception {
				
	    
		List<Evenement> evenements = service.getEvenementsByTypeDos(typedos);
		return evenements;
	}
	
	/**
	 * Retourne tous les evenements � partir du nom (ou partie) 
	 * @return
	 * @throws Exception
	 */
	@GET
	@Path("/status/{status}")
	@Produces(MediaType.APPLICATION_JSON + ";charset=utf-8")
	public List<Evenement>  getEventsByStatus(@PathParam("status") int status) throws Exception {
				
	    
		List<Evenement> evenements = service.getEvenementsByStatus(status);
		return evenements;
	}
}