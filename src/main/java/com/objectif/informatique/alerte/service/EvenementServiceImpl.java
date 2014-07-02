package com.objectif.informatique.alerte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objectif.informatique.alerte.dao.EvenementDAO;
import com.objectif.informatique.alerte.model.Evenement;

@Service("EvenementService")
public class EvenementServiceImpl implements EvenementService {

	public EvenementServiceImpl() {
	}

	@Autowired
	private EvenementDAO evenementDAO;

	@Override
	public Evenement getEvenementById(int evenementId) {
		try {
			return evenementDAO.findEvenementById(evenementId);
		} catch (Exception e) {
			// il faut logger etc...
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Evenement> findAll() throws Exception {
		return evenementDAO.findAll();
	}

	@Override
	public Evenement getEvenementByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evenement create(Evenement evenement) {
		return evenementDAO.create(evenement);
	}

	@Override
	public void delete(Class<Evenement> class1, int id) {
		evenementDAO.delete(id);	
	}
}