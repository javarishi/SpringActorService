package com.h2k.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActorController {
	
	@Autowired
	private ActorBO actorBO;
	
	
	@GetMapping("/actor/{id}")
	public ResponseEntity<ActorDTO> getActors(@PathVariable("id") Integer id) {
		ActorDTO actor = actorBO.getActorById(id);
		HttpStatus status = null;
		if(actor != null) {
			status = HttpStatus.OK;
		}else {
			actor = new ActorDTO();
			status = HttpStatus.NOT_FOUND;
		}
	
		return new ResponseEntity<ActorDTO>(actor, status);
	}

}
