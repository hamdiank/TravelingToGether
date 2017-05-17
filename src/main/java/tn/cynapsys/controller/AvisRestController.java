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

import tn.cynapsys.dao.AvisRepository;
import tn.cynapsys.entities.Avis;
import tn.cynapsys.entities.Message;
import tn.cynapsys.services.AvisService;

@RestController
@RequestMapping(value = "/avis")
public class AvisRestController {

	@Autowired
	private AvisService avisService;
	@Autowired
	private AvisRepository avisRepository;
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Avis> avis() {
return avisService.getAll(); 
	}
	
	
	@RequestMapping(value = "/avis/{id}", method = RequestMethod.GET)
	public List<Avis> AvisByIdDest(@PathVariable Long id) {
		return avisService.getAvisByIdDestinataire(id);
		
	}
	
	
	
	
	
}
