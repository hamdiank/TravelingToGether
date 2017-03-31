package tn.cynapsys.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.cynapsys.entities.Role;

public interface RoleRepository extends JpaRepository <Role, Long> {

}
