package tn.cynapsys.services;

import java.util.List;

import tn.cynapsys.entities.Avis;

public interface AvisService {

	List<Avis> getAll();


	List<Avis> getAvisByIdDestinataire(Long id);

	Avis getAvisById(Long id);

	Avis saveAvis(Avis a);
	void DeleteAvis(Avis a);
	Avis UpdateAvis(Avis a);
	
}
