package tn.cynapsys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cynapsys.dao.AnnonceCovoiRepository;
import tn.cynapsys.dao.ReservationRepository;
import tn.cynapsys.dao.UtilisateurRepository;
import tn.cynapsys.entities.AnnonceCovoi;
import tn.cynapsys.entities.Reservation;
import tn.cynapsys.entities.Utilisateur;
@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	ReservationRepository reservationRepository;
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	AnnonceCovoiRepository annonceCovoiRepository;
	
	
	
	

	@Override
	public Reservation demandeReservation(Long idAnnonceCovoi, Long idUtilisateurReservation, Boolean etat) {
		
		Reservation reservation= new Reservation();
		AnnonceCovoi annonceCovoi= annonceCovoiRepository.findOne(idAnnonceCovoi);
		Utilisateur utilisateurReservation= utilisateurRepository.findOne(idUtilisateurReservation);
		System.out.println(annonceCovoi.getUtilisateur().getIdUtilisateur());
		reservation.setAnnonceCovoi(annonceCovoi);
		reservation.setEtat(etat);
		reservation.setUtilisateurReservation(utilisateurReservation);
		return reservationRepository.save(reservation);
	}

	@Override
	public List<Reservation> getAllReservation() {
		
		return reservationRepository.findAll();
	}



	@Override
	public Reservation updateReservation( Reservation r,Long id) {
		r.setIdReservation(id);
		return reservationRepository.saveAndFlush(r);
	}

	@Override
	public List<Reservation> getReservationByAnnonceCovoi(Long idAnnonceCovoi) {
		AnnonceCovoi annonceCovoi= annonceCovoiRepository.findOne(idAnnonceCovoi);
		return annonceCovoi.getReservations();
	}

	@Override
	public List <Reservation> getReservationByUtilisateurReservation(Long idUtilisateur) {
		Utilisateur utilisateurReservation= utilisateurRepository.findOne(idUtilisateur);
		return utilisateurReservation.getReservations();
	}
	

}
