package tn.cynapsys.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.entities.Avion;
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
	@RequestMapping(value = "/avions", method=RequestMethod.POST)
	public Avion save(@RequestBody Avion a) {
		return avionService.saveAvion(a);
	}
	@RequestMapping(value = "/avions/{id}", method=RequestMethod.PUT)
	public Avion update(@RequestBody Avion a, @PathVariable Long id) {
		a.setId(id);
		return avionService.update(a, id);
	}
	
	@RequestMapping(value = "/avions/{id}", method=RequestMethod.DELETE)
	public void delete(@RequestBody Avion a, @PathVariable Long id) {
		avionService.delete(id);
	}
}
