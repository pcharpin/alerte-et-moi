/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author vdibi
 *
 */
@Entity
@Table(name="evenement")
public class Evenement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue
	@Column(name = "idEvt")
	private int idEvt;
	@Column(name = "idDos")
	private int idDos;
	@Column(name="responsable_idResp")
	private int responsable_idResp;
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
	@Column(name="modeGestionEvt")
	@Enumerated(EnumType.STRING)
	private EnumModeGestionEvt modeGestionEvt;
	@Column(name="lienGestEvt")
	private String lienGestEvt;
	@Column(name="trtEvt")
	private int trtEvt;
	@Column(name="dateTrtEvt")
	private Date dateTrtEvt;
	@Column(name = "enumPeriodeEvet")
	@Enumerated(EnumType.STRING)
	private EnumPeriodeEvet enumPeriodeEvet;
	@Column(name="actifEvt")
	private int actifEvt;
	@Column(name="recopAutoEvt")
	private int recopAutoEvt;
	@Column(name="recurtEvt")
	private int recurtEvt;
	@Column(name="libreEvt")
	private String libreEvt;
	@OneToMany(mappedBy="evenement", cascade = CascadeType.ALL)
	@Column(name = "responsable_idResp")
	private Responsable responsable;	
	
	@ManyToMany(targetEntity=Document.class,
			mappedBy = "evenements",
			cascade={CascadeType.PERSIST, CascadeType.MERGE}
	)
		@JoinTable(
				name="evenement_document",
				joinColumns=@JoinColumn(name="idEvt"),
				inverseJoinColumns=@JoinColumn(name="idDoc")
		)
	private Set<Document> documents = new HashSet<Document>();
	
	
	/**
	 * @param idEvt
	 * @param idDos
	 * @param responsable_idResp
	 * @param nomEvt
	 * @param descEvt
	 * @param dateEchEvt
	 * @param exeEvt
	 * @param mntEvt
	 * @param modeGestionEvt
	 * @param lienGestEvt
	 * @param trtEvt
	 * @param dateTrtEvt
	 * @param enumPeriodeEvet
	 * @param actifEvt
	 * @param recopAutoEvt
	 * @param recurtEvt
	 * @param libreEvt
	 * @param evenements
	 */
	public Evenement(int idEvt, int idDos, int responsable_idResp,
			String nomEvt, String descEvt, Date dateEchEvt, int exeEvt,
			float mntEvt, EnumModeGestionEvt modeGestionEvt,
			String lienGestEvt, int trtEvt, Date dateTrtEvt,
			EnumPeriodeEvet enumPeriodeEvet, int actifEvt, int recopAutoEvt,
			int recurtEvt, String libreEvt, Set<Document> documents) {
		super();
		this.idEvt = idEvt;
		this.idDos = idDos;
		this.responsable_idResp = responsable_idResp;
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
		this.documents = documents;
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
	public int getIdDos() {
		return idDos;
	}
	public void setIdDos(int idDos) {
		this.idDos = idDos;
	}
	public int getResponsable_idResp() {
		return responsable_idResp;
	}
	public void setResponsable_idResp(int responsable_idResp) {
		this.responsable_idResp = responsable_idResp;
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
		builder.append(", idDos=");
		builder.append(idDos);
		builder.append(", responsable_idResp=");
		builder.append(responsable_idResp);
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
		builder.append(", documents=");
		builder.append(documents);
		builder.append("]");
		return builder.toString();
	}
	
}
