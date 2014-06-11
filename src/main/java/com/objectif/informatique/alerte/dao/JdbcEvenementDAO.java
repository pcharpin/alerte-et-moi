package com.objectif.informatique.alerte.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.objectif.informatique.alerte.model.Evenement;

/**
 * 
 */


/**
 * @author vdibi
 *
 */
public interface JdbcEvenementDAO {
	public Integer create(Evenement evenement) throws SQLException;
	public void update(Evenement evenement) throws SQLException;
	public void delete(Evenement evenement) throws SQLException;
	 public Evenement getEvenementByName(String name) throws SQLException;
    public Integer findByEvenementById(int evid) throws SQLException;
    public  ArrayList<String> selectedAllEvenementByName() throws SQLException;   

}
