package tn.cynapsys.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

@Entity
public class Pays implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idPays;
	@Column(name = "nom")
	private String nom;

	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "idPays") 
	private List<City> cities = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "idPays")
	private List<Aeroport> aeroports = new ArrayList<>();
	
	@OneToMany(cascade=CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name = "idPays") 
	private List<Station> stations = new ArrayList<>();

	public Pays() {
		super();
	}

	

	public Pays(String nom, List<City> cities, List<Aeroport> aeroports, List<Station> stations) {
		super();
		this.nom = nom;
		this.cities = cities;
		this.aeroports = aeroports;
		this.stations = stations;
	}



	public Long getIdPays() {
		return idPays;
	}

	public void setIdPays(Long idPays) {
		this.idPays = idPays;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}



	public List<Aeroport> getAeroports() {
		return aeroports;
	}



	public void setAeroports(List<Aeroport> aeroports) {
		this.aeroports = aeroports;
	}



	public List<Station> getStations() {
		return stations;
	}



	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	

	

}
