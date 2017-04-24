package tn.cynapsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.cynapsys.entities.Aeroport;

@RepositoryRestResource
public interface AeroportRepository extends JpaRepository<Aeroport, Long> {

}