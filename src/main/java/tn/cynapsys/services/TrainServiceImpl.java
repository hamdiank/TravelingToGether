package tn.cynapsys.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cynapsys.dao.TrainRepository;
import tn.cynapsys.entities.Train;


@Service
public class TrainServiceImpl implements TrainService{
	
	@Autowired
	private TrainRepository trainRepository;

	@Override
	public List<Train> listTrain() {

		return trainRepository.findAll();
	}

	@Override
	public Train getTrain(Long id) {
		
		return trainRepository.findOne(id);
	}

	@Override
	public Train saveTrain(Train t) {
		
		return trainRepository.save(t);
	}

	@Override
	public Train update(Train t) {

		return trainRepository.saveAndFlush(t);
	}

	@Override
	public void delete(Long id) {
		trainRepository.delete(id);
		
	}

}
