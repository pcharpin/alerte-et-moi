/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author vdibi
 * @author P0P0T3 ;)
 */
@Entity
@Table(name="dossier")
public class Dossier implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3160355415787038352L;

	@Id @GeneratedValue
	@Column(name = "idDos")
	private int idDos;
	
	@Column(name = "nomDos")
	private String nomDos;

	@Column(name = "typesDossiers")
	@Enumerated(EnumType.STRING) 
	private EnumTypesDossiers enumTypesDossiers;
	@Column(name = "descDoc")
	private String descDoc;
	
	@OneToMany(mappedBy = "dossier", cascade = CascadeType.ALL)	
	@Column(name = "evtDos")
	private List<Evenement> evenements;
	
	@Column(name = "priorDos")
	private boolean priorDos;
	
	@Column(name = "mntDOS")
	private float mntDOS;
	
	@Column(name = "periodJourDos")
	private boolean periodJourDos;
	
	@Column(name = "periodHebdoDos")
	private boolean periodHebdoDos;
	
	@Column(name = "periodMensDos")
	private boolean periodMensDos;
	
	@Column(name = "periodTrimDos")
	private boolean periodTrimDos;
	
	@Column(name = "periodSemestDos")
	private boolean periodSemestDos;
	
	@Column(name = "periodAnuDos")
	private boolean periodAnuDos;
	
	@Column(name = "periodSansDos")
	private boolean periodSansDos;
	
	@Column(name = "actifDos")
	private boolean actifDos;
	
	@Column(name = "cntNomDos")
	private String cntNomDos;
	
	@Column(name = "cntPrenomDos")
	private String cntPrenomDos;
	
	@Column(name = "cntTelDos")
	private String cntTelDos;
	
	@Column(name = "cntCmntDos")
	private String cntCmntDos;
	
	@Column(name = "libre")
	private String libre;

	@ManyToMany(targetEntity=Document.class,
			mappedBy = "dossiers",
			cascade={CascadeType.PERSIST, CascadeType.MERGE}
	)
		@JoinTable(
				name="dossier_document",
				joinColumns=@JoinColumn(name="idDos"),
				inverseJoinColumns=@JoinColumn(name="idDoc")
		)
	private Set<Document> documents = new HashSet<Document>();
	/**
	 * @param idDos
	 * @param nomDos
	 * @param enumTypesDossiers
	 * @param descDoc
	 * @param evenements
	 * @param priorDos
	 * @param mntDOS
	 * @param periodJourDos
	 * @param periodHebdoDos
	 * @param periodMensDos
	 * @param periodTrimDos
	 * @param periodSemestDos
	 * @param periodAnuDos
	 * @param periodSansDos
	 * @param actifDos
	 * @param cntNomDos
	 * @param cntPrenomDos
	 * @param cntTelDos
	 * @param cntCmntDos
	 * @param libre
	 */
	public Dossier(int idDos, String nomDos,
			EnumTypesDossiers enumTypesDossiers, String descDoc,
			List<Evenement> evenements, boolean priorDos, float mntDOS,
			boolean periodJourDos, boolean periodHebdoDos,
			boolean periodMensDos, boolean periodTrimDos,
			boolean periodSemestDos, boolean periodAnuDos,
			boolean periodSansDos, boolean actifDos, String cntNomDos,
			String cntPrenomDos, String cntTelDos, String cntCmntDos,
			String libre) {
		super();
		this.idDos = idDos;
		this.nomDos = nomDos;
		this.enumTypesDossiers = enumTypesDossiers;
		this.descDoc = descDoc;
		this.evenements = evenements;
		this.priorDos = priorDos;
		this.mntDOS = mntDOS;
		this.periodJourDos = periodJourDos;
		this.periodHebdoDos = periodHebdoDos;
		this.periodMensDos = periodMensDos;
		this.periodTrimDos = periodTrimDos;
		this.periodSemestDos = periodSemestDos;
		this.periodAnuDos = periodAnuDos;
		this.periodSansDos = periodSansDos;
		this.actifDos = actifDos;
		this.cntNomDos = cntNomDos;
		this.cntPrenomDos = cntPrenomDos;
		this.cntTelDos = cntTelDos;
		this.cntCmntDos = cntCmntDos;
		this.libre = libre;
	}

	/**
	 * @return the idDos
	 */
	public int getIdDos() {
		return idDos;
	}

	/**
	 * @param idDos the idDos to set
	 */
	public void setIdDos(int idDos) {
		this.idDos = idDos;
	}

	/**
	 * @return the nomDos
	 */
	public String getNomDos() {
		return nomDos;
	}

	/**
	 * @param nomDos the nomDos to set
	 */
	public void setNomDos(String nomDos) {
		this.nomDos = nomDos;
	}

	/**
	 * @return the enumTypesDossiers
	 */
	public EnumTypesDossiers getEnumTypesDossiers() {
		return enumTypesDossiers;
	}

	/**
	 * @param enumTypesDossiers the enumTypesDossiers to set
	 */
	public void setEnumTypesDossiers(EnumTypesDossiers enumTypesDossiers) {
		this.enumTypesDossiers = enumTypesDossiers;
	}

	/**
	 * @return the descDoc
	 */
	public String getDescDoc() {
		return descDoc;
	}

	/**
	 * @param descDoc the descDoc to set
	 */
	public void setDescDoc(String descDoc) {
		this.descDoc = descDoc;
	}

	/**
	 * @return the evenements
	 */
	public List<Evenement> getEvenements() {
		return evenements;
	}

	/**
	 * @param evenements the evenements to set
	 */
	public void setEvenements(List<Evenement> evenements) {
		this.evenements = evenements;
	}

	/**
	 * @return the priorDos
	 */
	public boolean isPriorDos() {
		return priorDos;
	}

	/**
	 * @param priorDos the priorDos to set
	 */
	public void setPriorDos(boolean priorDos) {
		this.priorDos = priorDos;
	}

	/**
	 * @return the mntDOS
	 */
	public float getMntDOS() {
		return mntDOS;
	}

	/**
	 * @param mntDOS the mntDOS to set
	 */
	public void setMntDOS(float mntDOS) {
		this.mntDOS = mntDOS;
	}

	/**
	 * @return the periodJourDos
	 */
	public boolean isPeriodJourDos() {
		return periodJourDos;
	}

	/**
	 * @param periodJourDos the periodJourDos to set
	 */
	public void setPeriodJourDos(boolean periodJourDos) {
		this.periodJourDos = periodJourDos;
	}

	/**
	 * @return the periodHebdoDos
	 */
	public boolean isPeriodHebdoDos() {
		return periodHebdoDos;
	}

	/**
	 * @param periodHebdoDos the periodHebdoDos to set
	 */
	public void setPeriodHebdoDos(boolean periodHebdoDos) {
		this.periodHebdoDos = periodHebdoDos;
	}

	/**
	 * @return the periodMensDos
	 */
	public boolean isPeriodMensDos() {
		return periodMensDos;
	}

	/**
	 * @param periodMensDos the periodMensDos to set
	 */
	public void setPeriodMensDos(boolean periodMensDos) {
		this.periodMensDos = periodMensDos;
	}

	/**
	 * @return the periodTrimDos
	 */
	public boolean isPeriodTrimDos() {
		return periodTrimDos;
	}

	/**
	 * @param periodTrimDos the periodTrimDos to set
	 */
	public void setPeriodTrimDos(boolean periodTrimDos) {
		this.periodTrimDos = periodTrimDos;
	}

	/**
	 * @return the periodSemestDos
	 */
	public boolean isPeriodSemestDos() {
		return periodSemestDos;
	}

	/**
	 * @param periodSemestDos the periodSemestDos to set
	 */
	public void setPeriodSemestDos(boolean periodSemestDos) {
		this.periodSemestDos = periodSemestDos;
	}

	/**
	 * @return the periodAnuDos
	 */
	public boolean isPeriodAnuDos() {
		return periodAnuDos;
	}

	/**
	 * @param periodAnuDos the periodAnuDos to set
	 */
	public void setPeriodAnuDos(boolean periodAnuDos) {
		this.periodAnuDos = periodAnuDos;
	}

	/**
	 * @return the periodSansDos
	 */
	public boolean isPeriodSansDos() {
		return periodSansDos;
	}

	/**
	 * @param periodSansDos the periodSansDos to set
	 */
	public void setPeriodSansDos(boolean periodSansDos) {
		this.periodSansDos = periodSansDos;
	}

	/**
	 * @return the actifDos
	 */
	public boolean isActifDos() {
		return actifDos;
	}

	/**
	 * @param actifDos the actifDos to set
	 */
	public void setActifDos(boolean actifDos) {
		this.actifDos = actifDos;
	}

	/**
	 * @return the cntNomDos
	 */
	public String getCntNomDos() {
		return cntNomDos;
	}

	/**
	 * @param cntNomDos the cntNomDos to set
	 */
	public void setCntNomDos(String cntNomDos) {
		this.cntNomDos = cntNomDos;
	}

	/**
	 * @return the cntPrenomDos
	 */
	public String getCntPrenomDos() {
		return cntPrenomDos;
	}

	/**
	 * @param cntPrenomDos the cntPrenomDos to set
	 */
	public void setCntPrenomDos(String cntPrenomDos) {
		this.cntPrenomDos = cntPrenomDos;
	}

	/**
	 * @return the cntTelDos
	 */
	public String getCntTelDos() {
		return cntTelDos;
	}

	/**
	 * @param cntTelDos the cntTelDos to set
	 */
	public void setCntTelDos(String cntTelDos) {
		this.cntTelDos = cntTelDos;
	}

	/**
	 * @return the cntCmntDos
	 */
	public String getCntCmntDos() {
		return cntCmntDos;
	}

	/**
	 * @param cntCmntDos the cntCmntDos to set
	 */
	public void setCntCmntDos(String cntCmntDos) {
		this.cntCmntDos = cntCmntDos;
	}

	/**
	 * @return the libre
	 */
	public String getLibre() {
		return libre;
	}

	/**
	 * @param libre the libre to set
	 */
	public void setLibre(String libre) {
		this.libre = libre;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Dossier [idDos=");
		builder.append(idDos);
		builder.append(", nomDos=");
		builder.append(nomDos);
		builder.append(", enumTypesDossiers=");
		builder.append(enumTypesDossiers);
		builder.append(", descDoc=");
		builder.append(descDoc);
		builder.append(", evenements=");
		builder.append(evenements);
		builder.append(", priorDos=");
		builder.append(priorDos);
		builder.append(", mntDOS=");
		builder.append(mntDOS);
		builder.append(", periodJourDos=");
		builder.append(periodJourDos);
		builder.append(", periodHebdoDos=");
		builder.append(periodHebdoDos);
		builder.append(", periodMensDos=");
		builder.append(periodMensDos);
		builder.append(", periodTrimDos=");
		builder.append(periodTrimDos);
		builder.append(", periodSemestDos=");
		builder.append(periodSemestDos);
		builder.append(", periodAnuDos=");
		builder.append(periodAnuDos);
		builder.append(", periodSansDos=");
		builder.append(periodSansDos);
		builder.append(", actifDos=");
		builder.append(actifDos);
		builder.append(", cntNomDos=");
		builder.append(cntNomDos);
		builder.append(", cntPrenomDos=");
		builder.append(cntPrenomDos);
		builder.append(", cntTelDos=");
		builder.append(cntTelDos);
		builder.append(", cntCmntDos=");
		builder.append(cntCmntDos);
		builder.append(", libre=");
		builder.append(libre);
		builder.append("]");
		return builder.toString();
	}
}
