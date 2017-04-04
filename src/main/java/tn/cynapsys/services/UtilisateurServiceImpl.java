package tn.cynapsys.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import tn.cynapsys.dao.UtilisateurRepository;
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

	

	@Override
	public Long addUtilisateur(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteUtilisateur(Long idUtilisateur) {
		// TODO Auto-generated method stub
		return null;
	}

}
