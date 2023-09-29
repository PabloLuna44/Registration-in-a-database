import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CitiesService {

  
  
  private API_SERVER="http://localhost:8080/city/";

  constructor(
    private httpClient:HttpClient
  ) { }
  

  public getAllByCountry(idCountry:any): Observable<any> {
    return this.httpClient.get(this.API_SERVER+idCountry);
  }

}
