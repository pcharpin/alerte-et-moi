package com.objectif.informatique.alerte.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.objectif.informatique.alerte.dao.DossierDAOImpl;
import com.objectif.informatique.alerte.dao.EvenementDAOImpl;
import com.objectif.informatique.alerte.model.Evenement;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientUpdateEventTest {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("JpaALerte");
		EntityManager em = emf.createEntityManager();
		try {
			Client client =  Client.create();
			WebResource webResource = client.resource("http://localhost:8080/alerte-et-moi/rest/evenement/update/21");
			
			EvenementDAOImpl evenementDAOImpl = new EvenementDAOImpl(em);
			DossierDAOImpl dossierService = new DossierDAOImpl();
			
			//grt event id
			Evenement evenement = evenementDAOImpl.findEvenementById(21);
			evenement.setNomEvt("EVT21");
			evenement.setDescEvt("Test de mise à jour");

			em.getTransaction().begin();
			evenementDAOImpl.update(evenement);
			em.getTransaction().commit();
								
			ClientResponse response = webResource.accept("application/json").put(ClientResponse.class,evenement);
			
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