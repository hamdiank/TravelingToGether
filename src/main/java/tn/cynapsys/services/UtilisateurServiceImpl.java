package tn.cynapsys.services;


import java.util.List;
import java.util.prefs.Preferences;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.cynapsys.dao.RoleRepository;
import tn.cynapsys.dao.UtilisateurRepository;
import tn.cynapsys.entities.Role;
import tn.cynapsys.entities.Utilisateur;
import tn.cynapsys.entities.Voiture;

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {
	@Autowired
	UtilisateurRepository utilisateurRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	

	@Override
	public Utilisateur getUtilisateurByLogin(String login) {

		return utilisateurRepository.findOneByLogin(login);

	}

	@Override
	public Utilisateur getUtilisateurByMotDePasse(String motDePasse) {

		return utilisateurRepository.findUtilisateurByMotDePasse(motDePasse);

	}

	@Override
	public Utilisateur getUtilisateurbyId(Long idUtilisateur) {

		return utilisateurRepository.findUtilisateurByIdUtilisateur(idUtilisateur);
	}

	/*
	 * @Override public Long addUtilisateur(String username, String password) {
	 * // TODO Auto-generated method stub return null; }
	 */

	/*
	 * @Override public Boolean deleteUtilisateur(Long idUtilisateur) { // TODO
	 * Auto-generated method stub return null; }
	 */

	@Override
	public Utilisateur registerUtilisateur(String nom, String prenom, String login, String motDePasse) {
		Utilisateur utilisateur = new Utilisateur();
		utilisateur.setNom(nom);
		utilisateur.setPrenom(prenom);
		utilisateur.setLogin(login);
		utilisateur.setMotDePasse(motDePasse);
		Long idRole= Long.parseLong("2");
		Role role= roleRepository.findOne(idRole);
		System.out.println(role);
		utilisateur.setRole(role);

		return utilisateurRepository.saveAndFlush(utilisateur);
	}

	@Override
	public List<Utilisateur> listUtilisateur() {

		return utilisateurRepository.getAll();
	}

	@Override
	public Utilisateur getUtilisateur(Long id) {
		return utilisateurRepository.findOne(id);
	}

	@Override
	public Utilisateur saveUtilisateur(Utilisateur u) {
		Long idRole= Long.parseLong("2");
		Role role= roleRepository.findOne(idRole);
		System.out.println(role);
		u.setRole(role);
		Voiture voiture= new Voiture();
		voiture.setVoitureAvatar("imageVoiture.png");
		u.setVoiture(voiture);
		u.setAvatarSrc("téléchargement.png");
		tn.cynapsys.entities.Preferences preferences= new tn.cynapsys.entities.Preferences();
		u.setPreferences(preferences);
		return utilisateurRepository.save(u);
	}

	@Override
	public Utilisateur update(Utilisateur u) {

		return utilisateurRepository.saveAndFlush(u);
	}

	@Override
	public void delete(Long id) {
		utilisateurRepository.delete(id);

	}

	@Override
	public Long countOfUsers() {

		return utilisateurRepository.count();
	}

	@Override
	public Role getUserRole(Long id) {

		return utilisateurRepository.findOne(id).getRole();
	}

	@Override
	public Utilisateur getUtilisateurbyEmail(String email) {

		return utilisateurRepository.findUtilisateurByEmail(email);
	}


	@Override
	public void confirmerInscription(String email) {
		Utilisateur utilisateur= utilisateurRepository.findUtilisateurByEmail(email);
		utilisateur.setEtat(true);
	}


}
