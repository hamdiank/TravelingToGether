package tn.cynapsys.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.entities.Voiture;
import tn.cynapsys.services.VoitureService;
@CrossOrigin(origins="*")
@RestController
public class VoitureRestController {
	@Autowired
	private VoitureService voitureService;
	
	@RequestMapping(value = "/voitures", method = RequestMethod.GET)
	public List <Voiture> listVoiture() {
		return voitureService.listVoiture();
	}


	@RequestMapping(value = "/voitures/{id}", method = RequestMethod.GET)
	public Voiture getVoiture(@PathVariable("id")Long id) {
		return voitureService.getVoiture(id);
	}
	@RequestMapping(value = "/voitures", method=RequestMethod.POST)
	public Voiture save(@RequestBody Voiture v) {
		return voitureService.saveVoiture(v);
	}
	@RequestMapping(value = "/voitures/{id}", method=RequestMethod.PUT)
	public Voiture update(@RequestBody Voiture v, @PathVariable Long id) {
		v.setId(id);
		return voitureService.update(v, id);
	}
	
	@RequestMapping(value = "/voitures/{id}", method=RequestMethod.DELETE)
	public void delete( @PathVariable Long id) {
		voitureService.delete(id);
	}
}
