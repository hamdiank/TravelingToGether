package tn.cynapsys.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Aeroport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idAeroport;

	private String nom;

	
	
	public Aeroport() {
		super();
	}

	public Aeroport(String nom) {
		super();
		this.nom = nom;
	}

	public Long getIdAeroport() {
		return idAeroport;
	}

	public void setIdAeroport(Long idAeroport) {
		this.idAeroport = idAeroport;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
