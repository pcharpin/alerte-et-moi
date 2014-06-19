package com.objectif.informatique.alerte.tests;

import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.objectif.informatique.alerte.dao.EvenementDAOImpl;
import com.objectif.informatique.alerte.model.Document;
import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.model.Responsable;

public class NicoTest {
	
	protected static EntityManagerFactory emf;
	
	@BeforeClass
    public static void createEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("JpaALerte");
    }
	
	@AfterClass
    public static void closeEntityManagerFactory() {
        emf.close();
    }
	
	
	@Test 
	public void testPersistEvtWithDocs() throws Exception {
		EntityManager em = emf.createEntityManager();
        EvenementDAOImpl evenementServiceImpl = new EvenementDAOImpl(em);
        Responsable resp = em.find(Responsable.class, 1);
        
        Evenement evt = new Evenement("AVEC DOCS");
        evt.setResponsable(resp);
        evt.setDateEchEvt(new Date());
        evt.setIdDos(1);
        
        //Documents
        Document doc1 = new Document("acces1", "lien1");
        Document doc2 = new Document("acces2", "lien2");
        Set<Document> docs = new HashSet<Document>();
        docs.add(doc1);
        docs.add(doc2);
        evt.setDocuments(docs);
        
        em.getTransaction().begin();
        evenementServiceImpl.create(evt);
        em.getTransaction().commit();
	}
	
	@Test 
	public void testPersistDocWithEvts() throws Exception {
		EntityManager em = emf.createEntityManager();
        Responsable resp = em.find(Responsable.class, 1);
        
        Document doc = new Document("doc seul", "lien seul");
        
        Evenement evt1 = new Evenement("EVT1");
        Evenement evt2 = new Evenement("EVT2");
        evt1.setResponsable(resp);
        evt1.setDateEchEvt(new Date());
        evt1.setIdDos(1);
        evt2.setResponsable(resp);
        evt2.setDateEchEvt(new Date());
        evt2.setIdDos(1);
        
        Set<Evenement> evts = new HashSet<Evenement>();
        evts.add(evt1);
        evts.add(evt2);
        doc.setEvenements(evts);
        em.getTransaction().begin();
        em.persist(doc);
        em.getTransaction().commit();
	}
	
	@Test 
	public void testGetEvtWithDocs() {
		EntityManager em = emf.createEntityManager();
		Evenement evt = em.find(Evenement.class, 20); //20 est à changer, il correspont à un ID d'une évènement dans MA base de données contenant plusieurs documents.
		assertTrue("Cet évènement devrait contenir plusieurs documents ...", evt.getDocuments().size()>0);
	}
	
	@Test 
	public void testGetDocWithEvts() {
		EntityManager em = emf.createEntityManager();
		Document doc = em.find(Document.class, 21); //2 est à changer, il correspont à un ID d'un document dans MA base de données contenant plusieurs évènements.
		assertTrue("Ce document devrait contenir plusieurs évènements ...", doc.getEvenements().size()>0);
	}

}
