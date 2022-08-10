import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Config } from 'src/app/config';

@Injectable({
  providedIn: 'root'
})
export class ServicesService {

  private baseUrl="http://localhost:8081";
  constructor(private httpClient: HttpClient) { }

  getAllCustomers():Observable<any>{
    return this.httpClient.get<Config["CustomerObj"][]>(`${this.baseUrl}/customers`);
  } 

  getAllRenters():Observable<any>{
    return this.httpClient.get<Config["RenterObj"][]>(`${this.baseUrl}/renters`);
  }

  getRenterBikes(id:any):Observable<any>{
    
    return this.httpClient.get<Config["BikeObj"][]>(`${this.baseUrl}/renters/${id}`);
  }

}
