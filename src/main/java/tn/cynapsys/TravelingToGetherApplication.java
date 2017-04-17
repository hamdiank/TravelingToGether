package tn.cynapsys;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.cynapsys.dao.AnnonceRepository;
import tn.cynapsys.dao.AvionRepository;
import tn.cynapsys.dao.UtilisateurRepository;
import tn.cynapsys.dao.VoitureRepository;
import tn.cynapsys.entities.Annonce;
import tn.cynapsys.entities.AnnonceCovoi;
import tn.cynapsys.entities.Avion;
import tn.cynapsys.entities.Utilisateur;
import tn.cynapsys.entities.Voiture;

@SpringBootApplication
public class TravelingToGetherApplication implements CommandLineRunner {
	@Autowired
	private VoitureRepository voitureRepository;
	
	@Autowired
	private AvionRepository avionRepository;
	
	@Autowired
	private AnnonceRepository annonceRepository;
	
	@Autowired
	private UtilisateurRepository utilisateurRepository;
	

	
	
	
	public static void main(String[] args) {

		SpringApplication.run(TravelingToGetherApplication.class, args);

	}
	@Override
	public void run(String... arg0) throws Exception {
		
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
		

		
		
		
		
	}
	}



