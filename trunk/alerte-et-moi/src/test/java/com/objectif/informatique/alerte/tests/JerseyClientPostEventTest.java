package com.objectif.informatique.alerte.tests;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;

import com.objectif.informatique.alerte.dao.EvenementDAOImpl;
import com.objectif.informatique.alerte.model.Dossier;
import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.service.DossierService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPostEventTest {
	@Autowired
	static
	DossierService dossierService;
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("JpaALerte");
		 EntityManager em = emf.createEntityManager();
		try {
			Client client =  Client.create();
			WebResource webResource = client.resource("http://localhost:8080/alerte-et-moi/rest/evenement/send");
			
			EvenementDAOImpl evenementDAOImpl = new EvenementDAOImpl(em);
			//ResponsableDAOImpl respService = new ResponsableDAOImpl();
			
			
			//créer un dossier
			Dossier d = new Dossier();
			
			
//			dossier.setDescDoc("descDoc");
//			dossierService.create(dossier);
			//dossier.setIdDos(1);
			
			//Profil
//			Profil profil =  new Profil();
//			profil.setIdProf(2);
		
			//selection un responsable existant ou créer
//			Responsable responsable = new Responsable();
//			responsable.setNomResp("admin");
//			responsable.setNomResp("nomResp");
//			responsable.setPrenResp("prenResp");
//			responsable.setEmailResp("test@objectif-informatique.com");
//			responsable.setProfil(2);
		
			// Evenement
			Evenement evenement = new Evenement();
			evenement.setNomEvt("testGanss");
			evenement.setDateEchEvt(new Date());
			//evenement.setDossier(dossier);
			//evenement.setResponsable(responsable);
						
//			evenement.setDateEchEvt(new Date());
//			Dossier dossier =  em.find(Dossier.class, 2);
//			Responsable resp = em.find(Responsable.class, 1);
		//	evenement.setDossier(dossier);
//			evenement.setResponsable(resp);
			
			em.getTransaction().begin();
		//	Evenement evenement = new Evenement();
			
			try {
				d  = dossierService.getDossierById(1);
				d.getDescDoc();
				evenement.setDossier(d);
				evenementDAOImpl.create(evenement);
				em.getTransaction().commit();
			} catch (Exception e) {
				e.printStackTrace();
			}
										
			ClientResponse response = webResource.accept("application/json").post(ClientResponse.class,evenement);
			
			if(response.getStatus() != 200) {
				   throw new RuntimeException("Failed : HTTP error code : "
					+ response.getStatus());
				}
		 
				String output = response.getEntity(String.class);
		 
				System.out.println("Output from Server .... \n");
	
				System.out.println(output);
		 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}