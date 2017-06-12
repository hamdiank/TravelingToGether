package tn.cynapsys.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cynapsys.entities.Annonce;
import tn.cynapsys.entities.Commentaire;
import tn.cynapsys.entities.Utilisateur;

public interface CommentaireRepository extends JpaRepository<Commentaire, Long> {

	List<Commentaire> findByAuthor(Utilisateur u);

	List<Commentaire> findByAnnonce(Annonce a);
	Commentaire findById(Long id);
}
