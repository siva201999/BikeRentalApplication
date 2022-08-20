import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';
import { Config } from './config';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  

  private baseUrl= "http://localhost:8081";
  constructor(private httpClient: HttpClient) { }

  isAdminLogin(adminUser:Config["Login"]):Observable<object> {
    console.log(adminUser);
    return this.httpClient.post(`${this.baseUrl}/admin/login`, adminUser); 
  }

  isRenterLogin(renterUser:Config["Login"]):Observable<object> {
    console.log(renterUser);
    return this.httpClient.post(`${this.baseUrl}/renter/login`, renterUser); 
  }

  isCustomerLogin(customerUser:Config["Login"]):Observable<object> {
    console.log(customerUser);
    return this.httpClient.post(`${this.baseUrl}/customer/login`, customerUser);
  }

  renterSingnup(renterRegistration:Config["Signup"]):Observable<object> {
    console.log(renterRegistration);
    return this.httpClient.post(`${this.baseUrl}/renter/signup`, renterRegistration);
  }

  customerSignup(customerRegistration:Config["Signup"]):Observable<object> {
    console.log(customerRegistration);
    return this.httpClient.post(`${this.baseUrl}/customer/signup`, customerRegistration)
  }


}
