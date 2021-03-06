package com.objectif.informatique.alerte.tests;

import java.util.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.beans.factory.annotation.Autowired;

import com.objectif.informatique.alerte.dao.DocumentDAOImpl;
import com.objectif.informatique.alerte.dao.EvenementDAOImpl;
import com.objectif.informatique.alerte.model.Document;
import com.objectif.informatique.alerte.model.Dossier;
import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.model.Responsable;
import com.objectif.informatique.alerte.service.DossierService;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

public class JerseyClientPostDocumentTest {
	@Autowired
	static DossierService dossierService;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EntityManagerFactory emf;
		emf = Persistence.createEntityManagerFactory("JpaALerte");
		EntityManager em = emf.createEntityManager();
		try {
			Client client = Client.create();
			WebResource webResource = client
					.resource("http://localhost:8080/alerte-et-moi/rest/document/send");

			DocumentDAOImpl documentDAOImpl = new DocumentDAOImpl(em);

			// Document
			Document document = new Document();
			document.setAccesDoc("accesDoc");
			document.setLienDoc("lienDoc");
			em.getTransaction().begin();
			documentDAOImpl.create(document);
			em.getTransaction().commit();

			ClientResponse response = webResource.accept("application/json")
					.post(ClientResponse.class, document);

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