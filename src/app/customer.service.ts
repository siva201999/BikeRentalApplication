import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Customer } from './customer';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class CustomerService {
  baseURL="http://localhost:8090/customer";
  getCustomerByRenterId: any;
  constructor(private httpClient: HttpClient) { }

 update(renterId:number ,customer: Customer):Observable<Object>
 {
  console.log(customer);
  return this.httpClient.put(`${this.baseURL}/${renterId}`,customer);
 }

 getBikeById(id: number): Observable<any> {

  return this.httpClient.get(`${this.baseURL}/${id}`);
}
//  getCurrentData(){
//   return 
//  }

}
//  return this.http.put('${this.baseUrl}/${custid}',customer);
