/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.util.ArrayList;

/**
 * @author vdibi
 * @author P0P0T3 ;)
 */
@Entity
@Table(name="dossier")
public class Dossier {
	
	@Id @GeneratedValue
	@Column(name = "idDos")
	private int idDos;
	
	@Column(name = "nomDos")
	private String nomDos;

	@Column(name = "typesDossiers")
	@Enumerated(EnumType.STRING) 
	private enum typesDossiers{
		TOTO,TOTO,TOTO
	}
	
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


	public Dossier(int idDos, String nomDos,
			ArrayList<TypesDossiers> typesDossiers, String descDoc,
			String evtDos, boolean priorDos, float mntDOS,
			boolean periodJourDos, boolean periodHebdoDos,
			boolean periodMensDos, boolean periodTrimDos,
			boolean periodSemestDos, boolean periodAnuDos,
			boolean periodSansDos, boolean actifDos, String cntNomDos,
			String cntPrenomDos, String cntTelDos, String cntCmntDos,
			String libre) {
		super();
		this.idDos = idDos;
		this.nomDos = nomDos;
		this.typesDossiers = typesDossiers;
		this.descDoc = descDoc;
		this.evtDos = evtDos;
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
	public int getIdDos() {
		return idDos;
	}
	public void setIdDos(int idDos) {
		this.idDos = idDos;
	}
	public String getNomDos() {
		return nomDos;
	}
	public void setNomDos(String nomDos) {
		this.nomDos = nomDos;
	}
	public ArrayList<TypesDossiers> getTypesDossiers() {
		return typesDossiers;
	}
	public void setTypesDossiers(ArrayList<TypesDossiers> typesDossiers) {
		this.typesDossiers = typesDossiers;
	}
	public String getDescDoc() {
		return descDoc;
	}
	public void setDescDoc(String descDoc) {
		this.descDoc = descDoc;
	}
	public String getEvtDos() {
		return evtDos;
	}
	public void setEvtDos(String evtDos) {
		this.evtDos = evtDos;
	}
	public boolean isPriorDos() {
		return priorDos;
	}
	public void setPriorDos(boolean priorDos) {
		this.priorDos = priorDos;
	}
	public float getMntDOS() {
		return mntDOS;
	}
	public void setMntDOS(float mntDOS) {
		this.mntDOS = mntDOS;
	}
	public boolean isPeriodJourDos() {
		return periodJourDos;
	}
	public void setPeriodJourDos(boolean periodJourDos) {
		this.periodJourDos = periodJourDos;
	}
	public boolean isPeriodHebdoDos() {
		return periodHebdoDos;
	}
	public void setPeriodHebdoDos(boolean periodHebdoDos) {
		this.periodHebdoDos = periodHebdoDos;
	}
	public boolean isPeriodMensDos() {
		return periodMensDos;
	}
	public void setPeriodMensDos(boolean periodMensDos) {
		this.periodMensDos = periodMensDos;
	}
	public boolean isPeriodTrimDos() {
		return periodTrimDos;
	}
	public void setPeriodTrimDos(boolean periodTrimDos) {
		this.periodTrimDos = periodTrimDos;
	}
	public boolean isPeriodSemestDos() {
		return periodSemestDos;
	}
	public void setPeriodSemestDos(boolean periodSemestDos) {
		this.periodSemestDos = periodSemestDos;
	}
	public boolean isPeriodAnuDos() {
		return periodAnuDos;
	}
	public void setPeriodAnuDos(boolean periodAnuDos) {
		this.periodAnuDos = periodAnuDos;
	}
	public boolean isPeriodSansDos() {
		return periodSansDos;
	}
	public void setPeriodSansDos(boolean periodSansDos) {
		this.periodSansDos = periodSansDos;
	}
	public boolean isActifDos() {
		return actifDos;
	}
	public void setActifDos(boolean actifDos) {
		this.actifDos = actifDos;
	}
	public String getCntNomDos() {
		return cntNomDos;
	}
	public void setCntNomDos(String cntNomDos) {
		this.cntNomDos = cntNomDos;
	}
	public String getCntPrenomDos() {
		return cntPrenomDos;
	}
	public void setCntPrenomDos(String cntPrenomDos) {
		this.cntPrenomDos = cntPrenomDos;
	}
	public String getCntTelDos() {
		return cntTelDos;
	}
	public void setCntTelDos(String cntTelDos) {
		this.cntTelDos = cntTelDos;
	}
	public String getCntCmntDos() {
		return cntCmntDos;
	}
	public void setCntCmntDos(String cntCmntDos) {
		this.cntCmntDos = cntCmntDos;
	}
	public String getLibre() {
		return libre;
	}
	public void setLibre(String libre) {
		this.libre = libre;
	}	

}
