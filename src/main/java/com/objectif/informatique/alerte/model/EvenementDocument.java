/**
 * 
 */
package com.objectif.informatique.alerte.model;

/**
 * @author vdibi
 *
 */
public class EvenementDocument {

	private int idDoc;
	private int dEvt;
	
	public EvenementDocument(int idDoc, int dEvt) {
		super();
		this.idDoc = idDoc;
		this.dEvt = dEvt;
	}

	public int getIdDoc() {
		return idDoc;
	}

	public void setIdDoc(int idDoc) {
		this.idDoc = idDoc;
	}

	public int getdEvt() {
		return dEvt;
	}

	public void setdEvt(int dEvt) {
		this.dEvt = dEvt;
	}	
}
