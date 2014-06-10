/**
 * 
 */
package com.objectif.informatique.alerte.model;

/**
 * @author vdibi
 *
 */
public class TypesDossiers {
	private String chargesSociales;
	private String ursaff;
	private String vieSociale;
	
	
	public TypesDossiers(String chargesSociales, String ursaff,
			String vieSociale) {
		super();
		this.chargesSociales = chargesSociales;
		this.ursaff = ursaff;
		this.vieSociale = vieSociale;
	}


	public String getChargesSociales() {
		return chargesSociales;
	}


	public void setChargesSociales(String chargesSociales) {
		this.chargesSociales = chargesSociales;
	}


	public String getUrsaff() {
		return ursaff;
	}


	public void setUrsaff(String ursaff) {
		this.ursaff = ursaff;
	}


	public String getVieSociale() {
		return vieSociale;
	}


	public void setVieSociale(String vieSociale) {
		this.vieSociale = vieSociale;
	}
}
