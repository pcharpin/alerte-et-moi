/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.util.Set;

/**
 * @author vdibi
 *
 */
public class Responsable {
	
	private int idResp;
	private int idProfil;
	private String nomResp;
	private String prenResp;
	private String emailResp;
	private Set<Evenement> evenements;
	/**
	 * @param idResp
	 * @param idProfil
	 * @param nomResp
	 * @param prenResp
	 * @param emailResp
	 * @param responsables
	 */
	public Responsable(int idResp, int idProfil, String nomResp,
			String prenResp, String emailResp, Set<Evenement> evenements) {
		super();
		this.idResp = idResp;
		this.idProfil = idProfil;
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
	 * @return the idProfil
	 */
	public int getIdProfil() {
		return idProfil;
	}
	/**
	 * @param idProfil the idProfil to set
	 */
	public void setIdProfil(int idProfil) {
		this.idProfil = idProfil;
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
