import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { ListResponseModel } from './listresponsemodel';
import { ResponseModel } from './responsemodel';
import { Rental } from './rental';

@Injectable({
   providedIn: 'root'
})

export class RentalService {
  getBikeById(id: number): Observable<ListResponseModel<Rental>>{
    //let newPath = this.baseURL + 'get-rental-by-BikeId?carId=' + bikeId;
      return this.httpClient.get<ListResponseModel<Rental>>(this.baseURL);
  }

  baseURL="http://localhost:8090/rentals";
   rentingBike!: Rental;

   constructor(private httpClient: HttpClient) {
      this.getRentals();
   }

   getRentals(): Observable<ListResponseModel<Rental>> {
      return this.httpClient.get<ListResponseModel<Rental>>(this.baseURL);
   }

   getRentalsByBikeId(bikeId: number): Observable<ListResponseModel<Rental>> {
      let newPath = this.baseURL + 'get-rental-by-BikeId?carId=' + bikeId;
      return this.httpClient.get<ListResponseModel<Rental>>(newPath);
   }

   setRentingBike(rental: Rental) {
      this.rentingBike = rental;
   }

   getRentingBike() {
      return this.rentingBike;
   }

 

   add(rental: Rental): Observable<ResponseModel> {
      return this.httpClient.post<ResponseModel>(this.baseURL, rental);
   }
}