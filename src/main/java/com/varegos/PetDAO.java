package com.varegos;

import java.util.List;

import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.varegos.dto.Pet;
import com.varegos.exceptions.NotFoundException;

@Repository
@Transactional
public class PetDAO {
	
	@Autowired
	private PetDAOJpa repo;
	
	public void insertPet(@Body Pet pet) {
		repo.save(pet);
	}
	
	public List<Pet> getAllPets() {
		return repo.findAll();
	}
	
	public Pet getPetByID(Exchange exchange) throws NotFoundException {
		Long id = Long.valueOf((String)exchange.getIn().getHeader("petId"));

		return repo.findById(id);
	}
	
//	@Autowired
//	private SessionFactory sessionFactory;
//	
//	public void insertPet(@Body Pet pet) {
//		Session session = sessionFactory.getCurrentSession();
//		
//		session.save(pet);
//	}
//	
//	public List<Pet> getAllPets() {
//		Session session = sessionFactory.getCurrentSession();
//		CriteriaQuery<Pet> criteria = session.getCriteriaBuilder().createQuery(Pet.class);
//		Root<Pet> variableRoot = criteria.from(Pet.class);
//		criteria.select(variableRoot);
//		
//		return session.createQuery(criteria).getResultList();
//	}
//	
//	public Pet getPetByID(Exchange exchange) throws NotFoundException {
//		Long o = Long.valueOf((String)exchange.getIn().getHeader("petId"));
//		Session session = sessionFactory.getCurrentSession();
//		
//		Pet result = session.get(Pet.class, o);
//		
//		if (result == null) {
//			exchange.setProperty("targetStatus", 404);
//			throw new NotFoundException("Resource not found");
//		}
//
//		return result;
//	}

}
