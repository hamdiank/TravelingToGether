package tn.cynapsys.entities;


import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Message {

	
	@Id
	@GeneratedValue
	private Long idMessage;
	
	private Long idDestinataire;
	
	@ManyToOne
	@JoinColumn(name="ID_EXPEDITEUR")
	private Utilisateur expediteur;

	private String content ;

	//private Date dateMessage;
	@JsonFormat(pattern = "dd::MM::yyyy")
	LocalDateTime dateMessage;
	private Boolean read;
	
	public Message() {
		super();
	}

	public Message(Long idDestinataire, Utilisateur expediteur, String content) {
		super();
		this.idDestinataire = idDestinataire;
		this.expediteur = expediteur;
		this.content = content;
		this.dateMessage  = LocalDateTime.now();
		this.read=false;
	}

	public Long getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Long idMessage) {
		this.idMessage = idMessage;
	}

	public Long getIdDestinataire() {
		return idDestinataire;
	}

	public void setIdDestinataire(Long idDestinataire) {
		this.idDestinataire = idDestinataire;
	}

	public Utilisateur getExpediteur() {
		return expediteur;
	}

	public void setExpediteur(Utilisateur expediteur) {
		this.expediteur = expediteur;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getDateMessage() {
		return dateMessage;
	}

	public void setDateMessage(LocalDateTime dateMessage) {
		this.dateMessage = dateMessage;
	}

	public Boolean getRead() {
		return read;
	}

	public void setRead(Boolean read) {
		this.read = read;
	}

	
	
	
	
}
