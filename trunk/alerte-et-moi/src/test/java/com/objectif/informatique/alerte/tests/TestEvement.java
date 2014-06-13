/**
 * 
 */
package com.objectif.informatique.alerte.tests;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.objectif.informatique.alerte.dao.EvenementDAO;
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
			
		EvenementDAO jdbcEvenementDAO = (EvenementDAO) context.getBean("evenementDAO");
		//Integer evenement = jdbcEvenementDAO.findByEvenementById(1);
		//ArrayList<String> evenement = jdbcEvenementDAO.selectedAllEvenementByName();
		
//		Evenement evenement =  new Evenement(id, idDos, responsable_idResp, nomEvt, descEvt, dateEchEvt, exeEvt, mntEvt, lienGestEvt, tetEvt, dateTrtEvt, actifEvt, recopAutoEvt, recurtEvt, libreEvt)
//		Evenement evenement = jdbcEvenementDAO.create(evenement);
		EvenementServiceImpl evenementServiceImpl = new EvenementServiceImpl();
		Evenement evenement = new Evenement();
		evenement.setNomEvt("TOTO");
		evenementServiceImpl.create(evenement);
		System.out.println("evenement");
		
	}

}
