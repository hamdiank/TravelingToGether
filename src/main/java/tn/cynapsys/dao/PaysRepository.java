package tn.cynapsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.cynapsys.entities.Pays;

@RepositoryRestResource
public interface PaysRepository extends JpaRepository<Pays, Long>{
	@Query("SELECT pays FROM Pays pays WHERE pays.nom =:nom")
	public Pays findOneByName(@Param("nom")String nom);	
	
	
	
}
