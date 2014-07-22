package com.objectif.informatique.alerte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objectif.informatique.alerte.dao.EnumTypesDossiersDAO;
import com.objectif.informatique.alerte.model.EnumTypesDossiers;

@Service("EnumTypesDossiersService")
public class EnumTypesDossiersServiceImpl implements EnumTypesDossiersService{
		
	public EnumTypesDossiersServiceImpl(){}
	
	@Autowired
	private EnumTypesDossiersDAO enumTypesDossiersDAO;

	@Override
	public List<EnumTypesDossiers> findAll() throws Exception {
		return enumTypesDossiersDAO.findAll();
	}
}
