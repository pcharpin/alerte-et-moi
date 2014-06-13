/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
public class Responsable {
	
	@Id @GeneratedValue
	private int idResp;
	//private int idProfil;
	private Profil profil;
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
	public Responsable(int idResp, Profil profil, String nomResp,
			String prenResp, String emailResp, Set<Evenement> evenements) {
		super();
		this.idResp = idResp;
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
	public Profil getProfil() {
		return profil;
	}
	/**
	 * @param profil the profil to set
	 */
	public void setProfil(Profil profil) {
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
