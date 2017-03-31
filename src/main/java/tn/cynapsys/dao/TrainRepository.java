package tn.cynapsys.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.cynapsys.entities.Train;
import tn.cynapsys.entities.Voiture;

public interface TrainRepository  extends JpaRepository <Train, Long >{
	@Query("select t from Train t where t.type like :x ")
	public Page <Train> chercherTrains(@Param("x")String mc, Pageable pageable);
}
