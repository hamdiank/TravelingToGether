package tn.cynapsys.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cynapsys.dao.AnnonceTrainRepository;
import tn.cynapsys.dao.UtilisateurRepository;
import tn.cynapsys.entities.AnnonceTrain;
import tn.cynapsys.entities.Utilisateur;

@Service
@Transactional
public class AnnonceTrainServiceImpl implements AnnonceTrainService {
	
	@Autowired
	AnnonceTrainRepository annonceTrainRepository;
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<AnnonceTrain> listAnnonceTrain() {
		return annonceTrainRepository.findAll();
	}

	@Override
	public List<AnnonceTrain> maListeAnnonceTrain(Long id) {
		Query req= em.createQuery("select a from AnnonceTrain a where a.utilisateur.id= :x ");
		req.setParameter("x", id);
		return req.getResultList();
	}

	@Override
	public AnnonceTrain ajouterAnnonceTrain(AnnonceTrain a, Long id) {
		Utilisateur utilisateur= utilisateurRepository.findOne(id);
		a.setUtilisateur(utilisateur);
		return annonceTrainRepository.save(a);
	}

	@Override
	public AnnonceTrain updateAnnonceTrain(AnnonceTrain a, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAnnonceTrain(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public AnnonceTrain getAnnonceTrainById(Long id) {
		return annonceTrainRepository.findOne(id);
	}

}
