/**
 * 
 */
package com.objectif.informatique.alerte.tests;

import java.util.Date;

import org.hibernate.SessionFactory;

import com.objectif.informatique.alerte.model.EnumModeGestionEvt;
import com.objectif.informatique.alerte.model.EnumPeriodeEvet;
import com.objectif.informatique.alerte.service.EvenementServiceImpl;
import com.objectif.informatique.alerte.service.GetSession;
import com.objectif.informatique.alerte.service.HibernateUtils;

/**
 * @author vdibi
 * 
 */
public class TestMappingHibernate {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		// On r�cup�re la session Hibernate cr��e dans HibernateUtil
		//Session session = (Session) utils.getSessionFactory();

		// On cr�� une transaction pour pallier � d'�ventuel probl�mes lors de
		// l'insertion des tuples dans la table
		//Transaction transaction = session.beginTransaction();

		// add Evenement
//		Evenement evenement = new Evenement(id, idDos, responsable_idResp,
//				nomEvt, descEvt, dateEchEvt, exeEvt, mntEvt,
//				enumModeGestionEvt, lienGestEvt, trtEvt, dateTrtEvt,
//				enumPeriodeEvet, actifEvt, recopAutoEvt, recurtEvt, libreEvt);
//		evenementService.create(evenement);
		
    //   evenementService.findByEvenementById(1);
//       System.out.println("o_o:" +evenementService.findByEvenementById(id) );
	//evenementService.listEvenement();	
	//evenementService.selectedAllEvenementByName();
	}

}
