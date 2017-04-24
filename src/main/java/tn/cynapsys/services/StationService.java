package tn.cynapsys.services;

import java.util.List;

import tn.cynapsys.entities.Station;

public interface StationService {

	List<Station> getAllStation();
	Station getStationById(Long id);
	Station updateStation(Station s);
	public void deleteStation(Station s);
}
