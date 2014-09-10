/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

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
	
	private static final long serialVersionUID = 1L;
	@Transient
	private String[] documentNames;
	@Transient
	private String[] documentContents;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="Responsable_idResp")
	private Responsable responsable;	
	
	@OneToMany(mappedBy="evenement",cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private Set<Alerte> alertes = new HashSet<Alerte>();
	
	@ManyToMany(fetch=FetchType.EAGER)
		@JoinTable(
				name="evenement_document",
				joinColumns={@JoinColumn(name="Evenement_idEvt")},
				inverseJoinColumns={@JoinColumn(name="Document_idDoc")}
		)
	//@JsonIgnore
	private Set<Document> documents = new HashSet<Document>();

	public Evenement(){
		super();
	}
	public Evenement(int idEvt, Dossier dossier, String nomEvt, String descEvt,
			Date dateEchEvt, int exeEvt, float mntEvt,
			EnumModeGestionEvt modeGestionEvt, String lienGestEvt, int trtEvt,
			Date dateTrtEvt, EnumPeriodeEvet enumPeriodeEvet, int actifEvt,
			int recopAutoEvt, int recurtEvt, String libreEvt,
			String[] documentNames, String[] documentContents,
			Responsable responsable, Set<Alerte> alertes,
			Set<Document> documents) {
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
		this.documentNames = documentNames;
		this.documentContents = documentContents;
		this.responsable = responsable;
		this.alertes = alertes;
		this.documents = documents;
	}
	
	public Evenement(Dossier dossier, String nomEvt, String descEvt,
			Date dateEchEvt, int exeEvt, float mntEvt,
			EnumModeGestionEvt modeGestionEvt, String lienGestEvt, int trtEvt,
			Date dateTrtEvt, EnumPeriodeEvet enumPeriodeEvet, int actifEvt,
			int recopAutoEvt, int recurtEvt, String libreEvt,
			String[] documentNames, String[] documentContents,
			Responsable responsable, Set<Alerte> alertes,
			Set<Document> documents) {
		super();
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
		this.documentNames = documentNames;
		this.documentContents = documentContents;
		this.responsable = responsable;
		this.alertes = alertes;
		this.documents = documents;
	}
	public int getIdEvt() {
		return idEvt;
	}
	public void setIdEvt(int idEvt) {
		this.idEvt = idEvt;
	}
	public Dossier getDossier() {
		return dossier;
	}
	public void setDossier(Dossier dossier) {
		this.dossier = dossier;
	}
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
	public EnumModeGestionEvt getModeGestionEvt() {
		return modeGestionEvt;
	}
	public void setModeGestionEvt(EnumModeGestionEvt modeGestionEvt) {
		this.modeGestionEvt = modeGestionEvt;
	}
	public String getLienGestEvt() {
		return lienGestEvt;
	}
	public void setLienGestEvt(String lienGestEvt) {
		this.lienGestEvt = lienGestEvt;
	}
	public int getTrtEvt() {
		return trtEvt;
	}
	public void setTrtEvt(int trtEvt) {
		this.trtEvt = trtEvt;
	}
	public Date getDateTrtEvt() {
		return dateTrtEvt;
	}
	public void setDateTrtEvt(Date dateTrtEvt) {
		this.dateTrtEvt = dateTrtEvt;
	}
	public EnumPeriodeEvet getEnumPeriodeEvet() {
		return enumPeriodeEvet;
	}
	public void setEnumPeriodeEvet(EnumPeriodeEvet enumPeriodeEvet) {
		this.enumPeriodeEvet = enumPeriodeEvet;
	}
	public int getActifEvt() {
		return actifEvt;
	}
	public void setActifEvt(int actifEvt) {
		this.actifEvt = actifEvt;
	}
	public int getRecopAutoEvt() {
		return recopAutoEvt;
	}
	public void setRecopAutoEvt(int recopAutoEvt) {
		this.recopAutoEvt = recopAutoEvt;
	}
	public int getRecurtEvt() {
		return recurtEvt;
	}
	public void setRecurtEvt(int recurtEvt) {
		this.recurtEvt = recurtEvt;
	}
	public String getLibreEvt() {
		return libreEvt;
	}
	public void setLibreEvt(String libreEvt) {
		this.libreEvt = libreEvt;
	}
	public String[] getDocumentNames() {
		return documentNames;
	}
	public void setDocumentNames(String[] documentNames) {
		this.documentNames = documentNames;
	}
	public String[] getDocumentContents() {
		return documentContents;
	}
	public void setDocumentContents(String[] documentContents) {
		this.documentContents = documentContents;
	}
	public Responsable getResponsable() {
		return responsable;
	}
	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
	public Set<Alerte> getAlertes() {
		return alertes;
	}
	public void setAlertes(Set<Alerte> alertes) {
		this.alertes = alertes;
	}
	public Set<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(Set<Document> documents) {
		this.documents = documents;
	}
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
		builder.append(", documentNames=");
		builder.append(Arrays.toString(documentNames));
		builder.append(", documentContents=");
		builder.append(Arrays.toString(documentContents));
		builder.append(", responsable=");
		builder.append(responsable);
		builder.append(", alertes=");
		builder.append(alertes);
		builder.append(", documents=");
		builder.append(documents);
		builder.append("]");
		return builder.toString();
	}
		
}