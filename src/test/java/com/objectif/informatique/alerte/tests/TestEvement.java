/**
 * 
 */
package com.objectif.informatique.alerte.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objectif.informatique.alerte.dao.EvenementDAO;
import com.objectif.informatique.alerte.model.Document;
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
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		//EvenementDAO jdbcEvenementDAO = (EvenementDAO) context.getBean("evenementDAO");
		//Integer evenement = jdbcEvenementDAO.findByEvenementById(1);
		//ArrayList<String> evenement = jdbcEvenementDAO.selectedAllEvenementByName();
		
		try {
			EvenementServiceImpl evenementServiceImpl = new EvenementServiceImpl();

			Evenement evenement = new Evenement();
			Document documents = new Document(1, "testaccesDoc", "ttps://www.google.fr");
			evenement.setNomEvt("TOTO");
			//evenement.setDocuments(documents);
			evenementServiceImpl.create(evenement);
			System.out.println("evenement : " + evenement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
