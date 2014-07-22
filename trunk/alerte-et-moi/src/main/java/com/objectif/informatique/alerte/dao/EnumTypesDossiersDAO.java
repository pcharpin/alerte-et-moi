package com.objectif.informatique.alerte.dao;

import java.util.List;

import com.objectif.informatique.alerte.model.EnumTypesDossiers;

public interface EnumTypesDossiersDAO extends GenericDAO<EnumTypesDossiers>{
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<EnumTypesDossiers> findAll() throws Exception;
}
