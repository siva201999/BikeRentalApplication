package com.example.bikerental.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.bikerental.model.BikeModel;
import com.example.bikerental.model.Booking;
import com.example.bikerental.model.Comments;
import com.example.bikerental.model.CustomerModel;
import com.example.bikerental.model.Payment;
import com.example.bikerental.service.CustomerService;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CustomerController {
    @Autowired  
	CustomerService customerService;  
 
	@GetMapping("/customer")  
	//getAllCustomers
	public ResponseEntity<List<BikeModel>> getCustomerBike()   
	{  
		return customerService.getCustomerBike();  
	} 
    // deleteCustomer
	@DeleteMapping("/customer/{id}")  
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") long id)   
	{  
		return customerService.delete(id);  
	}  
      
    //update customer
	@PutMapping("/customer/{id}")  
	public ResponseEntity<?> update(@PathVariable("id")long id, @RequestBody CustomerModel customer)   
	{   
		return customerService.update(id, customer); 
	}
    
    @GetMapping("/customer/{id}")
    public ResponseEntity<?> getCustomerById(@PathVariable("id")long id){
        return customerService.getCustomerById(id);
    }

	//payment validation
	@PostMapping("/payment")
	public ResponseEntity<Payment> validatePayment(@RequestBody Payment paymentModel){
		
		return customerService.validatePayment(paymentModel);
		
	}

	@PostMapping("/booking/{id}")
	public ResponseEntity<?> saveBookingHistory(@PathVariable("id")long id,@RequestBody Booking booking){
		return customerService.saveBookingHistory(id,booking);
	}

}
