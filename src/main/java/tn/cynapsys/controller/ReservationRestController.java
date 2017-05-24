package tn.cynapsys.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import tn.cynapsys.dao.AnnonceCovoiRepository;
import tn.cynapsys.dao.ReservationRepository;
import tn.cynapsys.entities.Aeroport;
import tn.cynapsys.entities.Reservation;
import tn.cynapsys.services.ReservationService;

@CrossOrigin(origins="*")
@RestController
public class ReservationRestController {

	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private ReservationRepository reservationRepository;

		
/*	@RequestMapping(value = "/reservation", method=RequestMethod.PUT)
	public Reservation ajout(@RequestParam Long idAnnonceCovoi,@RequestParam Long idUtilisateurReservation, @RequestParam Boolean etat) {
		Reservation reservation= reservationService.getReservationByUtilisateurReservationAndByAnnonceCovoi(idUtilisateurReservation, idAnnonceCovoi);
		if(reservation!=null){
				System.out.println("vous avez déjà faire une reservation");
				return new Reservation();
		}
		else{
			return reservationService.demandeReservation(idAnnonceCovoi, idUtilisateurReservation, etat);
		}
	
	}*/
	
	@RequestMapping(value = "/reservation", method=RequestMethod.PUT)
	public ResponseEntity<Reservation> ajout(@RequestParam Long idAnnonceCovoi,@RequestParam Long idUtilisateurReservation, @RequestParam Boolean etat) {
		Reservation reservation= reservationService.getReservationByUtilisateurReservationAndByAnnonceCovoi(idUtilisateurReservation, idAnnonceCovoi);
		if(reservation!=null){
				System.out.println("vous avez déjà faire une reservation");
				return new ResponseEntity<Reservation>(HttpStatus.NO_CONTENT);
		}
		else{
			reservationService.demandeReservation(idAnnonceCovoi, idUtilisateurReservation, etat);
		return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
					
		}
	
	}
	@RequestMapping(value = "/getReservationsByAnnonceCovoi", method=RequestMethod.GET)
	public List <Reservation> getReservationsByAnnonceCovoi(@RequestParam Long idAnnonceCovoi) {
		return reservationService.getReservationByAnnonceCovoi(idAnnonceCovoi);
	}
	
	@RequestMapping(value = "/getReservationsByUtilisateurReservation", method=RequestMethod.GET)
	public List <Reservation> getReservationsByUtilisateurReservation(@RequestParam Long idUtilisateur) {
		return reservationService.getReservationByUtilisateurReservation(idUtilisateur);
	}
	
	@RequestMapping(value = "/annulerReservation/{idReservation}", method=RequestMethod.DELETE)
	public void annulerReservation(@PathVariable Long idReservation) {
		reservationService.deleteReservation(idReservation);
	}
	

	
		
	
	@RequestMapping(value = "/AllReservations", method = RequestMethod.GET)
	public List<Reservation> listReservations() {
		
		return reservationService.getAllReservation();
		
	}
	
	

}
