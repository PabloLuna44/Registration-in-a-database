import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class PersonaService {

  private API_SERVER="http://localhost:8080/personas/"//url de la connecion de la base de datos

  constructor(
    private httpClient:HttpClient,
  ) { }
  

  public getAllPersonas(): Observable<any>{
    return this.httpClient.get(this.API_SERVER);
  }

  public savePersona(persona):Observable<any>{

    try {
      return this.httpClient.post(this.API_SERVER,persona);
    } catch (error) {
      console.error(error);
    }
    return  this.httpClient.post(this.API_SERVER,persona);
  }

  public deletePersona(id):Observable<any>{
    return this.httpClient.delete(this.API_SERVER+"delete/"+id)
  }
  

}
