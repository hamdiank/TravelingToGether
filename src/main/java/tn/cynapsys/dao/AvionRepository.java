package tn.cynapsys.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import tn.cynapsys.entities.Avion;


@RepositoryRestResource
public interface AvionRepository extends JpaRepository<Avion, Long>{
	@Query("select a from Avion a where a.type like :x ")
	public Page <Avion> chercherAvions(@Param("x")String mc, Pageable pageable);
}
