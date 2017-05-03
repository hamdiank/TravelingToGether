package tn.cynapsys.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Embeddable
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS )
public class Annonce implements Serializable{
	@Id @GeneratedValue
	private Long id; 
	private String datePublication;
	private String dateDepart;
	private String adresseDepart;
	private String adresseArrivee;
	@ManyToOne
	 @JsonIgnoreProperties(value = "annonce")
	@JoinColumn(name="CODE_UTIL")
	private Utilisateur utilisateur;
	public Annonce() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Annonce(String datePublication, String dateDepart, String adresseDepart, String adresseArrivee,
			Utilisateur utilisateur) {
		super();
		this.datePublication = datePublication;
		this.dateDepart = dateDepart;
		this.adresseDepart = adresseDepart;
		this.adresseArrivee = adresseArrivee;
		this.utilisateur = utilisateur;
	}
	public Annonce(Long id, String datePublication, String dateDepart, String adresseDepart, String adresseArrivee,
			Utilisateur utilisateur) {
		super();
		this.id = id;
		this.datePublication = datePublication;
		this.dateDepart = dateDepart;
		this.adresseDepart = adresseDepart;
		this.adresseArrivee = adresseArrivee;
		this.utilisateur = utilisateur;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDatePublication() {
		return datePublication;
	}
	public void setDatePublication(String datePublication) {
		this.datePublication = datePublication;
	}
	public String getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}
	public String getAdresseDepart() {
		return adresseDepart;
	}
	public void setAdresseDepart(String adresseDepart) {
		this.adresseDepart = adresseDepart;
	}
	public String getAdresseArrivee() {
		return adresseArrivee;
	}
	public void setAdresseArrivee(String adresseArrivee) {
		this.adresseArrivee = adresseArrivee;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	

}
