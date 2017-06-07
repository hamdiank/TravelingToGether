package tn.cynapsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cynapsys.entities.AnnonceCovoi;
import tn.cynapsys.entities.Utilisateur;

public interface AnnonceCovoiRepository extends JpaRepository<AnnonceCovoi, Long>{
 //public AnnonceCovoi findByUtilisateur(Utilisateur utilisateur);
}
