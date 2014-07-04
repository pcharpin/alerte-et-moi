/**
 * 
 */
package com.objectif.informatique.alerte.tests;

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
import com.objectif.informatique.alerte.model.Dossier;
import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.model.Responsable;

/**
 * @author vdibi
 *
 */
public class EvenementTest {
	
protected static EntityManagerFactory emf;
	
	@BeforeClass
    public static void createEntityManagerFactory() {
        emf = Persistence.createEntityManagerFactory("JpaALerte");
    }
	
	@AfterClass
    public static void closeEntityManagerFactory() {
        emf.close();
    }
	
	

	/**
	 * @param args
	 * @throws Exception 
	 */
//	public static void main(String[] args)  throws Exception{
//		final GsonBuilder builder = new GsonBuilder();
//		final Gson gson = builder.create();
//		try {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaALerte");
//        EntityManager em = emf.createEntityManager();
//        EvenementDAOImpl evenementServiceImpl = new EvenementDAOImpl(em);

//			List<Evenement> evenements = evenementServiceImpl.findAll();
//			String evenement = null ;
//			for(int i=0;i<evenements.size();i++){
//			evenement = evenements.get(i).getNomEvt();	
//			String json = gson.toJson(evenement);
//				//System.out.println("evenement = "+ evenement);
//				System.out.println("R�sultat = "+ json);
//			}		
//	        System.out.println("--- OOOOOOOOKKKKKKKKKKKK ---");			
//			//System.out.println("resultat : " + evenementServiceImpl.create(evenement));			
//			//evenement.setDocuments(documents);
//			//System.out.println("evenement : " + evenement);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
	
//	@Test 
//	public void test2() {
//		System.out.println("Bla");
//	}
	
	@Test
	public void createEvent(){
		
		//EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaALerte");
        EntityManager em = emf.createEntityManager();
                     
        EvenementDAOImpl service = new EvenementDAOImpl(em);
        Responsable resp = em.find(Responsable.class, 1);
        Dossier dossier =  em.find(Dossier.class, 2);
        
        Evenement evenement =  new Evenement();
        evenement.setNomEvt("test3");
        evenement.setDateEchEvt(new Date());
//        evenement.setResponsable(resp);
//        evenement.setDossier(dossier);
      
        //Dossier
        //Documents
        Document doc1 = new Document("testAddEventDoc1", "http://www.objectif-informatique.fr/");
        Document doc2 = new Document("testAddEventDoc2", "http://www.objectif-informatique.fr/");
        Set<Document> docs = new HashSet<Document>();
        docs.add(doc1);
        docs.add(doc2);
        
       // evenement.setDocuments(docs);
        em.getTransaction().begin();
        service.create(evenement);
        em.getTransaction().commit();
	}
	
//	@Test 
//	public void testNip() {
//		final GsonBuilder builder = new GsonBuilder();
//		final Gson gson = builder.create();
//		try {
//		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaALerte");
//        EntityManager em = emf.createEntityManager();
//        EvenementDAOImpl evenementServiceImpl = new EvenementDAOImpl(em);
//
//			List<Evenement> evenements = evenementServiceImpl.findAll();
//			String evenement = null ;
//			for(int i=0;i<evenements.size();i++){
//			evenement = evenements.get(i).getNomEvt();	
//			String json = gson.toJson(evenement);
//				//System.out.println("evenement = "+ evenement);
//				System.out.println("Résultat = "+ json);
//			}
//	        System.out.println("--- OOOOOOOOKKKKKKKKKKKK ---");		
//			//System.out.println("resultat : " + evenementServiceImpl.create(evenement));			
//			//evenement.setDocuments(documents);
//			//System.out.println("evenement : " + evenement);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}	
}