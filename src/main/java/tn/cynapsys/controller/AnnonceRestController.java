package tn.cynapsys.controller;

import java.util.Date;
import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.entities.Annonce;
import tn.cynapsys.entities.AnnonceCovoi;
import tn.cynapsys.services.AnnonceService;

@CrossOrigin(origins="*")
@RestController
public class AnnonceRestController {
	
	@Autowired
	private AnnonceService annonceService;
	
	@RequestMapping(value = "/annonces", method = RequestMethod.GET)
	public List<AnnonceCovoi> listAnnonceCovoi() {
		
		return annonceService.listAnnonceCovoi();
		
	}
	@RequestMapping(value = "/annonces", method=RequestMethod.POST)
	public Annonce save(@RequestBody Annonce a) {
		return annonceService.saveAnnonce(a);
	}
	@RequestMapping(value = "/ajoutAnnonce", method=RequestMethod.POST)
	public Annonce ajout(@RequestParam Date datePublication,@RequestParam Date dateDepart,
			@RequestParam String adresseDepart,@RequestParam String adresseArrivee,
			@RequestParam Long nombrePlaces, @RequestParam Long cotisation,@RequestParam Long id ) {
		return annonceService.addAnnonceCovoi(datePublication, dateDepart, adresseDepart, adresseArrivee, nombrePlaces, cotisation, id);
	}

}
