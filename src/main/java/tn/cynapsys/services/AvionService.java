package tn.cynapsys.services;

import java.util.List;

import tn.cynapsys.entities.Avion;


public interface AvionService {
	
	public List<Avion> listAvion();
	
	public Avion getAvion(Long id);
	
	public Avion saveAvion(Avion a);
	
	public Avion update ( Avion a );
	
	public void delete(Long id );

}
