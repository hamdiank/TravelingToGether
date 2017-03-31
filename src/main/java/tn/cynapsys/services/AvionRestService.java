package tn.cynapsys.services;
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

import tn.cynapsys.dao.AvionRepository;
import tn.cynapsys.entities.Avion;
import tn.cynapsys.entities.Voiture;

import java.util.List;

@CrossOrigin(origins="*")
@RestController

public class AvionRestService {

	@Autowired
	private AvionRepository avionRepository;
	@RequestMapping(value = "/avions", method = RequestMethod.GET)
	public List <Avion> listProduit() {
		return avionRepository.findAll();
	}
	@RequestMapping(value = "/chercherAvions", method = RequestMethod.GET)
	public Page<Avion> chercher(
			@RequestParam(defaultValue="", name="motcle") String mc,
			@RequestParam(defaultValue="0", name="page")int page,
			@RequestParam(defaultValue="5", name="size")int size) 
	{
		return (Page<Avion>) avionRepository.chercherAvions("%"+ mc+ "%",new PageRequest(page, size));
	}
	@RequestMapping(value = "/avions/{id}", method = RequestMethod.GET)
	public Avion getAvion(@PathVariable("id")Long id) {
		return avionRepository.findOne(id);
	}
	@RequestMapping(value = "/avions", method=RequestMethod.POST)
	public Avion save(@RequestBody Avion a) {
		return avionRepository.save(a);
	}
	@RequestMapping(value = "/avions/{id}", method=RequestMethod.PUT)
	public Avion update(@RequestBody Avion a, @PathVariable Long id) {
		a.setId(id);
		return avionRepository.saveAndFlush(a);
	}
	
	@RequestMapping(value = "/avions/{id}", method=RequestMethod.DELETE)
	public void delete(@RequestBody Avion a, @PathVariable Long id) {
		avionRepository.delete(id);
	}
}
