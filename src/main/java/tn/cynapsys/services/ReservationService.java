package tn.cynapsys.services;

import java.util.List;

import tn.cynapsys.entities.Reservation;

public interface ReservationService  {
	
	Reservation demandeReservation(Long idAnnonceCovoi, Long idUtilisateurReservation, Boolean etat);
	
	List<Reservation> getReservationByAnnonceCovoi( Long idAnnonceCovoi);
	
	List<Reservation> getReservationByUtilisateurReservation(Long idUtilisateur);
	
	void deleteReservation(Long idReservation);
	
	Reservation getReservationByUtilisateurReservationAndByAnnonceCovoi(Long idUtilisateur, Long idAnnonceCovoi);
	
	Reservation accepterReservation(Long idReservation, Boolean etat);
	
	Reservation refuserReservation(Long idReservation, Boolean etat);
	
	
	
	List<Reservation> getAllReservation();
	
	Reservation updateReservation(Reservation r, Long id);
	

}
