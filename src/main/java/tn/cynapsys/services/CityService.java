package tn.cynapsys.services;

import tn.cynapsys.entities.City;

public interface CityService {

	
	City getCityById(Long id);
	City updatePays(City c);
}
