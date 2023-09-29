package com.example.persona.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.persona.model.Country;
import com.example.persona.repository.CountryRepository;



@Service
public class CountryService  {
	
	@Autowired
	private CountryRepository countryRepository;
	
	
	public List<Country> findAll(){
	
		return countryRepository.findAll();
	}

	

}
	