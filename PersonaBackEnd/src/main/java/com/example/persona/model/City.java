package com.example.persona.model;


import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Table(name="city")
@Entity
public class City implements Serializable{
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	@ManyToOne
	@JoinColumn(name="id_pais")
	private Country country;
	private String name;
	

}
	
	