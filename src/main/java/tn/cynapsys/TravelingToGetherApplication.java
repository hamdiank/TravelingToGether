package tn.cynapsys;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.cynapsys.dao.AnnonceRepository;
import tn.cynapsys.dao.AvionRepository;
import tn.cynapsys.dao.PaysRepository;
import tn.cynapsys.dao.UtilisateurRepository;
import tn.cynapsys.dao.VoitureRepository;
import tn.cynapsys.entities.Aeroport;
import tn.cynapsys.entities.Avion;
import tn.cynapsys.entities.City;
import tn.cynapsys.entities.Pays;
import tn.cynapsys.entities.Station;
import tn.cynapsys.entities.Voiture;

@SpringBootApplication
public class TravelingToGetherApplication implements CommandLineRunner {
	@Autowired
	private VoitureRepository voitureRepository;
	
	@Autowired
	private AvionRepository avionRepository;

	@Autowired
	private PaysRepository paysRepository;

	
	@Autowired
	private AnnonceRepository annonceRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	

	
	
	

	public static void main(String[] args) {

		SpringApplication.run(TravelingToGetherApplication.class, args);

	}
	@Override
	public void run(String... arg0) throws Exception {
		/*List<City>c=new ArrayList<City>();
		List<Aeroport>ae=new ArrayList<Aeroport>();
		List<Station>s=new ArrayList<Station>();
		c.add(new City("ttCity"));
		ae.add(new Aeroport("ttaero"));
		s.add(new Station("ttstation"));
		s.add(new Station("ttstation2"));
		s.add(new Station("ttstation3"));*/
		
		/*paysRepository.save(new Pays("tt",c,ae,s));*/
		voitureRepository.save(new Voiture("BMW", "Serie 5", 5, "Essence"));
		voitureRepository.save(new Voiture("BMW", "Serie 4", 4, "Diesel"));
		voitureRepository.save(new Voiture("Peugeot", "207", 5, "Essence"));
		voitureRepository.save(new Voiture("Kia", "rio", 5, "Essence"));
		System.out.println("aaaaaaaaa");
		List<Voiture> voitures= voitureRepository.findAll();
		voitures.forEach(v->System.out.println(v.getModele()));
		
		avionRepository.save(new Avion("Quatar Airlines"));
		avionRepository.save(new Avion("France Airlines"));	
		List<Avion> avions= avionRepository.findAll();
		avions.forEach(a->System.out.println(a.getType()));
		Long number= utilisateurRepository.count();
		
		System.out.println(String.valueOf(number));

		
		
		
		
	}
	}



