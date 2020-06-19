package com.carpooling.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carpooling.model.ERole;
import com.carpooling.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByName(ERole name);
}	
