/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author vdibi
 *
 */
@Entity
@Table(name="responsable")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Responsable implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7420598333065416818L;
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
	
	@JsonIgnore
	@OneToMany(mappedBy="responsable")
	private Set<Evenement> evenements;
	
	@ManyToMany(targetEntity=Alerte.class, fetch=FetchType.LAZY)
	@JoinTable(
			name="responsable_alertet",
			joinColumns={@JoinColumn(name="idAler")},
			inverseJoinColumns={@JoinColumn(name="idResp")}
	)
private Set<Alerte> alertes = new HashSet<Alerte>();

	public Responsable(){}
	
	/**
	 * 
	 * @param idResp
	 * @param profil
	 * @param nomResp
	 * @param prenResp
	 * @param emailResp
	 * @param evenements
	 * @param alertes
	 */
	public Responsable(int idResp, int profil, String nomResp, String prenResp,
			String emailResp, Set<Evenement> evenements, Set<Alerte> alertes) {
		super();
		this.idResp = idResp;
		this.profil = profil;
		this.nomResp = nomResp;
		this.prenResp = prenResp;
		this.emailResp = emailResp;
		this.evenements = evenements;
		this.alertes = alertes;
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Responsable [idResp=");
		builder.append(idResp);
		builder.append(", profil=");
		builder.append(profil);
		builder.append(", nomResp=");
		builder.append(nomResp);
		builder.append(", prenResp=");
		builder.append(prenResp);
		builder.append(", emailResp=");
		builder.append(emailResp);
		builder.append(", evenements=");
		builder.append(evenements);
		builder.append(", alertes=");
		builder.append(alertes);
		builder.append("]");
		return builder.toString();
	}
}