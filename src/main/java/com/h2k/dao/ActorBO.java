package com.h2k.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class holds internal business logic
 * @author Rishi
 *
 */

@Service
public class ActorBO {

	@Autowired
	ActorDAO actorDAO;
	

	public ActorDTO getActorById(int actorId) {
		System.out.println("Business logic to be added in ActorBO");
		ActorDTO dto = actorDAO.getActor(actorId);
		if(dto == null) {
			dto = new ActorDTO();
		}
		return dto;
	}	
}
