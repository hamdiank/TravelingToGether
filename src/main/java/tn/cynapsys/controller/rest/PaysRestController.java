package tn.cynapsys.controller.rest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.dao.PaysRepository;
import tn.cynapsys.entities.Pays;

@RestController
@RequestMapping(value = "/admin/pays")
public class PaysRestController {

	@Autowired
	private PaysRepository paysRepository;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Pays> pays() {

		return paysRepository.findAll();
	}

	@RequestMapping(value = "/one/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pays> paysById(@PathVariable Long id) {
		Pays pays = paysRepository.findOne(id);
		if (pays == null) {
			return new ResponseEntity<Pays>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Pays>(pays, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/one", method = RequestMethod.GET)
	public ResponseEntity<Pays> paysByName(@Param(value = "nom") String nom) {
		Pays pays = paysRepository.findOneByName(nom);
		if (pays == null) {
			return new ResponseEntity<Pays>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Pays>(pays, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/addPays", method = RequestMethod.POST)
	public ResponseEntity<Pays> createPays(@Param(value = "nom") String nom,
			@RequestParam("cities") List<String> cities,@RequestParam("aeroport") List<String> aeroport,@RequestParam("station") List<String> station) {
		Pays pays = new Pays(nom, cities,aeroport,station);
		if (paysRepository.findOneByName(pays.getNom()) != null) {
			throw new RuntimeException("pays already exist");
		}

		return new ResponseEntity<Pays>(paysRepository.save(pays), HttpStatus.CREATED);

	}

	@RequestMapping(value = "/delPays/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Pays> deleteUser(@PathVariable Long id) {
		Pays pays = paysRepository.findOne(id);
			if (pays == null) {
			return new ResponseEntity<Pays>(HttpStatus.NO_CONTENT);
		
		} else {
			paysRepository.delete(pays);
			return new ResponseEntity<Pays>(pays, HttpStatus.OK);
		}
	}
	
	
	//  Pour charger le table pays et city
	@RequestMapping(value = "/initial", method = RequestMethod.POST)
	public List<Pays> initialize() throws JsonParseException, IOException {

		//JSONParser parser = new JSONParser();
		JsonFactory f = new JsonFactory();
		JsonParser jp = f.createJsonParser(new File(
				"C:/Users/hamdi/Downloads/Compressed/CountriesToCitiesJSON-master/CountriesToCitiesJSON-master/countriesToCities.json"));

		JsonToken current;
		List<String> city = new ArrayList<String>();
		current = jp.nextToken();
		if (current != JsonToken.START_OBJECT) {
			System.out.println("Error: root should be object: quiting.");

		}
		// int i = 0;
		while (jp.nextToken() != JsonToken.END_OBJECT) {
			Pays p=new Pays();
			String fieldName = jp.getCurrentName();
			// move from field name to field value
			current = jp.nextToken();
			// i++;
			if (current == JsonToken.START_ARRAY) {
				System.out.println("avant le while : "+jp.getCurrentName());
				// For each of the records in the array
				while (jp.nextToken() != JsonToken.END_ARRAY) {
					// read the record into a tree model,
					// this moves the parsing position to the end of it
					System.out.println("  : " + jp.getText());
					city.add(jp.getText());
				}
				System.out.println("after the while");
				p.setNom(fieldName);
				p.setCities(city);
				paysRepository.save(p);
			} else {
				System.out.println("Error: records should be an array: skipping.");
				jp.skipChildren();
			}
			//System.out.println(fieldName);
			
			
		}
		// System.out.println(i);
		return null;

	}

}
