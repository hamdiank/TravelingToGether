package tn.cynapsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cynapsys.entities.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{

}
