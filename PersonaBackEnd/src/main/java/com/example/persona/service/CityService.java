package com.example.persona.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.persona.model.City;
import com.example.persona.repository.CityRepository;

@Service
public class CityService{ //Al incluir es para implementar todos los metodos que requeramos y nos crea todos los metodos necesarios de CRUD
    
	@Autowired // Esto es para crear la instacia en el repositorio
	private CityRepository cityRepository;
	private List<City> cityRespuesta;
	
public List<City> findAllByCountryId(int idPais){
		
		cityRespuesta = new ArrayList<>();
		List<City> cities=cityRepository.findAll();
		
		for(int i=0;i<cities.size();i++) {
			if(cities.get(i).getCountry().getId()==idPais)
		
				cityRespuesta.add(cities.get(i));
				
		}
		
		return cityRespuesta;
		
		
	}

	
	
	
}