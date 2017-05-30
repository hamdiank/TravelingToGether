package tn.cynapsys.entities;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
@Entity
@Embeddable
public class AnnonceVol extends Annonce{
	private String typeAvion;
	private String aeroportDepart;
	private String aeroportArrivee;
	public AnnonceVol() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnnonceVol(String datePublication, String heureDepart, String dateDepart, String paysDepart,
			String villeDepart, String paysArrivee, String villeArrivee, Utilisateur utilisateur, String typeAvion,
			String aeroportDepart, String aeroportArrivee) {
		super(datePublication, heureDepart, dateDepart, paysDepart, villeDepart, paysArrivee, villeArrivee,
				utilisateur);
		this.typeAvion = typeAvion;
		this.aeroportDepart = aeroportDepart;
		this.aeroportArrivee = aeroportArrivee;
	}
	public String getTypeAvion() {
		return typeAvion;
	}
	public void setTypeAvion(String typeAvion) {
		this.typeAvion = typeAvion;
	}
	public String getAeroportDepart() {
		return aeroportDepart;
	}
	public void setAeroportDepart(String aeroportDepart) {
		this.aeroportDepart = aeroportDepart;
	}
	public String getAeroportArrivee() {
		return aeroportArrivee;
	}
	public void setAeroportArrivee(String aeroportArrivee) {
		this.aeroportArrivee = aeroportArrivee;
	}
	
	


	

}
