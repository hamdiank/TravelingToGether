package tn.cynapsys.services;

import java.util.List;

import tn.cynapsys.entities.Annonce;
import tn.cynapsys.entities.AnnonceCovoi;

public interface AnnonceService {
	
	public List<Annonce> listAnnonceVol(String typeAnnonce);
	public List<Annonce> listAnnonceTrain(String typeAnnonce);
	
	public List<Annonce> listAnnonce();
	
	public Annonce getAnnonce(Long id);
	
	public Annonce saveAnnonce(Annonce a);
	
	public Annonce update ( Annonce a , Long id);
	
	public void delete(Long id );
	
	public Annonce addAnnonceCovoi(String datePublication, String dateDepart, String adresseDepart,
			String adresseArrivee,Long nombrePlaces, Long cotisation, Long id);
	public List<Annonce> getAnnonces(Long id);
	
	public List<AnnonceCovoi> listAnnonceCovoi();
	
	public List<AnnonceCovoi> maListAnnonceCovoi( Long id);
	
	public AnnonceCovoi updateAnnonceCovoi( String datePublication, String dateDepart, String adresseDepart,
			String adresseArrivee, Long nombrePlaces, Long cotisation, Long id, Long idUtilisateur);
	
	public void deleteAnnonceCovoi(Long id);
	
}
