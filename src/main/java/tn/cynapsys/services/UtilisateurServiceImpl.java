package tn.cynapsys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.cynapsys.dao.UtilisateurRepository;
import tn.cynapsys.entities.Role;
import tn.cynapsys.entities.Utilisateur;

@Service
@Transactional
public class UtilisateurServiceImpl implements UtilisateurService {
	@Autowired
	UtilisateurRepository utilisateurRepository;

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

		return utilisateurRepository.saveAndFlush(utilisateur);
	}

	@Override
	public List<Utilisateur> listUtilisateur() {
		// TODO Auto-generated method stub
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur getUtilisateur(Long id) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findOne(id);
	}

	@Override
	public Utilisateur saveUtilisateur(Utilisateur u) {
		// TODO Auto-generated method stub
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

	

}
