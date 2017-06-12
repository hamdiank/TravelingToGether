package tn.cynapsys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cynapsys.dao.CommentaireRepository;
import tn.cynapsys.entities.Annonce;
import tn.cynapsys.entities.Commentaire;

@Service
public class CommentaireServiceImpl implements CommentaireService {

	@Autowired
	CommentaireRepository commentaireRepository;

	@Override
	public List<Commentaire> getAll() {

		return commentaireRepository.findAll();
	}

	@Override
	public List<Commentaire> getCommentaireByAnnonce(Annonce a) {

		return commentaireRepository.findByAnnonce(a);
	}

	@Override
	public Commentaire getCommenataireById(Long id) {

		return commentaireRepository.findById(id);
	}

	@Override
	public Commentaire saveCommentaire(Commentaire c) {

		return commentaireRepository.save(c);
	}

	@Override
	public void deleteCommentaire(Commentaire c) {
		commentaireRepository.delete(c);

	}

	@Override
	public Commentaire UpdateAvis(Commentaire c) {

		return commentaireRepository.saveAndFlush(c);
	}

}
