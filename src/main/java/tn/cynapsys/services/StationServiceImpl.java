package tn.cynapsys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cynapsys.dao.StationRepository;
import tn.cynapsys.entities.Station;
@Service
public class StationServiceImpl implements StationService {

	@Autowired
	StationRepository stationRepository;

	@Override
	public List<Station> getAllStation() {

		return stationRepository.findAll();
	}

	@Override
	public Station getStationById(Long id) {

		return stationRepository.findOne(id);
	}

	@Override
	public Station updateStation(Station s) {

		return stationRepository.saveAndFlush(s);
	}

	@Override
	public void deleteStation(Station s) {
		stationRepository.delete(s);

	}

}
