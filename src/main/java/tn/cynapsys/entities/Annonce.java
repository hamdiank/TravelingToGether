package tn.cynapsys.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@Embeddable
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS )
public class Annonce implements Serializable{
	@Id @GeneratedValue
	private Long id; 
	private String datePublication;
	private String heureDepart;
	private String dateDepart;
	private String paysDepart;
	private String villeDepart;
	private String paysArrivee;
	private String villeArrivee;
	@ManyToOne
	@JsonIgnoreProperties(value = "annonces")
	@JoinColumn(name="CODE_UTIL")
	private Utilisateur utilisateur;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "annonce")
	@JsonIgnore
	private List<Commentaire> comment;
	
	public Annonce() {
		super();
	}
	public Annonce(String datePublication, String heureDepart, String dateDepart, String paysDepart, String villeDepart,
			String paysArrivee, String villeArrivee, Utilisateur utilisateur) {
		super();
		this.datePublication = datePublication;
		this.heureDepart = heureDepart;
		this.dateDepart = dateDepart;
		this.paysDepart = paysDepart;
		this.villeDepart = villeDepart;
		this.paysArrivee = paysArrivee;
		this.villeArrivee = villeArrivee;
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
	public String getHeureDepart() {
		return heureDepart;
	}
	public void setHeureDepart(String heureDepart) {
		this.heureDepart = heureDepart;
	}
	public String getDateDepart() {
		return dateDepart;
	}
	public void setDateDepart(String dateDepart) {
		this.dateDepart = dateDepart;
	}
	public String getPaysDepart() {
		return paysDepart;
	}
	public void setPaysDepart(String paysDepart) {
		this.paysDepart = paysDepart;
	}
	public String getVilleDepart() {
		return villeDepart;
	}
	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}
	public String getPaysArrivee() {
		return paysArrivee;
	}
	public void setPaysArrivee(String paysArrivee) {
		this.paysArrivee = paysArrivee;
	}
	public String getVilleArrivee() {
		return villeArrivee;
	}
	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
}
