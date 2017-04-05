package tn.cynapsys.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.entities.Avion;
import tn.cynapsys.entities.Utilisateur;
import tn.cynapsys.services.AvionService;
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

	@RequestMapping(value = "/utilisateurs/{id}", method = RequestMethod.GET)
	public Utilisateur getUtilisateur(@PathVariable("id")Long id) {
		return utilisateurService.getUtilisateur(id);
	}
	@RequestMapping(value = "/utilisateurs", method=RequestMethod.POST)
	public Utilisateur save(@RequestBody Utilisateur u) {
		return utilisateurService.saveUtilisateur(u);
	}
	@RequestMapping(value = "/utilisateurs/{id}", method=RequestMethod.PUT)
	public Utilisateur update(@RequestBody Utilisateur u, @PathVariable Long id) {
		u.setIdUtilisateur(id);
		return utilisateurService.update(u, id);
	}
	
	@RequestMapping(value = "/utilisateurs/{id}", method=RequestMethod.DELETE)
	public void delete(@RequestBody Utilisateur u, @PathVariable Long id) {
		utilisateurService.delete(id);
	}
}
