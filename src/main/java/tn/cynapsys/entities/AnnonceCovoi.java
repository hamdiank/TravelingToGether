package tn.cynapsys.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;

@Entity
@Embeddable
public class AnnonceCovoi extends Annonce{
	private Long nombrePlaces;
	private Long cotisation;
	public AnnonceCovoi() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnnonceCovoi(Long id, Date datePublication, Date dateDepart, String adresseDepart, String adresseArrivee,
			Utilisateur utilisateur, Long nombrePlaces, Long cotisation) {
		super(id, datePublication, dateDepart, adresseDepart, adresseArrivee, utilisateur);
		this.nombrePlaces = nombrePlaces;
		this.cotisation = cotisation;
	}
	public Long getNombrePlaces() {
		return nombrePlaces;
	}
	public void setNombrePlaces(Long nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}
	public Long getCotisation() {
		return cotisation;
	}
	public void setCotisation(Long cotisation) {
		this.cotisation = cotisation;
	}

}
