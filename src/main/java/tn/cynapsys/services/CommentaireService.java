package tn.cynapsys.services;

import java.util.List;

import tn.cynapsys.entities.Annonce;
import tn.cynapsys.entities.Commentaire;

public interface CommentaireService {

	
	
	List<Commentaire> getAll();


	List<Commentaire> getCommentaireByAnnonce(Annonce a);

	Commentaire getCommenataireById(Long id);

	Commentaire saveCommentaire(Commentaire c);
	void deleteCommentaire(Commentaire c);
	Commentaire UpdateAvis(Commentaire c);
	
}
