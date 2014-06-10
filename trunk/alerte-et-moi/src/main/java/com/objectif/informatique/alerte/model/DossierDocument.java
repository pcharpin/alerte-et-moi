/**
 * 
 */
package com.objectif.informatique.alerte.model;

/**
 * @author vdibi
 *
 */
public class DossierDocument {
	private int dossierId;
	private int DocumentId;
	
	public DossierDocument(int dossierId, int documentId) {
		super();
		this.dossierId = dossierId;
		DocumentId = documentId;
	}

	public int getDossierId() {
		return dossierId;
	}

	public void setDossierId(int dossierId) {
		this.dossierId = dossierId;
	}

	public int getDocumentId() {
		return DocumentId;
	}

	public void setDocumentId(int documentId) {
		DocumentId = documentId;
	}
}
