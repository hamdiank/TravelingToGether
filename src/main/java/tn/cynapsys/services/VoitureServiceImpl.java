package tn.cynapsys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cynapsys.dao.VoitureRepository;
import tn.cynapsys.entities.Voiture;

@Service
public class VoitureServiceImpl implements VoitureService {

	@Autowired
	private VoitureRepository voitureRepository;

	@Override
	public List<Voiture> listVoiture() {

		return voitureRepository.findAll();
	}

	@Override
	public Voiture saveVoiture(Voiture v) {
		return voitureRepository.save(v);
	}

	@Override
	public Voiture getVoiture(Long id) {

		return voitureRepository.findOne(id);
	}

	@Override
	public Voiture update(Voiture v, Long id) {

		return voitureRepository.saveAndFlush(v);
	}

	@Override
	public void delete(Long id) {
		voitureRepository.delete(id);

	}

}
