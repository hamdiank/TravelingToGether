package tn.cynapsys.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Avis {

	@Id
	@GeneratedValue
	private Long id;

	private Long idDest;

	@ManyToOne
	@JoinColumn(name = "ID_Autheur")
	private Utilisateur author;
	private String text;
	private String date;
	
	public Avis() {
		super();
	}

	public Avis(Long idDest, Utilisateur author, String text,String date) {
		super();
		this.idDest = idDest;
		this.author = author;
		this.text = text;
		this.date=date;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdDest() {
		return idDest;
	}

	public void setIdDest(Long idDest) {
		this.idDest = idDest;
	}

	public Utilisateur getAuthor() {
		return author;
	}

	public void setAuthor(Utilisateur author) {
		this.author = author;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
	
	
	
	
}
