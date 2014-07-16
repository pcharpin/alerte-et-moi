package com.objectif.informatique.alerte.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.objectif.informatique.alerte.dao.DocumentDAO;
import com.objectif.informatique.alerte.model.Document;

@Service("DocumentService")
public class DocumentServiceImpl implements DocumentService{
		
	public DocumentServiceImpl(){}
	
	@Autowired
	private DocumentDAO documentDAO;

	@Override
	public Document getDocumentById(int docId) {
		try {
			return documentDAO.findDocumentById(docId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Document> findAll() throws Exception {
		try {
			return documentDAO.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		
	}

	@Override
	public Document create(Document document) {
		return documentDAO.create(document);
	}

	@Override
	public void delete(Document docId) {
		documentDAO.delete(docId);			
	}

	@Override
	public void update(Document document) {
		documentDAO.update(document);		
	}
}