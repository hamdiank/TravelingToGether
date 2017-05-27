package tn.cynapsys.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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
	
	@PersistenceContext
	private EntityManager em;
	
	
	
	

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

	@Override
	public Reservation getReservationByUtilisateurReservationAndByAnnonceCovoi(Long idUtilisateur,
			Long idAnnonceCovoi) {
		try{
			Query req= em.createQuery("select r from Reservation r where r.utilisateurReservation.id= :x and r.annonceCovoi.id= :y");
			req.setParameter("x", idUtilisateur);
			req.setParameter("y", idAnnonceCovoi);
			return (Reservation) req.getSingleResult();
			
		}catch (NoResultException e) {
			return null;
		}

		
	

	}

	@Override
	public void deleteReservation(Long idReservation) {
		reservationRepository.delete(idReservation);
		
	}

	@Override
	public Reservation accepterReservation(Long idReservation, Boolean etat) {
		Reservation reservation= reservationRepository.findOne(idReservation);
		AnnonceCovoi annonceCovoi=reservation.getAnnonceCovoi();
		Long nombrePlaces= annonceCovoi.getNombrePlaces();
		nombrePlaces--;
		System.out.println(nombrePlaces);
		annonceCovoi.setNombrePlaces(nombrePlaces);
		reservation.setEtat(etat);
		return reservationRepository.saveAndFlush(reservation);
	}

	@Override
	public Reservation refuserReservation(Long idReservation, Boolean etat) {
		Reservation reservation= reservationRepository.findOne(idReservation);
		AnnonceCovoi annonceCovoi=reservation.getAnnonceCovoi();
		Long nombrePlaces= annonceCovoi.getNombrePlaces();
		nombrePlaces++;
		System.out.println(nombrePlaces);
		annonceCovoi.setNombrePlaces(nombrePlaces);
		reservation.setEtat(etat);
		return reservationRepository.saveAndFlush(reservation);
	}
	

}
