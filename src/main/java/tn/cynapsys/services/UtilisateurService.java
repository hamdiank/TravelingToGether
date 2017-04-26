package tn.cynapsys.services;


import java.util.List;

import tn.cynapsys.entities.Role;
import tn.cynapsys.entities.Utilisateur;

public interface UtilisateurService {
	Utilisateur getUtilisateurByLogin(String login);

	Utilisateur getUtilisateurByMotDePasse(String motDePasse);

	Utilisateur getUtilisateurbyId(Long idUtilisateur);

	//Boolean updateUtilisateur(String username,String password, Profile profile);

	//Long addUtilisateur(String username, String password);

	//Boolean deleteUtilisateur(Long idUtilisateur);
	
	public Utilisateur registerUtilisateur(String nom, String prenom, String login, String motDePasse );
	
	public List<Utilisateur> listUtilisateur();
	
	public Utilisateur getUtilisateur(Long id);
	
	public Utilisateur saveUtilisateur(Utilisateur u);
	
	public Utilisateur update( Utilisateur u , Long id);
	
	public void delete( Long id );
	public Role getUserRole(Long id);
	public Long countOfUsers();
}
