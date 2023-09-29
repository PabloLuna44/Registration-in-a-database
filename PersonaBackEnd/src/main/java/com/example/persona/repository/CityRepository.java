package com.example.persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.persona.model.City;

public interface CityRepository  extends JpaRepository<City,Long>{

}
