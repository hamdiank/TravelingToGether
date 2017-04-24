package tn.cynapsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.entities.Aeroport;
import tn.cynapsys.services.AeroportService;


@RestController
@RequestMapping(value = "/aeroport")
public class AeroportRestController {

	@Autowired
	private AeroportService aeroportService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Aeroport> city() {

		return aeroportService.getAllAeroport();
	}

	@RequestMapping(value = "/aeroport/{id}", method = RequestMethod.GET)
	public ResponseEntity<Aeroport> stationyById(@PathVariable Long id) {
		Aeroport aeroport = aeroportService.getAeroportById(id);
		if (aeroport == null) {
			return new ResponseEntity<Aeroport>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Aeroport>(aeroport, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/aeroportDel/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Aeroport> deleteCity(@PathVariable Long id) {

		Aeroport aeroport = aeroportService.getAeroportById(id);

		if (aeroport == null) {
			return new ResponseEntity<Aeroport>(HttpStatus.NO_CONTENT);

		} else {

			aeroportService.deleteAeroport(aeroport);

			return new ResponseEntity<Aeroport>(aeroport, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/updateAeroport/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Aeroport> updateCity(@PathVariable Long id, @RequestBody Aeroport aeroport) {

		Aeroport a = aeroportService.getAeroportById(id);

		if (a == null) {
			return new ResponseEntity<Aeroport>(HttpStatus.NO_CONTENT);

		} else {
			System.out.println(id + " " + aeroport);
			System.out.println(aeroport.getNom());
			aeroportService.updateAeroport(aeroport);

			System.out.println(aeroportService.getAeroportById(id).getNom());
			return new ResponseEntity<Aeroport>(aeroport, HttpStatus.OK);
		}
	}

}
