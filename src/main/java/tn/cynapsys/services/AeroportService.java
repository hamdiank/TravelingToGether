package tn.cynapsys.services;

import java.util.List;

import tn.cynapsys.entities.Aeroport;

public interface AeroportService {

	List<Aeroport> getAllAeroport();
	Aeroport getAeroportById(Long id);
	Aeroport updateAeroport(Aeroport a);
	public void deleteAeroport(Aeroport a);
}
