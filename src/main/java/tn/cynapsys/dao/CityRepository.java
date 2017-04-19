package tn.cynapsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.cynapsys.entities.City;
@RepositoryRestResource
public interface CityRepository extends JpaRepository<City, Long>{
	
		
		
		
		
	}