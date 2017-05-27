package tn.cynapsys.controller;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonFactory;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.dao.PaysRepository;
import tn.cynapsys.entities.Aeroport;
import tn.cynapsys.entities.City;
import tn.cynapsys.entities.Pays;
import tn.cynapsys.entities.Station;
import tn.cynapsys.services.PaysService;

@RestController
@RequestMapping(value = "/admin/pays")
public class PaysRestController {

	@Autowired
	private PaysRepository paysRepository;
	@Autowired
	private PaysService paysService;

	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Pays> pays() {

		return paysService.getAll();
	}

	@RequestMapping(value = "/pays/{id}", method = RequestMethod.GET)
	public ResponseEntity<Pays> paysById(@PathVariable Long id) {
		Pays pays = paysService.getPaysById(id);
		if (pays == null) {
			return new ResponseEntity<Pays>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Pays>(pays, HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/paysByCity/{nom}", method = RequestMethod.GET)
	public ResponseEntity<Pays> paysByCity(@PathVariable String nom) {
		System.out.println(nom);
		Pays pays = paysService.GetByCities(nom);
		if (pays == null) {
			System.out.println("enter1");
			return new ResponseEntity<Pays>(HttpStatus.NO_CONTENT);
		} else {
			System.out.println("enter2");
			return new ResponseEntity<Pays>(pays, HttpStatus.OK);
		}
	}
	

	@RequestMapping(value = "/pays", method = RequestMethod.GET)
	public ResponseEntity<Pays> paysByName(@Param(value = "nom") String nom) {
		Pays pays = paysRepository.findOneByName(nom);
		if (pays == null) {
			return new ResponseEntity<Pays>(HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<Pays>(pays, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/addPays/{nom}", method = RequestMethod.POST)
	public ResponseEntity<Pays> createPays(@PathVariable String nom) {
		System.out.println("nommmm :"+nom);
		Pays pays = new Pays(nom, null,null,null);
		if (paysRepository.findOneByName(pays.getNom()) != null) {
			throw new RuntimeException("pays already exist");
		}

		return new ResponseEntity<Pays>(paysRepository.save(pays), HttpStatus.CREATED);

	}
	@RequestMapping(value = "/renomerPays/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Pays> renomerPays(@PathVariable Long id,@RequestBody Pays pays) {
		Pays p= paysRepository.findOne(id);
		if (p == null) {
			return new ResponseEntity<Pays>(HttpStatus.NO_CONTENT);
		} else {
			System.out.println(pays.getNom());
			System.out.println(pays.getIdPays());
			System.out.println(id);
			paysService.updatePays(pays);
			System.out.println(paysRepository.findOne(id).getNom());
			return new ResponseEntity<Pays>(pays, HttpStatus.OK);
		}	}

	@RequestMapping(value = "/delPays/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Pays> deletePays(@PathVariable Long id) {
	
	
		Pays pays = paysRepository.findOne(id);
		
			if (pays == null) {
			return new ResponseEntity<Pays>(HttpStatus.NO_CONTENT);
		
		} else {
			
			paysRepository.delete(pays);
			
			return new ResponseEntity<Pays>(pays, HttpStatus.OK);
		}
	}
	@RequestMapping(value = "/updatePays/{id}/{v}/{a}/{s}", method = RequestMethod.PUT)
	public ResponseEntity<Pays> updatePays(@PathVariable Long id,@PathVariable String v,@PathVariable String a,@PathVariable String s) {
		
		Pays p = paysRepository.findOne(id);
		
		if (p == null) {
		return new ResponseEntity<Pays>(HttpStatus.NO_CONTENT);
	
	} else {
		if(v!=null||!v.equals("undefined"))
		p.getCities().add(new City(v));
		if(a!=null||!a.equals("undefined"))
		p.getAeroports().add(new Aeroport(a));
		if(s!=null||!s.equals("undefined"))
		p.getStations().add(new Station(s));
		
		System.out.println(a+" "+v+" "+s);
		//pays.getCities().forEach(v->System.out.println("idddd: "+v.getIdCity()));
	/*	System.out.println(id+" "+pays);
	System.out.println(pays.getNom());
	*/
		paysService.updatePays(p);
	
			
		// System.out.println(paysRepository.findOne(id).getNom());
			return new ResponseEntity<Pays>( HttpStatus.OK);
		}
	}
	
	@RequestMapping(value = "/city/{id}", method = RequestMethod.GET)
	public List<City> cityByPaysId(@PathVariable Long id) {
	
	
		Pays pays = paysRepository.findOne(id);
		
		//	if (pays == null) {
		//	ret
		
		//} else {
			//
		
			return pays.getCities();
		
	}
	

	//  Pour charger le table pays et city
	@RequestMapping(value = "/initial", method = RequestMethod.POST)
	public List<Pays> initialize() throws JsonParseException, IOException {

		//JSONParser parser = new JSONParser();
		JsonFactory f = new JsonFactory();
		JsonParser jp = f.createJsonParser(new File(
				"C:/Users/BESEM/Downloads/countriesToCities.json"));

		JsonToken current;
		
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
				List<City> city = new ArrayList<City>();
				while (jp.nextToken() != JsonToken.END_ARRAY) {
					// read the record into a tree model,
					// this moves the parsing position to the end of it
					System.out.println("  : " + jp.getText());
					city.add(new City(jp.getText()));
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
