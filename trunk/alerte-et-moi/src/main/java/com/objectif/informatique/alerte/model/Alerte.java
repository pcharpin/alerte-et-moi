
/**
 * 
 */
package com.objectif.informatique.alerte.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
@Table(name="alerte")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Alerte implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6204215592716227088L;
	@Id @GeneratedValue
	@Column(name = "idAler")
	private int idAler;
	@Column(name="declanchAler")
	private int declenchAler;
	
	@Enumerated(EnumType.STRING)
	private TypeDeclenchAler typeDeclenchAler;
	@Column(name="dateAler")
	private Date dateAlerte;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="Evenement_idEvt")
	private Evenement evenement;

	//private int eventId;
	
//	@ManyToMany(targetEntity=Alerte.class,
//			cascade={CascadeType.PERSIST, CascadeType.MERGE}
//	)
//		@JoinTable(
//				name="responsable_alerte",
//				joinColumns=@JoinColumn(name="idAler"),
//				inverseJoinColumns=@JoinColumn(name="idResp")
//		)
	@JsonIgnore
	@ManyToMany(mappedBy="alertes",fetch=FetchType.EAGER)
	private Set<Responsable> responsables = new HashSet<Responsable>();

	public Alerte(){}
	
	
	public Alerte(int declenchAler,
			TypeDeclenchAler typeDeclenchAler, Date dateAlerte,
			Evenement evenement, Set<Responsable> responsables) {
		super();
		this.declenchAler = declenchAler;
		this.typeDeclenchAler = typeDeclenchAler;
		this.dateAlerte = dateAlerte;
		this.evenement = evenement;
		this.responsables = responsables;
	}


	public Alerte(int idAler, int declenchAler, TypeDeclenchAler typeDeclenchAler,
			Date dateAlerte,Evenement evenement, Set<Responsable> responsables) {
		super();
		this.idAler = idAler;
		this.declenchAler = declenchAler;
		this.typeDeclenchAler = typeDeclenchAler;
		this.dateAlerte = dateAlerte;
		this.evenement = evenement;
		this.responsables = responsables;
	}

	public int getIdAler() {
		return idAler;
	}

	public void setIdAler(int idAler) {
		this.idAler = idAler;
	}

	public int getDeclenchAler() {
		return declenchAler;
	}

	public void setDeclenchAler(int declenchAler) {
		this.declenchAler = declenchAler;
	}

	public TypeDeclenchAler getTypeDeclenchAler() {
		return typeDeclenchAler;
	}

	public void setTypeDeclenchAler(TypeDeclenchAler typeDeclenchAler) {
		this.typeDeclenchAler = typeDeclenchAler;
	}

	public Date getDateAlerte() {
		return dateAlerte;
	}

	public void setDateAlerte(Date dateAlerte) {
		this.dateAlerte = dateAlerte;
	}



	public Set<Responsable> getResponsables() {
		return responsables;
	}

	public void setResponsables(Set<Responsable> responsables) {
		this.responsables = responsables;
	}

	
	public Evenement getEvenement() {
		return evenement;
	}


	public void setEvenement(Evenement evenement) {
		this.evenement = evenement;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Alerte [idAler=");
		builder.append(idAler);
		builder.append(", declenchAler=");
		builder.append(declenchAler);
		builder.append(", typeDeclenchAler=");
		builder.append(typeDeclenchAler);
		builder.append(", dateAlerte=");
		builder.append(dateAlerte);
		builder.append(", evenement=");
		builder.append(evenement);
		builder.append(", responsables=");
		builder.append(responsables);
		builder.append("]");
		return builder.toString();
	}


}