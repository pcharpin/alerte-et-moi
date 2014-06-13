package com.objectif.informatique.alerte.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public void update(Integer idEvt) throws SQLException;
	public void delete(Integer idEvt) throws SQLException;
	 public String getEvenementByName(String name) throws SQLException;
    public Evenement findByEvenementById(int evid) throws SQLException;
    public  ArrayList<String> selectedAllEvenementByName() throws SQLException;   
    public List<Evenement> listEvenement() throws SQLException; 

}