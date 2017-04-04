package tn.cynapsys.services;


import tn.cynapsys.entities.Utilisateur;

public interface UtilisateurService {
	Utilisateur getUtilisateurByLogin(String login);

	Utilisateur getUtilisateurByMotDePasse(String motDePasse);

	Utilisateur getUtilisateurbyId(Long idUtilisateur);

	//Boolean updateUtilisateur(String username,String password, Profile profile);

	Long addUtilisateur(String username, String password);

	Boolean deleteUtilisateur(Long idUtilisateur);
}
