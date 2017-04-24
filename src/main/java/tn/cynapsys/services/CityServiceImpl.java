package tn.cynapsys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cynapsys.dao.CityRepository;
import tn.cynapsys.entities.City;



	@Service
	public class CityServiceImpl  implements CityService{
		@Autowired
		public CityRepository cityRepository;


		@Override
		public City getCityById(Long id) {
			return cityRepository.findOne(id);
		}

		@Override
		public City updateCity(City c) {
			cityRepository.saveAndFlush(c);
			return c;
		}

		@Override
		public List<City> getAllCity() {
			
			return cityRepository.findAll();
		}

		@Override
		public void deleteCity(City c) {
			cityRepository.delete(c);
			
		}

	}