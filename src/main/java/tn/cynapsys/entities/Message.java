package tn.cynapsys.entities;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Message {

	
	@Id
	@GeneratedValue
	private Long id;
	
	private Long idDestinataire;
	
	@ManyToOne
	@JoinColumn(name="ID_EXPEDITEUR")
	private Utilisateur author;

	private String text ;

	private String sentAt;
	

	private Boolean isRead;
	
	public Message() {
		super();
	}
	
public Message(Long idDestinataire, Utilisateur author, String text,String sentAt) {
		super();
		this.idDestinataire = idDestinataire;
		this.author = author;
		this.text = text;
		this.isRead = false;
		this.sentAt=sentAt;
	}

/*
	public Message(Long idDestinataire, Utilisateur expediteur, String content) {
		super();
		this.idDestinataire = idDestinataire;
		this.expediteur = expediteur;
		this.content = content;
		//this.dateMessage  = new Date();
		this.read=false;
	}*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdDestinataire() {
		return idDestinataire;
	}

	public void setIdDestinataire(Long idDestinataire) {
		this.idDestinataire = idDestinataire;
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

	public Boolean getIsRead() {
		return isRead;
	}

	public void setIsRead(Boolean isRead) {
		this.isRead = isRead;
	}

	public String getSentAt() {
		return sentAt;
	}

	public void setSentAt(String sentAt) {
		this.sentAt = sentAt;
	}

	

	
	
	
	
}
