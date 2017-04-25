package tn.cynapsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.dao.CityRepository;
import tn.cynapsys.entities.City;
import tn.cynapsys.entities.Pays;
import tn.cynapsys.services.CityService;


@RestController
@RequestMapping(value = "/city")
public class CityRestController {

	
	
	@Autowired
	private CityService cityService;
	@Autowired
	private CityRepository cityRepository;
	
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<City> city() {

		return cityService.getAllCity();
	}
	
	@RequestMapping(value = "/city/{nom}", method = RequestMethod.POST)
	public ResponseEntity<City> addCity(@PathVariable String nom) {
		
		
		return new ResponseEntity<City>(cityRepository.save(new City(nom)), HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
	public ResponseEntity<City> cityById(@PathVariable Long id) {
		City city = cityService.getCityById(id);
		if (city == null) {
			return new ResponseEntity<City>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<City>(city, HttpStatus.OK);
		}
	}
	
	
	@RequestMapping(value = "/citydel/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<City> deleteCity(@PathVariable Long id) {
	
	
		City city = cityService.getCityById(id);
		
			if (city == null) {
			return new ResponseEntity<City>(HttpStatus.NO_CONTENT);
		
		} else {
			
			cityService.deleteCity(city);
			
			return new ResponseEntity<City>(city, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/updateCity/{id}", method = RequestMethod.PUT)
	public ResponseEntity<City> updateCity(@PathVariable Long id,@RequestBody  City city) {
		
		City c = cityService.getCityById(id);
		
		if (c == null) {
		return new ResponseEntity<City>(HttpStatus.NO_CONTENT);
	
	} else {
		System.out.println(id+" "+city);
	System.out.println(city.getNom());
	cityService.updateCity(city);
		
			
		 System.out.println(cityService.getCityById(id).getNom());
			return new ResponseEntity<City>(city, HttpStatus.OK);
		}
	}
	
	
	
	
	
	
	
	
	
}
