package tn.cynapsys.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
@Entity
@Embeddable
public class AnnonceTrain extends Annonce{
	private String typeTrain;
	private String stationTrainDepart;
	private String stationTrainArrivee;
	public AnnonceTrain() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AnnonceTrain(String datePublication, String heureDepart, String dateDepart, String paysDepart,
			String villeDepart, String paysArrivee, String villeArrivee, Utilisateur utilisateur, String typeTrain,
			String stationTrainDepart, String stationTrainArrivee) {
		super(datePublication, heureDepart, dateDepart, paysDepart, villeDepart, paysArrivee, villeArrivee,
				utilisateur);
		this.typeTrain = typeTrain;
		this.stationTrainDepart = stationTrainDepart;
		this.stationTrainArrivee = stationTrainArrivee;
	}
	public String getTypeTrain() {
		return typeTrain;
	}
	public void setTypeTrain(String typeTrain) {
		this.typeTrain = typeTrain;
	}
	public String getStationTrainDepart() {
		return stationTrainDepart;
	}
	public void setStationTrainDepart(String stationTrainDepart) {
		this.stationTrainDepart = stationTrainDepart;
	}
	public String getStationTrainArrivee() {
		return stationTrainArrivee;
	}
	public void setStationTrainArrivee(String stationTrainArrivee) {
		this.stationTrainArrivee = stationTrainArrivee;
	}
	
	
}
