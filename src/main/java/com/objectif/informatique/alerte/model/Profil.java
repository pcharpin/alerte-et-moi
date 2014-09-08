/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author vdibi
 *
 */
@Entity
@Table(name="profil")

public class Profil implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2192419740301679757L;
	@Id @GeneratedValue
	@Column(name = "idProf")
	private int idProf;
	@Enumerated(EnumType.STRING)
	private EnumTypeProf enumTypeProf;
	@Column(name="descProf")
	private String descProf;
	//@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
//	@OneToOne
//	@JoinColumn(name="Profil_idProf")
//	private Responsable responsable;	
	
	
	/**
	 * @param idProf
	 * @param enumTypeProf
	 * @param descProf
	 */
	public Profil(){}
	
	public Profil(int idProf, EnumTypeProf enumTypeProf, String descProf
			/*Responsable responsable*/) {
		super();
		this.idProf = idProf;
		this.enumTypeProf = enumTypeProf;
		this.descProf = descProf;
		//this.responsable = responsable;
	}

	/**
	 * @return the idProf
	 */
	public int getIdProf() {
		return idProf;
	}
	/**
	 * @param idProf the idProf to set
	 */
	public void setIdProf(int idProf) {
		this.idProf = idProf;
	}
	/**
	 * @return the enumTypeProf
	 */
	public EnumTypeProf getEnumTypeProf() {
		return enumTypeProf;
	}
	/**
	 * @param enumTypeProf the enumTypeProf to set
	 */
	public void setEnumTypeProf(EnumTypeProf enumTypeProf) {
		this.enumTypeProf = enumTypeProf;
	}
	/**
	 * @return the descProf
	 */
	public String getDescProf() {
		return descProf;
	}
	/**
	 * @param descProf the descProf to set
	 */
	public void setDescProf(String descProf) {
		this.descProf = descProf;
	}

//	/**
//	 * @return the responsable
//	 */
//	public Responsable getResponsable() {
//		return responsable;
//	}
//
//	/**
//	 * @param responsable the responsable to set
//	 */
//	public void setResponsable(Responsable responsable) {
//		this.responsable = responsable;
//	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Profil [idProf=");
		builder.append(idProf);
		builder.append(", enumTypeProf=");
		builder.append(enumTypeProf);
		builder.append(", descProf=");
		builder.append(descProf);
//		builder.append(", responsable=");
//		builder.append(responsable);
		builder.append("]");
		return builder.toString();
	}	
}