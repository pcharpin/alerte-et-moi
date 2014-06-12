/**
 * 
 */
package com.objectif.informatique.alerte.tests;

import java.util.Date;

import javax.ws.rs.GET;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.objectif.informatique.alerte.dao.JdbcEvenementDAO;
import com.objectif.informatique.alerte.model.EnumModeGestionEvt;
import com.objectif.informatique.alerte.model.EnumPeriodeEvet;
import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.service.EvenementService;
import com.objectif.informatique.alerte.service.GetSession;
import com.objectif.informatique.alerte.service.HibernateUtils;

/**
 * @author vdibi
 * 
 */
public class TestMappingHibernate {
	static int id = 1;
	static int idDos = 2;
	static int responsable_idResp = 1;
	static String nomEvt = "test";
	static String descEvt = "test";

	static Date dateEchEvt = new Date();
	static int exeEvt = 1;
	static float mntEvt = (float) 0.0;
	static EnumModeGestionEvt enumModeGestionEvt = EnumModeGestionEvt.ENLIGNE;
	static String lienGestEvt = "test";
	static int trtEvt = 0;
	static Date dateTrtEvt = new Date();
	static EnumPeriodeEvet enumPeriodeEvet = EnumPeriodeEvet.TRIMESTRIEL;
	static int actifEvt = 0;
	static int recopAutoEvt = 1;
	static int recurtEvt = 1;
	static String libreEvt = "test";
	static EvenementService evenementService = new EvenementService();
	private static SessionFactory factory;
	private static GetSession getSession;
	private static HibernateUtils utils;

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {

		// On récupère la session Hibernate créée dans HibernateUtil
		//Session session = (Session) utils.getSessionFactory();

		// On créé une transaction pour pallier à d'éventuel problèmes lors de
		// l'insertion des tuples dans la table
		//Transaction transaction = session.beginTransaction();

		// add Evenement
//		Evenement evenement = new Evenement(id, idDos, responsable_idResp,
//				nomEvt, descEvt, dateEchEvt, exeEvt, mntEvt,
//				enumModeGestionEvt, lienGestEvt, trtEvt, dateTrtEvt,
//				enumPeriodeEvet, actifEvt, recopAutoEvt, recurtEvt, libreEvt);
//		evenementService.create(evenement);
		
       evenementService.findByEvenementById(1);
//       System.out.println("o_o:" +evenementService.findByEvenementById(id) );
	//evenementService.listEvenement();	
	//evenementService.selectedAllEvenementByName();
	}

}
