package tn.cynapsys.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import tn.cynapsys.entities.Annonce;
import tn.cynapsys.entities.AnnonceCovoi;
import tn.cynapsys.entities.AnnonceTrain;
import tn.cynapsys.entities.AnnonceVol;

public interface AnnonceService {
	
	public List<Annonce> listAnnonceVol(String typeAnnonce);
	public List<Annonce> listAnnonceTrain(String typeAnnonce);
	
	public List<Annonce> listAnnonce();
	
	public Annonce getAnnonce(Long id);
	
	public Annonce saveAnnonce(Annonce a);
	
	public Annonce update ( Annonce a , Long id);
	
	public void delete(Long id );
	
	///////////////////Annonce Covoiturage ////////////////////////
	Page<AnnonceCovoi> getAllAnnounceByPage(Pageable pageable);

	public Annonce addAnnonceCovoi(String heureDepart, String dateDepart, String paysDepart,
			String villeDepart, String paysArrivee, String villeArrivee, Long nombrePlaces,
			Long cotisation,String cotType, Long id, String Description);
	public List<Annonce> getAnnonces(Long id);
	
	public List<AnnonceCovoi> listAnnonceCovoi();
	
	public List<AnnonceCovoi> maListAnnonceCovoi( Long id);
	
	public AnnonceCovoi updateAnnonceCovoi(String heureDepart, String dateDepart, String paysDepart,
			String villeDepart, String paysArrivee, String villeArrivee, Long nombrePlaces,
			Long cotisation, String description, String cotType, Long id, Long idUtilisateur);
	
	public void deleteAnnonceCovoi(Long id);
	
	public AnnonceCovoi getAnnonceCovoiById(Long id);
	
	public AnnonceVol getAnnonceVolById(Long id);
	
	public AnnonceTrain getAnnonceTrainById(Long id);
	
	
	
}
