package tn.cynapsys.entities;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Role {
	
	@Id @GeneratedValue
	private Long idRole;
	
	private String typeRole;
	
	@OneToMany(fetch = FetchType.LAZY,mappedBy="role")
	private Collection <Utilisateur> utilisateur;
	
	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Role(String typeRole) {
		super();
		this.typeRole = typeRole;
	}
	public Long getIdRole() {
		return idRole;
	}
	public void setIdRole(Long idRole) {
		this.idRole = idRole;
	}
	public String getTypeRole() {
		return typeRole;
	}
	public void setTypeRole(String typeRole) {
		this.typeRole = typeRole;
	}
	public Collection<Utilisateur> getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Collection<Utilisateur> utilisateur) {
		this.utilisateur = utilisateur;
	}

}
