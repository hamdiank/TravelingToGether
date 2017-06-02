package tn.cynapsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.entities.AnnonceVol;
import tn.cynapsys.services.AnnonceVolService;


@CrossOrigin(origins="*")
@RestController
public class AnnonceVolRestController {
	
	@Autowired
	AnnonceVolService annonceVolService;
	
	@RequestMapping(value = "/AnnoncesVol", method = RequestMethod.GET)
	public List<AnnonceVol> listAnnoncesVol() {
		
		return annonceVolService.listAnnonceVol();
		
	}
	
	@RequestMapping(value = "/MesAnnonceVol", method = RequestMethod.GET)
	public List<AnnonceVol> listeMesAnnoncesVol(@RequestParam Long id) {
		return annonceVolService.maListeAnnonceVol(id);
		
	}
	@RequestMapping(value = "/AjouterAnnonceVol/{id}", method = RequestMethod.PUT)
	public AnnonceVol ajouterAnnonceVol(@RequestBody AnnonceVol a, @PathVariable Long id) {
		return annonceVolService.ajouterAnnonceVol(a, id);
		
	}
	
	@RequestMapping(value = "/updateAnnonceVol/{id}", method = RequestMethod.PUT)
	public AnnonceVol updateAnnonceVol(@RequestBody AnnonceVol a, @PathVariable Long id) {
		return annonceVolService.updateAnnonceVol(a, id);
		
	}
	@RequestMapping(value = "/deleteAnnonceVol/{id}", method = RequestMethod.DELETE)
	public void deleteAnnonceVol( @PathVariable Long id) {
		annonceVolService.deleteAnnonceVol(id);
		
	}
	
	@RequestMapping(value = "/getAnnonceVolById/{id}", method = RequestMethod.PUT)
	public AnnonceVol getAnnonceVolById( @PathVariable Long id) {
		return annonceVolService.getAnnonceVolById(id);
		
	}
	
	
	
	
	

}
