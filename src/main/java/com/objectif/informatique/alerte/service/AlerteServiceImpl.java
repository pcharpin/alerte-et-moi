package com.objectif.informatique.alerte.service;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objectif.informatique.alerte.dao.AlerteDAO;
import com.objectif.informatique.alerte.model.Alerte;

@Service("AlerteService")
public class AlerteServiceImpl implements AlerteService{
		
	public AlerteServiceImpl(){}
	
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	
	@Autowired
	private AlerteDAO alerteDAO;

	@Override
	public Alerte create(Alerte alerte) {
		
		return alerteDAO.create(alerte);
	}

	@Override
	public void update(Alerte alerte) {
		
		alerteDAO.update(alerte);
	}

	@Override
	public void delete(Alerte alerte) {
		
		alerteDAO.delete(alerte);		
	}

	@Override
	public List<Alerte> findAll() throws Exception {
		
		return alerteDAO.findAll();
	}

	@Override
	public Alerte findAlerteById(int alertId) {
		try {
			return alerteDAO.findAlerteById(alertId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	
}