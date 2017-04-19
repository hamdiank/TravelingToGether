package tn.cynapsys.services;

import java.util.Date;
import java.util.List;

import tn.cynapsys.entities.Annonce;
import tn.cynapsys.entities.AnnonceCovoi;
import tn.cynapsys.entities.Utilisateur;

public interface AnnonceService {
	
	public List<Annonce> listAnnonceVol(String typeAnnonce);
	public List<Annonce> listAnnonceTrain(String typeAnnonce);
	
	public List<Annonce> listAnnonce();
	
	public Annonce getAnnonce(Long id);
	
	public Annonce saveAnnonce(Annonce a);
	
	public Annonce update ( Annonce a , Long id);
	
	public void delete(Long id );
	
	public Annonce addAnnonceCovoi(Date datePublication, Date dateDepart, String adresseDepart,
			String adresseArrivee,Long nombrePlaces, Long cotisation, Long id);
	public List<Annonce> getAnnonces(Long id);
	
	public List<AnnonceCovoi> listAnnonceCovoi();

}
