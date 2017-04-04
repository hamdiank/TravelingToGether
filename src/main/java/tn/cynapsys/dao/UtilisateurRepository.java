package tn.cynapsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import tn.cynapsys.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
@Query("SELECT u FROM Utilisateur u WHERE u.login = ?1")
	Utilisateur findOneByLogin(String login);
Utilisateur findUtilisateurByIdUtilisateur(Long id);
Utilisateur findUtilisateurByMotDePasse(String motDePasse);


}
