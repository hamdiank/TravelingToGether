package tn.cynapsys.services;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.dao.VoitureRepository;
import tn.cynapsys.entities.Voiture;
@CrossOrigin(origins="*")
@RestController
public class VoitureRestService {
	@Autowired
	private VoitureRepository voitureRepository;
	@RequestMapping(value = "/voitures", method = RequestMethod.GET)
	public List <Voiture> listVoiture() {
		return voitureRepository.findAll();
	}
	@RequestMapping(value = "/chercherVoitures", method = RequestMethod.GET)
	public Page<Voiture> chercher(
			@RequestParam(defaultValue="", name="motcle") String mc,
			@RequestParam(defaultValue="0", name="page")int page,
			@RequestParam(defaultValue="5", name="size")int size) 
	{
		return (Page<Voiture>) voitureRepository.chercherVoitures("%"+ mc+ "%",new PageRequest(page, size));
	}

	@RequestMapping(value = "/voitures/{id}", method = RequestMethod.GET)
	public Voiture getProduit(@PathVariable("id")Long id) {
		return voitureRepository.findOne(id);
	}
	@RequestMapping(value = "/voitures", method=RequestMethod.POST)
	public Voiture save(@RequestBody Voiture p) {
		return voitureRepository.save(p);
	}
	@RequestMapping(value = "/voitures/{id}", method=RequestMethod.PUT)
	public Voiture update(@RequestBody Voiture p, @PathVariable Long id) {
		p.setId(id);
		return voitureRepository.saveAndFlush(p);
	}
	
	@RequestMapping(value = "/voitures/{id}", method=RequestMethod.DELETE)
	public void delete(@RequestBody Voiture p, @PathVariable Long id) {
		 voitureRepository.delete(id);
	}
}
