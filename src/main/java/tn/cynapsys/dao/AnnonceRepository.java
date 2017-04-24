package tn.cynapsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cynapsys.entities.Annonce;

public interface AnnonceRepository extends JpaRepository<Annonce, Long> {

}
