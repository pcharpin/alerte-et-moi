/**
 * 
 */
package com.objectif.informatique.alerte.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.persistence.criteria.CriteriaBuilder.In;
import javax.sql.DataSource;

import com.mysql.jdbc.Connection;
import com.objectif.informatique.alerte.dao.JdbcEvenementDAO;
import com.objectif.informatique.alerte.model.Evenement;

/**
 * @author vdibi
 *
 */
public class EvenementDAO implements JdbcEvenementDAO{
	
	private DataSource dataSource;
	Connection conn = null;
	PreparedStatement pStatement;
	
	//static final Logger logger = Logger.getLogger(EvenementDAO.class);
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	  

	@Override
	public Integer create(Evenement evenement) throws SQLException {
		return null;
		
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
	public Integer findByEvenementById(int evid) throws SQLException {
		String sql = "SELECT * FROM evenement WHERE idEvt = ?";	
		int idEvet = 0;
		 
			conn = (Connection) dataSource.getConnection();
			pStatement = conn.prepareStatement(sql);
			pStatement.setInt(1, evid);
			Evenement evenement = null;
			ResultSet rs = pStatement.executeQuery();
			
			
			 while (rs.next()) {
				
				idEvet = rs.getInt("idEvt");
				 break;
//				logger.info(" conn :" +evenement.getId());
//				logger.info(" conn :" +evenement.getNomEvt());
		
			}
			rs.close();
			pStatement.close();
			conn.close();
			return idEvet;
		
	}

	@Override
	public ArrayList<String> selectedAllEvenementByName() throws SQLException {
String query = " SELECT nomEvt FROM evenement ";  
		
        ArrayList<String> arrList = new ArrayList<String>(); 
        
        try {
			conn = (Connection) dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {   	
                String allusers = rs.getString("nomEvt");
                arrList.add(allusers);
                
               System.out.println("arrList : " + arrList);		
               System.out.println("arrList : " + arrList.size());		
//                logger.info(" **arrList*** :" + arrList);
//                logger.info(" **arrList **:" + arrList.size());
            }
			rs.close();
			ps.close();
			return arrList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
				conn.close();
				} catch (SQLException e) {}
			}
		}

	}
}