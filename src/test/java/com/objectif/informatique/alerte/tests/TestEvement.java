/**
 * 
 */
package com.objectif.informatique.alerte.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.objectif.informatique.alerte.dao.EvenementDAOImpl;
import com.objectif.informatique.alerte.model.Evenement;

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
        EvenementDAOImpl evenementServiceImpl = new EvenementDAOImpl(em);

			List<Evenement> evenements = evenementServiceImpl.findAll();
			for(int i=0;i<evenements.size();i++){
				System.out.println("evenement "+i+" = "+evenements.get(i).getNomEvt());
			}
			
	        System.out.println("--- OOOOOOOOKKKKKKKKKKKK ---");
	       
	        


			
			//System.out.println("resultat : " + evenementServiceImpl.create(evenement));			
			//evenement.setDocuments(documents);
			//System.out.println("evenement : " + evenement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
