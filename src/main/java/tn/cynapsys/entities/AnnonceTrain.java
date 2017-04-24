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

	public AnnonceTrain() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AnnonceTrain(Long id, Date datePublication, Date dateDepart, String adresseDepart, String adresseArrivee,
			Utilisateur utilisateur, String typeTrain) {
		super(id, datePublication, dateDepart, adresseDepart, adresseArrivee, utilisateur);
		this.typeTrain = typeTrain;
	}

	public String getTypeTrain() {
		return typeTrain;
	}

	public void setTypeTrain(String typeTrain) {
		this.typeTrain = typeTrain;
	}

}
