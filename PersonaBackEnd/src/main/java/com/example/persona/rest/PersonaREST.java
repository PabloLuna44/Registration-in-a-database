package com.example.persona.rest;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.persona.model.Persona;
import com.example.persona.service.PersonaService;

@RestController
@RequestMapping("/personas/")
public class PersonaREST {
	
	@Autowired
	private PersonaService personaService;

	@GetMapping
	private ResponseEntity<List<Persona>> getAllPersonas(){
		return ResponseEntity.ok(personaService.findAll());
	}
	
	@PostMapping//Esto es para que si alguien hace un post a la url obligatoriamente manda una persona
	private ResponseEntity<Persona> savePersona(@RequestBody Persona persona){
		
		try {  //Se utiliza por si algo llega a fallar no se detenga el programa 
			Persona personaguardada =personaService.save(persona);
			return ResponseEntity.created(new URI("/personas/"+personaguardada.getId())).body(personaguardada);
		} catch (Exception e) {
			// TODO: handle exception
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		
	}
	
	@DeleteMapping(value="delete/{id}")
	private ResponseEntity<Boolean> deletePersona(@PathVariable long id){
		
		personaService.deleteById(id);
		return ResponseEntity.ok(!(personaService.findById(id)==null));
	}

	
}
