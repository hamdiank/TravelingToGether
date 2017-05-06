package tn.cynapsys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cynapsys.dao.PaysRepository;
import tn.cynapsys.entities.Pays;

@Service
public class PaysServiceImpl implements PaysService {
	@Autowired
	public PaysRepository paysRepository;

	@Override
	public Pays getPaysById(Long id) {
		return paysRepository.findOne(id);
	}

	@Override
	public Pays updatePays(Pays p) {

	return	paysRepository.saveAndFlush(p);
		//return p;
	}

	@Override
	public Pays GetByCities(String city) {

		return paysRepository.findOneByCities(city);
	}

	@Override
	public List<Pays> getAll() {
	
		return paysRepository.findAll();
	}

}
