package com.objectif.informatique.alerte.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.objectif.informatique.alerte.model.EnumTypesDossiers;


@Repository("EnumTypesDossiersDAO")
public class EnumTypesDossiersDAOImpl extends GenericDAOImpl<EnumTypesDossiers> implements EnumTypesDossiersDAO{
	
	public EnumTypesDossiersDAOImpl(EntityManager entityManager) {
		super(entityManager);
		entityManager = this.entityManager;
	}
	public EnumTypesDossiersDAOImpl(){}

	@Override
	public List<EnumTypesDossiers> findAll() throws Exception {
		List<EnumTypesDossiers> typesDossiers = new ArrayList<EnumTypesDossiers>();
		Query query = this.entityManager.createQuery("select e from EnumTypesDossiers e");
		typesDossiers = query.getResultList();
	    return typesDossiers;
	}
}