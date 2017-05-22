package tn.cynapsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.dao.AnnonceCovoiRepository;
import tn.cynapsys.entities.Reservation;
import tn.cynapsys.services.ReservationService;

@CrossOrigin(origins="*")
@RestController
public class ReservationRestController {

	@Autowired
	private ReservationService reservationService;

	@RequestMapping(value = "/reservation", method=RequestMethod.PUT)
	public Reservation ajout(@RequestParam Long idAnnonceCovoi,@RequestParam Long idUtilisateurReservation, @RequestParam Boolean etat) {
		
		return reservationService.demandeReservation(idAnnonceCovoi, idUtilisateurReservation, etat);
	}
	@RequestMapping(value = "/getReservationsByAnnonceCovoi", method=RequestMethod.GET)
	public List <Reservation> getReservationsByAnnonceCovoi(@RequestParam Long idAnnonceCovoi) {
		return reservationService.getReservationByAnnonceCovoi(idAnnonceCovoi);
	}
	@RequestMapping(value = "/AllReservations", method = RequestMethod.GET)
	public List<Reservation> listReservations() {
		
		return reservationService.getAllReservation();
		
	}

}
