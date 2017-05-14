package tn.cynapsys.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.entities.Utilisateur;
import tn.cynapsys.services.UtilisateurService;

@CrossOrigin(origins="*")
@RestController
public class UtilisateurRestController {
	

	@Autowired
	private UtilisateurService utilisateurService;
	
	
	@RequestMapping(value = "/utilisateurs", method = RequestMethod.GET)
	public List <Utilisateur> listUtilisateur() {
		return utilisateurService.listUtilisateur();
	}

	@RequestMapping(value = "/utilisateur/{id}", method = RequestMethod.GET)
	public Utilisateur getUtilisateur(@PathVariable("id")Long id) {
		return utilisateurService.getUtilisateur(id);
	}
	@RequestMapping(value = "/utilisateurs", method=RequestMethod.POST)
	public Utilisateur save(@RequestBody Utilisateur u) {
		return utilisateurService.saveUtilisateur(u);
	}
	@RequestMapping(value = "/utilisateur", method=RequestMethod.PUT)
	public Utilisateur update(@RequestBody Utilisateur u) {
		System.out.println(u.getLogin());
		System.out.println(u.getEmail());
		System.out.println(u.getNom());
		System.out.println(u.getNumTelephone());
		System.out.println(u.getPrenom());
		System.out.println(u.getMotDePasse());
		System.out.println(u.getDateNaissance());
		System.out.println(u.getDescription());
		return utilisateurService.update(u);
	}
	
	@RequestMapping(value = "/utilisateur/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		utilisateurService.delete(id);
	}
	@RequestMapping(value = "/countOfUsers", method=RequestMethod.GET)
	public Long getCount() {
		return utilisateurService.countOfUsers();
	}
}
