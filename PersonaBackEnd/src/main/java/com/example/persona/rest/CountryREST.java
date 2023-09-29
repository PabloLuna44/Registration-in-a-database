package com.example.persona.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.persona.model.Country;
import com.example.persona.service.CountryService;

@RestController //
@RequestMapping("/country/")
public class CountryREST {

	@Autowired
	private CountryService countryService;
	
	
	@GetMapping
	private ResponseEntity<List<Country>> getAllCountries(){
		
		return ResponseEntity.ok(countryService.findAll());//Findall ya esta definido y va a funcionar correctamente
		
	}
}
