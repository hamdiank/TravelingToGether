package tn.cynapsys;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.cynapsys.dao.AvionRepository;
import tn.cynapsys.dao.PaysRepository;
import tn.cynapsys.dao.VoitureRepository;
import tn.cynapsys.entities.Aeroport;
import tn.cynapsys.entities.City;
import tn.cynapsys.entities.Pays;
import tn.cynapsys.entities.Station;
import tn.cynapsys.entities.Voiture;

@SpringBootApplication
public class TravelingToGetherApplication implements CommandLineRunner {
	@Autowired
	private VoitureRepository voitureRepository;
	private AvionRepository avionRepository;
	@Autowired
	private PaysRepository paysRepository;
	public static void main(String[] args) {

		SpringApplication.run(TravelingToGetherApplication.class, args);

	}
	@Override
	public void run(String... arg0) throws Exception {
		List<City>c=new ArrayList<City>();
		List<Aeroport>a=new ArrayList<Aeroport>();
		List<Station>s=new ArrayList<Station>();
		c.add(new City("ttCity"));
		a.add(new Aeroport("ttaero"));
		s.add(new Station("ttstation"));
		s.add(new Station("ttstation2"));
		s.add(new Station("ttstation3"));
		
		paysRepository.save(new Pays("tt",c,a,s));
		voitureRepository.save(new Voiture("BMW", "Serie 5", 5, "Essence"));
		voitureRepository.save(new Voiture("BMW", "Serie 4", 4, "Diesel"));
		voitureRepository.save(new Voiture("Peugeot", "207", 5, "Essence"));
		voitureRepository.save(new Voiture("Kia", "rio", 5, "Essence"));
		System.out.println("aaaaaaaaa");
		List<Voiture> voitures= voitureRepository.findAll();
		voitures.forEach(v->System.out.println(v.getModele()));
	
	}
	}



