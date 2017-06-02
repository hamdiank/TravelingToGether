package tn.cynapsys.services;

import java.util.List;

import tn.cynapsys.entities.AnnonceCovoi;
import tn.cynapsys.entities.AnnonceVol;



public interface AnnonceVolService {
	
	public List<AnnonceVol> listAnnonceVol();
	
	public List<AnnonceVol> maListeAnnonceVol( Long id);
	
	public AnnonceVol ajouterAnnonceVol(AnnonceVol a, Long id);
	
	public AnnonceVol updateAnnonceVol(AnnonceVol a, Long id);

	public void deleteAnnonceVol(Long id);
	
	public AnnonceVol getAnnonceVolById(Long id);
}
