package com.objectif.informatique.alerte.tests;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.objectif.informatique.alerte.dao.DossierDAOImpl;
import com.objectif.informatique.alerte.model.Dossier;

public class DossierTest {
	
	protected static EntityManagerFactory emf;
	EntityManager em = emf.createEntityManager();
	
	@BeforeClass
    public static void createEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("JpaALerte");
    }
	
	@AfterClass
    public static void closeEntityManagerFactory() {
        emf.close();
    }
	

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}
	
	@Test
	public void addolder(){
		DossierDAOImpl d = new DossierDAOImpl(em);
		Dossier dossier = new Dossier("TestDossier");
		dossier.setDescDoc("test de crétion3");
		
		em.getTransaction().begin();
        d.create(dossier);
        em.getTransaction().commit();
		System.out.println("o_o");
	}
	
}
