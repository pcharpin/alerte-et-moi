/**
 * 
 */
package com.objectif.informatique.alerte.model;

/**
 * @author vdibi
 *
 */
public enum EnumTypesDossiers {
	CHARGESSOCIALES("charges sociales"),
	VIESOCIALE ("vie sociale");
	
	 private String code;

	 private EnumTypesDossiers(String val){
		this.code = val; 
	 }
	 
	 
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	} 
	
	public static EnumTypesDossiers converterEnum(String value){
		EnumTypesDossiers enumVal=null;
		  
		  if(value !=null){
		   if(value.equalsIgnoreCase("charges sociales"))
		    enumVal=EnumTypesDossiers.CHARGESSOCIALES;
		   else if(value.equalsIgnoreCase("vie sociale"))
		    enumVal=EnumTypesDossiers.VIESOCIALE;
		  }
		  
		  return enumVal;
		 }
	
		public String recreateString(){
		  return code;
		 }
}
