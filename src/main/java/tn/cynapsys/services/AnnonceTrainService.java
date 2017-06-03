package tn.cynapsys.services;

import java.util.List;

import tn.cynapsys.entities.AnnonceTrain;

public interface AnnonceTrainService {
	public List<AnnonceTrain> listAnnonceTrain();
	
	public List<AnnonceTrain> maListeAnnonceTrain( Long id);
	
	public AnnonceTrain ajouterAnnonceTrain(AnnonceTrain a, Long id);
	
	public AnnonceTrain updateAnnonceTrain(AnnonceTrain a, Long id);

	public void deleteAnnonceTrain(Long id);
	
	public AnnonceTrain getAnnonceTrainById(Long id);
}
