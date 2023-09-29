import { Component, OnInit } from '@angular/core';// Agregamos el elemento OnInit
//Vamos a importar los dos elementos para crear el formulario para crea una persona 
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

//Se importan los servicios que creamos 

import { CitiesService } from './services/cities/cities.service';
import { CountriesService } from './services/countries/countries.service';
import { PersonaService } from './services/persona/persona.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

//En esta parte se implementa Oninit
export class AppComponent implements OnInit {

  //Se declaran las siguientes variables
  personaForm: FormGroup;
  countries: any;
  cities: any;
  personas: any;


  //Se agrega el constructor 
  constructor(
    public fb: FormBuilder,

    //Se declaran lo servicios en el constructor 
    public citiesService: CitiesService,
    public countriesService: CountriesService,
    public personaService: PersonaService,


  ) {


  }

  ngOnInit(): void {

    //En esta parte inicaliza,ps personaForm

    this.personaForm = this.fb.group({
      //Aqui vamos a escribir todos los elementos del formulario 
      id: [''],
      name: ['', Validators.required],//Validators se utuiliza dependiendo del campo que se va a utilizar 
      lastNames: ['', Validators.required],
      age: ['', Validators.required],
      country: ['', Validators.required],
      city: ['', Validators.required]
    });;

    this.countriesService.getAllCountries().subscribe(resp => {

      this.countries = resp;

    },
      error => { console.error(error) }
    );

    this.personaService.getAllPersonas().subscribe(resp => {

      this.personas = resp;

    },
      error => { console.error(error) }

    );



    this.personaForm.get('country')?.valueChanges.subscribe(value => {
      this.citiesService.getAllByCountry(value.id).subscribe(resp => {

        this.cities = resp
      },

        error => { console.error(error) }
      );
    })


  }

  guardar(): void {
   
    this.personaService.savePersona(this.personaForm.value).subscribe(resp => {
      this.personaForm.reset();
      this.personaForm.setErrors(null);
      this.personas=this.personas.filter((persona) => resp.id!==persona.id);
      this.personas.push(resp);//Para mostar el dato en la tabla
    },
      error => { console.error(error) }

    )
  };

  delete(persona){
    
    this.personaService.deletePersona(persona.id).subscribe(resp => {
    
      if (resp) {
        // Encuentra el índice de la persona en el array personas
        const index = this.personas.findIndex(p => p.id === persona.id);
        
        // Si se encontró la persona, elimínala del array
        if (index !== -1) {
          this.personas.splice(index, 1);
        }
      }
      
    },
      error => { console.error(error) }

    )
  };

  modify(persona) {
    this.personaForm.setValue({
      id: persona.id,
      name: persona.name,
      lastNames: persona.lastNames,
      age: persona.age,
      country: persona.country,
      city: persona.city,

    })
  }


}

