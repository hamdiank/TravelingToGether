package tn.cynapsys.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
@Entity
@Embeddable
@DiscriminatorValue("AV")
public class AnnonceVol extends Annonce{
	private String typeAvion;

	public AnnonceVol() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnnonceVol(Long id, String datePublication, String dateDepart, String adresseDepart, String adresseArrivee,
			Utilisateur utilisateur, String typeAvion) {
		super(id, datePublication, dateDepart, adresseDepart, adresseArrivee, utilisateur);
		this.typeAvion = typeAvion;
	}

	public String getTypeAvion() {
		return typeAvion;
	}

	public void setTypeAvion(String typeAvion) {
		this.typeAvion = typeAvion;
	}
	

}
