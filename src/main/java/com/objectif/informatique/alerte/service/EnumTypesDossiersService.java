package com.objectif.informatique.alerte.service;

import java.util.List;

import com.objectif.informatique.alerte.model.EnumTypesDossiers;

public interface EnumTypesDossiersService {

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<EnumTypesDossiers> findAll() throws Exception;
}
