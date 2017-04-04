package tn.cynapsys.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cynapsys.dao.AvionRepository;
import tn.cynapsys.entities.Avion;

@Service
public class AvionServiceImpl implements AvionService{
	
	
	@Autowired
	public AvionRepository avionRepository;

	@Override
	public List <Avion> listAvion() {
		return avionRepository.findAll();
	}

	@Override
	public Avion getAvion(Long id) {
		return avionRepository.findOne(id);
	}

	@Override
	public Avion saveAvion(Avion a) {
		return avionRepository.save(a);
	}

	@Override
	public Avion update(Avion a, Long id) {
		
		return avionRepository.saveAndFlush(a);
	}

	@Override
	public void delete( Long id) {
		avionRepository.delete(id);
		
	}

}
