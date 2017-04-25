package tn.cynapsys.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class City {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCity;

	private String nom;
	
	public City() {
		super();
	}
	

	public City(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}


	public Long getIdCity() {
		return idCity;
	}


	public void setIdCity(Long idCity) {
		this.idCity = idCity;
	}

}
