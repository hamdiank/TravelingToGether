package tn.cynapsys.services;

import java.util.List;

import tn.cynapsys.entities.City;

public interface CityService {

	List<City> getAllCity();
	City getCityById(Long id);
	City updateCity(City c);
	public void deleteCity(City c);
}
