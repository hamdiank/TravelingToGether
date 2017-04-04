package tn.cynapsys.services;


import java.util.List;



import tn.cynapsys.entities.Voiture;

public interface VoitureService {

	public List<Voiture> listVoiture();
	
	public Voiture getVoiture(Long id);
	
	public Voiture saveVoiture(Voiture v);
	
	public Voiture update( Voiture v , Long id);
	
	public void delete( Long id );


}
