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
		try {
			this.entityManager.persist(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;
	}

	@Override
	public TYPE update(final TYPE object) {
		try {
			return this.entityManager.merge(object);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return object;		
	}

	@Override
	public TYPE find(final Object id) {
		return this.entityManager.find(type, id);
	}

	@Override
	public void delete(TYPE object ) {
		//Object ob = this.entityManager.find(type, id);
		this.entityManager.remove(object);
	}
}