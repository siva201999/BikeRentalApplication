import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Bikes } from './bikes';
@Injectable({
  providedIn: 'root'
})
export class RenterserviceService {
 baseUrl:string="http://localhost:8090/bike"

constructor( private httpClient:HttpClient) { }


getBikeById(id: number): Observable<any> {
  return this.httpClient.get(`${this.baseUrl}/${id}`);
}

// addBike(data: any): Observable<Object> {
//   return this.http.post(`${this.baseUrl}`, data);
// }

// updateBike(id: number, value: any): Observable<Object> {
//   return this.http.put(`${this.baseUrl}/${id}`, value);
// }

// deleteBike(id: number): Observable<any> {
//   return this.http.delete(`${this.baseUrl}/${id}`);
// }

getBike(): Observable<Bikes[]> {
  console.log(Bikes)
  return this.httpClient.get<Bikes[]>(this.baseUrl);
}

}