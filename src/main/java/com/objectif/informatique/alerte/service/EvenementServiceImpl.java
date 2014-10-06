package com.objectif.informatique.alerte.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.objectif.informatique.alerte.dao.EvenementDAO;
import com.objectif.informatique.alerte.model.EnumPeriodeEvet;
import com.objectif.informatique.alerte.model.Evenement;

@Service("EvenementService")
public class EvenementServiceImpl implements EvenementService {

	public EvenementServiceImpl() {
	}

	@Autowired
	private EvenementDAO evenementDAO;

	@Override
	public Evenement getEvenementById(int evenementId) {
		Evenement evenement = null;
		try {
			evenement =  evenementDAO.findEvenementById(evenementId);
		} catch (Exception e) {
			// il faut logger etc...
			e.printStackTrace();
		}
		return evenement;
	}

	@Override
	public List<Evenement> findAll() throws Exception {
		return evenementDAO.findAll();
	}

	@Override
	public Evenement getEvenementByName(String name){
		try {
			return evenementDAO.findEvenementByName(name);
		} catch (Exception e) {
			e.printStackTrace();
			return null;	
		}		
	}

	@Override
	@Transactional
	public Evenement create(Evenement evenement) {
		return evenementDAO.create(evenement);
	}

	@Override
	public void delete(Evenement eventId) {
		evenementDAO.delete(eventId);	
	}

	@Override
	public void update(Evenement evenement) {
		evenementDAO.update(evenement);		
	}

	@Override
	public List<EnumPeriodeEvet> findListOfPeriod() {
		List<EnumPeriodeEvet> enumPeriodeEvets=  null;
		try {
			enumPeriodeEvets =  evenementDAO.findEnumPeriod();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enumPeriodeEvets;
	}

	@Override
	public List<Evenement> findEvenementsByDateRange(Date start_date,
			Date end_date) throws Exception {
		List<Evenement> evenements =  null;
		try {
			evenements =  evenementDAO.findEvenementsByDateRange(start_date, end_date);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return evenements;
	}
}