package tn.cynapsys.services;

import java.util.List;

import tn.cynapsys.entities.Pays;

public interface PaysService {

	List<Pays>getAll();
	Pays getPaysById(Long id);
	Pays updatePays(Pays p);
	Pays GetByCities(String city);
}
