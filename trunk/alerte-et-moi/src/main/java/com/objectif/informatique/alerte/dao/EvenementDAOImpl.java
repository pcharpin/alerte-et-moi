/**
 * 
 */
package com.objectif.informatique.alerte.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.objectif.informatique.alerte.model.EnumPeriodeEvet;
import com.objectif.informatique.alerte.model.EnumTypesDossiers;
import com.objectif.informatique.alerte.model.Evenement;

/**
 * @author vdibi
 *
 */

@Repository("EvenementDAO")
public class EvenementDAOImpl extends GenericDAOImpl<Evenement> implements EvenementDAO{
	
//	@PersistenceContext(unitName="JpaALerte")
//	private EntityManager entityManager;
//	private SessionFactory sessionFactory;
	
	public EvenementDAOImpl(EntityManager entityManager) {
		super(entityManager);
		entityManager = this.entityManager;
	}
	public EvenementDAOImpl(){}
	
	@Override
	public List<Evenement> findAll() throws Exception {
		List<Evenement> evenements = new ArrayList<Evenement>();
		try {
			Query query = this.entityManager.createQuery("select e from Evenement e");
		    evenements = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return evenements;
	}

	@Override
	public Evenement findEvenementById(int evenementId) throws Exception {
		Evenement e = entityManager.find(Evenement.class, evenementId);
		return e;
	}
	
	@Override
	public Evenement findEvenementByName(String name) throws Exception {
		Evenement e = entityManager.find(Evenement.class, name); 
		return e;
	}
	
	@Override
	public List<EnumPeriodeEvet> findEnumPeriod() throws Exception {
		List<EnumPeriodeEvet> ListOfPeriode = new ArrayList<EnumPeriodeEvet>();
		try {
			Query query = this.entityManager.createQuery("select enumPeriodeEvet from Evenement e");
			ListOfPeriode = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	    return ListOfPeriode;
	}
	
	@Override
	public List<Evenement> findEvenementsByDateRange(Date start_date,
			Date end_date) throws Exception {
		List<Evenement> evenements = new ArrayList<Evenement>();
		
		try {
			Query query = this.entityManager.createQuery("select e from Evenement e where e.dateEchEvt between :start_date and :end_date")
						  .setParameter("start_date", start_date)
						  .setParameter("end_date", end_date);
			evenements = query.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return evenements;
	}
	
	@Override
	public List<Evenement> findEvenementsByPartialName(String srchKeyWord) throws Exception {
		List<Evenement> evenements = new ArrayList<Evenement>();
		try{
			Query query = this.entityManager.createQuery("select e from Evenement e where e.nomEvt like :srchKeyWord")
					      .setParameter("srchKeyWord", '%'+srchKeyWord+'%');
			evenements = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return evenements;
	}
	
	@Override
	public List<Evenement> findEvenementsByRespName(String respname)
			throws Exception {
		List<Evenement> evenements = new ArrayList<Evenement>();
		try{
			Query query = this.entityManager.createQuery("select e from Evenement e where e.responsable.nomResp like :respname")
					      .setParameter("respname", respname);
			evenements = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return evenements;
	}
	
	@Override
	public List<Evenement> findEvenementsByStatus(int status) throws Exception {
		List<Evenement> evenements = new ArrayList<Evenement>();
		try{
			Query query = this.entityManager.createQuery("select e from Evenement e where e.trtEvt =:status")
					      .setParameter("status", status);
			evenements = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return evenements;
	}
	
	@Override
	public List<Evenement> findEvenementsByTypeDos(String typedos)
			throws Exception {
		List<Evenement> evenements = new ArrayList<Evenement>();
		try{
			Query query = this.entityManager.createQuery("select e from Evenement e where e.dossier.enumTypesDossiers like :typedos")
					      .setParameter("typedos", EnumTypesDossiers.valueOf(typedos));
			evenements = query.getResultList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return evenements;
	}
}