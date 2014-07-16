package com.objectif.informatique.alerte.dao;

import java.util.List;

import com.objectif.informatique.alerte.model.Document;

public interface DocumentDAO extends GenericDAO<Document>{
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Document> findAll() throws Exception;
	/**
	 * 
	 * @param folderId
	 * @return
	 * @throws Exception
	 */
	Document findDocumentById(int docId) throws Exception;
}
