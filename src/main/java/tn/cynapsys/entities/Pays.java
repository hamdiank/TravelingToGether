package tn.cynapsys.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
public class Pays implements Serializable {
	@Id
	@GeneratedValue
	private Long idPays;
	@Column(name = "nom")
	private String nom;
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(name = "City", joinColumns = { @JoinColumn(name = "idPays") })

	private List<String> cities = new ArrayList<>();
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(name = "Aeroport", joinColumns = { @JoinColumn(name = "idPays") })
	private List<String> aeroports = new ArrayList<>();
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@ElementCollection
	@CollectionTable(name = "Station", joinColumns = { @JoinColumn(name = "idPays") })
	private List<String> stations = new ArrayList<>();

	public Pays() {
		super();
	}

	public Pays(String nom, List<String> cities, List<String> aeroports, List<String> stations) {
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

	public List<String> getCities() {
		return cities;
	}

	public void setCities(List<String> cities) {
		this.cities = cities;
	}

	public List<String> getAeroports() {
		return aeroports;
	}

	public void setAeroports(List<String> aeroports) {
		this.aeroports = aeroports;
	}

	public List<String> getStations() {
		return stations;
	}

	public void setStations(List<String> stations) {
		this.stations = stations;
	}

}
