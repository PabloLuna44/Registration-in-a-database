package com.example.persona.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.persona.model.Country;

public interface CountryRepository extends JpaRepository<Country,Long>{

}
