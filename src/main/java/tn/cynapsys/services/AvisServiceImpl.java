package tn.cynapsys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cynapsys.dao.AvisRepository;
import tn.cynapsys.dao.CityRepository;
import tn.cynapsys.entities.Avis;

@Service
public class AvisServiceImpl implements AvisService {

	@Autowired
	public AvisRepository avisRepository;

	@Override
	public List<Avis> getAll() {

		return avisRepository.findAll();
	}

	@Override
	public List<Avis> getAvisByIdDestinataire(Long id) {

		return avisRepository.findByIdDest(id);
	}

	@Override
	public Avis getAvisById(Long id) {

		return avisRepository.findOne(id);
	}

	@Override
	public Avis saveAvis(Avis a) {

		return avisRepository.save(a);
	}

	@Override
	public void DeleteAvis(Avis a) {

		avisRepository.delete(a);
	}

	@Override
	public Avis UpdateAvis(Avis a) {

		return avisRepository.saveAndFlush(a);
	}

}
