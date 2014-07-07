package com.objectif.informatique.alerte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objectif.informatique.alerte.dao.ProfilDAO;
import com.objectif.informatique.alerte.model.Profil;

@Service("ProfilService")
public class ProfilServiceImpl implements ProfilService{

	@Autowired
	private ProfilDAO profilDAO;
	
	public ProfilServiceImpl(){}

	@Override
	public Profil getProfilById(int profilId) {
		try {
			return profilDAO.findProfilById(profilId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Profil> findAll() throws Exception {
		return profilDAO.findAll();
	}
		
	
}
