/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

/**
 * @author vdibi
 *
 */
@Entity
@Table(name="evenement")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Evenement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	@Column(name = "idEvt")
	private int idEvt;
	//@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Dossier_idDos")
	private Dossier dossier;
	@Column(name="nomEvt")
	private String nomEvt;
	@Column(name="descEvt")
	private String descEvt;
	@Column(name="dateEchEvt")
	private Date dateEchEvt;
	@Column(name="exeEvt")
	private int exeEvt;
	@Column(name="mntEvt")
	private float mntEvt;
	
	@Column(name="modeGestEvt")
	@Enumerated(EnumType.STRING)
    private EnumModeGestionEvt modeGestionEvt;
	
	@Column(name="lienGestEvt")
	private String lienGestEvt;
	@Column(name="trtEvt")
	private int trtEvt;
	@Column(name="dateTrtEvt")
	private Date dateTrtEvt;
	@Column(name = "periodEvt")
	@Enumerated(EnumType.STRING)
	private EnumPeriodeEvet enumPeriodeEvet;
	@Column(name="actifEvt")
	private int actifEvt;
	@Column(name="recopAutoEvt")
	private int recopAutoEvt;
	@Column(name="recurEvt")
	private int recurtEvt;
	@Column(name="libreEvt")
	private String libreEvt;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Responsable_idResp")
	private Responsable responsable;	
	
	@ManyToMany(fetch=FetchType.EAGER)
		@JoinTable(
				name="evenement_document",
				joinColumns={@JoinColumn(name="Evenement_idEvt")},
				inverseJoinColumns={@JoinColumn(name="Document_idDoc")}
		)
	@JsonIgnore
	private Set<Document> documents = new HashSet<Document>();
	
	public Evenement(int idEvt, Dossier dossier, String nomEvt, String descEvt,
			Date dateEchEvt, int exeEvt, float mntEvt,
			EnumModeGestionEvt modeGestionEvt, String lienGestEvt, int trtEvt,
			Date dateTrtEvt, EnumPeriodeEvet enumPeriodeEvet, int actifEvt,
			int recopAutoEvt, int recurtEvt, String libreEvt,
			Responsable responsable, Set<Document> documents) {
		super();
		this.idEvt = idEvt;
		this.dossier = dossier;
		this.nomEvt = nomEvt;
		this.descEvt = descEvt;
		this.dateEchEvt = dateEchEvt;
		this.exeEvt = exeEvt;
		this.mntEvt = mntEvt;
		this.modeGestionEvt = modeGestionEvt;
		this.lienGestEvt = lienGestEvt;
		this.trtEvt = trtEvt;
		this.dateTrtEvt = dateTrtEvt;
		this.enumPeriodeEvet = enumPeriodeEvet;
		this.actifEvt = actifEvt;
		this.recopAutoEvt = recopAutoEvt;
		this.recurtEvt = recurtEvt;
		this.libreEvt = libreEvt;
		this.responsable = responsable;
		this.documents = documents;
	}
	public boolean addFile(Document document){
		List<Document> documents =  new ArrayList<Document>();
		return documents.add(document);		
	}
	
	public Evenement(int id, String nomEvt){
		super();
		this.idEvt = idEvt;
		this.nomEvt = nomEvt;
	}
	/**
	 * Constructeur vide
	 */
	public Evenement(){}
	
	
	/**
	 * @return the dossier
	 */
	public Dossier getDossier() {
		return dossier;
	}
	/**
	 * @param dossier the dossier to set
	 */
	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
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

//	public Responsable getResponsable_resp() {
//		return this.responsable;
//	}
//	public void setResponsable_resp(Responsable responsable_idResp) {
//		this.responsable = responsable_idResp;
//	}
	public String getNomEvt() {
		return nomEvt;
	}
	public void setNomEvt(String nomEvt) {
		this.nomEvt = nomEvt;
	}
	public String getDescEvt() {
		return descEvt;
	}
	public void setDescEvt(String descEvt) {
		this.descEvt = descEvt;
	}
	/**
	 * @return the responsable
	 */
	public Responsable getResponsable() {
		return responsable;
	}
	/**
	 * @param responsable the responsable to set
	 */
	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
	public Date getDateEchEvt() {
		return dateEchEvt;
	}
	public void setDateEchEvt(Date dateEchEvt) {
		this.dateEchEvt = dateEchEvt;
	}
	public int getExeEvt() {
		return exeEvt;
	}
	public void setExeEvt(int exeEvt) {
		this.exeEvt = exeEvt;
	}
	public float getMntEvt() {
		return mntEvt;
	}
	public void setMntEvt(float mntEvt) {
		this.mntEvt = mntEvt;
	}
	public String getLienGestEvt() {
		return lienGestEvt;
	}
	public void setLienGestEvt(String lienGestEvt) {
		this.lienGestEvt = lienGestEvt;
	}
	
	/**
	 * @return the trtEvt
	 */
	public int getTrtEvt() {
		return trtEvt;
	}
	/**
	 * @param trtEvt the trtEvt to set
	 */
	public void setTrtEvt(int trtEvt) {
		this.trtEvt = trtEvt;
	}
	public Date getDateTrtEvt() {
		return dateTrtEvt;
	}
	public void setDateTrtEvt(Date dateTrtEvt) {
		this.dateTrtEvt = dateTrtEvt;
	}
	
	/**
	 * @return the actifEvt
	 */
	public int getActifEvt() {
		return actifEvt;
	}
	/**
	 * @param actifEvt the actifEvt to set
	 */
	public void setActifEvt(int actifEvt) {
		this.actifEvt = actifEvt;
	}
	/**
	 * @return the recopAutoEvt
	 */
	public int getRecopAutoEvt() {
		return recopAutoEvt;
	}
	/**
	 * @param recopAutoEvt the recopAutoEvt to set
	 */
	public void setRecopAutoEvt(int recopAutoEvt) {
		this.recopAutoEvt = recopAutoEvt;
	}
	/**
	 * @return the recurtEvt
	 */
	public int getRecurtEvt() {
		return recurtEvt;
	}
	/**
	 * @param recurtEvt the recurtEvt to set
	 */
	public void setRecurtEvt(int recurtEvt) {
		this.recurtEvt = recurtEvt;
	}
	public String getLibreEvt() {
		return libreEvt;
	}
	public void setLibreEvt(String libreEvt) {
		this.libreEvt = libreEvt;
	}
	public EnumModeGestionEvt getModeGestionEvt() {
		return modeGestionEvt;
	}
	public void setModeGestionEvt(EnumModeGestionEvt modeGestionEvt) {
		this.modeGestionEvt = modeGestionEvt;
	}
	public EnumPeriodeEvet getEnumPeriodeEvet() {
		return enumPeriodeEvet;
	}
	public void setEnumPeriodeEvet(EnumPeriodeEvet enumPeriodeEvet) {
		this.enumPeriodeEvet = enumPeriodeEvet;
	}
	/**
	 * @return the evenements
	 */
	public Set<Document> getDocuments() {
		return documents;
	}
	/**
	 * @param documents the documents to set
	 */
	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Evenement [idEvt=");
		builder.append(idEvt);
		builder.append(", dossier=");
		builder.append(dossier);
		builder.append(", nomEvt=");
		builder.append(nomEvt);
		builder.append(", descEvt=");
		builder.append(descEvt);
		builder.append(", dateEchEvt=");
		builder.append(dateEchEvt);
		builder.append(", exeEvt=");
		builder.append(exeEvt);
		builder.append(", mntEvt=");
		builder.append(mntEvt);
		builder.append(", modeGestionEvt=");
		builder.append(modeGestionEvt);
		builder.append(", lienGestEvt=");
		builder.append(lienGestEvt);
		builder.append(", trtEvt=");
		builder.append(trtEvt);
		builder.append(", dateTrtEvt=");
		builder.append(dateTrtEvt);
		builder.append(", enumPeriodeEvet=");
		builder.append(enumPeriodeEvet);
		builder.append(", actifEvt=");
		builder.append(actifEvt);
		builder.append(", recopAutoEvt=");
		builder.append(recopAutoEvt);
		builder.append(", recurtEvt=");
		builder.append(recurtEvt);
		builder.append(", libreEvt=");
		builder.append(libreEvt);
		builder.append(", responsable=");
		builder.append(responsable);
		builder.append(", documents=");
		builder.append(documents);
		builder.append("]");
		return builder.toString();
	}
}