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

import tn.cynapsys.entities.AnnonceTrain;
import tn.cynapsys.entities.AnnonceVol;
import tn.cynapsys.services.AnnonceTrainService;


@CrossOrigin(origins="*")
@RestController
public class AnnonceTrainRestController {
	@Autowired
	AnnonceTrainService annonceTrainService;
	
	@RequestMapping(value = "/AnnoncesTrain", method = RequestMethod.GET)
	public List<AnnonceTrain> listAnnoncesVol() {
		
		return annonceTrainService.listAnnonceTrain();
		
	}
	@RequestMapping(value = "/AjouterAnnonceTrain/{id}", method = RequestMethod.PUT)
	public AnnonceTrain ajouterAnnonceTrain(@RequestBody AnnonceTrain a, @PathVariable Long id) {
		return annonceTrainService.ajouterAnnonceTrain(a, id);
		
	}
	@RequestMapping(value = "/getAnnonceTrainById/{id}", method = RequestMethod.PUT)
	public AnnonceTrain getAnnonceTrainById( @PathVariable Long id) {
		return annonceTrainService.getAnnonceTrainById(id);
		
	}
	@RequestMapping(value = "/MesAnnoncesTrain", method = RequestMethod.PUT)
	public List<AnnonceTrain> listeMesAnnoncesTrain(@RequestParam Long id) {
		return annonceTrainService.maListeAnnonceTrain(id);
		
	}
	@RequestMapping(value = "/updateAnnonceTrain/{id}", method = RequestMethod.PUT)
	public AnnonceTrain updateAnnonceVol(@RequestBody AnnonceTrain a, @PathVariable Long id) {
		return annonceTrainService.updateAnnonceTrain(a, id);
		
	}
	@RequestMapping(value = "/deleteAnnonceTrain/{id}", method = RequestMethod.DELETE)
	public void deleteAnnonceTrain( @PathVariable Long id) {
		annonceTrainService.deleteAnnonceTrain(id);
		
	}
}
