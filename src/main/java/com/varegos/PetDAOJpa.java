package com.varegos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.varegos.dto.Pet;

@Repository
public interface PetDAOJpa extends JpaRepository<Pet, Long> {
	
	public List<Pet> findAll();
	public Pet findById(Long id);

}
