package tn.cynapsys.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Embeddable
public class AnnonceCovoi extends Annonce {
	private Long nombrePlaces;

	private float cotisation;
	
	private String cotType;


	
	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "annonceCovoi")
	//@JsonIgnoreProperties(value = "annonceCovoi")
	private List <Reservation> reservations;
	

	public AnnonceCovoi() {
		super();
	}

	
	
	public AnnonceCovoi(String datePublication, String heureDepart, String dateDepart, String paysDepart,
			String villeDepart, String paysArrivee, String villeArrivee, Utilisateur utilisateur, Long nombrePlaces,
			Long cotisation, List<Reservation> reservations) {
		super(datePublication, heureDepart, dateDepart, paysDepart, villeDepart, paysArrivee, villeArrivee,
				utilisateur);
		this.nombrePlaces = nombrePlaces;
		this.cotisation = cotisation;
		this.reservations = reservations;
	}



	public AnnonceCovoi(String datePublication, String heureDepart, String dateDepart, String paysDepart,
			String villeDepart, String paysArrivee, String villeArrivee, Utilisateur utilisateur, Long nombrePlaces,
			Long cotisation) {
		super(datePublication, heureDepart, dateDepart, paysDepart, villeDepart, paysArrivee, villeArrivee,
				utilisateur);
		this.nombrePlaces = nombrePlaces;
		this.cotisation = cotisation;
	}

	public Long getNombrePlaces() {
		return nombrePlaces;
	}

	public void setNombrePlaces(Long nombrePlaces) {
		this.nombrePlaces = nombrePlaces;
	}

	public float getCotisation() {
		return cotisation;
	}

	public void setCotisation(Long cotisation) {
		this.cotisation = cotisation;
	}
	public List <Reservation> getReservations() {
		return reservations;
	}
	public void setReservations(List<Reservation> reservations) {
		this.reservations = reservations;
	}



	public String getCotType() {
		return cotType;
	}



	public void setCotType(String cotType) {
		this.cotType = cotType;
	}

}
