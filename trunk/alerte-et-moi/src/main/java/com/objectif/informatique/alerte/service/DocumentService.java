package com.objectif.informatique.alerte.service;

import java.util.List;

import com.objectif.informatique.alerte.model.Document;

public interface DocumentService {
	/**
	 * 
	 * @param dossierId
	 * @return
	 */
	public Document getDocumentById(int docId);
	/**
	 * 
	 * @return
	 * @throws Exception
	 */
	List<Document> findAll() throws Exception;
	/**
	 * 
	 * @param dossier
	 * @return
	 */
	public Document create(Document document);
	/**
	 * 
	 * @param class1
	 * @param id
	 */
	public void delete(Document docId);
	/**
	 * 
	 * @param dossier
	 */
	public void update(Document document);
}
