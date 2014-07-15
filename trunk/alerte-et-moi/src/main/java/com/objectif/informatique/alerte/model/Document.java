/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

/**
 * @author vdibi
 * @author P0P0T3
 *
 */
@Entity
public class Document implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3628579886622046928L;

	@Id @GeneratedValue
	@Column(name = "idDoc")
	private int idDoc;
	
	@Column(name = "accesDoc")
	private String accesDoc;
	
	@Column(name = "lienDoc")
	private String lienDoc;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="evenement_document",
			joinColumns={@JoinColumn(name="Document_idDoc")},
			inverseJoinColumns={@JoinColumn(name="Evenement_idEvt")}
	)
	private Set<Evenement> evenements;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(
			name="dossier_document",
			joinColumns={@JoinColumn(name="Dossier_idDos")},
			inverseJoinColumns={@JoinColumn(name="Document_idDoc")}
	)
	private Set<Dossier> dossiers;
	
	public Document(){}
	
	public Document(int idDoc, String accesDoc, String lienDoc,
			Set<Evenement> evenements, Set<Dossier> dossiers) {
		super();
		this.idDoc = idDoc;
		this.accesDoc = accesDoc;
		this.lienDoc = lienDoc;
		this.evenements = evenements;
		this.dossiers = dossiers;
	}

	public Document(String accesDoc, String lienDoc) {
		super();
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

	/**
	 * @return the evenements
	 */
	public Set<Evenement> getEvenements() {
		return evenements;
	}
	
	/**
	 * @param evenements the evenements to set
	 */
	public void setEvenements(Set<Evenement> evenements) {
		this.evenements = evenements;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Document [idDoc=");
		builder.append(idDoc);
		builder.append(", accesDoc=");
		builder.append(accesDoc);
		builder.append(", lienDoc=");
		builder.append(lienDoc);
		builder.append(", evenements=");
		builder.append(evenements);
		builder.append(", dossiers=");
		builder.append(dossiers);
		builder.append("]");
		return builder.toString();
	}
}