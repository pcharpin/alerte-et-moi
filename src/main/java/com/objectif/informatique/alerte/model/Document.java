/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.util.HashSet;
import java.util.Set;

/**
 * @author vdibi
 *
 */
public class Document {

	private int idDoc;
	private String accesDoc;
	private String lienDoc;
	private Set<Evenement> evenements = new HashSet<Evenement>(0);
	
	public Document(int idDoc, String accesDoc, String lienDoc) {
		super();
		this.idDoc = idDoc;
		this.accesDoc = accesDoc;
		this.lienDoc = lienDoc;
	}

	public int getIdDoc() {
		return idDoc;
	}

	public void setIdDoc(int idDoc) {
		this.idDoc = idDoc;
	}

	public String getAccesDoc() {
		return accesDoc;
	}

	public void setAccesDoc(String accesDoc) {
		this.accesDoc = accesDoc;
	}

	public String getLienDoc() {
		return lienDoc;
	}

	public void setLienDoc(String lienDoc) {
		this.lienDoc = lienDoc;
	}
}
