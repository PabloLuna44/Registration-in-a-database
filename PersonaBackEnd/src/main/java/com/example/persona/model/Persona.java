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
@Entity
@Table(name="Persona") //Para crear la tabla llamada persona 
public class Persona implements Serializable{

     
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) //Se utiliza para auto incrementar el id concecutivamente 
	private long id;
	private String name;
	private String lastNames;
	private int age;
	
	
	@ManyToOne //Es usado para hacer las relacion en este caso es de N:1
	@JoinColumn(name="id_pais")//Se utiliza para usar el identificador e la otra tabla este va ser nuestra foreign key 
	private Country country;
	@ManyToOne
	@JoinColumn(name="id_estado")
	private City city;
	
		
}