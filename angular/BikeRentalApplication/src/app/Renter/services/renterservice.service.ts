import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bikes } from '../model/Bikes';
@Injectable({
  providedIn: 'root'
})
export class RenterserviceService {
 baseUrl:string="http://localhost:8080/bike"

constructor( private http:HttpClient) { }


getBikeById(id: number): Observable<any> {

  return this.http.get(`${this.baseUrl}/${id}`);
}

addBike(data: any): Observable<Object> {
  return this.http.post(`${this.baseUrl}`, data);
}

updateBike(id: number, value: any): Observable<Object> {
  return this.http.put(`${this.baseUrl}/${id}`, value);
}

deleteBike(id: number): Observable<any> {
  return this.http.delete(`${this.baseUrl}/${id}`);
}

getBike(): Observable<any> {
  return this.http.get(`${this.baseUrl}`);
}

}
