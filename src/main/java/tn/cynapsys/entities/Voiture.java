package tn.cynapsys.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Voiture implements Serializable {
	@Id
	@GeneratedValue
	private Long id;
	private String marque;
	private String modele;
	private int nombrePlace;
	private String energie;

	public Voiture() {
		super();
	}

	public Voiture(String marque, String modele, int nombrePlace, String energie) {
		super();
		this.marque = marque;
		this.modele = modele;
		this.nombrePlace = nombrePlace;
		this.energie = energie;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMarque() {
		return marque;
	}

	public void setMarque(String marque) {
		this.marque = marque;
	}

	public String getModele() {
		return modele;
	}

	public void setModele(String modele) {
		this.modele = modele;
	}

	public int getNombrePlace() {
		return nombrePlace;
	}

	public void setNombrePlace(int nombrePlace) {
		this.nombrePlace = nombrePlace;
	}

	public String getEnergie() {
		return energie;
	}

	public void setEnergie(String energie) {
		this.energie = energie;
	}

}
