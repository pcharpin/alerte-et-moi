package com.objectif.informatique.alerte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objectif.informatique.alerte.dao.DossierDAO;
import com.objectif.informatique.alerte.model.Dossier;

@Service("DossierService")
public class DossierServiceImpl implements DossierService{
		
	public DossierServiceImpl(){}
	
	@Autowired
	private DossierDAO dossierDAO;

	@Override
	public Dossier getDossierById(int dossierId) {
		try {
			return dossierDAO.findFolderById(dossierId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Dossier> findAll() throws Exception {
		return dossierDAO.findAll();
	}

	@Override
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
}
