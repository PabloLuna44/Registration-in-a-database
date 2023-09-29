package com.example.persona.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.persona.model.Persona;
import com.example.persona.repository.PersonaRepository;

@Service
public class PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	
	public List<Persona> findAll() {
		// TODO Auto-generated method stub
		return personaRepository.findAll();
	}

	public <S extends Persona> S save(S entity) {
		// TODO Auto-generated method stub
		return personaRepository.save(entity);
	}

	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		personaRepository.deleteById(id);
	}
	public Optional<Persona> findById(Long id) {
		// TODO Auto-generated method stub
		return personaRepository.findById(id);
	}



	
}