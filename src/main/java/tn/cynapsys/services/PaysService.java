package tn.cynapsys.services;

import tn.cynapsys.entities.Pays;

public interface PaysService {

	
	Pays getPaysById(Long id);
	Pays updatePays(Pays p);
	Pays GetByCities(String city);
}
