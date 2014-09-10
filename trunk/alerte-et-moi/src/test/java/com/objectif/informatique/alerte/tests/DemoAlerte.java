/**
 * 
 */
package com.objectif.informatique.alerte.tests;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.objectif.informatique.alerte.dao.AlerteDAOImpl;
import com.objectif.informatique.alerte.dao.EvenementDAOImpl;
import com.objectif.informatique.alerte.dao.ResponsableDAOImpl;
import com.objectif.informatique.alerte.model.Alerte;
import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.model.Responsable;
import com.objectif.informatique.alerte.model.TypeDeclenchAler;

/**
 * @author gsoh
 *
 */
public class DemoAlerte {
	
	public static void main(String[] args) {
			
			// 1 : Ouverture unité de travail JPA
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaALerte");
			EntityManager em = emf.createEntityManager();
			
			// 2 : Ouverture transaction 
			EntityTransaction tx =  em.getTransaction();
			
			
			EvenementDAOImpl eimpl = new EvenementDAOImpl(em);
			AlerteDAOImpl a = new AlerteDAOImpl(em);
			Alerte alerte = new Alerte();
			
			tx.begin();
			

			Evenement event = em.find(Evenement.class, 153);
			
//			Responsable r = event.getResponsable();
//			
//			r.setEmailResp("to@gmail.com");
//			r.setNomResp("Test");
//			r.setProfil(1);
//			
//			event.setResponsable(r);
//			
			try {
				
				alerte.setTypeDeclenchAler(TypeDeclenchAler.Minutes);
				alerte.setEvenement(event);
				alerte.setDateAlerte(new Date());
				alerte.setDeclenchAler(3);
				
				Responsable responsable = event.getResponsable();
				
				Set<Alerte> alertes = new HashSet <Alerte>(); 
				
				Set<Responsable> responsables = new HashSet <Responsable>();
				responsables.add(responsable);
				
				alertes.add(alerte);
				responsable.setAlertes(alertes);
				
				event.setResponsable(responsable);
				
				alerte.setResponsables(responsables);
			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//a.create(alerte);
			eimpl.update(event);
			
			// 4 : Persistance Objet/Relationnel : création d'un enregistrement en base
			 //em.persist(alerte);
			
			// 5 : Fermeture transaction 
			try {
				 tx.commit();
			} catch (Exception e) {
				
				e.printStackTrace();
			}

			
			// 6 : Fermeture unité de travail JPA 
			em.close();
			emf.close();	
		}
	}
