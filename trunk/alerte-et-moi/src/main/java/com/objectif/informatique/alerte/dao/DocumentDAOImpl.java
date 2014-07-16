package com.objectif.informatique.alerte.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.objectif.informatique.alerte.model.Document;


@Repository("DocumentDAO")
public class DocumentDAOImpl extends GenericDAOImpl<Document> implements DocumentDAO{

	public DocumentDAOImpl(EntityManager entityManager) {
		super(entityManager);
		entityManager = this.entityManager;
	}
	public DocumentDAOImpl(){}
	
	@Override
	public List<Document> findAll() throws Exception {
		List<Document> documents = new ArrayList<Document>();
		Query query = this.entityManager.createQuery("select d from Document d");
		documents = query.getResultList();
	    return documents;
	}

	@Override
	public Document findDocumentById(int docId) throws Exception {
		Document documents = null;
		try {
			documents = entityManager.find(Document.class, docId); 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return documents;
	}
}