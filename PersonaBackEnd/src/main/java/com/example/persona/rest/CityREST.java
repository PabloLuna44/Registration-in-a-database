package com.example.persona.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.persona.model.City;
import com.example.persona.service.CityService;

@RestController //
@RequestMapping("/city/") //Este es para darnos las url mapping para acceder a este servicio
public class CityREST{
	
	@Autowired
	private CityService cityService;
	@GetMapping("{id}")//recibe el parametro id y se usa en el path
	private ResponseEntity<List<City>> getAllCitiesByCountry(@PathVariable("id") int idPais){
		
		return ResponseEntity.ok(cityService.findAllByCountryId(idPais));
	}
	
	

}
