package tn.cynapsys.services;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cynapsys.dao.AnnonceVolRepository;
import tn.cynapsys.dao.UtilisateurRepository;
import tn.cynapsys.entities.AnnonceVol;
import tn.cynapsys.entities.Utilisateur;

@Service
@Transactional
public class AnnonceVolServiceImpl implements AnnonceVolService{
	
	@Autowired
	AnnonceVolRepository annonceVolRepository;
	
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@PersistenceContext
	private EntityManager em;
	

	@Override
	public List<AnnonceVol> listAnnonceVol() {	
		return annonceVolRepository.findAll();
	}

	@Override
	public List<AnnonceVol> maListeAnnonceVol(Long id) {
		Query req= em.createQuery("select a from AnnonceVol a where a.utilisateur.id= :x ");
		req.setParameter("x", id);
		return req.getResultList();
	}

	@Override
	public AnnonceVol ajouterAnnonceVol(AnnonceVol a, Long id) {
		Utilisateur utilisateur= utilisateurRepository.findOne(id);
		a.setUtilisateur(utilisateur);
		return annonceVolRepository.save(a);
	}

	@Override
	public AnnonceVol updateAnnonceVol(AnnonceVol a, Long id) {
		
		Utilisateur utilisateur= utilisateurRepository.findOne(id);
		a.setUtilisateur(utilisateur);
		return annonceVolRepository.saveAndFlush(a);
	}

	@Override
	public void deleteAnnonceVol(Long id) {
		annonceVolRepository.delete(id);
		
	}

	@Override
	public AnnonceVol getAnnonceVolById(Long id) {
		return annonceVolRepository.findOne(id);
	}

}
