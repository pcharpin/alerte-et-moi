/**
 * 
 */
package com.objectif.informatique.alerte.tests;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.objectif.informatique.alerte.dao.AlerteDAOImpl;
import com.objectif.informatique.alerte.dao.EvenementDAOImpl;
import com.objectif.informatique.alerte.dao.ResponsableDAOImpl;
import com.objectif.informatique.alerte.model.Alerte;
import com.objectif.informatique.alerte.model.Dossier;
import com.objectif.informatique.alerte.model.EnumTypesDossiers;
import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.model.Responsable;
import com.objectif.informatique.alerte.model.TypeDeclenchAler;

/**
 * @author gsoh
 *
 */
public class DemoAlerte {
	
	public static void main(String[] args) {
		
		final int [] MONTH_LENGTH
				= {31,28,31,30,31,30,31,31,30,31,30,31};
			int year = 2014;
			int month = 0;
			int day = 1;
			
			Calendar calendar = new GregorianCalendar(year, month, day);
			//Calendar calendar = Calendar.getInstance();
			
		    Date current_date = calendar.getTime();
		    
		    month = calendar.get(Calendar.MONTH);
		    year = calendar.get(Calendar.YEAR);
		    calendar = new GregorianCalendar(year, month-1, 1);
	    
 		    Date start_date = calendar.getTime();
		    
		    if (month == 11){
		    	month = 0;
		    	year = year + 1;
		    	calendar = new GregorianCalendar(year, month, MONTH_LENGTH[month]);
		    } else
		    	calendar = new GregorianCalendar(year, month+1, MONTH_LENGTH[month+1]);
		    		    
		    Date end_date = calendar.getTime();
		    
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String str_from= sdf.format(start_date);
			String str_to= sdf.format(end_date);
			String str_current = sdf.format(current_date);
			
			System.out.println("Now " + str_current + " "+ "From " + str_from + " "+ "To "+ str_to);
		    
		    
		    
			
			// 1 : Ouverture unité de travail JPA
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("JpaALerte");
			EntityManager em = emf.createEntityManager();
			
			// 2 : Ouverture transaction 
			EntityTransaction tx =  em.getTransaction();
			
			
			EvenementDAOImpl eimpl = new EvenementDAOImpl(em);
			
			
			List<Evenement> events = null;
			
			tx.begin();

			try {
				
				events = eimpl.findEvenementsByDateRange(start_date, end_date);
					if (! events.isEmpty() ) {
						for (Evenement event : events){
							System.out.println("Nom evenement :" + event.getNomEvt());
							
							Date dateEch = event.getDateEchEvt();
						}
					}
				
//					alerte.setTypeDeclenchAler(TypeDeclenchAler.Minutes);
//					alerte.setDateAlerte(new Date());
//					alerte.setDeclenchAler(3);

			} catch (Exception e) {
				e.printStackTrace();
			}
			
			//a.delete(alerte);
			
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
