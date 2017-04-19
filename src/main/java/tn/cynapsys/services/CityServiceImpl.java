package tn.cynapsys.services;

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
		public City updatePays(City c) {
			cityRepository.saveAndFlush(c);
			return c;
		}

	}