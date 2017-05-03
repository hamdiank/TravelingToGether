package tn.cynapsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.entities.Train;
import tn.cynapsys.services.TrainService;

@CrossOrigin(origins = "*")
@RestController
public class TrainRestController {

	@Autowired
	private TrainService trainService;

	@RequestMapping(value = "/trains", method = RequestMethod.GET)
	public List<Train> listTrain() {
		return trainService.listTrain();
	}

	@RequestMapping(value = "/trains/{id}", method = RequestMethod.GET)
	public Train getTrain(@PathVariable("id") Long id) {
		return trainService.getTrain(id);
	}

	@RequestMapping(value = "/trains/{nom}", method = RequestMethod.POST)
	public Train save(@PathVariable String nom) {
		System.out.println(nom);
		Train t = new Train(nom);
		return trainService.saveTrain(t);
	}

	@RequestMapping(value = "/trains", method = RequestMethod.PUT)
	public Train update(@RequestBody Train t) {
		
		return trainService.update(t);
	}

	@RequestMapping(value = "/trains/{id}", method = RequestMethod.DELETE)
	public void delete( @PathVariable Long id) {
	
		trainService.delete(id);
	}
}
