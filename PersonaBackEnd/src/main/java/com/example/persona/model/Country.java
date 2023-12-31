package com.example.persona.model;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="country")
public class Country implements Serializable {
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO) 
	private long id;
	private String name;
	
}