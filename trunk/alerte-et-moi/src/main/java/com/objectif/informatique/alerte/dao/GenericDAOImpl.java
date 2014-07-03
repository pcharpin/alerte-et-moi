package com.objectif.informatique.alerte.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class GenericDAOImpl<TYPE> implements GenericDAO<TYPE> {
	
	@PersistenceContext(unitName="JpaALerte")
	public EntityManager entityManager;
	private Class<TYPE> type;
	
	public GenericDAOImpl(EntityManager entityManager) {
        this.entityManager= entityManager;
    }
	
	public GenericDAOImpl(){}
	
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public TYPE create(final TYPE object) {
		this.entityManager.persist(object);
		return object;
	}

	@Override
	public TYPE update(final TYPE object) {
		return this.entityManager.merge(object);
	}

	@Override
	public TYPE find(final Object id) {
		return this.entityManager.find(type, id);
	}

	@Override
	public void delete(final Object id) {
		this.entityManager.remove(this.entityManager.getReference(type, id));	
	}
}