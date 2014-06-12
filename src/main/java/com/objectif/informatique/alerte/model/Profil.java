/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author vdibi
 *
 */
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
	
	
	
}
