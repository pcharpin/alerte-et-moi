/**
 * 
 */
package com.objectif.informatique.alerte.tests;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
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
		final GsonBuilder builder = new GsonBuilder();
		final Gson gson = builder.create();
		try {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaALerte");
        EntityManager em = emf.createEntityManager();
        EvenementDAOImpl evenementServiceImpl = new EvenementDAOImpl(em);

			List<Evenement> evenements = evenementServiceImpl.findAll();
			String evenement = null ;
			for(int i=0;i<evenements.size();i++){
			evenement = evenements.get(i).getNomEvt();	
			String json = gson.toJson(evenement);
				//System.out.println("evenement = "+ evenement);
				System.out.println("Résultat = "+ json);
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
