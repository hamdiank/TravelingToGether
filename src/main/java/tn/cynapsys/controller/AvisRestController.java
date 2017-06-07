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

import tn.cynapsys.dao.UtilisateurRepository;
import tn.cynapsys.entities.Avis;
import tn.cynapsys.entities.Utilisateur;
import tn.cynapsys.services.AvisService;

@RestController
@RequestMapping(value = "/avis")
public class AvisRestController {

	@Autowired
	private AvisService avisService;
	@Autowired
	private UtilisateurRepository utilisateurService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Avis> avis() {
		return avisService.getAll();
	}

	@RequestMapping(value = "/avis/{id}", method = RequestMethod.GET)
	public List<Avis> AvisByIdDest(@PathVariable Long id) {
		return avisService.getAvisByIdDestinataire(id);

	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public Avis addAvist(@RequestBody Avis avis) {
		Utilisateur u = utilisateurService.findUtilisateurByIdUtilisateur(avis.getId());
		Avis a = new Avis(avis.getIdDest(), u, avis.getText(), avis.getDate());
		return avisService.saveAvis(a);

	}

	@RequestMapping(value = "/dell/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Avis> deleteAvis(@PathVariable Long id) {

		Avis a = avisService.getAvisById(id);

		if (a == null) {
			return new ResponseEntity<Avis>(HttpStatus.NO_CONTENT);

		} else {

			avisService.DeleteAvis(a);

			return new ResponseEntity<Avis>(a, HttpStatus.OK);
		}
	}
}
