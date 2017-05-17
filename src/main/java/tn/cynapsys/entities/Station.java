package tn.cynapsys.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Station implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idStation;
	
	private String nom;

	
	

	public Station() {
		super();
	}
	

	public Station(String nom) {
		super();
		this.nom = nom;
	}


	public Long getIdStation() {
		return idStation;
	}

	public void setIdStation(Long idStation) {
		this.idStation = idStation;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
}
