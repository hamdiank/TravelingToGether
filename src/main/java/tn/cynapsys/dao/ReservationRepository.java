package tn.cynapsys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cynapsys.entities.AnnonceCovoi;
import tn.cynapsys.entities.Reservation;
import tn.cynapsys.entities.Utilisateur;


public interface ReservationRepository extends JpaRepository<Reservation, Long>{
	public List <Reservation> findByAnnonceCovoi(AnnonceCovoi annonceCovoi);
	public List<Reservation> findByUtilisateurReservation(Utilisateur utilisateurReservation);
	

}
