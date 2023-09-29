import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CountriesService {

  private API_SERVER="http://localhost:8080/country/"//url de la connecion de la base de datos

  constructor(
    private httpClient:HttpClient,
  ) { }
  

  public getAllCountries(){
    return this.httpClient.get(this.API_SERVER)
  }


}
