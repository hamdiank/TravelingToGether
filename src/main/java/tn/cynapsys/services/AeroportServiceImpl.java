package tn.cynapsys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cynapsys.dao.AeroportRepository;
import tn.cynapsys.entities.Aeroport;

@Service
public class AeroportServiceImpl implements AeroportService {

	@Autowired
	AeroportRepository aeroportRepository;

	@Override
	public List<Aeroport> getAllAeroport() {

		return aeroportRepository.findAll();
	}

	@Override
	public Aeroport getAeroportById(Long id) {

		return aeroportRepository.findOne(id);
	}

	@Override
	public Aeroport updateAeroport(Aeroport a) {

		return aeroportRepository.saveAndFlush(a);
	}

	@Override
	public void deleteAeroport(Aeroport a) {
		aeroportRepository.delete(a);

	}

}
