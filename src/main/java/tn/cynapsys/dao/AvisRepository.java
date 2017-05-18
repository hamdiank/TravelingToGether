package tn.cynapsys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cynapsys.entities.Avis;
import tn.cynapsys.entities.Utilisateur;

public interface AvisRepository extends JpaRepository<Avis, Long> {

	List<Avis> findByIdDest(Long id);

	List<Avis> findByAuthor(Utilisateur U);

}
