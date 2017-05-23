package tn.cynapsys.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Embeddable
public class Reservation implements Serializable{
	
	@Id @GeneratedValue
	private Long idReservation;
	
	private  Boolean etat;
	
	@ManyToOne
	@JoinColumn(name="CODE_ANNONCE_COVOI")
	@JsonIgnoreProperties(value = "reservations")
	private AnnonceCovoi annonceCovoi;
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JsonIgnoreProperties(value = "reservations")
	@JoinColumn(name = "UTILISATEUR_ID")
	private Utilisateur utilisateurReservation;

	public Reservation() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Reservation(Boolean etat, AnnonceCovoi annonceCovoi, Utilisateur utilisateur) {
		super();
		this.etat = etat;
		this.annonceCovoi = annonceCovoi;
		this.utilisateurReservation = utilisateur;
	}

	public Long getIdReservation() {
		return idReservation;
	}

	public void setIdReservation(Long idReservation) {
		this.idReservation = idReservation;
	}

	public Boolean getEtat() {
		return etat;
	}

	public void setEtat(Boolean etat) {
		this.etat = etat;
	}

	public AnnonceCovoi getAnnonceCovoi() {
		return annonceCovoi;
	}

	public void setAnnonceCovoi(AnnonceCovoi annonceCovoi) {
		this.annonceCovoi = annonceCovoi;
	}

	public Utilisateur getUtilisateurReservation() {
		return utilisateurReservation;
	}

	public void setUtilisateurReservation(Utilisateur utilisateurReservation) {
		this.utilisateurReservation = utilisateurReservation;
	}


	
	

}
