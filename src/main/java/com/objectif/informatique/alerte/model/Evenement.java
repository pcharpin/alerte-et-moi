/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

/**
 * @author vdibi
 *
 */
public class Evenement implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idEvt;
	private int idDos;
	private int responsable_idResp;
	private String nomEvt;
	private String descEvt;
	private Date dateEchEvt;
	private int exeEvt;
	private float mntEvt;
	@Enumerated(EnumType.STRING)
	private EnumModeGestionEvt modeGestionEvt;
	private String lienGestEvt;
	private int trtEvt;
	private Date dateTrtEvt;
	@Enumerated(EnumType.STRING)
	private EnumPeriodeEvet enumPeriodeEvet;
	private int actifEvt;
	private int recopAutoEvt;
	private int recurtEvt;
	private String libreEvt;
	
	
	/**
	 * @param id
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
	 */
	public Evenement(int idEvt, int idDos, int responsable_idResp, String nomEvt,
			String descEvt, Date dateEchEvt, int exeEvt, float mntEvt,
			EnumModeGestionEvt modeGestionEvt, String lienGestEvt,
			int trtEvt, Date dateTrtEvt, EnumPeriodeEvet enumPeriodeEvet,
			int actifEvt, int recopAutoEvt, int recurtEvt,
			String libreEvt) {
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
}
