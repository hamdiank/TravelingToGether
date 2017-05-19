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
	
	//////////////////////////////////////////////////////
	
	@RequestMapping(value = "/ajoutAnnonceCovoi", method=RequestMethod.PUT)
	public Annonce ajout(@RequestParam String datePublication,@RequestParam String dateDepart,
			@RequestParam String adresseDepart,@RequestParam String adresseArrivee,
			@RequestParam Long nombrePlaces, @RequestParam Long cotisation,@RequestParam Long id ) {
		System.out.println("hehehhehehehe");
		return annonceService.addAnnonceCovoi(datePublication, dateDepart, adresseDepart, adresseArrivee, nombrePlaces, cotisation, id);
	}
	@RequestMapping(value = "/maListeAnnonceCovoi", method=RequestMethod.GET)
	public  List <AnnonceCovoi> getMaListeAnnonceCovoi(@RequestParam Long id) {
		return annonceService.maListAnnonceCovoi(id);
	}
	
	@RequestMapping(value = "/updateAnnonceCovoi", method=RequestMethod.PUT)
	public AnnonceCovoi update(@RequestParam String datePublication,@RequestParam String dateDepart,
			@RequestParam String adresseDepart,@RequestParam String adresseArrivee,
			@RequestParam Long nombrePlaces, @RequestParam Long cotisation,@RequestParam Long id, @RequestParam Long idUtilisateur) {
		return annonceService.updateAnnonceCovoi(datePublication, dateDepart, adresseDepart, adresseArrivee, nombrePlaces, cotisation, id, idUtilisateur);
	}
	
	@RequestMapping(value = "/deleteAnnonceCovoi/{id}", method=RequestMethod.DELETE)
	public void deleteAnnonceCovoi( @PathVariable Long id) {
		annonceService.deleteAnnonceCovoi(id);
	}
	@RequestMapping(value = "/getAnnonceCovoiById", method=RequestMethod.GET)
	public AnnonceCovoi getAnnonceCovoiById( @RequestParam Long id) {
		return annonceService.getAnnonceCovoiById(id);
	}
	
	
		
	
	

}
