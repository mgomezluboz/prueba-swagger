package com.varegos;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import com.varegos.dto.Pet;

public class PetProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		
		Pet pet = (Pet)exchange.getIn().getBody();
		pet.setStatus(Pet.StatusEnum.AVAILABLE);
		
		exchange.getOut().setBody(pet);
		
	}

}
