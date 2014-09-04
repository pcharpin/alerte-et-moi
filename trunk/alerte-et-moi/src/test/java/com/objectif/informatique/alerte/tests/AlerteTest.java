package com.objectif.informatique.alerte.tests;

import java.security.Provider.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.objectif.informatique.alerte.dao.AlerteDAOImpl;
import com.objectif.informatique.alerte.dao.EvenementDAOImpl;
import com.objectif.informatique.alerte.model.Alerte;
import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.model.TypeDeclenchAler;
import com.objectif.informatique.alerte.service.EvenementService;

public class AlerteTest {

	protected static EntityManagerFactory emf;
	EntityManager em = emf.createEntityManager();

	@Autowired
	EvenementService service;

	@BeforeClass
	public static void createEntityManagerFactory() {
		emf = Persistence.createEntityManagerFactory("JpaALerte");
	}

	@AfterClass
	public static void closeEntityManagerFactory() {
		emf.close();
	}

	// @Test
	// public void test() {
	// fail("Not yet implemented");
	// }

	@Test
	public void addalerte() {
		EvenementDAOImpl evenement = new EvenementDAOImpl(em);

		service.getEvenementById(4);

		Evenement event = em.find(Evenement.class, 4);

		// Evenement event = new Evenement();
		// event.setNomEvt("RSI test mardi");
		// event.setDateEchEvt(new Date());
		//
		// Dossier dossier = em.find(Dossier.class, 2);
		// System.out.println("****dossier***" + dossier);
		// Responsable resp = em.find(Responsable.class, 1);
		//
		// event.setDossier(dossier);
		//
		// try {
		// event = evenement.find(4);
		//
		// } catch (Exception e) {
		//
		// e.printStackTrace();
		// }
		//

		AlerteDAOImpl a = new AlerteDAOImpl(em);
		Alerte alerte = new Alerte();
		alerte.setTypeDeclenchAler(TypeDeclenchAler.Minutes);
		alerte.setEvenement(event);

		em.getTransaction().begin();
		// evenement.create(event);
		a.create(alerte);
		em.getTransaction().commit();
		System.out.println("o_o");
	}

}
