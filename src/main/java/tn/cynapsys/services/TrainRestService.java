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

import tn.cynapsys.dao.TrainRepository;
import tn.cynapsys.entities.Train;
import tn.cynapsys.entities.Voiture;
@CrossOrigin(origins="*")
@RestController
public class TrainRestService {

	@Autowired
	private TrainRepository trainRepository;
	@RequestMapping(value = "/trains", method = RequestMethod.GET)
	public List <Train> listTrain() {
		return trainRepository.findAll();
	}
	@RequestMapping(value = "/chercherTrains", method = RequestMethod.GET)
	public Page<Train> chercher(
			@RequestParam(defaultValue="", name="motcle") String mc,
			@RequestParam(defaultValue="0", name="page")int page,
			@RequestParam(defaultValue="5", name="size")int size) 
	{
		return (Page<Train>) trainRepository.chercherTrains("%"+ mc+ "%",new PageRequest(page, size));
	}
	@RequestMapping(value = "/trains/{id}", method = RequestMethod.GET)
	public Train getProduit(@PathVariable("id")Long id) {
		return trainRepository.findOne(id);
	}
	@RequestMapping(value = "/trains", method=RequestMethod.POST)
	public Train save(@RequestBody Train t) {
		return trainRepository.save(t);
	}
	@RequestMapping(value = "/trains/{id}", method=RequestMethod.PUT)
	public Train update(@RequestBody Train t, @PathVariable Long id) {
		t.setId(id);
		return trainRepository.saveAndFlush(t);
	}
	
	@RequestMapping(value = "/trains/{id}", method=RequestMethod.DELETE)
	public void delete(@RequestBody Train p, @PathVariable Long id) {
		 trainRepository.delete(id);
	}
}
