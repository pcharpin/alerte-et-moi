/**
 * 
 */
package com.objectif.informatique.alerte.service;

import java.sql.SQLException;
import java.util.ArrayList;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.objectif.informatique.alerte.dao.JdbcEvenementDAO;
import com.objectif.informatique.alerte.model.Evenement;

/**
 * @author vdibi
 *
 */
public class EvenementService implements JdbcEvenementDAO{
	private Session session;
	private HibernateUtils hibernateUtils;
	
	@Override
	public void create(Evenement evenement) throws SQLException {
		//session = hibernateUtils.getSession().
		
	}

	@Override
	public void update(Evenement evenement) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Evenement evenement) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Evenement getEvenementByName(String name) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Evenement findByEvenementById(int evid) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<String> selectedAllEvenementByName() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
