/**
 * 
 */
package com.objectif.informatique.alerte.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.objectif.informatique.alerte.model.Evenement;

/**
 * @author vdibi
 *
 */

@Repository("EvenementDAO")
public class EvenementDAOImpl implements EvenementDAO{
//	@PersistenceContext 
	private EntityManager entityManager;
	
	public EvenementDAOImpl(EntityManager entityManager) {
        this.entityManager= entityManager;
    }
//	
	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	/**
	 * @param entityManager the entityManager to set
	 */
//	@Autowired
//	public void setEntityManager(EntityManager entityManager) {
//		this.entityManager = entityManager;
//	}

	@Override
	public Integer create(Evenement evenement) throws Exception {
try {
			
			entityManager.persist(evenement);
			return evenement.getIdEvt();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public Evenement update(Evenement evenement) throws Exception {
		Evenement updatedEvenement = new Evenement();
		try {
			//updatedEvenement = entityManager.merge(evenement);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return updatedEvenement;		
	}

	@Override
	public void delete(Evenement evenement) throws Exception {
		try {
		//	entityManager.remove(evenement);
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e);
		}
		
	}

	@Override
	public String getEvenementByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evenement findEvenementById(Long evenementId) {
		try {
		//	Evenement e = entityManager.find(Evenement.class, evenementId); 
		//	return e;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Evenement> findAll() throws Exception {
		List<Evenement> evenements = new ArrayList<Evenement>();
		ArrayList<Integer> listId = new ArrayList<Integer>();
	    //Query query = entityManager.createQuery("select e.idEvt,e.idDos, e.nomEvt, e.descEvt, e.dateEchEvt,e.exeEvt, e.mntEvt,e.modeGestionEvt,e.lienGestEvt,e.trtEvt,e.dateTrtEvt,e.enumPeriodeEvet,e.actifEvt,e.recopAutoEvt,e.recurtEvt,e.libreEvt from Evenement e");
	    Query query = entityManager.createQuery("select e from Evenement e");
	    evenements = query.getResultList();
	    //System.out.println("Résultat = " +listId);
	    /*for(int i=0;i<listId.size();i++){
	    	evenements.add(entityManager.find(Evenement.class, listId.get(i)));
	    }*/
	    //System.out.println("Résultat de la liste ... = " +evenements);

	    return evenements;
	}

}
