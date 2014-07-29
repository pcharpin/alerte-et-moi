package com.objectif.informatique.alerte.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.objectif.informatique.alerte.dao.DossierDAO;
import com.objectif.informatique.alerte.model.Dossier;

@Service("DossierService")
public class DossierServiceImpl implements DossierService{
		
	public DossierServiceImpl(){}
	
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Autowired
	private DossierDAO dossierDAO;

	@Override
	public Dossier getDossierById(int dossierId) {
		try {
			return dossierDAO.findFolderById(dossierId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Dossier> findAll() throws Exception {
		return dossierDAO.findAll();
	}

	@Override
	@Transactional
	public Dossier create(Dossier dossier) {
		return dossierDAO.create(dossier);
	}

	@Override
	public void delete(Dossier dossierId) {
		dossierDAO.delete(dossierId);		
	}

	@Override
	public void update(Dossier dossier) {
		dossierDAO.update(dossier);		
	}

	@Override
	public Dossier getFolderByName(String name) {
		return dossierDAO.getFolderByName(name);
	}
}