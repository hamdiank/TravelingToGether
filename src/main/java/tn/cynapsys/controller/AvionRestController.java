package tn.cynapsys.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.entities.Avion;
import tn.cynapsys.entities.Pays;
import tn.cynapsys.services.AvionService;


@CrossOrigin(origins="*")
@RestController
public class AvionRestController {

	@Autowired
	private AvionService avionService;
	
	
	@RequestMapping(value = "/avions", method = RequestMethod.GET)
	public List <Avion> listAvion() {
		return avionService.listAvion();
	}

	@RequestMapping(value = "/avions/{id}", method = RequestMethod.GET)
	public Avion getAvion(@PathVariable("id")Long id) {
		return avionService.getAvion(id);
	}
	@RequestMapping(value = "/avions/{nom}", method=RequestMethod.POST)
	public Avion save(@PathVariable String  nom) {
		Avion a=new Avion (nom);
		return avionService.saveAvion(a);
	}
	@RequestMapping(value = "/avions/{id}", method=RequestMethod.PUT)
	public Avion update(@RequestBody Avion avion, @PathVariable Long id) {
		Avion a=avionService.getAvion(id);
		
		if(a==null)
			return null;
		return avionService.update(avion);
	}
	
	@RequestMapping(value = "/avions/{id}", method=RequestMethod.DELETE)
	public void delete( @PathVariable Long id) {
		avionService.delete(id);
	}
}
