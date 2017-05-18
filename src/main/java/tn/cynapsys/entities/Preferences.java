package tn.cynapsys.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Preferences implements Serializable{

	
	
	@Id
	@GeneratedValue
	@Column(name = "PREFERENCES_ID")
	private Long id;
	
	
	private Boolean musique;
	private Boolean animaux;
	private Boolean fumeur;
	
	public Preferences(Boolean musique, Boolean animaux, Boolean fumeur) {
		super();
		this.musique = musique;
		this.animaux = animaux;
		this.fumeur = fumeur;
	}

	public Preferences() {
		super();
		this.musique = null;
		this.animaux = null;
		this.fumeur = null;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Boolean getMusique() {
		return musique;
	}

	public void setMusique(Boolean musique) {
		this.musique = musique;
	}

	public Boolean getAnimaux() {
		return animaux;
	}

	public void setAnimaux(Boolean animaux) {
		this.animaux = animaux;
	}

	public Boolean getFumeur() {
		return fumeur;
	}

	public void setFumeur(Boolean fumeur) {
		this.fumeur = fumeur;
	}
	
	
}
