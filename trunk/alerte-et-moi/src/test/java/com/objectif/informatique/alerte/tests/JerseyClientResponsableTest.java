package com.objectif.informatique.alerte.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.objectif.informatique.alerte.dao.ResponsableDAOImpl;
import com.objectif.informatique.alerte.model.Responsable;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientResponsableTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("JpaALerte");
		EntityManager em = emf.createEntityManager();
		 
		try {
			Client client =  Client.create();
			//test Get
			//WebResource webResource = client.resource("http://localhost:8080/alerte-et-moi/rest/responsable/1");
			//WebResource webResource = client.resource("http://localhost:8080/alerte-et-moi/rest/responsable/getallResponsable");
			
			//ClientResponse response = webResource.accept("application/json").get(ClientResponse.class);
			
			//test Post
			WebResource webResource = client.resource("http://localhost:8080/alerte-et-moi/rest/responsable/send");
				
			ResponsableDAOImpl responsableDAOImpl =  new ResponsableDAOImpl(em);
			Responsable responsable = new Responsable();
			responsable.setNomResp("alertAdmin");
			responsable.setPrenResp("Julia");
			responsable.setEmailResp("responsable@objectif-informatique.fr");
			responsable.setProfil(2);
			em.getTransaction().begin();
			responsableDAOImpl.create(responsable);
			em.getTransaction().commit();
			ClientResponse response = webResource.accept("application/json").post(ClientResponse.class,responsable);
			
			
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