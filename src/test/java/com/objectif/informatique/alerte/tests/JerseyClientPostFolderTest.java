package com.objectif.informatique.alerte.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;

import com.objectif.informatique.alerte.dao.DossierDAOImpl;
import com.objectif.informatique.alerte.model.Dossier;
import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.service.DossierService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPostFolderTest {

	@Autowired
	static DossierService service;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("JpaALerte");
		EntityManager em = emf.createEntityManager();

		try {
			Client client = Client.create();
			// GetAll
			// WebResource webResource =
			// client.resource("http://localhost:8080/alerte-et-moi/rest/dossier/getFolders");
			// by id
			// WebResource webResource =
			// client.resource("http://localhost:8080/alerte-et-moi/rest/dossier/1");

			// Update
			// WebResource webResource =
			// client.resource("http://localhost:8080/alerte-et-moi/rest/dossier/update/2");
			// création
			WebResource webResource = client
					.resource("http://localhost:8080/alerte-et-moi/rest/dossier/sendFolder");

			DossierDAOImpl dossierService = new DossierDAOImpl(em);
			// Get dossier
			// Dossier dossier = dossierService.findFolderById(2);
			Dossier dossier = new Dossier();
			dossier.setNomDos("conseil");
			dossier.setDescDoc("Gant2");

			em.getTransaction().begin();
			// dossierService.update(dossier);
			dossierService.create(dossier);
			// service.create(dossier);
			em.getTransaction().commit();

			// ClientResponse response =
			// webResource.post(ClientResponse.class,dossier);
			ClientResponse response = webResource.accept("application/json")
					.post(ClientResponse.class, dossier);

			if (response.getStatus() != 200) {
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