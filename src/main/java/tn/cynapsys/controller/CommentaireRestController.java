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
import tn.cynapsys.entities.Annonce;
import tn.cynapsys.entities.Commentaire;
import tn.cynapsys.entities.Utilisateur;
import tn.cynapsys.services.AnnonceService;
import tn.cynapsys.services.CommentaireService;

@RestController
@RequestMapping(value = "/commentaire")
public class CommentaireRestController {

	@Autowired
	private CommentaireService commentaireService;
	@Autowired
	private AnnonceService annonceService;
	@Autowired
	private UtilisateurRepository utilisateurService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Commentaire> commentaire() {
		return commentaireService.getAll();
	}

	@RequestMapping(value = "/commentaire/{id}", method = RequestMethod.GET)
	public List<Commentaire> CommentaireByAnnonce(@PathVariable Long id) {
		System.out.println("id    "+id);
		Annonce a = annonceService.getAnnonceCovoiById(id);
		System.out.println(a.getId());
		return commentaireService.getCommentaireByAnnonce(a);
	}

	@RequestMapping(value = "/add/{id}", method = RequestMethod.POST)
	public ResponseEntity<Commentaire> addAvist(@RequestBody Commentaire c, @PathVariable Long id) {

		Utilisateur u = utilisateurService.findUtilisateurByIdUtilisateur(c.getId());
		Annonce a = annonceService.getAnnonceCovoiById(id);
		Commentaire co = commentaireService.saveCommentaire(new Commentaire(a, u, c.getText(), c.getDate()));
		System.out.println(co.getText());
		return new ResponseEntity<Commentaire>(co, HttpStatus.OK);
	}
	
	/////////////////////Add commentaire and Get AnnonceVol///////////////////////
	
	@RequestMapping(value = "/addCommAnnonceVol/{id}", method = RequestMethod.POST)
	public ResponseEntity<Commentaire> addCommAnnonceVol(@RequestBody Commentaire c, @PathVariable Long id) {

		Utilisateur u = utilisateurService.findUtilisateurByIdUtilisateur(c.getId());
		Annonce a = annonceService.getAnnonceVolById(id);
		Commentaire co = commentaireService.saveCommentaire(new Commentaire(a, u, c.getText(), c.getDate()));
		System.out.println(co.getText());
		return new ResponseEntity<Commentaire>(co, HttpStatus.OK);
	}
	@RequestMapping(value = "/commentaireAnnonceVol/{id}", method = RequestMethod.GET)
	public List<Commentaire> CommentaireByAnnonceVol(@PathVariable Long id) {
		System.out.println("id    "+id);
		Annonce a = annonceService.getAnnonceVolById(id);
		System.out.println(a.getId());
		return commentaireService.getCommentaireByAnnonce(a);
	}
	
	///////////////////////Add Commentaire AnnonceTrain and Get commentaires/////////////////////////////////////////////////
	@RequestMapping(value = "/addCommAnnonceTrain/{id}", method = RequestMethod.POST)
	public ResponseEntity<Commentaire> addCommAnnonceTrain(@RequestBody Commentaire c, @PathVariable Long id) {

		Utilisateur u = utilisateurService.findUtilisateurByIdUtilisateur(c.getId());
		Annonce a = annonceService.getAnnonceTrainById(id);
		Commentaire co = commentaireService.saveCommentaire(new Commentaire(a, u, c.getText(), c.getDate()));
		System.out.println(co.getText());
		return new ResponseEntity<Commentaire>(co, HttpStatus.OK);
	}
	@RequestMapping(value = "/commentaireAnnonceTrain/{id}", method = RequestMethod.GET)
	public List<Commentaire> CommentaireByAnnonceTrain(@PathVariable Long id) {
		System.out.println("id    "+id);
		Annonce a = annonceService.getAnnonceTrainById(id);
		System.out.println(a.getId());
		return commentaireService.getCommentaireByAnnonce(a);
	}
	
	////////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/dell/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Commentaire> deleteCommentaire(@PathVariable Long id) {

		Commentaire a = commentaireService.getCommenataireById(id);

		if (a == null) {
			return new ResponseEntity<Commentaire>(HttpStatus.NO_CONTENT);

		} else {

			commentaireService.deleteCommentaire(a);
			System.out.print("commentaire supprimé");

			return new ResponseEntity<Commentaire>(a, HttpStatus.OK);
		}
	}
}
