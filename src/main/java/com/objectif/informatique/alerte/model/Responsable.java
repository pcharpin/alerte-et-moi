/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author vdibi
 *
 */
@Entity
@Table(name="responsable")
public class Responsable implements Serializable{
	
	@Id @GeneratedValue
	private int idResp;
	@Column(name="Profil_idProf")
	private int profil;
	@Column(name="nomResp")
	private String nomResp;
	@Column(name="prenResp")
	private String prenResp;
	@Column(name="emailResp")
	private String emailResp;
	@OneToMany(mappedBy="responsable")
	private Set<Evenement> evenements;
	
	
	/**
	 * @param idResp
	 * @param profil
	 * @param nomResp
	 * @param prenResp
	 * @param emailResp
	 * @param evenements
	 */
	public Responsable(){}
	
	public Responsable(int idResp, int profil, String nomResp,
			String prenResp, String emailResp, Set<Evenement> evenements) {
		super();
		this.idResp = idResp;
		this.profil = profil;
		this.nomResp = nomResp;
		this.prenResp = prenResp;
		this.emailResp = emailResp;
		this.evenements = evenements;
	}
	
	
	public Responsable(int profil, String nomResp,
			String prenResp, String emailResp, Set<Evenement> evenements) {
		super();
		this.profil = profil;
		this.nomResp = nomResp;
		this.prenResp = prenResp;
		this.emailResp = emailResp;
		this.evenements = evenements;
	}
	
	/**
	 * @return the idResp
	 */
	public int getIdResp() {
		return idResp;
	}
	/**
	 * @param idResp the idResp to set
	 */
	public void setIdResp(int idResp) {
		this.idResp = idResp;
	}
		/**
	 * @return the profil
	 */
	public int getProfil() {
		return profil;
	}
	/**
	 * @param profil the profil to set
	 */
	public void setProfil(int profil) {
		this.profil = profil;
	}
		/**
	 * @return the nomResp
	 */
	public String getNomResp() {
		return nomResp;
	}
	/**
	 * @param nomResp the nomResp to set
	 */
	public void setNomResp(String nomResp) {
		this.nomResp = nomResp;
	}
	/**
	 * @return the prenResp
	 */
	public String getPrenResp() {
		return prenResp;
	}
	/**
	 * @param prenResp the prenResp to set
	 */
	public void setPrenResp(String prenResp) {
		this.prenResp = prenResp;
	}
	/**
	 * @return the emailResp
	 */
	public String getEmailResp() {
		return emailResp;
	}
	/**
	 * @param emailResp the emailResp to set
	 */
	public void setEmailResp(String emailResp) {
		this.emailResp = emailResp;
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
}
