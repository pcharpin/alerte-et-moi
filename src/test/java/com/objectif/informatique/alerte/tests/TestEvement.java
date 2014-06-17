/**
 * 
 */
package com.objectif.informatique.alerte.tests;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.service.EvenementServiceImpl;

/**
 * @author vdibi
 *
 */
public class TestEvement {

	/**
	 * @param args
	 * @throws Exception 
	 */
	public static void main(String[] args)  throws Exception{
		try {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaALerte");
        EntityManager em = emf.createEntityManager();
			EvenementServiceImpl evenementServiceImpl = new EvenementServiceImpl(em);

			Evenement evenement = new Evenement();
			em.getTransaction().begin();
			evenement.setNomEvt("TOTO");
			evenementServiceImpl.create(evenement);
	        em.getTransaction().commit();
			
	        System.out.println("--- Create and persist artist ---");
	       
	        


			
			System.out.println("resultat : " + evenementServiceImpl.create(evenement));			
			//evenement.setDocuments(documents);
			System.out.println("evenement : " + evenement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
