/**
 * 
 */
package com.objectif.informatique.alerte.tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objectif.informatique.alerte.dao.JdbcEvenementDAO;
import com.objectif.informatique.alerte.model.Evenement;

/**
 * @author vdibi
 *
 */
public class TestEvement {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws SQLException{
		ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Module.xml");
		
		//int id, 
//		private int id;
//		private int idDos;
//		private int responsable_idResp = "test";
//		private String nomEvt="test";
//		private String descEvt="test";
//		private Date dateEchEvt = new Date();
//		dateEchEvt.
//		private int exeEvt;
//		private float mntEvt;
//		private enum modeGestionEvt {manuel,enligne};
//		private String lienGestEvt;
//		private boolean tetEvt;
//		private Date dateTrtEvt;
//		private enum periodeEvet {annuel,trimestriel,mensuel};
//		private boolean actifEvt;
//		private boolean recopAutoEvt;
//		private boolean recurtEvt;
//		private String libreEvt;
//	 
			
		JdbcEvenementDAO jdbcEvenementDAO = (JdbcEvenementDAO) context.getBean("evenementDAO");
		Integer evenement = jdbcEvenementDAO.findByEvenementById(1);
		//ArrayList<String> evenement = jdbcEvenementDAO.selectedAllEvenementByName();
		
//		Evenement evenement =  new Evenement(id, idDos, responsable_idResp, nomEvt, descEvt, dateEchEvt, exeEvt, mntEvt, lienGestEvt, tetEvt, dateTrtEvt, actifEvt, recopAutoEvt, recurtEvt, libreEvt)
//		Evenement evenement = jdbcEvenementDAO.create(evenement);
		// System.out.println(evenement);
		
	}

}
