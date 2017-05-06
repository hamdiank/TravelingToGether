package tn.cynapsys.services;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.cynapsys.dao.AnnonceCovoiRepository;
import tn.cynapsys.dao.AnnonceRepository;
import tn.cynapsys.dao.UtilisateurRepository;
import tn.cynapsys.entities.Annonce;
import tn.cynapsys.entities.AnnonceCovoi;
import tn.cynapsys.entities.Utilisateur;

@Service
@Transactional
public class AnnonceServiceImpl implements AnnonceService{
	@Autowired
	public AnnonceRepository annonceRepository;
	
	@Autowired
	public UtilisateurRepository utilisateurRepository;
	
	@Autowired
	public AnnonceCovoiRepository annonceCovoiRepository;
	
	@PersistenceContext
	private EntityManager em;


	@Override
	public List<Annonce> listAnnonceVol(String typeAnnonce) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List <Annonce> listAnnonceTrain(String typeAnnonce) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Annonce> listAnnonce() {
		
		return annonceRepository.findAll();
	}

	@Override
	public Annonce getAnnonce(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Annonce saveAnnonce(Annonce a) {
		return annonceRepository.save(a);
	}

	@Override
	public Annonce update(Annonce a, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
	}

	/*@Override
	public Annonce addAnnonceCovoi(String, Long id) {

		Utilisateur util= em.find(Utilisateur.class, id);
		a.setUtilisateur(util);
		em.persist(a);
		return a;
	}*/

	@Override
	public List<Annonce> getAnnonces(Long id) {
		Query req= em.createQuery("select a from AnnonceCovoi a where a.utilisateur.id= :x ");
		req.setParameter("x", id);
		return req.getResultList();
	}

	@Override
	public Annonce addAnnonceCovoi(String datePublication, String dateDepart, String adresseDepart,
			String adresseArrivee, Long nombrePlaces, Long cotisation, Long id) {
		AnnonceCovoi annonceCovoi= new AnnonceCovoi();
		annonceCovoi.setAdresseDepart(adresseDepart);
		annonceCovoi.setAdresseArrivee(adresseArrivee);
		annonceCovoi.setCotisation(cotisation);
		annonceCovoi.setDateDepart(dateDepart);
		annonceCovoi.setDatePublication(datePublication);
		annonceCovoi.setNombrePlaces(nombrePlaces);
		
		Utilisateur utilisateur= utilisateurRepository.findOne(id);
		
		annonceCovoi.setUtilisateur(utilisateur);
		
		return annonceRepository.save(annonceCovoi);
		

	}

	@Override
	public List<AnnonceCovoi> listAnnonceCovoi() {
		
		return annonceCovoiRepository.findAll();
	}

	@Override
	public List<AnnonceCovoi> maListAnnonceCovoi(Long id) {
		Query req= em.createQuery("select a from AnnonceCovoi a where a.utilisateur.id= :x ");
		req.setParameter("x", id);
		return req.getResultList();
	}

	@Override
	public AnnonceCovoi updateAnnonceCovoi(String datePublication, String dateDepart, String adresseDepart,
			String adresseArrivee, Long nombrePlaces, Long cotisation, Long id, Long idUtilisateur) {
		AnnonceCovoi annonceCovoi= annonceCovoiRepository.findOne(id);
		annonceCovoi.setAdresseDepart(adresseDepart);
		annonceCovoi.setAdresseArrivee(adresseArrivee);
		annonceCovoi.setCotisation(cotisation);
		annonceCovoi.setDateDepart(dateDepart);
		annonceCovoi.setDatePublication(datePublication);
		annonceCovoi.setNombrePlaces(nombrePlaces);
		Utilisateur utilisateur= utilisateurRepository.findOne(idUtilisateur);
		annonceCovoi.setUtilisateur(utilisateur);
		return annonceCovoiRepository.saveAndFlush(annonceCovoi);
	}

	@Override
	public void deleteAnnonceCovoi(Long id) {
		annonceCovoiRepository.delete(id);
		
	}


	

}
