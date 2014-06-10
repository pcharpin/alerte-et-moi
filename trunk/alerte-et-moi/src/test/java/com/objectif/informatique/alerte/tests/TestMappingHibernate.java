/**
 * 
 */
package com.objectif.informatique.alerte.tests;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.objectif.informatique.alerte.model.EnumModeGestionEvt;
import com.objectif.informatique.alerte.model.EnumPeriodeEvet;
import com.objectif.informatique.alerte.model.Evenement;
import com.objectif.informatique.alerte.service.HibernateUtils;

/**
 * @author vdibi
 *
 */
public class TestMappingHibernate {
	static int id = 1;
	static int idDos = 2; 
	static int responsable_idResp=1; 
	static String nomEvt ="test";			
	static String descEvt ="test"; 
	
	static Date dateEchEvt = new Date();		
	static int exeEvt=1; 
	static float mntEvt=(float) 0.0;
	static EnumModeGestionEvt enumModeGestionEvt = EnumModeGestionEvt.ENLIGNE;
	static String lienGestEvt ="test";
	static int trtEvt=0; 
	static Date dateTrtEvt=new Date(); 
	static EnumPeriodeEvet enumPeriodeEvet = EnumPeriodeEvet.TRIMESTRIEL;
	static int actifEvt = 0 ;
	static int recopAutoEvt =1 ;
	static int recurtEvt = 1;
	static String libreEvt ="test";

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		
		Session s = HibernateUtils.getSession();
		
		try {
			Transaction tx = (Transaction) s.beginTransaction();
			
			Evenement evenement = new Evenement(id, idDos, responsable_idResp, nomEvt, descEvt, dateEchEvt, 
					exeEvt, mntEvt, enumModeGestionEvt, lienGestEvt, trtEvt, dateTrtEvt, enumPeriodeEvet, actifEvt, recopAutoEvt, recurtEvt, libreEvt);
						
			s.save(evenement);
			tx.commit();
			s.close();
		} catch (Exception e) {
			
		}
			
		
	}

}
