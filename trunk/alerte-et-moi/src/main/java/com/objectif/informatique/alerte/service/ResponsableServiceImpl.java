package com.objectif.informatique.alerte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objectif.informatique.alerte.dao.ResponsableDAO;
import com.objectif.informatique.alerte.model.Responsable;

@Service("ResponsableService")
public class ResponsableServiceImpl implements ResponsableService{
	

	public ResponsableServiceImpl() {
	}
	@Autowired
	private ResponsableDAO responsableDAO;


	@Override
	public Responsable getResponsableById(int responsableId) {
		try {
			return responsableDAO.findResponsableById(responsableId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public List<Responsable> findAll() throws Exception {
		return responsableDAO.findAll();
	}

	@Override
	public Responsable getResponsableByName(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Responsable create(Responsable responsable) {
		return responsableDAO.create(responsable);
	}

	@Override
	public void delete(Class<Responsable> class1, int id) {
		responsableDAO.delete(id);	
	}
}
