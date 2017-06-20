package tn.cynapsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.entities.Annonce;
import tn.cynapsys.entities.AnnonceCovoi;
import tn.cynapsys.entities.Pays;
import tn.cynapsys.entities.Utilisateur;
import tn.cynapsys.services.AnnonceService;

@CrossOrigin(origins="*")
@RestController
public class AnnonceRestController {
	
	@Autowired
	private AnnonceService annonceService;
	

	@RequestMapping(value = "/annonces", method=RequestMethod.POST)
	public Annonce save(@RequestBody Annonce a) {
		return annonceService.saveAnnonce(a);
	}
	
	/////////////////////Annonce Covoiturage ////////////////////////////////
	
	@RequestMapping(value = "/annonces", method = RequestMethod.GET)
	public List<AnnonceCovoi> listAnnonceCovoi() {
		
		return annonceService.listAnnonceCovoi();
		
	}
	
	@RequestMapping(value = "/annoncesByPage/{page}", method = RequestMethod.GET)
	public Page<AnnonceCovoi> listAnnonceCovoiByPage(@PathVariable int page,@RequestParam(name="size",defaultValue="1") int size) {
		return annonceService.getAllAnnounceByPage(new PageRequest(page,size));
	}

	
	@RequestMapping(value = "/ajoutAnnonceCovoi", method=RequestMethod.PUT)
	public Annonce ajout(@RequestParam String heureDepart,@RequestParam String dateDepart, @RequestParam String paysDepart,
			@RequestParam String villeDepart, @RequestParam String paysArrivee,@RequestParam String villeArrivee,@RequestParam Long nombrePlaces,
			@RequestParam Long cotisation, @RequestParam String cotType, @RequestParam Long id, @RequestParam String description ) {
		
		return annonceService.addAnnonceCovoi(heureDepart, dateDepart, paysDepart, villeDepart, paysArrivee, villeArrivee, nombrePlaces, cotisation,cotType, id, description);

	}
	/*@RequestMapping(value = "/maListeAnnonceCovoi/{id}", method=RequestMethod.GET)
	public  List <AnnonceCovoi> getMaListeAnnonceCovoi(@PathVariable Long id) {
		return annonceService.maListAnnonceCovoi(id);
	}*/
	
	@RequestMapping(value = "/maListeAnnonceCovoi", method=RequestMethod.GET)
	public  List <AnnonceCovoi> getMaListeAnnonceCovoi(@RequestParam Long id) {
		return annonceService.maListAnnonceCovoi(id);
	}
	
	@RequestMapping(value = "/updateAnnonceCovoi", method=RequestMethod.PUT)
	public AnnonceCovoi update(@RequestParam String heureDepart,@RequestParam String dateDepart, @RequestParam String paysDepart,
			@RequestParam String villeDepart, @RequestParam String paysArrivee,@RequestParam String villeArrivee,@RequestParam Long nombrePlaces,
			@RequestParam Long cotisation,@RequestParam String cotType, @RequestParam String description, @RequestParam Long id, @RequestParam Long idUtilisateur) {
		return annonceService.updateAnnonceCovoi(heureDepart, dateDepart, paysDepart, villeDepart, paysArrivee, villeArrivee, nombrePlaces, cotisation,cotType, description, id, idUtilisateur);
	}
	
	@RequestMapping(value = "/deleteAnnonceCovoi/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<AnnonceCovoi> deleteAnnonceCovoi( @PathVariable Long id) {
		AnnonceCovoi annonceCovoi = annonceService.getAnnonceCovoiById(id);
		if (annonceCovoi == null) {
			return new ResponseEntity<AnnonceCovoi>(HttpStatus.NO_CONTENT);
		}
		else{
		annonceService.deleteAnnonceCovoi(id);
		return new ResponseEntity<AnnonceCovoi>(annonceCovoi, HttpStatus.OK);
		}
		}
	@RequestMapping(value = "/getAnnonceCovoiById/{id}", method=RequestMethod.GET)
	public AnnonceCovoi getAnnonceCovoiById( @PathVariable("id") Long id) {
		return annonceService.getAnnonceCovoiById(id);
	}

///////////////////////////////////////////////////////////////////
	
		
	
	

}
