package tn.cynapsys.entities;

import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Utilisateur {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idUtilisateur;
	
	private String nom;
	private String prenom;
	private String email;
	private String motDePasse;
	private String dateNaissance;
	private String Profession;
	private String sexe;
	private String numTelephone;
	private String login;
	private boolean etat ;
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="CodeRole")
	private Role  role;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="author")
	private List<Message> messages;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="utilisateur")

	 @JsonIgnoreProperties(value = "utilisateur")
	private Collection<Annonce> annonces ;

	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String nom, String prenom, String email, String motDePasse, String dateNaissance,
			String profession, String sexe, String numTelephone, String login, boolean etat, Role role,String description) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.motDePasse = motDePasse;
		this.dateNaissance = dateNaissance;
		Profession = profession;
		this.sexe = sexe;
		this.numTelephone = numTelephone;
		this.login = login;
		this.etat = etat;
		this.role = role;
		this.description=description;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	public String getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(String dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getProfession() {
		return Profession;
	}

	public void setProfession(String profession) {
		Profession = profession;
	}

	public String getSexe() {
		return sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public String getNumTelephone() {
		return numTelephone;
	}

	public void setNumTelephone(String numTelephone) {
		this.numTelephone = numTelephone;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public boolean isEtat() {
		return etat;
	}

	public void setEtat(boolean etat) {
		this.etat = etat;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Collection<Annonce> getAnnonces() {
		return annonces;
	}

	public void setAnnonces(Collection<Annonce> annonces) {
		this.annonces = annonces;
	}
	

	
}
