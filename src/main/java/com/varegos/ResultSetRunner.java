package com.varegos;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import javax.transaction.Transactional;

import com.varegos.dto.Order;
import com.varegos.dto.Persona;
import com.varegos.dto.PersonaOrder;

@Transactional
public class ResultSetRunner {

	@PersistenceContext
	public EntityManager entityManager;
	
	@SuppressWarnings("rawtypes")
	public List<PersonaOrder> getSeveralResultSets() {
		List<PersonaOrder> result = new ArrayList<PersonaOrder>();
		
		StoredProcedureQuery spq = entityManager.createStoredProcedureQuery("getSeveralResultSets");
		List resultSet1 = spq.getResultList();
		List resultSet2;
//		if (spq.hasMoreResults())
//		{
		    resultSet2 = spq.getResultList(); // get the second result set
//		}
		
		for (Object rs1 : resultSet1) {
			Persona persona = (Persona)rs1;
			Order order = (Order)resultSet2.get(0);
			result.add(new PersonaOrder(persona.getDni(), order.getSize(), order.getAmount(), persona.getApellido()));
		}
		
		return result;
	}

}
