package tn.cynapsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.dao.CityRepository;
import tn.cynapsys.entities.City;
import tn.cynapsys.services.CityService;


@RestController
@RequestMapping(value = "/city")
public class CityRestController {

	
	@Autowired
	private CityRepository cityRepository;
	@Autowired
	private CityService cityService;
	
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<City> city() {

		return cityRepository.findAll();
	}
	
	@RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
	public ResponseEntity<City> cityById(@PathVariable Long id) {
		City city = cityRepository.findOne(id);
		if (city == null) {
			return new ResponseEntity<City>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<City>(city, HttpStatus.OK);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
