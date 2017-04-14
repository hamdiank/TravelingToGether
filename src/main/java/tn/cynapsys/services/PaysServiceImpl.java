package tn.cynapsys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cynapsys.dao.PaysRepository;
import tn.cynapsys.entities.Pays;

@Service
public class PaysServiceImpl  implements PaysService{
	@Autowired
	public PaysRepository paysRepository;
	@Override
	public Pays getPaysById(Long id) {
		return paysRepository.findOne(id);
	}

	@Override
	public Pays updatePays(Pays p) {
	
		paysRepository.saveAndFlush(p);
		return p;
	}

}