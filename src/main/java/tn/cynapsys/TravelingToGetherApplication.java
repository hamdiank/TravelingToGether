package tn.cynapsys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.cynapsys.dao.AnnonceRepository;
import tn.cynapsys.dao.AvionRepository;
import tn.cynapsys.dao.MessageRepository;
import tn.cynapsys.dao.PaysRepository;
import tn.cynapsys.dao.RoleRepository;
import tn.cynapsys.dao.UtilisateurRepository;
import tn.cynapsys.dao.VoitureRepository;
import tn.cynapsys.entities.Message;
import tn.cynapsys.entities.Role;
import tn.cynapsys.entities.Utilisateur;
import tn.cynapsys.services.UtilisateurService;

@SpringBootApplication
public class TravelingToGetherApplication implements CommandLineRunner {
	@Autowired
	private VoitureRepository voitureRepository;

	@Autowired
	private AvionRepository avionRepository;
	@Autowired
	private UtilisateurRepository util;
	@Autowired
	private UtilisateurService Utilisateurservice;
	@Autowired
	private PaysRepository paysRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private AnnonceRepository annonceRepository;

	@Autowired
	private UtilisateurRepository utilisateurRepository;
	@Autowired
	private MessageRepository messageRepository;
	

	public static void main(String[] args) {

		SpringApplication.run(TravelingToGetherApplication.class, args);

	}

	@Override
	public void run(String... arg0) throws Exception {
	
		Utilisateur u = utilisateurRepository.findOne(Long.valueOf(2 + ""));
		System.out.println(u.getRole().getTypeRole());
	//	Role role = new Role("USER");
		
	//	u.setRole(role);
		
	//	Utilisateurservice.update(u);
		/*
		 * LocalDateTime c=LocalDateTime.now(); System.out.println(c);
		 * LocalDateTime a=LocalDateTime.now();
		 */
		
		Message message = new Message(Long.valueOf(2 + ""), u, "first message");

		messageRepository.save(message);

		/*
		 * List<City>c=new ArrayList<City>(); List<Aeroport>ae=new
		 * ArrayList<Aeroport>(); List<Station>s=new ArrayList<Station>();
		 * c.add(new City("ttCity")); ae.add(new Aeroport("ttaero")); s.add(new
		 * Station("ttstation")); s.add(new Station("ttstation2")); s.add(new
		 * Station("ttstation3"));
		 * 
		 * paysRepository.save(new Pays("tt",c,ae,s));
		 * voitureRepository.save(new Voiture("BMW", "Serie 5", 5, "Essence"));
		 * voitureRepository.save(new Voiture("BMW", "Serie 4", 4, "Diesel"));
		 * voitureRepository.save(new Voiture("Peugeot", "207", 5, "Essence"));
		 * voitureRepository.save(new Voiture("Kia", "rio", 5, "Essence"));
		 * System.out.println("aaaaaaaaa"); List<Voiture> voitures=
		 * voitureRepository.findAll();
		 * voitures.forEach(v->System.out.println(v.getModele()));
		 * 
		 * avionRepository.save(new Avion("Quatar Airlines"));
		 * avionRepository.save(new Avion("France Airlines")); List<Avion>
		 * avions= avionRepository.findAll();
		 * avions.forEach(a->System.out.println(a.getType())); Long number=
		 * utilisateurRepository.count();
		 * 
		 * System.out.println(String.valueOf(number));
		 * 
		 * 
		 */

	}
}
