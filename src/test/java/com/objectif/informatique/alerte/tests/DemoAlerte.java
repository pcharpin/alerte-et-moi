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
	
			int current_month = 11;
			int start_month;
			int end_month;
			int current_year = 2014;
			int start_year;
			int end_year;
			
			int day = 1;
			
			Calendar calendar = new GregorianCalendar(current_year, current_month, day);
			//Calendar calendar = Calendar.getInstance();
			
			
			
		    Date current_date = calendar.getTime();
		    
		    current_month = calendar.get(Calendar.MONTH);
		    current_year = calendar.get(Calendar.YEAR);
		    
		    if (current_month == 0){
		    	start_month = 11;
		    	start_year = current_year-1;
		    	calendar = new GregorianCalendar(start_year, start_month, 1);
		    } else {
		    	calendar = new GregorianCalendar(current_year, current_month-1, 1);
		    }
	    
 		    Date start_date = calendar.getTime();
		    
		    if (current_month == 11){
		    	end_month = 0;
		    	end_year = current_year + 1;
		    	calendar = new GregorianCalendar(end_year, end_month, MONTH_LENGTH[end_month]);
		    } else
		    	calendar = new GregorianCalendar(current_year, current_month+1, MONTH_LENGTH[current_month+1]);
		    		    
		    Date end_date = calendar.getTime();
		    
		    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String str_from= sdf.format(start_date);
			String str_to= sdf.format(end_date);
			String str_current = sdf.format(current_date);
			
			System.out.println("Now " + str_current + " "+ "From " + str_from + " "+ "To "+ str_to);
		    
		    
		    
			
			// 1 : Ouverture unit� de travail JPA
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
			
			// 4 : Persistance Objet/Relationnel : cr�ation d'un enregistrement en base
			 //em.persist(alerte);
			
			// 5 : Fermeture transaction 
			try {
				 tx.commit();
			} catch (Exception e) {
				
				e.printStackTrace();
			}

			
			// 6 : Fermeture unit� de travail JPA 
			em.close();
			emf.close();	
		}
	}
