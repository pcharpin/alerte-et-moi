/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author vdibi
 *
 */
@Entity
@Table(name="alerte")
public class Alerte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6204215592716227088L;
	@Id @GeneratedValue
	@Column(name = "idAler")
	private int idAler;
	@Column(name = "idEvt")
	private int idEvt;
	@Enumerated(EnumType.STRING)
	private EnumConstante enumConstante;
	@Column(name="dateAlerte")
	private Date dateAlerte;

	@ManyToOne(cascade = CascadeType.ALL)
	private Evenement evenement;
	
	@ManyToMany(targetEntity=Alerte.class,
			cascade={CascadeType.PERSIST, CascadeType.MERGE}
	)
		@JoinTable(
				name="responsable_alerte",
				joinColumns=@JoinColumn(name="idAler"),
				inverseJoinColumns=@JoinColumn(name="idResp")
		)
	private Set<Responsable> responsables = new HashSet<Responsable>();

	

	/**
	 * @param idAler
	 * @param idEvt
	 * @param enumConstante
	 * @param dateAlerte
	 * @param evenement
	 * @param responsables
	 */
	public Alerte(int idAler, int idEvt, EnumConstante enumConstante,
			Date dateAlerte, Evenement evenement, Set<Responsable> responsables) {
		super();
		this.idAler = idAler;
		this.idEvt = idEvt;
		this.enumConstante = enumConstante;
		this.dateAlerte = dateAlerte;
		this.evenement = evenement;
		this.responsables = responsables;
	}

	/**
	 * @return the idAler
	 */
	public int getIdAler() {
		return idAler;
	}

	/**
	 * @param idAler the idAler to set
	 */
	public void setIdAler(int idAler) {
		this.idAler = idAler;
	}

	/**
	 * @return the idEvt
	 */
	public int getIdEvt() {
		return idEvt;
	}

	/**
	 * @param idEvt the idEvt to set
	 */
	public void setIdEvt(int idEvt) {
		this.idEvt = idEvt;
	}

	/**
	 * @return the enumConstante
	 */
	public EnumConstante getEnumConstante() {
		return enumConstante;
	}

	/**
	 * @param enumConstante the enumConstante to set
	 */
	public void setEnumConstante(EnumConstante enumConstante) {
		this.enumConstante = enumConstante;
	}

	/**
	 * @return the dateAlerte
	 */
	public Date getDateAlerte() {
		return dateAlerte;
	}

	/**
	 * @param dateAlerte the dateAlerte to set
	 */
	public void setDateAlerte(Date dateAlerte) {
		this.dateAlerte = dateAlerte;
	}

	/**
	 * @return the evenement
	 */
	public Evenement getEvenement() {
		return evenement;
	}

	/**
	 * @param evenement the evenement to set
	 */
	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}

	/**
	 * @return the responsables
	 */
	public Set<Responsable> getResponsables() {
		return responsables;
	}

	/**
	 * @param responsables the responsables to set
	 */
	public void setResponsables(Set<Responsable> responsables) {
		this.responsables = responsables;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Alerte [idAler=");
		builder.append(idAler);
		builder.append(", idEvt=");
		builder.append(idEvt);
		builder.append(", enumConstante=");
		builder.append(enumConstante);
		builder.append(", dateAlerte=");
		builder.append(dateAlerte);
		builder.append(", evenement=");
		builder.append(evenement);
		builder.append(", responsables=");
		builder.append(responsables);
		builder.append("]");
		return builder.toString();
	}

	
}
